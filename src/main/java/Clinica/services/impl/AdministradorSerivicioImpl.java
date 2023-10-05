package Clinica.services.impl;

import Clinica.model.classes.*;
import Clinica.model.enums.EstadoPQRS;
import Clinica.model.repositorios.*;
import Clinica.services.interfaces.AdmnistradorServicio;
import dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorSerivicioImpl implements AdmnistradorServicio {


    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MensajeRepo mensajeRepo;
    private final CuentaRepo cuentaRepo;
    private final HorarioRepo horarioRepo;


    @Override
    public int crearMedico(RegistroMedicoDTO medico) throws Exception {
        return 0;
    }

    @Override
    public int actualizarMedico(MedicoDTO medico) throws Exception {
        return 0;
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {

    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {
        return null;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {
        return null;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarCitas() throws Exception {
        return null;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {

    }
}
