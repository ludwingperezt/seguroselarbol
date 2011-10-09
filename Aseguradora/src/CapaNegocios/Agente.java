package CapaNegocios;


public class Agente {

    private int idAgente;

    private String DPI;

    private String NIT;

    private String Nombre;

    private String Direccion;

    private String Telefono;

    private String Celular;

    private double Comision;

    private double sueldoBase;

    private String usuario;

    private int nivelAcceso;

    private boolean activo;

    private byte fotografia;

    public Agente () {
    }

    public String getCelular () {
        return Celular;
    }

    public void setCelular (String val) {
        this.Celular = val;
    }

    public double getComision () {
        return Comision;
    }

    public void setComision (double val) {
        this.Comision = val;
    }

    public String getDPI () {
        return DPI;
    }

    public void setDPI (String val) {
        this.DPI = val;
    }

    public String getDireccion () {
        return Direccion;
    }

    public void setDireccion (String val) {
        this.Direccion = val;
    }

    public String getNIT () {
        return NIT;
    }

    public void setNIT (String val) {
        this.NIT = val;
    }

    public String getNombre () {
        return Nombre;
    }

    public void setNombre (String val) {
        this.Nombre = val;
    }

    public String getTelefono () {
        return Telefono;
    }

    public void setTelefono (String val) {
        this.Telefono = val;
    }

    public boolean getActivo () {
        return activo;
    }

    public void setActivo (boolean val) {
        this.activo = val;
    }

    public byte getFotografia () {
        return fotografia;
    }

    public void setFotografia (byte val) {
        this.fotografia = val;
    }

    public int getIdAgente () {
        return idAgente;
    }

    public void setIdAgente (int val) {
        this.idAgente = val;
    }

    public int getNivelAcceso () {
        return nivelAcceso;
    }

    public void setNivelAcceso (int val) {
        this.nivelAcceso = val;
    }

    public double getSueldoBase () {
        return sueldoBase;
    }

    public void setSueldoBase (double val) {
        this.sueldoBase = val;
    }

    public String getUsuario () {
        return usuario;
    }

    public void setUsuario (String val) {
        this.usuario = val;
    }

}

