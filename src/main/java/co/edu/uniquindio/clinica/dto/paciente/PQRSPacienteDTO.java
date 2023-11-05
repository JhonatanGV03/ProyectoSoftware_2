package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.TipoPQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record PQRSPacienteDTO(
        @Positive
        int codigoCita,
        @Positive
        int codigoPaciente,
        @NotBlank @Length(max = 500)
        String mensaje,
        @NotNull
        TipoPQRS tipoPQRS

) {
}
