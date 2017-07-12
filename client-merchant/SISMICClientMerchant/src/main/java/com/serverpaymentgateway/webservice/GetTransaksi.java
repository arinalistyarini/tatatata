
package com.serverpaymentgateway.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getTransaksi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTransaksi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="noCc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "getTransaksi", propOrder = {
    "noCc",
    "waktu"
})
public class GetTransaksi {

    protected String noCc;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar waktu;

    /**
     * Gets the value of the noCc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCc() {
        return noCc;
    }

    /**
     * Sets the value of the noCc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCc(String value) {
        this.noCc = value;
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
