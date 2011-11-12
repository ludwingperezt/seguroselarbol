package CapaNegocios;

import CapaDatos.Conexion;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ContratoAuto {

    private int idContratoAuto;

    private int idSeguroAuto;

    private int idAuto;

    private String descripcion;

    private Date fechaContrato;

    private Date fechaPago;

    private Date año;

    private double mora;

    private double valor;

    private Date vencimiento;

    private int numeroPagos;

    private boolean activo;

    private double montoPagoSeguro;

    public ContratoAuto () {
    }

    public boolean getActivo () {
        return activo;
    }

    public void setActivo (boolean val) {
        this.activo = val;
    }

    public Date getAño () {
        return año;
    }

    public void setAño (Date val) {
        this.año = val;
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

    public int getIdAuto () {
        return idAuto;
    }

    public void setIdAuto (int val) {
        this.idAuto = val;
    }

    public int getIdContratoAuto () {
        return idContratoAuto;
    }

    public void setIdContratoAuto (int val) {
        this.idContratoAuto = val;
    }

    public int getIdSeguroAuto () {
        return idSeguroAuto;
    }

    public void setIdSeguroAuto (int val) {
        this.idSeguroAuto = val;
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

    public double getValor () {
        return valor;
    }

    public void setValor (double val) {
        this.valor = val;
    }

    public Date getVencimiento () {
        return vencimiento;
    }

    public void setVencimiento (Date val) {
        this.vencimiento = val;
    }

    public void insertarContraroAuto(SeguroAuto actualSeguro, Cliente actualCliente, Auto actual, ContratoAuto ca) throws SQLException {
       Connection con = (Connection) Conexion.obtenerConexion();

            
            PreparedStatement cmd = (PreparedStatement) con.prepareStatement("SELECT insersionNuevaPolizaAutoRetorno(?,?,?,?,?,?,?,?,?,?)");
            CallableStatement funcion;
            /*
             * 1 idSeguro int,
             * 2 idAuto int,
             * 3 descripcion varchar(45),
             * 4 FechaContrato date,
             * 5  fechapago date, 
             * 6 mora decimal,
             * 7  valor decimal, 
             * 8 vencimiento date, 
             * 9 pagos int,
             * 10 montoPago decimal)
             */
            cmd.setInt(1,  actualSeguro.getIdSeguroAuto());
            cmd.setInt(2, actual.getIdAuto());
            cmd.setString(3, descripcion);
            cmd.setDate(4, fechaContrato);
            cmd.setDate(5, fechaPago);
            cmd.setDouble(6, mora);
            cmd.setDouble(7, valor);
            cmd.setDate(8, vencimiento);
            cmd.setInt(9, numeroPagos);
            cmd.setDouble(10, montoPagoSeguro);
           
            if (cmd.execute()){
                ResultSet rs = cmd.getResultSet();
                boolean next = rs.next();
                int indexContrato = rs.getInt(1);
                this.idContratoAuto = indexContrato;
                //insertarTuplaSeguroAutoClienteSeguro(agente int, cliente int, contratoAuto int)
                funcion = (CallableStatement) con.prepareCall("{CALL insertarTuplaSeguroAutoClienteSeguro(?,?,?)}");
                funcion.setInt(1, aseguradora.AseguradoraView.idEmpleado);
                funcion.setInt(2, actualCliente.getIdCliente());
                funcion.setInt(3, indexContrato);
                boolean execute = funcion.execute();
            }  
       

    }

}

