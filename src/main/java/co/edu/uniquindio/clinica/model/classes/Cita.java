package co.edu.uniquindio.clinica.model.classes;

import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCita;
    //Atributos
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false)
    private LocalDate fechaCita;
    @Column(nullable = false)
    private LocalTime horaCita;
    @Column(nullable = false, length = 500)
    private String motivo;

    //Enums
    private EstadoCita estado;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico medico;
    @OneToOne(mappedBy="cita")
    private Consulta consulta;
    @OneToOne
    private RegistroRecordatorio registroRecordatorio;
    @OneToMany(mappedBy="cita")
    private List<PQRS> PQRS;
}
