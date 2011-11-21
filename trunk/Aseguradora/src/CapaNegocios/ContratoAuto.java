package CapaNegocios;

import CapaDatos.Conexion;
import aseguradora.AseguradoraView;
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
import javax.swing.JOptionPane;
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
    
    private Cliente cliente=null;
    
    private String identificacion;

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
        Statement bloqueo = (Statement) con.createStatement();
        PreparedStatement cmd = (PreparedStatement) con.prepareStatement("SELECT insersionNuevaPolizaAutoRetorno(?,?,?,?,?,?,?,?,?,?)");
        CallableStatement funcion;
        try {
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
            //bloqueo.execute("ROLLBACK");
            //bloqueo.execute("LOCK TABLE ContratoAuto WRITE");
            ResultSet rs = cmd.executeQuery();          
            boolean next = rs.next();
            int indexContrato = rs.getInt(1);
            this.idContratoAuto = indexContrato;
            //bloqueo.execute("UNLOCK TABLES");
            //insertarTuplaSeguroAutoClienteSeguro(agente int, cliente int, contratoAuto int)
            funcion = (CallableStatement) con.prepareCall("{CALL insertarTuplaSeguroAutoClienteSeguro(?,?,?)}");
            funcion.setInt(1, aseguradora.AseguradoraView.idEmpleado);
            funcion.setInt(2, actualCliente.getIdCliente());
            funcion.setInt(3, indexContrato);
            boolean execute = funcion.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoAuto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

    }

    public String getIdentificacion() {
        return this.identificacion;
    }
    public void setIdentificacion(String id){
        this.identificacion = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente unCliente){
        this.cliente = unCliente;
    }
    
    public static ContratoAuto[] listaPolizasAuto() throws SQLException {
        
        ArrayList<ContratoAuto> lista = new ArrayList<ContratoAuto>();
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "select "
                + "ca.idContratoAuto,"                
                + "ca.Identificacion, "
                + "ca.Descripcion,"
                + "c.IdCliente,"
                + "c.DPI,"
                + "c.NIT,"
                + "c.Nombres,"
                + "c.Apellidos"
                + "from ContratoAuto as ca "
                + "inner join ClienteSeguro as cs on ca.idContratoAuto = cs.ContratoAuto_idContratoAuto "
                + "inner join Cliente as c on c.idCliente = cs.Cliente_idAgente";      
        
        Statement query = (Statement) con.createStatement();
        
        ResultSet rs = query.executeQuery(consulta);
        
        while (rs.next()){
            ContratoAuto i = new ContratoAuto();
            Cliente ci = new Cliente();            
            i.setIdContratoAuto(rs.getInt(1));
            i.setIdentificacion(rs.getString(2));
            i.setDescripcion(rs.getString(3));
            ci.setIdCliente(rs.getInt(4));
            ci.setDPI(rs.getString(5));
            ci.setNIT(rs.getString(6));
            ci.setNombres(rs.getString(7));
            ci.setApellidos(rs.getString(8));

            i.setCliente(ci);            
            lista.add(i);
        }      
        ContratoAuto [] ls = new ContratoAuto[lista.size()];
        ls = lista.toArray(ls);
        return ls;
    }
    
    public void completarDatos() throws SQLException{
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "select "
                + "ca.idContratoAuto,"
                + "ca.SeguroAuto_idSeguroAuto,"
                + "ca.Auto_idAuto,"
                + "ca.Identificacion, "
                + "ca.Descripcion,"
                + "ca.FechaContrato,"
                + "ca.FechaPago,"
                + "ca.Año,"
                + "ca.Mora,"
                + "ca.Valor,"
                + "ca.Vencimiento,"
                + "ca.NumeroPagos,"
                + "ca.MontoPagoSeguro,"
                + "c.IdCliente,"
                + "c.DPI,"
                + "c.NIT,"
                + "c.Nombres,"
                + "c.Apellidos,"
                + "c.Direccion,"
                + "c.Telefono,"
                + "c.Celular,"
                + "c.FechaNacimiento,"
                + "c.Edad "
                + "from ContratoAuto as ca "
                + "inner join ClienteSeguro as cs on ca.idContratoAuto = cs.ContratoAuto_idContratoAuto "
                + "inner join Cliente as c on c.idCliente = cs.Cliente_idAgente "
                + "WHERE ca.idContratoAuto = "
                + Integer.toString(this.getIdContratoAuto());      
        
        Statement query = (Statement) con.createStatement();
        
        ResultSet rs = query.executeQuery(consulta);
        
        Cliente ci = null;
        while (rs.next()){
            
            ci = new Cliente();            
            this.setIdContratoAuto(rs.getInt(1));
            this.setIdSeguroAuto(rs.getInt(2));
            this.setIdAuto(rs.getInt(3));
            this.setIdentificacion(rs.getString(4));
            this.setDescripcion(rs.getString(5));
            this.setFechaContrato(rs.getDate(6));
            this.setFechaPago(rs.getDate(7));
            this.setAño(rs.getDate(8));
            this.setMora(rs.getDouble(9));
            this.setValor(rs.getDouble(10));
            this.setVencimiento(rs.getDate(11));
            
            this.setNumeroPagos(rs.getInt(12));
            this.setMontoPagoSeguro(rs.getDouble(13));

            ci.setIdCliente(rs.getInt(14));
            ci.setNIT(rs.getString(15));
            ci.setDPI(rs.getString(16));
            ci.setNombres(rs.getString(17));
            ci.setApellidos(rs.getString(18));
            ci.setDireccion(rs.getString(19));
            ci.setTelefono(rs.getString(20));
            ci.setCelular(rs.getString(21));
            ci.setFechaNacimiento(rs.getDate(22));
            ci.setEdad(rs.getInt(23));

        }      
        this.setCliente(ci);
    }
    
    public static void desactivarSegurosVencidos() throws SQLException{
        Connection con  = (Connection) Conexion.obtenerConexion();
        CallableStatement cs = (CallableStatement) con.prepareCall("{CALL desactivarSegurosVencidos()}");
        boolean execute = cs.execute();
        cs.close();
    }
    
    public static ContratoAuto[] polizasPorCliente(Cliente unCliente) throws SQLException {
        ArrayList<ContratoAuto> lista = new ArrayList<ContratoAuto>();
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "SELECT CA.idContratoAuto, "
                + "CA.Identificacion,"
                + "CA.Descripcion "
                + "FROM ContratoAuto AS CA "
                + "INNER JOIN ClienteSeguro as CS on CS.ContratoAuto_idContratoAuto = CA.idContratoAuto "
                + "INNER JOIN Cliente AS Cl on CS.Cliente_idAgente = Cl.idCliente WHERE "
                + "Cl.idCliente = "+Integer.toString(unCliente.getIdCliente());
        
        Statement query = (Statement) con.createStatement();
        
        ResultSet rs = query.executeQuery(consulta);
        
        while (rs.next()){
            ContratoAuto i = new ContratoAuto();          
            i.setIdContratoAuto(rs.getInt(1));
            i.setIdentificacion(rs.getString(2));
            i.setDescripcion(rs.getString(3));
            i.setCliente(unCliente);            
            lista.add(i);
        }      
        ContratoAuto [] ls = new ContratoAuto[lista.size()];
        ls = lista.toArray(ls);
        return ls;
    }
    public void cancelarPoliza(String razonCancelacion) throws SQLException {
        String consulta = "UPDATE ContratoAuto SET Activo = 0 WHERE idContratoAuto = "+Integer.toString(this.idContratoAuto);
        Connection con = (Connection) Conexion.obtenerConexion();
        Statement st = (Statement) con.createStatement();
        st.executeUpdate(consulta);
        ///idHistorialSeguro, Anotacion, Fecha, Hora, idSeguroVida, idSeguroHogar, idSeguroAuto, Agente_idAgente, Cliente_idCliente
        consulta = "INSERT INTO HistorialSeguro (Anotacion, Fecha, Hora, idSeguroAuto, Agente_idAgente, Cliente_idCliente) "
                + "VALUES ("
                + "'"+razonCancelacion+"',"
                + "CURDATE(),"
                + "CURTIME(),"
                + Integer.toString(this.idContratoAuto)+","
                + Integer.toString(AseguradoraView.idEmpleado)+","
                + Integer.toString(this.cliente.getIdCliente())
                + ")";
        st.execute(consulta);
        st.close();
    }

    public void renovar() {
        try{
            String consulta = "UPDATE ContratoAuto "
                    + "SET Activo = 1, "
                    + "FechaContrato = ?,"
                    + "Descripcion = ?,"
                    + "FechaPago = ?,"
                    + "Año = ? ,"
                    + "Mora = ?,"
                    + "Valor = ?,"
                    + "Vencimiento = ?,"
                    + "NumeroPagos = ?,"
                    + "MontoPagoSeguro = ? "
                    + "WHERE idContratoAuto = "+Integer.toString(this.idContratoAuto);
            Connection con = (Connection) Conexion.obtenerConexion();
            Statement st = (Statement) con.createStatement();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(consulta);
            //st.executeUpdate(consulta);
            ///idHistorialSeguro, Anotacion, Fecha, Hora, idSeguroVida, idSeguroHogar, idSeguroAuto, Agente_idAgente, Cliente_idCliente
            ps.setDate(1, this.fechaContrato);
            ps.setString(2, this.descripcion);
            ps.setDate(3, this.fechaPago);
            ps.setDate(4, this.año);
            ps.setDouble(5, mora);
            ps.setDouble(6, valor);
            ps.setDate(7, vencimiento);
            ps.setInt(8, numeroPagos);
            ps.setDouble(9, montoPagoSeguro);

            boolean execute = ps.execute();

            consulta = "INSERT INTO HistorialSeguro (Anotacion, Fecha, Hora, idSeguroAuto, Agente_idAgente, Cliente_idCliente) "
                    + "VALUES ("
                    + "'Póliza de seguro de auto renovada',"
                    + "CURDATE(),"
                    + "CURTIME(),"
                    + Integer.toString(this.idContratoAuto)+","
                    + Integer.toString(AseguradoraView.idEmpleado)+","
                    + Integer.toString(this.cliente.getIdCliente())
                    + ")";
            st.execute(consulta);
            st.close();
            ps.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static ContratoAuto[] polizasActivasPorCliente(Cliente unCliente) throws SQLException {
        ArrayList<ContratoAuto> lista = new ArrayList<ContratoAuto>();
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "SELECT CA.idContratoAuto, "
                + "CA.Identificacion,"
                + "CA.Descripcion "
                + "FROM ContratoAuto AS CA "
                + "INNER JOIN ClienteSeguro as CS on CS.ContratoAuto_idContratoAuto = CA.idContratoAuto "
                + "INNER JOIN Cliente AS Cl on CS.Cliente_idAgente = Cl.idCliente WHERE "
                + "CA.Activo = 1 AND Cl.idCliente = "+Integer.toString(unCliente.getIdCliente());
        
        Statement query = (Statement) con.createStatement();
        
        ResultSet rs = query.executeQuery(consulta);
        
        while (rs.next()){
            ContratoAuto i = new ContratoAuto();          
            i.setIdContratoAuto(rs.getInt(1));
            i.setIdentificacion(rs.getString(2));
            i.setDescripcion(rs.getString(3));
            i.setCliente(unCliente);            
            lista.add(i);
        }      
        ContratoAuto [] ls = new ContratoAuto[lista.size()];
        ls = lista.toArray(ls);
        return ls;
    }
    public static ContratoAuto[] polizasNoActivasPorCliente(Cliente unCliente) throws SQLException {
        ArrayList<ContratoAuto> lista = new ArrayList<ContratoAuto>();
        Connection con = (Connection) Conexion.obtenerConexion();
        String consulta = "SELECT CA.idContratoAuto, "
                + "CA.Identificacion,"
                + "CA.Descripcion "
                + "FROM ContratoAuto AS CA "
                + "INNER JOIN ClienteSeguro as CS on CS.ContratoAuto_idContratoAuto = CA.idContratoAuto "
                + "INNER JOIN Cliente AS Cl on CS.Cliente_idAgente = Cl.idCliente WHERE "
                + "CA.Activo = 0 AND Cl.idCliente = "+Integer.toString(unCliente.getIdCliente());
        
        Statement query = (Statement) con.createStatement();
        
        ResultSet rs = query.executeQuery(consulta);
        
        while (rs.next()){
            ContratoAuto i = new ContratoAuto();          
            i.setIdContratoAuto(rs.getInt(1));
            i.setIdentificacion(rs.getString(2));
            i.setDescripcion(rs.getString(3));
            i.setCliente(unCliente);            
            lista.add(i);
        }      
        ContratoAuto [] ls = new ContratoAuto[lista.size()];
        ls = lista.toArray(ls);
        return ls;
    }
    
}

