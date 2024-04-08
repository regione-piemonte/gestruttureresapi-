/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

public enum ProfiloEnum {
	GEST_EROGATORI("GEST_EROGATORI"),
	GEST_ST_RES("GEST_ST_RES"),
	RSA("RSA"),RSA_RP("RSA_RP"),
	RSA_ASL("RSA_ASL");
	
	private final String codice;
	
	
	ProfiloEnum(String codice) {
		this.codice = codice;

	}

	public String getCodice() {
		return codice;
	}

}
