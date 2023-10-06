package Clinica.dto;

import jakarta.validation.constraints.NotNull;

public record RegistroRespuestaDTO(
        @NotNull
        int codigo,
        @NotNull
        int codUsuario,
        @NotNull
        String mensaje
){
}
