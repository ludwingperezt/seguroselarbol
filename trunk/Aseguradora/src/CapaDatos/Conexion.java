/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDatos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    //private static String baseDatos = "seguroselarbol";
    //private static String usuario = "root";
    //private static String password = "";
    //private static String nombreServidor = "localhost";
    
    //private static String direccionServidor = "jdbc:mysql://ROLANDO-PC/"+baseDatos;
    
    private static Connection conexionDB = null;
    
    public static Connection iniciarConexion(){
        try {
            conexionDB =null;
            
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

        } catch (SQLException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
               
        return conexionDB;
        
    }
    public static Connection obtenerConexion()
    {
        try {
            if (conexionDB.isClosed()){
                return Conexion.iniciarConexion();
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
