package Clinica.services.interfaces;

import Clinica.model.enums.EstadoPQRS;
import Clinica.dto.administrador.*;
import Clinica.dto.ItemPQRSDTO;
import Clinica.dto.RegistroRespuestaDTO;

import java.util.List;

public interface AdmnistradorServicio {

    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarMedico(DetallesMedicoDTO medico) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarMedicos() throws Exception;

    DetallesMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    DetallesPQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws  Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;

}
