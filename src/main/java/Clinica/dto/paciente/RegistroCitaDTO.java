package Clinica.dto.paciente;

import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record RegistroCitaDTO(
        @NotNull
        int especialidad,
        @NotNull
        String medico,
        @NotNull
        Date fecha,
        @NotNull
        Time hora,
        @NotNull
        String motivoConsulta
) {
}
