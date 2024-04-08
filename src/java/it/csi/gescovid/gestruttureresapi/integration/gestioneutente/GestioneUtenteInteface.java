/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente;

import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Funzione;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelAsr;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelMedico;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelResponse;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelSindaco;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelUtenteContatto;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteOperazioneCodProfiloInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteOperazioneInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteRefertanteInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteRichiedenteInterface;

public interface GestioneUtenteInteface {

	<T> T verifyCurrentUser(UtenteOperazioneCodProfiloInterface currentOperator, CurrentOperatorTypeEnum operator,
			UserTypeEnum userTypeEnum, Funzione function, MultivaluedMap<String, String> header);

	<T> T verifyCurrentUser(UtenteOperazioneInterface currentOperator, CurrentOperatorTypeEnum operator,
			UserTypeEnum userTypeEnum, Funzione function, MultivaluedMap<String, String> header);

	ModelResponse verifyCurrentUser(UtenteOperazioneInterface currentOperator, CurrentOperatorTypeEnum operator,
			Set<UserTypeEnum> userTypeEnum, Funzione function, MultivaluedMap<String, String> header);

	<T> T verifyCurrentUserWhitProfilo(UtenteOperazioneInterface currentOperator, CurrentOperatorTypeEnum operator,
			ProfiloTypeEnum profiloEnumToBeVerified, UserTypeEnum userTypeEnum, Funzione function,
			MultivaluedMap<String, String> header);

	<T> T verifyCurrentUserWhitProfilo(UtenteOperazioneCodProfiloInterface currentOperator,
			CurrentOperatorTypeEnum operator, ProfiloTypeEnum profiloEnumToBeVerified, UserTypeEnum userTypeEnum,
			Funzione function, MultivaluedMap<String, String> header);

	<T> T verifyCurrentUserRichiedente(UtenteRichiedenteInterface currentOperator, CurrentOperatorTypeEnum operator,
			UserTypeEnum userTypeEnum, Funzione function, MultivaluedMap<String, String> header);

    ModelResponse verifyCurrentUserRichiedente(UtenteRichiedenteInterface currentOperator, CurrentOperatorTypeEnum operator,
            Set<UserTypeEnum> userTypeEnum, Funzione function, MultivaluedMap<String, String> header);
    
	<T> T verifyCurrentUserRefertentante(UtenteRefertanteInterface currentOperator, CurrentOperatorTypeEnum operator,
			UserTypeEnum userTypeEnum, Funzione function, MultivaluedMap<String, String> header);

    ModelResponse verifyCurrentUserRefertentante(UtenteRefertanteInterface currentOperator, CurrentOperatorTypeEnum operator,
            Set<UserTypeEnum> userTypeEnum, Funzione function, MultivaluedMap<String, String> header);
	/**
	 * Enumerazione di tutti i parametri return
	 *
	 */
	public enum UserTypeEnum {

		MEDICO("MEDICO", ModelMedico.class), 
		MEDICO_ID("MEDICO_ID", ModelMedico.class),
		SINDACO("SINDACO", ModelSindaco.class), 
		VALIDATE("VALIDATE", String.class), 
		ID_ASR("ID_ASR", Long.class),
		ASR("ASR", ModelAsr.class),   
		UTENTE_CONTATTO("UTENTE_CONTATTO", ModelUtenteContatto.class),
        COD_PROFILO("COD_PROFILO", String.class);

		String value;
		Class<?> clazz;

		UserTypeEnum(String s, Class<?> c) {
			this.value = s;
			this.clazz = c;
		}

		public String getValue() {
			return value;
		}

		public Class<?> getClazz() {
			return clazz;
		}
	}

	public enum ProfiloTypeEnum {

		GEST_BO_COV("GEST_BO_COV"), LAB_IMPORT("LAB IMPORT"), BUONO_RES("BO_BUONORES");

		private final String codProfilo;

		private ProfiloTypeEnum(String codProfilo) {
			this.codProfilo = codProfilo;
		}

		public String getCodProfilo() {
			return codProfilo;
		}

	}
}