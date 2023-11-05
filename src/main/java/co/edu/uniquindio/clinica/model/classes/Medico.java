package co.edu.uniquindio.clinica.model.classes;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico extends Usuario implements Serializable {
    //Enums
    private Especialidad especialidad;

    //Relaciones
    @OneToMany(mappedBy="medico")
    private List<Horario> horarios;

    @OneToMany(mappedBy="medico")
    private List<Disponibilidad> disponibilidades;

    @OneToMany(mappedBy="medico")
    private List<Cita> citas;
}
