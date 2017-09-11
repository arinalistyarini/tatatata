/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientmerchant.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author Arina Listyarini DA
 */
public class ECDSAImpl {
    private KeyPair keyPair;

    public ECDSAImpl(){
        Security.addProvider(new BouncyCastleProvider());
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }
    
    public KeyPair generateKeyPair(){
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "BC");
            ECGenParameterSpec ecParamSpec = new ECGenParameterSpec("secp256r1");
            kpg.initialize(ecParamSpec);
            
            keyPair = kpg.generateKeyPair();
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException ex) {
            System.out.println(ex);
        }
        return keyPair;
    }
    
    public byte[] signMessage(byte[] dataEncrypted) throws Exception {
        //getKunciPrivate
        PrivateKey prKey = keyPair.getPrivate();
                
        // bubuhi sign dengan kunci private
        Signature ecdsa = Signature.getInstance("SHA1withECDSA");
        ecdsa.initSign(prKey);
        ecdsa.update(dataEncrypted);
        byte[] tandatanganDigital = ecdsa.sign();
        
        return tandatanganDigital;
    }
    
    public boolean verifySignature(byte[] dataEncrypted, byte[] tandatanganDigital) throws Exception {
        boolean result;
        
        PublicKey pbKey = keyPair.getPublic();
        byte[] encodedPbKey = pbKey.getEncoded();
       
        X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(encodedPbKey);
        KeyFactory kf = KeyFactory.getInstance("EC");
        PublicKey publikKey = kf.generatePublic(formatted_public);
            
        Signature ECDSA = Signature.getInstance("SHA1withECDSA");
            
        ECDSA.initVerify(publikKey);
        ECDSA.update(dataEncrypted);
            
        result = ECDSA.verify(tandatanganDigital);
        return result;
    }
}
