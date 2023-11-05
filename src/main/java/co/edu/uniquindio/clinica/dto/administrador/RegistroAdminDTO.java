package co.edu.uniquindio.clinica.dto.administrador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record RegistroAdminDTO(

        @Positive
        int codigo,
        @NotBlank @Length(max = 50) @Email
        String correo,
        @NotBlank
        String password
) {


}
