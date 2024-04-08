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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.RsaTamponiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaTamponi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaTamponiMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.DateUtils;

public class RsaTamponeApiServiceImpl extends GestioneUtenteServiceImpl implements RsaTamponiApi {

	@Autowired
	private RsaTamponiMapper rsaTamponeMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response inserisciRsaTamponi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaTamponi input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "inserisciRsaTamponi: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_TAMPONE),
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

			rsaTamponeMapper.insert(input);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "insert", "covidrsa_t_tamponi", mapper.writeValueAsString(input));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response aggiornaRsaTamponi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaTamponi input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "aggiornaRsaTamponi: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_TAMPONE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaTamponi tamponi =  rsaTamponeMapper.selectByPrimaryKey(input.getTampId());
			tamponi.setUtenteOperazione(shibIdentitaCodiceFiscale);
			tamponi.setDataModifica(new Date());
			tamponi.setTampNumTotali(input.getTampNumTotali());
			tamponi.setTampNumPositivi(input.getTampNumPositivi());
			tamponi.setTampNumNegativi(input.getTampNumNegativi());
			tamponi.setTampNumInAttesa(input.getTampNumInAttesa());
			tamponi.setTampNumIndeterminati(input.getTampNumIndeterminati());
			tamponi.setTampNumDubbi(input.getTampNumDubbi());

			rsaTamponeMapper.updateByPrimaryKey(tamponi);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_tamponi", mapper.writeValueAsString(tamponi));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response cancellaRsaTamponi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaTamponi input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "cancellaRsaTamponi: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_TAMPONE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaTamponi tamponi =  rsaTamponeMapper.selectByPrimaryKey(input.getTampId());
			tamponi.setUtenteOperazione(shibIdentitaCodiceFiscale);
			Date now = new Date();
			tamponi.setDataModifica(new Date());
			tamponi.setDataCancellazione(now);

			rsaTamponeMapper.updateByPrimaryKey(tamponi);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_tamponi", mapper.writeValueAsString(tamponi));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

}
