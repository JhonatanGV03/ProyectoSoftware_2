package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Cita;
import co.edu.uniquindio.clinica.model.classes.Medico;
import co.edu.uniquindio.clinica.model.classes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    //Esta pendiente de revision en la bases de datos
    List<Cita> findAllByPaciente(Paciente paciente);
    List<Cita> findAllByMedico(Medico medico);
    List<Cita> findAllByFechaCita(LocalDate fecha);
    List<Cita> findAllByFechaCitaAndMedico_Codigo(LocalDate fecha, int medicoId);
    List<Cita> findAllByPaciente_Codigo(int pacienteId);

    List<Cita> findAllByFechaCitaAndPaciente_Codigo(LocalDate fecha, int pacienteId);
    List<Cita> findAllByMedico_CodigoAndPaciente_Codigo(int medicoId, int pacienteId);
}
