package CapaNegocios;

import java.sql.Date;
public class ContratoHogar {

    private int idContratoVida;

    private int idSeguroHogar;

    private Date fechaContrato;

    private Date fechaPago;

    private double Mora;

    private String Descripcion;

    private Date vencimiento;

    private double valorInmueble;

    private double valorMuebles;

    private int numeroPagos;

    private boolean activo;

    private double montoPagoseguro;

    public ContratoHogar () {
    }

    public String getDescripcion () {
        return Descripcion;
    }

    public void setDescripcion (String val) {
        this.Descripcion = val;
    }

    public double getMora () {
        return Mora;
    }

    public void setMora (double val) {
        this.Mora = val;
    }

    public boolean getActivo () {
        return activo;
    }

    public void setActivo (boolean val) {
        this.activo = val;
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

    public int getIdSeguroHogar () {
        return idSeguroHogar;
    }

    public void setIdSeguroHogar (int val) {
        this.idSeguroHogar = val;
    }

    public double getMontoPagoseguro () {
        return montoPagoseguro;
    }

    public void setMontoPagoseguro (double val) {
        this.montoPagoseguro = val;
    }

    public int getNumeroPagos () {
        return numeroPagos;
    }

    public void setNumeroPagos (int val) {
        this.numeroPagos = val;
    }

    public double getValorInmueble () {
        return valorInmueble;
    }

    public void setValorInmueble (double val) {
        this.valorInmueble = val;
    }

    public double getValorMuebles () {
        return valorMuebles;
    }

    public void setValorMuebles (double val) {
        this.valorMuebles = val;
    }

    public Date getVencimiento () {
        return vencimiento;
    }

    public void setVencimiento (Date val) {
        this.vencimiento = val;
    }

}

