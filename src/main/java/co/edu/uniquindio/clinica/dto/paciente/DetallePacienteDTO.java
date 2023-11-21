package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record DetallePacienteDTO(
        @Positive
        int codigo,
        @NotBlank @Length(max = 20, message = "La cedula debe tener maximo 20 caracteres")
        String cedula,
        @NotBlank @Email(message = "Ingrese una direccion de correo valida")
        @Length(max = 50, message = "El correo debe tener maximo 50 caracteres")
        String correo,
        @NotBlank @Length(max = 100, message = "El nombre debe tener maximo 100 caracteres")
        String nombre,
        @NotBlank @Length(max = 10, message = "El numero de telefono debe tener maximo 10 digitos")
        String telefono,
        @NotNull
        Ciudad ciudad,
        @NotNull @Past(message = "Seleccione una fecha de nacimiento correcta")
        LocalDate fechaNacimiento,
        @NotBlank @Length(max = 250)
        String alergias,
        @NotNull
        EPS eps,
        @NotNull
        TipoSangre tipoSangre,
        @NotNull
        String urlFoto

) {
}
