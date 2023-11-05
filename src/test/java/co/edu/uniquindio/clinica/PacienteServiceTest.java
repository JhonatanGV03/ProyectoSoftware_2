package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.model.enums.*;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@Transactional
public class PacienteServiceTest {

    @Autowired
    private PacienteServices pacienteService;

//    @Test
//    @Sql("classpath:dataset.sql")
//    public void registrarseTest() throws Exception{
//        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
//                "1097222222",
//                "pepitoperez@email.com",
//                "3243434",
//                "Pepito Perez",
//                "12345678",
//                Ciudad.ARMENIA,
//                LocalDate.of(1990, 10, 7),
//                "El polvo y el polen me hacen estornudar",
//                EPS.NUEVA_EPS,
//                TipoSangre.A_POSITIVO,
//                "aquí va la url de la foto"
//                );
//
//        int nuevo = pacienteService.registrarse(pacienteDTO);
//
//        Assertions.assertNotEquals(0, nuevo);
//
//    }


    @Test
    @Sql("classpath:dataset.sql")
    public void editarPerfilTest() throws Exception{
        DetallePacienteDTO pacienteGuardado = pacienteService.verDetallePaciente(4);

        DetallePacienteDTO modificado = new DetallePacienteDTO(
                pacienteGuardado.codigo(),
                pacienteGuardado.cedula(),
                pacienteGuardado.correo(),
                pacienteGuardado.nombre(),
                "111111",
                pacienteGuardado.ciudad(),
                pacienteGuardado.fechaNacimiento(),
                pacienteGuardado.alergias(),
                pacienteGuardado.eps(),
                pacienteGuardado.tipoSangre(),
                pacienteGuardado.urlFoto()
                );

        pacienteService.editarPerfil(modificado);

        DetallePacienteDTO objetoModificado = pacienteService.verDetallePaciente(4);

        Assertions.assertEquals("111111", objetoModificado.telefono());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePacienteTest() throws Exception{
        try {
            DetallePacienteDTO paciente = pacienteService.verDetallePaciente(4);
            System.out.println(paciente.toString());
            Assertions.assertNotEquals(null, paciente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCuentaTest() throws Exception{
        try {
            pacienteService.eliminarCuenta(4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarPacientesTest() throws Exception {

        List<ItemPacienteDTO> pacientes = pacienteService.listarPacientes();
        pacientes.forEach(System.out::println);
        Assertions.assertEquals(6, pacientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordTest() {
        try {
            NewPasswordDTO nuevaPasswordDTO = new NewPasswordDTO( "paciente2@gmail.com","12345","12345");
            pacienteService.cambiarPassword(nuevaPasswordDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPqrsTest() throws Exception {
        PQRSPacienteDTO pqrs = new PQRSPacienteDTO(
                4,
                5,
                "Mala atencion",
                TipoPQRS.PETICION
        );
        int codigoPqrs = pacienteService.crearPQRS(pqrs);
        Assertions.assertEquals("Mala atencion", pacienteService.verDetallesPQRS(codigoPqrs).motivoPQRS());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarPqrsPacienteTest() throws Exception {
        List<ItemPQRSDTO> pqrs = pacienteService.listarPQRSPaciente(5);
        pqrs.forEach(System.out::println);
        Assertions.assertEquals(1, pqrs.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallesPqrsTest() throws Exception {
        try {
            DetallesPQRSDTO pqrs = pacienteService.verDetallesPQRS(3);
            System.out.println(pqrs.toString());
            Assertions.assertNotEquals(null, pqrs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPqrsTest() throws Exception {
        RegistroRespuestaDTO respuesta = new RegistroRespuestaDTO(
                1,
                6,
                5,
                "Respuesta de la respuesta"
        );
        int codigo = pacienteService.responderPQRS(respuesta);
        Assertions.assertNotNull(codigo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarCitaTest() throws Exception{
        RegistroCitaDTO cita = new RegistroCitaDTO(
                4,
                Especialidad.MEDICINA_GENERAL,
                8,
                LocalDate.of(2023, 10,22),
                LocalTime.of(10, 30),
                "Dolor de espalda"
        );
        int codigoCita = pacienteService.agendarCita(cita);
        Assertions.assertEquals("Dolor de espalda", pacienteService.verDetallesCita(codigoCita).motivoConsulta());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallesCitaTest() throws Exception{
        try {
            DetallesCitaDTO cita = pacienteService.verDetallesCita(3);
            System.out.println(cita.toString());
            Assertions.assertNotEquals(null, cita);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPacienteTest() throws Exception {
        List<ItemCitaDTO> citas = pacienteService.listarCitasPaciente(4);
        citas.forEach(System.out::println);
        Assertions.assertEquals(2, citas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallesConsultaTest() throws Exception{
        try {
            DetallesConsultaDTO consulta = pacienteService.verDetalleConsulta(3);
            System.out.println(consulta.toString());
            Assertions.assertNotEquals(null, consulta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasFecha() throws Exception {
        List<ItemCitaDTO> citas = pacienteService.filtrarCitasPacientePorFecha(LocalDate.of(2023, 10, 25), 4);
        citas.forEach(System.out::println);
        Assertions.assertEquals(2, citas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasMedico() throws Exception {
        List<ItemCitaDTO> citas = pacienteService.filtrarCitasPacientePorMedico(10, 13);
        citas.forEach(System.out::println);
        Assertions.assertEquals(1, citas.size());
    }


}
