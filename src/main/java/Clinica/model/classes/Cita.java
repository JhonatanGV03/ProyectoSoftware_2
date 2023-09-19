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
    //@Column(name="x")
    private int codigoCita;
    //Atributos
    //@Column(name="x")
    private LocalDateTime fechaCreacion;
    //@Column(name="x")
    private LocalDateTime fechaCita;
    //@Column(name="x")
    private String motivo;
    //Enums
    private EstadoCita estadoCita;
    //Relaciones
    @ManyToOne
    private Paciente codigoPaciente;
    @ManyToOne
    private Medico codigoMedico;
    @OneToOne(mappedBy="codigoCita")
    private Consulta consulta;
    @OneToOne
    private RegistroRecordatorio registroRecordatorio;
    @OneToMany(mappedBy="codigoCita")
    private List<PQRS> PQRS;
}
