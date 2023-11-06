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


    //HISTORIA NO 20
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
        paciente.setEstado(EstadoUsuario.ACTIVO);

        Paciente pacienteNuevo = pacienteRepo.save(paciente);

        return pacienteNuevo.getCodigo();
    }

    //PARTE DE LA HISTORIA DE USUARIO NO 5
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

    //HISTORIA NO 5
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

    //HISTORIA NO 21
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

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

    //POR HACER
    @Override
    public List<ItemPacienteDTO> listarPacientes() {
        return null;
    }

    @Override
    public void cambiarPassword(NewPasswordDTO newPasswordDTO) throws Exception {

    }

    @Override
    public int crearPQRS(PQRSPacienteDTO PQRSPacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public DetallesCitaDTO verDetallesCita(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public DetallesConsultaDTO verDetalleConsulta(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> filtrarCitasPacientePorFecha(LocalDate fecha, int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> filtrarCitasPacientePorMedico(int codigoMedico, int codigoPaciente) throws Exception {
        return null;
    }

}
