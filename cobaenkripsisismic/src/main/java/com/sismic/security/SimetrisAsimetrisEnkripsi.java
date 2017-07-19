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
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author Arina Listyarini DA
 */
public class SimetrisAsimetrisEnkripsi {
    public static void main(String[] args) throws Exception {
        // proses enkripsi:
        // referensi: TestEnkripsi3.java
        // 1. generate sam-key (kunci master)
        // 2. generate kunci anakan dari sam-key dg pbkdf2, prosesnya:
            // a. generate random number (dan dipotong jadi 20bytes/128bit)
                // disimpen di idKartu/xor4salt.txt
            // b. generate random number (dan dipotong jadi 12bytes/96bit)
                // disimpen di idKartu/konkat-w-idkartu.txt
            // c. konkat b dengan idKartu (b + idKartu menjadi 20bytes/128bit)
            // d. buat salt dengan meng-xor-kan a ^ c
            // e. generate kunci anakan pbkdf2 dg masukan sam-key + salt dr d
        // 3. generate aes key dari no 2e
        // 4. enkripsi text.txt dg aes key (3) & tulis di text-enc.txt
        // referensi: TestEnkripsiDekripsiECIES.java
        // 5. enkripsi aes key (3) & tulis di idKartu/aes-key-enc.txt
            // public&private key disimpen di idKartu/txt
            // tapi nnti pada prakteknya, sama sekali tidak disimpan
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
        
        String fileIv = "iv.txt";
        File ivFile = new File("resources"+File.separator+"simetrisasimetris"+File.separator+idKartu+File.separator+fileIv);
        
        // 1. generate sam-key (kunci master)
        /*SecureRandom randomizerSAM = new SecureRandom();
        BigInteger randomSAM = new BigInteger(128, randomizerSAM);
        String samKeyBef = randomSAM.toString(128);
        // potong sam key-nya menjadi 20bytes/128bit
        byte[] samKeyBytes = new byte[20];
        System.arraycopy(samKeyBef.getBytes("UTF-8"), 0, samKeyBytes, 0, 20);
        //tulis ke file sam-key.txt
        Files.write(samKeyFile.toPath(), samKeyBytes, StandardOpenOption.CREATE);
        //String samKey = new String(samKeyBytes, "UTF-8");*/
        // baca file sam-key.txt
        List<String> samKeys = Files.readAllLines(samKeyFile.toPath(), Charset.forName("UTF-8"));
        if(samKeys.isEmpty()){
            throw new IllegalStateException("File sam-key.txt invalid");
        }
        String samKey = samKeys.get(0);
        
        // 2a. generate random number (dan dipotong jadi 20bytes/128bit)
            // disimpen di idKartu/xor4salt.txt
        /*SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(128, randomizer);
        String rSaltBef = random.toString(128);
        // potong saltnya
        byte[] rSaltBytesCut = new byte[20];
        System.arraycopy(rSaltBef.getBytes("UTF-8"), 0, rSaltBytesCut, 0, 20);
        //tulis ke file <id-kartu>-xor4salt.txt
        Files.write(XORFile.toPath(), rSaltBytesCut, StandardOpenOption.CREATE);*/
        //baca file <id-kartu>-xor4salt.txt
        List<String> rSalts = Files.readAllLines(XORFile.toPath(), Charset.forName("UTF-8"));
        if(rSalts.isEmpty()){
            throw new IllegalStateException("File " + idKartu + "/xor4salt.txt invalid");
        }
        String rSalt = rSalts.get(0);
        byte[] rSaltBytes = rSalt.getBytes("UTF-8");
        
        // 2b. generate random number (dan dipotong jadi 12bytes/96bit)
            // disimpen di idKartu/konkat-w-idkartu.txt
        /*SecureRandom randomizerId = new SecureRandom();
        BigInteger randomId = new BigInteger(48, randomizerId);
        String untukId = randomId.toString(96);
        //potong random number
        byte[] untukIdKarCut = new byte[12];
        System.arraycopy(untukId.getBytes("UTF-8"), 0, untukIdKarCut, 0, 12);
        //tulis ke file <idKartu>-konkat.txt
        Files.write(konkatFile.toPath(), untukIdKarCut, StandardOpenOption.CREATE);*/
        //baca file <idKartu>-konkat.txt
        List<String> untukIdKars = Files.readAllLines(konkatFile.toPath(), Charset.forName("UTF-8"));
        if(untukIdKars.isEmpty()){
            throw new IllegalStateException(idKartu + "/konkat-w-idkartu.txt invalid");
        }
        String untukIdKar = untukIdKars.get(0);
        byte[] untukIdKarBytes = untukIdKar.getBytes("UTF-8");
        
        // 2c. konkat 2b dengan idKartu (b + idKartu menjadi 20bytes/128bit)
        byte[] idKartuBytes = idKartu.getBytes("UTF-8");
        byte[] combinedIdRandBytes = new byte[idKartuBytes.length + untukIdKarBytes.length];
        System.arraycopy(idKartuBytes, 0, combinedIdRandBytes, 0, idKartuBytes.length);
        System.arraycopy(untukIdKarBytes, 0, combinedIdRandBytes, idKartuBytes.length, untukIdKarBytes.length); 
        
        // 2d. buat salt dengan meng-xor-kan 2a ^ 2c
        byte[] saltXOR = new byte[Math.min(combinedIdRandBytes.length, rSaltBytes.length)];
        int i = 0;
        for (byte b : combinedIdRandBytes){
            saltXOR[i] = (byte) (0xff & ((int)b ^ (int)rSaltBytes[i++]));
        }
        
        // 2e. generate kunci anakan pbkdf2 dg masukan sam-key + salt dr 2d
        int perulangan = 1000;
        String algoritma = "PBKDF2WithHmacSHA1";
        int panjangKey = 128; // cuma support 16, 24, 32bytes (128bit, 192bit, 256bit)
        
        PBEKeySpec keyspec = new PBEKeySpec(samKey.toCharArray(), saltXOR, perulangan, panjangKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritma);
        SecretKey keyChildPBKDF2 = keyFactory.generateSecret(keyspec);
        /*System.out.println("Kunci anakan (kunci simetrik untuk aes): " + Base64.toBase64String(keyChildPBKDF2.getEncoded()));
        System.out.println("ukuran: " + keyChildPBKDF2.getEncoded().length + " bytes");*/
        
        // 3. generate aes key dari no 2e
        SecretKey aesKey = new SecretKeySpec(keyChildPBKDF2.getEncoded(), "AES");
        /*System.out.println("aesKey: " + Base64.toBase64String(aesKey.getEncoded()));
        System.out.println("ukuran: " + aesKey.getEncoded().length + " bytes");*/
        
        //enkripsi text.txt
        //cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        
        // tujuan hasil enkripsi
        CipherOutputStream writer = new CipherOutputStream(new FileOutputStream(textEncFile), cipher);

        // enkripsi isi file
        FileReader reader = new FileReader(textFile);
        int data;
        while((data = reader.read()) != -1){
            writer.write(data);
        }
        reader.close();
        writer.close();
        
        // generate IV
        byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        // write iv to text file
        Files.write(ivFile.toPath(), Base64.toBase64String(iv).getBytes(), StandardOpenOption.CREATE);
        
        // 4. enkripsi text.txt dg aes key (3) & tulis di text-enc.txt
        // 5. enkripsi aes key (3) & tulis di idKartu/aes-key-enc.txt
            // public&private key disimpen di idKartu/txt
            // tapi nnti pada prakteknya, sama sekali tidak disimpan (mungkin?)
        
        // generate pasangan kunci public & private
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECIES", "BC");
        ECGenParameterSpec ecParamSpec = new ECGenParameterSpec("secp384r1");
        kpg.initialize(ecParamSpec);
        
        KeyPair kp = kpg.generateKeyPair();
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();
        //tulis public key ke file public-key.txt
        Files.write(publicKeyFile.toPath(), Base64.toBase64String(publicKey.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        //tulis private key ke file private-key.txt
        Files.write(privateKeyFile.toPath(), Base64.toBase64String(privateKey.getEncoded()).getBytes(), StandardOpenOption.CREATE);
        
        // enkripsi AES Key, ditulis ke aes-key-enc.txt
        // baca public key dari file public-key.txt
        List<String> pubKeys = Files.readAllLines(publicKeyFile.toPath(), Charset.forName("UTF-8"));
        if(pubKeys.isEmpty()){
            throw new IllegalStateException("public-key.txt invalid");
        }
        String pubKeyF = pubKeys.get(0);
        byte[] decodedPublic = Base64.decode(pubKeyF);

        X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(decodedPublic);
        KeyFactory kf = KeyFactory.getInstance("EC","BC");
        PublicKey pubKey = kf.generatePublic(formatted_public);

        Cipher c = Cipher.getInstance("ECIES", "BC");
        c.init(Cipher.ENCRYPT_MODE, pubKey); 

        byte[] cipherAsimetris = c.doFinal(aesKey.getEncoded());
        String hasilEnkripsi = Base64.toBase64String(cipherAsimetris);
        System.out.println("Ciphertext : " + hasilEnkripsi);
                
        Files.write(AESKeyFile.toPath(), Base64.encode(cipherAsimetris), StandardOpenOption.CREATE);
    }
}
