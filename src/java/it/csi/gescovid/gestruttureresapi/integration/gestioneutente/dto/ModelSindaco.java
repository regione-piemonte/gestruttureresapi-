/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto;

import java.io.Serializable;

public class ModelSindaco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6867715444371852872L;
	private String cfUtente;
	private String comuneIstat;

	public String getCfUtente() {
		return cfUtente;
	}

	public void setCfUtente(String cfUtente) {
		this.cfUtente = cfUtente;
	}

	public String getComuneIstat() {
		return comuneIstat;
	}

	public void setComuneIstat(String comuneIstat) {
		this.comuneIstat = comuneIstat;
	}

}
