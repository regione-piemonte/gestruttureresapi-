/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

public class Profilo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilo.id_profilo
	 * @mbg.generated
	 */
	private Integer idProfilo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilo.nome_profilo
	 * @mbg.generated
	 */
	private String nomeProfilo;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilo.id_profilo
	 * @return  the value of profilo.id_profilo
	 * @mbg.generated
	 */
	public Integer getIdProfilo() {
		return idProfilo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilo.id_profilo
	 * @param idProfilo  the value for profilo.id_profilo
	 * @mbg.generated
	 */
	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilo.nome_profilo
	 * @return  the value of profilo.nome_profilo
	 * @mbg.generated
	 */
	public String getNomeProfilo() {
		return nomeProfilo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilo.nome_profilo
	 * @param nomeProfilo  the value for profilo.nome_profilo
	 * @mbg.generated
	 */
	public void setNomeProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}
}