/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class Decorso {

	
	private String luogoPaziente;
	private String descrizioneContesto;

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.id_decorso
     *
     * @mbg.generated
     */
    private Long idDecorso;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.id_soggetto
     *
     * @mbg.generated
     */
    private Long idSoggetto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.comune_ricovero_istat
     *
     * @mbg.generated
     */
    private String comuneRicoveroIstat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.id_rep_ricovero
     *
     * @mbg.generated
     */
    private Long idRepRicovero;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.condizioni_cliniche
     *
     * @mbg.generated
     */
    private String condizioniCliniche;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.id_dimiss
     *
     * @mbg.generated
     */
    private Long idDimiss;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.sintomi
     *
     * @mbg.generated
     */
    private String sintomi;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.ospedale_ricovero
     *
     * @mbg.generated
     */
    private String ospedaleRicovero;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.data_dimissioni
     *
     * @mbg.generated
     */
    private Date dataDimissioni;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.data_inizio_sint
     *
     * @mbg.generated
     */
    private Date dataInizioSint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.data_evento
     *
     * @mbg.generated
     */
    private Date dataEvento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.id_tipo_evento
     *
     * @mbg.generated
     */
    private Integer idTipoEvento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.id_area
     *
     * @mbg.generated
     */
    private Integer idArea;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.note
     *
     * @mbg.generated
     */
    private String note;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.data_prev_fine_evento
     *
     * @mbg.generated
     */
    private Date dataPrevFineEvento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.indirizzo_decorso
     *
     * @mbg.generated
     */
    private String indirizzoDecorso;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column decorso.decorso_presso
     *
     * @mbg.generated
     */
    private String decorsoPresso;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.id_decorso
     *
     * @return the value of decorso.id_decorso
     *
     * @mbg.generated
     */
    public Long getIdDecorso() {
        return idDecorso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.id_decorso
     *
     * @param idDecorso the value for decorso.id_decorso
     *
     * @mbg.generated
     */
    public void setIdDecorso(Long idDecorso) {
        this.idDecorso = idDecorso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.id_soggetto
     *
     * @return the value of decorso.id_soggetto
     *
     * @mbg.generated
     */
    public Long getIdSoggetto() {
        return idSoggetto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.id_soggetto
     *
     * @param idSoggetto the value for decorso.id_soggetto
     *
     * @mbg.generated
     */
    public void setIdSoggetto(Long idSoggetto) {
        this.idSoggetto = idSoggetto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.comune_ricovero_istat
     *
     * @return the value of decorso.comune_ricovero_istat
     *
     * @mbg.generated
     */
    public String getComuneRicoveroIstat() {
        return comuneRicoveroIstat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.comune_ricovero_istat
     *
     * @param comuneRicoveroIstat the value for decorso.comune_ricovero_istat
     *
     * @mbg.generated
     */
    public void setComuneRicoveroIstat(String comuneRicoveroIstat) {
        this.comuneRicoveroIstat = comuneRicoveroIstat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.id_rep_ricovero
     *
     * @return the value of decorso.id_rep_ricovero
     *
     * @mbg.generated
     */
    public Long getIdRepRicovero() {
        return idRepRicovero;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.id_rep_ricovero
     *
     * @param idRepRicovero the value for decorso.id_rep_ricovero
     *
     * @mbg.generated
     */
    public void setIdRepRicovero(Long idRepRicovero) {
        this.idRepRicovero = idRepRicovero;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.condizioni_cliniche
     *
     * @return the value of decorso.condizioni_cliniche
     *
     * @mbg.generated
     */
    public String getCondizioniCliniche() {
        return condizioniCliniche;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.condizioni_cliniche
     *
     * @param condizioniCliniche the value for decorso.condizioni_cliniche
     *
     * @mbg.generated
     */
    public void setCondizioniCliniche(String condizioniCliniche) {
        this.condizioniCliniche = condizioniCliniche;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.id_dimiss
     *
     * @return the value of decorso.id_dimiss
     *
     * @mbg.generated
     */
    public Long getIdDimiss() {
        return idDimiss;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.id_dimiss
     *
     * @param idDimiss the value for decorso.id_dimiss
     *
     * @mbg.generated
     */
    public void setIdDimiss(Long idDimiss) {
        this.idDimiss = idDimiss;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.sintomi
     *
     * @return the value of decorso.sintomi
     *
     * @mbg.generated
     */
    public String getSintomi() {
        return sintomi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.sintomi
     *
     * @param sintomi the value for decorso.sintomi
     *
     * @mbg.generated
     */
    public void setSintomi(String sintomi) {
        this.sintomi = sintomi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.ospedale_ricovero
     *
     * @return the value of decorso.ospedale_ricovero
     *
     * @mbg.generated
     */
    public String getOspedaleRicovero() {
        return ospedaleRicovero;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.ospedale_ricovero
     *
     * @param ospedaleRicovero the value for decorso.ospedale_ricovero
     *
     * @mbg.generated
     */
    public void setOspedaleRicovero(String ospedaleRicovero) {
        this.ospedaleRicovero = ospedaleRicovero;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.data_dimissioni
     *
     * @return the value of decorso.data_dimissioni
     *
     * @mbg.generated
     */
    public Date getDataDimissioni() {
        return dataDimissioni;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.data_dimissioni
     *
     * @param dataDimissioni the value for decorso.data_dimissioni
     *
     * @mbg.generated
     */
    public void setDataDimissioni(Date dataDimissioni) {
        this.dataDimissioni = dataDimissioni;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.data_inizio_sint
     *
     * @return the value of decorso.data_inizio_sint
     *
     * @mbg.generated
     */
    public Date getDataInizioSint() {
        return dataInizioSint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.data_inizio_sint
     *
     * @param dataInizioSint the value for decorso.data_inizio_sint
     *
     * @mbg.generated
     */
    public void setDataInizioSint(Date dataInizioSint) {
        this.dataInizioSint = dataInizioSint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.data_evento
     *
     * @return the value of decorso.data_evento
     *
     * @mbg.generated
     */
    public Date getDataEvento() {
        return dataEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.data_evento
     *
     * @param dataEvento the value for decorso.data_evento
     *
     * @mbg.generated
     */
    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.id_tipo_evento
     *
     * @return the value of decorso.id_tipo_evento
     *
     * @mbg.generated
     */
    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.id_tipo_evento
     *
     * @param idTipoEvento the value for decorso.id_tipo_evento
     *
     * @mbg.generated
     */
    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.id_area
     *
     * @return the value of decorso.id_area
     *
     * @mbg.generated
     */
    public Integer getIdArea() {
        return idArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.id_area
     *
     * @param idArea the value for decorso.id_area
     *
     * @mbg.generated
     */
    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.note
     *
     * @return the value of decorso.note
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.note
     *
     * @param note the value for decorso.note
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.data_prev_fine_evento
     *
     * @return the value of decorso.data_prev_fine_evento
     *
     * @mbg.generated
     */
    public Date getDataPrevFineEvento() {
        return dataPrevFineEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.data_prev_fine_evento
     *
     * @param dataPrevFineEvento the value for decorso.data_prev_fine_evento
     *
     * @mbg.generated
     */
    public void setDataPrevFineEvento(Date dataPrevFineEvento) {
        this.dataPrevFineEvento = dataPrevFineEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.indirizzo_decorso
     *
     * @return the value of decorso.indirizzo_decorso
     *
     * @mbg.generated
     */
    public String getIndirizzoDecorso() {
        return indirizzoDecorso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.indirizzo_decorso
     *
     * @param indirizzoDecorso the value for decorso.indirizzo_decorso
     *
     * @mbg.generated
     */
    public void setIndirizzoDecorso(String indirizzoDecorso) {
        this.indirizzoDecorso = indirizzoDecorso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column decorso.decorso_presso
     *
     * @return the value of decorso.decorso_presso
     *
     * @mbg.generated
     */
    public String getDecorsoPresso() {
        return decorsoPresso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column decorso.decorso_presso
     *
     * @param decorsoPresso the value for decorso.decorso_presso
     *
     * @mbg.generated
     */
    public void setDecorsoPresso(String decorsoPresso) {
        this.decorsoPresso = decorsoPresso;
    }
    
	public String getLuogoPaziente() {
		return luogoPaziente;
	}

	public void setLuogoPaziente(String luogoPaziente) {
		this.luogoPaziente = luogoPaziente;
	}

	public String getDescrizioneContesto() {
		return descrizioneContesto;
	}

	public void setDescrizioneContesto(String descrizioneContesto) {
		this.descrizioneContesto = descrizioneContesto;
	}
}