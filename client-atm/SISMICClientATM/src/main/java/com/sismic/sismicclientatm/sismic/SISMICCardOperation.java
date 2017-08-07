/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientatm.sismic;

import com.sismic.sismicclientatm.reader.*;
import java.util.Date;

/**
 *
 * @author Arina Listyarini DA
 */
public final class SISMICCardOperation {
    public static final String SALDO_BLOCK_KEY_A = "FFFFFFFFFFFF";
    public static final String MASA_BERLAKU_BLOCK_KEY_A = "FFFFFFFFFFFF";
    
    public static final String SALDO_BLOCK_POSITION = Operation.getBlockACRHexString(0, 2);
    public static final String MASA_BERLAKU_BLOCK_POSITION = Operation.getBlockACRHexString(0, 1);
    
    public static void isiSaldo(int data){
        // nulis saldo ke kartu:
        Reader.writeValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, data, 0, 0);
        
        // nulis riwayat trans ke kartu:
        
        //nulis saldo ke DB & riwayat trans ke DB:
        /*String idKartu = bacaNomorKartu();
        
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsSismic.ubahSaldo(0, idKartu, data, bacaSaldo(), "ATM A");*/
    }
    
    // cuekin aja ini mah, gausa dimasukin ke dokumen
    public static void ubahMasaBerlaku(int waktu){
        //String w = Operation.stringASCIIToHexString(waktu);
        Reader.writeBlock(MASA_BERLAKU_BLOCK_POSITION, MASA_BERLAKU_BLOCK_KEY_A, waktu, 0);
    }
       
    public static int bacaSaldo(){
        int res = Reader.readValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, 0);
        
        //nulis riwayat/logging ke DB
        /*String idKartu = bacaNomorKartu();
        
        String waktu = System.currentTimeMillis()/1000 + "";
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsSismic.tambahLog(idKartu, "baca saldo", waktu);
        
        System.out.println("done baca saldo");*/
        
        return res;
    }
    
    public static String bacaMasaBerlaku(){
        // baca dari kartu
        int res = Reader.readBlock(MASA_BERLAKU_BLOCK_POSITION, MASA_BERLAKU_BLOCK_KEY_A, 0);
        String res_st = res + "000";
        Date d = new Date(Long.parseLong(res_st));
        
        //nulis riwayat/logging ke DB
        /*String idKartu = bacaNomorKartu();
        
        String waktu = System.currentTimeMillis()/1000 + "";
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsSismic.tambahLog(idKartu, "baca masa berlaku", waktu);
        
        System.out.println("done baca masa berlaku");*/
        
        return d.toString();
    }
    
    public static String bacaNomorKartu(){
        String res = Reader.getCardUID();
        
        System.out.println("nomor kartu: " + res);
        
        return res;
    }
}
