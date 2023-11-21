package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;

import java.time.LocalDate;
import java.util.List;

public interface PacienteServices {
    int registrarse(RegistroPacienteDTO paciente) throws Exception;

    DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception;

    int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception;

    void eliminarCuenta(int codigoPaciente) throws Exception;

    List<ItemPacienteDTO> listarPacientes();

    void cambiarPassword(NewPasswordDTO newPasswordDTO) throws Exception;

    int crearPQRS(PQRSPacienteDTO PQRSPacienteDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;
    DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    DetallesCitaDTO verDetallesCita(int codigo) throws Exception;
    List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    DetallesConsultaDTO verDetalleConsulta(int codigo) throws Exception;

    List<ItemCitaDTO> filtrarCitasPacientePorFecha(LocalDate fecha, int codigoPaciente) throws Exception;  //??

    List<ItemCitaDTO> filtrarCitasPacientePorMedico(int codigoMedico, int codigoPaciente) throws Exception;  //??

}
