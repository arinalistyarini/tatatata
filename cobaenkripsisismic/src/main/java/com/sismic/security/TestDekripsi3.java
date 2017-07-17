/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestDekripsi3 {
    public static void main(String[] args) throws Exception {
        String idKartu = "70356809";
        
        // nama file
        String fileDecrypted = "plain-dec.txt";
        String filePlain = "plain.txt";
        String fileEncrypted = "plain-enc.txt";
        String fileSAMKey = "sam-key.txt";
        String fileChildKeyPBKDF2 = "child-key-pbkdf2.txt";
        String fileChildKeyAES = "child-key-aes.txt";
        String fileIv = "iv.txt";
        String fileKonkat = idKartu + "-konkat.txt";
        String fileXOR4Salt = idKartu + "-xor4salt.txt";
        
        // lokasi file
        File decryptedFile = new File("target"+File.separator+"classes"+File.separator+fileDecrypted);
        File plain = new File("resources"+File.separator+"testenkripsi3"+File.separator+filePlain);
        File samKeyFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileSAMKey);
        File childKeyFilePBKDF2 = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileChildKeyPBKDF2);
        File childKeyFileAES = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileChildKeyAES);
        File ivFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileIv);
        File encryptedFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileEncrypted);
        File XOR4SaltFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileXOR4Salt);
        File konkatFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileKonkat);
        
        // load child key aes
        String algoritmaKey = "AES";
        List<String> keys = Files.readAllLines(childKeyFileAES.toPath(), Charset.forName("UTF-8"));
        if(keys.isEmpty()){
            throw new IllegalStateException("File key invalid");
        }
        String key = keys.get(0);
        System.out.println("Key : "+key);
        SecretKeySpec keySpec = new SecretKeySpec(Base64.decodeBase64(key), algoritmaKey);
        
        // load IV
        List<String> ivs = Files.readAllLines(ivFile.toPath(), Charset.forName("UTF-8"));
        if(ivs.isEmpty()){
            throw new IllegalStateException("File IV invalid");
        }
        String iv = ivs.get(0);
        System.out.println("IV : "+iv);
        IvParameterSpec ivSpec = new IvParameterSpec(Base64.decodeBase64(iv));
        
        // inisialisasi AES
        String algoritmaEnkripsi = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algoritmaEnkripsi);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        
        // output terdekripsi
        FileWriter output = new FileWriter(decryptedFile);
        
        // dekripsi isi file
        CipherInputStream cis = new CipherInputStream(new FileInputStream(encryptedFile), cipher);
        int data;
        while((data = cis.read()) != -1){
            output.write(data);
            System.out.println(data);
        }
        cis.close();
        output.close();
    }
}
