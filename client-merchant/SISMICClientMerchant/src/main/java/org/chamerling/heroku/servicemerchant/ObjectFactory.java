
package org.chamerling.heroku.servicemerchant;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.chamerling.heroku.servicemerchant package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddTransaksiResponse_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "addTransaksiResponse");
    private final static QName _GetListTransaksi_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "getListTransaksi");
    private final static QName _AddTransaksi_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "addTransaksi");
    private final static QName _GetListBarangResponse_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "getListBarangResponse");
    private final static QName _AddTransaksiBarangJumlahResponse_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "addTransaksiBarangJumlahResponse");
    private final static QName _GetTransaksiBarangByWaktuResponse_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "getTransaksiBarangByWaktuResponse");
    private final static QName _GetListBarang_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "getListBarang");
    private final static QName _GetTransaksiBarangByWaktu_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "getTransaksiBarangByWaktu");
    private final static QName _GetListTransaksiResponse_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "getListTransaksiResponse");
    private final static QName _AddTransaksiBarangJumlah_QNAME = new QName("http://servicemerchant.heroku.chamerling.org/", "addTransaksiBarangJumlah");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.chamerling.heroku.servicemerchant
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddTransaksiResponse }
     * 
     */
    public AddTransaksiResponse createAddTransaksiResponse() {
        return new AddTransaksiResponse();
    }

    /**
     * Create an instance of {@link GetListTransaksi }
     * 
     */
    public GetListTransaksi createGetListTransaksi() {
        return new GetListTransaksi();
    }

    /**
     * Create an instance of {@link AddTransaksi }
     * 
     */
    public AddTransaksi createAddTransaksi() {
        return new AddTransaksi();
    }

    /**
     * Create an instance of {@link GetListBarangResponse }
     * 
     */
    public GetListBarangResponse createGetListBarangResponse() {
        return new GetListBarangResponse();
    }

    /**
     * Create an instance of {@link GetTransaksiBarangByWaktuResponse }
     * 
     */
    public GetTransaksiBarangByWaktuResponse createGetTransaksiBarangByWaktuResponse() {
        return new GetTransaksiBarangByWaktuResponse();
    }

    /**
     * Create an instance of {@link AddTransaksiBarangJumlahResponse }
     * 
     */
    public AddTransaksiBarangJumlahResponse createAddTransaksiBarangJumlahResponse() {
        return new AddTransaksiBarangJumlahResponse();
    }

    /**
     * Create an instance of {@link GetTransaksiBarangByWaktu }
     * 
     */
    public GetTransaksiBarangByWaktu createGetTransaksiBarangByWaktu() {
        return new GetTransaksiBarangByWaktu();
    }

    /**
     * Create an instance of {@link GetListBarang }
     * 
     */
    public GetListBarang createGetListBarang() {
        return new GetListBarang();
    }

    /**
     * Create an instance of {@link GetListTransaksiResponse }
     * 
     */
    public GetListTransaksiResponse createGetListTransaksiResponse() {
        return new GetListTransaksiResponse();
    }

    /**
     * Create an instance of {@link AddTransaksiBarangJumlah }
     * 
     */
    public AddTransaksiBarangJumlah createAddTransaksiBarangJumlah() {
        return new AddTransaksiBarangJumlah();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link ArrayTransaksiBarang }
     * 
     */
    public ArrayTransaksiBarang createArrayTransaksiBarang() {
        return new ArrayTransaksiBarang();
    }

    /**
     * Create an instance of {@link Barang }
     * 
     */
    public Barang createBarang() {
        return new Barang();
    }

    /**
     * Create an instance of {@link Transaksi }
     * 
     */
    public Transaksi createTransaksi() {
        return new Transaksi();
    }

    /**
     * Create an instance of {@link TransaksiBarang }
     * 
     */
    public TransaksiBarang createTransaksiBarang() {
        return new TransaksiBarang();
    }

    /**
     * Create an instance of {@link ArrayBarang }
     * 
     */
    public ArrayBarang createArrayBarang() {
        return new ArrayBarang();
    }

    /**
     * Create an instance of {@link ArrayTransaksi }
     * 
     */
    public ArrayTransaksi createArrayTransaksi() {
        return new ArrayTransaksi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaksiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "addTransaksiResponse")
    public JAXBElement<AddTransaksiResponse> createAddTransaksiResponse(AddTransaksiResponse value) {
        return new JAXBElement<AddTransaksiResponse>(_AddTransaksiResponse_QNAME, AddTransaksiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTransaksi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "getListTransaksi")
    public JAXBElement<GetListTransaksi> createGetListTransaksi(GetListTransaksi value) {
        return new JAXBElement<GetListTransaksi>(_GetListTransaksi_QNAME, GetListTransaksi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaksi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "addTransaksi")
    public JAXBElement<AddTransaksi> createAddTransaksi(AddTransaksi value) {
        return new JAXBElement<AddTransaksi>(_AddTransaksi_QNAME, AddTransaksi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListBarangResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "getListBarangResponse")
    public JAXBElement<GetListBarangResponse> createGetListBarangResponse(GetListBarangResponse value) {
        return new JAXBElement<GetListBarangResponse>(_GetListBarangResponse_QNAME, GetListBarangResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaksiBarangJumlahResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "addTransaksiBarangJumlahResponse")
    public JAXBElement<AddTransaksiBarangJumlahResponse> createAddTransaksiBarangJumlahResponse(AddTransaksiBarangJumlahResponse value) {
        return new JAXBElement<AddTransaksiBarangJumlahResponse>(_AddTransaksiBarangJumlahResponse_QNAME, AddTransaksiBarangJumlahResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransaksiBarangByWaktuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "getTransaksiBarangByWaktuResponse")
    public JAXBElement<GetTransaksiBarangByWaktuResponse> createGetTransaksiBarangByWaktuResponse(GetTransaksiBarangByWaktuResponse value) {
        return new JAXBElement<GetTransaksiBarangByWaktuResponse>(_GetTransaksiBarangByWaktuResponse_QNAME, GetTransaksiBarangByWaktuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListBarang }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "getListBarang")
    public JAXBElement<GetListBarang> createGetListBarang(GetListBarang value) {
        return new JAXBElement<GetListBarang>(_GetListBarang_QNAME, GetListBarang.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransaksiBarangByWaktu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "getTransaksiBarangByWaktu")
    public JAXBElement<GetTransaksiBarangByWaktu> createGetTransaksiBarangByWaktu(GetTransaksiBarangByWaktu value) {
        return new JAXBElement<GetTransaksiBarangByWaktu>(_GetTransaksiBarangByWaktu_QNAME, GetTransaksiBarangByWaktu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTransaksiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "getListTransaksiResponse")
    public JAXBElement<GetListTransaksiResponse> createGetListTransaksiResponse(GetListTransaksiResponse value) {
        return new JAXBElement<GetListTransaksiResponse>(_GetListTransaksiResponse_QNAME, GetListTransaksiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaksiBarangJumlah }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemerchant.heroku.chamerling.org/", name = "addTransaksiBarangJumlah")
    public JAXBElement<AddTransaksiBarangJumlah> createAddTransaksiBarangJumlah(AddTransaksiBarangJumlah value) {
        return new JAXBElement<AddTransaksiBarangJumlah>(_AddTransaksiBarangJumlah_QNAME, AddTransaksiBarangJumlah.class, null, value);
    }

}
