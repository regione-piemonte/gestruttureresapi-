/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class RsaPersonale {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.pers_id
     *
     * @mbg.generated
     */
    private Integer persId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.pers_num_pianta_organica
     *
     * @mbg.generated
     */
    private Integer persNumPiantaOrganica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.pers_num_attuali
     *
     * @mbg.generated
     */
    private Integer persNumAttuali;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.pers_num_nuove_assunzioni
     *
     * @mbg.generated
     */
    private Integer persNumNuoveAssunzioni;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.pers_tipo_id
     *
     * @mbg.generated
     */
    private Integer persTipoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.id_struttura
     *
     * @mbg.generated
     */
    private String idStruttura;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.str_categoria_id
     *
     * @mbg.generated
     */
    private Integer strCategoriaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.data_rilevazione
     *
     * @mbg.generated
     */
    private Date dataRilevazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_personale.data_visibilita
     *
     * @mbg.generated
     */
    private Date dataVisibilita;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.pers_id
     *
     * @return the value of covidrsa_t_personale.pers_id
     *
     * @mbg.generated
     */
    public Integer getPersId() {
        return persId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.pers_id
     *
     * @param persId the value for covidrsa_t_personale.pers_id
     *
     * @mbg.generated
     */
    public void setPersId(Integer persId) {
        this.persId = persId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.pers_num_pianta_organica
     *
     * @return the value of covidrsa_t_personale.pers_num_pianta_organica
     *
     * @mbg.generated
     */
    public Integer getPersNumPiantaOrganica() {
        return persNumPiantaOrganica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.pers_num_pianta_organica
     *
     * @param persNumPiantaOrganica the value for covidrsa_t_personale.pers_num_pianta_organica
     *
     * @mbg.generated
     */
    public void setPersNumPiantaOrganica(Integer persNumPiantaOrganica) {
        this.persNumPiantaOrganica = persNumPiantaOrganica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.pers_num_attuali
     *
     * @return the value of covidrsa_t_personale.pers_num_attuali
     *
     * @mbg.generated
     */
    public Integer getPersNumAttuali() {
        return persNumAttuali;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.pers_num_attuali
     *
     * @param persNumAttuali the value for covidrsa_t_personale.pers_num_attuali
     *
     * @mbg.generated
     */
    public void setPersNumAttuali(Integer persNumAttuali) {
        this.persNumAttuali = persNumAttuali;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.pers_num_nuove_assunzioni
     *
     * @return the value of covidrsa_t_personale.pers_num_nuove_assunzioni
     *
     * @mbg.generated
     */
    public Integer getPersNumNuoveAssunzioni() {
        return persNumNuoveAssunzioni;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.pers_num_nuove_assunzioni
     *
     * @param persNumNuoveAssunzioni the value for covidrsa_t_personale.pers_num_nuove_assunzioni
     *
     * @mbg.generated
     */
    public void setPersNumNuoveAssunzioni(Integer persNumNuoveAssunzioni) {
        this.persNumNuoveAssunzioni = persNumNuoveAssunzioni;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.pers_tipo_id
     *
     * @return the value of covidrsa_t_personale.pers_tipo_id
     *
     * @mbg.generated
     */
    public Integer getPersTipoId() {
        return persTipoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.pers_tipo_id
     *
     * @param persTipoId the value for covidrsa_t_personale.pers_tipo_id
     *
     * @mbg.generated
     */
    public void setPersTipoId(Integer persTipoId) {
        this.persTipoId = persTipoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.id_struttura
     *
     * @return the value of covidrsa_t_personale.id_struttura
     *
     * @mbg.generated
     */
    public String getIdStruttura() {
        return idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.id_struttura
     *
     * @param idStruttura the value for covidrsa_t_personale.id_struttura
     *
     * @mbg.generated
     */
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.str_categoria_id
     *
     * @return the value of covidrsa_t_personale.str_categoria_id
     *
     * @mbg.generated
     */
    public Integer getStrCategoriaId() {
        return strCategoriaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.str_categoria_id
     *
     * @param strCategoriaId the value for covidrsa_t_personale.str_categoria_id
     *
     * @mbg.generated
     */
    public void setStrCategoriaId(Integer strCategoriaId) {
        this.strCategoriaId = strCategoriaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.data_rilevazione
     *
     * @return the value of covidrsa_t_personale.data_rilevazione
     *
     * @mbg.generated
     */
    public Date getDataRilevazione() {
        return dataRilevazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.data_rilevazione
     *
     * @param dataRilevazione the value for covidrsa_t_personale.data_rilevazione
     *
     * @mbg.generated
     */
    public void setDataRilevazione(Date dataRilevazione) {
        this.dataRilevazione = dataRilevazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.validita_inizio
     *
     * @return the value of covidrsa_t_personale.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.validita_inizio
     *
     * @param validitaInizio the value for covidrsa_t_personale.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.validita_fine
     *
     * @return the value of covidrsa_t_personale.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.validita_fine
     *
     * @param validitaFine the value for covidrsa_t_personale.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.utente_operazione
     *
     * @return the value of covidrsa_t_personale.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.utente_operazione
     *
     * @param utenteOperazione the value for covidrsa_t_personale.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.data_creazione
     *
     * @return the value of covidrsa_t_personale.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.data_creazione
     *
     * @param dataCreazione the value for covidrsa_t_personale.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.data_modifica
     *
     * @return the value of covidrsa_t_personale.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.data_modifica
     *
     * @param dataModifica the value for covidrsa_t_personale.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.data_cancellazione
     *
     * @return the value of covidrsa_t_personale.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.data_cancellazione
     *
     * @param dataCancellazione the value for covidrsa_t_personale.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_personale.data_visibilita
     *
     * @return the value of covidrsa_t_personale.data_visibilita
     *
     * @mbg.generated
     */
    public Date getDataVisibilita() {
        return dataVisibilita;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_personale.data_visibilita
     *
     * @param dataVisibilita the value for covidrsa_t_personale.data_visibilita
     *
     * @mbg.generated
     */
    public void setDataVisibilita(Date dataVisibilita) {
        this.dataVisibilita = dataVisibilita;
    }
}