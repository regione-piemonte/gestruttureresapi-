/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.MovimentoApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTIntegrazionePbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTInvioPbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.UpdateStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDStatoRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTIntegrazionePbandiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTInvioPbandiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.service.CovidrsaRendicontazioneServiceImpl;
import it.csi.gescovid.gestruttureresapi.dto.custom.DichiarazioneValidazioneRequest;
import it.csi.gescovid.gestruttureresapi.dto.custom.IntegrazioneSpesaWrap;
import it.csi.gescovid.gestruttureresapi.dto.custom.Mensilitum;
import it.csi.gescovid.gestruttureresapi.enumeration.RendicontazioneUtenteEnum;

public class MovimentoApiServiceImpl extends GestioneUtenteServiceImpl implements MovimentoApi {

    private static final String UTENTE_OPERAZIONE = "pbandi";

    @Autowired
    CovidrsaTInvioPbandiMapper covidrsaTInvioPbandiMapper;

    @Autowired
    private CovidrsaTRendicontazioneMapper covidrsaTRendicontazioneMapper;

    @Autowired
    private CovidrsaRendicontazioneServiceImpl covidrsaRendicontazioneServiceImpl;

    @Autowired
    private CovidrsaDStatoRendicontazioneMapper covidrsaDStatoRendicontazioneMapper;
    
    @Autowired
    private CovidrsaTIntegrazionePbandiMapper covidrsaTIntegrazionePbandiMapper;
    
    @Override
    public Response postDichiarazioneValidazione(String xRequestId, String userAgent,
            String numeroDomanda, DichiarazioneValidazioneRequest payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postDichiarazioneValidazione: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            checkNotNull(payload, "payload obbligatorio");
            checkNotNull(payload.getValidazione_dichiarazione(), "validazione dichiarazione obbligatoria");
            // pesca per uuid
            checkNotNull(numeroDomanda, "id_dichiarazione_spesa_buonodom non valido");
            CovidrsaTInvioPbandi invioPbandi = covidrsaTInvioPbandiMapper
                    .selectByInvioPbandiCodExt(
                            payload.getValidazione_dichiarazione().getId_dichiarazione_spesa_bandi());

            checkNotNull(invioPbandi, "id_dichiarazione_spesa_buonodom sconosciuto");
            String domandaNumero = covidrsaTRendicontazioneMapper
                    .selectDomandaNumeroFromInvioPbandiId(invioPbandi.getInvioPbandiId());

            checkNotNull(domandaNumero, "domandaNumero associata non valida"); // aggiorna dati
            checkCondition(domandaNumero.equals(numeroDomanda),
                    "id_dichiarazione_spesa_buonodom non corrisponde a domandaNumero associata a dichiarazione");
            for (Mensilitum mensilita : payload.getValidazione_dichiarazione().getMensilita()) {
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.set(Calendar.YEAR, mensilita.getAnno());
                c.set(Calendar.DAY_OF_MONTH, 1);
                String mese = mensilita.getMese().startsWith("0") ? mensilita.getMese().substring(1)
                        : mensilita.getMese();
                c.set(Calendar.MONTH, Integer.valueOf(mese) - 1);
                Date dataRendicontazione = c.getTime();
                CovidrsaTRendicontazione rendicontazione = covidrsaTRendicontazioneMapper
                        .selectByRendicontazioneByInvioPBandiId(invioPbandi.getInvioPbandiId(), dataRendicontazione);
                if (rendicontazione == null) {
                    logAuditWhitoutShibIdentitaCf(httpHeaders, UTENTE_OPERAZIONE, "ERROR",
                            "covidrsa_t_rendicontazione",
                            methodName + " rendicontazione associata non esistente per id: +"
                                    + +invioPbandi.getInvioPbandiId() + " data: " + dataRendicontazione);
                    checkNotNull(rendicontazione,
                            "rendicontazione associata non esistente per data: " + dataRendicontazione);

                } else {
                    Integer newStatoId = covidrsaDStatoRendicontazioneMapper.selectIdByCod(mensilita.getEsito());
                    checkNotNull(newStatoId, "Esito: " + mensilita.getEsito() + " non valido");
                    UpdateStatoRendicontazione updateStato = new UpdateStatoRendicontazione();
                    updateStato.setOldStato(rendicontazione.getStatoRendId());
                    updateStato.setNewStato(newStatoId);

                    List<Integer> rendicontazioni = new ArrayList<>();
                    rendicontazioni.add(rendicontazione.getRendicontazioneId());
                    updateStato.setRendicontazioniId(rendicontazioni);
                    covidrsaRendicontazioneServiceImpl.postRendicontazioneStato(updateStato,
                            UTENTE_OPERAZIONE,
                            httpHeaders, null, mensilita.getNote(), RendicontazioneUtenteEnum.ENTE_GESTORE);
                    // aggiorna STATO

                }

            }

            return Response.status(Status.CREATED).entity("OK").build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postDichiarazioneIntegrazione(String xRequestId, String userAgent, String numeroDomanda,
            IntegrazioneSpesaWrap payload, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "postDichiarazioneIntegrazione: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            checkNotNull(payload, "payload obbligatorio");
            checkNotNull(payload.getIntegrazione_spesa(), "integrazione spesa obbligatoria");
            checkNotNull(numeroDomanda, "id_dichiarazione_spesa_buonodom non valido");
            // pesca per uuid
            CovidrsaTInvioPbandi invioPbandi = covidrsaTInvioPbandiMapper
                    .selectByInvioPbandiCodExt(
                            payload.getIntegrazione_spesa().getId_dichiarazione_spesa_bandi());

            checkNotNull(invioPbandi, "id_dichiarazione_spesa_buonodom sconosciuto");
            String domandaNumero = covidrsaTRendicontazioneMapper
                    .selectDomandaNumeroFromInvioPbandiId(invioPbandi.getInvioPbandiId());

            checkNotNull(domandaNumero, "domandaNumero associata non valida"); // aggiorna dati
            checkCondition(domandaNumero.equals(numeroDomanda),
                    "id_dichiarazione_spesa_buonodom non corrisponde a domandaNumero associata a dichiarazione");

            CovidrsaTIntegrazionePbandi integrazione = new CovidrsaTIntegrazionePbandi();
            integrazione.setIntegrazionePbandiCod(payload.getIntegrazione_spesa().getIdentificativo_richiesta_integrazione());
            
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(payload.getIntegrazione_spesa().getData_azione());
            integrazione.setDataRichiesta(date);
            integrazione.setNoteRichiesta(payload.getIntegrazione_spesa().getNote());
            integrazione.setInvioPbandiId(invioPbandi.getInvioPbandiId());
            integrazione.setUtenteOperazione(UTENTE_OPERAZIONE);
            if(payload.getIntegrazione_spesa().getNumero_giorni()!=null) {
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, payload.getIntegrazione_spesa().getNumero_giorni());  // number of days to add
                integrazione.setDataScadenza(c.getTime());
            }
            covidrsaTIntegrazionePbandiMapper.insert(integrazione);

            return Response.status(Status.CREATED).entity("OK").build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
