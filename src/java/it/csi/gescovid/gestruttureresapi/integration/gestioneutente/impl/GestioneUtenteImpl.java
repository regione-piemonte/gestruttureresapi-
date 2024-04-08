/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.CurrentOperatorTypeEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.GestioneUtenteInteface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Funzione;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelResponse;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator.BaseUtenteOperazioneInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator.CurrentOperator;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteOperazioneCodProfiloInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteOperazioneInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteRefertanteInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteRichiedenteInterface;
import it.csi.gescovid.gestruttureresapi.util.SpringSupportedResource;

@Service
public class GestioneUtenteImpl extends SpringSupportedResource implements GestioneUtenteInteface {

	public Logger log = Logger.getLogger(getClass());

	@Value("${gestioneutente.gateway}")
	private String basePath;

	@Value("${gestioneutente.user.auth}")
	private String username;

	@Value("${gestioneutente.pwd.auth}")
	private String password;

	@Value("${gestioneutente.webapp}")
	private String webapp;

	@Override
	public <T> T verifyCurrentUserWhitProfilo(UtenteOperazioneCodProfiloInterface currentOperator,
			CurrentOperatorTypeEnum operator, ProfiloTypeEnum profiloEnumToBeVerified, UserTypeEnum userTypeEnum,
			Funzione function, MultivaluedMap<String, String> header) {
		return getVerifyCurrentUserWhitProfilo(currentOperator, null, currentOperator.getCodProfiloOperazione(),
				operator, profiloEnumToBeVerified, userTypeEnum, function, header);
	}

	@Override
	public <T> T verifyCurrentUserWhitProfilo(UtenteOperazioneInterface currentOperator,
			CurrentOperatorTypeEnum operator, ProfiloTypeEnum profiloEnumToBeVerified, UserTypeEnum userTypeEnum,
			Funzione function, MultivaluedMap<String, String> header) {
		return getVerifyCurrentUserWhitProfilo(currentOperator, currentOperator.getIdProfiloOperazione(), null,
				operator, profiloEnumToBeVerified, userTypeEnum, function, header);
	}

	@Override
	public <T> T verifyCurrentUser(UtenteOperazioneCodProfiloInterface currentOperator,
			CurrentOperatorTypeEnum operator, UserTypeEnum userTypeEnum, Funzione function,
			MultivaluedMap<String, String> header) {
		return getVerifyCurrentUser(currentOperator, null, currentOperator.getCodProfiloOperazione(), operator,
				userTypeEnum, function, header);
	}

	@Override
	public <T> T verifyCurrentUser(UtenteOperazioneInterface currentOperator, CurrentOperatorTypeEnum operator,
			UserTypeEnum userTypeEnum, Funzione function, MultivaluedMap<String, String> header) {
		return getVerifyCurrentUser(currentOperator, currentOperator.getIdProfiloOperazione(), null, operator,
				userTypeEnum, function, header);

	}

	@Override
	public <T> T verifyCurrentUserRichiedente(UtenteRichiedenteInterface currentOperatorRichiedente,
			CurrentOperatorTypeEnum operator, UserTypeEnum userTypeEnum, Funzione function,
			MultivaluedMap<String, String> header) {
		CurrentOperator currentOperator = new CurrentOperator(currentOperatorRichiedente);
		return verifyCurrentUser(currentOperator, operator, userTypeEnum, function, header);
	}
    @Override
    public ModelResponse verifyCurrentUserRichiedente(UtenteRichiedenteInterface currentOperatorRichiedente,
            CurrentOperatorTypeEnum operator, Set<UserTypeEnum> userTypeEnum, Funzione function,
            MultivaluedMap<String, String> header) {
        CurrentOperator currentOperator = new CurrentOperator(currentOperatorRichiedente);
        return verifyCurrentUser(currentOperator, operator, userTypeEnum, function, header);
    }



