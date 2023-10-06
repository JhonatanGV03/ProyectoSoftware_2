package Clinica.dto.administrador;

import Clinica.dto.HorarioDTO;
import Clinica.model.enums.Ciudad;
import Clinica.model.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record DetallesMedicoDTO(
        @NotNull @Length(max = 50)
        String cedula,
        @NotNull
        String nombre,
        @NotNull
        Ciudad ciudad,
        @NotNull
        String telefono,
        @NotNull @Length(max = 40) @Email
        String correo,
        @NotNull
        Especialidad especialidad,
        List<HorarioDTO> horario_dto
) {
}
