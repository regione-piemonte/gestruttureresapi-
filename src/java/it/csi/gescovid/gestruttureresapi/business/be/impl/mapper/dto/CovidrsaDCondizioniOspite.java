/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidrsaDCondizioniOspite extends AbstractDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.condizioni_ospite_id
     *
     * @mbg.generated
     */
    private Integer condizioniOspiteId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.condizioni_ospite_ord
     *
     * @mbg.generated
     */
    private String condizioniOspiteOrd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.condizioni_ospite_cod
     *
     * @mbg.generated
     */
    private String condizioniOspiteCod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.condizioni_ospite_desc
     *
     * @mbg.generated
     */
    private String condizioniOspiteDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_condizioni_ospite.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_id
     *
     * @return the value of covidrsa_d_condizioni_ospite.condizioni_ospite_id
     *
     * @mbg.generated
     */
    public Integer getCondizioniOspiteId() {
        return condizioniOspiteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_id
     *
     * @param condizioniOspiteId the value for covidrsa_d_condizioni_ospite.condizioni_ospite_id
     *
     * @mbg.generated
     */
    public void setCondizioniOspiteId(Integer condizioniOspiteId) {
        this.condizioniOspiteId = condizioniOspiteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_ord
     *
     * @return the value of covidrsa_d_condizioni_ospite.condizioni_ospite_ord
     *
     * @mbg.generated
     */
    public String getCondizioniOspiteOrd() {
        return condizioniOspiteOrd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_ord
     *
     * @param condizioniOspiteOrd the value for covidrsa_d_condizioni_ospite.condizioni_ospite_ord
     *
     * @mbg.generated
     */
    public void setCondizioniOspiteOrd(String condizioniOspiteOrd) {
        this.condizioniOspiteOrd = condizioniOspiteOrd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_cod
     *
     * @return the value of covidrsa_d_condizioni_ospite.condizioni_ospite_cod
     *
     * @mbg.generated
     */
    public String getCondizioniOspiteCod() {
        return condizioniOspiteCod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_cod
     *
     * @param condizioniOspiteCod the value for covidrsa_d_condizioni_ospite.condizioni_ospite_cod
     *
     * @mbg.generated
     */
    public void setCondizioniOspiteCod(String condizioniOspiteCod) {
        this.condizioniOspiteCod = condizioniOspiteCod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_desc
     *
     * @return the value of covidrsa_d_condizioni_ospite.condizioni_ospite_desc
     *
     * @mbg.generated
     */
    public String getCondizioniOspiteDesc() {
        return condizioniOspiteDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.condizioni_ospite_desc
     *
     * @param condizioniOspiteDesc the value for covidrsa_d_condizioni_ospite.condizioni_ospite_desc
     *
     * @mbg.generated
     */
    public void setCondizioniOspiteDesc(String condizioniOspiteDesc) {
        this.condizioniOspiteDesc = condizioniOspiteDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.validita_inizio
     *
     * @return the value of covidrsa_d_condizioni_ospite.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.validita_inizio
     *
     * @param validitaInizio the value for covidrsa_d_condizioni_ospite.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.validita_fine
     *
     * @return the value of covidrsa_d_condizioni_ospite.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.validita_fine
     *
     * @param validitaFine the value for covidrsa_d_condizioni_ospite.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.data_creazione
     *
     * @return the value of covidrsa_d_condizioni_ospite.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.data_creazione
     *
     * @param dataCreazione the value for covidrsa_d_condizioni_ospite.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.data_modifica
     *
     * @return the value of covidrsa_d_condizioni_ospite.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.data_modifica
     *
     * @param dataModifica the value for covidrsa_d_condizioni_ospite.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.data_cancellazione
     *
     * @return the value of covidrsa_d_condizioni_ospite.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.data_cancellazione
     *
     * @param dataCancellazione the value for covidrsa_d_condizioni_ospite.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_condizioni_ospite.utente_operazione
     *
     * @return the value of covidrsa_d_condizioni_ospite.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_condizioni_ospite.utente_operazione
     *
     * @param utenteOperazione the value for covidrsa_d_condizioni_ospite.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }
}