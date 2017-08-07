/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.pakesign;

import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Arina Listyarini DA
 */
public class Cobacoba {
    public static void main(String[] args) throws Exception {
        String s = "61706161";
        if (s.length() % 2 == 1){
            s = "0" + s;
        }
        byte[] b = DatatypeConverter.parseHexBinary(s);
        byte[] dataWrite2 = new byte[16];
        System.arraycopy(b, 0, dataWrite2, 16 - b.length, b.length);
        
        byte[] a = s.getBytes("UTF-8");
        byte[] dataWrite = new byte[16];
        System.arraycopy(a, 0, dataWrite, 16 - a.length, a.length);
        
        if(Arrays.equals(dataWrite2, dataWrite)){
            System.out.println("sama");
        }
        else{
            System.out.println("beda");
            System.out.println("ukuran a: " + dataWrite.length);
            System.out.println("ukuran b: " + dataWrite2.length);
        }
    }
}


