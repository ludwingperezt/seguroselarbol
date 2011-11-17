package CapaNegocios;

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


public class Auto {

    
    private int idAuto;

    private String tipoVehiculo;

    private String marca;

    private String modelo;

    private String placas;

    private String NumeroMotor;

    private String NumeroChasis;

    private String Color;

    private int Ejes;

    private File fotografia = null;

    public Auto () {
    }

    public String getColor () {
        return Color;
    }

    public void setColor (String val) {
        this.Color = val;
    }

    public int getEjes () {
        return Ejes;
    }

    public void setEjes (int val) {
        this.Ejes = val;
    }

    public String getNumeroChasis () {
        return NumeroChasis;
    }

    public void setNumeroChasis (String val) {
        this.NumeroChasis = val;
    }

    public String getNumeroMotor () {
        return NumeroMotor;
    }

    public void setNumeroMotor (String val) {
        this.NumeroMotor = val;
    }

    public File getFotografia () {
        return fotografia;
    }

    public void setFotografia (File val) {
        this.fotografia = val;
    }

    public int getIdAuto () {
        return idAuto;
    }

    public void setIdAuto (int val) {
        this.idAuto = val;
    }

    public String getMarca () {
        return marca;
    }

    public void setMarca (String val) {
        this.marca = val;
    }

    public String getModelo () {
        return modelo;
    }

    public void setModelo (String val) {
        this.modelo = val;
    }

    public String getPlacas () {
        return placas;
    }

    public void setPlacas (String val) {
        this.placas = val;
    }

    public String getTipoVehiculo () {
        return tipoVehiculo;
    }

    public void setTipoVehiculo (String val) {
        this.tipoVehiculo = val;
    }
    public Auto insertarAutoEnBD() throws FileNotFoundException, IOException, SQLException {
        if (fotografia==null){
            String dirTemp = System.getProperty("user.dir")+File.separator+"imagenes"+File.separator+"nf.jpg";
            fotografia = new File(dirTemp);
        }
        FileInputStream bf = null;
        Auto nuevo = this;
        Connection con = (Connection) Conexion.obtenerConexion();
        bf = new FileInputStream(fotografia);
        java.sql.PreparedStatement comandos = con.prepareStatement("ROLLBACK");
        
        try{    
                
                comandos.execute();
                comandos.execute("LOCK TABLE Auto WRITE");
                String cadena = "INSERT INTO Auto (TipoVehiculo, Marca, Modelo, Placas, NumeroMotor, NumeroChasis, Color, NumeroEjes, Fotografia) VALUES ("
                        +"'"+this.tipoVehiculo+"',"
                        +"'"+this.marca+"',"
                        +"'"+this.modelo+"',"
                        +"'"+this.placas+"',"
                        +"'"+this.NumeroMotor+"',"
                        +"'"+this.NumeroChasis+"',"
                        +"'"+this.Color+"',"
                        +"'"+Integer.toString(this.Ejes)+"',"
                        +"?)";
                comandos = con.prepareStatement(cadena);
                comandos.setBlob(1, bf);
                comandos.execute();
                comandos = con.prepareStatement("SELECT max(idAuto) FROM Auto");
                ResultSet rs = comandos.executeQuery();
                rs.next();
                this.idAuto = rs.getInt(1);
                comandos = con.prepareStatement("UNLOCK TABLES");
                comandos.execute();
                comandos.execute("COMMIT");
                comandos.close();
                
                bf.close();
                nuevo = this;
                
        }
        catch (SQLException ex){
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            comandos.execute("ROLLBACK");
            nuevo = null;
        }
            return nuevo;
    }
    
    public static Auto[] consultarAutoPorCliente(Cliente actualCliente) throws SQLException {
        ArrayList<Auto> ls = new ArrayList<Auto>();
        
        String consulta = "select distinct idAuto,TipoVehiculo,Marca,Modelo,Placas from ClienteSeguro as cs inner join ContratoAuto as ca on cs.ContratoAuto_idContratoAuto = ca.idContratoAuto inner join Auto as a on a.idAuto = ca.Auto_idAuto where cs.Cliente_idAgente = ? and cs.ContratoAuto_idContratoAuto is not null;";
        
        Connection cn = (Connection) Conexion.obtenerConexion();
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement(consulta);
        ps.setInt(1, actualCliente.getIdCliente());
        ResultSet rs =  ps.executeQuery();
        
        while(rs.next()){
            Auto x = new Auto();
            x.setIdAuto(rs.getInt(1));
            x.setTipoVehiculo(rs.getString(2));
            x.setMarca(rs.getString(3));
            x.setModelo(rs.getString(4));
            x.setPlacas(rs.getString(5));
            ls.add(x);
        }
        Auto [] lista = new Auto[ls.size()];
        lista = ls.toArray(lista);
        return lista;        
    }
    
    public static Auto[] consultarTodosLosAutos() throws SQLException{
        ArrayList<Auto> ls = new ArrayList<Auto>();
        
        String consulta = "select distinct idAuto,TipoVehiculo,Marca,Modelo,Placas from auto";
        
        Connection cn = (Connection) Conexion.obtenerConexion();
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement(consulta);
        ResultSet rs =  ps.executeQuery();
        
        while(rs.next()){
            Auto x = new Auto();
            x.setIdAuto(rs.getInt(1));
            x.setTipoVehiculo(rs.getString(2));
            x.setMarca(rs.getString(3));
            x.setModelo(rs.getString(4));
            x.setPlacas(rs.getString(5));
            ls.add(x);
        }
        Auto [] lista = new Auto[ls.size()];
        lista = ls.toArray(lista);
        return lista;        
    }


}

