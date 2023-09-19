package Clinica.model.classes;

import Clinica.model.enums.EPS;
import Clinica.model.enums.TipoSangre;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    private LocalDateTime fechaNacimiento;
    //@Column(name="x")
    private String alegias;
    //Enums
    private EPS codigoEPS;
    private TipoSangre codigoTipoSangre;
    //Relaciones
    @OneToMany(mappedBy="codigoPaciente")
    private List<Cita> cita;
    @OneToMany(mappedBy="codigoPaciente")
    private List<Mensaje> mensajes;
}
