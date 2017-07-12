
package com.servermerchant.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arrayTransaksiBarang complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arrayTransaksiBarang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transaksiBarangs" type="{http://webservice.servermerchant.com/}transaksiBarang" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrayTransaksiBarang", propOrder = {
    "transaksiBarangs"
})
public class ArrayTransaksiBarang {

    @XmlElement(nillable = true)
    protected List<TransaksiBarang> transaksiBarangs;

    /**
     * Gets the value of the transaksiBarangs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transaksiBarangs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransaksiBarangs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransaksiBarang }
     * 
     * 
     */
    public List<TransaksiBarang> getTransaksiBarangs() {
        if (transaksiBarangs == null) {
            transaksiBarangs = new ArrayList<TransaksiBarang>();
        }
        return this.transaksiBarangs;
    }

}
