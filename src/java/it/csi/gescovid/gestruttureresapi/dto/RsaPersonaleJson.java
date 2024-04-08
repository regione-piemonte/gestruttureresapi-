/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RsaPersonaleJson {

	@JsonProperty("Struttura")
	private String nomeStruttura;
	
	@JsonProperty("Data rilevazione")
	private String dataRilevazioneString;

	@JsonProperty("Tipo struttura")
	private String tipologiaStrutturaDesc;

	@JsonProperty("Dati validi")
	private String datiValidi;

	@JsonProperty("Tipologia personale")
	private String tipologiaPersonale;

	@JsonProperty("Attuali")
	private Integer persNumAttuali;
	
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

	public Integer getPersNumAttuali() {
		return persNumAttuali;
	}

	public void setPersNumAttuali(Integer persNumAttuali) {
		this.persNumAttuali = persNumAttuali;
	}

	public String getTipologiaPersonale() {
		return tipologiaPersonale;
	}

	public void setTipologiaPersonale(String tipologiaPersonale) {
		this.tipologiaPersonale = tipologiaPersonale;
	}
	
	

}
