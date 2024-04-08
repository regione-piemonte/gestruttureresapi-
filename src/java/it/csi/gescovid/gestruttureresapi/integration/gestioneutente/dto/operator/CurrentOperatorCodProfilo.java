/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.GestioneUtenteInteface.ProfiloTypeEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface.UtenteOperazioneCodProfiloInterface;

public class CurrentOperatorCodProfilo extends BaseCurrentOperator implements UtenteOperazioneCodProfiloInterface{

	private String codProfiloOperazione;
	
	public CurrentOperatorCodProfilo(String webappOperazione, ProfiloTypeEnum profiloTypeEnumOperazione, String ruoloOperazione,
			String utenteOperazione, Integer idEnteOperazione, String idStrutturaOperazione, Integer idAreaOperazione) {
		super();
		this.webappOperazione = webappOperazione;
		this.setCodProfiloOperazione(profiloTypeEnumOperazione.getCodProfilo());
		this.ruoloOperazione = ruoloOperazione;
		this.utenteOperazione = utenteOperazione;
		this.idEnteOperazione = idEnteOperazione;
		this.idStrutturaOperazione = idStrutturaOperazione;
		this.idAreaOperazione = idAreaOperazione;
	}
	
	public CurrentOperatorCodProfilo(String webappOperazione, String codProfiloOperazione, String ruoloOperazione,
			String utenteOperazione, Integer idEnteOperazione, String idStrutturaOperazione, Integer idAreaOperazione) {
		super();
		this.webappOperazione = webappOperazione;
		this.setCodProfiloOperazione(codProfiloOperazione);
		this.ruoloOperazione = ruoloOperazione;
		this.utenteOperazione = utenteOperazione;
		this.idEnteOperazione = idEnteOperazione;
		this.idStrutturaOperazione = idStrutturaOperazione;
		this.idAreaOperazione = idAreaOperazione;
	}

	public String getCodProfiloOperazione() {
		return codProfiloOperazione;
	}

	public void setCodProfiloOperazione(String codProfiloOperazione) {
		this.codProfiloOperazione = codProfiloOperazione;
	}
}