	@Override
	public <T> T verifyCurrentUserRefertentante(UtenteRefertanteInterface currentOperatorRefertante,
			CurrentOperatorTypeEnum operator, UserTypeEnum userTypeEnum, Funzione function,
			MultivaluedMap<String, String> header) {
		CurrentOperator currentOperator = new CurrentOperator(currentOperatorRefertante);
		return verifyCurrentUser(currentOperator, operator, userTypeEnum, function, header);
	}
	
    @Override
    public ModelResponse verifyCurrentUserRefertentante(UtenteRefertanteInterface currentOperatorRefertante,
            CurrentOperatorTypeEnum operator, Set<UserTypeEnum> userTypeEnum, Funzione function,
            MultivaluedMap<String, String> header) {
        CurrentOperator currentOperator = new CurrentOperator(currentOperatorRefertante);
        return verifyCurrentUser(currentOperator, operator, userTypeEnum, function, header);
    }



	@Override
	public ModelResponse verifyCurrentUser(UtenteOperazioneInterface currentOperator, CurrentOperatorTypeEnum operator,
			Set<UserTypeEnum> userTypeEnum, Funzione function, MultivaluedMap<String, String> header) {
		if (userTypeEnum != null && !userTypeEnum.isEmpty()) {
			if (userTypeEnum.size() == 1) {
				userTypeEnum.add(UserTypeEnum.COD_PROFILO);
			}
			List<String> value = new ArrayList<>();
			for (UserTypeEnum u : userTypeEnum) {
				value.add(u.getValue());
			}
			header.put("userTypeReturn", value);
		}
		return getVerifyCurrentUser(currentOperator, currentOperator.getIdProfiloOperazione(), null, operator,
				ModelResponse.class, function, header);
	}

	private <T> T getVerifyCurrentUser(BaseUtenteOperazioneInterface currentOperator, Integer idProfiloOperazione,
			String codProfiloOperazione, CurrentOperatorTypeEnum operator, Class<T> returnClass, Funzione function,
			MultivaluedMap<String, String> header) throws WebApplicationException {
		String path = "verifyuser";
		List<String> queryParam = setDefaultQueryParam(currentOperator, idProfiloOperazione, codProfiloOperazione,
				function, operator);

		return verifyCallWhitBooleanResponse(header, queryParam, path, returnClass);
	}

	private <T> T getVerifyCurrentUserWhitProfilo(BaseUtenteOperazioneInterface currentOperator,
			Integer idProfiloOperazione, String codProfiloOperazione, CurrentOperatorTypeEnum operator,
			String codProfiloToBeVerified, Class<T> returnClass, Funzione function,
			MultivaluedMap<String, String> header) throws WebApplicationException {
		String path = "verifyuser/hasprofile";
		List<String> queryParam = setDefaultQueryParam(currentOperator, idProfiloOperazione, codProfiloOperazione,
				function, operator);

		GestioneUtenteClient.setElementIfExist(codProfiloToBeVerified, queryParam, "codProfilo");

		return verifyCallWhitBooleanResponse(header, queryParam, path, returnClass);
	}

	@SuppressWarnings("unchecked")
	private <T> T getVerifyCurrentUserWhitProfilo(BaseUtenteOperazioneInterface currentOperator,
			Integer idProfiloOperazione, String codProfiloOperazione, CurrentOperatorTypeEnum operator,
			ProfiloTypeEnum profiloEnumToBeVerified, UserTypeEnum userTypeEnum, Funzione function,
			MultivaluedMap<String, String> header) {
		setDefaultHeaderParam(userTypeEnum, header);
		return (T) getVerifyCurrentUserWhitProfilo(currentOperator, idProfiloOperazione, codProfiloOperazione, operator,
				profiloEnumToBeVerified != null ? profiloEnumToBeVerified.getCodProfilo() : null,
				userTypeEnum.getClazz(), function, header);
	}

