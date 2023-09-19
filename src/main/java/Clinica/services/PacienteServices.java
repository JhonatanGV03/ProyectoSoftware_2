package Clinica.services;

import dto.PacienteDTO;

public interface PacienteServices {

    //______________________________ Servicios _______________________
    String registrar(PacienteDTO pacienteDTO) throws Exception;
    String modificarDatos(PacienteDTO pacienteDTO) throws Exception;
    //_______________________________________________________________

}
