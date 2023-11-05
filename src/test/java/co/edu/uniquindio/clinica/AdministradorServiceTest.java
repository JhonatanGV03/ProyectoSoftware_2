package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServiceTest {

    @Autowired
    private AdministradorServices administradorServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void crearMedicoTest() {

        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO("LUNES", LocalTime.of(7, 0, 0), LocalTime.of(14, 0, 0)));

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Paco Perez",
                "54321",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGIA,
                "12345",
                "pepito@email.com",
                "78387",
                "url_foto",
                horarios
        );
        try {
            int codigo = administradorServicio.crearMedico(medicoDTO);
            Assertions.assertNotEquals(0, codigo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizarMedicoTest() {
        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO("LUNES", LocalTime.of(7, 0, 0), LocalTime.of(14, 0, 0)));

        DetallesMedicoDTO medicoDTO = new DetallesMedicoDTO(
                8,
                "Alejandro Hernandez",
                "12345",
                Ciudad.ARMENIA,
                Especialidad.MEDICINA_GENERAL,
                "12345",
                "Hernan@email.com",
                "78387/img/imagen.jpg",
                horarios
        );
        try {
            administradorServicio.actualizarmedico(medicoDTO);
            Assertions.assertNotEquals(0, medicoDTO.codigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarMedicoTest() {
        try {
            administradorServicio.eliminarmedico(8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void listarMedicosTest() {
        try {
            List<ItemMedicoDTO> medicos = administradorServicio.listarmedicos();
            System.out.println(medicos.toString());
            Assertions.assertNotEquals(0, medicos.size()); // Verifica que la lista no este vacia.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void obtenerMedicoTest() {
        try {
            DetallesMedicoDTO medico = administradorServicio.obtenerMedico(9);
            System.out.println(medico.toString());
            Assertions.assertEquals(9, medico.codigo()); // Verifica que la lista no este vacia.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarPQRSTest() {
        try {
            List<ItemPQRSDTO> medicos = administradorServicio.listarPQRS();
            System.out.println(medicos.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void responderPQRSTest() {
        RegistroRespuestaDTO respuesta = new RegistroRespuestaDTO(
                1,
                6,
                5,
                "respuesta"
        );


        try {
            int codigo = administradorServicio.responderPQRS(respuesta);
            Assertions.assertNotNull(codigo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void verDetallesPQRSTest() {
        try {
            DetallesPQRSAdminDTO pqrs = administradorServicio.verDetallesPQRS(2);
            System.out.println(pqrs.toString());
            Assertions.assertNotEquals(null, pqrs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void cambiarEstadoPQRSTest() {
        try {
            //Ver el estado inicial de la pqrs
            DetallesPQRSAdminDTO pqrsi = administradorServicio.verDetallesPQRS(2);
            System.out.println(pqrsi.toString());

            administradorServicio.cambiarEstadoPQRS(2, EstadoPQRS.RESUELTO);

            //Ver el estado final de la pqrs
            DetallesPQRSAdminDTO pqrs = administradorServicio.verDetallesPQRS(2);
            System.out.println(pqrs.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasTest() {
        try {
            List<ItemCitaAdminDTO> citas = administradorServicio.listarCitas();
            System.out.println(citas.toString());
            Assertions.assertNotEquals(0, citas.size()); // Verifica que la lista no este vacia.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
