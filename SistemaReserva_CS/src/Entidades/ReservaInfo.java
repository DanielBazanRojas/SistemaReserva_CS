package Entidades;

import java.util.Date;

public class ReservaInfo {
   private int idReserva;
    private String serieReserva;
    private String correlativoReserva;
    private Date fechaReserva;
    private int idPago;
    private int idCliente;
    private int idTrabajador;
    private double total;
    private String estadoHabitacion;
    private int idHabitacion;

    public ReservaInfo() {
    }

    public ReservaInfo(int idReserva, String serieReserva, String correlativoReserva, Date fechaReserva, int idPago, int idCliente, int idTrabajador, double total, String estadoHabitacion, int idHabitacion) {
        this.idReserva = idReserva;
        this.serieReserva = serieReserva;
        this.correlativoReserva = correlativoReserva;
        this.fechaReserva = fechaReserva;
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.total = total;
        this.estadoHabitacion = estadoHabitacion;
        this.idHabitacion = idHabitacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getSerieReserva() {
        return serieReserva;
    }

    public void setSerieReserva(String serieReserva) {
        this.serieReserva = serieReserva;
    }

    public String getCorrelativoReserva() {
        return correlativoReserva;
    }

    public void setCorrelativoReserva(String correlativoReserva) {
        this.correlativoReserva = correlativoReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

}
