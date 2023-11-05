package co.edu.uniquindio.clinica.dto.paciente;

import jakarta.validation.constraints.NotBlank;

public record FiltroBusquedaDTO(
        @NotBlank
        String busqueda

) {
}
