/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.VerificaImpresaApi;
import it.csi.gescovid.gestruttureresapi.dto.ModelPersona;
import it.csi.gescovid.gestruttureresapi.dto.ModelSede;
import it.csi.gescovid.gestruttureresapi.dto.ModelVerificaImpresa;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.integration.aura.AuraAnagrafeService;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.DatiAnagrafici;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.DatiAnagraficiMsg;
import it.csi.gescovid.gestruttureresapi.integration.aura.generated.FindProfiliAnagraficiRequest;
import it.csi.gescovid.gestruttureresapi.integration.mef.MefService;
import it.csi.gescovid.gestruttureresapi.integration.mef.mef.InterrogaMefCovidResponseBody;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.OrchestratoreService;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.AziendaAAEP;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CercaPersoneInfoc;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.GetDettaglioImpresa2;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Persona;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.PersonaINFOC;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Sede;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.SedeAAEP;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Ubicazione;
import it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.Utente;

public class VerificaImpresaApiServiceImpl extends GestioneUtenteServiceImpl implements VerificaImpresaApi {

    @Autowired
    private OrchestratoreService orchestratoreService;
    @Autowired
    private AuraAnagrafeService auraAnagrafeService;

    @Autowired
    private MefService mefService;

    @Override
    public Response getVerificaImpresa(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, String cfPIva, String cfRappLeg, String cfTitolare,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getVerificaImpresa: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);
            checkNotNull(cfRappLeg, "codice fiscale rappresentante legale deve essere valorizzato");
            
            if (cfTitolare != null && cfRappLeg.equalsIgnoreCase(cfTitolare)) {
                cfTitolare = null;
            }
            
            GetDettaglioImpresa2 getDettaglioImpresa2 = new GetDettaglioImpresa2();
            getDettaglioImpresa2.setUtente(new Utente());
            getDettaglioImpresa2.setFonte("AAEP");
            getDettaglioImpresa2.setCodiceFiscale(cfPIva);
            getDettaglioImpresa2.setNumIscrizREA("");
            getDettaglioImpresa2.setSiglaProvCCIAA("");
            getDettaglioImpresa2.setStatoCessSEDE("");
            AziendaAAEP dettaglioImpresaResponse = orchestratoreService.getDettaglioImpresa2(getDettaglioImpresa2);
            ModelVerificaImpresa result = new ModelVerificaImpresa();
            if (dettaglioImpresaResponse != null) {
                if (Boolean.TRUE.equals(dettaglioImpresaResponse.getCessazione().isCessazione())) {
                    logAudit(httpHeaders, "orchestratore", "getDettaglioImpresa2",
                            methodName + " azienda cessata per cfPiva: " + cfPIva + " codiceFiscale: "
                                    + cfRappLeg);
                    throw buildError("Azienda Cessata", Status.NOT_ACCEPTABLE);

                }

                result.setEntGestVerificato(true);
                result.setRagioneSociale(dettaglioImpresaResponse.getRagioneSociale());
                for (Sede sede : dettaglioImpresaResponse.getSedi()) {
                    if (sede.getDescrTipoSede().equals("SEDE LEGALE")) {
                        SedeAAEP sedeAAEP = (SedeAAEP) sede;
                        ModelSede sedeLegale = new ModelSede();
                        sedeLegale.setDescrTipoSede(sedeAAEP.getDescrTipoSede());
                        Ubicazione ubicazione = sedeAAEP.getUbicazione();
                        sedeLegale.setCodISTATComune(ubicazione.getCodISTATComune());
                        sedeLegale.setSiglaProvincia(sedeAAEP.getSiglaProvUL());
                        sedeLegale.setIndirizzo(ubicazione.getToponimo() + " " + ubicazione.getIndirizzo() + " "
                                + ubicazione.getNumeroCivico());
                        sedeLegale.setDescrComune(ubicazione.getDescrComune());
                        result.setSede(sedeLegale);
                        break;
                    }
                }
            } else {
                result.setEntGestVerificato(false);
            }

            ModelPersona persona = new ModelPersona();
            result.setRapLegVerificato(false);

