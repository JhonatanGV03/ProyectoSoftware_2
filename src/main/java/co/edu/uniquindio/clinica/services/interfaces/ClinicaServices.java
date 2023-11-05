package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;

import java.util.List;

public interface ClinicaServices {

    List<Ciudad> listarCiudades() throws Exception;
    List<TipoSangre> listarTipoSangre() throws Exception;

    List<Especialidad> listarEspecialidad() throws Exception;
    List<EPS> listarEPS() throws Exception;
}
