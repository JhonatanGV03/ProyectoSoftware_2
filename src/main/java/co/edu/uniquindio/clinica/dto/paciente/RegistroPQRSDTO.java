package co.edu.uniquindio.clinica.dto.paciente;

import jakarta.validation.constraints.NotNull;

public record RegistroPQRSDTO(
        @NotNull
        String citaAsociada,
        @NotNull
        String mensaje
) {
}
