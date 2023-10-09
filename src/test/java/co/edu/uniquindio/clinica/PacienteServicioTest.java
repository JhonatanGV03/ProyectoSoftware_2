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
                 "109496586",
                 "darlydeguarnizo@uq.com",
                 "12345",
                 "Darly Guarnizo",
                 301298041,
                 Ciudad.ARMENIA,
                 LocalDate.of(2003, 10, 23).atStartOfDay(),
                 "A tu indiferencia bb",
                 EPS.SURA,
                 TipoSangre.A_POSITIVO,
                 "null"
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
                    "109496586",
                    "darlydeguarnizo@uq.com",
                    "Darly Guarnizo",
                    301298041,
                    Ciudad.ARMENIA,
                    LocalDate.of(2003, 10, 23).atStartOfDay(),
                    "acetaminofen",
                    EPS.SURA,
                    TipoSangre.A_POSITIVO,
                    "null"


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
