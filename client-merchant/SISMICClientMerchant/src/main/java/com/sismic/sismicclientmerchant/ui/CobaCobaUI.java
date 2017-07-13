/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientmerchant.ui;

import com.sismic.sismicclientmerchant.reader.Reader;
import com.sismic.sismicclientmerchant.sismic.SISMICCardOperation;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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

        jLabel1.setText("Baris1");

        jLabel2.setText("Baris2");

        jLabel3.setText("Baris3");

        jLabel4.setText("Baris4");

        jLabel5.setText("Baris5");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomeUI home = new HomeUI();
        home.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            Reader.connectToReader();
            Boolean isKartuTempel = Reader.getTerminal().isCardPresent();
            if(isKartuTempel){
                // ubahsaldo- ws sismic
                /*org.chamerling.heroku.servicesismic.HelloService wsSismic = new org.chamerling.heroku.servicesismic.HelloServiceImplService().getHelloServiceImplPort();
                wsSismic.ubahSaldo(0, SISMICCardOperation.bacaNomorKartu(), 500, SISMICCardOperation.bacaSaldo(), "Toko AABB");*/
                
                // fetch arraylist of transaksi - ws sismic
                /*com.serversismic.webservice.HelloService wsSismic = new com.serversismic.webservice.HelloServiceImplService().getHelloServiceImplPort();
                com.serversismic.webservice.ArrayTransaksi trs = wsSismic.getListTransaksi(SISMICCardOperation.bacaNomorKartu());
                for(com.serversismic.webservice.Transaksi t: trs.getTransaksis()){
                    long epochmili = t.getWaktu().toGregorianCalendar().getTimeInMillis();
                    Date date = new Date(epochmili);
                
                    String txt = 
                        "IDKartu: " + t.getIdKartu() + 
                        " | Jenis Transaksi: " + t.getJenisTransaksi() + 
                        " | Nominal: " + t.getNominal() + 
                        " | Status: " + t.getStatus() +
                        " | Via: " + t.getVia() +
                        " | Waktu: " + date.toString() ;
                    System.out.println(txt);
                }*/
                
                //fetch Kartu - ws sismic
                /*org.chamerling.heroku.servicesismic.HelloService wsSismic = new org.chamerling.heroku.servicesismic.HelloServiceImplService().getHelloServiceImplPort();
                org.chamerling.heroku.servicesismic.Kartu kartuDB = wsSismic.getInfoKartu(SISMICCardOperation.bacaNomorKartu());
                long epochmili = kartuDB.getKadaluarsa().toGregorianCalendar().getTimeInMillis();
                System.out.println(kartuDB.getKadaluarsa().getYear());
                Date date = new Date(epochmili);
                String txt = 
                        "IDKartu: " + kartuDB.getIdKartu() + 
                        " | Kadaluarsa: " + date.toString() +
                        " | Saldo: " + kartuDB.getSaldo() ;
                jLabel1.setText(txt);*/
                
                //---------------------------------------------------
                
                //add Transaksi ke db paymentgateway
                /*com.serverpaymentgateway.webservice.HelloService wsPayGat = new com.serverpaymentgateway.webservice.HelloServiceImplService().getHelloServiceImplPort();
                wsPayGat.addTransaksi("4437767890128856", 75000, "Bank C", "Bank G");*/
                
                
                //fetch arraylist of transaksi - ws paymentgateway
                /*com.serverpaymentgateway.webservice.HelloService wsPayGat = new com.serverpaymentgateway.webservice.HelloServiceImplService().getHelloServiceImplPort();
                com.serverpaymentgateway.webservice.ArrayTransaksi trs = wsPayGat.getListTransaksi("4437767890128856");
                for(com.serverpaymentgateway.webservice.Transaksi t: trs.getTransaksis()){
                    String epochmili = t.getWaktu().toGregorianCalendar().getTimeInMillis() + "";
                    Date date = new Date(Long.parseLong(epochmili));
                
                    String txt = 
                        "Waktu: " + date.toString() + 
                        " | Nominal: " + t.getNominal() + 
                        " | Dari Bank: " + t.getDariBank() +
                        " | Ke Bank: " + t.getKeBank();
                    System.out.println(txt);
                }*/
                
                ////fetch transaksi param waktu epoch milisekon- ws paymentgateway
                /*GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(new Date(Long.parseLong("1499940604")));
                XMLGregorianCalendar xmlGc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
               
                com.serverpaymentgateway.webservice.HelloService wsPayGat = new com.serverpaymentgateway.webservice.HelloServiceImplService().getHelloServiceImplPort();
                com.serverpaymentgateway.webservice.Transaksi t = wsPayGat.getTransaksi("4437767890128856", xmlGc);
                
                long epochmili = t.getWaktu().toGregorianCalendar().getTimeInMillis();
                Date date = new Date(epochmili);
                
                String txt = 
                        "Waktu: " + date.toString() + 
                        //"Waktu: " + t.getWaktu().toString() + 
                        " | Nominal: " + t.getNominal() + 
                        " | Dari Bank: " + t.getDariBank() +
                        " | Ke Bank: " + t.getKeBank();
                jLabel1.setText(txt);*/
                                
                //fetch nomor cc - ws paymentgateway
                /*org.chamerling.heroku.servicepaymentgateway.HelloService wsPayGat = new org.chamerling.heroku.servicepaymentgateway.HelloServiceImplService().getHelloServiceImplPort();
                org.chamerling.heroku.servicepaymentgateway.ArrayNoCc ccs = wsPayGat.getNoCc();
                StringBuilder sb = new StringBuilder();
                for (String cc : ccs.getNoCcs()) {
                    sb.append(cc == null ? "" : cc + ", ");
                }
                jLabel1.setText(sb.toString());*/
                
                //---------------------------
                
                // addTransaksi ws merchant
                /*com.servermerchant.webservice.HelloService wsMerchant = new com.servermerchant.webservice.HelloServiceImplService().getHelloServiceImplPort();
                String waktu = wsMerchant.addTransaksi(SISMICCardOperation.bacaNomorKartu(), 40000);
                // add transaksi_jumlahbarang
                HashMap<String, Integer> barangJumlah = new HashMap<String, Integer>();
                barangJumlah.put("A01", 1);
                barangJumlah.put("A02", 1);
                Set set = barangJumlah.entrySet();
                Iterator i = set.iterator();
                while(i.hasNext()) {
                    Map.Entry me = (Map.Entry)i.next(); // untuk tau mpe index mana
                    wsMerchant.addTransaksiBarangJumlah(waktu, me.getKey().toString(), (String) me.getValue().toString());
                }*/
                
                //getlisttransaksi - wsmerchant
                /*com.servermerchant.webservice.HelloService wsMerchant = new com.servermerchant.webservice.HelloServiceImplService().getHelloServiceImplPort();
                com.servermerchant.webservice.ArrayTransaksi tt = wsMerchant.getListTransaksi();
                for(com.servermerchant.webservice.Transaksi t: tt.getTransaksis()){
                    String lwkt = t.getWaktu().toGregorianCalendar().getTimeInMillis() +"";
                    Date date = new Date(Long.parseLong(lwkt));
                    
                    System.out.println("Waktu Transaksi: " + date.toString());
                    System.out.println("ID Kartu: " + t.getIdKartu());
                    System.out.println("Nominal belanja: " + t.getNominal());
                    System.out.println("~~~");
                    //ArrayList<com.servermerchant.model.TransaksiBarang> transb = wsMerchant.getTransaksiBarangByWaktu(wkt);
                    String wkt = t.getWaktu().toGregorianCalendar().getTimeInMillis()/1000 + "";
                    com.servermerchant.webservice.ArrayTransaksiBarang transb = wsMerchant.getTransaksiBarangByWaktu(wkt);
                    for(com.servermerchant.webservice.TransaksiBarang tb: transb.getTransaksiBarangs()){
                        System.out.println("ID TransaksiBarang: " + tb.getIdTransaksiBarang());
                        System.out.println("ID Barang yang dibeli: "+ tb.getIdBarang());
                        System.out.println("Jumlah yang dibeli: " + tb.getJumlah());
                        System.out.println("..");
                    }
                    
                    System.out.println("------------------");
                }*/
                
                //fetch listbarang wsmerchant
                /*org.chamerling.heroku.servicemerchant.HelloService wsMerchant = new org.chamerling.heroku.servicemerchant.HelloServiceImplService().getHelloServiceImplPort();
                org.chamerling.heroku.servicemerchant.ArrayBarang brs = wsMerchant.getListBarang();
                for(org.chamerling.heroku.servicemerchant.Barang t: brs.getBarangs()){
                    System.out.println("ID Barang: " + t.getIdBarang());
                    System.out.println("Nama Barang: " + t.getNamaBarang());
                    System.out.println("Harga Barang: " + t.getHarga());
                    System.out.println("----");
                }*/
                
                //feth getbarang wsmerchant
                //....nanti aja                
            }      
        } catch (IOException ex) {
            Logger.getLogger(CobaCobaUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (CardException ex) {
            Logger.getLogger(CobaCobaUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        /*catch (DatatypeConfigurationException ex) {
            Logger.getLogger(CobaCobaUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }*/
    }//GEN-LAST:event_formWindowOpened

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
