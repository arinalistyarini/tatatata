
package org.chamerling.heroku.servicepaymentgateway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addTransaksi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTransaksi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="noCc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nominal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dariBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTransaksi", propOrder = {
    "noCc",
    "nominal",
    "dariBank",
    "keBank"
})
public class AddTransaksi {

    protected String noCc;
    protected int nominal;
    protected String dariBank;
    protected String keBank;

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

}
