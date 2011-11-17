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
    
    public static byte [] obtenerCodigoHash(String pass) throws NoSuchAlgorithmException{
        MessageDigest md;
        byte[] buffer, digest;
        String hash = "";
        buffer = pass.getBytes();
        md = MessageDigest.getInstance("SHA1");
        md.update(buffer);
        digest = md.digest();

        return  digest;
    }    
}
