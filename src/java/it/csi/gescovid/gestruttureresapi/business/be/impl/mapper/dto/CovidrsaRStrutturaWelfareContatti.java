/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidrsaRStrutturaWelfareContatti extends AbstractDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.str_welf_contatti_id
     *
     * @mbg.generated
     */
    private Integer strWelfContattiId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.str_welfare_id
     *
     * @mbg.generated
     */
    private Integer strWelfareId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.struttura_email
     *
     * @mbg.generated
     */
    private String strutturaEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_r_struttura_welfare_contatti.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.str_welf_contatti_id
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.str_welf_contatti_id
     *
     * @mbg.generated
     */
    public Integer getStrWelfContattiId() {
        return strWelfContattiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.str_welf_contatti_id
     *
     * @param strWelfContattiId the value for covidrsa_r_struttura_welfare_contatti.str_welf_contatti_id
     *
     * @mbg.generated
     */
    public void setStrWelfContattiId(Integer strWelfContattiId) {
        this.strWelfContattiId = strWelfContattiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.str_welfare_id
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.str_welfare_id
     *
     * @mbg.generated
     */
    public Integer getStrWelfareId() {
        return strWelfareId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.str_welfare_id
     *
     * @param strWelfareId the value for covidrsa_r_struttura_welfare_contatti.str_welfare_id
     *
     * @mbg.generated
     */
    public void setStrWelfareId(Integer strWelfareId) {
        this.strWelfareId = strWelfareId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.struttura_email
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.struttura_email
     *
     * @mbg.generated
     */
    public String getStrutturaEmail() {
        return strutturaEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.struttura_email
     *
     * @param strutturaEmail the value for covidrsa_r_struttura_welfare_contatti.struttura_email
     *
     * @mbg.generated
     */
    public void setStrutturaEmail(String strutturaEmail) {
        this.strutturaEmail = strutturaEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.validita_inizio
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.validita_inizio
     *
     * @param validitaInizio the value for covidrsa_r_struttura_welfare_contatti.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.validita_fine
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.validita_fine
     *
     * @param validitaFine the value for covidrsa_r_struttura_welfare_contatti.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.utente_operazione
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.utente_operazione
     *
     * @param utenteOperazione the value for covidrsa_r_struttura_welfare_contatti.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.data_creazione
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.data_creazione
     *
     * @param dataCreazione the value for covidrsa_r_struttura_welfare_contatti.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.data_modifica
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.data_modifica
     *
     * @param dataModifica the value for covidrsa_r_struttura_welfare_contatti.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_r_struttura_welfare_contatti.data_cancellazione
     *
     * @return the value of covidrsa_r_struttura_welfare_contatti.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_r_struttura_welfare_contatti.data_cancellazione
     *
     * @param dataCancellazione the value for covidrsa_r_struttura_welfare_contatti.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }
}