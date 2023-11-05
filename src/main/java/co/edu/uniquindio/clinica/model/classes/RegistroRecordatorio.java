package co.edu.uniquindio.clinica.model.classes;

import co.edu.uniquindio.clinica.model.enums.EstadoRecordatorio;
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
    private int codigoRecordatorio;

    //Atributos
    @Column(nullable = false)
    private LocalDateTime fechaEnvio;

    //Enums
    private EstadoRecordatorio estado;

    //Relaciones
    @OneToOne(mappedBy = "registroRecordatorio")
    @JoinColumn(nullable = false)
    private Cita cita;
}
