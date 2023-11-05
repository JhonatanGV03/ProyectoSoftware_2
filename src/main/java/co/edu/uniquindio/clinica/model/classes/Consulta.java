package co.edu.uniquindio.clinica.model.classes;

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
    private int codigoConsulta;

    //Atributos
    @Column(nullable = false, length = 500)
    private String notasMedicas;
    @Column(nullable = false, length = 500)
    private String diagnostico;
    @Column(nullable = false, length = 500)
    private String tratamiento;

    //Relaciones
    @OneToOne
    @JoinColumn(nullable = false)
    private Cita cita;

}
