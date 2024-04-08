/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.RichiestaTamponeApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidresTRichiestaTest;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidresTRichiestaTestExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidresTRichiestaTestMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaPostiMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.GeneralLogEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;

public class RichiestaTamponeApiServiceImpl extends GestioneUtenteServiceImpl implements RichiestaTamponeApi {

    private static final int DAY_OF_MONTH_16 = 16;
    private static final int DAY_OF_MONTH_15 = 15;
    private static final int DAY_OF_MONTH_1 = 1;

    @Autowired
    private CovidresTRichiestaTestMapper covidresTRichiestaTestMapper;
    @Autowired
    private RsaPostiMapper rsaPostiMapper;

    @Override
    public Response getTamponiRichiestaTest(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getTamponiRichiestaTest: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_TAMPONE_RICHIESTA),
                    httpHeaders);

            checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
            checkNotNull(idStrutturaOperazione, CaConstants.IDSTRUTTURA_OPERAZIONE_OBBLIGATORIA);
//            checkCondition(DateUtils.isSameDay(input.getDataRilevazione(), DateUtils.getNextMonday()),
            List<CovidresTRichiestaTestExt> res = covidresTRichiestaTestMapper
                    .selectFromIdStruttura(idStrutturaOperazione);

            Calendar c = Calendar.getInstance();
            Date now = covidresTRichiestaTestMapper.selectNowFromDual();

            for (CovidresTRichiestaTestExt r : res) {

                c.setTime(r.getDataApproviggionamento());
                c.add(Calendar.MONTH, -1);
                c.set(Calendar.DAY_OF_MONTH, DAY_OF_MONTH_15);
                Date to = c.getTime();
                c.add(Calendar.MONTH, -1);
                c.set(Calendar.DAY_OF_MONTH, DAY_OF_MONTH_16);
                Date from = c.getTime();

                if ((now.before(to) && now.after(from))
                        || (DateUtils.isSameDay(now, to) || DateUtils.isSameDay(now, from))) {
                    r.setModificabile(Boolean.TRUE);
                } else {
                    r.setModificabile(Boolean.FALSE);
                }
            }
            logAudit(httpHeaders, "SELECT", "covidres_t_richiesta_test",
                    "idStrutturaOperazione: " + idStrutturaOperazione);
            return Response.ok(res).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postTamponiRichiestaTest(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidresTRichiestaTest payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postTamponiRichiestaTest: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.RSA_TAMPONE_RICHIESTA),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getNumeroTest(), "numero test obbligatorio");
            Integer numeroTextMax = rsaPostiMapper.selectMaxTamponiForStruttura(idStrutturaOperazione);
            checkCondition(numeroTextMax != null,
                    "Numero massimo Tamponi richiedibili non definibile per questa struttura");
            numeroTextMax = numeroTextMax*2;
            checkCondition(payload.getNumeroTest() <= numeroTextMax,
                    "Numero massimo Tamponi richiedibili superato");

            if (payload.getRichiestaTestId() != null) {
                CovidresTRichiestaTest oldVal = covidresTRichiestaTestMapper
                        .selectByPrimaryKey(payload.getRichiestaTestId());

                int res = covidresTRichiestaTestMapper.updateValiditaFine(payload);
                checkCondition(res != 0, "richieste test da modificare non trovata");
                logAudit(httpHeaders, "update", "covidres_t_richiesta_test", methodName);

                oldVal.setRichiestaTestId(null);
                oldVal.setValiditaFine(null);
                oldVal.setValiditaInizio(null);
                oldVal.setNumeroTest(payload.getNumeroTest());
                payload = oldVal;
            } else {
                Date now = payload.getDataRichiesta() != null ? payload.getDataRichiesta()
                        : covidresTRichiestaTestMapper.selectNowFromDual();
                Calendar c = Calendar.getInstance();
                c.setTime(now);
                int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
                if (dayOfMonth >= DAY_OF_MONTH_16) {
                    c.add(Calendar.MONTH, 2);
                } else {
                    c.add(Calendar.MONTH, 1);
                }
                c.set(Calendar.DAY_OF_MONTH, DAY_OF_MONTH_1);
                c.set(Calendar.HOUR_OF_DAY, 12);

                payload.setDataApproviggionamento(c.getTime());
                payload.setIdStruttura(idStrutturaOperazione);
                payload.setDataRichiesta(now);
            }

            payload.setUtenteOperazione(utenteOperazione);
            covidresTRichiestaTestMapper.insert(payload);
            logAudit(httpHeaders, "insert", "covidres_t_richiesta_test", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }
    
    @Override
    public Response deleteTamponiRichiestaTest(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidresTRichiestaTest payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "deleteTamponiRichiestaTest: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.RSA_TAMPONE_RICHIESTA),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getRichiestaTestId(), "richiestaTestId obbligatorio");
            
            int res = covidresTRichiestaTestMapper.updateDataCancellazione(payload);
            checkCondition(res == 1,"Richiesta Tamponi da cancellare non trovata");
            
            logAudit(httpHeaders, "update", "covidres_t_richiesta_test", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }



    @Override
    public Response getTamponiRichiestaDataApprovigionamentoSuccessiva(String shibIdentitaCodiceFiscale,
            String xApplicazioneCodice, String xRequestId, String xForwardedFor, String userAgent,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getTamponiRichiestaDataApprovigionamentoSuccessiva: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");

            checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);

            Calendar c = Calendar.getInstance();
            Date now = covidresTRichiestaTestMapper.selectNowFromDual();
            c.setTime(now);
            int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            if (dayOfMonth >= DAY_OF_MONTH_16) {
                c.add(Calendar.MONTH, 2);
            } else {
                c.add(Calendar.MONTH, 1);
            }
            c.set(Calendar.DAY_OF_MONTH, DAY_OF_MONTH_16);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            return Response.ok(c.getTime()).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getTamponiRichiestaPersone(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postTamponiRichiestaTest: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_TAMPONE_RICHIESTA),
                    httpHeaders);
            
            Integer numeroTextMax = rsaPostiMapper.selectMaxTamponiForStruttura(idStrutturaOperazione);
            if(numeroTextMax == null) {
                numeroTextMax = 0;
            }
            logAudit(httpHeaders, "select", "covidres_t_richiesta_test", methodName);

            return Response.ok(numeroTextMax).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
