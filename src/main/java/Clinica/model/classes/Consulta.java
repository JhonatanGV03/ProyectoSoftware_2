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
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="x")
    private int codigoConsulta;
    //Atributos
    //@Column(name="x")
    private String sintomas;
    //@Column(name="x")
    private String diagnostico;
    //@Column(name="x")
    private String tratamiento;
    //Relaciones
    @OneToOne
    private Cita codigoCita;
}
