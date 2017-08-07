/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pakesign;

import java.io.File;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.SecretKey;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class Main {
    public static void main(String[] args) throws Exception {
        PBKDF2Impl pbkdf2Impl = new PBKDF2Impl();
        AESImpl aesImpl = new AESImpl();
        ECDSAImpl ecdsaImpl = new ECDSAImpl();
        
        String idKartu = "70356809";
        
        String fileSamKey = "sam-key.txt";
        File samKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileSamKey);
        String fileText = "text.txt";
        File textFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileText);
        String fileTextDec = "text-dec.txt";
        File textDecFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileTextDec);
        String fileTextEnc = "text-enc.txt";
        File textEncFile = new File("resources"+File.separator+"dikelasin"+File.separator+fileTextEnc);
        
        String fileKonkat = "konkat-w-idkartu.txt";
        File konkatFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileKonkat);
        String filePrivateKey = "private-key.txt";
        File privateKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+filePrivateKey);
        String filePublicKey = "public-key.txt";
        File publicKeyFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+filePublicKey);
        String fileXOR = "xor4salt.txt";
        File XORFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileXOR);
        
        String fileIv = "iv.txt";
        File ivFile = new File("resources"+File.separator+"dikelasin"+File.separator+idKartu+File.separator+fileIv);
        
        pbkdf2Impl.setIdKartu(idKartu.getBytes("UTF-8"));
        
        // read SAM Key
        pbkdf2Impl.setSAMMasterKey(GeneratorAndIO.readFromFile(samKeyFile).getBytes("UTF-8")); // read SAM key from file
        
        
        // read random number untuk di-xor dengan konkatIdKartu
        pbkdf2Impl.setXOR4Salt(GeneratorAndIO.readFromFile(XORFile).getBytes("UTF-8"));
        
        // read random number u/ dikonkat dg idKartu
        pbkdf2Impl.setToKonkatIdKartu(GeneratorAndIO.readFromFile(konkatFile).getBytes("UTF-8"));
        
        // Make salt
        pbkdf2Impl.makeSalt();
        
        // Generate child key
        SecretKey childKey = pbkdf2Impl.generateChildKey();
        
        // generate AESKey from child key
        aesImpl.generateToAESKey(childKey);
        
        // Read text.txt
        String data = GeneratorAndIO.readFromFile(textFile);
        System.out.println("Data yang akan dienkripsi: " + data);
        
        // Encrypt text.txt with AES
        byte[] dataEncrypted = aesImpl.encrypt(data.getBytes("UTF-8"));
        String hasilEnkripsi = Base64.toBase64String(dataEncrypted); // buat disout ke console
        System.out.println("Text setelah dienkripsi: " + hasilEnkripsi);
        GeneratorAndIO.writeToFile(textEncFile, Base64.encode(dataEncrypted));
        
        // generate IV
        aesImpl.generateIV();
        
        // --- sign pesan encrypted
        ecdsaImpl.generateKeyPair();
        byte[] tandatanganDigital = ecdsaImpl.signMessage(dataEncrypted);
        
        // ---verivikasi sign
        boolean result;
        result = ecdsaImpl.verifySignature(dataEncrypted, tandatanganDigital);
        if (result){
            System.out.printf("\nPesan berhasil diverifikasi\n\n");
            
            //Decrypt text.txt
            String dataEnc = GeneratorAndIO.readFromFile(textEncFile);
            System.out.println("Data yang akan didekripsi: " + dataEnc);
            byte[] dataDecBytes = aesImpl.decrypt(dataEnc.getBytes("UTF-8"));
            System.out.println("Text setelah didekripsi: " + new String (dataDecBytes, "UTF-8"));
        }
        else{
            System.out.println("digital signature gagal diverifikasi");
        }
       
        /*//Decrypt text.txt
        String dataEnc = GeneratorAndIO.readFromFile(textEncFile);
        System.out.println("Data yang akan didekripsi: " + dataEnc);
        byte[] dataDecBytes = aesImpl.decrypt(dataEnc.getBytes("UTF-8"));
        System.out.println("Text setelah didekripsi: " + new String (dataDecBytes, "UTF-8"));
        //GeneratorAndIO.writeToFile(textDecFile, dataDecBytes);*/
        
        /*System.out.println("===============================");
        
        
        
        //Generate kunci publik dan kunci private
        System.out.println("Alice men-generate kunci Private dan kunci Publik miliknya ...");
        KeyPairGenerator keyGenerator =  KeyPairGenerator.getInstance("EC");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        keyGenerator.initialize(256, random);
        KeyPair keyPair = keyGenerator.genKeyPair();
        
        //Alice 
        
        //Ambil kunci private kemudian simpan ke dalam bentuk string
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encodedPrivateKey = privateKey.getEncoded();
        byte[] kunciPrivate =  Base64.encode(encodedPrivateKey);// <----------- Kunci Private Alice
        System.out.println("\nKunci private Alice : " + kunciPrivate);
        
        //Ambil kunci Publik kemudian simpan ke dalam bentuk string
        PublicKey publicKey = keyPair.getPublic();
        byte[] encodedPublicKey = publicKey.getEncoded();
        byte[] kunciPublik = Base64.encode(encodedPublicKey);// <-------------- Kunci Publik Alice
        System.out.println("\nKunci publik Alice : "+ kunciPublik);
        
        String pesan = "Hai bob ! Selamat pagi, kapan menikah ?"; 
        System.out.println("\nPesan Alice : " + pesan
                + "\n\nAlice menandatangani pesan menggunakan ECDSA ...");
        
        Signature ecdsa = Signature.getInstance("SHA1withECDSA");
        ecdsa.initSign(privateKey);
        ecdsa.update(pesan.getBytes());
        byte[] tandatanganDigital = ecdsa.sign();
        String tandaTanganDigital = Base64.toBase64String(tandatanganDigital);
        
        System.out.println("\nAlice memperoleh tanda tangan digital : "+ tandaTanganDigital +
                "\n\nKirim pesan asli dan tanda tangan digital kepada Bob"+
                "\n\n\nBob memperoleh pesan & tanda tangan digital"+
                "\n\nBob mengambil kunci publik milik Alice dan melakukan verifikasi tanda tangan digital");
        
        // Bob
        byte[] ttDigital = Base64.decode(tandaTanganDigital);
        byte[] byteKunciPublik = Base64.decode(kunciPublik);
        boolean success;
       
        X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(byteKunciPublik);
        KeyFactory kf = KeyFactory.getInstance("EC");
        PublicKey publikKey = kf.generatePublic(formatted_public);
            
        Signature ECDSA = Signature.getInstance("SHA1withECDSA");
            
        ECDSA.initVerify(publikKey);
        ECDSA.update(pesan.getBytes());
            
        success = ECDSA.verify(ttDigital);
        if (success == true){
            System.out.printf("\nPesan '%s' berhasil diverifikasi\n\n",pesan);
        }*/
    }
}
