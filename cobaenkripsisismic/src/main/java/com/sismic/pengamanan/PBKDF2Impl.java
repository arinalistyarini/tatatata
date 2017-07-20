/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pengamanan;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Arina Listyarini DA
 */
public class PBKDF2Impl {
    private byte[] SAMMasterKey;
    private byte[] idKartu;
    
    private byte[] XOR4Salt;
    private byte[] toKonkatIdKartu;
    private byte[] salt;

    public byte[] getSAMMasterKey() {
        return SAMMasterKey;
    }

    public void setSAMMasterKey(byte[] SAMMasterKey) {
        this.SAMMasterKey = SAMMasterKey;
    }

    public byte[] getIdKartu() {
        return idKartu;
    }

    public void setIdKartu(byte[] idKartu) {
        this.idKartu = idKartu;
    }

    public byte[] getXOR4Salt() {
        return XOR4Salt;
    }

    public void setXOR4Salt(byte[] XOR4Salt) {
        this.XOR4Salt = XOR4Salt;
    }

    public byte[] getToKonkatIdKartu() {
        return toKonkatIdKartu;
    }

    public void setToKonkatIdKartu(byte[] toKonkatIdKartu) {
        this.toKonkatIdKartu = toKonkatIdKartu;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    
    public byte[] generateSAMMasterKey() throws Exception {
        SAMMasterKey = GeneratorAndIO.generateBytes(20);
        return SAMMasterKey;
    }
    
    public byte[] generateXOR4Salt() throws Exception {
        XOR4Salt = GeneratorAndIO.generateBytes(20);
        return XOR4Salt;
    }
    
    public byte[] generateToKonkatIdKartu() throws Exception {
        toKonkatIdKartu = GeneratorAndIO.generateBytes(12);
        return toKonkatIdKartu;
    }
    
    public byte[] makeSalt() {
        byte[] resKonkat = GeneratorAndIO.concat2NumBytes(idKartu, toKonkatIdKartu);
        salt = GeneratorAndIO.xor2NumBytes(resKonkat, XOR4Salt);
        return salt;
    }
    
    public SecretKey generateChildKey() throws Exception{
        String samKey = new String(SAMMasterKey, "UTF-8");
        int perulangan = 1000;
        int panjangKey = 128; // cuma support 16, 24, 32bytes (128bit, 192bit, 256bit)
        
        PBEKeySpec keyspec = new PBEKeySpec(samKey.toCharArray(), salt, perulangan, panjangKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey keyChild = keyFactory.generateSecret(keyspec);
        return keyChild;
    }
}
