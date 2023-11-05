package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepository extends JpaRepository<PQRS, Integer>{
    @Query("select m from PQRS m where m.cita.paciente.codigo = :codigoPaciente")
    List<PQRS> obtenerPqrs(int codigoPaciente);
}
