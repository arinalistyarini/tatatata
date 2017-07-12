
package com.serverpaymentgateway.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transaksi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaksi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dariBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nominal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="waktu" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaksi", propOrder = {
    "dariBank",
    "keBank",
    "nominal",
    "waktu"
})
public class Transaksi {

    protected String dariBank;
    protected String keBank;
    protected int nominal;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar waktu;

    /**
     * Gets the value of the dariBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDariBank() {
        return dariBank;
    }

    /**
     * Sets the value of the dariBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDariBank(String value) {
        this.dariBank = value;
    }

    /**
     * Gets the value of the keBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeBank() {
        return keBank;
    }

    /**
     * Sets the value of the keBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeBank(String value) {
        this.keBank = value;
    }

    /**
     * Gets the value of the nominal property.
     * 
     */
    public int getNominal() {
        return nominal;
    }

    /**
     * Sets the value of the nominal property.
     * 
     */
    public void setNominal(int value) {
        this.nominal = value;
    }

    /**
     * Gets the value of the waktu property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWaktu() {
        return waktu;
    }

    /**
     * Sets the value of the waktu property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWaktu(XMLGregorianCalendar value) {
        this.waktu = value;
    }

}
