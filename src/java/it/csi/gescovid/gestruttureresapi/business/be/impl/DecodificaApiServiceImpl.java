/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.DecodificaApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDCondizioniOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaDStatoRendicontazioneExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaDTipoMovOspiteExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDCondizioniOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDStatoRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDTipoMovOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWelfareFasciaMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWorkflowRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRTipoMovOspiteNaturaSadMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.GeneralLogEnum;

public class DecodificaApiServiceImpl extends RESTBaseService implements DecodificaApi {
    
    @Autowired
    private CovidrsaDWelfareFasciaMapper covidrsaDWelfareFasciaMapper;

    @Autowired
    private CovidrsaDStatoRendicontazioneMapper covidrsaDStatoRendicontazioneMapper;

    @Autowired
    private CovidrsaDWorkflowRendicontazioneMapper covidrsaDWorkflowRendicontazioneMapper;

    @Autowired
    private CovidrsaDTipoMovOspiteMapper covidrsaDTipoMovOspiteMapper;
    
    @Autowired
    private CovidrsaRTipoMovOspiteNaturaSadMapper covidrsaRTipoMovOspiteNaturaSadMapper;
    
    @Autowired
    private CovidrsaDCondizioniOspiteMapper covidrsaDCondizioniOspiteMapper;
    
    @Override
    public Response getWelfareFascia(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getWelfareFascia: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            List<CovidrsaDWelfareFascia> result = covidrsaDWelfareFasciaMapper.selectAllValid();

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getStatoRendicontazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getStatoRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            List<CovidrsaDStatoRendicontazioneExt> result = covidrsaDStatoRendicontazioneMapper.selectAllValid();

            for (CovidrsaDStatoRendicontazioneExt stato : result) {
                stato.setWorkflowRendicontazione(
                        covidrsaDWorkflowRendicontazioneMapper.selectAllValidFromId(stato.getStatoRendId(),null));
            }

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getTipoMovimentoOspite(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getTipoMovimentoOspite: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            List<CovidrsaDTipoMovOspiteExt> result = covidrsaDTipoMovOspiteMapper.selectAllValid();

            for (CovidrsaDTipoMovOspiteExt movimento : result) {
                movimento.setTipoMovOspiteNaturaSod(
                        covidrsaRTipoMovOspiteNaturaSadMapper.selectAllValidfromTipoMovOspiteId(
                                movimento.getTipoMovOspiteId()));
            }

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getCondizioneOspite(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getTipoMovimentoOspite: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            List<CovidrsaDCondizioniOspite> result = covidrsaDCondizioniOspiteMapper.selectAllValid();

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }
    
}
