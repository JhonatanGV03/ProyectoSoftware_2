package co.edu.uniquindio.clinica.model.classes;

import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.model.enums.TipoPQRS;
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
public class PQRS implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    //Atributos
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false, length = 200)
    private String motivo;

    //Enums
    private TipoPQRS tipoPQRS;
    private EstadoPQRS estado;

    //Relacion Clases
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cita cita;
    @OneToMany(mappedBy="PQRS")
    private List<Mensaje> mensajes;


}
