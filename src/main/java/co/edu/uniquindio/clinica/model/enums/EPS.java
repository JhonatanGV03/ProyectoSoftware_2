package co.edu.uniquindio.clinica.model.enums;

public enum EPS {
    SURA("SURA"),
    COOMEVA("COOMEVA"),
    SANITAS("SANITAS"),
    NUEVA_EPS("NUEVA EPS"),
    ALIANSALUD("ALIANSALUD"),
    MEDIMAS("MEDIMAS"),
    SALUD_TOTAL("SALUD TOTAL"),
    FAMISANAR("FAMISANAR"),
    COMPENSAR("COMPENSAR"),
    COMFENALCO("COMFENALCO");

    private String nombre;
    EPS(String nombre) {
        this.nombre = nombre;
    }
 }
