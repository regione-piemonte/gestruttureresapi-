/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class RsaTipoTampone {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.str_tipo_tampone_id
	 * @mbg.generated
	 */
	private Integer strTipoTamponeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.str_tipo_tampone_cod
	 * @mbg.generated
	 */
	private String strTipoTamponeCod;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.str_tipo_tampone_desc
	 * @mbg.generated
	 */
	private String strTipoTamponeDesc;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.validita_inizio
	 * @mbg.generated
	 */
	private Date validitaInizio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.validita_fine
	 * @mbg.generated
	 */
	private Date validitaFine;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.utente_operazione
	 * @mbg.generated
	 */
	private String utenteOperazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.data_creazione
	 * @mbg.generated
	 */
	private Date dataCreazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.data_modifica
	 * @mbg.generated
	 */
	private Date dataModifica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidrsa_d_tipo_tampone.data_cancellazione
	 * @mbg.generated
	 */
	private Date dataCancellazione;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.str_tipo_tampone_id
	 * @return  the value of covidrsa_d_tipo_tampone.str_tipo_tampone_id
	 * @mbg.generated
	 */
	public Integer getStrTipoTamponeId() {
		return strTipoTamponeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.str_tipo_tampone_id
	 * @param strTipoTamponeId  the value for covidrsa_d_tipo_tampone.str_tipo_tampone_id
	 * @mbg.generated
	 */
	public void setStrTipoTamponeId(Integer strTipoTamponeId) {
		this.strTipoTamponeId = strTipoTamponeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.str_tipo_tampone_cod
	 * @return  the value of covidrsa_d_tipo_tampone.str_tipo_tampone_cod
	 * @mbg.generated
	 */
	public String getStrTipoTamponeCod() {
		return strTipoTamponeCod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.str_tipo_tampone_cod
	 * @param strTipoTamponeCod  the value for covidrsa_d_tipo_tampone.str_tipo_tampone_cod
	 * @mbg.generated
	 */
	public void setStrTipoTamponeCod(String strTipoTamponeCod) {
		this.strTipoTamponeCod = strTipoTamponeCod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.str_tipo_tampone_desc
	 * @return  the value of covidrsa_d_tipo_tampone.str_tipo_tampone_desc
	 * @mbg.generated
	 */
	public String getStrTipoTamponeDesc() {
		return strTipoTamponeDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.str_tipo_tampone_desc
	 * @param strTipoTamponeDesc  the value for covidrsa_d_tipo_tampone.str_tipo_tampone_desc
	 * @mbg.generated
	 */
	public void setStrTipoTamponeDesc(String strTipoTamponeDesc) {
		this.strTipoTamponeDesc = strTipoTamponeDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.validita_inizio
	 * @return  the value of covidrsa_d_tipo_tampone.validita_inizio
	 * @mbg.generated
	 */
	public Date getValiditaInizio() {
		return validitaInizio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.validita_inizio
	 * @param validitaInizio  the value for covidrsa_d_tipo_tampone.validita_inizio
	 * @mbg.generated
	 */
	public void setValiditaInizio(Date validitaInizio) {
		this.validitaInizio = validitaInizio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.validita_fine
	 * @return  the value of covidrsa_d_tipo_tampone.validita_fine
	 * @mbg.generated
	 */
	public Date getValiditaFine() {
		return validitaFine;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.validita_fine
	 * @param validitaFine  the value for covidrsa_d_tipo_tampone.validita_fine
	 * @mbg.generated
	 */
	public void setValiditaFine(Date validitaFine) {
		this.validitaFine = validitaFine;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.utente_operazione
	 * @return  the value of covidrsa_d_tipo_tampone.utente_operazione
	 * @mbg.generated
	 */
	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.utente_operazione
	 * @param utenteOperazione  the value for covidrsa_d_tipo_tampone.utente_operazione
	 * @mbg.generated
	 */
	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.data_creazione
	 * @return  the value of covidrsa_d_tipo_tampone.data_creazione
	 * @mbg.generated
	 */
	public Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.data_creazione
	 * @param dataCreazione  the value for covidrsa_d_tipo_tampone.data_creazione
	 * @mbg.generated
	 */
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.data_modifica
	 * @return  the value of covidrsa_d_tipo_tampone.data_modifica
	 * @mbg.generated
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.data_modifica
	 * @param dataModifica  the value for covidrsa_d_tipo_tampone.data_modifica
	 * @mbg.generated
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidrsa_d_tipo_tampone.data_cancellazione
	 * @return  the value of covidrsa_d_tipo_tampone.data_cancellazione
	 * @mbg.generated
	 */
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidrsa_d_tipo_tampone.data_cancellazione
	 * @param dataCancellazione  the value for covidrsa_d_tipo_tampone.data_cancellazione
	 * @mbg.generated
	 */
	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}
}