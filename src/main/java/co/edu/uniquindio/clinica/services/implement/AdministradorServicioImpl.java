package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;

import co.edu.uniquindio.clinica.model.classes.*;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositories.*;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServices {

    private final MedicoRepository medicoRepo;
    private final PQRSRepository pqrsRepo;
    private final CuentaRepository cuentaRepo;
    private final MensajeRepository mensajeRepo;
    private final CitaRepository citaRepo;
    private final HorarioRepository horarioRepo;
    private final AdministradorRepository administradorRepo;


    @Override
    public void crearAdmin(RegistroAdminDTO admin) throws Exception {

        if( estaRepetidoCorreoAdmin(admin.correo()) ){
            throw new Exception("El correo "+admin.correo()+" ya está en uso");
        }
        Administrador administrador = new Administrador();

        administrador.setCorreo(admin.correo());
        //Parte de encriptado
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( admin.password() );
        administrador.setPassword( passwordEncriptada );


        //administrador.setPassword(admin.password());

        administradorRepo.save(administrador);

    }
    private boolean estaRepetidoCorreoAdmin(String correo) {
        return administradorRepo.findByCorreo(correo) != null;
    }

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if( estaRepetidaCedula(medicoDTO.cedula()) ){
            throw new Exception("La cédula "+medicoDTO.cedula()+" ya está en uso");
        }

        if( estaRepetidoCorreo(medicoDTO.correo()) ){
            throw new Exception("El correo "+medicoDTO.correo()+" ya está en uso");
        }

        Medico medico = new Medico();

        medico.setNombre(medicoDTO.nombre());
        medico.setCedula(medicoDTO.cedula());
        medico.setCiudad(medicoDTO.ciudad());
        medico.setEspecialidad(medicoDTO.especialidad());
        medico.setTelefono(medicoDTO.telefono());
        medico.setCorreo(medicoDTO.correo());
        //codigoMedico.setPassword(medicoDTO.password());
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setEstado(EstadoUsuario.ACTIVO);

        //Parte de encriptado
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( medicoDTO.password() );
        medico.setPassword( passwordEncriptada );

        Medico medicoNuevo = medicoRepo.save(medico);

        asignarHorariosMedico(medicoNuevo, medicoDTO.horarios());

        return medicoNuevo.getCodigo();

    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    private void asignarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios) {

        for( HorarioDTO h : horarios ){

            Horario hm = new Horario();
            hm.setDia( h.dia() );
            hm.setHoraInicio( h.horaInicio() );
            hm.setHoraFin( h.horaFin() );
            hm.setMedico( medicoNuevo );

            horarioRepo.save(hm);

        }

    }


    @Override
    public int actualizarmedico(DetallesMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(medicoDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setNombre(medicoDTO.nombre() );
        buscado.setCedula(medicoDTO.cedula() );
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setEspecialidad( medicoDTO.especialidad() );
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setCorreo(medicoDTO.correo() );
        //buscado.setPassword(medicoDTO.password());
        buscado.setUrlFoto(medicoDTO.urlFoto());

        //Parte de encriptado
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String passwordEncriptada = passwordEncoder.encode( medicoDTO.password() );
        //buscado.setPassword( passwordEncriptada );

        asignarHorariosMedico(buscado,medicoDTO.horarios());

        medicoRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public void eliminarmedico(int codigo) throws Exception {
        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);
        medicoRepo.save( buscado );


    }

    @Override
    public List<ItemMedicoDTO> listarmedicos() throws Exception {
        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay médicos registrados");
        }

        return medicos.stream().map(m -> new ItemMedicoDTO(
                m.getCodigo(),
                m.getCedula(),
                m.getNombre(),
                m.getEstado(),
                m.getEspecialidad()
        ) ).toList();
    }

    @Override
    public DetallesMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }
        List<Horario> horarios = horarioRepo.findAllByMedicoCodigo(codigo);
        List<HorarioDTO> horariosDTO = new ArrayList<>();

        for( Horario h : horarios ){
            horariosDTO.add( new HorarioDTO(
                    h.getDia(),
                    h.getHoraInicio(),
                    h.getHoraFin()
            ) );
        }

        Medico buscado = opcional.get();

        return new DetallesMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getUrlFoto(),
                //buscado.getPassword(),
                horariosDTO
        );
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

        List<PQRS> listaPqrs = pqrsRepo.findAll();

        if(listaPqrs.isEmpty()){
            throw new Exception("No existen PQRS creados");
        }

        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for( PQRS p: listaPqrs ){

            respuesta.add( new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getFechaCreacion(),
                    p.getEstado(),
                    p.getMotivo()
            ) );

        }

        return respuesta;
    }


    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception {
        Optional<PQRS> opcionalPQRS = pqrsRepo.findById(registroRespuesta.codPqrs());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+registroRespuesta.codPqrs());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuesta.codCuenta());

        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe una cuenta con el código "+registroRespuesta.codCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPQRS(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion( LocalDateTime.now() );
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuesta.mensaje());

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public DetallesPQRSAdminDTO verDetallesPQRS(int codigo) throws Exception {

        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigo);
        }

        PQRS buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByCodigo(codigo);

        return new DetallesPQRSAdminDTO(
                buscado.getCodigo(),
                buscado.getEstado(),
                buscado.getFechaCreacion(),
                buscado.getMotivo(),
                convertirRespuestasDTO(mensajes),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getPaciente().getCedula(),
                buscado.getCita().getPaciente().getCorreo(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),
                buscado.getCita().getFechaCita(),
                buscado.getCita().getEstado(),
                buscado.getCita().getMotivo(),
                buscado.getCita().getConsulta().getNotasMedicas(),
                buscado.getCita().getConsulta().getDiagnostico(),
                buscado.getCita().getConsulta().getTratamiento()
        );
    }

    private List<RespuestaDTO> convertirRespuestasDTO(List<Mensaje> mensajes) {
        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
                m.getMensaje(),
                m.getCuenta().getCorreo(),
                m.getFechaCreacion()
        )).toList();
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitas(int codigoMedico) throws Exception {
        Optional<Medico> medico =medicoRepo.findById(codigoMedico);
        List<Cita> citas = citaRepo.findAllByMedico(medico.get());
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            respuesta.add( new ItemCitaAdminDTO(
                    c.getCodigoCita(),
                    c.getEstado(),
                    c.getFechaCreacion(),
                    c.getPaciente().getNombre()
            )  );
        }

        return respuesta;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRSDTO estadoPQRS) throws Exception {

        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un PQRS con el código "+codigoPQRS);
        }

        PQRS pqrs = opcional.get();
        pqrs.setEstado(estadoPQRS.estadoPQRS());

        pqrsRepo.save( pqrs );
    }

}