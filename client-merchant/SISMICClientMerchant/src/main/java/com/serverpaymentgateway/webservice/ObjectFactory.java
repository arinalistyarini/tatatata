
package com.serverpaymentgateway.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.serverpaymentgateway.webservice package. 
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

    private final static QName _GetTransaksi_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "getTransaksi");
    private final static QName _GetListTransaksiResponse_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "getListTransaksiResponse");
    private final static QName _GetNoCc_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "getNoCc");
    private final static QName _AddTransaksi_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "addTransaksi");
    private final static QName _GetTransaksiResponse_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "getTransaksiResponse");
    private final static QName _AddTransaksiResponse_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "addTransaksiResponse");
    private final static QName _GetListTransaksi_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "getListTransaksi");
    private final static QName _GetNoCcResponse_QNAME = new QName("http://webservice.serverpaymentgateway.com/", "getNoCcResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.serverpaymentgateway.webservice
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
     * Create an instance of {@link GetNoCcResponse }
     * 
     */
    public GetNoCcResponse createGetNoCcResponse() {
        return new GetNoCcResponse();
    }

    /**
     * Create an instance of {@link GetListTransaksi }
     * 
     */
    public GetListTransaksi createGetListTransaksi() {
        return new GetListTransaksi();
    }

    /**
     * Create an instance of {@link GetTransaksiResponse }
     * 
     */
    public GetTransaksiResponse createGetTransaksiResponse() {
        return new GetTransaksiResponse();
    }

    /**
     * Create an instance of {@link AddTransaksi }
     * 
     */
    public AddTransaksi createAddTransaksi() {
        return new AddTransaksi();
    }

    /**
     * Create an instance of {@link GetListTransaksiResponse }
     * 
     */
    public GetListTransaksiResponse createGetListTransaksiResponse() {
        return new GetListTransaksiResponse();
    }

    /**
     * Create an instance of {@link GetNoCc }
     * 
     */
    public GetNoCc createGetNoCc() {
        return new GetNoCc();
    }

    /**
     * Create an instance of {@link GetTransaksi }
     * 
     */
    public GetTransaksi createGetTransaksi() {
        return new GetTransaksi();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link Transaksi }
     * 
     */
    public Transaksi createTransaksi() {
        return new Transaksi();
    }

    /**
     * Create an instance of {@link ArrayNoCc }
     * 
     */
    public ArrayNoCc createArrayNoCc() {
        return new ArrayNoCc();
    }

    /**
     * Create an instance of {@link ArrayTransaksi }
     * 
     */
    public ArrayTransaksi createArrayTransaksi() {
        return new ArrayTransaksi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransaksi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "getTransaksi")
    public JAXBElement<GetTransaksi> createGetTransaksi(GetTransaksi value) {
        return new JAXBElement<GetTransaksi>(_GetTransaksi_QNAME, GetTransaksi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTransaksiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "getListTransaksiResponse")
    public JAXBElement<GetListTransaksiResponse> createGetListTransaksiResponse(GetListTransaksiResponse value) {
        return new JAXBElement<GetListTransaksiResponse>(_GetListTransaksiResponse_QNAME, GetListTransaksiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNoCc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "getNoCc")
    public JAXBElement<GetNoCc> createGetNoCc(GetNoCc value) {
        return new JAXBElement<GetNoCc>(_GetNoCc_QNAME, GetNoCc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaksi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "addTransaksi")
    public JAXBElement<AddTransaksi> createAddTransaksi(AddTransaksi value) {
        return new JAXBElement<AddTransaksi>(_AddTransaksi_QNAME, AddTransaksi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransaksiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "getTransaksiResponse")
    public JAXBElement<GetTransaksiResponse> createGetTransaksiResponse(GetTransaksiResponse value) {
        return new JAXBElement<GetTransaksiResponse>(_GetTransaksiResponse_QNAME, GetTransaksiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaksiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "addTransaksiResponse")
    public JAXBElement<AddTransaksiResponse> createAddTransaksiResponse(AddTransaksiResponse value) {
        return new JAXBElement<AddTransaksiResponse>(_AddTransaksiResponse_QNAME, AddTransaksiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTransaksi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "getListTransaksi")
    public JAXBElement<GetListTransaksi> createGetListTransaksi(GetListTransaksi value) {
        return new JAXBElement<GetListTransaksi>(_GetListTransaksi_QNAME, GetListTransaksi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNoCcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.serverpaymentgateway.com/", name = "getNoCcResponse")
    public JAXBElement<GetNoCcResponse> createGetNoCcResponse(GetNoCcResponse value) {
        return new JAXBElement<GetNoCcResponse>(_GetNoCcResponse_QNAME, GetNoCcResponse.class, null, value);
    }

}
