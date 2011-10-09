package CapaNegocios;


public class SeguroVida {

    private int idSeguroVida;

    private int tipoSeguro;

    private String descripcion;

    private double prima;

    private double couta;

    public SeguroVida () {
    }

    public double getCouta () {
        return couta;
    }

    public void setCouta (double val) {
        this.couta = val;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String val) {
        this.descripcion = val;
    }

    public int getIdSeguroVida () {
        return idSeguroVida;
    }

    public void setIdSeguroVida (int val) {
        this.idSeguroVida = val;
    }

    public double getPrima () {
        return prima;
    }

    public void setPrima (double val) {
        this.prima = val;
    }

    public int getTipoSeguro () {
        return tipoSeguro;
    }

    public void setTipoSeguro (int val) {
        this.tipoSeguro = val;
    }

}

