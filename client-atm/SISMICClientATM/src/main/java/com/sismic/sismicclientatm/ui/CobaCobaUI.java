/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientatm.ui;

import com.sismic.sismicclientatm.reader.Reader;
import com.sismic.sismicclientatm.sismic.SISMICCardOperation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;

/**
 *
 * @author Arina Listyarini DA
 */
public class CobaCobaUI extends javax.swing.JFrame {

    /**
     * Creates new form CobaCobaUI
     */
    public CobaCobaUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Baris 1");

        jLabel2.setText("Baris 2");

        jLabel3.setText("Baris 3");

        jLabel4.setText("Baris 4");

        jLabel5.setText("Baris 5");

        jButton1.setText("Kembali ke Menu Utama");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            Reader.connectToReader();
            Boolean isKartuTempel = Reader.getTerminal().isCardPresent();
            if(isKartuTempel){
                /*String text = "" + SISMICCardOperation.bacaNomorKartu();
                jLabel1.setText(text);*/
                
                // fetch arraylist of transaksi - ws merchant
                /*com.serversismic.webservice.ServiceImpl wsSismic = new com.serversismic.webservice.ServiceImpl();
                ArrayList<com.serversismic.model.Transaksi> trs = wsSismic.getListTransaksi(SISMICCardOperation.bacaNomorKartu());
                for(com.serversismic.model.Transaksi t: trs){
                    String txt = 
                        "IDKartu: " + t.getIdKartu() + 
                        " | Jenis Transaksi: " + t.getJenisTransaksi() + 
                        " | Nominal: " + t.getNominal() + 
                        " | Status: " + t.getStatus() +
                        " | Via: " + t.getVia() +
                        " | Waktu: " + t.getWaktu() ;
                    System.out.println(txt);
                }*/
                /*String txt = 
                        "IDKartu: " + trs.get(0).getIdKartu() + 
                        " | Jenis Transaksi: " + trs.get(0).getJenisTransaksi() + 
                        " | Nominal: " + trs.get(0).getNominal() + 
                        " | Status: " + trs.get(0).getStatus() +
                        " | Via: " + trs.get(0).getVia() +
                        " | Waktu: " + trs.get(0).getWaktu() ;
                jLabel1.setText(txt);*/
                
                //fetch Kartu - ws merchant
                /*com.serversismic.webservice.ServiceImpl wsSismic = new com.serversismic.webservice.ServiceImpl();
                com.serversismic.model.Kartu kartuDB = wsSismic.getInfoKartu(SISMICCardOperation.bacaNomorKartu());
                String txt = 
                        "IDKartu: " + kartuDB.getIdKartu() + 
                        " | Kadaluarsa: " + kartuDB.getKadaluarsa() +
                        " | Saldo: " + kartuDB.getSaldo() ;
                jLabel1.setText(txt);*/
                
                //---------------------------------------------------
                
                //add Transaksi ke db paymentgateway
                /*com.serverpaymentgateway.webservice.ServiceImpl wsPayGat = new com.serverpaymentgateway.webservice.ServiceImpl();
                wsPayGat.addTransaksi("4437767890128856", 95000, "Bank C", "Bank G");*/
                
                //fetch arraylist of transaksi - ws paymentgateway
                /*com.serverpaymentgateway.webservice.ServiceImpl wsPayGat = new com.serverpaymentgateway.webservice.ServiceImpl();
                ArrayList<com.serverpaymentgateway.model.Transaksi> trs = wsPayGat.getListTransaksi("1234567890123456");
                for(com.serverpaymentgateway.model.Transaksi t: trs){
                    String txt = 
                        "Waktu: " + t.getWaktu() + 
                        " | Nominal: " + t.getNominal() + 
                        " | Dari Bank: " + t.getDariBank() +
                        " | Ke Bank: " + t.getKeBank();
                    System.out.println(txt);
                }*/
                
                ////fetch transaksi param waktu epoch milisekon- ws paymentgateway
                /*com.serverpaymentgateway.webservice.ServiceImpl wsPayGat = new com.serverpaymentgateway.webservice.ServiceImpl();
                com.serverpaymentgateway.model.Transaksi t = wsPayGat.getTransaksi("1234567890123456", new Date(Long.parseLong("1499757303204")));
                String txt = 
                        "Waktu: " + t.getWaktu() + 
                        " | Nominal: " + t.getNominal() + 
                        " | Dari Bank: " + t.getDariBank() +
                        " | Ke Bank: " + t.getKeBank();
                jLabel1.setText(txt);*/
                
                //fetch nomor cc - ws paymentgateway
                /*com.serverpaymentgateway.webservice.ServiceImpl wsPayGat = new com.serverpaymentgateway.webservice.ServiceImpl();
                ArrayList<String> ccs = wsPayGat.getNoCc();
                StringBuilder sb = new StringBuilder();
                for (String cc : ccs) {
                    sb.append(cc == null ? "" : cc + ", ");
                }
                jLabel1.setText(sb.toString());*/
                
                //---------------------------
                
                // addTransaksi ws merchant
                /*HashMap<String, Integer> barangJumlah = new HashMap<String, Integer>();
                barangJumlah.put("A01", 1);
                barangJumlah.put("A02", 1);
                com.servermerchant.webservice.ServiceImpl wsMerchant = new com.servermerchant.webservice.ServiceImpl();
                wsMerchant.addTransaksi(SISMICCardOperation.bacaNomorKartu(), 194500, barangJumlah);*/
                
                //getlisttransaksi - wsmerchant
                /*com.servermerchant.webservice.ServiceImpl wsMerchant = new com.servermerchant.webservice.ServiceImpl();
                ArrayList<com.servermerchant.model.Transaksi> trans = wsMerchant.getListTransaksi();
                for(com.servermerchant.model.Transaksi t: trans){
                    String wkt = t.getWaktu().getTime() + "";
                    
                    System.out.println("Waktu Transaksi: " + wkt);
                    System.out.println("ID Kartu: " + t.getIdKartu());
                    System.out.println("Nominal belanja: " + t.getNominal());
                    System.out.println("~~~");
                    ArrayList<com.servermerchant.model.TransaksiBarang> transb = wsMerchant.getTransaksiBarangByWaktu(wkt);
                    for(com.servermerchant.model.TransaksiBarang tb: transb){
                        System.out.println("ID TransaksiBarang: " + tb.getIdTransaksiBarang());
                        System.out.println("ID Barang yang dibeli: "+ tb.getIdBarang());
                        System.out.println("Jumlah yang dibeli: " + tb.getJumlah());
                        System.out.println("..");
                    }
                    
                    System.out.println("------------------");
                }*/
                
                
            }      
        } catch (IOException ex) {
            Logger.getLogger(CobaCobaUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (CardException ex) {
            Logger.getLogger(CobaCobaUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomeUI home = new HomeUI();
        home.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CobaCobaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobaCobaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobaCobaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobaCobaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobaCobaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
