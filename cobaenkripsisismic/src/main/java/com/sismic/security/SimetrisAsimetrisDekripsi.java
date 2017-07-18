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
public class SimetrisAsimetrisDekripsi {
    //proses dekripsi:
    // 1. dekripsi kunci idKartu/aes-key-enc.txt
        // baca private key dr idKartu/private-key.txt
        // baca aes-key yg ternkrip dr idKartu/aes-key-enc.txt
        // referensi: TestEnkripsiDekripsiECIES.java        
    // 2. dekripsi pesan menggunakan kunci aes
        // pesan yang didekrip: text-enc.txt
        // referensi: TestDekripsi3.java
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        String idKartu = "70356809";
        
        String fileSamKey = "sam-key.txt";
        File samKeyFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+fileSamKey);
        String fileText = "text.txt";
        File textFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+fileText);
        String fileTextDec = "text-dec.txt";
        File textDecFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+fileTextDec);
        String fileTextEnc = "text-enc.txt";
        File textEncFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+fileTextEnc);
        
        String fileAESKey = "aes-key-enc.txt";
        File AESKeyFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+idKartu+File.separator+fileAESKey);
        String fileKonkat = "konkat-w-idkartu.txt";
        File konkatFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+idKartu+File.separator+fileKonkat);
        String filePrivateKey = "private-key.txt";
        File privateKeyFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+idKartu+File.separator+filePrivateKey);
        String filePublicKey = "public-key.txt";
        File publicKeyFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+idKartu+File.separator+filePublicKey);
        String fileXOR = "xor4salt.txt";
        File XORFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+idKartu+File.separator+fileXOR);
        
        // 1. dekripsi kunci idKartu/aes-key-enc.txt
        // baca aes-key yg ternkrip dr idKartu/aes-key-enc.txt
        
        // baca private key dr idKartu/private-key.txt
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
        
        Cipher c = Cipher.getInstance("ECIES", "BC");
        c.init(Cipher.DECRYPT_MODE, privKey);
        //byte[] plaintext = c.doFinal(Base64.decode(hasilEnkripsi));
        
        
        
    }
}
