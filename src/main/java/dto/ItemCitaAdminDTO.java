package dto;

import Clinica.model.enums.Especialidad;
import Clinica.model.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(
        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha
) {
}
