/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varios;

import CapaDatos.Conexion;
import CapaNegocios.Cliente;
import CapaNegocios.ContratoHogar;
import CapaNegocios.ContratoVida;
import ModuloClientes.SeleccionarCliente;
import ModuloSeguros.SeleccionarPolizaSeguro;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HP G42
 */
public class VisualizadorReportes {
    
    //funcion para visualizar una nueva poliza de seguro de vida
    public static void mostrarReportePolizaSeguroVida(int idReporte){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reportePolizaVida.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("idContratoVida", idReporte); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //funcion para visualizar una nueva poliza de seguro de hogar
    public static void mostrarReportePolizaSeguroHogar(int idReporte){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reportePolizaHogar.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("idContratoHogar", idReporte); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //funcion para visualizar una nueva poliza de seguro de auto
    public static void mostrarReportePolizaSeguroAuto(int idReporte){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"PolizaSeguroAuto.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("idSeguro", idReporte); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //reporte de beneficiarios por cliente
    public static void mostrarReporteBeneficiariosPorCliente(){
        Cliente seleccionado;
        SeleccionarCliente ventana = new SeleccionarCliente(null,true);
        seleccionado = ventana.seleccionarCliente();
        int idCliente = seleccionado.getIdCliente();
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reporteBeneficiariosPorCliente.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("idCliente", idCliente); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //reporte de beneficiarios por seguro de vida
    public static void mostrarReporteBeneficiariosPorSeguroVida(){
        ContratoVida seleccionado;
        SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
        //seleccionado = (ContratoVida) sps.cargarSeguros(true);
        seleccionado = (ContratoVida) sps.cargarSeguros(SeleccionarPolizaSeguro.SELECCIONAR_POLIZAS_SEGURO_VIDA);
        String identificacion = seleccionado.getIdentificacion();
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reporteBeneficiariosPorSeguroVida.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("identificacion", identificacion); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte de beneficiarios por seguro de hogar
    public static void mostrarReporteBeneficiariosPorSeguroHogar(){
        ContratoHogar seleccionado;
        SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
        //seleccionado = (ContratoHogar) sps.cargarSeguros(false);
        seleccionado = (ContratoHogar) sps.cargarSeguros(SeleccionarPolizaSeguro.SELECCIONAR_POLIZAS_SEGURO_HOGAR);
        
        String identificacion = seleccionado.getIdentificacion();
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reporteBeneficiariosSeguroHogar.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("identificacion", identificacion); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mostrarReporteMarcasMasAseguradas(){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reporteMarcasMasAseguradas.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.            
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void desactivarSegurosVencidosHoy(){
        try {
            ContratoVida.desactivarSegurosVencidos();
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reportePolizasVencidasHoy.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.            
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void verSegurosAVencerProximosSieteDias(){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reporteVencimientosSemana.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.            
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mostrarReporteHistorialEntre(Date fecha1){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reporteHistorial.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("fecha", fecha1);
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.            
            if (visor.isAlwaysOnTopSupported())
                visor.setAlwaysOnTop(true);
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
