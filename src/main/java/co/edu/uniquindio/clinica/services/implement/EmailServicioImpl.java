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

    private final JavaMailSender javaMailSender;
    @Override
    public void enviarCorreo(EmailDTO emailDTO) throws Exception {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.mensaje() + "\n\n" + emailDTO.remitente(), true);
        helper.setTo(emailDTO.destinatario());
        helper.setFrom("clinicaaurorareal@gmail.com");
        javaMailSender.send(mensaje);
    }
    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }
}
