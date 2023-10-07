package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.model.classes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {

        Paciente findByCedula(String cedula);

        Paciente findByCorreo(String email);

        Paciente findByCodigoCuenta(int codigoCuenta);

        Paciente findByCorreoAndPassword(String email, String password);

}
