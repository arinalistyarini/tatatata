
package org.chamerling.heroku.servicesismic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arrayTransaksi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arrayTransaksi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transaksis" type="{http://servicesismic.heroku.chamerling.org/}transaksi" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrayTransaksi", propOrder = {
    "transaksis"
})
public class ArrayTransaksi {

    @XmlElement(nillable = true)
    protected List<Transaksi> transaksis;

    /**
     * Gets the value of the transaksis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transaksis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransaksis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transaksi }
     * 
     * 
     */
    public List<Transaksi> getTransaksis() {
        if (transaksis == null) {
            transaksis = new ArrayList<Transaksi>();
        }
        return this.transaksis;
    }

}
