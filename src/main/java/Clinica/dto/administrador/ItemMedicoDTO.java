package Clinica.dto.administrador;

import jakarta.validation.constraints.NotNull;

public record ItemMedicoDTO(
        @NotNull
        int cedula,
        @NotNull
        String nombre,
        @NotNull
        int especialidad
){
}
