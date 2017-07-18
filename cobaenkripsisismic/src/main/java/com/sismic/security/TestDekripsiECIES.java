/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestDekripsiECIES {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        
        String filePrivateKey = "private-key.txt";
        File privateKeyFile = new File("resources"+File.separator+"testenkripsiecies"+File.separator+filePrivateKey);
        
        // mulai dekripsi
        // baca private key dari file public-key.txt
        List<String> prKeys = Files.readAllLines(privateKeyFile.toPath(), Charset.forName("UTF-8"));
        if(prKeys.isEmpty()){
            throw new IllegalStateException("File key invalid");
        }
        String prKey = prKeys.get(0);
        //System.out.println("Key : " + prKey);
        byte[] decodedPrivate = Base64.decode(prKey);
        
        PKCS8EncodedKeySpec formatted_private = new PKCS8EncodedKeySpec(decodedPrivate);
        KeyFactory kf = KeyFactory.getInstance("EC","BC");
        PrivateKey privKey = kf.generatePrivate(formatted_private);

        Cipher cd = Cipher.getInstance("ECIES", "BC");
        cd.init(Cipher.DECRYPT_MODE, privKey);

    // Assume that we know the encoded cipher text
        Cipher c = Cipher.getInstance("ECIES", "BC");
        c.init(Cipher.DECRYPT_MODE, privKey);
        byte[] plaintext = c.doFinal(Base64.decode(""));
        System.out.println("\nPlaintext : " + new String(plaintext, "UTF-8"));
    }
}
