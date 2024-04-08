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

import it.csi.gescovid.gestruttureresapi.business.be.RsaOspitiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaCovid;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaCovidMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.DateUtils;

public class RsaOspitiApiServiceImpl extends GestioneUtenteServiceImpl implements RsaOspitiApi {

	@Autowired
	private RsaCovidMapper covidMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response inserisciRsaCovid(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaCovid input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "inserisciRsaCovid: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_OSPITE),
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

			covidMapper.insert(input);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "insert", "covidrsa_t_covid", mapper.writeValueAsString(input));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response aggiornaRsaCovid(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaCovid input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "aggiornaRsaCovid: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_OSPITE),
                    httpHeaders);


			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaCovid ospiti =  covidMapper.selectByPrimaryKey(input.getCovidId());
			ospiti.setUtenteOperazione(shibIdentitaCodiceFiscale);
			ospiti.setDataModifica(new Date());
			ospiti.setCovidNumSospetti(input.getCovidNumSospetti());
			ospiti.setCovidNumIsolati(input.getCovidNumIsolati());
			ospiti.setCovidNumOspedalizzati(input.getCovidNumOspedalizzati());

			covidMapper.updateByPrimaryKey(ospiti);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_covid", mapper.writeValueAsString(ospiti));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response cancellaRsaCovid(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaCovid input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "cancellaRsaCovid: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_OSPITE),
                    httpHeaders);


			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaCovid ospiti =  covidMapper.selectByPrimaryKey(input.getCovidId());
			ospiti.setUtenteOperazione(shibIdentitaCodiceFiscale);
			Date now = new Date();
			ospiti.setDataModifica(new Date());
			ospiti.setDataCancellazione(now);

			covidMapper.updateByPrimaryKey(ospiti);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_covid", mapper.writeValueAsString(ospiti));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

}
