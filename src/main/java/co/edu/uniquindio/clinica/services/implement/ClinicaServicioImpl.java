package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import co.edu.uniquindio.clinica.services.interfaces.ClinicaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicaServicioImpl implements ClinicaServices {


    @Override
    public List<Ciudad> listarCiudades() throws Exception {
        List<Ciudad> ciudades = List.of(Ciudad.values());
        return ciudades;
    }

    @Override
    public List<TipoSangre> listarTipoSangre() throws Exception {
        List<TipoSangre> tipoSangres = List.of(TipoSangre.values());
        return tipoSangres;
    }

    @Override
    public List<Especialidad> listarEspecialidad() throws Exception {
        List<Especialidad> especialidad = List.of(Especialidad.values());
        return especialidad;
    }

    @Override
    public List<EPS> listarEPS() throws Exception {
        List<EPS> eps = List.of(EPS.values());
        return eps;
    }
}
