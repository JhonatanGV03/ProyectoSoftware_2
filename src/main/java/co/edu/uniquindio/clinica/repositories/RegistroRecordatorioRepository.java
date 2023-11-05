package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.RegistroRecordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRecordatorioRepository extends JpaRepository<RegistroRecordatorio, Integer> {
}
