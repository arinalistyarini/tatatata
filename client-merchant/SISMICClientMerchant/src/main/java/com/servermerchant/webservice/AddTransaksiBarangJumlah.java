
package com.servermerchant.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addTransaksiBarangJumlah complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTransaksiBarangJumlah">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="waktu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idBarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jumlah" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTransaksiBarangJumlah", propOrder = {
    "waktu",
    "idBarang",
    "jumlah"
})
public class AddTransaksiBarangJumlah {

    protected String waktu;
    protected String idBarang;
    protected String jumlah;

    /**
     * Gets the value of the waktu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaktu() {
        return waktu;
    }

    /**
     * Sets the value of the waktu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaktu(String value) {
        this.waktu = value;
    }

    /**
     * Gets the value of the idBarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdBarang() {
        return idBarang;
    }

    /**
     * Sets the value of the idBarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdBarang(String value) {
        this.idBarang = value;
    }

    /**
     * Gets the value of the jumlah property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJumlah() {
        return jumlah;
    }

    /**
     * Sets the value of the jumlah property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJumlah(String value) {
        this.jumlah = value;
    }

}
