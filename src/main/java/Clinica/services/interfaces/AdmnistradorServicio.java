package Clinica.services.interfaces;

import Clinica.model.enums.EstadoPQRS;
import dto.*;

import java.util.List;

public interface AdmnistradorServicio {

    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarMedico(MedicoDTO medico) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws  Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;

}
