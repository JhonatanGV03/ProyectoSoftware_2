package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record ItemMedicoDTO(
        @Positive
        int codigo,
        @NotBlank @Length(max = 20)
        String cedula,
        @NotBlank @Length(max = 100)
        String nombre,
        @NotNull
        EstadoUsuario estadoUsuario,
        @NotNull
        Especialidad especialidad
){
}
