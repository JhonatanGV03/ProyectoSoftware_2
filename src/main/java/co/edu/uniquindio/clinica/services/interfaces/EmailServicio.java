package co.edu.uniquindio.clinica.services.interfaces;


import co.edu.uniquindio.clinica.dto.EmailDTO;


public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;


}
