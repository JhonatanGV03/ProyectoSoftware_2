package dto;

import Clinica.model.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivo,
        LocalDateTime fecha,
        String nombrePaciente) {
}
