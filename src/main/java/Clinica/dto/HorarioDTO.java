package Clinica.dto;

import jakarta.validation.constraints.NotNull;

public record HorarioDTO (
        @NotNull
        String dia,
        @NotNull
        String horaInicio,
        @NotNull
        String horaFin
){
}
