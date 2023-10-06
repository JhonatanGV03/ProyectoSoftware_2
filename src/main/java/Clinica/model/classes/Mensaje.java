package Clinica.model.classes;
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
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int codigoMensaje;

    //Atributos
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false)
    private String mensaje;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private PQRS codigoPQRS;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cuenta cuenta;
    @OneToOne
    @JoinColumn(nullable = false)
    private Mensaje codigoMensajeInt;
}

