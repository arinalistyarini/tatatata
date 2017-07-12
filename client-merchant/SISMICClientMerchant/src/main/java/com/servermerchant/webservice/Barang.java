
package com.servermerchant.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for barang complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="barang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="harga" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idBarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="namaBarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "barang", propOrder = {
    "harga",
    "idBarang",
    "namaBarang"
})
public class Barang {

    protected int harga;
    protected String idBarang;
    protected String namaBarang;

    /**
     * Gets the value of the harga property.
     * 
     */
    public int getHarga() {
        return harga;
    }

    /**
     * Sets the value of the harga property.
     * 
     */
    public void setHarga(int value) {
        this.harga = value;
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
     * Gets the value of the namaBarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * Sets the value of the namaBarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamaBarang(String value) {
        this.namaBarang = value;
    }

}
