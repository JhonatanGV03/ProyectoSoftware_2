package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

public record ItemCitaRealizadaDTO( //Item cita realizada por el codigoMedico del historial de consultas del codigoMedico
        @NotEmpty
        LocalDate fechaAtencion,
        @NotEmpty
        LocalTime horaAtencion,
        @NotBlank @Length(max = 100)
        String nomPaciente,
        @NotBlank @Length(max = 20)
        String cedulaPaciente

) {
}
