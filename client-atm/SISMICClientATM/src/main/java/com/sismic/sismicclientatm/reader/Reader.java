/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientatm.reader;

import java.io.IOException;
import java.util.List;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

/**
 *
 * @author Arina Listyarini DA
 */
public final class Reader {
    private static CardTerminal terminal = null;
    private static CardChannel channel = null;
    
    public static void connectToReader() throws IOException {
        // reader
        try {
            TerminalFactory factory = TerminalFactory.getDefault();
            List<CardTerminal> terminalsList = factory.terminals().list();
            terminal = terminalsList.get(0);

            //System.out.println("[INFO] Terminal used: " + terminalsList.get(0));
        } catch (CardException ex) {
            System.out.println("[ERROR] Check if any terminal is connected!");
            System.exit(-1);
        }
    }
    
    public static CardTerminal getTerminal(){
        return terminal;
    }
    
    public static int readBlock(String block, String key, int aOrB){
        // ngereturn hexstring, kalo mau jadi ascii: String result_ascii = Operation.hexStringToASCII(result_hexstring);
        
        //convert hexString to bytes
        byte[] blockBy = Operation.hexStringToBytes(block);
        byte[] keyBy = Operation.hexStringToBytes(key);
        try {            
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();
                        
            // load auth key
            int loadKeyResult = apduLoadAuthKey(keyBy);
            
            //jika berhasil load key
            if (loadKeyResult == 0x90) {                
                // authenticate block
                // key a or key b. aOrB = 0 key A, aOrB = 1 key B
                int authBlockResult = 0;
                if(aOrB == 0){
                    authBlockResult = apduAuthBlockKeyA(blockBy);
                }
                else {
                    authBlockResult = apduAuthBlockKeyB(blockBy);
                }
                                
                // jika authBlock berhasil
                if (authBlockResult == 0x90) {
                    //baca isi blocknya
                    byte[] read_block_apdu = new byte[] { 
                        (byte) 0xFF,
                        (byte) 0xB0,
                        (byte) 0x00,
                        // ....(byte) block
                        // ....(byte) read_block_apdu_last
                    };
                    byte[] read_block_apdu_last = new byte[] {
                        (byte) 0x10, // number byte to read, max 16bytes
                    };
                    read_block_apdu = Operation.concat3Bytes(read_block_apdu, blockBy, read_block_apdu_last);
                    
                    CommandAPDU cmd = new CommandAPDU(read_block_apdu);
                    ResponseAPDU transmit = channel.transmit(cmd);
                
                    if (transmit.getSW1() == 0x90) {
                        String result_hexstring = Operation.bytesToHexString(transmit.getData());
                        String result_ascii = Operation.hexStringToASCII(result_hexstring);
                        int result_int = Operation.hexStringToDecimalInteger(result_hexstring);
                        System.out.println("Isi block ke-" + block + ": " + result_hexstring + "(ASCII: " + result_ascii + ")" + " Decimal: " + Operation.hexStringToDecimalInteger(result_hexstring));
                        
                        return result_int;
                    }
                    else{
                        System.out.println("gagal baca isi block");
                    }
                }
                else{
                    System.out.println("[ERROR] Failed authenticating block");
                }
            }
            else {
                System.out.println("[ERROR] Failed loading auth key");
            }
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
        return -1;
    }
    
    public static String readBlockStr(String block, String key, int aOrB){
        // ngereturn hexstring, kalo mau jadi ascii: String result_ascii = Operation.hexStringToASCII(result_hexstring);
        
        //convert hexString to bytes
        byte[] blockBy = Operation.hexStringToBytes(block);
        byte[] keyBy = Operation.hexStringToBytes(key);
        try {            
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();
                        
            // load auth key
            int loadKeyResult = apduLoadAuthKey(keyBy);
            
            //jika berhasil load key
            if (loadKeyResult == 0x90) {                
                // authenticate block
                // key a or key b. aOrB = 0 key A, aOrB = 1 key B
                int authBlockResult = 0;
                if(aOrB == 0){
                    authBlockResult = apduAuthBlockKeyA(blockBy);
                }
                else {
                    authBlockResult = apduAuthBlockKeyB(blockBy);
                }
                                
                // jika authBlock berhasil
                if (authBlockResult == 0x90) {
                    //baca isi blocknya
                    byte[] read_block_apdu = new byte[] { 
                        (byte) 0xFF,
                        (byte) 0xB0,
                        (byte) 0x00,
                        // ....(byte) block
                        // ....(byte) read_block_apdu_last
                    };
                    byte[] read_block_apdu_last = new byte[] {
                        (byte) 0x10, // number byte to read, max 16bytes
                    };
                    read_block_apdu = Operation.concat3Bytes(read_block_apdu, blockBy, read_block_apdu_last);
                    
                    CommandAPDU cmd = new CommandAPDU(read_block_apdu);
                    ResponseAPDU transmit = channel.transmit(cmd);
                
                    if (transmit.getSW1() == 0x90) {
                        String result_hexstring = Operation.bytesToHexString(transmit.getData());
                        String result_ascii = Operation.hexStringToASCII(result_hexstring);
                        int result_int = Operation.hexStringToDecimalInteger(result_hexstring);
                        System.out.println("Isi block ke-" + block + ": " + result_hexstring + "(ASCII: " + result_ascii + ")" + " Decimal: " + Operation.hexStringToDecimalInteger(result_hexstring) + " ||| Integer: " + result_int);
                        
                        return result_ascii;
                    }
                    else{
                        System.out.println("gagal baca isi block");
                    }
                }
                else{
                    System.out.println("[ERROR] Failed authenticating block");
                }
            }
            else {
                System.out.println("[ERROR] Failed loading auth key");
            }
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
        return null;
    }
    
    public static int readValueBlock(String block, String key, int aOrB){
        //convert hexString to bytes
        byte[] blockBy = Operation.hexStringToBytes(block);
        byte[] keyBy = Operation.hexStringToBytes(key);
        try {            
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();
                        
            // load auth key
            int loadKeyResult = apduLoadAuthKey(keyBy);
            
            //jika berhasil load key
            if (loadKeyResult == 0x90) {                
                // authenticate block
                // key a or key b. aOrB = 0 key A, aOrB = 1 key B
                int authBlockResult = 0;
                if(aOrB == 0){
                    authBlockResult = apduAuthBlockKeyA(blockBy);
                }
                else {
                    authBlockResult = apduAuthBlockKeyB(blockBy);
                }
                
                // jika authBlock berhasil
                if (authBlockResult == 0x90) {
                    byte[] value_block_read_apdu = new byte[] {
                        (byte) 0xFF, (byte) 0xB1, (byte) 0x00,
                        //...block number
                        //(byte) 0x04
                    };
                    byte[] value_block_apdu_last = new byte[] {
                        (byte) 0x04,
                    };
                    value_block_read_apdu = Operation.concat3Bytes(value_block_read_apdu, blockBy, value_block_apdu_last);
                    CommandAPDU cmd = new CommandAPDU(value_block_read_apdu);
                    ResponseAPDU transmit = channel.transmit(cmd);
                    //jika berhasil baca
                    if (transmit.getSW1() == 0x90) {                
                        System.out.println("Isi value block sekarang adalah: " + Operation.bytesToDecimalInteger(transmit.getData()));
                        return Operation.bytesToDecimalInteger(transmit.getData());
                    }
                    else {
                        System.out.println("[ERROR] Gagal baca value block");
                    }
                }
                else{
                    System.out.println("[ERROR] Failed authenticating block");
                }
            }
            else {
                System.out.println("[ERROR] Failed loading auth key");
            }
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
        return -1;
    }
        
    public static void writeBlock(String block, String key, int data, int aOrB){
        //convert hexString to bytes
        byte[] blockBy = Operation.hexStringToBytes(block);
        byte[] keyBy = Operation.hexStringToBytes(key);
        //byte[] dataBy = Operation.hexStringTo16Bytes(data); // kalo data nya string
        byte[] dataBy = Operation.decimalIntegerTo16Bytes(data); // kalo data nya int
        
        //System.out.println(Operation.bytesToHexString(dataBy));
        try {            
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();
            
            // load auth key
            int loadKeyResult = apduLoadAuthKey(keyBy);
            
            //jika berhasil load key
            if (loadKeyResult == 0x90) {                
                // authenticate block
                // key a or key b. aOrB = 0 key A, aOrB = 1 key B
                int authBlockResult;
                if(aOrB == 0){
                    authBlockResult = apduAuthBlockKeyA(blockBy);
                }
                else {
                    authBlockResult = apduAuthBlockKeyB(blockBy);
                }
                
                // jika authBlock berhasil
                if (authBlockResult == 0x90) {
                    //tulis block
                    byte[] write_block_apdu = new byte[] { 
                        (byte) 0xFF,(byte) 0xD6, (byte) 0x00,
                    };
                    byte[] write_block_apdu_between = new byte[] { 
                        (byte) 0x10 // number of bytes to update (max 16 bytes)
                    };
                    write_block_apdu = Operation.concat4Bytes(write_block_apdu, blockBy, write_block_apdu_between, dataBy);
                    
                    CommandAPDU cmd = new CommandAPDU(write_block_apdu);
                    ResponseAPDU transmit = channel.transmit(cmd);
                
                    if (transmit.getSW1() == 0x90) {
                        System.out.println("[INFO] Block ke-" + block + " berhasil di-update)");
                    }
                    else{
                        System.out.println("gagal tulis block");
                    }
                }
                else{
                    System.out.println("[ERROR] Failed authenticating block");
                }
            }
            else {
                System.out.println("[ERROR] Failed loading auth key");
            }
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
    }
    
    public static void writeBlockStr(String block, String key, String data, int aOrB){
        //convert hexString to bytes
        byte[] blockBy = Operation.hexStringToBytes(block);
        byte[] keyBy = Operation.hexStringToBytes(key);
        byte[] dataBy = Operation.hexStringTo16Bytes(data); // kalo data nya string
        //byte[] dataBy = Operation.decimalIntegerTo16Bytes(data); // kalo data nya int
        
        //System.out.println(Operation.bytesToHexString(dataBy));
        try {            
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();
            
            // load auth key
            int loadKeyResult = apduLoadAuthKey(keyBy);
            
            //jika berhasil load key
            if (loadKeyResult == 0x90) {                
                // authenticate block
                // key a or key b. aOrB = 0 key A, aOrB = 1 key B
                int authBlockResult;
                if(aOrB == 0){
                    authBlockResult = apduAuthBlockKeyA(blockBy);
                }
                else {
                    authBlockResult = apduAuthBlockKeyB(blockBy);
                }
                
                // jika authBlock berhasil
                if (authBlockResult == 0x90) {
                    //tulis block
                    byte[] write_block_apdu = new byte[] { 
                        (byte) 0xFF,(byte) 0xD6, (byte) 0x00,
                    };
                    byte[] write_block_apdu_between = new byte[] { 
                        (byte) 0x10 // number of bytes to update (max 16 bytes)
                    };
                    write_block_apdu = Operation.concat4Bytes(write_block_apdu, blockBy, write_block_apdu_between, dataBy);
                    
                    CommandAPDU cmd = new CommandAPDU(write_block_apdu);
                    ResponseAPDU transmit = channel.transmit(cmd);
                
                    if (transmit.getSW1() == 0x90) {
                        System.out.println("[INFO] Block ke-" + block + " berhasil di-update)");
                    }
                    else{
                        System.out.println("gagal tulis block");
                    }
                }
                else{
                    System.out.println("[ERROR] Failed authenticating block");
                }
            }
            else {
                System.out.println("[ERROR] Failed loading auth key");
            }
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
    }
    
    public static void writeValueBlock(String block, String key, int data, int aOrB, int incdec){
        //convert hexString to bytes
        byte[] blockBy = Operation.hexStringToBytes(block);
        byte[] keyBy = Operation.hexStringToBytes(key);
        //byte[] dataBy = Operation.hexStringTo4Bytes(data); // kalo data nya string
        byte[] dataBy = Operation.decimalIntegerTo4Bytes(data); // kalo data nya int
        byte[] inc = new byte[] {
            (byte) 0x01,
        };
        byte[] dec = new byte[] {
            (byte) 0x02,
        };
        try {            
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();
                        
            // load auth key
            int loadKeyResult = apduLoadAuthKey(keyBy);
            
            //jika berhasil load key
            if (loadKeyResult == 0x90) {                
                // authenticate block
                // key a or key b. aOrB = 0 key A, aOrB = 1 key B
                int authBlockResult = 0;
                if(aOrB == 0){
                    authBlockResult = apduAuthBlockKeyA(blockBy);
                }
                else {
                    authBlockResult = apduAuthBlockKeyB(blockBy);
                }
                
                // jika authBlock berhasil
                if (authBlockResult == 0x90) {
                    byte[] value_block_operation_apdu = new byte[] {
                        (byte) 0xFF, (byte) 0xD7, (byte) 0x00,
                        //(byte) 0x10, // block number
                        // (byte) 0x05,
                        // (byte) 0x01, // increment: 01h, decrement: 02h
                        // (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xFF // data to be incremented. signed long integer 4 bytes
                    };
                    byte[] value_block_operation_apdu_middle = new byte[] {
                        (byte) 0x05,
                    };
                    byte[] value_block_operation_apdu_last;
                    if(incdec == 0){ //increment
                        value_block_operation_apdu_last = Operation.concat2Bytes(inc, dataBy);
                    }
                    else {
                        value_block_operation_apdu_last = Operation.concat2Bytes(dec, dataBy);
                    }
                    value_block_operation_apdu = Operation.concat4Bytes(value_block_operation_apdu, blockBy, value_block_operation_apdu_middle, value_block_operation_apdu_last);
                    CommandAPDU cmd = new CommandAPDU(value_block_operation_apdu);
                    ResponseAPDU transmit = channel.transmit(cmd);
                    //jika berhasil increment
                    if (transmit.getSW1() == 0x90) {                
                        System.out.print("Value block berhasil ditulis. ");
                    }
                    else {
                        System.out.println("[ERROR] Failed writing value block");
                    }
                }
                else{
                    System.out.println("[ERROR] Failed authenticating block");
                }
            }
            else {
                System.out.println("[ERROR] Failed loading auth key");
            }
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
    }
    
    public static int apduAuthBlockKeyA(byte[] blockB) {
        try{
            byte[] authenticate_block_apdu = {
                (byte) 0xFF, (byte) 0x86, (byte) 0x00, (byte) 0x00, (byte) 0x05,
                (byte) 0x01, (byte) 0x00
                // .....(byte) block
                // .....(byte) authenticate_block_apdu_last
            };
            byte[] authenticate_block_apdu_last = {
                (byte) 0x60, // key tipe. type a: 60, type b 61
                (byte) 0x01 // key location
            };
            authenticate_block_apdu = Operation.concat3Bytes(authenticate_block_apdu, blockB, authenticate_block_apdu_last);

            CommandAPDU cmd = new CommandAPDU(authenticate_block_apdu);
            ResponseAPDU transmit = channel.transmit(cmd);

            return transmit.getSW1();
        }
        catch (CardException ex) {
            System.out.println("[ERROR] Something wrong with the card");
            System.exit(-1);
        }
        return -1;
    }
    
    public static int apduAuthBlockKeyB(byte[] blockB) {
        try{
            byte[] authenticate_block_apdu = {
                (byte) 0xFF, (byte) 0x86, (byte) 0x00, (byte) 0x00, (byte) 0x05,
                (byte) 0x01, (byte) 0x00
                // .....(byte) block
                // .....(byte) authenticate_block_apdu_last
            };
            byte[] authenticate_block_apdu_last = {
                (byte) 0x61, // key tipe. type a: 60, type b 61
                (byte) 0x01 // key location
            };
            authenticate_block_apdu = Operation.concat3Bytes(authenticate_block_apdu, blockB, authenticate_block_apdu_last);

            CommandAPDU cmd = new CommandAPDU(authenticate_block_apdu);
            ResponseAPDU transmit = channel.transmit(cmd);

            return transmit.getSW1();
        }
        catch (CardException ex) {
            System.out.println("[ERROR] Something wrong with the card");
            System.exit(-1);
        }
        return -1;
    }
    
    public static int apduLoadAuthKey(byte[] keyB){
        try {
            byte[] load_auth_key_apdu = {
                (byte) 0xFF, (byte) 0x82, 
                (byte) 0x00, 
                (byte) 0x01, //key location
                (byte) 0x06
                // .....(byte) key
            };
            load_auth_key_apdu = Operation.concat2Bytes(load_auth_key_apdu, keyB);

            CommandAPDU cmd = new CommandAPDU(load_auth_key_apdu);
            ResponseAPDU transmit = channel.transmit(cmd);

            return transmit.getSW1();
        }
        catch (CardException ex) {
            System.out.println("[ERROR] Something wrong with the card");
            System.exit(-1);
        }
        return -1;
    }
    
    public static String getCardUID(){
        try {
            Card card = terminal.connect("*");
            channel = card.getBasicChannel();

            //Reset the card
            card.getATR();

            byte[] uid_apdu = {(byte) 0xFF, (byte) 0xCA, (byte) 0x00, (byte) 0x00, (byte) 0x00};
            CommandAPDU cmd = new CommandAPDU(uid_apdu);
            ResponseAPDU transmit = channel.transmit(cmd);
            
            String uid_hexstring = Operation.bytesToHexString(transmit.getData());
            //String uid_ascii = Operation.hexStringToASCII(uid_hexstring);
            //System.out.println("[INFO] Card UID: " + uid_hexstring + "(ASCII: " + uid_ascii + ")");
            
            return uid_hexstring;
         }
         catch (CardException ex) {
            System.out.println("[ERROR] No card found");
            System.exit(-1);
        }
        return null;
    }
}
