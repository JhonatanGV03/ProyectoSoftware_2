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
public class Horario  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="x")
    private int codigoHorario;
    //Atributos
    //@Column(name="x")
    private int dia;
    //Tipo???
    //@Column(name="x")
    private String horaInicio;
    //@Column(name="x")
    private String horaFin;
    //Relaciones
    @ManyToOne
    private Medico codigoMedico;
}
