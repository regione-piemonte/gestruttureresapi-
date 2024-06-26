/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.aura.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2023-02-09T14:26:42.037+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "AnagrafeFind", 
                  wsdlLocation = "file:/C:/Users/ALESSA~1.BUS/AppData/Local/Temp/tempdir496605911616781690.tmp/AURA.WS.AnagrafeFind_1.wsdl",
                  targetNamespace = "http://AnagrafeFind.central.services.auraws.aura.csi.it") 
public class AnagrafeFind extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://AnagrafeFind.central.services.auraws.aura.csi.it", "AnagrafeFind");
    public final static QName AnagrafeFindSoap = new QName("http://AnagrafeFind.central.services.auraws.aura.csi.it", "AnagrafeFindSoap");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/ALESSA~1.BUS/AppData/Local/Temp/tempdir496605911616781690.tmp/AURA.WS.AnagrafeFind_1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AnagrafeFind.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/ALESSA~1.BUS/AppData/Local/Temp/tempdir496605911616781690.tmp/AURA.WS.AnagrafeFind_1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AnagrafeFind(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AnagrafeFind(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AnagrafeFind() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AnagrafeFind(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AnagrafeFind(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AnagrafeFind(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns AnagrafeFindSoap
     */
    @WebEndpoint(name = "AnagrafeFindSoap")
    public AnagrafeFindSoap getAnagrafeFindSoap() {
        return super.getPort(AnagrafeFindSoap, AnagrafeFindSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AnagrafeFindSoap
     */
    @WebEndpoint(name = "AnagrafeFindSoap")
    public AnagrafeFindSoap getAnagrafeFindSoap(WebServiceFeature... features) {
        return super.getPort(AnagrafeFindSoap, AnagrafeFindSoap.class, features);
    }

}
