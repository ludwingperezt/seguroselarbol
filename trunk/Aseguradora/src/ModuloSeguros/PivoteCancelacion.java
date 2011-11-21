/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguros;

import CapaNegocios.Cliente;
import CapaNegocios.ContratoAuto;
import CapaNegocios.ContratoHogar;
import CapaNegocios.ContratoVida;
import ModuloClientes.SeleccionarCliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP G42
 */
public class PivoteCancelacion {
    
    public static void cancelarSeguro(){
        int categoriaPoliza = JOptionPane.showOptionDialog(null, "Seleccione el tipo de seguro que desea cancelar", "Seleccionar categoría", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Seguro de Hogar","Seguro de Vida","Seguro de Automovil"}, "Seguro de Hogar");
        int tipoBusquedaSeguro;
        if (categoriaPoliza==0){ //se seleccionó seguro de hogar
            tipoBusquedaSeguro = JOptionPane.showOptionDialog(null, 
                    "Seleccione el tipo de búsqueda del seguro a cancelar",
                    "Seleccionar tipo de búsqueda", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, 
                    new Object[] {"Obtener lista de pólizas por cliente","Seleccionar una póliza de la lista de seguros"}, "Obtener lista de pólizas por cliente");
            if (tipoBusquedaSeguro!=-1){
                PivoteCancelacion.mostradoYSeleccionPolizaSeguroHogar(tipoBusquedaSeguro);
            }
        }
        else if (categoriaPoliza==1){ //se seleccionó seguro de vida
            tipoBusquedaSeguro = JOptionPane.showOptionDialog(null, 
                    "Seleccione el tipo de búsqueda del seguro a cancelar",
                    "Seleccionar tipo de búsqueda", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, 
                    new Object[] {"Obtener lista de pólizas por cliente","Seleccionar una póliza de la lista de seguros"}, "Obtener lista de pólizas por cliente");
            if (tipoBusquedaSeguro!=-1){
                PivoteCancelacion.mostradoYSeleccionPolizaSeguroVida(tipoBusquedaSeguro);
            }
        }
        else if (categoriaPoliza==2){ //se seleccionó seguro de auto
            tipoBusquedaSeguro = JOptionPane.showOptionDialog(null, 
                    "Seleccione el tipo de búsqueda del seguro a cancelar",
                    "Seleccionar tipo de búsqueda", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, 
                    new Object[] {"Obtener lista de pólizas por cliente","Seleccionar una póliza de la lista de seguros"}, "Obtener lista de pólizas por cliente");
            if (tipoBusquedaSeguro!=-1){
                PivoteCancelacion.mostradoYSeleccionPolizaSeguroAuto(tipoBusquedaSeguro);
            }
        }
        
    }
    
    public static void mostradoYSeleccionPolizaSeguroHogar(int tipoBusqueda){
        if (tipoBusqueda==0){ 
                try {
                //obtener lista de seguros por cliente (solo seguros no vencidos)
                    SeleccionarCliente sc = new SeleccionarCliente(null, true);
                    Cliente cl = sc.seleccionarCliente();
                    SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                    ContratoHogar ch = (ContratoHogar) sps.cargarSegurosHogarActivosPorCliente(cl);
                    String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                    ch.cancelarPoliza(razonCancelacion);
                } catch (SQLException ex) {
                    //Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if (tipoBusqueda==1){ 
            try {
                //mostrar lista con todos los seguros
                SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                ContratoHogar ch = (ContratoHogar) sps.cargarSeguros(SeleccionarPolizaSeguro.SELECCIONAR_POLIZAS_SEGURO_HOGAR);
                String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                ch.cancelarPoliza(razonCancelacion);
            } catch (SQLException ex) {
                //Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    public static void mostradoYSeleccionPolizaSeguroVida(int tipoBusqueda){
        if (tipoBusqueda==0){ 
                try {
                //obtener lista de seguros por cliente (solo seguros no vencidos)
                    SeleccionarCliente sc = new SeleccionarCliente(null, true);
                    Cliente cl = sc.seleccionarCliente();
                    SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                    ContratoVida cv = (ContratoVida) sps.cargarSegurosVidaActivosPorCliente(cl);
                    String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                    cv.cancelarPoliza(razonCancelacion);
                } catch (SQLException ex) {
                    //Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if (tipoBusqueda==1){ 
            try {
                //mostrar lista con todos los seguros
                SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                ContratoVida cv = (ContratoVida) sps.cargarSeguros(SeleccionarPolizaSeguro.SELECCIONAR_POLIZAS_SEGURO_VIDA);
                String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                cv.cancelarPoliza(razonCancelacion);
            } catch (SQLException ex) {
                //Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void mostradoYSeleccionPolizaSeguroAuto(int tipoBusqueda){
        if (tipoBusqueda==0){ 
                try {
                //obtener lista de seguros por cliente (solo seguros no vencidos)
                    SeleccionarCliente sc = new SeleccionarCliente(null, true);
                    Cliente cl = sc.seleccionarCliente();
                    SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                    ContratoAuto ca = (ContratoAuto) sps.cargarSegurosAutoActivosPorCliente(cl);
                    String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                    ca.cancelarPoliza(razonCancelacion);
                } catch (SQLException ex) {
                    //Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if (tipoBusqueda==1){ 
            try {
                //mostrar lista con todos los seguros
                SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                ContratoAuto ca = (ContratoAuto) sps.cargarSeguros(SeleccionarPolizaSeguro.SELECCIONAR_POLIZAS_SEGURO_AUTO);
                String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                ca.cancelarPoliza(razonCancelacion);
            } catch (SQLException ex) {
                //Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void cancelarSeguroVida(){
        try {
            SeleccionarCliente sc = new SeleccionarCliente(null, true);
            Cliente cl = sc.seleccionarCliente();            
            if (cl!=null){
                    SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                    ContratoVida cv = (ContratoVida) sps.cargarSegurosVidaActivosPorCliente(cl);
                    if (cv!=null){
                        String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                        cv.cancelarPoliza(razonCancelacion);
                    }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void cancelarSeguroHogar(){
        try {
            SeleccionarCliente sc = new SeleccionarCliente(null, true);
            Cliente cl = sc.seleccionarCliente();
            if (cl!=null){
                SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                ContratoHogar ch = (ContratoHogar) sps.cargarSegurosHogarActivosPorCliente(cl);
                if (ch!=null){
                    String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                    ch.cancelarPoliza(razonCancelacion);
                }                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void cancelarSeguroAuto(){
        try{
            SeleccionarCliente sc = new SeleccionarCliente(null, true);
            Cliente cl = sc.seleccionarCliente();
            if (cl!=null){
                SeleccionarPolizaSeguro sps = new SeleccionarPolizaSeguro(null, true);
                ContratoAuto ca = (ContratoAuto) sps.cargarSegurosAutoActivosPorCliente(cl);
                if (ca!=null){
                    String razonCancelacion = JOptionPane.showInputDialog(null, "Ingrese la razón de la cancelación del seguro", "Razón", JOptionPane.QUESTION_MESSAGE);
                    ca.cancelarPoliza(razonCancelacion);
                }
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PivoteCancelacion.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
}
