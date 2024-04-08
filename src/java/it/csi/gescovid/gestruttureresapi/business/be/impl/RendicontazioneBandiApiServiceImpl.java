/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.RendicontazioneBandiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTInvioPbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTInvioPbandiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.dto.custom.DocumentiEsitoAcquisizione;
import it.csi.gescovid.gestruttureresapi.dto.custom.EsitoAcquisizioneSpesa;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;

public class RendicontazioneBandiApiServiceImpl extends GestioneUtenteServiceImpl implements RendicontazioneBandiApi {

    @Autowired
    CovidrsaTInvioPbandiMapper covidrsaTInvioPbandiMapper;

    @Autowired
    private CovidrsaTRendicontazioneMapper covidrsaTRendicontazioneMapper;

    @Override
    public Response postRendicontazioneBandiApi(String xRequestId, String userAgent,
            String idDichiarazionespesaBuonodom, EsitoAcquisizioneSpesa payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest req) {
        final String methodName = "postRendicontazioneBandiApi: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            // pesca per uuid
            CovidrsaTInvioPbandi invioPbandi = covidrsaTInvioPbandiMapper
                    .selectByInvioPbandiCod(idDichiarazionespesaBuonodom);
            checkNotNull(invioPbandi, "id_dichiarazione_spesa_buonodom non valido");
            // aggiorna dati
            invioPbandi.setInvioPbandiCodExt(payload.getId_dichiarazione_spesa_bandi());
            invioPbandi.setCallbackData(new Date());
            if (payload.getEsito_acquisizione() != null) {
                invioPbandi.setCallbackEsito(payload.getEsito_acquisizione().getEsito());
                if (payload.getEsito_acquisizione().getErrore() != null) {
                    invioPbandi.setCallbackErrorCod(payload.getEsito_acquisizione().getErrore().getCodice());
                    invioPbandi.setCallbackErrorMessage(payload.getEsito_acquisizione().getErrore().getMessaggio());
                }

            }
            covidrsaTInvioPbandiMapper.updateByPrimaryKey(invioPbandi);
            logAuditWhitoutShibIdentitaCf(httpHeaders,"", "update", "covidrsa_t_invio_pbandi", methodName);

            if (payload.getDocumenti() != null && !payload.getDocumenti().isEmpty()) {
                for (DocumentiEsitoAcquisizione doc : payload.getDocumenti()) {
                    CovidrsaTRendicontazione rend = covidrsaTRendicontazioneMapper
                            .selectByRendicontazioneCod(doc.getId_documento_buonodom());
                    if (rend != null) {
                        rend.setRendicontazioneCodExt(doc.getId_documento_bandi());
                        covidrsaTRendicontazioneMapper.updateByPrimaryKey(rend);
                    } else {
                        logAuditWhitoutShibIdentitaCf(httpHeaders,"", "update", "covidrsa_t_rendicontazione",
                                methodName + " doc non trovato per id: " + doc.getId_documento_buonodom());
                    }
                }
            } else {
                log.info(methodName, "documenti non trovati per buonodom: " + idDichiarazionespesaBuonodom);
            }

            return Response.status(Status.CREATED).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
