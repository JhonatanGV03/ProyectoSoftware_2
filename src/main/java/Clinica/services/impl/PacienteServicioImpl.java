package Clinica.services.impl;

import Clinica.dto.paciente.DetallePacienteDTO;
import Clinica.dto.paciente.RegistroPacienteDTO;
import Clinica.model.classes.Paciente;
import Clinica.model.enums.EstadoUsuario;
import Clinica.repositorios.PacienteRepo;
import Clinica.services.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class   PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;


    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {

        if(estaRepetidaCedula(registroPacienteDTO.cedula())){
            throw new Exception("La cedula ya se encuentra en uso");
        }
        if(estaRepetidaCorreo(registroPacienteDTO.email())){
            throw new Exception("El correo ya se encuentra en uso");
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
        paciente.setAlegias(registroPacienteDTO.alergias());
        paciente.setCodigoEPS(registroPacienteDTO.eps());
        paciente.setCodigoTipoSangre(registroPacienteDTO.tipoSangre());


        Paciente pacienteNuevo = pacienteRepo.save(paciente);
        

        return pacienteNuevo.getCodigoCuenta();
    }

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByDni(cedula) != null;
    }
    private boolean estaRepetidaCorreo(String email) {
        return pacienteRepo.findByEmail(email) != null;
    }

    @Override
    public int editarPerfil(int codigoPaciente, DetallePacienteDTO detallePacienteDTO) throws Exception {

        Optional<Paciente> buscado = pacienteRepo.findById(detallePacienteDTO.codigo());

        if (buscado.isEmpty()){
            throw new Exception("El codigo" + detallePacienteDTO.cedula() + " no existe.");
        }

        Paciente paciente = buscado.get();
        paciente.setCorreo(detallePacienteDTO.email());


        paciente.setCedula(detallePacienteDTO.cedula());
        paciente.setNombre(detallePacienteDTO.nombre());
        paciente.setTelefono(detallePacienteDTO.telefono());
        paciente.setUrlFoto(detallePacienteDTO.urlFoto());
        paciente.setCodigoCiudad(detallePacienteDTO.ciudad());
        paciente.setEstadoCuenta(EstadoUsuario.ACTIVO);

        paciente.setFechaNacimiento(detallePacienteDTO.fechaNacimiento());
        paciente.setAlegias(detallePacienteDTO.alergias());
        paciente.setCodigoEPS(detallePacienteDTO.eps());
        paciente.setCodigoTipoSangre(detallePacienteDTO.tipoSangre());

        Paciente pacienteNuevo = pacienteRepo.save(paciente);


        return pacienteNuevo.getCodigoCuenta();
    }

    @Override
    public boolean eliminarCuenta(int codigoPaciente) throws Exception {

        Optional<Paciente> opcional =pacienteRepo.findById(codigoPaciente);

        if( opcional.isEmpty() ){
            throw new Exception("No existe el paciente con el código "+codigoPaciente);
        }

        Paciente buscado = opcional.get();
        buscado.setEstadoCuenta(EstadoUsuario.INACTIVO);
        pacienteRepo.save( buscado );

        return true;
    }
}
