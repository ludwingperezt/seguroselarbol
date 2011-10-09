package CapaNegocios;


public class DetalleFactura {

    private int idDetalleRecibo;

    private int idRecibo;

    private int idContratoAuto;

    private int idContratoVida;

    private int idContratoHogar;

    private int subtotal;

    public DetalleFactura () {
    }

    public int getIdContratoAuto () {
        return idContratoAuto;
    }

    public void setIdContratoAuto (int val) {
        this.idContratoAuto = val;
    }

    public int getIdContratoHogar () {
        return idContratoHogar;
    }

    public void setIdContratoHogar (int val) {
        this.idContratoHogar = val;
    }

    public int getIdContratoVida () {
        return idContratoVida;
    }

    public void setIdContratoVida (int val) {
        this.idContratoVida = val;
    }

    public int getIdDetalleRecibo () {
        return idDetalleRecibo;
    }

    public void setIdDetalleRecibo (int val) {
        this.idDetalleRecibo = val;
    }

    public int getIdRecibo () {
        return idRecibo;
    }

    public void setIdRecibo (int val) {
        this.idRecibo = val;
    }

    public int getSubtotal () {
        return subtotal;
    }

    public void setSubtotal (int val) {
        this.subtotal = val;
    }

}

