package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Paciente findByCedula(String cedula);
    Paciente findByCorreo(String correo);
}
