package Clinica.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ItemPQRSDTO(
        @NotNull
        int codigo,  //Radicado
        //String tipo,
        @NotNull
        Date fecha,
        @NotNull
        int estadoPQRS
){
}
