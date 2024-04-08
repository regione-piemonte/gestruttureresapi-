/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente;

public enum CurrentOperatorTypeEnum {

		REFERTANTE("Refertante"),
		RICHIEDENTE("Richiedente"),
		UTENTE_OPERAZIONE("Utente operatore");
	
		private final String code;

		private CurrentOperatorTypeEnum(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

}
