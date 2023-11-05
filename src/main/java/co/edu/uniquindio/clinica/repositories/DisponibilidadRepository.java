package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Disponibilidad;
import co.edu.uniquindio.clinica.model.classes.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {

    List<Disponibilidad> findAllByMedico(Medico medico);
}
