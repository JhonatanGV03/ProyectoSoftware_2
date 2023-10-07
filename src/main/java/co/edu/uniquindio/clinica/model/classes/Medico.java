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
    private Especialidad codigoEspecialidad;

    //Relaciones
    @OneToMany(mappedBy="codigoMedico")
    private List<Horario> horarios;

    @OneToMany(mappedBy="codigoMedico")
    private List<Disponibilidad> disponibilidades;

    @OneToMany(mappedBy="codigoMedico")
    private List<Cita> citas;
}
