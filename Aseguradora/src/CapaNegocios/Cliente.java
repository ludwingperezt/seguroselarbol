package CapaNegocios;

//import java.util.*;
import CapaDatos.Conexion;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void setFechaNacimiento (String val) {
        this.fechaNacimiento = Date.valueOf(val);
    }
    public int getIdCliente () {
        return idCliente;
    }

    public void setIdCliente (int val) {
        this.idCliente = val;
    }
    public void llenarCliente(int id) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM CLIENTE WHERE id="+id);
        this.setIdCliente(rs.getInt("IdCliente"));
        this.setDPI(rs.getString("DPI"));
        this.setNIT(rs.getString("NIT"));
        this.setNombres(rs.getString("Nombres"));
        this.setApellidos(rs.getString("Apellidos"));
        this.setDireccion(rs.getString("Direccion("));
        this.setTelefono(rs.getString("Telefono"));
        this.setCelular(rs.getString("Celular"));
        this.setFechaNacimiento(rs.getString("Celular"));
        this.setEdad(rs.getInt("Edad"));
    }
    
    public ResultSet obtenerClientes(int id) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM CLIENTE");
        return rs;
    }
    
    public ResultSet obtenerCliente(int id) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM CLIENTE WHERE DPI like '"+id+"'");
        return rs;
    }
    
    
    public ResultSet obtenerCliente(String DPI) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM CLIENTE WHERE DPI like '"+DPI+"'");
        return rs;
    }
    
    
    public boolean setCliente() throws SQLException
    {
        try {
            Statement st=(Statement) Conexion.iniciarConexion().createStatement();
            st.executeUpdate("INSERT INTO Cliente VALUES (null, "+this.getDPI()+", "+this.getNIT()+", "+this.getNombres()+", "+this.getApellidos()+", "+
                    this.getDireccion()+", "+this.getTelefono()+", "+this.getCelular()+", "+this.getFechaNacimiento().toString()+", "+this.getEdad()+")");
            Conexion.obtenerConexion().commit();
        } catch (SQLException ex) {
            Conexion.obtenerConexion().rollback();
            return false;
        }
        Conexion.obtenerConexion().close();
        return true;
    }
}

