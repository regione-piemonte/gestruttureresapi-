/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RsaDecessiJson {
	
	@JsonProperty("Struttura")
	private String nomeStruttura;

	@JsonProperty("Data rilevazione")
	private String dataRilevazioneString;

	@JsonProperty("Tipo struttura")
	private String tipologiaStrutturaDesc;

	@JsonProperty("Dati validi")
	private String datiValidi;

	@JsonProperty("Totale deceduti ultima settimana")
	private Integer decNumUltimaSettimana;

	@JsonProperty("Totale deceduti ultima settimana COVID")
	private Integer decNumCovidUltimaSettimana;

	@JsonProperty("Totale deceduti in struttura ultima settimana")
	private Integer decNumInStrutturaUltimaSettimana;

	@JsonProperty("Totale deceduti in struttura ultima settimana COVID")
	private Integer decNumInStrutturaCovidUltimaSettimana;


	@JsonProperty("Totale deceduti in ospedale ultima settimana")
	private Integer decNumInOspedaleUltimaSettimana;

	@JsonProperty("Totale deceduti in ospedale ultima settimana COVID")
	private Integer decNumInOspedaleCovidUltimaSettimana;


}
