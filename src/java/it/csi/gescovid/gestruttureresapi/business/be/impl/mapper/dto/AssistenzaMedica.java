/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class AssistenzaMedica {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.assmed_id
     *
     * @mbg.generated
     */
    private Integer assmedId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.assmed_cod
     *
     * @mbg.generated
     */
    private String assmedCod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.assmed_desc
     *
     * @mbg.generated
     */
    private String assmedDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_assistenza_medica.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.assmed_id
     *
     * @return the value of covidrsa_d_assistenza_medica.assmed_id
     *
     * @mbg.generated
     */
    public Integer getAssmedId() {
        return assmedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.assmed_id
     *
     * @param assmedId the value for covidrsa_d_assistenza_medica.assmed_id
     *
     * @mbg.generated
     */
    public void setAssmedId(Integer assmedId) {
        this.assmedId = assmedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.assmed_cod
     *
     * @return the value of covidrsa_d_assistenza_medica.assmed_cod
     *
     * @mbg.generated
     */
    public String getAssmedCod() {
        return assmedCod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.assmed_cod
     *
     * @param assmedCod the value for covidrsa_d_assistenza_medica.assmed_cod
     *
     * @mbg.generated
     */
    public void setAssmedCod(String assmedCod) {
        this.assmedCod = assmedCod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.assmed_desc
     *
     * @return the value of covidrsa_d_assistenza_medica.assmed_desc
     *
     * @mbg.generated
     */
    public String getAssmedDesc() {
        return assmedDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.assmed_desc
     *
     * @param assmedDesc the value for covidrsa_d_assistenza_medica.assmed_desc
     *
     * @mbg.generated
     */
    public void setAssmedDesc(String assmedDesc) {
        this.assmedDesc = assmedDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.validita_inizio
     *
     * @return the value of covidrsa_d_assistenza_medica.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.validita_inizio
     *
     * @param validitaInizio the value for covidrsa_d_assistenza_medica.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.validita_fine
     *
     * @return the value of covidrsa_d_assistenza_medica.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.validita_fine
     *
     * @param validitaFine the value for covidrsa_d_assistenza_medica.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.utente_operazione
     *
     * @return the value of covidrsa_d_assistenza_medica.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.utente_operazione
     *
     * @param utenteOperazione the value for covidrsa_d_assistenza_medica.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.data_creazione
     *
     * @return the value of covidrsa_d_assistenza_medica.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.data_creazione
     *
     * @param dataCreazione the value for covidrsa_d_assistenza_medica.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.data_modifica
     *
     * @return the value of covidrsa_d_assistenza_medica.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.data_modifica
     *
     * @param dataModifica the value for covidrsa_d_assistenza_medica.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_assistenza_medica.data_cancellazione
     *
     * @return the value of covidrsa_d_assistenza_medica.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_assistenza_medica.data_cancellazione
     *
     * @param dataCancellazione the value for covidrsa_d_assistenza_medica.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }
}