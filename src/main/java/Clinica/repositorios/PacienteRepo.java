package Clinica.repositorios;

import Clinica.model.classes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {

        Paciente findByDni(String dni);

        Paciente findByEmail(String email);

        Paciente findByDniAndPassword(String dni, String password);

        Paciente findByEmailAndPassword(String email, String password); //Login

        Paciente findByCodigoPaciente(int codigoPaciente);

        boolean existsByDni(String dni);

        boolean existsByEmail(String email);

        boolean existsByDniAndPassword(String dni, String password);

        boolean existsByEmailAndPassword(String email, String password);

        boolean existsByCodigoPaciente(int codigoPaciente);

        boolean existsByCodigoPacienteAndDni(int codigoPaciente, String dni);

        boolean existsByCodigoPacienteAndEmail(int codigoPaciente, String email);

        boolean existsByCodigoPacienteAndDniAndPassword(int codigoPaciente, String dni, String password);

        boolean existsByCodigoPacienteAndEmailAndPassword(int codigoPaciente, String email, String password);

        boolean findByDniAndEmail(String dni, String email);

        boolean existsByDniAndEmailAndPassword(String dni, String email, String password);

        boolean existsByDniAndEmailAndPasswordAndCodigoPaciente(String dni, String email, String password, int codigoPaciente);

        boolean existsByDniAndEmailAndCodigoPaciente(String dni, String email, int codigoPaciente);

        boolean existsByDniAndPasswordAndCodigoPaciente(String dni, String password, int codigoPaciente);

        boolean existsByEmailAndPasswordAndCodigoPaciente(String email, String password, int codigoPaciente);

        boolean existsByDniAndCodigoPaciente(String dni, int codigoPaciente);

        boolean existsByEmailAndCodigoPaciente(String email, int codigoPaciente);

        boolean existsByDniAndEmailAndPasswordAndCodigoPacienteAndEstado(String dni, String email, String password, int codigoPaciente, boolean estado);

        boolean existsByDniAndEmailAndCodigoPacienteAndEstado(String dni, String email, int codigoPaciente, boolean estado);

        boolean existsByDniAndPasswordAndCodigoPacienteAndEstado(String dni, String password, int codigoPaciente, boolean estado);

        boolean existsByEmailAndPasswordAndCodigoPacienteAndEstado(String email, String password, int codigoPaciente, boolean estado);

        boolean existsByDniAndCodigoPacienteAndEstado(String dni, int codigoPaciente, boolean estado);

        boolean existsByEmailAndCodigoPacienteAndEstado(String email, int codigoPaciente, boolean estado);
}
