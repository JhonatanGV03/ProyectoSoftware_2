package Clinica.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="x")
    private int codigoCuenta;
    //Atributos
    //@Column(name="x")
    private String correo;
    //@Column(name="x")
    private String password;
}
