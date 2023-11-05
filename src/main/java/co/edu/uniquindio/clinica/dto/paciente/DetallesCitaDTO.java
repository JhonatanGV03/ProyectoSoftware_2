package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

public record DetallesCitaDTO (
        @Positive
        int codigoPaciente,
        @NotNull
        Especialidad especialidad,
        @Positive
        int codigoMedico,
        @NotEmpty
        LocalDate fecha,
        @NotEmpty
        LocalTime hora,
        @NotBlank @Length(max = 500)
        String motivoConsulta,
        @NotNull
        EstadoCita estadoCita
){
}
