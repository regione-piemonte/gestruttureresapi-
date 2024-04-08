/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.Date;
import java.util.List;

public class ModelRendicontazioniBoDocumentiSpesa {
    private Integer idDocSpesa;
    private String doc_tipo;
    private String doc_numero;
    private String periodoInizio;
    private String periodoFine;
    private String rsaCod;
    private String rsaCodArpe;
    private String rsaPIva;
    private String rsaNome;
    private String rsaIBAN;
    private String fascia;
    private boolean flagPrimoIngresso;
    private String movUscitaData;
    private String movUscitaMotivazione;
    private String note;
    private List<ModelRendicontazioniBoDocumentiSpesaDettaglio> documentiSpesaDettaglio;
    private String noteIstruttoria;
    private String dataIstruttoria;

    public String getDoc_tipo() {
        return doc_tipo;
    }

    public void setDoc_tipo(String doc_tipo) {
        this.doc_tipo = doc_tipo;
    }

    public String getDoc_numero() {
        return doc_numero;
    }

    public void setDoc_numero(String doc_numero) {
        this.doc_numero = doc_numero;
    }

    public String getPeriodoInizio() {
        return periodoInizio;
    }

    public void setPeriodoInizio(String periodoInizio) {
        this.periodoInizio = periodoInizio;
    }

    public String getPeriodoFine() {
        return periodoFine;
    }

    public void setPeriodoFine(String periodoFine) {
        this.periodoFine = periodoFine;
    }

    public String getRsaCod() {
        return rsaCod;
    }

    public void setRsaCod(String rsaCod) {
        this.rsaCod = rsaCod;
    }

    public String getRsaCodArpe() {
        return rsaCodArpe;
    }

    public void setRsaCodArpe(String rsaCodArpe) {
        this.rsaCodArpe = rsaCodArpe;
    }

    public String getRsaPIva() {
        return rsaPIva;
    }

    public void setRsaPIva(String rsaPIva) {
        this.rsaPIva = rsaPIva;
    }

    public String getRsaNome() {
        return rsaNome;
    }

    public void setRsaNome(String rsaNome) {
        this.rsaNome = rsaNome;
    }

    public String getRsaIBAN() {
        return rsaIBAN;
    }

    public void setRsaIBAN(String rsaIBAN) {
        this.rsaIBAN = rsaIBAN;
    }

    public String getFascia() {
        return fascia;
    }

    public void setFascia(String fascia) {
        this.fascia = fascia;
    }

    public boolean isFlagPrimoIngresso() {
        return flagPrimoIngresso;
    }

    public void setFlagPrimoIngresso(boolean flagPrimoIngresso) {
        this.flagPrimoIngresso = flagPrimoIngresso;
    }

    public String getMovUscitaData() {
        return movUscitaData;
    }

    public void setMovUscitaData(String movUscitaData) {
        this.movUscitaData = movUscitaData;
    }

    public String getMovUscitaMotivazione() {
        return movUscitaMotivazione;
    }

    public void setMovUscitaMotivazione(String movUscitaMotivazione) {
        this.movUscitaMotivazione = movUscitaMotivazione;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ModelRendicontazioniBoDocumentiSpesaDettaglio> getDocumentiSpesaDettaglio() {
        return documentiSpesaDettaglio;
    }

    public void setDocumentiSpesaDettaglio(List<ModelRendicontazioniBoDocumentiSpesaDettaglio> documentiSpesaDettaglio) {
        this.documentiSpesaDettaglio = documentiSpesaDettaglio;
    }

    public Integer getIdDocSpesa() {
        return idDocSpesa;
    }

    public void setIdDocSpesa(Integer idDocSpesa) {
        this.idDocSpesa = idDocSpesa;
    }

    public String getDataIstruttoria() {
        return dataIstruttoria;
    }

    public void setDataIstruttoria(String dataIstruttoria) {
        this.dataIstruttoria = dataIstruttoria;
    }

    public String getNoteIstruttoria() {
        return noteIstruttoria;
    }

    public void setNoteIstruttoria(String noteIstruttoria) {
        this.noteIstruttoria = noteIstruttoria;
    }

}
