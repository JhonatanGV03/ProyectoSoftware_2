package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.services.interfaces.EmailServices;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServices {


    //POR HACER
    @Override
    public void enviarCorreo(EmailDTO emailDTO) throws Exception {

    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }
}
