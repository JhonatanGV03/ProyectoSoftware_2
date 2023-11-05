package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record EmailDTO(
        //Probablemente haya que agregar una fecha de envío
        @NotBlank @Length(max = 500)
        String mensaje,
        @NotBlank @Email @Length(max = 50)
        String destinatario,
        @NotBlank @Length(max = 250)
        String asunto,
        @NotBlank @Length(max = 50)
        String remitente
) {
}
