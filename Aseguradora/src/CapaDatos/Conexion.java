/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDatos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP G42
 */
public class Conexion {
    private static String baseDatos = "seguroselarbol";
    private static String usuario = "elArbol";
    private static String password = "seguros";
    private static String nombreServidor = "ROLANDO-PC";

    //private static String direccionServidor = "jdbc:mysql://ROLANDO-PC/"+baseDatos;
    
    private static Connection conexionDB = null;
    
    public static Connection iniciarConexion(){
        conexionDB =null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conexionDB = DriverManager.getConnection(direccionServidor, usuario, password);
            MysqlDataSource origenDatos = new MysqlDataSource();
            origenDatos.setDatabaseName(baseDatos);
            origenDatos.setUser(usuario);
            origenDatos.setPassword(password);
            origenDatos.setServerName(nombreServidor);
            System.out.println("Conexion establecida con la base de datos");
            conexionDB = origenDatos.getConnection();
            //bandera="Conexion establecida con la base de datos";

        } catch (Exception ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //bandera = ex.getMessage();
        }
        return conexionDB;
    }
    public static Connection obtenerConexion()
    {
        return conexionDB;
    }
    public static void cambiarStringConexion(String servidor, String usuario, String pass, String baseDatos){
        Conexion.nombreServidor=servidor;
        Conexion.baseDatos=baseDatos;
        Conexion.usuario=usuario;
        Conexion.password=pass;
        
        Connection con = Conexion.iniciarConexion();
    }

}
