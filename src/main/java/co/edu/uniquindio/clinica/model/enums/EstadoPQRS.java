package co.edu.uniquindio.clinica.model.enums;

public enum EstadoPQRS {
    NUEVO("Nuevo"),
    EN_PROCESO("En proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private String estado;
    EstadoPQRS(String estado) {
        this.estado = estado;
    }
}
