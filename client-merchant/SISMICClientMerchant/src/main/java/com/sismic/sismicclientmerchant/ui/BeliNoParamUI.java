/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientmerchant.ui;

import com.sismic.sismicclientmerchant.reader.Reader;
import com.sismic.sismicclientmerchant.sismic.SISMICCardOperation;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.swing.JOptionPane;

/**
 *
 * @author Arina Listyarini DA
 */
public class BeliNoParamUI extends javax.swing.JFrame {

    /**
     * Creates new form BeliNoParamUI
     */
    public BeliNoParamUI() {
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Masukkan nominal transaksi:");

        jTextField1.setText("500");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Transaksi berhasil. Saldo anda sekarang:");

        jLabel3.setText("Saldo anda:");

        jButton2.setText("Kembali ke Menu Utama");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addComponent(jButton2)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLabel2.setText("");
        try {
            Reader.connectToReader();
            Boolean isKartuTempel = Reader.getTerminal().isCardPresent();
            if(isKartuTempel){
                String text = "Saldo anda: " + SISMICCardOperation.bacaSaldo();
                jLabel3.setText(text);
            }
        } catch (IOException ex) {
            Logger.getLogger(BeliNoParamUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (CardException ex) {
            Logger.getLogger(BeliNoParamUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
         catch (Exception ex) {
            Logger.getLogger(BeliNoParamUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int saldo = Integer.parseInt(jTextField1.getText());
            if(saldo < 500){
                validation("Minimal transaksi pembelian adalah 500");
            }
            else if(saldo > SISMICCardOperation.bacaSaldo()){
                validation("Saldo Anda tidak mencukupi untuk melakukan transaksi");
            }
            else if(saldo > 1000000){
                validation("Maksimal transaksi pembelian adalah 1.000.000");
            }
            else{
                HashMap<String, Integer> barangJumlah = new HashMap<String, Integer>();
                barangJumlah.put("undefined", 0);
                Boolean isKartuTempel = Reader.getTerminal().isCardPresent();
                if(isKartuTempel){                
                    SISMICCardOperation.beliBarangNoParam(saldo,barangJumlah);
                    String waktu = System.currentTimeMillis()/1000 + "";
                    Reader.writeLogEDC(Reader.getCardUID(), waktu, "berhasil", "beli barang", "merchant A", saldo);
                    String text = "Transaksi berhasil. Saldo anda sekarang: " + SISMICCardOperation.bacaSaldo();
                    jLabel2.setText(text);

                    text = "Saldo anda: " + SISMICCardOperation.bacaSaldo();
                    jLabel3.setText(text);
                }
            }      
        } catch (Exception ex) {
            validation("Hanya menerima masukan angka");
            Logger.getLogger(BeliNoParamUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void validation(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomeUI home = new HomeUI();
        home.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BeliNoParamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BeliNoParamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BeliNoParamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BeliNoParamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BeliNoParamUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
