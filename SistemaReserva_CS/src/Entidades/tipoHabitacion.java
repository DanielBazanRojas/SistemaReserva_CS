package Entidades;

public class tipoHabitacion extends Habitacion{
    private String tipoHabitacion;
    private String caracteristicas;
    
    public tipoHabitacion() {
    }

    public tipoHabitacion(String tipoHabitacion, String caracteristicas) {
        this.tipoHabitacion = tipoHabitacion;
        this.caracteristicas = caracteristicas;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
