package co.edu.uniquindio.clinica.model.enums;

public enum EstadoCita {
    PROGRAMADA("Programada"),
    COMPLETADA("Completada"),
    CANCELADA("Cancelada");

    private String estado;

    EstadoCita(String estado) {
        this.estado = estado;
    }
}
