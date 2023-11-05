package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record ItemPacienteDTO(
        @Positive
        int codigo,
        @NotBlank @Length(max = 20, message = "La cedula debe tener maximo 20 caracteres")
        String cedula,
        @NotBlank @Length(max = 100, message = "El nombre debe tener maximo 100 caracteres")
        String nombre,
        @NotNull
        Ciudad ciudad
) {
}
