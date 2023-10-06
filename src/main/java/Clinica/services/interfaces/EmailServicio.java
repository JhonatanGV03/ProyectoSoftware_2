package Clinica.services.interfaces;


import Clinica.dto.EmailDTO;


public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;


}
