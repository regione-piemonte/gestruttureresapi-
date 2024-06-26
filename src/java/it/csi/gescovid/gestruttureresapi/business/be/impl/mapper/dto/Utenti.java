/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

public class Utenti {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column utenti.cf_utente
	 * @mbg.generated
	 */
	private String cfUtente;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column utenti.id_asr
	 * @mbg.generated
	 */
	private Long idAsr;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column utenti.id_laboratorio
	 * @mbg.generated
	 */
	private Long idLaboratorio;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column utenti.cf_utente
	 * @return  the value of utenti.cf_utente
	 * @mbg.generated
	 */
	public String getCfUtente() {
		return cfUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column utenti.cf_utente
	 * @param cfUtente  the value for utenti.cf_utente
	 * @mbg.generated
	 */
	public void setCfUtente(String cfUtente) {
		this.cfUtente = cfUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column utenti.id_asr
	 * @return  the value of utenti.id_asr
	 * @mbg.generated
	 */
	public Long getIdAsr() {
		return idAsr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column utenti.id_asr
	 * @param idAsr  the value for utenti.id_asr
	 * @mbg.generated
	 */
	public void setIdAsr(Long idAsr) {
		this.idAsr = idAsr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column utenti.id_laboratorio
	 * @return  the value of utenti.id_laboratorio
	 * @mbg.generated
	 */
	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column utenti.id_laboratorio
	 * @param idLaboratorio  the value for utenti.id_laboratorio
	 * @mbg.generated
	 */
	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
}