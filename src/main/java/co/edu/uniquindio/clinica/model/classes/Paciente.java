package co.edu.uniquindio.clinica.model.classes;

import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("Paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente extends Usuario implements Serializable {
    //Atributos
    @Column(nullable = false)
    private String fechaNacimiento;
    @Column(nullable = false, length = 250)
    private String alergias;

    //Enums
    private EPS EPS;
    private TipoSangre tipoSangre;

    //Relaciones
    @OneToMany(mappedBy="paciente")
    private List<Cita> cita;
}
