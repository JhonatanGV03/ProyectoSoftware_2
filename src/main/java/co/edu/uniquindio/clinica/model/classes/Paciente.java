package co.edu.uniquindio.clinica.model.classes;

import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private LocalDateTime fechaNacimiento;
    @Column(nullable = false, length = 150)
    private String alergias;

    //Enums
    @Column(nullable = false)
    private EPS codigoEPS;
    @Column(nullable = false)
    private TipoSangre codigoTipoSangre;

    //Relaciones
    @OneToMany(mappedBy="codigoPaciente")
    private List<Cita> cita;
}
