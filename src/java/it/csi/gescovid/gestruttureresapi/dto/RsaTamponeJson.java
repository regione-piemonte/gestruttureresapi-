/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RsaTamponeJson {

	@JsonProperty("Struttura")
	private String nomeStruttura;

	@JsonProperty("Data rilevazione")
	private String dataRilevazioneString;

	@JsonProperty("Tipo struttura")
	private String tipologiaStrutturaDesc;

	@JsonProperty("Categoria")
	private String categoriaTampDesc;

	@JsonProperty("Dati validi")
	private String datiValidi;

	@JsonProperty("Totali")
	private Integer tampNumTotali;

	@JsonProperty("Positivi")
	private Integer tampNumPositivi;

	@JsonProperty("Negativi")
	private Integer tampNumNegativi;



}
