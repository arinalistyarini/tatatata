
package com.serversismic.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://webservice.serversismic.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloService {


    /**
     * 
     * @param via
     * @param pil
     * @param saldoKartu
     * @param nominal
     * @param idKartu
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ubahSaldo", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.UbahSaldo")
    @ResponseWrapper(localName = "ubahSaldoResponse", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.UbahSaldoResponse")
    public String ubahSaldo(
        @WebParam(name = "pil", targetNamespace = "")
        int pil,
        @WebParam(name = "idKartu", targetNamespace = "")
        String idKartu,
        @WebParam(name = "nominal", targetNamespace = "")
        int nominal,
        @WebParam(name = "saldoKartu", targetNamespace = "")
        int saldoKartu,
        @WebParam(name = "via", targetNamespace = "")
        String via);

    /**
     * 
     * @param idKartu
     * @return
     *     returns com.serversismic.webservice.ArrayTransaksi
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getListTransaksi", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.GetListTransaksi")
    @ResponseWrapper(localName = "getListTransaksiResponse", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.GetListTransaksiResponse")
    public ArrayTransaksi getListTransaksi(
        @WebParam(name = "idKartu", targetNamespace = "")
        String idKartu);

    /**
     * 
     * @param waktu
     * @param yangDilakukan
     * @param idKartu
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tambahLog", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.TambahLog")
    @ResponseWrapper(localName = "tambahLogResponse", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.TambahLogResponse")
    public Boolean tambahLog(
        @WebParam(name = "idKartu", targetNamespace = "")
        String idKartu,
        @WebParam(name = "yangDilakukan", targetNamespace = "")
        String yangDilakukan,
        @WebParam(name = "waktu", targetNamespace = "")
        String waktu);

    /**
     * 
     * @param idKartu
     * @return
     *     returns com.serversismic.webservice.Kartu
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInfoKartu", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.GetInfoKartu")
    @ResponseWrapper(localName = "getInfoKartuResponse", targetNamespace = "http://webservice.serversismic.com/", className = "com.serversismic.webservice.GetInfoKartuResponse")
    public Kartu getInfoKartu(
        @WebParam(name = "idKartu", targetNamespace = "")
        String idKartu);

}
