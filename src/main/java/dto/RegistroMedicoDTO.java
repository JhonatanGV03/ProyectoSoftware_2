package dto;

import Clinica.model.enums.Especialidad;
import Clinica.model.enums.Ciudad;

import java.util.List;

public record RegistroMedicoDTO(
        String nombre,
        String cedula,
        Ciudad codigoCiudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String password,
        String URLFoto,
        boolean estado,
        List<HorarioDTO> horarios
) {


}
