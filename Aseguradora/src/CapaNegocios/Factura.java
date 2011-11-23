package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Factura {

    private int idFactura;

    private int idAgente;

    private int idSerie;

    private int correlativo;

    private Date fecha;

    private double descuento;

    private double total;

    public Factura () {
    }

    public int getCorrelativo () {
        return correlativo;
    }

    public void setCorrelativo (int val) {
        this.correlativo = val;
    }

    public double getDescuento () {
        return descuento;
    }

    public void setDescuento (double val) {
        this.descuento = val;
    }

    public Date getFecha () {
        return fecha;
    }

    public void setFecha (Date val) {
        this.fecha = val;
    }

    public int getIdAgente () {
        return idAgente;
    }

    public void setIdAgente (int val) {
        this.idAgente = val;
    }

    public int getIdFactura () {
        return idFactura;
    }

    public void setIdFactura (int val) {
        this.idFactura = val;
    }

    public int getIdSerie () {
        return idSerie;
    }

    public void setIdSerie (int val) {
        this.idSerie = val;
    }

    public double getTotal () {
        return total;
    }

    public void setTotal (double val) {
        this.total = val;
    }
    public void insertarFactura() throws SQLException{
        Connection con = (Connection) Conexion.iniciarConexion();
        java.sql.PreparedStatement comandos = con.prepareStatement("LOCK TABLE Factura WRITE;");
        comandos.execute();
         String cadena = "INSERT INTO Factura (Cliente_idAgente, Serie_idSerie, correlativo, descuento, total) VALUES ("
                    +"'"+this.idAgente+"',"
                    +"'"+this.idSerie+"',"
                    +"'"+this.correlativo+"',"
                    +"'"+this.descuento+"',"
                    +"'"+this.total+"'"
                    +");";
         comandos = con.prepareStatement(cadena);
         comandos.execute();
         comandos = con.prepareStatement("UNLOCK TABLES;");
         comandos.close();
    }
    public void setidFactura() throws SQLException{
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "select * FROM ClienteSeguro WHERE Serie_idSerie="+this.getIdSerie()+" and Correlativo="+this.getCorrelativo()+";";
        Statement query = (Statement) con.createStatement();
        ResultSet rs = query.executeQuery(consulta);
        this.setIdFactura(rs.getInt(1));
    }


}

