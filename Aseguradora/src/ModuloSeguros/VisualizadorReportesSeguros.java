/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguros;

import CapaDatos.Conexion;
import java.io.File;
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
public class VisualizadorReportesSeguros {
    
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
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportesSeguros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mostrarReportePolizaSeguroHogar(int idReporte){
        try {
            String direccionReporte = System.getProperty("user.dir")+File.separator+"reportesSeguros"+File.separator+"reportePolizaHogar.jasper"; //obtiene la direccion del fichero compilado del reporte. Este tiene extension .jasper y está en la carpeta del proyecto, en la subcarpeta reportesSeguros
            Map <String,Object> parametros = new HashMap<String,Object>(); //sirve para enviar los parámetros
            parametros.clear();
            parametros.put("idContratoHogar", idReporte); //la clave es el nombre del parámetro y el valor es el valor que se va enviar
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(direccionReporte); //se invoca al reporte
            JasperPrint visualizador = JasperFillManager.fillReport(reporte,parametros,Conexion.obtenerConexion()); //se llena el reporte con el reporte que se llamó, los parámetros que se le van a enviar y la conexion a la base de datos
            
            JasperViewer visor = new JasperViewer(visualizador,false); //esto es para visualizar el reporte.  es una ventana independiente.
            visor.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de visualización de reportes", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VisualizadorReportesSeguros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
