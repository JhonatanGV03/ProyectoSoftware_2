package co.edu.uniquindio.clinica.services.interfaces;

public interface CitaServicios {

    void agendraCita();

    void listarCitasPaciente();

    void verDetalleCita();

    void filtrarCitasPorMedico();

    void filtrarCitasPorFecha();

    void listarCitasPendientesMedico();

    void atenderCita();

    void listarTodasCitasMedico();
}
