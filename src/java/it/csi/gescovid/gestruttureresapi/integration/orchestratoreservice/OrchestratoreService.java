/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Message;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.AziendaAAEP;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CSIException_Exception;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CercaPersoneInfoc;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.GetDettaglioImpresa2;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Impresa;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.OrchestratoreImplService;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.OrchestratoreIntf;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Persona;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.PersonaINFOC;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Utente;

@Service
public class OrchestratoreService extends RESTBaseService {

    @Value("${orchestratore.wsdl.url}")
    private String baseUrl;

    /**
     * 
     * @param request
     * @return
     */
    public List<Persona> cercaPersoneInfoc(CercaPersoneInfoc request) throws WebApplicationException {

        String methodName = "cercaPersoneInfoc | ";

        try {

            OrchestratoreIntf soap = getOrchestratoreIntF();

            log.debug(methodName, "## RICHIESTA :");
            log.debug(methodName, "##  CodiceFiscaleAzienda: " + request.getCodiceFiscaleAzienda());

            return soap.cercaPersoneInfoc(request.getUtente(), request.getCodiceFiscaleAzienda(),
                    request.isSoloRappresentantiLegali());
        } catch (Exception e) {
            log.error(methodName, " Errore durante la chiamata al servizio ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Server Error")).build());
        }

    }

    /**
     * 
     * @param request
     * @return
     */
    public PersonaINFOC getDettaglioPersonaInfoc(Utente utente, Persona request) throws WebApplicationException {

        String methodName = "cercaPersoneInfoc | ";

        try {

            OrchestratoreIntf soap = getOrchestratoreIntF();

            log.debug(methodName, "## RICHIESTA :");

            return (PersonaINFOC) soap.getDettaglioPersonaInfoc(utente, request);
        } catch (Exception e) {
            log.error(methodName, " Errore durante la chiamata al servizio ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Server Error")).build());
        }

    }

    @SuppressWarnings("unchecked")
    public <T extends Impresa> T getDettaglioImpresa2(GetDettaglioImpresa2 request) throws WebApplicationException {
        if (request.getFonte().equals("AAEP")) {
            return (T) getDettaglioImpresa2(request, AziendaAAEP.class);
        } else {
            return (T) getDettaglioImpresa2(request, Impresa.class);
        }
    }

    /**
     * 
     * @param request
     * @return
     */
    private <T> T getDettaglioImpresa2(GetDettaglioImpresa2 request, Class<T> clazz) throws WebApplicationException {

        String methodName = "cercaPersoneInfoc | ";

        try {

            OrchestratoreIntf soap = getOrchestratoreIntF();

            log.debug(methodName, "## RICHIESTA :");
            log.debug(methodName, "##  CodiceFiscale: " + request.getCodiceFiscale());

            return clazz
                    .cast(soap.getDettaglioImpresa2(request.getUtente(), request.getFonte(), request.getCodiceFiscale(),
                            request.getStatoCessSEDE(), request.getSiglaProvCCIAA(), request.getNumIscrizREA()));
        } catch (CSIException_Exception e) {
            log.error(methodName, " Errore durante la chiamata al servizio ", e);
            if(e.getMessage().contains("cercaPerCodiceFiscaleAAEP2: Nessun record trovato")) {
                return null;
            }
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Server Error")).build());
        } catch (Exception e) {
            log.error(methodName, " Errore durante la chiamata al servizio ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Server Error")).build());
        }

    }

    private OrchestratoreIntf getOrchestratoreIntF() throws MalformedURLException {
        String methodName = "getOrchestratoreIntF | ";
        final URL wsdlURL = new URL(baseUrl + "?wsdl");
        // costruisco il service
        log.debug(methodName, "creazione servizio");
        OrchestratoreImplService service = new OrchestratoreImplService(wsdlURL);
        log.debug(methodName, "fine creazione servizio");
        return service.getOrchestratoreImplPort();
    }
}
