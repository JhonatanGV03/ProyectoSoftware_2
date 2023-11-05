package co.edu.uniquindio.clinica.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Horario  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoHorario;

    //Atributos
    @Column(nullable = false)
    private String dia; //String
    @Column(nullable = false)
    private String horaInicio; //LocalTime
    @Column(nullable = false)
    private String horaFin; //LocalTime

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico medico;
}
