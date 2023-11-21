package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.services.interfaces.PDFServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class PDF_ServiceTest {

    @Autowired
    private PDFServices pdfServices;
}
