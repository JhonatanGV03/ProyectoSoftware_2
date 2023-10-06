package Clinica.dto.medico;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ItemCitaHistorialDTO( //Item cita del historial medico del paciente
        @NotNull
        Date fechaAtencion,
        @NotNull
        String medicoTratante,
        @NotNull
        int especialidad
) {
}
