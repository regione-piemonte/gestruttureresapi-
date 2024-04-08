/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.aura;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.AnagrafeFind;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.AnagrafeFindSoap;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.DatiAnagraficiMsg;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.FindProfiliAnagraficiRequest;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Message;

@Service
public class AuraAnagrafeService extends RESTBaseService {

    @Value("${auraprefix.url}")
    private String baseUrl;

    @Value("${aura.pwd}")
    private String password;

    @Value("${aura.user}")
    private String user;

    /**
     * 
     * @param request
     * @return
     */
    public DatiAnagraficiMsg findProfiliAnagrafici(FindProfiliAnagraficiRequest request)
            throws WebApplicationException {

        String methodName = "findProfiliAnagrafici ";

        try {

            AnagrafeFindSoap port = getOrchestratoreIntF();

            log.debug(methodName, "## RICHIESTA :");
            log.debug(methodName, "##  codiceFiscale: " + request.getCodiceFiscale());

            return port.findProfiliAnagrafici(request);
        } catch (Exception e) {
            log.error(methodName, " Errore durante la chiamata al servizio ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Server Error")).build());
        }

    }

    public void setOutInterceptor(AnagrafeFindSoap port) {

    }

    private AnagrafeFindSoap getOrchestratoreIntF() throws MalformedURLException {
        String methodName = "getOrchestratoreIntF | ";
        final URL wsdlURL = new URL(baseUrl + "?wsdl");
        // costruisco il service
        log.debug(methodName, "creazione servizio");
        AnagrafeFind soap = new AnagrafeFind(wsdlURL);

        AnagrafeFindSoap port = soap.getPort(AnagrafeFindSoap.class);
        
        Client client = ClientProxy.getClient(port);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(10000);
        httpClientPolicy.setReceiveTimeout(10000);
        http.setClient(httpClientPolicy);

        soap.addPort(AnagrafeFind.SERVICE, SOAPBinding.SOAP12HTTP_BINDING, baseUrl);

        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        outProps.put(WSHandlerConstants.USER, user);
        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, new UTPasswordCallback(user, password));
        client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
        BindingProvider bindingProvider = (BindingProvider) port;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,baseUrl);
        
        return port;
    }
}
