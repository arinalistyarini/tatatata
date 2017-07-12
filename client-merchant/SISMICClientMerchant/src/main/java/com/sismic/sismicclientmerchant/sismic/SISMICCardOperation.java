/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientmerchant.sismic;

import com.sismic.sismicclientmerchant.reader.Reader;
import com.sismic.sismicclientmerchant.reader.Operation;
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
        
        //nulis saldo ke DB:
        
        // nulis riwayat trans ke DB:
    }
    
    public static void ubahMasaBerlaku(int waktu){
        
        Reader.writeBlock(MASA_BERLAKU_BLOCK_POSITION, MASA_BERLAKU_BLOCK_KEY_A, waktu, 0);
    }
    
    public static void beliBarangNoParam(int data){
        // nulis saldo ke kartu:
        Reader.writeValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, data, 0, 1);
        
        // nulis riwayat trans ke kartu:
        
        //nulis saldo ke DB:
        
        // nulis riwayat trans ke DB:
    }
    
    public static int bacaSaldo(){
        int res = Reader.readValueBlock(SALDO_BLOCK_POSITION, SALDO_BLOCK_KEY_A, 0);
        return res;
    }
    
    public static String bacaMasaBerlaku(){
        int res = Reader.readBlock(MASA_BERLAKU_BLOCK_POSITION, MASA_BERLAKU_BLOCK_KEY_A, 0);
        String res_st = res + "000";
        Date d = new Date(Long.parseLong(res_st));
        
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
        return res;
    }
}
