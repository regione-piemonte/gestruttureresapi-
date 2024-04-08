/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteOperazioneInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteRefertanteInterface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteRichiedenteInterface;

public class CurrentOperator extends BaseCurrentOperator implements UtenteOperazioneInterface {
	private Integer idProfiloOperazione;
	public CurrentOperator(String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			String utenteOperazione, Integer idEnteOperazione, String idStrutturaOperazione, Integer idAreaOperazione) {
		super();
		this.webappOperazione = webappOperazione;
		this.idProfiloOperazione = idProfiloOperazione;
		this.ruoloOperazione = ruoloOperazione;
		this.utenteOperazione = utenteOperazione;
		this.idEnteOperazione = idEnteOperazione;
		this.idStrutturaOperazione = idStrutturaOperazione;
		this.idAreaOperazione = idAreaOperazione;
	}
	
	public CurrentOperator() {
		super();
	}
	public CurrentOperator(UtenteRichiedenteInterface c) {
		super();
		this.webappOperazione = c.getWebappRichiedente();
		this.idProfiloOperazione = c.getIdProfiloRichiedente();
		this.ruoloOperazione = c.getRuoloRichiedente();
		this.utenteOperazione = c.getUtenteRichiedente();
		this.idEnteOperazione = c.getIdEnteRichiedente();
		this.idStrutturaOperazione = c.getIdStrutturaRichiedente();
		this.idAreaOperazione = c.getIdAreaRichiedente();
	}

	public CurrentOperator(UtenteRefertanteInterface c) {
		super();
		this.webappOperazione = c.getWebappRefertante();
		this.idProfiloOperazione = c.getIdProfiloRefertante();
		this.ruoloOperazione = c.getRuoloRefertante();
		this.utenteOperazione = c.getUtenteRefertante();
		this.idEnteOperazione = c.getIdEnteRefertante();
		this.idStrutturaOperazione = c.getIdStrutturaRefertante();
		this.idAreaOperazione = c.getIdAreaRefertante();
	}

	@Override
	public Integer getIdProfiloOperazione() {
		return idProfiloOperazione;
	}
	public void setIdProfiloOperazione(Integer idProfiloOperazione) {
		this.idProfiloOperazione = idProfiloOperazione;
	}
	
	
	
}
