package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    Medico findByCorreo(String correo);

    Medico findByCedula(String cedula);

    Optional<Medico> findByNombre(String medico);


    /*
        @Query("select m from Medico m where m.cedula = :cedula")
    Medico buscarPorCedula(String cedula);

    @Query("select m from Medico m where m.correo = :correo")
    Medico buscarPorCorreo(String correo);
     */
}
