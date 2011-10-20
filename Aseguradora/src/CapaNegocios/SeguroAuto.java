package CapaNegocios;

import com.mysql.jdbc.Connection;
import CapaDatos.*;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeguroAuto {

    private int idSeguroAuto;

    private int tipoSeguro;

    private String descripcion;

    private double prima;

    private double couta;
    
    private int correlativo;
    
    private String serie;

    public SeguroAuto () {
    }

    public double getCouta () {
        return couta;
    }
    public String getSerie(){
        return this.serie;
    }
    public int getCorrelativo(){
        return this.correlativo;
    }

    public void setCouta (double val) {
        this.couta = val;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String val) {
        this.descripcion = val;
    }

    public int getIdSeguroAuto () {
        return idSeguroAuto;
    }

    public void setIdSeguroAuto (int val) {
        this.idSeguroAuto = val;
    }

    public double getPrima () {
        return prima;
    }

    public void setPrima (double val) {
        this.prima = val;
    }

    public int getTipoSeguro () {
        return tipoSeguro;
    }

    public void setTipoSeguro (int val) {
        this.tipoSeguro = val;
    }

    public void setSerie(String text) {
        this.serie = text;
    }

    public void setCorrelativo(int parseInt) {
        this.correlativo=parseInt;
    }

    public void insertarEnBaseDeDatos() throws SQLException {
        Connection con = (Connection) Conexion.obtenerConexion();        
        Statement st = (Statement) con.createStatement();
        String sentencia = "INSERT INTO SeguroAuto (TipoSeguro,Descripcion,Prima,Serie,Correlativo) VALUES ("
                +String.valueOf(this.tipoSeguro+1)+","
                +"'"+this.descripcion+"',"
                +String.valueOf(prima)+","
                +"'"+this.serie+"',"
                +String.valueOf(this.correlativo) +")";
        st.execute("LOCK TABLE SeguroAuto WRITE;");
        
        st.execute(sentencia);
        
        st.execute("UNLOCK TABLES;");
        st.close();
    }
    public static  SeguroAuto [] consultarListaSeguros() throws SQLException{
        ArrayList<SeguroAuto> lista = new ArrayList<SeguroAuto>();
        
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement st = (Statement) con.createStatement();
        String consulta = "SELECT idSeguroAuto,Descripcion FROM SeguroAuto";
        
        ResultSet rs = st.executeQuery(consulta);
        
        while (rs.next()){
            SeguroAuto i = new SeguroAuto();
            i.setIdSeguroAuto((Integer)rs.getObject(1));
            i.setDescripcion(rs.getString(2));
            lista.add(i);
        }
        
        SeguroAuto []a = new SeguroAuto[lista.size()];
        a = lista.toArray(a);
        return a;
    }

}

