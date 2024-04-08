/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

public class TipoSoggetto {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column d_tipo_soggetto.id_tipo_soggetto
	 * @mbg.generated
	 */
	private Integer idTipoSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column d_tipo_soggetto.desc_tipo_soggetto
	 * @mbg.generated
	 */
	private String descTipoSoggetto;
	
	
	private String tipologia;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column d_tipo_soggetto.id_tipo_soggetto
	 * @return  the value of d_tipo_soggetto.id_tipo_soggetto
	 * @mbg.generated
	 */
	public Integer getIdTipoSoggetto() {
		return idTipoSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column d_tipo_soggetto.id_tipo_soggetto
	 * @param idTipoSoggetto  the value for d_tipo_soggetto.id_tipo_soggetto
	 * @mbg.generated
	 */
	public void setIdTipoSoggetto(Integer idTipoSoggetto) {
		this.idTipoSoggetto = idTipoSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column d_tipo_soggetto.desc_tipo_soggetto
	 * @return  the value of d_tipo_soggetto.desc_tipo_soggetto
	 * @mbg.generated
	 */
	public String getDescTipoSoggetto() {
		return descTipoSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column d_tipo_soggetto.desc_tipo_soggetto
	 * @param descTipoSoggetto  the value for d_tipo_soggetto.desc_tipo_soggetto
	 * @mbg.generated
	 */
	public void setDescTipoSoggetto(String descTipoSoggetto) {
		this.descTipoSoggetto = descTipoSoggetto;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
}