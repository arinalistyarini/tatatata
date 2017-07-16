/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsi2Dirapihin {
    public static void main(String[] args) throws Exception {
        // random numbers u/ salt
        System.out.println("~ Generate random number u/ salt ~");
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(64, randomizer);
        String rSalt = random.toString(128);
        byte[] rSaltBytes = rSalt.getBytes("UTF-8");
        
        System.out.println("Angka random u/ salt: " + new String(rSaltBytes, "UTF-8"));
        System.out.println("Ukurannya (bytes): " + rSaltBytes.length);
        
        System.out.println("------------------------");
        
        // id kartu
        System.out.println("~ ID Kartu ~");
        String idKartu = "70356809";
        byte[] idKartuBytes = idKartu.getBytes("UTF-8");
        
        System.out.println("ID Kartu: " + idKartu);
        System.out.println("Ukurannya (bytes): " + idKartuBytes.length);
        
        System.out.println("------------------------");
        
        //random number u/ diconcat dg id kartu agar jadi 20 bytes (160bit)
        // id kartu 8 bytes, maka butuh 12 bytes lagi u/ random numbernya
        
        System.out.println("~ Generate random number u/ diconcat dg idKartu ~");
        
        SecureRandom randomizerId = new SecureRandom();
        BigInteger randomId = new BigInteger(48, randomizerId);
        String untukId = randomId.toString(96);
        System.out.println("string random u/ idKartu: " + untukId);
        System.out.println("ukurannya: " + untukId.getBytes("UTF-8").length);
        
        System.out.println("...random numbernya dipotong...");
        
        byte[] untukIdKar = new byte[12];
        System.arraycopy(untukId.getBytes("UTF-8"), 0, untukIdKar, 0, 12);
        System.out.println("string random u/ idKartu stlh dipotong: " + new String(untukIdKar, "UTF-8"));
        System.out.println("ukurannya: " + untukIdKar.length);
        
        System.out.println("------------------------");
        
        System.out.println("~ Concat random number dg ID kartu ~");
        
        byte[] combinedIdRand = new byte[idKartuBytes.length + untukIdKar.length];
        System.arraycopy(idKartuBytes, 0, combinedIdRand, 0, idKartuBytes.length);
        System.arraycopy(untukIdKar, 0, combinedIdRand, idKartuBytes.length, untukIdKar.length); 
        System.out.println("Hasil konkat idkartu + random buat id: " + new String(combinedIdRand, "UTF-8"));
        System.out.println("Ukurannya: " + combinedIdRand.length);
        
        System.out.println("------------------------");
        
        System.out.println("~ XOR random u/ salt + hasil concat ~");
        
        byte[] resultXOR = new byte[20];
        
        int i = 0;
        for (byte b : combinedIdRand){
            resultXOR[i] = (byte) (b ^ rSaltBytes[i++]);
        }
        System.out.println("hasil xor: " + new String(resultXOR, "UTF-8"));
    }
}
