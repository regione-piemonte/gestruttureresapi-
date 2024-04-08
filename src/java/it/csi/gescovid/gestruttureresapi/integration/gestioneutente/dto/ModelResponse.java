/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto;

import java.io.Serializable;

public class ModelResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8546022725776594702L;
	private Long idAsr;
	private ModelAsr asr;
	private ModelMedico modelMedico;
	private Long idMedico;
	private ModelSindaco sindaco;
	private String codProfilo;
	
	public Long getIdAsr() {
		return idAsr;
	}
	public void setIdAsr(Long idAsr) {
		this.idAsr = idAsr;
	}
	public ModelMedico getModelMedico() {
		return modelMedico;
	}
	public void setModelMedico(ModelMedico modelMedico) {
		this.modelMedico = modelMedico;
	}
	public Long getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}
	public ModelSindaco getSindaco() {
		return sindaco;
	}
	public void setSindaco(ModelSindaco sindaco) {
		this.sindaco = sindaco;
	}
	public ModelAsr getAsr() {
		return asr;
	}
	public void setAsr(ModelAsr asr) {
		this.asr = asr;
	}
	public String getCodProfilo() {
		return codProfilo;
	}
	public void setCodProfilo(String codProfilo) {
		this.codProfilo = codProfilo;
	}
}
