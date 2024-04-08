/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto;

import java.io.Serializable;

public class ModelAsr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4704703189701434261L;
	private Long idAsr;
	private String descrizione;
	private Integer idEnte;
	
	public Long getIdAsr() {
		return idAsr;
	}
	public void setIdAsr(Long idAsr) {
		this.idAsr = idAsr;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getIdEnte() {
		return idEnte;
	}
	public void setIdEnte(Integer idEnte) {
		this.idEnte = idEnte;
	}
}
