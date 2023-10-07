package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetallePacienteDTO(
        @NotNull
        int codigo,
        @NotNull
        String cedula,
        @NotNull @Email
        String email,
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


) {
}
