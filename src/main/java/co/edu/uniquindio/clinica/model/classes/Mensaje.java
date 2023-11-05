package co.edu.uniquindio.clinica.model.classes;
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
    private int codigo;

    //Atributos
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false, length = 500)
    private String mensaje;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private PQRS PQRS;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cuenta cuenta;
}

