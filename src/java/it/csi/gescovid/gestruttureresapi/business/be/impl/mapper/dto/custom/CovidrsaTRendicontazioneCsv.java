/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.math.BigDecimal;
import java.util.Date;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class CovidrsaTRendicontazioneCsv extends AbstractDto {

    private String idStruttura;
    private Date dataRendicontazione;
    private BigDecimal importoRetta;
    private Integer buonoresId;
    private Boolean flgPrimoIngresso;
    private String note;
    private String codiceFiscale;
    private String cognome;
    private String nome;
    private Date dataNascita;
    private String statoRendicontazione;
    private Date dataUscita;
    private String motivoUscita;
    
    public String getIdStruttura() {
        return idStruttura;
    }
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }
    public Date getDataRendicontazione() {
        return dataRendicontazione;
    }
    public void setDataRendicontazione(Date dataRendicontazione) {
        this.dataRendicontazione = dataRendicontazione;
    }
    public BigDecimal getImportoRetta() {
        return importoRetta;
    }
    public void setImportoRetta(BigDecimal importoRetta) {
        this.importoRetta = importoRetta;
    }
    public Boolean getFlgPrimoIngresso() {
        return flgPrimoIngresso;
    }
    public void setFlgPrimoIngresso(Boolean flgPrimoIngresso) {
        this.flgPrimoIngresso = flgPrimoIngresso;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getStatoRendicontazione() {
        return statoRendicontazione;
    }
    public void setStatoRendicontazione(String statoRendicontazione) {
        this.statoRendicontazione = statoRendicontazione;
    }
    public Date getDataUscita() {
        return dataUscita;
    }
    public void setDataUscita(Date dataUscita) {
        this.dataUscita = dataUscita;
    }
    public String getMotivoUscita() {
        return motivoUscita;
    }
    public void setMotivoUscita(String motivoUscita) {
        this.motivoUscita = motivoUscita;
    }
    public Integer getBuonoresId() {
        return buonoresId;
    }
    public void setBuonoresId(Integer buonoresId) {
        this.buonoresId = buonoresId;
    }
    
}
