package Clinica.services.impl;

import Clinica.dto.paciente.DetallePacienteDTO;
import Clinica.dto.paciente.RegistroPacienteDTO;
import Clinica.model.classes.Paciente;
import Clinica.model.enums.EstadoUsuario;
import Clinica.repositorios.PacienteRepo;
import Clinica.services.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class    PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;


    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {

        if(estaRepetidaCedula_Y_Correo(registroPacienteDTO.cedula(), registroPacienteDTO.email())){
            throw new Exception("La cedula o el Correo ya se encuentran en uso");
        }

        Paciente paciente = new Paciente();
        paciente.setCorreo(registroPacienteDTO.email());
        paciente.setPassword(registroPacienteDTO.contrasena());

        paciente.setCedula(registroPacienteDTO.cedula());
        paciente.setNombre(registroPacienteDTO.nombre());
        paciente.setTelefono(registroPacienteDTO.telefono());
        paciente.setUrlFoto(registroPacienteDTO.urlFoto());
        paciente.setCodigoCiudad(registroPacienteDTO.ciudad());
        paciente.setEstadoCuenta(EstadoUsuario.ACTIVO);

        paciente.setFechaNacimiento(registroPacienteDTO.fechaNacimiento());
        paciente.setAlergias(registroPacienteDTO.alergias());
        paciente.setCodigoEPS(registroPacienteDTO.eps());
        paciente.setCodigoTipoSangre(registroPacienteDTO.tipoSangre());


        Paciente pacienteNuevo = pacienteRepo.save(paciente);
        

        return pacienteNuevo.getCodigoCuenta();
    }

    private boolean estaRepetidaCedula_Y_Correo(String cedula, String email) {
        return pacienteRepo.existsByDniAndEmail(cedula, email);
    }

    @Override
    public boolean editarPerfil(int codigoPaciente, DetallePacienteDTO detallePacienteDTO) throws Exception {
        return false;
    }

    @Override
    public boolean eliminarCuenta(int codigoPaciente) throws Exception {
        return false;
    }
}
