package CapaNegocios;

import java.sql.Date;
public class ContratoVida {

    private int idContratoVida;

    private int idSeguroVida;

    private String descripcion;

    private String profesion;

    private Date fechaContrato;

    private Date fechaPago;

    private double mora;

    private Date vencimiento;

    private int numeroPagos;

    private boolean activo;

    private double montoPagoSeguro;

    public ContratoVida () {
    }

    public boolean getActivo () {
        return activo;
    }

    public void setActivo (boolean val) {
        this.activo = val;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String val) {
        this.descripcion = val;
    }

    public Date getFechaContrato () {
        return fechaContrato;
    }

    public void setFechaContrato (Date val) {
        this.fechaContrato = val;
    }

    public Date getFechaPago () {
        return fechaPago;
    }

    public void setFechaPago (Date val) {
        this.fechaPago = val;
    }

    public int getIdContratoVida () {
        return idContratoVida;
    }

    public void setIdContratoVida (int val) {
        this.idContratoVida = val;
    }

    public int getIdSeguroVida () {
        return idSeguroVida;
    }

    public void setIdSeguroVida (int val) {
        this.idSeguroVida = val;
    }

    public double getMontoPagoSeguro () {
        return montoPagoSeguro;
    }

    public void setMontoPagoSeguro (double val) {
        this.montoPagoSeguro = val;
    }

    public double getMora () {
        return mora;
    }

    public void setMora (double val) {
        this.mora = val;
    }

    public int getNumeroPagos () {
        return numeroPagos;
    }

    public void setNumeroPagos (int val) {
        this.numeroPagos = val;
    }

    public String getProfesion () {
        return profesion;
    }

    public void setProfesion (String val) {
        this.profesion = val;
    }

    public Date getVencimiento () {
        return vencimiento;
    }

    public void setVencimiento (Date val) {
        this.vencimiento = val;
    }

}

