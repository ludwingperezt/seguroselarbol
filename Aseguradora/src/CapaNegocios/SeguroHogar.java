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
    
    private int correlativo;
    
    private String serie;

    public SeguroHogar () {
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
        st.execute("LOCK TABLE SeguroHogar WRITE;");
        
        st.execute(sentencia);
        
        st.execute("UNLOCK TABLES;");
        st.close();
    }
     
     
    public void modificar() throws SQLException {
        Connection con = (Connection) Conexion.obtenerConexion();        
        Statement st = (Statement) con.createStatement();
        //idSeguroVida, TipoSeguro, Descripcion, Prima, Serie, Correlativo
        String sentencia = "UPDATE SeguroHogar SET TipoSeguro='" +String.valueOf(this.tipoSeguro+1)+
                "', Descripcion='" +this.descripcion+"',Prima='" +String.valueOf(prima)+"',Serie='"+this.serie+"',Correlativo='"    
                +String.valueOf(this.correlativo) +"' where idSeguroHogar="+String.valueOf(this.getIdSeguroHogar())+";";        
        st.executeUpdate(sentencia);
        st.close();
    }
     
    public static  SeguroHogar [] consultarListaSegurosHogar() throws SQLException{
        ArrayList<SeguroHogar> lista = new ArrayList<SeguroHogar>();
        
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement st = (Statement) con.createStatement();
        String consulta = "SELECT DISTINCT idSeguroHogar, TipoSeguro, Descripcion, Prima, Serie, Correlativo FROM SeguroHogar";
        
        ResultSet rs = st.executeQuery(consulta);
        
        while (rs.next()){
            SeguroHogar i = new SeguroHogar();
            i.setIdSeguroHogar(rs.getInt(1));
            i.setTipoSeguro(rs.getInt(2));
            i.setDescripcion(rs.getString(3));
            i.setPrima(rs.getDouble(4));
            i.setSerie(rs.getString(5));
            i.setCorrelativo(rs.getInt(6));
            lista.add(i);
        }
        
        SeguroHogar []a = new SeguroHogar[lista.size()];
        a = lista.toArray(a);
        return a;
    }
    
    public static SeguroHogar consultarDatosSeguro(int idSeguroBuscado) throws SQLException{
        String ret = null;
        SeguroHogar sh = null;
        String consulta = "SELECT Descripcion,Prima FROM seguroHogar WHERE idSeguroHogar = "+Integer.toString(idSeguroBuscado);
        
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement st = (Statement) con.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        
        if (rs.next()){
            sh = new SeguroHogar();
            sh.idSeguroHogar = idSeguroBuscado;
            sh.descripcion = rs.getString(1);
            sh.prima = rs.getDouble(2);
            ret = rs.getString(1);
        }
        rs.close();
        st.close();
        return sh;
    }
    //TipoSeguro, Descripcion, Prima, Serie, Correlativo

}

