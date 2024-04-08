/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.RsaDecessiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaDecessi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaDecessiMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.DateUtils;

public class RsaDecessiApiServiceImpl extends GestioneUtenteServiceImpl implements RsaDecessiApi{

	@Autowired
	private RsaDecessiMapper decessiMapper;


	@Override
	public Response inserisciRsaDecessi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaDecessi input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "inserisciRsaDecessi: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_DECESSO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(input.getDataRilevazione(), CaConstants.DATA_RILEVAZIONE_OBBLIGATORIA);
			checkCondition(DateUtils.isSameDay(input.getDataRilevazione(), DateUtils.getNextMonday()),
					String.format(CaConstants.DATA_RILEVAZIONE_NON_CONFORME,input.getDataRilevazione()));


			Date now = new Date();

			input.setUtenteOperazione(shibIdentitaCodiceFiscale);
			input.setDataCreazione(now);
			input.setDataModifica(now);

			Calendar calValiditaInizio = Calendar.getInstance();
			calValiditaInizio.setTime(input.getDataRilevazione());
			calValiditaInizio.add(Calendar.DATE, -7);
			input.setValiditaInizio(calValiditaInizio.getTime());

			Calendar calValiditaFine = Calendar.getInstance();
			calValiditaFine.setTime(input.getDataRilevazione());
			calValiditaFine.add(Calendar.DATE, -1);
			input.setValiditaFine(calValiditaFine.getTime());

			decessiMapper.insert(input);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "insert", "covidrsa_t_decessi", mapper.writeValueAsString(input));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	public Response aggiornaRsaDecessi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaDecessi input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "aggiornaRsaDecessi: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_DECESSO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaDecessi decessi =  decessiMapper.selectByPrimaryKey(input.getDecId());
			decessi.setUtenteOperazione(shibIdentitaCodiceFiscale);
			Date now = new Date();
			decessi.setDataModifica(now);
			decessi.setDecNumUltimaSettimana(input.getDecNumUltimaSettimana());
			decessi.setDecNumCovidUltimaSettimana(input.getDecNumCovidUltimaSettimana());
			decessi.setDecNumInStruttura(input.getDecNumInStruttura());
			decessi.setDecNumInStrutturaCovid(input.getDecNumInStrutturaCovid());
			decessi.setDecNumInOspedale(input.getDecNumInOspedale());
			decessi.setDecNumInOspedaleCovid(input.getDecNumInOspedaleCovid());
			decessi.setDecNumInStrutturaUltimaSettimana(input.getDecNumInStrutturaUltimaSettimana());
			decessi.setDecNumInStrutturaCovidUltimaSettimana(input.getDecNumInStrutturaCovidUltimaSettimana());
			decessi.setDecNumInOspedaleUltimaSettimana(input.getDecNumInOspedaleUltimaSettimana());
			decessi.setDecNumInOspedaleCovidUltimaSettimana(input.getDecNumInOspedaleCovidUltimaSettimana());

			decessiMapper.updateByPrimaryKey(decessi);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_decessi", mapper.writeValueAsString(decessi));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	public Response cancellaRsaDecessi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaDecessi input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "cancellaRsaDecessi: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_DECESSO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaDecessi decessi =  decessiMapper.selectByPrimaryKey(input.getDecId());
			decessi.setUtenteOperazione(shibIdentitaCodiceFiscale);
			Date now = new Date();
			decessi.setDataModifica(new Date());
			decessi.setDataCancellazione(now);

			decessiMapper.updateByPrimaryKey(decessi);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_decessi", mapper.writeValueAsString(decessi));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

}
