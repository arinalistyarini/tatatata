/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.security;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.KeyAgreement;

/**
 *
 * @author Arina Listyarini DA
 */
public class TestEnkripsiECC {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg;
        kpg = KeyPairGenerator.getInstance("EC","SunEC");
        
        ECGenParameterSpec ecsp = new ECGenParameterSpec("secp192k1");
        kpg.initialize(ecsp);

        KeyPair kpU = kpg.genKeyPair();
        PrivateKey privKeyU = kpU.getPrivate();
        PublicKey pubKeyU = kpU.getPublic();
        System.out.println("User U: " + privKeyU.toString());
        System.out.println("User U: " + pubKeyU.toString());

        KeyPair kpV = kpg.genKeyPair();
        PrivateKey privKeyV = kpV.getPrivate();
        PublicKey pubKeyV = kpV.getPublic();
        System.out.println("User V: " + privKeyV.toString());
        System.out.println("User V: " + pubKeyV.toString());

        KeyAgreement ecdhU = KeyAgreement.getInstance("ECDH");
        ecdhU.init(privKeyU);
        ecdhU.doPhase(pubKeyV,true);

        KeyAgreement ecdhV = KeyAgreement.getInstance("ECDH");
        ecdhV.init(privKeyV);
        ecdhV.doPhase(pubKeyU,true);

        System.out.println("Secret computed by U: 0x" + (new BigInteger(1, ecdhU.generateSecret()).toString(16)).toUpperCase());
        System.out.println("Secret computed by V: 0x" + (new BigInteger(1, ecdhV.generateSecret()).toString(16)).toUpperCase());
    }
}
