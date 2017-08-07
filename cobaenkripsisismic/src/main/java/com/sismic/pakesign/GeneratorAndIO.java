/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pakesign;

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
public final class GeneratorAndIO {
    public static byte[] generateBytes(int ukuranBytes) throws Exception {
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(128, randomizer);
        String numByte = random.toString(128);
        // potong random number sebesar ukuranBytes byte
        byte[] result = new byte[ukuranBytes];
        System.arraycopy(numByte.getBytes("UTF-8"), 0, result, 0, ukuranBytes);
        return result;
    }
    
    public static byte[] concat2NumBytes(byte[] a, byte[] b) {
        byte[] combined = new byte[a.length + b.length];
        System.arraycopy(a, 0, combined, 0, a.length);
        System.arraycopy(b, 0, combined, a.length, b.length);
        return combined;
    }
    
    public static byte[] xor2NumBytes(byte[] a, byte[] b){
        byte[] result = new byte[Math.min(a.length, b.length)];
        int i = 0;
        for (byte c : a){
            result[i] = (byte) (0xff & ((int) c ^ (int) b[i++]));
        }
        return result;
    }
    
    public static void writeToFile(File file, byte[] data) throws Exception {
        String dummy = "";
        Files.write(file.toPath(), dummy.getBytes("UTF-8"), StandardOpenOption.CREATE); // file nya dikosongin dl
        Files.write(file.toPath(), data, StandardOpenOption.CREATE);
    }
    
    public static String readFromFile(File file) throws Exception {
        List<String> datas = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        if(datas.isEmpty()){
            throw new IllegalStateException("File invalid");
        }
        String data = datas.get(0);
        return data;
    }
}
