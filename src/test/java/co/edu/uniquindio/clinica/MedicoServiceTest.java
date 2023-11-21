package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class MedicoServiceTest {

    @Autowired
    private MedicoServices medicoService;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPendientesTest() {

        try {
            List<ItemCitaMedicoDTO> citas = medicoService.listarCitasPendientes(8, LocalDate.of(2023, 10, 23));
            System.out.println(citas.toString());
            Assertions.assertNotEquals(0, citas.size() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void atenderCitaTest() throws Exception {

        RegistroConsultaDTO registro = new RegistroConsultaDTO(6,
                LocalDate.of(2021, 10, 23).atTime(12,12,12,12),
                "diagnosticoPrueba",
                "notasPrueba",
                "tratamientoPrueba",
                "motivoPrueba",
                EstadoCita.COMPLETADA,
                "123",
                "nombre",
                "correo",
                EPS.NUEVA_EPS,
                TipoSangre.A_NEGATIVO,
                "alergias");

        medicoService.atenderCita(registro);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cargarRegistroConsultaTest(){

        try {

            RegistroConsultaDTO registro = medicoService.cargarRegistro(5);
            System.out.println(registro.toString());
            Assertions.assertEquals("Motivo5", registro.motivoConsulta());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialPacienteTest() {

        try {
            List<ItemCitaHistorialDTO> historial = medicoService.listarHistorialPaciente(4);
            System.out.println(historial.toString());
            Assertions.assertNotEquals(0, historial.size() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDisponibildiadTest() throws Exception {

        LocalDate fecha = LocalDate.of(2023, 10, 23);
        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(fecha);
        int medico = medicoService.agendarDiaLibre(diaLibreDTO, 14);
        System.out.println(medico);
        Assertions.assertEquals(8, medico );
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasRealizadasMedicoTest(){

        try {
            List<ItemCitaRealizadaDTO> citas = medicoService.listarCitasRealizadasMedico(11);
            System.out.println(citas.toString());
            Assertions.assertNotEquals(0, citas.size() );
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
