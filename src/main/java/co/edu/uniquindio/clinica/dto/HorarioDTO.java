package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record HorarioDTO (
        @NotNull
        String dia,
        @NotNull
        LocalTime horaInicio,
        @NotNull
        LocalTime horaFin
){
}
