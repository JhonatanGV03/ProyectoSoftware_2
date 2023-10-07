package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;

public record NewPasswordDTO(
    @NotNull
    String email
    //String token //En caso de que se vaya a realizar con codigo de confirmacion
) {

}
