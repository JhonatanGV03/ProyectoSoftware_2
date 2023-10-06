package Clinica;

import Clinica.dto.paciente.RegistroPacienteDTO;
import Clinica.model.enums.Ciudad;
import Clinica.model.enums.EPS;
import Clinica.model.enums.TipoSangre;
import Clinica.services.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@SpringBootTest
public class PacienteServicioTest {

     @Autowired
     private PacienteServicio pacienteServicio;

     @Test
     public void testPacienteServicio() throws Exception {

         RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                 "1097222222",
                 "pepitoperez@email.com",
                 "3243434",
                 "Darly Daniela",
                 313,
                 Ciudad.ARMENIA,
                 LocalDate.of(1990, 10, 7).atStartOfDay(),
                 "A tu indiferencia bb",
                 EPS.SURA,
                 TipoSangre.A_POSITIVO,
                 "SUASASDSA"
         );


             int nuevo = pacienteServicio.registrarse(pacienteDTO);


     }
}