package Entidades;

import java.util.Date;
import java.util.List;

public class Reserva {

    private int idReserva;
    String serieReserva;
    String correlativoReserva;
    private Date fechaReserva;
    private int idCliente;
    private int idPago;
    private int idTrabajador;
    private double total;
    private boolean estado;
 
    private List<detalleReserva> detalleReserva;

    public Reserva() {
    }

    public Reserva(int idReserva, String serieReserva, String correlativoReserva, Date fechaReserva, int idCliente, int idPago, int idTrabajador, double total, boolean estado, List<detalleReserva> detalleReserva) {
        this.idReserva = idReserva;
        this.serieReserva = serieReserva;
        this.correlativoReserva = correlativoReserva;
        this.fechaReserva = fechaReserva;
        this.idCliente = idCliente;
        this.idPago = idPago;
        this.idTrabajador = idTrabajador;
        this.total = total;
        this.estado = estado;
        this.detalleReserva = detalleReserva;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<detalleReserva> getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(List<detalleReserva> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }
}
