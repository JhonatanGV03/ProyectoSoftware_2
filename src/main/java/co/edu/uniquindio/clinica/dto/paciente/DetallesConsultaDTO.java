package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record DetallesConsultaDTO(
        @Positive
        int codigo,
        @NotBlank @Length(max = 100)
        String nomPaciente,
        @NotEmpty
        LocalDateTime fechaCreacion,
        @NotEmpty
        LocalDate fechaCita,
        @NotEmpty
        LocalTime horaCita,
        @NotNull
        EstadoCita estadoCita,
        @NotBlank @Length(max = 500)
        String motivoConsulta,
        @NotBlank @Length(max = 100)
        String nomMedico,
        @NotNull
        Especialidad especialidad,
        @NotBlank @Length(max = 500)
        String notasMedicas,
        @NotBlank @Length(max = 500)
        String diagnostico,
        @NotBlank @Length(max = 500)
        String tratamiento
        ){
}
