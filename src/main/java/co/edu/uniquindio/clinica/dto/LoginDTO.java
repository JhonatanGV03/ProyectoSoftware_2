package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;

public record LoginDTO(
        @NotNull
        String usuario,
        @NotNull
        String contrasena
) {
}
