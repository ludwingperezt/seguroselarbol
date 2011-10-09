package CapaNegocios;

import java.sql.Date;
public class Factura {

    private int idFactura;

    private int idAgente;

    private int idSerie;

    private int correlativo;

    private Date fecha;

    private double descuento;

    private double total;

    public Factura () {
    }

    public int getCorrelativo () {
        return correlativo;
    }

    public void setCorrelativo (int val) {
        this.correlativo = val;
    }

    public double getDescuento () {
        return descuento;
    }

    public void setDescuento (double val) {
        this.descuento = val;
    }

    public Date getFecha () {
        return fecha;
    }

    public void setFecha (Date val) {
        this.fecha = val;
    }

    public int getIdAgente () {
        return idAgente;
    }

    public void setIdAgente (int val) {
        this.idAgente = val;
    }

    public int getIdFactura () {
        return idFactura;
    }

    public void setIdFactura (int val) {
        this.idFactura = val;
    }

    public int getIdSerie () {
        return idSerie;
    }

    public void setIdSerie (int val) {
        this.idSerie = val;
    }

    public double getTotal () {
        return total;
    }

    public void setTotal (double val) {
        this.total = val;
    }

}

