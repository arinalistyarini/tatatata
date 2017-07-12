
package com.serversismic.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.serversismic.webservice package. 
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

    private final static QName _UbahSaldo_QNAME = new QName("http://webservice.serversismic.com/", "ubahSaldo");
    private final static QName _TambahLogResponse_QNAME = new QName("http://webservice.serversismic.com/", "tambahLogResponse");
    private final static QName _GetListTransaksi_QNAME = new QName("http://webservice.serversismic.com/", "getListTransaksi");
    private final static QName _GetInfoKartuResponse_QNAME = new QName("http://webservice.serversismic.com/", "getInfoKartuResponse");
    private final static QName _GetInfoKartu_QNAME = new QName("http://webservice.serversismic.com/", "getInfoKartu");
    private final static QName _TambahLog_QNAME = new QName("http://webservice.serversismic.com/", "tambahLog");
    private final static QName _UbahSaldoResponse_QNAME = new QName("http://webservice.serversismic.com/", "ubahSaldoResponse");
    private final static QName _GetListTransaksiResponse_QNAME = new QName("http://webservice.serversismic.com/", "getListTransaksiResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.serversismic.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetListTransaksi }
     * 
     */
    public GetListTransaksi createGetListTransaksi() {
        return new GetListTransaksi();
    }

    /**
     * Create an instance of {@link TambahLogResponse }
     * 
     */
    public TambahLogResponse createTambahLogResponse() {
        return new TambahLogResponse();
    }

    /**
     * Create an instance of {@link UbahSaldo }
     * 
     */
    public UbahSaldo createUbahSaldo() {
        return new UbahSaldo();
    }

    /**
     * Create an instance of {@link GetListTransaksiResponse }
     * 
     */
    public GetListTransaksiResponse createGetListTransaksiResponse() {
        return new GetListTransaksiResponse();
    }

    /**
     * Create an instance of {@link UbahSaldoResponse }
     * 
     */
    public UbahSaldoResponse createUbahSaldoResponse() {
        return new UbahSaldoResponse();
    }

    /**
     * Create an instance of {@link TambahLog }
     * 
     */
    public TambahLog createTambahLog() {
        return new TambahLog();
    }

    /**
     * Create an instance of {@link GetInfoKartu }
     * 
     */
    public GetInfoKartu createGetInfoKartu() {
        return new GetInfoKartu();
    }

    /**
     * Create an instance of {@link GetInfoKartuResponse }
     * 
     */
    public GetInfoKartuResponse createGetInfoKartuResponse() {
        return new GetInfoKartuResponse();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link Kartu }
     * 
     */
    public Kartu createKartu() {
        return new Kartu();
    }

    /**
     * Create an instance of {@link Transaksi }
     * 
     */
    public Transaksi createTransaksi() {
        return new Transaksi();
    }

    /**
     * Create an instance of {@link ArrayTransaksi }
     * 
     */
    public ArrayTransaksi createArrayTransaksi() {
        return new ArrayTransaksi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UbahSaldo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "ubahSaldo")
    public JAXBElement<UbahSaldo> createUbahSaldo(UbahSaldo value) {
        return new JAXBElement<UbahSaldo>(_UbahSaldo_QNAME, UbahSaldo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TambahLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "tambahLogResponse")
    public JAXBElement<TambahLogResponse> createTambahLogResponse(TambahLogResponse value) {
        return new JAXBElement<TambahLogResponse>(_TambahLogResponse_QNAME, TambahLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTransaksi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "getListTransaksi")
    public JAXBElement<GetListTransaksi> createGetListTransaksi(GetListTransaksi value) {
        return new JAXBElement<GetListTransaksi>(_GetListTransaksi_QNAME, GetListTransaksi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoKartuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "getInfoKartuResponse")
    public JAXBElement<GetInfoKartuResponse> createGetInfoKartuResponse(GetInfoKartuResponse value) {
        return new JAXBElement<GetInfoKartuResponse>(_GetInfoKartuResponse_QNAME, GetInfoKartuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoKartu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "getInfoKartu")
    public JAXBElement<GetInfoKartu> createGetInfoKartu(GetInfoKartu value) {
        return new JAXBElement<GetInfoKartu>(_GetInfoKartu_QNAME, GetInfoKartu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TambahLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "tambahLog")
    public JAXBElement<TambahLog> createTambahLog(TambahLog value) {
        return new JAXBElement<TambahLog>(_TambahLog_QNAME, TambahLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UbahSaldoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "ubahSaldoResponse")
    public JAXBElement<UbahSaldoResponse> createUbahSaldoResponse(UbahSaldoResponse value) {
        return new JAXBElement<UbahSaldoResponse>(_UbahSaldoResponse_QNAME, UbahSaldoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTransaksiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serversismic.com/", name = "getListTransaksiResponse")
    public JAXBElement<GetListTransaksiResponse> createGetListTransaksiResponse(GetListTransaksiResponse value) {
        return new JAXBElement<GetListTransaksiResponse>(_GetListTransaksiResponse_QNAME, GetListTransaksiResponse.class, null, value);
    }

}
