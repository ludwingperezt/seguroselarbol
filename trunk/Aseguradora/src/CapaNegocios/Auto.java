package CapaNegocios;


public class Auto {

    private int idAuto;

    private String tipoVehiculo;

    private String marca;

    private String modelo;

    private String placas;

    private String NumeroMotor;

    private String NumeroChasis;

    private String Color;

    private int Ejes;

    private byte fotografia;

    public Auto () {
    }

    public String getColor () {
        return Color;
    }

    public void setColor (String val) {
        this.Color = val;
    }

    public int getEjes () {
        return Ejes;
    }

    public void setEjes (int val) {
        this.Ejes = val;
    }

    public String getNumeroChasis () {
        return NumeroChasis;
    }

    public void setNumeroChasis (String val) {
        this.NumeroChasis = val;
    }

    public String getNumeroMotor () {
        return NumeroMotor;
    }

    public void setNumeroMotor (String val) {
        this.NumeroMotor = val;
    }

    public byte getFotografia () {
        return fotografia;
    }

    public void setFotografia (byte val) {
        this.fotografia = val;
    }

    public int getIdAuto () {
        return idAuto;
    }

    public void setIdAuto (int val) {
        this.idAuto = val;
    }

    public String getMarca () {
        return marca;
    }

    public void setMarca (String val) {
        this.marca = val;
    }

    public String getModelo () {
        return modelo;
    }

    public void setModelo (String val) {
        this.modelo = val;
    }

    public String getPlacas () {
        return placas;
    }

    public void setPlacas (String val) {
        this.placas = val;
    }

    public String getTipoVehiculo () {
        return tipoVehiculo;
    }

    public void setTipoVehiculo (String val) {
        this.tipoVehiculo = val;
    }

}

