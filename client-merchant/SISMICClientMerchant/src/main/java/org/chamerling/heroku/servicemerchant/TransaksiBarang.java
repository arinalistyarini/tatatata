
package org.chamerling.heroku.servicemerchant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transaksiBarang complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaksiBarang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idBarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTransaksiBarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jumlah" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaksiBarang", propOrder = {
    "idBarang",
    "idTransaksiBarang",
    "jumlah"
})
public class TransaksiBarang {

    protected String idBarang;
    protected String idTransaksiBarang;
    protected int jumlah;

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
     * Gets the value of the idTransaksiBarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTransaksiBarang() {
        return idTransaksiBarang;
    }

    /**
     * Sets the value of the idTransaksiBarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTransaksiBarang(String value) {
        this.idTransaksiBarang = value;
    }

    /**
     * Gets the value of the jumlah property.
     * 
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * Sets the value of the jumlah property.
     * 
     */
    public void setJumlah(int value) {
        this.jumlah = value;
    }

}
