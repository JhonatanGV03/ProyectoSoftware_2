package Clinica.model.enums;

public enum EPS {
    SURA("Sura"),
    COOMEVA("Coomeva"),
    SANITAS("Sanitas"),
    NUEVA_EPS("Nueva EPS"),
    ALIANSALUD(" Aliansalud"),
    MEDIMAS("Medimas"),
    SALUD_TOTAL("Salud Total"),
    FAMISANAR("Famisanar"),
    COMPENSAR("Compensar"),
    COMFENALCO("Comfenalco");

    private String nombre;

    EPS(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
