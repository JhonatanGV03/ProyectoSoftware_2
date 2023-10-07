package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServicio;
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
     public void registroPaciente() throws Exception {

         System.out.println("PacienteServicioTest.testPacienteServicio");
         RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                 "10972222222",
                 "pepitoperez2@gmail.com",
                 "3243434",
                 "Darly Danielas",
                 313,
                 Ciudad.ARMENIA,
                 LocalDate.of(1990, 10, 7).atStartOfDay(),
                 "A tu indiferencia bb",
                 EPS.SURA,
                 TipoSangre.A_POSITIVO,
                 "SUASASDSA"
         );


             int nuevo = pacienteServicio.registrarse(pacienteDTO);
             Assertions.assertNotEquals(0, nuevo);
             System.out.println(nuevo);


     }


     @Test
     public void editarPerfil() throws Exception{
            System.out.println("PacienteServicioTest.editarPerfil");
            int codigoPaciente = 1;
            DetallePacienteDTO pacienteDTO = new DetallePacienteDTO(
                    1,
                    "sdsd",
                    "asdads@gmail.com",
                    "Darly Daniela",
                    123213,
                    Ciudad.CALARCA,
                    LocalDate.of(1990, 10, 7).atStartOfDay(),
                    "Sapo",
                    EPS.COMFENALCO,
                    TipoSangre.A_POSITIVO,
                    "asdfadfadsf"


            );
            pacienteServicio.editarPerfil(codigoPaciente, pacienteDTO);
     }


     @Test
     public void eliminarPaciente() throws Exception {
         System.out.println("PacienteServicioTest.eliminarPaciente");
         int codigoPaciente = 1;
         boolean eliminado = pacienteServicio.eliminarCuenta(codigoPaciente);
         Assertions.assertTrue(eliminado);
     }
     @Test
    public void iniciarSesion() throws Exception {
         System.out.println("PacienteServicioTest.iniciarSesion");
         String email = "asdads@gmail.com", password = "3243434";
         int codigoPaciente = pacienteServicio.iniciarSesion(email, password);
         Assertions.assertNotEquals(0, codigoPaciente);
         System.out.println(codigoPaciente + "PACIENTE LOGUEADO");
     }

}