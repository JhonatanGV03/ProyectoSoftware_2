package Clinica.dto.paciente;

import jakarta.validation.constraints.NotNull;

public record RegistroPQRSDTO(
        @NotNull
        String citaAsociada,
        @NotNull
        String mensaje
) {
}
