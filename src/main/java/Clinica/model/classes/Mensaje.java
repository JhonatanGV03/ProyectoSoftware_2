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
    private int codigoMensaje;
    //Atributos
    //@Column(name="x")
    private LocalDateTime fechaCreacion;
    //@Column(name="x")
    private String mensaje;
    //Relaciones
    @ManyToOne
    private PQRS codigoPQRS;
    @ManyToOne
    private Paciente codigoPaciente;
    @ManyToOne
    private Administrador codigoAdministrador;
    @OneToOne
    private Mensaje codigoMensajeInt;
}

