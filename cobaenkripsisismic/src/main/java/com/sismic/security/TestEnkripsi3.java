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
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsi3 {
    public static void main(String[] args) throws Exception {
        String idKartu = "70356809";
        
        // nama file
        String filePlain = "plain.txt";
        String fileEncrypted = "plain-enc.txt";
        String fileSAMKey = "sam-key.txt";
        String fileChildKeyPBKDF2 = "child-key-pbkdf2.txt";
        String fileChildKeyAES = "child-key-aes.txt";
        String fileIv = "iv.txt";
        String fileKonkat = idKartu + "-konkat.txt";
        String fileXOR4Salt = idKartu + "-xor4salt.txt";
                        
        // lokasi file
        File plain = new File("resources"+File.separator+"testenkripsi3"+File.separator+filePlain);
        File samKeyFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileSAMKey);
        File childKeyFilePBKDF2 = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileChildKeyPBKDF2);
        File childKeyFileAES = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileChildKeyAES);
        File ivFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileIv);
        File encryptedFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileEncrypted);
        File XOR4SaltFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileXOR4Salt);
        File konkatFile = new File("resources"+File.separator+"testenkripsi3"+File.separator+fileKonkat);
        
        
        /*// generate sam key master
        SecureRandom randomizerSAM = new SecureRandom();
        BigInteger randomSAM = new BigInteger(128, randomizerSAM);
        String samKeyBef = randomSAM.toString(128);
        // potong sam key-nya
        byte[] samKeyBytes = new byte[20];
        System.arraycopy(samKeyBef.getBytes("UTF-8"), 0, samKeyBytes, 0, 20);
        //tulis ke file sam-key.txt
        Files.write(samKeyFile.toPath(), samKeyBytes, StandardOpenOption.CREATE);
        String samKey = new String(samKeyBytes, "UTF-8");*/
        // baca file sam-key.txt
        List<String> samKeys = Files.readAllLines(samKeyFile.toPath(), Charset.forName("UTF-8"));
        if(samKeys.isEmpty()){
            throw new IllegalStateException("File sam-key.txt invalid");
        }
        String samKey = samKeys.get(0);
        
        /*// I random numbers u/ dixor jadi salt
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(128, randomizer);
        String rSaltBef = random.toString(128);
        // potong saltnya
        byte[] rSaltBytes = new byte[20];
        System.arraycopy(rSaltBef.getBytes("UTF-8"), 0, rSaltBytes, 0, 20);
        //tulis ke file <id-kartu>-xor4salt.txt
        Files.write(XOR4SaltFile.toPath(), rSaltBytes, StandardOpenOption.CREATE);*/
        //baca file <id-kartu>-xor4salt.txt
        List<String> rSalts = Files.readAllLines(XOR4SaltFile.toPath(), Charset.forName("UTF-8"));
        if(rSalts.isEmpty()){
            throw new IllegalStateException("File sam-key.txt invalid");
        }
        String rSalt = rSalts.get(0);
        byte[] rSaltBytes = rSalt.getBytes("UTF-8");
        
        /*// II id kartu & konkatnya
        byte[] idKartuBytes = idKartu.getBytes("UTF-8");
        SecureRandom randomizerId = new SecureRandom();
        BigInteger randomId = new BigInteger(48, randomizerId);
        String untukId = randomId.toString(96);
        //potong random number
        byte[] untukIdKar = new byte[12];
        System.arraycopy(untukId.getBytes("UTF-8"), 0, untukIdKar, 0, 12);
        //konkat
        byte[] combinedIdRandBytes = new byte[idKartuBytes.length + untukIdKar.length];
        System.arraycopy(idKartuBytes, 0, combinedIdRandBytes, 0, idKartuBytes.length);
        System.arraycopy(untukIdKar, 0, combinedIdRandBytes, idKartuBytes.length, untukIdKar.length); 
        //tulis ke file <idKartu>-konkat.txt
        Files.write(konkatFile.toPath(), combinedIdRandBytes, StandardOpenOption.CREATE);*/
        //baca file <idKartu>-konkat.txt
        List<String> combinedIdRands = Files.readAllLines(konkatFile.toPath(), Charset.forName("UTF-8"));
        if(rSalts.isEmpty()){
            throw new IllegalStateException("File sam-key.txt invalid");
        }
        String combinedIdRand = combinedIdRands.get(0);
        byte[] combinedIdRandBytes = combinedIdRand.getBytes("UTF-8");
        
        // xor I & II untuk jadi salt
        byte[] saltXOR = new byte[Math.min(combinedIdRandBytes.length, rSaltBytes.length)];int i = 0;
        for (byte b : combinedIdRandBytes){
            saltXOR[i] = (byte) (0xff & ((int)b ^ (int)rSaltBytes[i++]));
        }
        
        // generate kunci anakan
        int perulangan = 1000;
        String algoritma = "PBKDF2WithHmacSHA1";
        int panjangKey = 128; // cuma support 16, 24, 32bytes (128bit, 192bit, 256bit)
        
        PBEKeySpec keyspec = new PBEKeySpec(samKey.toCharArray(), saltXOR, perulangan, panjangKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritma);
        SecretKey keyChildPBKDF2 = keyFactory.generateSecret(keyspec);
        System.out.println("Kunci anakan (kunci simetrik untuk aes): " + Base64.encodeBase64String(keyChildPBKDF2.getEncoded()));
        System.out.println("ukuran: " + keyChildPBKDF2.getEncoded().length + " bytes");
        //tulis ke file child-key-pbkdf2.txt
        Files.write(childKeyFilePBKDF2.toPath(), Base64.encodeBase64String(keyChildPBKDF2.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        /*//baca file child-key-pbkdf2.txt
        List<String> keyChildPBKDF2s = Files.readAllLines(XOR4SaltFile.toPath(), Charset.forName("UTF-8"));
        if(keyChildPBKDF2s.isEmpty()){
            throw new IllegalStateException("File sam-key.txt invalid");
        }
        String keyChildPBKDF2 = keyChildPBKDF2s.get(0);
        byte[] keyChildPBKDF2Bytes = keyChildPBKDF2.getBytes("UTF-8");*/
        
        // generate aes key
        SecretKey aesKey = new SecretKeySpec(keyChildPBKDF2.getEncoded(), "AES");
        //tulis ke file child-key-aes.txt
        Files.write(childKeyFileAES.toPath(), Base64.encodeBase64String(aesKey.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        System.out.println("ukuran aes key: " + aesKey.getEncoded().length);
        
        //cipher
        String algoritmaEnkripsi = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algoritmaEnkripsi);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        
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
            writer.write(data);
        }
        reader.close();
        writer.close();
    }
}
