/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ModelRendicontazioniBoResponse extends AbstractDto {
    private Integer idDicSpesa;
    private String dicSpesaCod;
    private String dicSpesaPeriodoDesc;
    private String dicSpesaData;
    private String dicSpesaCodBandi;
    private String periodoInizio;
    private String periodoFine;
    private String statoCod;
    private String statoDesc;
    private String dataInvio;
    private List<Object> allegatiDichiarazioneSpesa;
    private List<ModelRendicontazioniBoDocumentiSpesa> documentiSpesa;
    
    public String getDicSpesaCod() {
        return dicSpesaCod;
    }

    public void setDicSpesaCod(String dicSpesaCod) {
        this.dicSpesaCod = dicSpesaCod;
    }

    public String getDicSpesaPeriodoDesc() {
        return dicSpesaPeriodoDesc;
    }

    public void setDicSpesaPeriodoDesc(String dicSpesaPeriodoDesc) {
        this.dicSpesaPeriodoDesc = dicSpesaPeriodoDesc;
    }

    public String getDicSpesaData() {
        return dicSpesaData;
    }

    public void setDicSpesaData(String dicSpesaData) {
        this.dicSpesaData = dicSpesaData;
    }

    public String getDicSpesaCodBandi() {
        return dicSpesaCodBandi;
    }

    public void setDicSpesaCodBandi(String dicSpesaCodBandi) {
        this.dicSpesaCodBandi = dicSpesaCodBandi;
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

    public String getStatoCod() {
        return statoCod;
    }

    public void setStatoCod(String statoCod) {
        this.statoCod = statoCod;
    }

    public String getStatoDesc() {
        return statoDesc;
    }

    public void setStatoDesc(String statoDesc) {
        this.statoDesc = statoDesc;
    }

    public String getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(String dataInvio) {
        this.dataInvio = dataInvio;
    }

    public List<Object> getAllegatiDichiarazioneSpesa() {
        return allegatiDichiarazioneSpesa;
    }

    public void setAllegatiDichiarazioneSpesa(List<Object> allegatiDichiarazioneSpesa) {
        this.allegatiDichiarazioneSpesa = allegatiDichiarazioneSpesa;
    }

    public List<ModelRendicontazioniBoDocumentiSpesa> getDocumentiSpesa() {
        return documentiSpesa;
    }

    public void setDocumentiSpesa(List<ModelRendicontazioniBoDocumentiSpesa> documentiSpesa) {
        this.documentiSpesa = documentiSpesa;
    }

    public Integer getIdDicSpesa() {
        return idDicSpesa;
    }

    public void setIdDicSpesa(Integer idDicSpesa) {
        this.idDicSpesa = idDicSpesa;
    }

}
