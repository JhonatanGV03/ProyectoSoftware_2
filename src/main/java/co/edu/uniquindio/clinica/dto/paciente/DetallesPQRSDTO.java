package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record DetallesPQRSDTO(
        @NotNull
        int codigo,
        @NotNull
        Date fechaPQRS,
        @NotNull
        int estadoPQRS,
        @NotNull
        String fechaCita,
        @NotNull
        String medico,
        @NotNull
        String motivoPQRS,

        List<RespuestaDTO> mensajes

        ) {
}
