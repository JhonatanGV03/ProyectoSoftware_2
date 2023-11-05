package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.EmailDTO;

public interface EmailServices {
    void enviarCorreo(EmailDTO emailDTO) throws Exception;
    void enviarLinkRecuperacion(String email) throws Exception;
}
