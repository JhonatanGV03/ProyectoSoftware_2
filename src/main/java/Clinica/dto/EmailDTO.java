package Clinica.dto;

import jakarta.validation.constraints.NotNull;

public record EmailDTO(
        @NotNull
        String mensaje,
        @NotNull
        String destinatario,
        @NotNull
        String asunto,
        @NotNull
        String remitente
) {
}
