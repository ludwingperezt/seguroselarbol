package CapaNegocios;

//import java.util.*;
import CapaDatos.Conexion;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ResultSet rs=st.executeQuery("SELECT * FROM CLIENTE WHERE ID like '"+id+"'");
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
        Statement st=(Statement) con.createStatement();
        try {
            st.execute("begin");
            String w="INSERT INTO Cliente VALUES (null, "+this.getDPI()+", '"+this.getNIT()+"', '"+this.getNombres()+"', '"+this.getApellidos()+"', '"+
                    this.getDireccion()+"', '"+this.getTelefono()+"', '"+this.getCelular()+"', '"+this.getFechaNacimiento().toString()+"', "+
                    this.getEdad()+");";
            st.execute(w);
        } catch (SQLException ex) {
            st.execute("Rollback;");
            System.out.println("rollback");
            return false;
        }
        System.out.println("commit");
        st.execute("Commit;");
        st.close();
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
        con.setAutoCommit(false);
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        try {            
            st.execute("Begin");
            st.execute("UPDATE Cliente SET DPI="+this.getDPI()+", NIT='"+this.getNIT()+"', Nombres='"+this.getNombres()+"', Apellidos='"+this.getApellidos()+
                    "', Direccion='"+this.getDireccion()+"', Telefono='"+this.getTelefono()+"', Celular='"+this.getCelular()+
                    "',FechaNacimiento='"+this.getFechaNacimiento().toString()+"', edad="+this.getEdad()+" WHERE idCliente="+this.getIdCliente()+";");
        } catch (SQLException ex) {
            st.execute("Rollback;");
            System.out.println("rollback");
            return false;
        }
        System.out.println("commit");
        st.execute("commit;");
        con.close();
        return true;
    }
    public void obtenerClienteDPI(String DPI) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM CLIENTE WHERE DPI like '"+DPI+"'");
        this.setIdCliente(rs.getInt(1));
        this.setNIT(rs.getString(3));
        this.setNombres(rs.getString(4));
        this.setApellidos(rs.getString(5));
        this.setDireccion(rs.getString(6));
        this.setTelefono(rs.getString(7));
        this.setCelular(rs.getString(8));
        this.setFechaNacimiento(rs.getDate(9));
        this.setEdad(rs.getInt(10));
    }
}

