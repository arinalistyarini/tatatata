
package com.serversismic.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tambahLog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tambahLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idKartu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yangDilakukan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "tambahLog", propOrder = {
    "idKartu",
    "yangDilakukan",
    "waktu"
})
public class TambahLog {

    protected String idKartu;
    protected String yangDilakukan;
    protected String waktu;

    /**
     * Gets the value of the idKartu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdKartu() {
        return idKartu;
    }

    /**
     * Sets the value of the idKartu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdKartu(String value) {
        this.idKartu = value;
    }

    /**
     * Gets the value of the yangDilakukan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYangDilakukan() {
        return yangDilakukan;
    }

    /**
     * Sets the value of the yangDilakukan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYangDilakukan(String value) {
        this.yangDilakukan = value;
    }

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
