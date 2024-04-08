/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gatefire;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.Attachment;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.CallInfo;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.GateFireSrvc;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.GateFireSrvc_Service;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.SignVerifyResult;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Message;

@Service
public class GateFireService extends RESTBaseService {

    @Value("${gatefire.wsdl.url}")
    private String baseUrl;

    /**
     * 
     * @param request
     * @return
     */
    public SignVerifyResult verificaFirma(Attachment attachment, CallInfo info) throws WebApplicationException {

        final String methodName = "verificaFirma ";

        try {

            GateFireSrvc soap = getSoap();

            log.debug(methodName, "## RICHIESTA :");
            return soap.verificaFirma(attachment, info);
        } catch (Exception e) {
            log.error(methodName, " Errore durante la chiamata al servizio ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Errore in chiamata verifica firma")).build());
        }

    }

    private GateFireSrvc getSoap() throws MalformedURLException {
        final String methodName = "getSoap ";
        final URL wsdlURL = new URL(baseUrl + "?wsdl");
        // costruisco il service
        log.debug(methodName, "creazione servizio");
        GateFireSrvc_Service service = new GateFireSrvc_Service(wsdlURL);
        log.debug(methodName, "fine creazione servizio");
        return service.getGateFireSrvcPort();
    }
}
