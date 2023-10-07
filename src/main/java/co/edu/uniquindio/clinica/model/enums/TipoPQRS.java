package co.edu.uniquindio.clinica.model.enums;

public enum TipoPQRS {
    PETICION("Petición"),
    QUEJA("Queja"),
    RECLAMO("Reclamo"),
    SUGERENCIA("Sugerencia");

    private String tipo;
    TipoPQRS(String tipo) {
        this.tipo = tipo;
    }
}
