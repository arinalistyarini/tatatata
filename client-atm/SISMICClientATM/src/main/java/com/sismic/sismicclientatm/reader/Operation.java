/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientatm.reader;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Arina Listyarini DA
 */
public final class Operation {
     /** Regex pattern for hexadecimal strings */
    private static final Pattern HEX_STRING_PATTERN = Pattern.compile("^([0-9A-Fa-f]{2})+$");
    
    /** Array of all hexadecimal chars */
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    public static boolean isHexString(String s) {
        return (s != null) && HEX_STRING_PATTERN.matcher(s).matches();
    }
    
    public static byte[] hexStringToBytes(String s) {
        /*int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;*/
        if (s.length() % 2 == 1){
            s = "0" + s;
        }
        return DatatypeConverter.parseHexBinary(s);
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
    
    public static String hexStringToASCII(String hex){

	  StringBuilder sb = new StringBuilder();
	  StringBuilder temp = new StringBuilder();

	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  for( int i=0; i<hex.length()-1; i+=2 ){

	      //grab the hex in pairs
	      String output = hex.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      sb.append((char)decimal);

	      temp.append(decimal);
	  }

	return sb.toString();
    }
    
    public static byte[] concat2Bytes(byte[] b1, byte[] b2){
        byte[] combined = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, combined, 0, b1.length);
        System.arraycopy(b2, 0, combined, b1.length, b2.length); 
        return combined;
    }
    
    public static byte[] concat3Bytes(byte[] b1, byte[] b2, byte[] b3){
        byte[] combined = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, combined, 0, b1.length);
        System.arraycopy(b2, 0, combined, b1.length, b2.length);
        
        byte[] combined2 = new byte[combined.length + b3.length];
        System.arraycopy(combined, 0, combined2, 0, combined.length);
        System.arraycopy(b3, 0, combined2, combined.length, b3.length);
        return combined2;
    }
    
    public static byte[] concat4Bytes(byte[] b1, byte[] b2, byte[] b3, byte[] b4){
        byte[] combined = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, combined, 0, b1.length);
        System.arraycopy(b2, 0, combined, b1.length, b2.length);
        
        byte[] combined2 = new byte[combined.length + b3.length];
        System.arraycopy(combined, 0, combined2, 0, combined.length);
        System.arraycopy(b3, 0, combined2, combined.length, b3.length);
        
        byte[] result = new byte[combined2.length + b4.length];
        System.arraycopy(combined2, 0, result, 0, combined2.length);
        System.arraycopy(b4, 0, result, combined2.length, b4.length);
        
        return result;
    }
    
    public static byte[] hexStringTo16Bytes(String data){
        if (data.length() % 2 == 1){
            data = "0" + data;
        }
        byte[] dataB = Operation.hexStringToBytes(data);
        byte[] dataWrite = new byte[16];
        System.arraycopy(dataB, 0, dataWrite, 16 - dataB.length, dataB.length);
        return dataWrite;
    }
    
    public static byte[] hexStringTo4Bytes(String data){
        if (data.length() % 2 == 1){
            data = "0" + data;
        }
        byte[] dataB = Operation.hexStringToBytes(data);
        byte[] dataWrite = new byte[4];
        System.arraycopy(dataB, 0, dataWrite, 4 - dataB.length, dataB.length);
        return dataWrite;
    }
    
    public static byte[] decimalIntegerToBytes(int dec){
        String hex = Integer.toHexString(dec);
        if (hex.length() % 2 == 1){
            hex = "0" + hex;
        }
        byte[] result = hexStringToBytes(hex);
        return result;
    }
    
    public static byte[] decimalIntegerTo16Bytes(int dec){
        String hex = Integer.toHexString(dec);
        if (hex.length() == 1){
            hex = "0" + hex;
        }
        byte[] result = hexStringToBytes(hex);
        byte[] dataWrite = new byte[16];
        System.arraycopy(result, 0, dataWrite, 16 - result.length, result.length);
        return dataWrite;
    }
    
    public static byte[] decimalIntegerTo4Bytes(int dec){
        String hex = Integer.toHexString(dec);
        if (hex.length() == 1){
            hex = "0" + hex;
        }
        byte[] result = hexStringToBytes(hex);
        byte[] dataWrite = new byte[4];
        System.arraycopy(result, 0, dataWrite, 4 - result.length, result.length);
        return dataWrite;
    }
    
    public static int hexStringToDecimalInteger(String data){
        int dec = (int) Long.parseLong(data, 16);
        return dec;
    }
    
    public static int bytesToDecimalInteger(byte[] b){
        String data = bytesToHexString(b);
        int dec = (int) Long.parseLong(data, 16);
        return dec;
    }
    
    public static String stringASCIIToHexString(String str){
        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }

        return hex.toString();
    }
    
    public static String getBlockACRHexString(int sector, int block){
        int sumBlock = (sector * 4) + block;
        byte[] hexString = decimalIntegerToBytes(sumBlock);
        String result = bytesToHexString(hexString);
        return result;
    }
    
    public static byte[] getBlockACRHexBytes(int sector, int block){
        int sumBlock = (sector * 4) + block;
        byte[] hexString = decimalIntegerToBytes(sumBlock);
        /*String result = bytesToHexString(hexString);
        byte[] blockBy = Operation.hexStringToBytes(result);*/
        return hexString;
    }
    
    public static int getSectorFromSumBlock(byte[] sumBlock){
        String sumBlockHexString = Operation.bytesToHexString(sumBlock);
        int sumBlockInt = Operation.hexStringToDecimalInteger(sumBlockHexString);
        int sector = sumBlockInt/4;
        
        return sector;
    }
    
    public static Date longToDate(long d){
        Date date = new Date(TimeUnit.SECONDS.toMillis(d));
        return date;
    }
}
