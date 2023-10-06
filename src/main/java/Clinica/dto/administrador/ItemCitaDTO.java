package Clinica.dto.administrador;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ItemCitaDTO(
        @NotNull
        int codigo,
        @NotNull
        int estadoCita,
        @NotNull
        Date fecha
) {
}
