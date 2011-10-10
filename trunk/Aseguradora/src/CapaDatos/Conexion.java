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
    private static String baseDatos = "seguroselarbol";
    private static String usuario = "seguroselarbol";
    private static String password = "seguroselarbol";
    private static String direccionServidor = "jdbc:mysql://www.freesql.org/"+baseDatos;
    private static String nombreServidor = "www.freesql.org";
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
        return conexionDB;
    }

}
