package Clinica.repositorios;

import Clinica.model.classes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {

        Paciente findByDni(String dni);

        Paciente findByEmail(String email);


}
