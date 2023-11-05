package co.edu.uniquindio.clinica.model.classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private int codigo;

    //Atributos
    @Email
    @Column(nullable = false, unique = true, length = 50)
    private String correo;
    @Column(nullable = false)
    private String password;

    // Relaciones
    @OneToMany(mappedBy="cuenta")
    private List<Mensaje> mensajes;
}
