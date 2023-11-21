package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.administrador.ItemMedicoDTO;
import co.edu.uniquindio.clinica.model.enums.*;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import co.edu.uniquindio.clinica.services.interfaces.ClinicaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicaServicioImpl implements ClinicaServices {


    private final AdministradorServices administradorService;

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

    @Override
    public List<TipoPQRS> listarTiposPQRS() throws Exception {
        List<TipoPQRS> tipoPQRS = List.of(TipoPQRS.values());
        return tipoPQRS;
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {
        List<ItemMedicoDTO> medicos = administradorService.listarmedicos();
                return medicos;
    }
}
