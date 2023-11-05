package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

        Optional<Cuenta> findByCorreo(String correo);
}
