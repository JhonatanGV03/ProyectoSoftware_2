package Clinica.services;

import dto.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AdministradorServices {

    //______________________________ Servicios _______________________
    String crearMedico(MedicoDTO medico) throws Exception;
    String actualizarMedico(int codigo, MedicoDTO medico) throws Exception;
    String eliminarMedico(int codigo) throws Exception;
    List<MedicoDTOAdmin> listarMedicos() throws Exception;
    InfoMedicoDTO obtenerMedico(int codigo) throws Exception;
    List<PQRSDTOAdmin> listarPQRS() throws Exception;
    String responderPQRS(int codigo) throws Exception;
    InfoPQRSDTO verDetallePQRS(int codigo) throws Exception;
    List<CitaDTOAdmin> listarCitas() throws Exception;
    //_________________________________________________________________________

}
