package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

public record ItemCitaMedicoDTO( //Item cita de la lista de citas que tiene el codigoMedico en su agenda
         @NotNull
         int codigoCita,
         @NotBlank @Length(max = 100)
        String nombrePaciente,
        @NotEmpty
        LocalDate fecha,
        @NotEmpty
        LocalTime hora,
        @NotNull
        EstadoCita estadoCita
) {
}
