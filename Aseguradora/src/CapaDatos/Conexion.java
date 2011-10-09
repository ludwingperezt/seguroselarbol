/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDatos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP G42
 */
public class Conexion {
    private static String baseDatos = "aseguradora";
    private static String usuario = "root";
    private static String password = "";
    private static String direccionServidor = "jdbc:mysql://localhost/"+baseDatos;
    private static String nombreServidor = "localhost";
    private static Connection conexionDB = null;
    
    public static String iniciarConexion(){
        String bandera;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conexionDB = DriverManager.getConnection(direccionServidor, usuario, password);

            MysqlDataSource origenDatos = new MysqlDataSource();
            origenDatos.setDatabaseName(baseDatos);
            origenDatos.setUser(usuario);
            origenDatos.setPassword(password);
            origenDatos.setServerName(nombreServidor);
            conexionDB = origenDatos.getConnection();
            bandera="Conexion establecida con la base de datos";

        } catch (Exception ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            bandera = ex.getMessage();
        }
        return bandera;
    }
    public static Connection obtenerConexion()
    {
        double jjj;
        Date djdj;
        
        return conexionDB;
    }

}
