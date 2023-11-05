package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record NewPasswordDTO(
    @NotBlank @Email @Length(max = 50)
    String correo,
    //String token //En caso de que se vaya a realizar con codigo de confirmacion
    @NotBlank
    String newPassword,
    @NotBlank
    String confirmPassword
) {

}
