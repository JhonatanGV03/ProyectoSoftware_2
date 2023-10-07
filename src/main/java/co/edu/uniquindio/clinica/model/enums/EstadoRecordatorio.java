package co.edu.uniquindio.clinica.model.enums;

public enum EstadoRecordatorio {
    ENVIADO("Enviado"),

    NO_ENVIADO("No enviado");

    private String estado;
    EstadoRecordatorio(String estado) {
        this.estado = estado;
    }
}
