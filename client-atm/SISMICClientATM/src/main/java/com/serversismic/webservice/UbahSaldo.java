
package com.serversismic.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ubahSaldo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ubahSaldo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pil" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idKartu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nominal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="saldoKartu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ubahSaldo", propOrder = {
    "pil",
    "idKartu",
    "nominal",
    "saldoKartu",
    "via"
})
public class UbahSaldo {

    protected int pil;
    protected String idKartu;
    protected int nominal;
    protected int saldoKartu;
    protected String via;

    /**
     * Gets the value of the pil property.
     * 
     */
    public int getPil() {
        return pil;
    }

    /**
     * Sets the value of the pil property.
     * 
     */
    public void setPil(int value) {
        this.pil = value;
    }

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
     * Gets the value of the saldoKartu property.
     * 
     */
    public int getSaldoKartu() {
        return saldoKartu;
    }

    /**
     * Sets the value of the saldoKartu property.
     * 
     */
    public void setSaldoKartu(int value) {
        this.saldoKartu = value;
    }

    /**
     * Gets the value of the via property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVia() {
        return via;
    }

    /**
     * Sets the value of the via property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVia(String value) {
        this.via = value;
    }

}
