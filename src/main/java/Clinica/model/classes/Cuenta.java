package Clinica.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int codigoCuenta;

    //Atributos
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false)
    private String password;

    // Relaciones
    @OneToMany(mappedBy="cuenta")
    private List<Mensaje> mensajes;
}
