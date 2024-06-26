/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

public class Comuni {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comuni.istat_comune
	 * @mbg.generated
	 */
	private String istatComune;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comuni.nome_comune
	 * @mbg.generated
	 */
	private String nomeComune;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comuni.istat_comune
	 * @return  the value of comuni.istat_comune
	 * @mbg.generated
	 */
	public String getIstatComune() {
		return istatComune;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comuni.istat_comune
	 * @param istatComune  the value for comuni.istat_comune
	 * @mbg.generated
	 */
	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comuni.nome_comune
	 * @return  the value of comuni.nome_comune
	 * @mbg.generated
	 */
	public String getNomeComune() {
		return nomeComune;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comuni.nome_comune
	 * @param nomeComune  the value for comuni.nome_comune
	 * @mbg.generated
	 */
	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}
}