/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author Arina Listyarini DA
 */
public class SimetrisAsimetrisDekripsi {
    //proses dekripsi:
    // 1. dekripsi kunci idKartu/aes-key-enc.txt
        // baca private key dr idKartu/private-key.txt
        // baca aes-key yg ternkrip dr idKartu/aes-key-enc.txt
        // referensi: TestEnkripsiDekripsiECIES.java        
    // 2. dekripsi pesan menggunakan kunci aes
        // pesan yang didekrip: text-enc.txt
        // referensi: TestDekripsi3.java
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        String idKartu = "70356809";
    }
}
