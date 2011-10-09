package CapaNegocios;


public class SeguroAuto {

    private int idSeguroAuto;

    private int tipoSeguro;

    private String descripcion;

    private double prima;

    private double couta;

    public SeguroAuto () {
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

    public int getIdSeguroAuto () {
        return idSeguroAuto;
    }

    public void setIdSeguroAuto (int val) {
        this.idSeguroAuto = val;
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

