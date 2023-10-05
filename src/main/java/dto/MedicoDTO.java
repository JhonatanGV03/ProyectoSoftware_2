package dto;

import Clinica.model.enums.Ciudad;
import Clinica.model.enums.Especialidad;

import java.util.List;

public record MedicoDTO(

        int codigo,

        String nombre,
        String cedula,
        Ciudad codigoCiudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String password,
        String URLFoto,
        List<HorarioDTO> horarios

) {
}
