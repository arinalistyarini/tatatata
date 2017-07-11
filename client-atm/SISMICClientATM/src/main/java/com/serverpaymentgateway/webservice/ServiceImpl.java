/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serverpaymentgateway.webservice;

import com.firebase.client.Firebase;
import com.serverpaymentgateway.model.Transaksi;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Arina Listyarini DA
 */
public class ServiceImpl {
    private final String rootURL = "https://ta-paymentgateway.firebaseio.com/";
    
    public Boolean addTransaksi(String noCc, int nominal, String dariBank, String keBank){
            Firebase ref = new Firebase(rootURL);
            
            //nulis riwayat transaksi
            String transaksiURL = noCc + "/" + System.currentTimeMillis(); // timestamp
            Firebase transaksiRef = ref.child(transaksiURL);
            Map<String, Object> transaction = new HashMap<String, Object>();
            
            transaction.put("nominal", nominal);
            transaction.put("dari_bank", dariBank);
            transaction.put("ke_bank", keBank);
            transaksiRef.updateChildren(transaction);
            
            return true;
    }
    
    public ArrayList<Transaksi> getListTransaksi(String noCc){
        try {
            URL url = new URL(rootURL + noCc + ".json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Iterator<String> data = obj.keys();
            ArrayList<Transaksi> t = new ArrayList<Transaksi>();
                            
            while(data.hasNext()){
                String waktu = data.next();
                
                JSONObject getTrans = obj.getJSONObject(waktu);

                Transaksi transaksi = new Transaksi();
                transaksi.setDariBank(getTrans.getString("dari_bank"));
                transaksi.setKeBank(getTrans.getString("ke_bank"));
                transaksi.setNominal(getTrans.getInt("nominal"));
                transaksi.setWaktu(new Date(Long.parseLong(waktu)));
                t.add(transaksi);
            }    
            
            return t;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return null;
    }
    
    public Transaksi getTransaksi(String noCc, Date waktu){
        try {
            URL url = new URL(rootURL + noCc + "/" + waktu.getTime() + ".json");
            //System.out.println(rootURL + noCc + "/" + waktu + ".json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Transaksi t = new Transaksi();

            t.setDariBank(obj.getString("dari_bank"));
            t.setKeBank(obj.getString("ke_bank"));
            t.setNominal(obj.getInt("nominal"));
            t.setWaktu(waktu);
            return t;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public ArrayList<String> getNoCc(){
        try {
            URL url = new URL(rootURL + ".json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Iterator<String> data = obj.keys();
            ArrayList<String> noCcs = new ArrayList<String>();
                            
            while(data.hasNext()){
                String waktu = data.next();
                noCcs.add(waktu);
            }    
            
            return noCcs;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return null;
    }
    
}
