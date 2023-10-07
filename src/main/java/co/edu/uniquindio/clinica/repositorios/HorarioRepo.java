package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.model.classes.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
}