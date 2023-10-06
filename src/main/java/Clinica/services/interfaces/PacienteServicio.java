    package Clinica.services.interfaces;

    import Clinica.dto.paciente.DetallePacienteDTO;
    import Clinica.dto.paciente.RegistroPacienteDTO;

    public interface PacienteServicio {

        int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;
        boolean editarPerfil(int codigoPaciente, DetallePacienteDTO detallePacienteDTO) throws Exception;
        boolean eliminarCuenta(int codigoPaciente) throws Exception;
    //   DetallePacienteDTO verDetallePaciente(int codigo) throws Exception;
    //   void enviarLinkRecuperacion(String email)throws Exception;
    //   void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;
    //   int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;
    //   int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;


        //List<ItemPQRSDTO> listarPQRSPciente(int codigoPciente) throws Exception;

        //DetallesPQRSDTO verDetallePQRS (int codigo) throws Exception;

        //int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

        //List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

        //void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;
        //DetallesAtencionMedicoDTO verDetalleCita(int codigoCita) throws Exception;

        //-----------OJITO

        //void listarPQRSPaciente() throws Exception;
        //void responderPQRS() throws Exception;
        //void listarCitasPaciente() throws Exception;
        //void filtrarCitasPorFecha() throws Exception;
        //void filtrarCitasPorMedico() throws Exception;
        //void verDetalleCita() throws Exception;


    }
