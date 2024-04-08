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

import it.csi.gescovid.gestruttureresapi.business.be.StrutturaContoApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRStrutturaConto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaContoExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaContoMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.exception.RESTException;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.CaRet;

public class StrutturaContoApiServiceImpl extends GestioneUtenteServiceImpl implements StrutturaContoApi {
	
	@Autowired
	private CovidrsaRStrutturaContoMapper covidrsaRStrutturaContoMapper;

    @Override
    public Response getStrutturaConto(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getStrutturaConto: ";
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_CONTO),
                    httpHeaders);


            //covidrsa_r_struttura_conto 
            //get lista con filtro su id_struttura e si va in join con 
            //covidrsa_t_struttura_info sti_id con sti_id 
            //sotto verify
            //covidrsa_r_struttura_conto 
            //get --> scarta quelli con data cancellazione valorizzata
            //quelle non valide sono da tirare su.
            //update/insert unica questi campi:
            //   str_conto_iban              TEXT      NOT NULL,
            //   str_conto_istituto          TEXT      NOT NULL,
            //   str_conto_desc              TEXT      NOT NULL,
            //   flg_default                 BOOLEAN   NOT NULL,
            //   validita_inizio             TIMESTAMP NOT NULL DEFAULT NOW(),
            //   validita_fine               TIMESTAMP     NULL,

            List<CovidrsaRStrutturaContoExt> list = covidrsaRStrutturaContoMapper.selectFromIdStruttura(idStrutturaOperazione, Boolean.FALSE);
            logAudit(httpHeaders, "select", "covidrsa_r_struttura_conto", methodName);

            return Response.ok(list).build();

        } catch (RESTException e) {
            log.error(methodName, " ERROR RESTException", e);
            return e.getResponse();
        } catch (Exception e) {
            log.error(methodName, " ERROR Exception", e);
            return CaRet.internalServerErrResponse();
        }
    }

    @Override
    public Response postStrutturaConto(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, CovidrsaRStrutturaContoExt payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postStrutturaConto: ";
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_CONTO),
                    httpHeaders);
            


            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getStrContoIban(), "str conto iban non valorizzato");
            checkNotNull(payload.getStrContoIstituto(), "str conto istituto non valorizzato");
            checkNotNull(payload.getStrContoDesc(), "str conto desc non valorizzato");
            checkNotNull(payload.getFlgDefault(), "flag default non valorizzato");
            checkNotNull(payload.getStiId(), "stiId non valorizzato");
            
            String idStrutturaConto = covidrsaRStrutturaContoMapper.selectIdStrutturaByStiId(payload.getStiId());
            checkCondition(idStrutturaOperazione.equals(idStrutturaConto),
                    "idStruttura associata a conto non coincide con idStrutturaOperazione");

            payload.setUtenteOperazione(utenteOperazione);
            
            if(Boolean.TRUE.equals(payload.getFlgDefault())) {
                covidrsaRStrutturaContoMapper.updateByIdStrutturaAndKeyAndDefault(payload);
            } else {
                //se e' l'unico conto setta a true il flagDefault
                List<CovidrsaRStrutturaContoExt> res = covidrsaRStrutturaContoMapper.selectFromIdStruttura(idStrutturaConto, Boolean.TRUE);
                if(res == null || res.isEmpty()) {
                    payload.setFlgDefault(Boolean.TRUE);
                }
            }
            
            if(payload.getStrContoId() != null)  {
                covidrsaRStrutturaContoMapper.updateByPrimaryKeyWhitDataModifica(payload);
                logAudit(httpHeaders, "update", "covidrsa_r_struttura_conto", methodName);
            } else {
                covidrsaRStrutturaContoMapper.insert(payload);
                logAudit(httpHeaders, "insert", "covidrsa_r_struttura_conto", methodName);
            }
 
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
    public Response invalidaStrutturaConto(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidrsaRStrutturaConto payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "deleteStrutturaConto: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_CONTO),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getStrContoId(), "str conto id non valorizzato");
            payload.setUtenteOperazione(utenteOperazione);
            payload.setFlgDefault(Boolean.FALSE);
            int res = covidrsaRStrutturaContoMapper.invalidaByPrimaryKey(payload);
            checkCondition(res!=0, "record associato gia' cancellato");
            
            logAudit(httpHeaders, "update", "covidrsa_r_struttura_conto", methodName);
 
            return Response.ok(payload).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
