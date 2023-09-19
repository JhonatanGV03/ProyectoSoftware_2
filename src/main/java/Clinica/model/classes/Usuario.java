package Clinica.model.classes;

import Clinica.model.enums.Ciudad;
import Clinica.model.enums.EstadoUsuario;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends Cuenta implements Serializable {
    //Atributos
    //@Column(name="x")
    private String cedula;
    //@Column(name="x")
    private String nombre;
    //@Column(name="x")
    private int telefono;
    //@Column(name="x")
    private String urlFoto;
    //Enums
    private Ciudad codigoCiudad;
    private EstadoUsuario estadoCuenta;

}
