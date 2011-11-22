package CapaNegocios;

import CapaDatos.Conexion;
import Utilidades.Criptografia;
import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.sql.rowset.serial.SerialBlob;

public class Agente {

    
/**
     * administrador 1
     * agente 2
     * cajero 3
     * invitado 4
     */
    private int idAgente;

    private String DPI;

    private String NIT;

    private String Nombre;

    private String Direccion;

    private String Telefono;

    private String Celular;

    private double Comision;

    private double sueldoBase;

    private String usuario;

    private byte[] Contraseña;

    private int nivelAcceso;

    private int activo;

    private File fotografia;
    
    private Image foto;

    public Agente () {
    }

    public String getCelular () {
        return Celular;
    }

    public void setCelular (String val) {
        this.Celular = val;
    }

    public double getComision () {
        return Comision;
    }

    public void setComision (double val) {
        this.Comision = val;
    }

    public String getDPI () {
        return DPI;
    }

    public void setDPI (String val) {
        this.DPI = val;
    }

    public String getDireccion () {
        return Direccion;
    }

    public void setDireccion (String val) {
        this.Direccion = val;
    }

    public String getNIT () {
        return NIT;
    }

    public void setNIT (String val) {
        this.NIT = val;
    }

    public String getNombre () {
        return Nombre;
    }

    public void setNombre (String val) {
        this.Nombre = val;
    }

    public String getTelefono () {
        return Telefono;
    }

    public void setTelefono (String val) {
        this.Telefono = val;
    }

    public int getActivo () {
        return activo;
    }

    public void setActivo (int val) {
        this.activo = val;
    }

    public Image getFotografia () {
        return foto;
    }

    public void setFotografia (File val) {
        this.fotografia = val;
    }
    
    public void setFotografia (byte[] val) throws IOException {
        
        this.foto = getImage(val, false);
    }
    
    public int getIdAgente () {
        return idAgente;
    }

    public void setIdAgente (int val) {
        this.idAgente = val;
    }

    public int getNivelAcceso () {
        return nivelAcceso;
    }

    public void setNivelAcceso (int val) {
        this.nivelAcceso = val;
    }

    public double getSueldoBase () {
        return sueldoBase;
    }

    public void setSueldoBase (double val) {
        this.sueldoBase = val;
    }

    public String getUsuario () {
        return usuario;
    }

    public void setUsuario (String val) {
        this.usuario = val;
    }
    public byte[] getContraseña () {
        return Contraseña;
    }

