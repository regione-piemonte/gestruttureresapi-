/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidrsaDWelfareFileTipo extends AbstractDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_id
     *
     * @mbg.generated
     */
    private Integer fileTipoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_cod
     *
     * @mbg.generated
     */
    private String fileTipoCod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_desc
     *
     * @mbg.generated
     */
    private String fileTipoDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_obbligatorio
     *
     * @mbg.generated
     */
    private Boolean fileTipoObbligatorio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_firmato
     *
     * @mbg.generated
     */
    private Boolean fileTipoFirmato;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_gruppo
     *
     * @mbg.generated
     */
    private String fileTipoGruppo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_d_welfare_file_tipo.file_tipo_hint
     *
     * @mbg.generated
     */
    private String fileTipoHint;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_id
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_id
     *
     * @mbg.generated
     */
    public Integer getFileTipoId() {
        return fileTipoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_id
     *
     * @param fileTipoId the value for covidrsa_d_welfare_file_tipo.file_tipo_id
     *
     * @mbg.generated
     */
    public void setFileTipoId(Integer fileTipoId) {
        this.fileTipoId = fileTipoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_cod
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_cod
     *
     * @mbg.generated
     */
    public String getFileTipoCod() {
        return fileTipoCod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_cod
     *
     * @param fileTipoCod the value for covidrsa_d_welfare_file_tipo.file_tipo_cod
     *
     * @mbg.generated
     */
    public void setFileTipoCod(String fileTipoCod) {
        this.fileTipoCod = fileTipoCod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_desc
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_desc
     *
     * @mbg.generated
     */
    public String getFileTipoDesc() {
        return fileTipoDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_desc
     *
     * @param fileTipoDesc the value for covidrsa_d_welfare_file_tipo.file_tipo_desc
     *
     * @mbg.generated
     */
    public void setFileTipoDesc(String fileTipoDesc) {
        this.fileTipoDesc = fileTipoDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_obbligatorio
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_obbligatorio
     *
     * @mbg.generated
     */
    public Boolean getFileTipoObbligatorio() {
        return fileTipoObbligatorio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_obbligatorio
     *
     * @param fileTipoObbligatorio the value for covidrsa_d_welfare_file_tipo.file_tipo_obbligatorio
     *
     * @mbg.generated
     */
    public void setFileTipoObbligatorio(Boolean fileTipoObbligatorio) {
        this.fileTipoObbligatorio = fileTipoObbligatorio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_firmato
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_firmato
     *
     * @mbg.generated
     */
    public Boolean getFileTipoFirmato() {
        return fileTipoFirmato;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_firmato
     *
     * @param fileTipoFirmato the value for covidrsa_d_welfare_file_tipo.file_tipo_firmato
     *
     * @mbg.generated
     */
    public void setFileTipoFirmato(Boolean fileTipoFirmato) {
        this.fileTipoFirmato = fileTipoFirmato;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.validita_inizio
     *
     * @return the value of covidrsa_d_welfare_file_tipo.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.validita_inizio
     *
     * @param validitaInizio the value for covidrsa_d_welfare_file_tipo.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.validita_fine
     *
     * @return the value of covidrsa_d_welfare_file_tipo.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.validita_fine
     *
     * @param validitaFine the value for covidrsa_d_welfare_file_tipo.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.utente_operazione
     *
     * @return the value of covidrsa_d_welfare_file_tipo.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.utente_operazione
     *
     * @param utenteOperazione the value for covidrsa_d_welfare_file_tipo.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.data_creazione
     *
     * @return the value of covidrsa_d_welfare_file_tipo.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.data_creazione
     *
     * @param dataCreazione the value for covidrsa_d_welfare_file_tipo.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.data_modifica
     *
     * @return the value of covidrsa_d_welfare_file_tipo.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.data_modifica
     *
     * @param dataModifica the value for covidrsa_d_welfare_file_tipo.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.data_cancellazione
     *
     * @return the value of covidrsa_d_welfare_file_tipo.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.data_cancellazione
     *
     * @param dataCancellazione the value for covidrsa_d_welfare_file_tipo.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_gruppo
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_gruppo
     *
     * @mbg.generated
     */
    public String getFileTipoGruppo() {
        return fileTipoGruppo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_gruppo
     *
     * @param fileTipoGruppo the value for covidrsa_d_welfare_file_tipo.file_tipo_gruppo
     *
     * @mbg.generated
     */
    public void setFileTipoGruppo(String fileTipoGruppo) {
        this.fileTipoGruppo = fileTipoGruppo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_hint
     *
     * @return the value of covidrsa_d_welfare_file_tipo.file_tipo_hint
     *
     * @mbg.generated
     */
    public String getFileTipoHint() {
        return fileTipoHint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_d_welfare_file_tipo.file_tipo_hint
     *
     * @param fileTipoHint the value for covidrsa_d_welfare_file_tipo.file_tipo_hint
     *
     * @mbg.generated
     */
    public void setFileTipoHint(String fileTipoHint) {
        this.fileTipoHint = fileTipoHint;
    }
}