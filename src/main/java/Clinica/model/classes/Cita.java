package Clinica.model.classes;

import Clinica.model.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int codigoCita;
    //Atributos
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false)
    private LocalDateTime fechaCita;
    @Column(nullable = false, length = 150)
    private String motivo;

    //Enums
    private EstadoCita estadoCita;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Paciente codigoPaciente;
    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Medico codigoMedico;
    @OneToOne(mappedBy="codigoCita")
    @JoinColumn(nullable = false)
    private Consulta consulta;
    @OneToOne
    @JoinColumn(nullable = false)
    private RegistroRecordatorio registroRecordatorio;
    @OneToMany(mappedBy="codigoCita")
    private List<PQRS> PQRS;
}
