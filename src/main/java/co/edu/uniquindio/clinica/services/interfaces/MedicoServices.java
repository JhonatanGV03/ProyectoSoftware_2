package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.medico.RegistroConsultaDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaMedicoDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaHistorialDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaRealizadaDTO;

import java.time.LocalDate;
import java.util.List;

public interface MedicoServices {

    List<ItemCitaMedicoDTO> listarCitasPendientes(int codigoMedico, LocalDate dia) throws Exception;
    void atenderCita(RegistroConsultaDTO atencionMedica) throws Exception;
    RegistroConsultaDTO cargarRegistro(int codigoCita) throws Exception;
    List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception;
    List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
}
