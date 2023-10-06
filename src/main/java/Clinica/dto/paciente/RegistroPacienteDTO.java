package Clinica.dto.paciente;

import Clinica.model.enums.Ciudad;
import Clinica.model.enums.EPS;
import Clinica.model.enums.TipoSangre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroPacienteDTO (
        @NotNull
        String cedula,
        @NotNull @Email
        String email,
        @NotNull
        String contrasena,
        @NotNull
        String nombre,
        @NotNull
        int telefono,
        @NotNull
        Ciudad ciudad,
        @NotNull
        LocalDateTime fechaNacimiento,
        @NotNull
        String alergias,
        @NotNull
        EPS eps,
        @NotNull
        TipoSangre tipoSangre,
        @NotNull
        String urlFoto


){
}
