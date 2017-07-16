/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.io.File;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.List;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsi2 {
    public static void main(String[] args) throws Exception {
        // nama file
        String filePlain = "plain.txt";
        String fileEncrypted = "plain-enc.txt";
        String fileSAMKey = "sam-key.txt";
        String fileChildKey = "child-key.txt";
        String fileIv = "iv.txt";
        String fileSalt = "salt.txt";
                
        // lokasi file
        File plain = new File("resources"+File.separator+filePlain);
        File samKeyFile = new File("resources"+File.separator+fileSAMKey);
        File childKeyFile = new File("resources"+File.separator+fileChildKey);
        File ivFile = new File("resources"+File.separator+fileIv);
        File encryptedFile = new File("resources"+File.separator+fileEncrypted);
        File saltFile = new File("resources"+File.separator+fileSalt);
        
        // generate random salt
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(64, randomizer);
        String salt = random.toString(128);
        System.out.println("salt: " + salt);
        System.out.println("ukuran salt: " + salt.getBytes("UTF-8").length);
        //nulis salt ke salt.txt
        Files.write(saltFile.toPath(), salt.getBytes("UTF-8"), StandardOpenOption.CREATE);
        
        System.out.println("========");
        
        // get salt from salt.txt
        List<String> saltFromFiles = Files.readAllLines(saltFile.toPath(), Charset.forName("UTF-8"));
        if(saltFromFiles.isEmpty()){
            throw new IllegalStateException("File salt.txt invalid");
        }
        String saltFromFile = saltFromFiles.get(0);
        System.out.println("salt dr file: " + saltFromFile);
        System.out.println("ukuran salt dr file: " + saltFromFile.getBytes("UTF-8").length);
        
        System.out.println("=========");
        
        String idKartu = "70356809";
        System.out.println("ukuran idKartu: " + idKartu.getBytes("UTF-8").length);
        
        String saltIdKartu = idKartu + saltFromFile;
        System.out.println("ukuran id kartu sama salt: " + saltIdKartu.getBytes("UTF-8").length);
        System.out.println("isi id kartu + salt: "  + saltIdKartu);
        
        System.out.println("=============");
        
        byte[] combined = new byte[idKartu.getBytes("UTF-8").length + saltFromFile.getBytes("UTF-8").length];
        System.arraycopy(idKartu.getBytes("UTF-8"), 0, combined, 0, idKartu.getBytes("UTF-8").length);
        System.arraycopy(saltFromFile.getBytes("UTF-8"), 0, combined, idKartu.getBytes("UTF-8").length, saltFromFile.getBytes("UTF-8").length); 
        
        System.out.println("ukuran combined byte: " + combined.length);
        String doc2 = new String(combined, "UTF-8");
        System.out.println("isi: " + doc2);
        
        System.out.println("=============");
        
        System.out.println("generate random number u/ diconcat sama idKartu (butuh 12bytes = 96bit)");
        
        SecureRandom randomizerId = new SecureRandom();
        BigInteger randomId = new BigInteger(48, randomizerId);
        String untukId = randomId.toString(96);
        System.out.println("string random u/ idKartu: " + untukId);
        System.out.println("ukuran random u/ idKartu: " + untukId.getBytes("UTF-8").length);
        
        byte[] untukIdKar = new byte[12];
        System.arraycopy(untukId.getBytes("UTF-8"), 0, untukIdKar, 0, 12);
        System.out.println("string random u/ idKartu stlh dipotong: " + new String(untukIdKar, "UTF-8"));
        
        System.out.println("=============");
        
        //byte[] result = idKartu.getBytes("UTF-8") ^ saltFromFile.getBytes("UTF-8");
        byte[] array_1 = saltFromFile.getBytes("UTF-8");
        byte[] array_2 = idKartu.getBytes("UTF-8");
        //byte[] array_2_ext = new byte[20];
        
        System.out.println("ukuran byte id kartu: " + array_2.length);
        System.out.println("salt from file: " + new String(array_1, "UTF-8"));
        System.out.println("ukuran salt: " + array_1.length);
        System.out.println("id kartu: " + new String(array_2, "UTF-8"));
        
        byte[] combinedIdRand = new byte[array_2.length + untukIdKar.length];
        System.arraycopy(array_2, 0, combinedIdRand, 0, array_2.length);
        System.arraycopy(untukIdKar, 0, combinedIdRand, array_2.length, untukIdKar.length); 
        System.out.println("hasil konkat idkartu + random buat id: " + new String(combinedIdRand, "UTF-8"));
        System.out.println("ukurannya: " + combinedIdRand.length);
        byte[] array_3 = new byte[20];
        
        int i = 0;
        for (byte b : combinedIdRand){
            array_3[i] = (byte) (b ^ array_1[i++]);
        }
        
        System.out.println("hasil xor: " + new String(array_3, "UTF-8"));
    }
}
