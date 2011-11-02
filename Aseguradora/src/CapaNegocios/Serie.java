package CapaNegocios;

import java.sql.Date;
import java.sql.ResultSet;
import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ResultSet rs=st.executeQuery("SELECT MAX(Correlativo) FROM FACTURA WHERE serie like '"+serie+"'");
        correlativo =rs.getInt(4); 
        return (correlativo);
    }
    




}

