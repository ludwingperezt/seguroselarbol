/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author HP G42
 */
public class Criptografia {
    
    public static byte[] obtenerCodigoHash(String pass) throws NoSuchAlgorithmException{
        byte[] resumen;
        byte[] mensaje = pass.getBytes();
        
        MessageDigest cifrador = MessageDigest.getInstance("SHA-1");
        cifrador.reset();
        cifrador.update(mensaje);
        resumen = cifrador.digest();
        
        return resumen;
    }    
}
