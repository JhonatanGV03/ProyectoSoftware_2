package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
