package CapaNegocios;

//import java.util.*;
import java.sql.Date;

public class Cliente {

    private int idCliente;

    private String DPI;

    private String NIT;

    private String Nombres;

    private String Apellidos;

    private String Direccion;

    private String Telefono;

    private String Celular;

    private Date fechaNacimiento;

    private int edad;

    public Cliente () {
    }

    public String getApellidos () {
        return Apellidos;
    }

    public void setApellidos (String val) {
        this.Apellidos = val;
    }

    public String getCelular () {
        return Celular;
    }

    public void setCelular (String val) {
        this.Celular = val;
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

    public String getNombres () {
        return Nombres;
    }

    public void setNombres (String val) {
        this.Nombres = val;
    }

    public String getTelefono () {
        return Telefono;
    }

    public void setTelefono (String val) {
        this.Telefono = val;
    }

    public int getEdad () {
        return edad;
    }

    public void setEdad (int val) {
        this.edad = val;
    }

    public Date getFechaNacimiento () {
        return fechaNacimiento;
    }

    public void setFechaNacimiento (Date val) {
        this.fechaNacimiento = val;
    }

    public int getIdCliente () {
        return idCliente;
    }

    public void setIdCliente (int val) {
        this.idCliente = val;
    }

}

