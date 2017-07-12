/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serversismic.webservice;

import com.firebase.client.Firebase;
import com.serversismic.model.Kartu;
import com.serversismic.model.Transaksi;
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
    private final String rootURL = "https://ta-sismic.firebaseio.com/";
    
    public Boolean ubahSaldo(int pil, String idKartu, int nominal, int saldoKartu, String via){
                
            // ubah saldo di firebase
            Firebase ref = new Firebase(rootURL);
            String saldoURL = "kartu/" + idKartu;
            Firebase saldoRef = ref.child(saldoURL);

            Map<String, Object> ubahSaldo = new HashMap<String, Object>();
            ubahSaldo.put("saldo", saldoKartu);
            saldoRef.updateChildren(ubahSaldo);

            //nulis riwayat transaksi
            String transaksiURL = "kartu/" + idKartu + "/transaksi/" + System.currentTimeMillis(); // timestamp
            Firebase transaksiRef = ref.child(transaksiURL);
            Map<String, Object> transaction = new HashMap<String, Object>();
            //buat insert id_transaksi unique:  - get key unik: String key = userRef.push().getKey();
            // - masukin ke db: transaction.put("id_transaksi", key);
            transaction.put("nominal", nominal);
            if(pil == 0){ // top-up saldo
                transaction.put("jenis_transaksi", "top-up saldo");
            }
            else if(pil == 1){ // pembelian
                transaction.put("jenis_transaksi", "pembelian");
            }
            else {
                transaction.put("jenis_transaksi", "undefined");
            }
            transaction.put("status", "berhasil");
            transaction.put("via", via);
            transaksiRef.updateChildren(transaction);
            return true;
        }

    public ArrayList<Transaksi> getListTransaksi(String idKartu){
        try {
            String link = rootURL + "kartu/" + idKartu + "/transaksi.json";
            System.out.println(link);
            URL url = new URL(link);
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Iterator<String> data = obj.keys();
            ArrayList<Transaksi> t = new ArrayList<Transaksi>();
                            
            while(data.hasNext()){
                System.out.println("data ada next");
                String waktu = data.next();
                
                JSONObject getTrans = obj.getJSONObject(waktu);

                Transaksi transaksi = new Transaksi();
                transaksi.setIdKartu(idKartu);
                transaksi.setJenisTransaksi(getTrans.getString("jenis_transaksi"));
                transaksi.setNominal(getTrans.getInt("nominal"));
                transaksi.setStatus(getTrans.getString("status"));
                transaksi.setVia(getTrans.getString("via"));
                transaksi.setWaktu(new Date(Long.parseLong(waktu)));
                t.add(transaksi);
            }    
            
            return t;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
        
    public Kartu getInfoKartu(String idKartu){
        try {
            URL url = new URL(rootURL + "kartu/" + idKartu + ".json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Kartu k = new Kartu();
            
            String str = obj.getInt("kadaluarsa") + "";
            k.setKadaluarsa(new Date(Long.parseLong(str)));
            
            k.setSaldo(obj.getInt("saldo"));
            k.setIdKartu(idKartu);
            
            return k;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
}