/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsi {
    public static void main(String[] args) throws Exception {
        
        // nama file
        String filePlain = "plain.txt";
        String fileEncrypted = "plain-enc.txt";
        String fileSAMKey = "sam-key.txt";
        String fileChildKey = "child-key.txt";
        String fileIv = "iv.txt";
                
        // lokasi file
        File plain = new File("resources"+File.separator+filePlain);
        File samKeyFile = new File("resources"+File.separator+fileSAMKey);
        File childKeyFile = new File("resources"+File.separator+fileChildKey);
        File ivFile = new File("resources"+File.separator+fileIv);
        File encryptedFile = new File("resources"+File.separator+fileEncrypted);
        
        // generate sam key master
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(32, randomizer);
        String key = random.toString(32);
        Files.write(samKeyFile.toPath(), key.getBytes("UTF-8"), StandardOpenOption.CREATE);
        /*SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[6];
        random.nextBytes(randomBytes);
        Files.write(samKeyFile.toPath(), random.getAlgorithm().getBytes(), StandardOpenOption.CREATE);*/
                
        // get sam key master from file
        List<String> samKeys = Files.readAllLines(samKeyFile.toPath(), Charset.forName("UTF-8"));
        if(samKeys.isEmpty()){
            throw new IllegalStateException("File sam-key.txt invalid");
        }
        String samKey = samKeys.get(0);
        System.out.println("sam key: " + samKey);
        System.out.println("ukuran sam key: " + samKey.getBytes().length);
        
        System.out.println("-------------");
        
        // generate kunci anakan
        int perulangan = 1000;
        String algoritma = "PBKDF2WithHmacSHA1";
        //int panjangKey = 48;
        int panjangKey = 128; // cuma suppor 16, 24, 32bytes
        String idKartu = "70356809";
        PBEKeySpec keyspec = new PBEKeySpec(samKey.toCharArray(), idKartu.getBytes("UTF-8"), perulangan, panjangKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritma);
        SecretKey keyChild = keyFactory.generateSecret(keyspec);
        
        // tulis kunci anakan ke child-key.txt
        Files.write(childKeyFile.toPath(), Base64.encodeBase64String(keyChild.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        System.out.println("Kunci anakan (kunci simetrik untuk aes): " + Base64.encodeBase64String(keyChild.getEncoded()));
        System.out.println("ukuran: " + keyChild.getEncoded().length + " bytes");
        
        //cipher
        String algoritmaEnkripsi = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algoritmaEnkripsi);
        cipher.init(Cipher.ENCRYPT_MODE, keyChild);
        
        // generate IV
        byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        // write iv to text file
        Files.write(ivFile.toPath(), Base64.encodeBase64String(iv).getBytes(), StandardOpenOption.CREATE);

        // tujuan hasil enkripsi
        CipherOutputStream writer = new CipherOutputStream(new FileOutputStream(encryptedFile), cipher);

        // enkripsi isi file
        FileReader reader = new FileReader(plain);
        int data;
        while((data = reader.read()) != -1){
            System.out.print((char)data);
            writer.write(data);
        }
        reader.close();
        writer.close();
    }
}
