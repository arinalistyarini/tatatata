/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serverpaymentgateway.model;

import java.util.Date;

/**
 *
 * @author Arina Listyarini DA
 */
public class Transaksi {
    private Date waktu;
    private int nominal;
    private String dariBank;
    private String keBank;

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getDariBank() {
        return dariBank;
    }

    public void setDariBank(String dariBank) {
        this.dariBank = dariBank;
    }

    public String getKeBank() {
        return keBank;
    }

    public void setKeBank(String keBank) {
        this.keBank = keBank;
    }
}
