package co.edu.uniquindio.clinica.model.enums;

public enum Especialidad {
    MEDICINA_GENERAL("MEDICINA GENERAL"),
    MEDICINA_INTERNA("MEDICINA INTERNA"),
    ANATOMIA_PATOLOGICA("ANATOMIA PATOLOGICA"),
    CIRUGIA("CIRUGIA"),
    PEDIATRIA("PEDIATRIA"),
    OBSTETRICIA_Y_GINECOLOGIA("OBSTETRICIA Y GINECOLOGIA"),
    DERMATOLOGIA("DERMATOLOGIA"),
    CARDIOLOGIA("CARDIOLOGIA"),
    NEUROLOGIA("NEUROLOGIA"),
    ONCOLOGIA("ONCOLOGIA"),
    PSIQUIATRIA("PSIQUIATRIA");

    private String nombre;
    Especialidad(String nombre) {
        this.nombre = nombre;
    }

}
