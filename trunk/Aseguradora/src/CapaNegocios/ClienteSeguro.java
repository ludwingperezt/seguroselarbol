package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteSeguro {

    private int idClienteSeguro;

    private int idAgente;

    private int idCliente;

    private int idContratoVida;

    private int idContratoAuto;

    private int idContratoHogar;

    public ClienteSeguro () {
    }

    public int getIdAgente () {
        return idAgente;
    }

    public void setIdAgente (int val) {
        this.idAgente = val;
    }

    public int getIdCliente () {
        return idCliente;
    }

    public void setIdCliente (int val) {
        this.idCliente = val;
    }

    public int getIdClienteSeguro () {
        return idClienteSeguro;
    }

    public void setIdClienteSeguro (int val) {
        this.idClienteSeguro = val;
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
    public static ArrayList<String> consultarSeguros(String idCliente) throws SQLException {
        ArrayList<String> seguros = new ArrayList<String>();
        String consulta = "select ContratoVida_idContratoVida, ContratoAuto_idContratoAuto,ContratoHogar_idContratoHogar WHERE idClienteSeguro="+idCliente+";";
        Connection cn = (Connection) Conexion.obtenerConexion();
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement(consulta);
        ResultSet rs =  ps.executeQuery();
        while(rs.next()){
            if (rs.getString(5)!="0")
                seguros.add(rs.getString(5));
            if (rs.getString(6)!="0")
                seguros.add(rs.getString(6));
            if (rs.getString(7)!="0")
                seguros.add(rs.getString(7));
        }
        return seguros;        
    }
}

