package Clinica.dto.administrador;

import Clinica.dto.HorarioDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(

    @NotNull
    //Revisar segun las reglas de negocio que ya ingresamos en la base de datos
    @Length(max = 200)
    String cedula,
    @NotNull
    String nombre,
    @NotNull
    int ciudad,
    @NotNull
    String telefono,
    @NotNull
    String password,
    @NotNull @Length(max = 30) @Email
    String correo,
    @NotNull
    int especialidad,
    @NotNull
    int estadoCuenta,
    @NotNull
    String urlFoto,
    List<HorarioDTO> horario_dto
) {

}
