package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/*
REVISAR LOS ATRIBUTOS QUE VA A TENER ESTE ITEM
 */
public record ItemPQRSDTO(
        @Positive
        int codigo,  //Radicado
        @NotEmpty
        LocalDateTime fecha,
        @NotNull
        EstadoPQRS estadoPQRS,
        @NotBlank @Length(max = 100)
        String motivo
){
}
