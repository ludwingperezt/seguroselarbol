package CapaNegocios;

import java.sql.Date;
public class Serie {

    private int idSerie;

    private String serie;

    private int maximo;

    private int actual;

    private Date fechaCreacion;

    private Date fechaVencimiento;

    private boolean activa;

    public Serie () {
    }

    public boolean getActiva () {
        return activa;
    }

    public void setActiva (boolean val) {
        this.activa = val;
    }

    public int getActual () {
        return actual;
    }

    public void setActual (int val) {
        this.actual = val;
    }

    public Date getFechaCreacion () {
        return fechaCreacion;
    }

    public void setFechaCreacion (Date val) {
        this.fechaCreacion = val;
    }

    public Date getFechaVencimiento () {
        return fechaVencimiento;
    }

    public void setFechaVencimiento (Date val) {
        this.fechaVencimiento = val;
    }

    public int getIdSerie () {
        return idSerie;
    }

    public void setIdSerie (int val) {
        this.idSerie = val;
    }

    public int getMaximo () {
        return maximo;
    }

    public void setMaximo (int val) {
        this.maximo = val;
    }

    public String getSerie () {
        return serie;
    }

    public void setSerie (String val) {
        this.serie = val;
    }

}

