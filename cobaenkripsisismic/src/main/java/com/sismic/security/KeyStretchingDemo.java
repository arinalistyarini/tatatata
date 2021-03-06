/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Base64;

public class KeyStretchingDemo {
    public static void main(String[] args) throws Exception {
        String password = "sangat rahasia sekali";
        
        // generate random salt
        SecureRandom randomizer = new SecureRandom();
        BigInteger random = new BigInteger(32, randomizer);
        String salt = random.toString(64);
        
        int perulangan = 1000;
        String algoritma = "PBKDF2WithHmacSHA1";
        int panjangKey = 256;
        
        PBEKeySpec keyspec = new PBEKeySpec(password.toCharArray(), salt.getBytes("UTF-8"), perulangan, panjangKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritma);
        SecretKey key = keyFactory.generateSecret(keyspec);
        
        System.out.println("Password asli : "+password + " | ukurannya: " + password.toCharArray().length);
        System.out.println("Salt : "+salt + " | ukurannya: " + salt.getBytes().length);
        System.out.println("Generated Key : " + Base64.encodeBase64String(key.getEncoded()) + " | ukurannya: " + key.getEncoded().length );
    }
}