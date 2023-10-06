package Clinica.dto.medico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroAtencionDTO(
        //Datos Atencion
        @NotNull
        String codigoAtencion,
        @NotNull
        LocalDateTime fechaHoraAtencion,
        @NotNull
        String diagnosticoMedico,
        @NotNull
        String notasMedico,
        @NotNull
        String tratamientoMedico,
        @NotNull
        String motivoConsulta,


        //Datos Paciente
        @NotNull
        String cedula,
        @NotNull
        String nombre,
        @NotNull
        String email,
        @NotNull
        int eps,
        @NotNull
        int tipoSangre,
        @NotNull
        String Alergias

) {
}
