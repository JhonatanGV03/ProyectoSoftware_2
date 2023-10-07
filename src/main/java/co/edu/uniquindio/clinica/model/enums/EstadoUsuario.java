package co.edu.uniquindio.clinica.model.enums;

public enum EstadoUsuario {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private String estado;
    EstadoUsuario(String estado) {
        this.estado = estado;
    }
}
