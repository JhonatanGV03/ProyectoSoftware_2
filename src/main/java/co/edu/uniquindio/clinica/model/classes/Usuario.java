package co.edu.uniquindio.clinica.model.classes;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import jakarta.persistence.Column;
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
    @Column(nullable = false, length = 15, unique = true)
    private String cedula;
    @Column(nullable = false, length = 40)
    private String nombre;
    @Column(nullable = false)
    private int telefono;
    @Column(nullable = false)
    private String urlFoto;

    //Enums

    private Ciudad codigoCiudad;
    private EstadoUsuario estadoCuenta;

}
