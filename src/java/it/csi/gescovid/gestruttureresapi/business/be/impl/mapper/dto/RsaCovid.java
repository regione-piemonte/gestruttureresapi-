/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class RsaCovid {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.covid_id
     *
     * @mbg.generated
     */
    private Integer covidId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.covid_num_sospetti
     *
     * @mbg.generated
     */
    private Integer covidNumSospetti;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.covid_num_isolati
     *
     * @mbg.generated
     */
    private Integer covidNumIsolati;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.id_struttura
     *
     * @mbg.generated
     */
    private String idStruttura;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.str_categoria_id
     *
     * @mbg.generated
     */
    private Integer strCategoriaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.data_rilevazione
     *
     * @mbg.generated
     */
    private Date dataRilevazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.data_visibilita
     *
     * @mbg.generated
     */
    private Date dataVisibilita;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidrsa_t_covid.covid_num_ospedalizzati
     *
     * @mbg.generated
     */
    private Integer covidNumOspedalizzati;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.covid_id
     *
     * @return the value of covidrsa_t_covid.covid_id
     *
     * @mbg.generated
     */
    public Integer getCovidId() {
        return covidId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.covid_id
     *
     * @param covidId the value for covidrsa_t_covid.covid_id
     *
     * @mbg.generated
     */
    public void setCovidId(Integer covidId) {
        this.covidId = covidId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.covid_num_sospetti
     *
     * @return the value of covidrsa_t_covid.covid_num_sospetti
     *
     * @mbg.generated
     */
    public Integer getCovidNumSospetti() {
        return covidNumSospetti;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.covid_num_sospetti
     *
     * @param covidNumSospetti the value for covidrsa_t_covid.covid_num_sospetti
     *
     * @mbg.generated
     */
    public void setCovidNumSospetti(Integer covidNumSospetti) {
        this.covidNumSospetti = covidNumSospetti;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.covid_num_isolati
     *
     * @return the value of covidrsa_t_covid.covid_num_isolati
     *
     * @mbg.generated
     */
    public Integer getCovidNumIsolati() {
        return covidNumIsolati;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.covid_num_isolati
     *
     * @param covidNumIsolati the value for covidrsa_t_covid.covid_num_isolati
     *
     * @mbg.generated
     */
    public void setCovidNumIsolati(Integer covidNumIsolati) {
        this.covidNumIsolati = covidNumIsolati;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.id_struttura
     *
     * @return the value of covidrsa_t_covid.id_struttura
     *
     * @mbg.generated
     */
    public String getIdStruttura() {
        return idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.id_struttura
     *
     * @param idStruttura the value for covidrsa_t_covid.id_struttura
     *
     * @mbg.generated
     */
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.str_categoria_id
     *
     * @return the value of covidrsa_t_covid.str_categoria_id
     *
     * @mbg.generated
     */
    public Integer getStrCategoriaId() {
        return strCategoriaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.str_categoria_id
     *
     * @param strCategoriaId the value for covidrsa_t_covid.str_categoria_id
     *
     * @mbg.generated
     */
    public void setStrCategoriaId(Integer strCategoriaId) {
        this.strCategoriaId = strCategoriaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.data_rilevazione
     *
     * @return the value of covidrsa_t_covid.data_rilevazione
     *
     * @mbg.generated
     */
    public Date getDataRilevazione() {
        return dataRilevazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.data_rilevazione
     *
     * @param dataRilevazione the value for covidrsa_t_covid.data_rilevazione
     *
     * @mbg.generated
     */
    public void setDataRilevazione(Date dataRilevazione) {
        this.dataRilevazione = dataRilevazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.validita_inizio
     *
     * @return the value of covidrsa_t_covid.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.validita_inizio
     *
     * @param validitaInizio the value for covidrsa_t_covid.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.validita_fine
     *
     * @return the value of covidrsa_t_covid.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.validita_fine
     *
     * @param validitaFine the value for covidrsa_t_covid.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.utente_operazione
     *
     * @return the value of covidrsa_t_covid.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.utente_operazione
     *
     * @param utenteOperazione the value for covidrsa_t_covid.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.data_creazione
     *
     * @return the value of covidrsa_t_covid.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.data_creazione
     *
     * @param dataCreazione the value for covidrsa_t_covid.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.data_modifica
     *
     * @return the value of covidrsa_t_covid.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.data_modifica
     *
     * @param dataModifica the value for covidrsa_t_covid.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.data_cancellazione
     *
     * @return the value of covidrsa_t_covid.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.data_cancellazione
     *
     * @param dataCancellazione the value for covidrsa_t_covid.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.data_visibilita
     *
     * @return the value of covidrsa_t_covid.data_visibilita
     *
     * @mbg.generated
     */
    public Date getDataVisibilita() {
        return dataVisibilita;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.data_visibilita
     *
     * @param dataVisibilita the value for covidrsa_t_covid.data_visibilita
     *
     * @mbg.generated
     */
    public void setDataVisibilita(Date dataVisibilita) {
        this.dataVisibilita = dataVisibilita;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidrsa_t_covid.covid_num_ospedalizzati
     *
     * @return the value of covidrsa_t_covid.covid_num_ospedalizzati
     *
     * @mbg.generated
     */
    public Integer getCovidNumOspedalizzati() {
        return covidNumOspedalizzati;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidrsa_t_covid.covid_num_ospedalizzati
     *
     * @param covidNumOspedalizzati the value for covidrsa_t_covid.covid_num_ospedalizzati
     *
     * @mbg.generated
     */
    public void setCovidNumOspedalizzati(Integer covidNumOspedalizzati) {
        this.covidNumOspedalizzati = covidNumOspedalizzati;
    }
}