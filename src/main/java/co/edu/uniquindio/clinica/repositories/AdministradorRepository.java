package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    Administrador findByCorreo(String correo);
}
