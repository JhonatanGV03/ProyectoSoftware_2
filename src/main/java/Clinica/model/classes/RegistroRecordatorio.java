package Clinica.model.classes;

import Clinica.model.enums.EstadoRecordatorio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistroRecordatorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="x")
    private int codigoRecordatorio;
    //Atributos
    //@Column(name="x")
    private LocalDateTime fechaEnvio;
    //Enums
    private EstadoRecordatorio codigoEstado;
    //Relaciones
    @OneToOne(mappedBy = "registroRecordatorio")
    private Cita cita;
}
