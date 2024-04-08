/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaStrutturaNote;

public class RsaStrutturaNoteExt extends RsaStrutturaNote{
	
	@JsonProperty("Struttura")
	private String nomeStruttura;
	
	@JsonProperty("Tipo struttura")
	private String tipologiaStrutturaDesc;
	
	
	public String getTipologiaStrutturaDesc() {
		return tipologiaStrutturaDesc;
	}
	public void setTipologiaStrutturaDesc(String tipologiaStrutturaDesc) {
		this.tipologiaStrutturaDesc = tipologiaStrutturaDesc;
	}
	public String getNomeStruttura() {
		return nomeStruttura;
	}
	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}
	
	

}
