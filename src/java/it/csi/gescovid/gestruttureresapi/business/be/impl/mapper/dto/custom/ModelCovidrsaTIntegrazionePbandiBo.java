/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ModelCovidrsaTIntegrazionePbandiBo extends AbstractDto {

    private Integer invioPbandiId;
    private Integer integrazionePbandiId;
    private String dicSpesaIntegrazioneCode;
    private String dicSpesaIntegrazioneNote;
    private String dicSpesaIntegrazioneData;
    private String periodoInizio;
    private String periodoFine;
    private String dataScadenza;
    private String dataRisposta;
    private String rsaCod;
    private String rsaNome;
    private List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> allegati;
    public Integer getInvioPbandiId() {
        return invioPbandiId;
    }
    public void setInvioPbandiId(Integer invioPbandiId) {
        this.invioPbandiId = invioPbandiId;
    }
    public Integer getIntegrazionePbandiId() {
        return integrazionePbandiId;
    }
    public void setIntegrazionePbandiId(Integer integrazionePbandiId) {
        this.integrazionePbandiId = integrazionePbandiId;
    }
    public String getDicSpesaIntegrazioneCode() {
        return dicSpesaIntegrazioneCode;
    }
    public void setDicSpesaIntegrazioneCode(String dicSpesaIntegrazioneCode) {
        this.dicSpesaIntegrazioneCode = dicSpesaIntegrazioneCode;
    }
    public String getDicSpesaIntegrazioneNote() {
        return dicSpesaIntegrazioneNote;
    }
    public void setDicSpesaIntegrazioneNote(String dicSpesaIntegrazioneNote) {
        this.dicSpesaIntegrazioneNote = dicSpesaIntegrazioneNote;
    }
    public String getDicSpesaIntegrazioneData() {
        return dicSpesaIntegrazioneData;
    }
    public void setDicSpesaIntegrazioneData(String dicSpesaIntegrazioneData) {
        this.dicSpesaIntegrazioneData = dicSpesaIntegrazioneData;
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
    public String getDataScadenza() {
        return dataScadenza;
    }
    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
    public List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> getAllegati() {
        return allegati;
    }
    public void setAllegati(List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> allegati) {
        this.allegati = allegati;
    }
    public String getDataRisposta() {
        return dataRisposta;
    }
    public void setDataRisposta(String dataRisposta) {
        this.dataRisposta = dataRisposta;
    }
    public String getRsaNome() {
        return rsaNome;
    }
    public void setRsaNome(String rsaNome) {
        this.rsaNome = rsaNome;
    }
    public String getRsaCod() {
        return rsaCod;
    }
    public void setRsaCod(String rsaCod) {
        this.rsaCod = rsaCod;
    }
    
}
