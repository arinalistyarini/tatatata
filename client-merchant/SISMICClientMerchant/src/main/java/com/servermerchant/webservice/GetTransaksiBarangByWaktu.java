
package com.servermerchant.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTransaksiBarangByWaktu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTransaksiBarangByWaktu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="waktu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransaksiBarangByWaktu", propOrder = {
    "waktu"
})
public class GetTransaksiBarangByWaktu {

    protected String waktu;

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

}
