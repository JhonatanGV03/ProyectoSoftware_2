package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.model.classes.*;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositories.*;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServices {

    private final PacienteRepository pacienteRepo;
    private final CuentaRepository cuentaRepo;
    private final CitaRepository citaRepo;
    private final MedicoRepository medicoRepo;
    private final PQRSRepository pqrsRepo;
    private final MensajeRepository mensajeRepo;


    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception {
        if (estaRepetidaCedula(pacienteDTO.cedula())) {
            throw new Exception("La cédula " + pacienteDTO.cedula() + " ya está en uso");
        }
        if( estaRepetidoCorreo(pacienteDTO.correo()) ){
            throw new Exception("El correo "+pacienteDTO.correo()+" ya está en uso");
        }

        Paciente paciente = new Paciente();

        //Datos de la cuenta
        paciente.setCorreo(pacienteDTO.correo());
        paciente.setPassword(pacienteDTO.password());
        //Datos del usuario
        paciente.setCedula(pacienteDTO.cedula());
        paciente.setNombre(pacienteDTO.nombre());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setCiudad(pacienteDTO.ciudad());
        paciente.setUrlFoto(pacienteDTO.urlFoto());
        //Datos del paciente
        paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        paciente.setAlergias(pacienteDTO.alergias());
        paciente.setEPS(pacienteDTO.eps());
        paciente.setTipoSangre(pacienteDTO.tipoSangre());

        //Parte de encriptado
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( pacienteDTO.password() );
        paciente.setPassword( passwordEncriptada );

        Paciente pacienteNuevo = pacienteRepo.save(paciente);

        return pacienteNuevo.getCodigo();
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception {
        Optional<Paciente> pacienteBuscado =pacienteRepo.findById(codigoPaciente);

        if( pacienteBuscado.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+codigoPaciente);
        }

        Paciente buscado = pacienteBuscado.get();

        return new DetallePacienteDTO(
                buscado.getCodigo(),
                buscado.getCedula(),
                buscado.getCorreo(),
                buscado.getNombre(),
                buscado.getTelefono(),
                buscado.getCiudad(),
                buscado.getFechaNacimiento(),
                buscado.getAlergias(),
                buscado.getEPS(),
                buscado.getTipoSangre(),
                buscado.getUrlFoto()
        );
    }

    @Override
    public int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception {
        Optional<Paciente> pacienteBuscado =pacienteRepo.findById(pacienteDTO.codigo());

        if( pacienteBuscado.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+pacienteDTO.codigo());
        }

        Paciente buscado = pacienteBuscado.get();

            if (estaRepetidaCedula(pacienteDTO.cedula()) && !(buscado.getCedula().equals(pacienteDTO.cedula()))) {
                throw new Exception("La cédula " + pacienteDTO.cedula() + " ya está en uso");
            }
            if( estaRepetidoCorreo(pacienteDTO.correo()) && !(buscado.getCorreo().equals(pacienteDTO.correo()))){
                throw new Exception("El correo "+pacienteDTO.correo()+" ya está en uso");
            }

        //Datos de la cuenta
        buscado.setCorreo(pacienteDTO.correo());
        //Datos del usuario
        buscado.setCedula(pacienteDTO.cedula());
        buscado.setNombre(pacienteDTO.nombre());
        buscado.setTelefono(pacienteDTO.telefono());
        buscado.setCiudad(pacienteDTO.ciudad());
        buscado.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        buscado.setUrlFoto(pacienteDTO.urlFoto());
        //Datos del paciente
        buscado.setAlergias(pacienteDTO.alergias());
        buscado.setEPS(pacienteDTO.eps());
        buscado.setTipoSangre(pacienteDTO.tipoSangre());


        //Parte de encriptado
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String passwordEncriptada = passwordEncoder.encode( pacienteDTO.password() );
        //buscado.setPassword( passwordEncriptada );

        pacienteRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigoPaciente) throws Exception {
        Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigoPaciente);

        if( pacienteBuscado.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+codigoPaciente);
        }

        Paciente buscado = pacienteBuscado.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);
        pacienteRepo.save( buscado );
    }

    @Override
    public void cambiarPassword(NewPasswordDTO newPasswordDTO) throws Exception {
        Optional<Cuenta> opcionalCuenta = cuentaRepo.findByCorreo(newPasswordDTO.correo());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(opcionalCuenta.isEmpty()) {
            throw new Exception("No existe una cuenta con el correo " + newPasswordDTO.correo());
        }

        Cuenta cuenta = opcionalCuenta.get();
        if (newPasswordDTO.newPassword().equals(newPasswordDTO.confirmPassword())){
            cuenta.setPassword(passwordEncoder.encode(newPasswordDTO.newPassword()));
            cuentaRepo.save(cuenta);
        }else{
            throw new Exception("Las contraseñas no coinciden");
        }
    }

    @Override
    public List<ItemPacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepo.findAll();
        List<ItemPacienteDTO> repuesta = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            repuesta.add( new ItemPacienteDTO(
                    paciente.getCodigo(),
                    paciente.getCedula(),
                    paciente.getNombre(),
                    paciente.getCiudad()
            ) );
        }
        return repuesta;
    }

    @Override
    public int crearPQRS(PQRSPacienteDTO PQRSPacienteDTO) throws Exception {

        Cita cita = citaRepo.findById(PQRSPacienteDTO.codigoCita()).orElseThrow( () -> new Exception("No existe la cita") );

        PQRS pqrs = new PQRS();
        pqrs.setFechaCreacion(LocalDateTime.now());
        pqrs.setTipoPQRS(PQRSPacienteDTO.tipoPQRS());
        pqrs.setMotivo(PQRSPacienteDTO.mensaje());
        pqrs.setEstado(EstadoPQRS.NUEVO);
        pqrs.setCita(cita);

        PQRS pqrsCreada = pqrsRepo.save(pqrs);
        return pqrsCreada.getCodigo();
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {

        if (pacienteRepo.findById(codigoPaciente).isEmpty()){
            throw new Exception("No existe un paciente con el código "+codigoPaciente);
        }
        if (pqrsRepo.findAll().isEmpty()){
            throw new Exception("No existen PQRS");
        }
        List<PQRS> listaPqrs = pqrsRepo.obtenerPqrs(codigoPaciente);
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
    public DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigo);
        }

        PQRS buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByCodigo(codigo);

        return new DetallesPQRSDTO(
                buscado.getCodigo(),
                buscado.getFechaCreacion(),
                buscado.getEstado(),
                buscado.getCita().getFechaCita(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),
                buscado.getMotivo(),
                convertirRespuestasDTO(mensajes)

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
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        List<Cita> citasPaciente = citaRepo.findAllByPaciente_Codigo(registroCitaDTO.codigoPaciente());
        Optional<Medico> medico = medicoRepo.findById(registroCitaDTO.codigoMedico());
        Optional<Paciente> paciente = pacienteRepo.findById(registroCitaDTO.codigoPaciente());

        int cantidadCitasAct = 0;
        for(int i = 0; i <= citasPaciente.size(); i++ ){
            if(citasPaciente.get(i).getEstado() == EstadoCita.PROGRAMADA){
                cantidadCitasAct++;
            }
        }

        if(cantidadCitasAct >= 3){
            throw new Exception("El paciente ya tiene 3 citas programadas en este momento");
        }
        if (medico.isEmpty()){
            throw new Exception("No existe un médico con el codigo "+registroCitaDTO.codigoMedico());
        }
        if (paciente.isEmpty()){
            throw new Exception("No existe un paciente con el código "+registroCitaDTO.codigoPaciente());
        }

        if (citasPaciente != null){
            for (Cita cita : citasPaciente) {
                if (cita.getFechaCita().equals(registroCitaDTO.fecha())){
                    throw new Exception("Ya existe una cita para el paciente " + paciente.get().getNombre() + " en la fecha " + registroCitaDTO.fecha());
                }
                //EL IDE dice que da error - Tener en cuenta
                if (cita.getMedico().equals(medico.get())){
                    throw new Exception("Ya existe una cita con el médico " + registroCitaDTO.codigoMedico() + " en la fecha " + cita.getFechaCita());
                }
            }
        }
        Cita cita = new Cita();

        cita.setFechaCreacion(LocalDateTime.now());
        cita.setFechaCita(registroCitaDTO.fecha());
        cita.setHoraCita(registroCitaDTO.hora());
        cita.setMotivo(registroCitaDTO.motivoConsulta());
        cita.setEstado(EstadoCita.PROGRAMADA);
        cita.setPaciente(paciente.get());
        cita.setMedico(medico.get());

        Cita citaCreada = citaRepo.save(cita);

        /* //Esto es para enviar el correo pero google nos beto
         emailServices.enviarCorreo(new EmailDTO(
         "Agendamiento de cita\n\n " +
         "Informacion de su cita medica:\n " +
         "Paciente: "+citaCreada.getPaciente().getNombre()+"\n " +
         "Fecha de creación: "+LocalDateTime.now()+"\n " +
         "Fecha de cita: "+citaCreada.getFechaCita()+"\n " +
         "Hora de cita: "+citaCreada.getHoraCita()+"\n " +
         "Motivo de la cita: "+citaCreada.getMotivo()+"\n " +
         "Estado de la cita: "+citaCreada.getEstado()+"\n " +
         "Medico: "+citaCreada.getMedico().getNombre()+"\n " +
         "Especialidad: "+citaCreada.getMedico().getEspecialidad()+"\n\n " +
         "CLINICA AURORA - SU SALUD ES NUESTRA PRIORIDAD",
         citaCreada.getPaciente().getCorreo(),
         "CLINICA AURORA - Recordatorio agendamiento de cita",
         "Clinica Aurora"

         ));
         */


        return citaCreada.getCodigoCita();
    }
    public DetallesCitaDTO verDetallesCita(int codigo) throws Exception {
        Optional<Cita> citaEncontrada = citaRepo.findById(codigo);

        if(citaEncontrada.isEmpty()){
            throw new Exception("No existe una cita con el código "+codigo);
        }

        Cita cita = citaEncontrada.get();

        return new DetallesCitaDTO(
                cita.getPaciente().getCodigo(),
                cita.getMedico().getEspecialidad(),
                cita.getMedico().getCodigo(),
                cita.getFechaCita(),
                cita.getHoraCita(),
                cita.getMotivo(),
                cita.getEstado()
        );
    }
    @Override
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        Paciente paciente = pacienteRepo.findById(codigoPaciente).orElseThrow( () -> new Exception("No existe el paciente") );
        List<Cita> citasPaciente = citaRepo.findAllByPaciente(paciente);
        List<ItemCitaDTO> citas = new ArrayList<>();

        if (citasPaciente == null){
            throw new Exception("No existen citas para el paciente con código "+codigoPaciente);
        }

        for (Cita cita : citasPaciente){
            citas.add(new ItemCitaDTO(
                    cita.getCodigoCita(),
                    cita.getFechaCita(),
                    cita.getHoraCita(),
                    cita.getMedico().getEspecialidad(),
                    cita.getMedico().getNombre()
            ));
        }
        return citas;
    }

    @Override
    public DetallesConsultaDTO verDetalleConsulta(int codigo) throws Exception {
        Optional<Cita> citaEncontrada = citaRepo.findById(codigo);

        if(citaEncontrada.isEmpty()){
            throw new Exception("No existe una cita con el código "+codigo);
        }

        Cita cita = citaEncontrada.get();

        return new DetallesConsultaDTO(
                cita.getCodigoCita(),
                cita.getPaciente().getNombre(),
                cita.getFechaCreacion(),
                cita.getFechaCita(),
                cita.getHoraCita(),
                cita.getEstado(),
                cita.getMotivo(),
                cita.getMedico().getNombre(),
                cita.getMedico().getEspecialidad(),
                cita.getConsulta().getNotasMedicas(),
                cita.getConsulta().getDiagnostico(),
                cita.getConsulta().getTratamiento()
        );
    }

    @Override
    public List<ItemCitaDTO> filtrarCitasPacientePorFecha(LocalDate fecha, int codigoPaciente) throws Exception {
        List<Cita> citasFecha = citaRepo.findAllByFechaCitaAndPaciente_Codigo(fecha, codigoPaciente);

        if(citasFecha.isEmpty()){
            throw new Exception("No hay citas por la fecha introducida o el id del paciente es incorrecto");
        }

        List<ItemCitaDTO> citas = new ArrayList<>();

        for(Cita c : citasFecha){
            citas.add(new ItemCitaDTO(
                    c.getCodigoCita(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getEspecialidad(),
                    c.getMedico().getNombre()
            ));
        }

        return citas;
    }

    @Override
    public List<ItemCitaDTO> filtrarCitasPacientePorMedico(int codigoMedico, int codigoPaciente) throws Exception {
        List<Cita> citasMedico = citaRepo.findAllByMedico_CodigoAndPaciente_Codigo(codigoMedico, codigoPaciente);

        if(citasMedico.isEmpty()){
            throw new Exception("No hay citas por el codigoMedico introducido");
        }

        List<ItemCitaDTO> citas = new ArrayList<>();

        for(Cita c : citasMedico){
            citas.add(new ItemCitaDTO(
                    c.getCodigoCita(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getEspecialidad(),
                    c.getMedico().getNombre()
            ));
        }

        return citas;
    }


    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

}
