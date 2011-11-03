package CapaNegocios;

//import java.util.*;
import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    
    protected int idCliente;

    protected String DPI;

    protected String NIT;

    protected String Nombres;

    protected String Apellidos;

    protected String Direccion;

    protected String Telefono;

    protected String Celular; //"INSERT INTO Beneficiarios (ContratoVida_idContratoVida,DPI, Nombres, Apellidos, FechaNacimiento, Direccion, Telefono, Celular) values ("

    protected Date fechaNacimiento;

    protected int edad;

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

    public void setFechaNacimiento (java.util.Date val) {
        this.fechaNacimiento = new Date(val.getTime());
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
    
    
    public boolean guardarCliente() throws SQLException
    {
        java.sql.Connection con=Conexion.iniciarConexion();
        try {
            con.setAutoCommit(false);
            Statement st=(Statement) con.createStatement();
            String w="INSERT INTO Cliente VALUES (null, "+this.getDPI()+", '"+this.getNIT()+"', '"+this.getNombres()+"', '"+this.getApellidos()+"', '"+
                    this.getDireccion()+"', '"+this.getTelefono()+"', '"+this.getCelular()+"', '"+this.getFechaNacimiento().toString()+"', "+this.getEdad()+")";
            st.executeUpdate(w);
            Conexion.obtenerConexion().commit();
        } catch (SQLException ex) {
            con.rollback();
            return false;
        }
        con.commit();
        con.close();
        return true;
    }
    
    public static Cliente[] consultarListaClientes() throws SQLException {
        Cliente[] lista;
        ArrayList<Cliente> ls = new ArrayList<Cliente>();
        java.sql.Connection  con =  Conexion.iniciarConexion();
        Statement cmd = (Statement) con.createStatement();
        String consulta = "SELECT * FROM Cliente";
        
        ResultSet rs = cmd.executeQuery(consulta);
        
        while(rs.next()){
            Cliente x = new Cliente();
            x.setIdCliente(rs.getInt(1));
            x.setDPI(rs.getString(2));
            x.setNIT(rs.getString(3));
            x.setNombres(rs.getString(4));
            x.setApellidos(rs.getString(5));
            x.setDireccion(rs.getString(6));
            x.setTelefono(rs.getString(7));
            x.setCelular(rs.getString(8));
            x.setFechaNacimiento(rs.getString(9));
            x.edad=rs.getInt(10);
            ls.add(x);
        }
        
        lista = new Cliente[ls.size()];
        lista = ls.toArray(lista);        
        return lista;
    }
    @Override
    public String toString()
    {
        return this.getNombres();
    }

    public boolean modificar() throws SQLException {
        java.sql.Connection con=Conexion.iniciarConexion();
        try {            
            con.setAutoCommit(false);
            Statement st=(Statement) Conexion.iniciarConexion().createStatement();
            st.executeUpdate("UPDATE Cliente SET (null, "+this.getDPI()+", "+this.getNIT()+", "+this.getNombres()+", "+this.getApellidos()+", "+
                    this.getDireccion()+", "+this.getTelefono()+", "+this.getCelular()+", "+this.getFechaNacimiento().toString()+", "+
                    this.getEdad()+") WHERE idCliente="+this.getIdCliente());
            Conexion.obtenerConexion().commit();
        } catch (SQLException ex) {
            con.rollback();
            return false;
        }
        con.commit();
        con.close();
        return true;
    }
}

