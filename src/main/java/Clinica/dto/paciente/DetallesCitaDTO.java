package Clinica.dto.paciente;

import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record DetallesCitaDTO(
        @NotNull
        int codigo,
        @NotNull
        String paciente,
        @NotNull
        Date fechaCreacion,
        @NotNull
        Date fechaCita,
        @NotNull
        Time horaCita,
        @NotNull
        int estado,
        @NotNull
        String medico,
        @NotNull
        int especialidad,
        @NotNull
        String notasMedicas,
        @NotNull
        String diagnostico,
        @NotNull
        String tratamiento


        ){
}
