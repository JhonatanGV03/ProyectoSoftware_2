package dto;

import java.util.List;

public record PacienteDTO(
        String nombre,
        String cedula,
        String telefono,
        String correo,
        String password,
        String alergias

) {
}
