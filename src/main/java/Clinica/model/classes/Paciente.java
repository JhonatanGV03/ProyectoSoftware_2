package Clinica.model.classes;

import Clinica.model.enums.EPS;
import Clinica.model.enums.TipoSangre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("Paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente extends Usuario implements Serializable {
    //Atributos
    //@Column(name="x")
    @Column(nullable = false)
    private LocalDateTime fechaNacimiento;
    //@Column(name="x")
    @Column(nullable = false)
    private String alergias;
    //Enums
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EPS codigoEPS;
    @Column(nullable = false)
    private TipoSangre codigoTipoSangre;
    //Relaciones
    @OneToMany(mappedBy="codigoPaciente")
    private List<Cita> cita;
    @OneToMany(mappedBy="codigoPaciente")
    private List<Mensaje> mensajes;
}