	@SuppressWarnings("unchecked")
	private <T> T getVerifyCurrentUser(BaseUtenteOperazioneInterface currentOperator, Integer idProfiloOperazione,
			String codProfiloOperazione, CurrentOperatorTypeEnum operator, UserTypeEnum userTypeEnum, Funzione function,
			MultivaluedMap<String, String> header) throws WebApplicationException {
		setDefaultHeaderParam(userTypeEnum, header);
		return (T) getVerifyCurrentUser(currentOperator, idProfiloOperazione, codProfiloOperazione, operator,
				userTypeEnum.getClazz(), function, header);
	}

	/**
	 * @param userTypeEnum
	 * @param header
	 */
	private void setDefaultHeaderParam(UserTypeEnum userTypeEnum, MultivaluedMap<String, String> header) {
		header.add("userTypeReturn", userTypeEnum.getValue());
	}

	/**
	 * @param webappOperazione
	 * @param idProfiloOperazione
	 * @param ruoloOperazione
	 * @param utenteOperazione
	 * @param idEnteOperazione
	 * @param idStrutturaOperazione
	 * @param idAreaOperazione
	 * @param operator
	 * @return
	 */
	protected List<String> setDefaultQueryParam(BaseUtenteOperazioneInterface currentOperator,
			Integer idProfiloOperazione, String codProfiloOperazione, Funzione function,
			CurrentOperatorTypeEnum operator) {
		List<String> queryParam = new ArrayList<>();
		GestioneUtenteClient.setElementIfExist(currentOperator.getWebappOperazione(), queryParam, "webappOperazione");
		GestioneUtenteClient.setElementIfExist(currentOperator.getRuoloOperazione(), queryParam, "ruoloOperazione");
		GestioneUtenteClient.setElementIfExist(currentOperator.getUtenteOperazione(), queryParam, "utenteOperazione");
		GestioneUtenteClient.setElementIfExist(currentOperator.getIdEnteOperazione(), queryParam, "idEnteOperazione");
		GestioneUtenteClient.setElementIfExist(currentOperator.getIdStrutturaOperazione(), queryParam,
				"idStrutturaOperazione");
		GestioneUtenteClient.setElementIfExist(currentOperator.getIdAreaOperazione(), queryParam, "idAreaOperazione");
		GestioneUtenteClient.setElementIfExist(webapp, queryParam, "webappBeChiamante");
		GestioneUtenteClient.setElementIfExist(function.getVisibilita(), queryParam, "funzioneVisibilita");
		GestioneUtenteClient.setElementIfExist(function.getFunzione(), queryParam, "funzione");
		if (idProfiloOperazione == null) {
			GestioneUtenteClient.setElementIfExist(codProfiloOperazione, queryParam, "codProfiloOperazione");
		} else {
			GestioneUtenteClient.setElementIfExist(idProfiloOperazione, queryParam, "idProfiloOperazione");
		}
		if (!CurrentOperatorTypeEnum.UTENTE_OPERAZIONE.equals(operator)) {
			GestioneUtenteClient.setElementIfExist(operator, queryParam, "operazione");
		}
		return queryParam;
	}

	/**
	 * @param header
	 * @param path
	 * @param queryParam
	 * @throws WebApplicationException
	 */
	protected <T> T verifyCallWhitBooleanResponse(MultivaluedMap<String, String> header, List<String> queryParam,
			String path, Class<T> tClass) throws WebApplicationException {
		T msg;
		try {
			msg = GestioneUtenteClient.getResultObject(header, path, queryParam, tClass, basePath, username, password);
		} catch (WebApplicationException e) {
			log.error("verifyCurrentUser: response con status: " + e.getResponse().getStatus() + " message: "
					+ e.getResponse().getEntity());
			throw e;
		}

        if (msg == null || Boolean.FALSE.equals(msg)) {
            String listParam = queryParam != null ? String.join(", ", queryParam) : null;
	        log.warn("verifyCallWhitBooleanResponse:  msg non valorizzato: " +msg+ " queryParam: " + listParam);
	            
			GestioneUtenteClient.generateResponse(Status.UNAUTHORIZED, "Profilazione non verificata");
		}
		return msg;

	}

}
