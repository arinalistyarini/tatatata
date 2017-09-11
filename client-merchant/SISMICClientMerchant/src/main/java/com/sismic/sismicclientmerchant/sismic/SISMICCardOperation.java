/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientmerchant.sismic;

import com.sismic.sismicclientmerchant.reader.Operation;
import com.sismic.sismicclientmerchant.reader.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Arina Listyarini DA
 */
public final class SISMICCardOperation {
    public static final String SALDO_BLOCK_KEY_A = "FFFFFFFFFFFF";
    public static final String SALDO_BLOCK_POSITION = Operation.getBlockACRHexString(0, 2);
    
    public static final String MASA_BERLAKU_BLOCK_KEY_A = "FFFFFFFFFFFF";
    public static final String MASA_BERLAKU_BLOCK_POSITION = Operation.getBlockACRHexString(0, 1);
    
    public static final String PARAMETER_KEY_A = "FFFFFFFFFFFF";
    public static final String PARAMETER_POSITION = Operation.getBlockACRHexString(6, 0);
    
    public static void isiSaldo(int data, HashMap<String, Integer> barangJumlah){
        // nulis saldo ke kartu:
        Reader.writeValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, data, 0, 0);
        
        // nulis riwayat trans ke kartu:
        
        //nulis saldo ke DB & riwayat trans ke DB:
       /* String idKartu = bacaNomorKartu();
        
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        String waktu = wsSismic.ubahSaldo(0, idKartu, data, bacaSaldo(), "Merchant Z");
        
        //nulis riwayat ke merchant
        com.servermerchant.webservice.HelloService wsMerchant = new com.servermerchant.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsMerchant.addTransaksiParamWaktu(waktu, idKartu, data);
        Set set = barangJumlah.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); // untuk tau mpe index mana
            wsMerchant.addTransaksiBarangJumlah(waktu, me.getKey().toString(), (String) me.getValue().toString());
        }*/
    }
    
    // cuekin aja ini mah, gausa dimasukin ke dokumen
    public static void ubahMasaBerlaku(int waktu){
        //String w = Operation.stringASCIIToHexString(waktu);
        Reader.writeBlock(MASA_BERLAKU_BLOCK_POSITION, MASA_BERLAKU_BLOCK_KEY_A, waktu, 0);
    }
    
    public static void beliBarangNoParam(int data, HashMap<String, Integer> barangJumlah){
        // nulis saldo ke kartu:
        Reader.writeValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, data, 0, 1);
        
        // nulis riwayat trans ke kartu:
        
        //nulis saldo ke DB & riwayat trans ke DB:
        /*String idKartu = bacaNomorKartu();
        
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        String waktu = wsSismic.ubahSaldo(1, idKartu, data, bacaSaldo(), "Merchant Z");
        
        //nulis riwayat ke merchant
        com.servermerchant.webservice.HelloService wsMerchant = new com.servermerchant.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsMerchant.addTransaksiParamWaktu(waktu, idKartu, data);
        Set set = barangJumlah.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); // untuk tau mpe index mana
            wsMerchant.addTransaksiBarangJumlah(waktu, me.getKey().toString(), (String) me.getValue().toString());
        }*/
    }
    
    public static int bacaSaldo(){
        int res = Reader.readValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, 0);
        
        //nulis riwayat/logging ke DB
        /*String waktu = System.currentTimeMillis()/1000 + "";
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsSismic.tambahLog(bacaNomorKartu(), "baca saldo", waktu);
        
        System.out.println("done baca saldo");*/
        
        return res;
    }
    
    public static String bacaMasaBerlaku(){
        int res = Reader.readBlock(MASA_BERLAKU_BLOCK_POSITION, MASA_BERLAKU_BLOCK_KEY_A, 0);
        String res_st = res + "000";
        Date d = new Date(Long.parseLong(res_st));
        
        String idKartu = bacaNomorKartu();
        
        //nulis riwayat/logging ke DB
        /*String waktu = System.currentTimeMillis()/1000 + "";
        com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
        wsSismic.tambahLog(idKartu, "baca masa berlaku", waktu);
        
        System.out.println("done baca masa berlaku");*/
        
        return d.toString();
        
        /*String thn = d.getYear()+1900 + "";
        String bln = d.getMonth() + "";
        String tgl = d.getDay() + "";
        
        String wkt_jm = d.getHours() + "";
        String wkt_min = d.getMinutes() + "";
                
        String output = "Masa berlaku habis pada: " + tgl + "-" + bln + "-" + thn;
        return output;*/   
    }
    
    public static String bacaNomorKartu(){
        String res = Reader.getCardUID();
        
        System.out.println("nomor kartu: " + res);
        
        return res;
    }
    
    public static void tulisParameter(int waktu){
        Reader.writeBlock(PARAMETER_POSITION, PARAMETER_KEY_A, waktu, 0);
    }
    
    public static int bacaParameter(){
        int res = Reader.readBlock(PARAMETER_POSITION, PARAMETER_KEY_A, 0);
        return res;
    }
}
