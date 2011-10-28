package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SeguroHogar {

    private int idSeguroHogar;

    private int tipoSeguro;

    private String descripcion;

    private double prima;

    private double couta;
    
    private int correlativo;
    
    private String serie;

    public SeguroHogar () {
    }

    public double getCouta () {
        return couta;
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

    public int getIdSeguroHogar () {
        return idSeguroHogar;
    }

    public void setIdSeguroHogar (int val) {
        this.idSeguroHogar = val;
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
    public String getSerie(){
        return this.serie;
    }
    public int getCorrelativo(){
        return this.correlativo;
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
        //idSeguroVida, TipoSeguro, Descripcion, Prima, Serie, Correlativo
        String sentencia = "INSERT INTO SeguroHogar (TipoSeguro,Descripcion,Prima,Serie,Correlativo) VALUES ("
                +String.valueOf(this.tipoSeguro+1)+","
                +"'"+this.descripcion+"',"
                +String.valueOf(prima)+","
                +"'"+this.serie+"',"
                +String.valueOf(this.correlativo) +")";
        st.execute("LOCK TABLE SeguroidaHogar WRITE;");
        
        st.execute(sentencia);
        
        st.execute("UNLOCK TABLES;");
        st.close();
    }
    public static  SeguroHogar [] consultarListaSegurosHogar() throws SQLException{
        ArrayList<SeguroHogar> lista = new ArrayList<SeguroHogar>();
        
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement st = (Statement) con.createStatement();
        String consulta = "SELECT idSeguroHogar,Descripcion FROM SeguroHogar";
        
        ResultSet rs = st.executeQuery(consulta);
        
        while (rs.next()){
            SeguroHogar i = new SeguroHogar();
            i.setIdSeguroHogar((Integer)rs.getObject(1));
            i.setDescripcion(rs.getString(2));
            lista.add(i);
        }
        
        SeguroHogar []a = new SeguroHogar[lista.size()];
        a = lista.toArray(a);
        return a;
    }
    
    //TipoSeguro, Descripcion, Prima, Serie, Correlativo

}

