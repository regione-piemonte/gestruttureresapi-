/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator;

public abstract class BaseCurrentOperator {

	protected String webappOperazione;
	protected String ruoloOperazione;
	protected String utenteOperazione;
	protected Integer idEnteOperazione;
	protected String idStrutturaOperazione;
	protected Integer idAreaOperazione;

	protected BaseCurrentOperator() {
		super();
	}

	public String getWebappOperazione() {
		return webappOperazione;
	}

	public void setWebappOperazione(String webappOperazione) {
		this.webappOperazione = webappOperazione;
	}

	public String getRuoloOperazione() {
		return ruoloOperazione;
	}

	public void setRuoloOperazione(String ruoloOperazione) {
		this.ruoloOperazione = ruoloOperazione;
	}

	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	public Integer getIdEnteOperazione() {
		return idEnteOperazione;
	}

	public void setIdEnteOperazione(Integer idEnteOperazione) {
		this.idEnteOperazione = idEnteOperazione;
	}

	public String getIdStrutturaOperazione() {
		return idStrutturaOperazione;
	}

	public void setIdStrutturaOperazione(String idStrutturaOperazione) {
		this.idStrutturaOperazione = idStrutturaOperazione;
	}

	public Integer getIdAreaOperazione() {
		return idAreaOperazione;
	}

	public void setIdAreaOperazione(Integer idAreaOperazione) {
		this.idAreaOperazione = idAreaOperazione;
	}

}