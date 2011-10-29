package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ContratoVida {

    private int idContratoVida;

    private int idSeguroVida;

    private String descripcion;

    private String profesion;

    private Date fechaContrato;

    private Date fechaPago;

    private double mora;

    private Date vencimiento;

    private int numeroPagos;

    private boolean activo;

    private double montoPagoSeguro;

    public ContratoVida () {
    }

    public boolean getActivo () {
        return activo;
    }

    public void setActivo (boolean val) {
        this.activo = val;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String val) {
        this.descripcion = val;
    }

    public Date getFechaContrato () {
        return fechaContrato;
    }

    public void setFechaContrato (Date val) {
        this.fechaContrato = val;
    }

    public Date getFechaPago () {
        return fechaPago;
    }

    public void setFechaPago (Date val) {
        this.fechaPago = val;
    }

    public int getIdContratoVida () {
        return idContratoVida;
    }

    public void setIdContratoVida (int val) {
        this.idContratoVida = val;
    }

    public int getIdSeguroVida () {
        return idSeguroVida;
    }

    public void setIdSeguroVida (int val) {
        this.idSeguroVida = val;
    }

    public double getMontoPagoSeguro () {
        return montoPagoSeguro;
    }

    public void setMontoPagoSeguro (double val) {
        this.montoPagoSeguro = val;
    }

    public double getMora () {
        return mora;
    }

    public void setMora (double val) {
        this.mora = val;
    }

    public int getNumeroPagos () {
        return numeroPagos;
    }

    public void setNumeroPagos (int val) {
        this.numeroPagos = val;
    }

    public String getProfesion () {
        return profesion;
    }

    public void setProfesion (String val) {
        this.profesion = val;
    }

    public Date getVencimiento () {
        return vencimiento;
    }

    public void setVencimiento (Date val) {
        this.vencimiento = val;
    }

    public void insertarEnBaseDeDatos(Cliente clienteSeleccionado, SeguroVida seguroSeleccionado, ArrayList<Beneficiario> listaBeneficiariosNuevos,ArrayList<Beneficiario> listaBeneficiariosExistenetes) throws SQLException{

            Connection con = (Connection) Conexion.obtenerConexion();            
            Statement comando = (Statement) con.createStatement();            
            PreparedStatement cmd = (PreparedStatement) con.prepareStatement("SELECT insersionNuevaPolizaVidaRetorno(?,?,?,?,?,?,?,?,?)");
            
            CallableStatement funcion = (CallableStatement) con.prepareCall("{CALL insertarTuplaSeguroVidaClienteSeguro(?,?,?)}");
            
        try {            
            cmd.setInt(1,seguroSeleccionado.getIdSeguroVida());
            cmd.setString(2, this.getDescripcion());
            cmd.setString(3, this.profesion);
            cmd.setDate(4, this.fechaContrato);
            cmd.setDate(5, this.fechaPago);
            cmd.setDouble(6, this.mora);
            cmd.setDate(7, this.vencimiento);
            cmd.setInt(8, this.numeroPagos);
            cmd.setDouble(9, this.montoPagoSeguro);
            //insertarTuplaSeguroVidaClienteSeguro-agente int, cliente int, contratoVida int
   
            boolean execute = comando.execute("Begin;");  //inicia la transaccion
            
            execute = cmd.execute(); //ejecuta la llamada a la funcion de insersión de contrato vida            
            ResultSet rs = cmd.getResultSet(); //obtene el resultado de la consulta
            execute = rs.next();
            this.setIdContratoVida(rs.getInt(1)); //ese resultado lo almacena en una variable, es el id del ultimo registro insertado
            
            funcion.setInt(1, aseguradora.AseguradoraView.idEmpleado);
            funcion.setInt(2, clienteSeleccionado.getIdCliente());
            funcion.setInt(3,this.idContratoVida);
            
            for (Beneficiario i:listaBeneficiariosNuevos){
                CallableStatement insertarBeneficiario = (CallableStatement) con.prepareCall("{CALL insertarBeneficiarioSeguroVida(?,?,?,?,?,?,?,?)}");
                i.setIdContratoVida(this.idContratoVida);
                insertarBeneficiario.setInt(1, this.idContratoVida);
                insertarBeneficiario.setString(2, i.getDPI());
                insertarBeneficiario.setString(3, i.getNombres());
                insertarBeneficiario.setString(4, i.getApellidos());
                insertarBeneficiario.setDate(5, i.getFechaNacimiento());
                insertarBeneficiario.setString(6, i.getDireccion());
                insertarBeneficiario.setString(7, i.getTelefono());
                insertarBeneficiario.setString(8, i.getCelular());
                execute = insertarBeneficiario.execute();
                
            }
            
            for (Beneficiario j:listaBeneficiariosExistenetes){
                /*
                 * IMPORTANTISIMO: AQUI SE HACE UNA INSERSIÓN A UNA TABLA INTERMEDIA ENTRE SEGURO Y BENEFICIARIO, YA NO HACIA BENEFICIARIO, PORQUE ÉSTE YA EXISTE
                 */
                String consulta = "INSERT INTO SeguroVidaBeneficiarios (Beneficiarios_idBeneficiarios,ContratoVida_idContratoVida) VALUES ("+j.getIdBeneficiario()+","+this.idContratoVida+")";
                execute = comando.execute(consulta);
            }
            
            execute = funcion.execute(); //ejecuta la llamada al procedimiento que inserta la tupla en la tabla cliente-seguro            
            execute = comando.execute("commit;");  //termina la transacción         
            
            funcion.close();
            comando.close();
            cmd.close();
            
        } catch (SQLException ex) {
            boolean execute = comando.execute("rollback;");
            Logger.getLogger(ContratoVida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

