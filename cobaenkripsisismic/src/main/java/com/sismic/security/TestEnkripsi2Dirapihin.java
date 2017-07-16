/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsi2Dirapihin {
    private static final Pattern HEX_STRING_PATTERN = Pattern.compile("^([0-9A-Fa-f]{2})+$");
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
    
    public static void main(String[] args) throws Exception {
        // random numbers u/ salt
        System.out.println("~ Generate random number u/ salt ~");
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(128, randomizer);
        String rSaltBef = random.toString(128);
        byte[] rSaltBefBytes = rSaltBef.getBytes("UTF-8");
        
        System.out.println("Angka random u/ salt: " + new String(rSaltBefBytes, "UTF-8"));
        System.out.println("Ukurannya (bytes): " + rSaltBefBytes.length);
        System.out.println("Apakah hexstring? " + isHexString(rSaltBef));
        
        System.out.println("...potong salt agar 20 bytes...");
        
        byte[] rSaltBytes = new byte[20];
        System.arraycopy(rSaltBef.getBytes("UTF-8"), 0, rSaltBytes, 0, 20);
        System.out.println("string random u/ idKartu stlh dipotong: " + new String(rSaltBytes, "UTF-8"));
        System.out.println("ukurannya: " + rSaltBytes.length);
        
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
        System.out.println("Apakah hexstring? " + isHexString(new String(combinedIdRand, "UTF-8")));
        
        System.out.println("------------------------");
        
        System.out.println("~ XOR random u/ salt + hasil concat ~");
        
        byte[] resultXOR = new byte[Math.min(combinedIdRand.length, rSaltBytes.length)];
        System.out.println("Ukuran resultXOR sebelum XOR: " + resultXOR.length);
        
        int i = 0;
        for (byte b : combinedIdRand){
            resultXOR[i] = (byte) (0xff & ((int)b ^ (int)rSaltBytes[i++]));
        }
        System.out.println("Ukuran setelah dixor: " + resultXOR.length);
        System.out.println("hasil xor: " + new String(resultXOR, "UTF-8"));
        System.out.println("xor sebiji: " + resultXOR[8]);
        
        System.out.println("print result XOR array by array: ");
        for (i = 0; i < resultXOR.length; i++) {
            System.out.print(resultXOR[i]);
        }
        System.out.println("");
        
        System.out.println("resultXOR diconver jadi hexstring: " + bytesToHexString(resultXOR));
        
        /*byte[] resultXOR = new byte[Math.min(combinedIdRand.length, rSaltBytes.length)];

        for (int i = 0; i < resultXOR.length; i++) {
          resultXOR[i] = (byte) (((int) combinedIdRand[i]) ^ ((int) rSaltBytes[i]));
        }
        
        System.out.println("hasil xor: " + new String(resultXOR, "UTF-8"));*/
        
        /*for (int i = 0; i < combinedIdRand.length; i++) {
            rSaltBytes[i] ^= combinedIdRand[i];
        }
        System.out.println("Hasil XOR: " + new String(rSaltBytes, "UTF-8"));*/
        
        System.out.println("------------------------");
        
        System.out.println("~ tes dengan int ~");
        int a = 9;
        int b = 13;
        
        byte c = (byte) ((byte) a ^ (byte) b);
        int d = (int) c;
        
        System.out.println(d);
        
        System.out.println("------------------------");
        
        System.out.println("~ tes dengan xor salt satuan + id satuan ~");
        
        byte result = (byte) (((int) combinedIdRand[8]) ^ ((int) rSaltBytes[8]));
        System.out.println(result);
    }
    
    public static boolean isHexString(String s) {
        return (s != null) && HEX_STRING_PATTERN.matcher(s).matches();
    }
    
    public static String bytesToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_CHARS[v >>> 4];
            hexChars[i * 2 + 1] = HEX_CHARS[v & 0x0F];
        }
        return new String(hexChars);
    }
}
