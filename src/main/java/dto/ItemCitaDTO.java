package dto;

import Clinica.model.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha
) {
}
