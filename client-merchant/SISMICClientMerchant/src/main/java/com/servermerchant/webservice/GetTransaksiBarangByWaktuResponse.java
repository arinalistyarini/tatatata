
package com.servermerchant.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTransaksiBarangByWaktuResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTransaksiBarangByWaktuResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.servermerchant.com/}arrayTransaksiBarang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransaksiBarangByWaktuResponse", propOrder = {
    "_return"
})
public class GetTransaksiBarangByWaktuResponse {

    @XmlElement(name = "return")
    protected ArrayTransaksiBarang _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayTransaksiBarang }
     *     
     */
    public ArrayTransaksiBarang getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayTransaksiBarang }
     *     
     */
    public void setReturn(ArrayTransaksiBarang value) {
        this._return = value;
    }

}
