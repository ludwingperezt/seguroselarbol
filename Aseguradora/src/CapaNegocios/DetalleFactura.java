package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;


public class DetalleFactura {

    private int idDetalleRecibo;

    private int idRecibo;

    private int idContratoAuto;

    private int idContratoVida;

    private int idContratoHogar;

    private int subtotal;

    public DetalleFactura () {
    }

    public int getIdContratoAuto () {
        return idContratoAuto;
    }

    public void setIdContratoAuto (int val) {
        this.idContratoAuto = val;
    }

    public int getIdContratoHogar () {
        return idContratoHogar;
    }

    public void setIdContratoHogar (int val) {
        this.idContratoHogar = val;
    }

    public int getIdContratoVida () {
        return idContratoVida;
    }

    public void setIdContratoVida (int val) {
        this.idContratoVida = val;
    }

    public int getIdDetalleRecibo () {
        return idDetalleRecibo;
    }

    public void setIdDetalleRecibo (int val) {
        this.idDetalleRecibo = val;
    }

    public int getIdRecibo () {
        return idRecibo;
    }

    public void setIdRecibo (int val) {
        this.idRecibo = val;
    }

    public int getSubtotal () {
        return subtotal;
    }

    public void setSubtotal (int val) {
        this.subtotal = val;
    }

    public void insertarNuevoDetalle(DetalleFactura detalle) throws SQLException{
        Connection con = (Connection) Conexion.iniciarConexion();
        java.sql.PreparedStatement comandos = con.prepareStatement("LOCK TABLE DetalleFactura WRITE;");
        comandos.execute();
         String cadena = "INSERT INTO DetalleFactura (Recibo_idRecibo, ContratoAuto_idContratoAuto, ContratoVida_idContratoVida, ContratoHogar_idContratoHogar, subtotal) VALUES ("
                    +"'"+this. idRecibo+"',"
                    +"'"+this.idContratoAuto+"',"
                    +"'"+this.idContratoVida+"',"
                    +"'"+this.idContratoHogar+"',"
                    +"'"+this.subtotal+"'"
                    +")";
         comandos = con.prepareStatement(cadena);
         comandos.execute();
         comandos = con.prepareStatement("UNLOCK TABLES;");
         comandos.close();
    }    
        public void insertarHistorialSeguro(DetalleFactura detalle, Date fecha, Time hora, String anotacion, int idagente, int idcliente) throws SQLException{
        Connection con = (Connection) Conexion.iniciarConexion();
        java.sql.PreparedStatement comandos = con.prepareStatement("LOCK TABLE HistorialSeguro WRITE;");
        comandos.execute();
         String cadena = "INSERT INTO HistorialSeguro (Anotacion, Fecha, Hora, idSeguroVida, idSeguroHogar, idSeguroAuto, Agente_idAgente, Cliente_idCliente) VALUES ("
                    +"'"+anotacion+"',"
                    +"'"+fecha+"',"
                    +"'"+hora+"',"
                    +"'"+this.idContratoVida+"',"
                    +"'"+this.idContratoHogar+"',"
                    +"'"+this.idContratoAuto+"',"
                    +"'"+idagente+"',"
                    +"'"+idcliente+"',"
                    +")";
         comandos = con.prepareStatement(cadena);
         comandos.execute();
         comandos = con.prepareStatement("UNLOCK TABLES;");
         comandos.close();
    }
}

