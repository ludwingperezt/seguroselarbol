package CapaNegocios;

import CapaDatos.Conexion;
import aseguradora.FacturaF;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
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
    public void consultarSeguros(int idCliente) throws SQLException {
        DefaultTableModel dfm=new DefaultTableModel();
        dfm.addColumn("Id Seguro");
        dfm.addColumn("Fecha Pago");
        dfm.addColumn("Mora");
        dfm.addColumn("Monto Pago");
        dfm.addColumn("Tipo Seguro");
        Object insert[]=new Object[5];
        ArrayList<ContratoAuto> ls = new ArrayList<ContratoAuto>();
        int[] segurosVida = new int[20];
        int[] segurosAuto = new int[20];
        int[] segurosHogar = new int[20];
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "select * FROM ClienteSeguro WHERE idClienteSeguro="+idCliente+";";
        Statement query = (Statement) con.createStatement();
        ResultSet rs = query.executeQuery(consulta);
        int x=0,y=0,z=0;
        while(rs.next()){
            if (rs.getString(4)!=null){
                segurosVida[x]= rs.getInt(4);
                x++;}
            if (rs.getString(5)!=null){
                segurosAuto[y]=rs.getInt(5);
                y++;}
            if (rs.getString(6)!=null){
                segurosHogar[z]=rs.getInt(6);
            z++;}
        }
        int valor=0;
        ResultSet rs1 = null,rs2 = null,rs3 = null;
       for (int a=0;a<x;a++){
           valor=segurosVida[a];
           consulta = "select * FROM ContratoVida WHERE idContratoVida="+valor+" and activo="+1+";";
           query = (Statement) con.createStatement();
           rs1 = query.executeQuery(consulta);
       }
       for (int a=0;a<y;a++){
           valor=segurosAuto[a];
           consulta = "select * FROM ContratoAuto WHERE idContratoAuto="+valor+" and activo="+1+";";
           query = (Statement) con.createStatement();
           rs2 = query.executeQuery(consulta);
       }
       for (int a=0;a<z;a++){
           valor=segurosHogar[a];
           consulta = "select * FROM ContratoHogar WHERE idContratoHogar="+valor+" and activo="+1+";";
           query = (Statement) con.createStatement();
           rs3 = query.executeQuery(consulta);
       }
       int id;
       double mor,mont;
       Date ft;
       if(x>0){
        while(rs1.next()){
            id=rs1.getInt(2);
            ft=rs1.getDate(6);
            mor=rs1.getDouble(8);
            mont=rs1.getDouble(12);
            insert[0]=id;
            insert[1]=ft;
            insert[2]=mor;
            insert[3]=mont;
            insert[4]="Seguro Vida";
            }
        }
       if (y>0){
        while(rs2.next()){
            id=rs1.getInt(2);
            ft=rs1.getDate(6);
            mor=rs1.getDouble(8);
            mont=rs1.getDouble(12);
            insert[0]=id;
            insert[1]=ft;
            insert[2]=mor;
            insert[3]=mont;
            insert[4]="Seguro Auto";}
        }
       if(z>0){
        while(rs3.next()){
            id=rs1.getInt(2);
            ft=rs1.getDate(6);
            mor=rs1.getDouble(8);
            mont=rs1.getDouble(12);
            insert[0]=id;
            insert[1]=ft;
            insert[2]=mor;
            insert[3]=mont;
            insert[4]="Seguro Hogar";}
        }
        dfm.addRow(insert);
        ContratoAuto [] lista = new ContratoAuto[ls.size()];
        lista = ls.toArray(lista);
        FacturaF.jTable1.setModel(dfm); 
    }
}