    public void setContraseña (String val) {
        try {
            this.Contraseña = Criptografia.obtenerCodigoHash(val);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarAgente(int id) throws SQLException, IOException
    {
        Statement st= Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM AGENTE WHERE idAgente="+id);
        rs.first();
        this.setIdAgente(rs.getInt("idAgente"));
        this.setDPI(rs.getString("DPI"));
        this.setNIT(rs.getString("NIT"));
        this.setNombre(rs.getString("Nombre"));
        this.setDireccion(rs.getString("Direccion"));
        this.setTelefono(rs.getString("Telefono"));
        this.setCelular(rs.getString("Celular"));
        this.setComision(rs.getInt("Comision"));
        this.setSueldoBase(rs.getInt("SueldoBase"));
        this.setUsuario(rs.getString("Usuario"));
        //this.Contraseña=rs.getString("Contraseña"); //NO SE GUARDARÁ LA CONTRASEÑA EN EL OBJETO!
        this.setActivo(rs.getInt("Activo"));
        this.setNivelAcceso(rs.getInt("NivelAcceso"));
        byte[] img = rs.getBytes("Fotografia");
        foto=getImage(img, false);        
        

    }

     public boolean guardarAgente() throws SQLException, FileNotFoundException
    {
        Connection conn=Conexion.obtenerConexion();
        conn.setAutoCommit(false);
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO Agente VALUES (null, '"+
                this.getDPI()+"', '"+this.getNIT()+"', '"+this.getNombre()+"', '"+
                this.getDireccion()+"', '"+this.getTelefono()+"', '"+this.getCelular()+"', '"+
                this.getComision()+"', '"+this.getSueldoBase()+"', ?,'"+this.getUsuario()+"',?,'"+
                this.getNivelAcceso()+"','"+this.getActivo()+"');");
        try {
            FileInputStream fis = new FileInputStream(fotografia);
            ps.setBinaryStream(1, fis, (int) fotografia.length());
            ps.setBlob(2, new SerialBlob(Contraseña));
            ps.execute();
            ResultSet rs = ps.executeQuery("Select max(idAgente) from agente");            
            rs.next();
            int index = rs.getInt(1);
            this.setIdAgente(index);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            return false;
        }
        return true;
    }

      public ResultSet activagente(String DPI) throws SQLException
    {
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM AGENTE WHERE DPI like '"+DPI+"'");
        return rs;
    }

    public void activaagente() throws SQLException {
       throw new UnsupportedOperationException("Not yet implemented");
    //Statement st=(Statement) Conexion.iniciarConexion().createStatement();
      //  ResultSet rs=st.executeQuery("SELECT * FROM AGENTE WHERE DPI like '"+DPI+"'");
      //  return rs;
    }

    public void buscaruno(String DPI) throws SQLException {
        //throw new UnsupportedOperationException("Not yet implemented");
        Statement st=(Statement) Conexion.iniciarConexion().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM AGENTE WHERE DPI like '"+DPI+"'");
        //return rs;
    }
    
    public boolean login (String usuario, String pass)throws SQLException, IOException 
    {
        Connection conn = Conexion.obtenerConexion();
        Statement st = conn.createStatement();
        ResultSet rs=st.executeQuery("select * from agente where usuario like '"+usuario+"';");
        if  (rs.first())
        {
            byte[] passw=rs.getBytes("contraseña");
            byte[] pass2 = null;
            try {
                pass2 = Criptografia.obtenerCodigoHash(pass);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean iwales=true;
            if (passw.length==pass2.length){
                for (int i =0; i<passw.length;i++)
                    if (pass2[i]!=passw[i]){
                        iwales=false;
                        break;
                    }
            }
            else
                iwales=false;
            
            if (iwales){
                this.llenarAgente(Integer.valueOf(rs.getObject("idAgente").toString()));
                return true;
            }
        }
        return false;
    }
    
    public void buscar()  throws SQLException {
        throw new UnsupportedOperationException("Not yet implemented");
         //Agente[] lista;

        //ArrayList<Agente> ls = new ArrayList<Agente>();
        //Connection con = (Connection) Conexion.obtenerConexion();
        //Statement cmd = (Statement) con.createStatement();
        //String consulta = "SELECT idClienteSeguro, idAgente, idCliente, idContratoVida, idContratoHogar, idContratoAuto FROM ClienteSeguro";

        //ResultSet rs = cmd.executeQuery(consulta);

        //while(rs.next()){
          //  Agente x = new Agente();
            //x.setidClienteSeguro(rs.getInt(1));
            //x.setidAgente(rs.getInt(2));
            //x.setidCliente(rs.getInt(3));
            //x.setidContratoVida(rs.getInt(4));
            //x.setidContratoHogar(rs.getInt(5));
            //x.setidContratoAuto(rs.getInt(6));
        //    ls.add(x);
        // }

        //lista = new Agente[ls.size()];
        //lista = ls.toArray(lista);
        //return lista;
    }
    
    
    public static boolean existeUsuario(String usuario) throws SQLException {
        Connection cn = Conexion.obtenerConexion();
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM AGENTE WHERE Usuario like '"+usuario+"';");
        return rs.first();
    }
    
    
    public static Image getImage(byte[] bytes, boolean isThumbnail) {
        if (bytes!=null){                
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
            ImageReader reader = (ImageReader) readers.next();
            Object source = bis; // File or InputStream
            ImageInputStream iis;
            try {
                iis = ImageIO.createImageInputStream(source);
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();
                if (isThumbnail) {
                    param.setSourceSubsampling(4, 4, 0, 0);
                    return reader.read(0, param);
                }
            } catch (IOException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
     public static Agente[] consultarListaAgentes() throws SQLException, IOException {
        Agente[] lista;
        ArrayList<Agente> ls = new ArrayList<Agente>();
        java.sql.Connection  con =  Conexion.obtenerConexion();
        Statement cmd = (Statement) con.createStatement();
        String consulta = "SELECT * FROM Agente";
        
        ResultSet rs = cmd.executeQuery(consulta);
        
        while(rs.next()){
            Agente x = new Agente();
            x.setIdAgente(rs.getInt(1));
            x.setDPI(rs.getString(2));
            x.setNIT(rs.getString(3));
            x.setNombre(rs.getString(4));
            x.setDireccion(rs.getString(5));
            x.setTelefono(rs.getString(6));
            x.setCelular(rs.getString(7));
            x.setComision(rs.getDouble(8));
            x.setSueldoBase(rs.getInt(9));
            x.setFotografia(rs.getBytes("Fotografia"));
            x.setUsuario(rs.getString(11));
            x.setContraseña(rs.getBytes(12));
            x.setNivelAcceso(rs.getInt(13));
            x.setActivo(rs.getInt(14));
            ls.add(x);
        }
        
        lista = new Agente[ls.size()];
        lista = ls.toArray(lista);        
        return lista;
    }

    private void setContraseña(byte[] bytes) {
        this.Contraseña=bytes;
    }

    public void modificar() throws SQLException, FileNotFoundException {
        Connection conn=Conexion.obtenerConexion();
        conn.setAutoCommit(false);
        conn.rollback();
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement("UPDATE Agente SET DPI='"+
                this.getDPI()+"', NIT='"+this.getNIT()+"', NOMBRE='"+this.getNombre()+"', DIRECCION='"+
                this.getDireccion()+"', TELEFONO='"+this.getTelefono()+"', CELULAR='"+this.getCelular()+"', COMISION='"+
                this.getComision()+"', SUELDOBASE='"+this.getSueldoBase()+"', FOTOGRAFIA=?, USUARIO='"+this.getUsuario()+"', CONTRASEÑA=?, NIVELACCESO='"+
                this.getNivelAcceso()+"', ACTIVO='"+this.getActivo()+"' WHERE idAgente="+this.getIdAgente()+";");
        try {
            FileInputStream fis = new FileInputStream(fotografia);
            ps.setBinaryStream(1, fis, (int) fotografia.length());
            ps.setBlob(2, new SerialBlob(Contraseña));
            ps.executeUpdate();
            ps.executeQuery("commit;");            
            ResultSet rs = ps.executeQuery("Select idAgente from agente WHERE NIT LIKE '"+this.getNIT()+"';");            
            rs.next();
            int index = rs.getInt(1);
            this.setIdAgente(index);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
        }
    }
}
