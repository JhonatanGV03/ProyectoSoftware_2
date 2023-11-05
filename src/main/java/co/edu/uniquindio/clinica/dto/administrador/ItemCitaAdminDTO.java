package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(
        @Positive
        int codigo,
        @NotNull
        EstadoCita estadoCita,
        @NotEmpty
        LocalDateTime fecha,
        @NotBlank @Length(max = 100)
        String nomPaciente
) {
}
