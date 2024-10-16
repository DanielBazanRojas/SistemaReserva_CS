package Entidades;

public class detalleReserva {
    private int idDetalleReserva;
    private int idReserva;
    private int idHabitacion;
    private int cantidadDias;
    private double montoTotal;

    public detalleReserva() {
    }

    public detalleReserva(int idDetalleReserva, int idReserva, int idHabitacion, int cantidadDias, double montoTotal) {
        this.idDetalleReserva = idDetalleReserva;
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.cantidadDias = cantidadDias;
        this.montoTotal = montoTotal;
    }

    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }

    public void setIdDetalleReserva(int idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

}
