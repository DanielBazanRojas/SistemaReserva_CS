package Entidades;

public class Pago {
    private int idPago;
    private String formaPago;

    public Pago() {
    }

    public Pago(int idPago, String formaPago) {
        this.idPago = idPago;
        this.formaPago = formaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    

}
