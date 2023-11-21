package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RegistroConsultaDTO(
        //Datos Atencion
        @Positive
        int codigoCita,
        @NotNull
        LocalDateTime fechaHoraAtencion,
        @NotBlank @Length(max = 500)
        String diagnosticoMedico,
        @NotBlank @Length(max = 500)
        String notasMedico,
        @NotBlank @Length(max = 500)
        String tratamientoMedico,
        @NotBlank @Length(max = 500)
        String motivoConsulta,
        @NotNull
        EstadoCita estadoCita,


        //Datos Paciente
        @NotNull
        int codigoPaciente,
        @NotBlank @Length(max = 20)
        String cedula,
        @NotBlank @Length(max = 100)
        String nombre,
        @NotBlank @Length(max = 50) @Email
        String correo,
        @NotNull
        EPS eps,
        @NotNull
        TipoSangre tipoSangre,
        @NotBlank @Length(max = 250)
        String alergias

) {
}
