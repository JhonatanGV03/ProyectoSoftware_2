package co.edu.uniquindio.clinica.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Disponibilidad  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int codigoDisponibilidad;

    //Atributos
    @Column(nullable = false)
    private Date dia;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico codigoMedico;
}
