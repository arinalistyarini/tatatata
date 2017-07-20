/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pengamanan;

import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class AESImpl {
    private SecretKey AESKey;
    private byte[] iv;
    
    private Cipher cipher;
    
    AESImpl(){
        Security.addProvider(new BouncyCastleProvider());
    }

    public SecretKey getAESKey() {
        return AESKey;
    }

    public void setAESKey(SecretKey AESKey) {
        this.AESKey = AESKey;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }
    
    public SecretKey generateToAESKey(SecretKey sKey) {
        AESKey = new SecretKeySpec(sKey.getEncoded(), "AES");
        return AESKey;
    }
    
    public void settingCipher() throws Exception {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
    
    public byte[] generateIV() throws Exception {
        // generate IV
        iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        // write iv to text file
        //Files.write(ivFile.toPath(), Base64.toBase64String(iv).getBytes(), StandardOpenOption.CREATE);
        return iv;
    }
    
    public byte[] encrypt(byte[] data) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE, AESKey);
        byte[] dataEncrypted = cipher.doFinal(data);
        return dataEncrypted;
        
        //String hasilEnkripsi = Base64.toBase64String(dataEncrypted); // buat disout ke console
        
        //nulis ke file:
        //Files.write(*pathnya*, Base64.encode(dataEncrypted), StandardOpenOption.CREATE);
        
        // ----- ini klo lgsg ditulis ke file:
        
        /*//cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, AESKey);
        
        // tujuan hasil enkripsi
        CipherOutputStream writer = new CipherOutputStream(new FileOutputStream(textEncFile), cipher);

        // enkripsi isi file
        FileReader reader = new FileReader(textFile);
        int data;
        while((data = reader.read()) != -1){
            writer.write(data);
        }
        reader.close();
        writer.close();*/
    }
    
    public byte[] decrypt(byte[] data) throws Exception{
        SecretKeySpec AESKeySpec = new SecretKeySpec(AESKey.getEncoded(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, AESKeySpec, ivSpec);
        
        byte[] dataDecrypted = cipher.doFinal(Base64.decode(data));
        return dataDecrypted;
    }
}
