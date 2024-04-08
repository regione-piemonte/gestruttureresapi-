/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RsaVisitatoriJson {
	
	@JsonProperty("Struttura")
	private String nomeStruttura;
	
	@JsonProperty("Data rilevazione")
	private String dataRilevazioneString;
	
	@JsonProperty("Tipo struttura")
	private String tipologiaStrutturaDesc;
	
	@JsonProperty("Dati validi")
	private String datiValidi;

	@JsonProperty("Ingressi visitatori")
	private String visitatoriIngressiDesc;
	
	public String getNomeStruttura() {
		return nomeStruttura;
	}


	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}


	public String getDataRilevazioneString() {
		return dataRilevazioneString;
	}


	public void setDataRilevazioneString(String dataRilevazioneString) {
		this.dataRilevazioneString = dataRilevazioneString;
	}


	public String getTipologiaStrutturaDesc() {
		return tipologiaStrutturaDesc;
	}


	public void setTipologiaStrutturaDesc(String tipologiaStrutturaDesc) {
		this.tipologiaStrutturaDesc = tipologiaStrutturaDesc;
	}


	public String getDatiValidi() {
		return datiValidi;
	}


	public void setDatiValidi(String datiValidi) {
		this.datiValidi = datiValidi;
	}


	public String getVisitatoriIngressiDesc() {
		return visitatoriIngressiDesc;
	}


	public void setVisitatoriIngressiDesc(String visitatoriIngressiDesc) {
		this.visitatoriIngressiDesc = visitatoriIngressiDesc;
	}
	

}
