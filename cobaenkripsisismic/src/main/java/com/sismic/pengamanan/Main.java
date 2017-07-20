/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pengamanan;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class Main {
    public static void main(String[] args) throws Exception {
        PBKDF2Impl pbkdf2Impl = new PBKDF2Impl();
        AESImpl aesImpl = new AESImpl();
        aesImpl.settingCipher();
        ECIESImpl eciesImpl = new ECIESImpl();
        eciesImpl.settingCipher();
        
        String idKartu = "70356809";
        
        String fileSamKey = "sam-key.txt";
        File samKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileSamKey);
        String fileText = "text.txt";
        File textFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileText);
        String fileTextDec = "text-dec.txt";
        File textDecFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileTextDec);
        String fileTextEnc = "text-enc.txt";
        File textEncFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileTextEnc);
        
        String fileAESKey = "aes-key-enc.txt";
        File AESKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileAESKey);
        String fileKonkat = "konkat-w-idkartu.txt";
        File konkatFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileKonkat);
        String filePrivateKey = "private-key.txt";
        File privateKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+filePrivateKey);
        String filePublicKey = "public-key.txt";
        File publicKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+filePublicKey);
        String fileXOR = "xor4salt.txt";
        File XORFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileXOR);
        
        String fileIv = "iv.txt";
        File ivFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileIv);
        
        pbkdf2Impl.setIdKartu(idKartu.getBytes("UTF-8"));
        
        // Generate SAM Key
        byte[] samKey = pbkdf2Impl.generateSAMMasterKey();
        GeneratorAndIO.writeToFile(samKeyFile, samKey);
        // pbkdf2Impl.setSAMMasterKey(GeneratorAndIO.readFromFile(samKeyFile).getBytes("UTF-8")); // read SAM key from file
        
        
        // Generate random number untuk di-xor dengan konkatIdKartu
        byte[] xor4Salt = pbkdf2Impl.generateXOR4Salt();
        GeneratorAndIO.writeToFile(XORFile, xor4Salt);
        // pbkdf2Impl.setXOR4Salt(GeneratorAndIO.readFromFile(XORFile).getBytes("UTF-8"));
        
        // Generate random number u/ dikonkat dg idKartu
        byte[] toKonkatIdKartu = pbkdf2Impl.generateToKonkatIdKartu();
        GeneratorAndIO.writeToFile(konkatFile , toKonkatIdKartu);
        // GeneratorAndIO.readFromFile(konkatFile);
        
        // Make salt
        pbkdf2Impl.makeSalt();
        
        // Generate child key
        SecretKey childKey = pbkdf2Impl.generateChildKey();
        
        // generate AESKey from child key
        aesImpl.generateToAESKey(childKey);
        
        // Read text.txt
        String data = GeneratorAndIO.readFromFile(textFile);
        System.out.println("Data yang akan dienkripsi: " + data);
        
        // Encrypt text.txt with AES
        byte[] dataEncrypted = aesImpl.encrypt(data.getBytes("UTF-8"));
        String hasilEnkripsi = Base64.toBase64String(dataEncrypted); // buat disout ke console
        System.out.println("Text setelah dienkripsi: " + hasilEnkripsi);
        GeneratorAndIO.writeToFile(textEncFile, Base64.encode(dataEncrypted));
        
        // generate IV
        aesImpl.generateIV();
        
        // Encrypt AESKey
        eciesImpl.generateKeyPair();
        byte[] aesKeyEncBytes = eciesImpl.encrypt(aesImpl.getAESKey().getEncoded());
        SecretKey aesKeyEnc = new SecretKeySpec(Base64.encode(aesKeyEncBytes), "AES");
        aesImpl.setAESKey(aesKeyEnc);
        
        System.out.println("================");
        
        // Decrypt AESKey
        byte[] aesKeyDecBytes = eciesImpl.decrypt(aesImpl.getAESKey().getEncoded());
        SecretKeySpec aesKeyDec = new SecretKeySpec(aesKeyDecBytes, "AES");
        aesImpl.setAESKey(aesKeyDec);
        
        // Read text-enc.txt
        String dataEnc = GeneratorAndIO.readFromFile(textEncFile);
        System.out.println("Data yang akan didekripsi: " + dataEnc);
        byte[] dataDecBytes = aesImpl.decrypt(dataEnc.getBytes("UTF-8"));
        System.out.println("Text setelah didekripsi: " + new String (dataDecBytes, "UTF-8"));
        GeneratorAndIO.writeToFile(textDecFile, dataDecBytes);
        
    }
}
