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

import it.csi.gescovid.gestruttureresapi.business.be.RsaPostiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaPosti;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaPostiMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.DateUtils;

public class RsaPostiApiServiceImpl extends GestioneUtenteServiceImpl implements RsaPostiApi {

	@Autowired
	private RsaPostiMapper postiMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response inserisciRsaPosti(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaPosti input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "inserisciRsaPosti: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_POSTI),
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

			postiMapper.insert(input);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "insert", "covidrsa_t_posti", mapper.writeValueAsString(input));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response aggiornaRsaPosti(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaPosti input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "aggiornaRsaPosti: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_POSTI),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaPosti posti =  postiMapper.selectByPrimaryKey(input.getPostiId());
			posti.setUtenteOperazione(shibIdentitaCodiceFiscale);
			posti.setDataModifica(new Date());
			posti.setPostiNumTotali(input.getPostiNumTotali());
			posti.setPostiNumOccupati(input.getPostiNumOccupati());
			posti.setPostiNumOspedalizzati(input.getPostiNumOspedalizzati());
			posti.setPostiNumTotaliSingole(input.getPostiNumTotaliSingole());
			posti.setPostiNumSingoleResidue(input.getPostiNumSingoleResidue());
			posti.setAccessiInPsNum(input.getAccessiInPsNum());
			posti.setPostiNumOccupatiPaganti(input.getPostiNumOccupatiPaganti());
			posti.setPostiNumOccupatiConvenzionati(input.getPostiNumOccupatiConvenzionati());
            posti.setPostiNumOccupatiDgr23(input.getPostiNumOccupatiDgr23());
            posti.setPostiNumOccupabiliDgr10(input.getPostiNumOccupabiliDgr10());
            posti.setPostiNumOccupatiDgrUomini(input.getPostiNumOccupatiDgrUomini());
            posti.setPostiNumOccupatiDgrDonne(input.getPostiNumOccupatiDgrDonne());
            posti.setPostiNumOccupabiliDgrUomini(input.getPostiNumOccupabiliDgrUomini());
            posti.setPostiNumOccupabiliDgrDonne(input.getPostiNumOccupabiliDgrDonne());
            
            posti.setPostiNumLiberi(input.getPostiNumLiberi());
            posti.setPostiNumOccupatiPagantiSs(input.getPostiNumOccupatiPagantiSs());
           
            posti.setPostiNumSollievoOccupati(input.getPostiNumSollievoOccupati());
            posti.setPostiNumSollievoLiberi(input.getPostiNumSollievoLiberi());
            posti.setPostiNumSollievoLiberiUomini(input.getPostiNumSollievoLiberiUomini());
            posti.setPostiNumSollievoLiberiDonne(input.getPostiNumSollievoLiberiDonne());
            posti.setPostiNumSollievoLiberiIndiff(input.getPostiNumSollievoLiberiIndiff());
            
            posti.setPostiNumDimProtOccupati(input.getPostiNumDimProtOccupati());
            posti.setPostiNumDimProtLiberi(input.getPostiNumDimProtLiberi());
            posti.setPostiNumDimProtLiberiUomini(input.getPostiNumDimProtLiberiUomini());
            posti.setPostiNumDimProtLiberiDonne(input.getPostiNumDimProtLiberiDonne());
            posti.setPostiNumDimProtLiberiIndiff(input.getPostiNumDimProtLiberiIndiff());
            
            posti.setPostiNumCavsOccupati(input.getPostiNumCavsOccupati());
            posti.setPostiNumCavsLiberi(input.getPostiNumCavsLiberi());
            posti.setPostiNumCavsLiberiUomini(input.getPostiNumCavsLiberiUomini());
            posti.setPostiNumCavsLiberiDonne(input.getPostiNumCavsLiberiDonne());
            posti.setPostiNumCavsLiberiIndiff(input.getPostiNumCavsLiberiIndiff());
            
            posti.setPostiNumLungodegOccupati(input.getPostiNumLungodegOccupati());
            posti.setPostiNumLungodegLiberi(input.getPostiNumLungodegLiberi());
            posti.setPostiNumLungodegLiberiUomini(input.getPostiNumLungodegLiberiUomini());
            posti.setPostiNumLungodegLiberiDonne(input.getPostiNumLungodegLiberiDonne());
            posti.setPostiNumLungodegLiberiIndiff(input.getPostiNumLungodegLiberiIndiff());
            
            posti.setPostiNumHospiceOccupati(input.getPostiNumHospiceOccupati());
            posti.setPostiNumHospiceLiberi(input.getPostiNumHospiceLiberi());
            posti.setPostiNumHospiceLiberiUomini(input.getPostiNumHospiceLiberiUomini());
            posti.setPostiNumHospiceLiberiDonne(input.getPostiNumHospiceLiberiDonne());
            posti.setPostiNumHospiceLiberiIndiff(input.getPostiNumHospiceLiberiIndiff());
            
            posti.setPostiNumLiberiDonne(input.getPostiNumLiberiDonne());
            posti.setPostiNumLiberiUomini(input.getPostiNumLiberiUomini());
            posti.setPostiNumLiberiIndiff(input.getPostiNumLiberiIndiff());
            
            postiMapper.updateByPrimaryKey(posti);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_posti", mapper.writeValueAsString(posti));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response cancellaRsaPosti(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			RsaPosti input, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "cancellaRsaPosti: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_POSTI),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			RsaPosti posti =  postiMapper.selectByPrimaryKey(input.getPostiId());
			posti.setUtenteOperazione(shibIdentitaCodiceFiscale);
			Date now = new Date();
			posti.setDataModifica(new Date());
			posti.setDataCancellazione(now);

			postiMapper.updateByPrimaryKey(posti);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "covidrsa_t_posti", mapper.writeValueAsString(posti));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

}
