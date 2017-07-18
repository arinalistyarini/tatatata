/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import javax.crypto.Cipher;
//import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsiECIES {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        
        String filePublicKey = "public-key.txt";
        File publicKeyFile = new File("resources"+File.separator+"testenkripsiecies"+File.separator+filePublicKey);
        
        String filePrivateKey = "private-key.txt";
        File privateKeyFile = new File("resources"+File.separator+"testenkripsiecies"+File.separator+filePrivateKey);
        
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECIES", "BC");
        ECGenParameterSpec ecParamSpec = new ECGenParameterSpec("secp384r1");
        kpg.initialize(ecParamSpec);
        
        KeyPair kp = kpg.generateKeyPair();

        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        //byte[] publicKeyEnc = publicKey.getEncoded();
        //byte[] privateKeyEnc = privateKey.getEncoded();
        
        //tulis public key ke file public-key.txt
        Files.write(publicKeyFile.toPath(), Base64.toBase64String(publicKey.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        //tulis private key ke file private-key.txt
        Files.write(privateKeyFile.toPath(), Base64.toBase64String(privateKey.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        
        // mulai enkripsi
        // baca public key dari file public-key.txt
        List<String> pKeys = Files.readAllLines(publicKeyFile.toPath(), Charset.forName("UTF-8"));
        if(pKeys.isEmpty()){
            throw new IllegalStateException("File key invalid");
        }
        String pKey = pKeys.get(0);
        //System.out.println("Key : " + pKey);
        byte[] decodedPublic = Base64.decode(pKey);

        X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(decodedPublic);
        KeyFactory kf = KeyFactory.getInstance("EC","BC");
        PublicKey pubKey = kf.generatePublic(formatted_public);

        Cipher c = Cipher.getInstance("ECIES", "BC");

        c.init(Cipher.ENCRYPT_MODE, pubKey); 

        byte[] cipher = c.doFinal("Halo halo halo tes satu dua tiga tes".getBytes());
        String hasilEnkripsi = Base64.toBase64String(cipher);
        System.out.println("Ciphertext : " + hasilEnkripsi);
        
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
        PrivateKey privKey = kf.generatePrivate(formatted_private);

        Cipher cd = Cipher.getInstance("ECIES", "BC");
        cd.init(Cipher.DECRYPT_MODE, privKey); //How can i adding the **AES128_CBC** ies param ?

    // Assume that we know the encoded cipher text
        byte[] plaintext = c.doFinal(Base64.decode(hasilEnkripsi));
        System.out.println("\nPlaintext : "+ new String (plaintext));
    }
}
