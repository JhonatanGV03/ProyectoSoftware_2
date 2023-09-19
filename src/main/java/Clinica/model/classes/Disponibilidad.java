package Clinica.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Disponibilidad  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="x")
    private int codigoDisponibilidad;
    //Atributos
    //@Column(name="x")
    private int dia;
    //Relaciones
    @ManyToOne
    private Medico codigoMedico;
}