            if (dettaglioImpresaResponse != null) {

                CercaPersoneInfoc req = new CercaPersoneInfoc();
                req.setUtente(new Utente());
                req.setCodiceFiscaleAzienda(cfPIva);
                req.setSoloRappresentantiLegali(Boolean.TRUE);
                List<Persona> persone = orchestratoreService.cercaPersoneInfoc(req);
                if (!persone.isEmpty()) {
                    for (Persona singolo : persone) {
                        if (singolo.getCodiceFiscale().equals(cfRappLeg)) {
                            result.setRapLegVerificato(true);

                            persona.setCodiceFiscale(singolo.getCodiceFiscale());
                            persona.setCognome(singolo.getCognome());
                            persona.setNome(singolo.getNome());

                            Utente utente = new Utente();
                            PersonaINFOC personaDettaglio = orchestratoreService.getDettaglioPersonaInfoc(utente,
                                    singolo);
                            persona.setDataNascita(personaDettaglio.getDataNascita());
                            persona.setComuneNascita(personaDettaglio.getDescrComuneNascita());
                            persona.setProvinciaNascita(personaDettaglio.getSiglaProvNascita() != null
                                    ? personaDettaglio.getSiglaProvNascita()
                                    : personaDettaglio.getCodStatoNascita());
                            persona.setIndirizzoResidenza(getIndirizzo(personaDettaglio.getDescrToponimoResid(),
                                    personaDettaglio.getViaResidenza(), personaDettaglio.getNumCivicoResid()));
                            persona.setComuneResidenza(personaDettaglio.getDescrComuneRes());
                            persona.setProvinciaResidenza(personaDettaglio.getSiglaProvResidenza());

                            break;
                        }
                    }
                }
            }

            if (persona.getCodiceFiscale() == null) {
                persona = chiamataAuraPerSoggetto(cfRappLeg);
                if (persona.getCodiceFiscale() == null) {
                    logAudit(httpHeaders, "aura", "findProfiliAnagrafici",
                            methodName + " profilo anagrafico non trovato per cfPIva: " + cfPIva + " codiceFiscale: "
                                    + cfRappLeg);
                    throw buildError("codice fiscale non esistente", Status.BAD_REQUEST);
                }
            }

            result.setRappresentanteLegale(persona);
            if (cfTitolare != null) {
                result.setTitolare(chiamataAuraPerSoggetto(cfTitolare));
                result.setTitEffVerificato(true);
                if (result.getTitolare().getCodiceFiscale() == null) {
                    logAudit(httpHeaders, "aura", "findProfiliAnagrafici",
                            methodName + " profilo anagrafico non trovato per cfPIva: " + cfPIva + " cfTitolare: "
                                    + cfTitolare);
                    throw buildError("codice fiscale titolare non esistente", Status.BAD_REQUEST);
                }

            }
            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    /**
     * @param cfPIva
     * @param cfRappLeg
     * @param httpHeaders
     * @param methodName
     * @return
     * @throws Exception 
     */
    private ModelPersona chiamataAuraPerSoggetto(String cf) throws Exception {
        String methodName = "chiamataAuraPerSoggetto";
    	ModelPersona persona = new ModelPersona();

        FindProfiliAnagraficiRequest profilo = new FindProfiliAnagraficiRequest();
        profilo.setFlagDecesso("1");
        profilo.setCodiceFiscale(cf);
        DatiAnagraficiMsg datiAnagrafici = auraAnagrafeService.findProfiliAnagrafici(profilo);
        if (datiAnagrafici != null && datiAnagrafici.getBody() != null
                && datiAnagrafici.getBody().getElencoProfili() != null
                && datiAnagrafici.getBody().getElencoProfili().getDatianagrafici() != null
                && !datiAnagrafici.getBody().getElencoProfili().getDatianagrafici().isEmpty()) {

            List<DatiAnagrafici> datiAnagraficiList = datiAnagrafici.getBody().getElencoProfili()
                    .getDatianagrafici();

            DatiAnagrafici dati = datiAnagraficiList.get(0);
            persona.setCodiceFiscale(dati.getCodiceFiscale());
            persona.setNome(dati.getNome());
            persona.setCognome(dati.getCognome());
            persona.setComuneNascita(dati.getComuneNascita());
            persona.setProvinciaNascita(dati.getProvinciaNascita());
            Date dataNascita = dati.getDataNascita().toGregorianCalendar().getTime();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setTimeZone(TimeZone.getTimeZone("GMT+2"));
            persona.setDataNascita(df.format(dataNascita));

        } else {
        	//chiamiamo il mef
            InterrogaMefCovidResponseBody anagrafica = mefService.getAnagraficaCittadino(cf);

            if (anagrafica == null) {
                log.warn(methodName, "Soggetto " + cf + " sprovvisto di anagrafica! ");
            } else {
            	 persona.setCodiceFiscale(anagrafica.getCodicefiscale());
                 persona.setNome(anagrafica.getNome());
                 persona.setCognome(anagrafica.getCognome());
                 persona.setComuneNascita(anagrafica.getComunenasc());
                 persona.setProvinciaNascita(anagrafica.getProvincianasc());
                 persona.setDataNascita(anagrafica.getDatanascita());
            }
        }

        return persona;
    }

    private String getIndirizzo(String toponimo, String via, String civico) {
        return toponimo + " " + via + " " + civico;
    }
}
