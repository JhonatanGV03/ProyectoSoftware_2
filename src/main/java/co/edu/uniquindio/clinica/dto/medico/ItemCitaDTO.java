package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record ItemCitaDTO( //Item cita de la lista de citas que tiene el medico en su agenda
        @NotNull
        String nombrePaciente,
        @NotNull
        Date fecha,
        @NotNull
        Time hora,
        @NotNull
        int estadoCita

) {
}
