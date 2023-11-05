package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemPqrsPacienteDTO(
        @Positive
        int codigo,  //Radicado
        @Positive
        int codigoPacientr,
        @NotEmpty
        LocalDateTime fecha,
        @NotNull
        EstadoPQRS estadoPQRS,
        @NotBlank @Length(max = 100)
        String nomPaciente
) {
}
