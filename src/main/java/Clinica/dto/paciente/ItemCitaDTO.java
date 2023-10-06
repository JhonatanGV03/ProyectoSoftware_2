package Clinica.dto.paciente;

import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record ItemCitaDTO(
        @NotNull
        int codigo,
        @NotNull
        Date fecha,
        @NotNull
        Time hora,
        @NotNull
        int especialidad,
        @NotNull
        String medico
) {
}
