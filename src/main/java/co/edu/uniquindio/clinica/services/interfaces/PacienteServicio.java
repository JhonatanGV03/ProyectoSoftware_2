    package co.edu.uniquindio.clinica.services.interfaces;

    import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
    import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
    import co.edu.uniquindio.clinica.model.classes.Paciente;

    public interface PacienteServicio {

        int iniciarSesion(String email, String password) throws Exception;
        int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;
        int editarPerfil(int codigoPaciente, DetallePacienteDTO detallePacienteDTO) throws Exception;
        boolean eliminarCuenta(int codigoPaciente) throws Exception;
        Paciente obtenerPaciente(int codigoPaciente) throws Exception;
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
