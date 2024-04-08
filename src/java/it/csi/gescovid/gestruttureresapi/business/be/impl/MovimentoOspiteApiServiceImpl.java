/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.MovimentoOspiteApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.SoggettoStrutturaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTMovimentoOspiteExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDTipoMovOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTMovimentoOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.SoggettoStrutturaInfoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.business.service.SoggettoServiceImpl;
import it.csi.gescovid.gestruttureresapi.dto.ModelErrore;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.exception.RESTException;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.CaRet;

public class MovimentoOspiteApiServiceImpl extends GestioneUtenteServiceImpl implements MovimentoOspiteApi {

    @Autowired
    private CovidrsaTMovimentoOspiteMapper covidrsaTMovimentoOspiteMapper;

    @Autowired
    private CovidrsaDTipoMovOspiteMapper covidrsaDTipoMovOspiteMapper;

    @Autowired
    private SoggettoStrutturaInfoMapper ssiMapper;

    @Autowired
    private SoggettoServiceImpl movimentoOspiteServiceImpl;

    @Override
    public Response getMovimentoOspite(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, Integer idSoggetto, String orderby, Long rowPerPage, Long pageNumber,
            Boolean descending, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getMovimentoOspite: ";

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_MOVIMENTO_OSPITE),
                    httpHeaders);

            Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, descending);
            List<CovidrsaTMovimentoOspiteExt> res = covidrsaTMovimentoOspiteMapper
                    .selectFromIdSoggettoAndIdStruttura(idSoggetto, idStrutturaOperazione, paginazione);
            logAudit(httpHeaders, "select", "covidrsa_t_movimento_ospite", methodName);

            return Response.ok(res).build();

        } catch (RESTException e) {
            log.error(methodName, " ERROR RESTException", e);
            return e.getResponse();
        } catch (Exception e) {
            log.error(methodName, " ERROR Exception", e);
            return CaRet.internalServerErrResponse();
        }
    }

    @Override
    public Response postMovimentoOspite(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, CovidrsaTMovimentoOspite payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postMovimentoOspite: ";

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.RSA_MOVIMENTO_OSPITE),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getIdSoggetto(), CaConstants.ID_SOGGETTO_OBBLIGATORIO);
            checkNotNull(payload.getDataMovimento(), "data movimento obbligatoria");
            checkNotNull(payload.getTipoMovOspiteId(), "tipo movimento ospite id obbligatorio");
            CovidrsaDTipoMovOspite tipoMovimento = covidrsaDTipoMovOspiteMapper
                    .selectByPrimaryKey(payload.getTipoMovOspiteId());
            checkNotNull(tipoMovimento, "tipo movimento ospite non esistente");
            if (Boolean.TRUE.equals(tipoMovimento.getFlgIngresso())) {
                payload.setFlgPreservaPosto(Boolean.FALSE);
            }

            checkNotNull(payload.getFlgPreservaPosto(), "flag preserva posto obbligatorio");

            payload.setIdStruttura(idStrutturaOperazione);
            payload.setUtenteOperazione(utenteOperazione);
            payload.setMovimentoOspiteId(null);

            covidrsaTMovimentoOspiteMapper.insert(payload);
            logAudit(httpHeaders, "insert", "covidrsa_t_movimento_ospite", methodName);
            // SE � UN USCITA O UN INGRESSO VAI A MODIFICARE L'ALTRA
            // covidres_r_soggetto_struttura_info

            if (Boolean.FALSE.equals(tipoMovimento.getFlgIngresso())
                    && Boolean.FALSE.equals(payload.getFlgPreservaPosto())) {
                List<SoggettoStrutturaInfo> ssiList = ssiMapper.selectValidByIdSoggettoAndIdStruttura(
                        Long.valueOf(payload.getIdSoggetto()), payload.getIdStruttura(), true);

                ObjectMapper mapper = new ObjectMapper();

                if (ssiList != null) {
                    for (SoggettoStrutturaInfo ssi : ssiList) {
                        ssi.setValiditaFine(new Date());
                        ssi.setUtenteOperazione(shibIdentitaCodiceFiscale);
                        ssiMapper.updateByPrimaryKey(ssi);
                        logAudit(httpHeaders, "update", "covidres_r_soggetto_struttura_info",
                                mapper.writeValueAsString(ssi));
                    }
                }
            } else if (Boolean.TRUE.equals(tipoMovimento.getFlgIngresso())) {
                int ret = ssiMapper.invalidSsSoggettoByIdSoggettoIdStrutturaFlgOspite(Long.valueOf(payload.getIdSoggetto()), payload.getIdStruttura(), true, shibIdentitaCodiceFiscale);
                log.info(methodName, "Sono state invalidate " + ret + " struttura per il soggetto " + payload.getIdSoggetto());
                
                ModelErrore errore = new ModelErrore();
                
                    try {
                        movimentoOspiteServiceImpl.associaSoggettoAStrutturaRes(shibIdentitaCodiceFiscale, httpHeaders, methodName, new Date(), Long.valueOf(payload.getIdSoggetto()), payload.getIdStruttura(), true);
                    } catch (Exception e) {
                        log.error(methodName, " ERROR associaSoggettoAStrutturaRes idSoggetto: "+payload.getIdSoggetto()+" idStrutturaRes: "+payload.getIdStruttura());
                        logAudit(httpHeaders, "rollback", "covidres_r_soggetto_struttura_info", "errore inserimento id_struttura: " + payload.getIdStruttura() + " id_soggetto: " + payload.getIdSoggetto());  
                        errore.setMessaggio("immpossibile associare soggetto alla struttura");
                        throw e;
                    }
                
            }
            // se � uscita e NON HO IL PRESERVA POSTO fai lo stesso sql che c'� in soggetto
            // elimina associazione.
            // se ingresso devo fare il controllo come in inserimento associativa e inserire
            // il record.

            return Response.ok(payload).build();

        } catch (RESTException e) {
            log.error(methodName, " ERROR RESTException", e);
            return e.getResponse();
        } catch (Exception e) {
            log.error(methodName, " ERROR Exception", e);
            return CaRet.internalServerErrResponse();
        }
    }

    @Override
    public Response deleteMovimentoOspite(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidrsaTMovimentoOspite payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postMovimentoOspite: ";

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.RSA_MOVIMENTO_OSPITE),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getMovimentoOspiteId(), "movimento ospite id obbligatorio");
            int res = covidrsaTMovimentoOspiteMapper.logicDeleteByPrimaryKey(payload);
            checkCondition(res!=0, "movimento ospite da cancellare non trovato");
            
            logAudit(httpHeaders, "update", "covidrsa_t_movimento_ospite", methodName);

            return Response.ok().build();

        } catch (RESTException e) {
            log.error(methodName, " ERROR RESTException", e);
            return e.getResponse();
        } catch (Exception e) {
            log.error(methodName, " ERROR Exception", e);
            return CaRet.internalServerErrResponse();
        }
    }
}
