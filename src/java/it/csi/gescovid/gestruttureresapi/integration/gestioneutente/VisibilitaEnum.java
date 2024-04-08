/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente;

public enum VisibilitaEnum {

	LETTURA("R"),
	SCRITTURA("W");

	private final String code;

	private VisibilitaEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
