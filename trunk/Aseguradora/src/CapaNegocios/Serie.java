package CapaNegocios;

import java.sql.Date;
import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Serie {

    private int idSerie;

    private String serie;

    private int maximo;

    private int actual;

    private Date fechaCreacion;

    private Date fechaVencimiento;

    private boolean activa;

    public Serie () {
    }

    public boolean getActiva () {
        return activa;
    }

    public void setActiva (boolean val) {
        this.activa = val;
    }

    public int getActual () {
        return actual;
    }

    public void setActual (int val) {
        this.actual = val;
    }

    public Date getFechaCreacion () {
        return fechaCreacion;
    }

    public void setFechaCreacion (Date val) {
        this.fechaCreacion = val;
    }

    public Date getFechaVencimiento () {
        return fechaVencimiento;
    }

    public void setFechaVencimiento (Date val) {
        this.fechaVencimiento = val;
    }

    public int getIdSerie () {
        return idSerie;
    }

    public void setIdSerie (int val) {
        this.idSerie = val;
    }

    public int getMaximo () {
        return maximo;
    }

    public void setMaximo (int val) {
        this.maximo = val;
    }

    public String getSerie () {
        return serie;
    }

    public void setSerie (String val) {
        this.serie = val;
    }
    public ArrayList<String>  getSeries()  throws SQLException{
        ArrayList<String> acumuladas = new ArrayList<String>();
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet resultado=st.executeQuery("select * from serie where activo=1");
        while(resultado.next()){
            acumuladas.add(resultado.getString(2));
        }
        return acumuladas;
    }
    public int getCorrelativoD(String serie) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        int correlativo;
        ResultSet rs=st.executeQuery("SELECT MAX(Correlativo) FROM serie WHERE serie like '"+serie+"'");
        correlativo =rs.getInt(4); 
        return (correlativo);
    }
    public void setNuevo(String ser,int maximo,int actual,Date fc, Date fv){
        this.activa=true;
        this.actual=actual;
        this.fechaCreacion=fc;
        this.fechaVencimiento=fv;
        this.maximo=maximo;
        this.serie=ser;
    }
    public int getUltimoId() throws SQLException{
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        int correlativo;
        ResultSet rs=st.executeQuery("SELECT COUNT() FROM serie");
        correlativo =rs.getInt(1); 
        return (correlativo+1);   
    }

    public void nuevaSerie1(String serie, int maximo, int actual, java.util.Date fechaC, java.util.Date fechaV) throws SQLException {
        Connection con = (Connection) Conexion.obtenerConexion();
            java.sql.PreparedStatement comandos = con.prepareStatement("LOCK TABLE Auto WRITE;");
            comandos.execute();
            String cadena = "INSERT INTO Serie (Serie, Maximo, actual, FechaCreacion, FechaVencimiento, Activo) VALUES ("
                    +"'"+this.serie+"',"
                    +"'"+this.maximo+"',"
                    +"'"+this.actual+"',"
                    +"'"+this.fechaCreacion+"',"
                    +"'"+this.fechaVencimiento+"',"
                    +"'"+this.activa+"',"
                    +"?)";
            comandos = con.prepareStatement(cadena);
            comandos.execute();
            ResultSet rs = comandos.executeQuery();
            rs.next();
            comandos = con.prepareStatement("UNLOCK TABLES;");
            comandos.close();
    }
    
    }
    






