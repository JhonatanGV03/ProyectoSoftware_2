package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;

import java.util.List;

public interface AdministradorServices {

    void crearAdmin(RegistroAdminDTO admin) throws Exception;
    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarmedico(DetallesMedicoDTO medicoDTO) throws Exception;

    void eliminarmedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarmedicos() throws Exception;

    DetallesMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;
    DetallesPQRSAdminDTO verDetallesPQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;
    List<ItemCitaAdminDTO> listarCitas() throws Exception;


}
