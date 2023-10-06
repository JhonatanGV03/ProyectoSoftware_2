package Clinica.dto.medico;

import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record ItemCitaRealizadaDTO( //Item cita realizada por el medico del historial de consultas del medico
        @NotNull
        Date fechaAtencion,
        @NotNull
        Time horaAtencion,
        @NotNull
        String nombrePaciente,
        @NotNull
        String cedulaPaciente

) {
}
