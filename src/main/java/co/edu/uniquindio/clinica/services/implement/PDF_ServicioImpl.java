package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.services.interfaces.PDFServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PDF_ServicioImpl implements PDFServices {

    @Override
    public String generarPDF(String html) throws Exception {
        return null;
    }
}
