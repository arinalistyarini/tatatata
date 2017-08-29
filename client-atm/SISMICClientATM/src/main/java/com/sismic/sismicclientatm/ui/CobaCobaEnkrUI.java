/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sismic.sismicclientatm.ui;

import com.sismic.sismicclientatm.security.*;
import com.sismic.sismicclientatm.reader.*;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arina Listyarini DA
 */
public class CobaCobaEnkrUI extends javax.swing.JFrame {

    /**
     * Creates new form CobaCobaEnkrUI
     */
    public CobaCobaEnkrUI() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            /*String idKartu = Reader.getCardUID();
            System.out.println(idKartu);
            PBKDF2Impl pbkdf2Impl = new PBKDF2Impl();
            pbkdf2Impl.setIdKartu(idKartu.getBytes("UTF-8"));
            // Generate SAM Key
            byte[] samKey = pbkdf2Impl.generateSAMMasterKey();
            String fileMasterKey = "resources/SAM/masterkey.txt";
            GeneratorAndIO.writeToFile(new File(fileMasterKey), samKey);
            //pbkdf2Impl.setSAMMasterKey(GeneratorAndIO.readFromFile(new File(fileMasterKey)).getBytes("UTF-8")); // read SAM key from file

            // Generate random number untuk di-xor dengan konkatIdKartu
            pbkdf2Impl.generateXOR4Salt();
            System.out.println(Base64.toBase64String(pbkdf2Impl.getXOR4Salt()));
            // Generate random number u/ dikonkat dg idKartu
            pbkdf2Impl.generateToKonkatIdKartu();
            System.out.println(Base64.toBase64String(pbkdf2Impl.getToKonkatIdKartu()));
            // Make salt
            pbkdf2Impl.makeSalt();

            // Generate child key = AES KEY
            SecretKey childKey = pbkdf2Impl.generateChildKey();
            String fileAESKey = "resources/SAM/" + idKartu + "/aK.txt";
            GeneratorAndIO.writeToFile(new File(fileAESKey), Base64.encode(childKey.getEncoded()));*/
            //Reader.writeValueBlock(Operation.getBlockACRHexString(0, 2), "FFFFFFFFFFFF", 500, 0, 0);
            byte[] data = Operation.decimalIntegerTo4Bytes(500);
            byte[] sumBlock = Operation.getBlockACRHexBytes(0, 2);
            Reader.writeValueBlockEncr(sumBlock, data, 0, 0);
        } catch (Exception ex) {
            Logger.getLogger(CobaCobaEnkrUI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(CobaCobaEnkrUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobaCobaEnkrUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobaCobaEnkrUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobaCobaEnkrUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobaCobaEnkrUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}