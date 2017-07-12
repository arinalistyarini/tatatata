
package com.serversismic.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getListTransaksi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getListTransaksi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idKartu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListTransaksi", propOrder = {
    "idKartu"
})
public class GetListTransaksi {

    protected String idKartu;

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

}
