
package org.chamerling.heroku.servicesismic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for kartu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kartu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idKartu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kadaluarsa" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kartu", propOrder = {
    "idKartu",
    "kadaluarsa",
    "saldo"
})
public class Kartu {

    protected String idKartu;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar kadaluarsa;
    protected int saldo;

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
     * Gets the value of the kadaluarsa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getKadaluarsa() {
        return kadaluarsa;
    }

    /**
     * Sets the value of the kadaluarsa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setKadaluarsa(XMLGregorianCalendar value) {
        this.kadaluarsa = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     */
    public void setSaldo(int value) {
        this.saldo = value;
    }

}
