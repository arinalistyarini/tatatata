/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pengamanan;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class ECIESImpl {
    private KeyPair keyPair;
    
    private Cipher cipher;

    ECIESImpl(){
        Security.addProvider(new BouncyCastleProvider());
    }
    
    public void settingCipher() throws Exception {
        cipher = Cipher.getInstance("ECIES", "BC");
    }
    
    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECIES", "BC");
        ECGenParameterSpec ecParamSpec = new ECGenParameterSpec("secp384r1");
        kpg.initialize(ecParamSpec);
        
        keyPair = kpg.generateKeyPair();
        return keyPair;
    }
    
    public byte[] encrypt(byte[] data) throws Exception{
        byte[] decodedPublic = keyPair.getPublic().getEncoded(); // kalo ada masalah, mungkin dr sini
        
        X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(decodedPublic);
        KeyFactory kf = KeyFactory.getInstance("EC","BC");
        PublicKey pubKey = kf.generatePublic(formatted_public);

        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] encryptedData = cipher.doFinal(data);
        //String hasilEnkripsi = Base64.toBase64String(cipherAsimetris);
        //System.out.println("Ciphertext : " + hasilEnkripsi);
        
        //Files.write(AESKeyFile.toPath(), Base64.encode(cipherAsimetris), StandardOpenOption.CREATE);
        
        return encryptedData;
    }
    
    public byte[] decrypt(byte[] data) throws Exception {
        byte[] decodedPrivate = keyPair.getPrivate().getEncoded();
        
        PKCS8EncodedKeySpec formatted_private = new PKCS8EncodedKeySpec(decodedPrivate);
        KeyFactory kf = KeyFactory.getInstance("EC","BC");
        PrivateKey privKey = kf.generatePrivate(formatted_private);

        cipher.init(Cipher.DECRYPT_MODE, privKey);
        
        byte[] dataDecrypted = cipher.doFinal(Base64.decode(data));
        return dataDecrypted;
    }
}
