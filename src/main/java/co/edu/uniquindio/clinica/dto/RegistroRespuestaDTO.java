package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;


public record RegistroRespuestaDTO(
        @Positive
        int codCuenta,
        @Positive
        int codPqrs,
        @Positive
        int codMensaje, //Deberia crearse automatico
        @NotBlank @Length(max = 500)
        String mensaje
){
}
