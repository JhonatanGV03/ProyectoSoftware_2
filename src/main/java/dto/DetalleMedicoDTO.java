package dto;

import Clinica.model.enums.Ciudad;
import Clinica.model.enums.Especialidad;
import dto.HorarioDTO;

import java.util.ArrayList;
import java.util.List;

public record DetalleMedicoDTO(
        int codigo,
        String nombre,
        String cedula,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String urlFoto,
        List<HorarioDTO> horarios

) {

}
