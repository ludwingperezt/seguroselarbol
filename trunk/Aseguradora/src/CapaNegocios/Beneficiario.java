package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Beneficiario extends Cliente {

    private int idBeneficiario;

    private int idContratoVida;

    private int idContratoHogar;

    public Beneficiario () {
    }

    public int getIdBeneficiario () {
        return idBeneficiario;
    }

    public void setIdBeneficiario (int val) {
        this.idBeneficiario = val;
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
    
    public void insertarBeneficiarioBaseDatos() throws SQLException{
        //hay que arreglar esto!!!!!!!!!!!!!!!!! hay que crear una tabla intermedia entre Beneficiarios y ContratoVida, por ahora queda asi
        Connection con = (Connection) Conexion.obtenerConexion();
        PreparedStatement insertarBeneficiario = (PreparedStatement)con.prepareStatement("INSERT INTO Beneficiarios (ContratoVida_idContratoVida,DPI, Nombres,Apellidos, FechaNacimiento, Direccion, Telefono, Celular) values (?,?,?,?,?,?,?,?)");
        insertarBeneficiario.setInt(1, this.idContratoVida);
        insertarBeneficiario.setString(2, DPI);
        insertarBeneficiario.setString(3, Nombres);
        insertarBeneficiario.setString(4, Apellidos);
        insertarBeneficiario.setDate(5, fechaNacimiento);
        insertarBeneficiario.setString(6, Direccion);
        insertarBeneficiario.setString(7, Telefono);
        insertarBeneficiario.setString(8, Celular);
        
        boolean ex = insertarBeneficiario.execute();
        insertarBeneficiario.close();
    }
    
    public static Beneficiario[] listaBeneficiarios() throws SQLException{
        Beneficiario [] lista;
        ArrayList<Beneficiario> ls = new ArrayList<Beneficiario>();
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement cmd = (Statement) con.createStatement();
        String consulta = "SELECT distinct idBeneficiarios,DPI,Nombres,Apellidos, FechaNacimiento, Direccion, Telefono, Celular FROM Beneficiarios";
        
        ResultSet rs = cmd.executeQuery(consulta);

        while (rs.next()){
            Beneficiario bf = new Beneficiario();
            bf.setIdBeneficiario(rs.getInt(1));
            bf.setDPI(rs.getString(2));
            bf.setNombres(rs.getString(3));
            bf.setApellidos(rs.getString(4));
            ls.add(bf);
        }
        cmd.close();
        lista = new Beneficiario[ls.size()];
        lista = ls.toArray(lista);
        return lista;
    }
    public static Beneficiario[] listaCortaBeneficiarios() throws SQLException{
        Beneficiario [] lista;
        ArrayList<Beneficiario> ls = new ArrayList<Beneficiario>();
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement cmd = (Statement) con.createStatement();
        String consulta = "SELECT distinct idBeneficiarios,DPI,Nombres,Apellidos FROM Beneficiarios";
        
        ResultSet rs = cmd.executeQuery(consulta);

        while (rs.next()){
            Beneficiario bf = new Beneficiario();
            bf.setIdBeneficiario(rs.getInt(1));
            bf.setDPI(rs.getString(2));
            bf.setNombres(rs.getString(3));
            bf.setApellidos(rs.getString(4));
            ls.add(bf);
        }
        cmd.close();
        lista = new Beneficiario[ls.size()];
        lista = ls.toArray(lista);
        return lista;
    }
}

