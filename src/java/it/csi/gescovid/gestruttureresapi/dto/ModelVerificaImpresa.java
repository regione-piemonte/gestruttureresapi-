/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ModelVerificaImpresa extends AbstractDto {
    private String ragioneSociale;
    private ModelSede sede;
    private ModelPersona rappresentanteLegale;
    private ModelPersona titolare;
    private Boolean rapLegVerificato;
    private Boolean entGestVerificato;
    private Boolean titEffVerificato;
    
    public String getRagioneSociale() {
        return ragioneSociale;
    }
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
    public ModelSede getSede() {
        return sede;
    }
    public void setSede(ModelSede sede) {
        this.sede = sede;
    }
    public Boolean getRapLegVerificato() {
        return rapLegVerificato;
    }
    public void setRapLegVerificato(Boolean rapLegVerificato) {
        this.rapLegVerificato = rapLegVerificato;
    }
    public Boolean getEntGestVerificato() {
        return entGestVerificato;
    }
    public void setEntGestVerificato(Boolean entGestVerificato) {
        this.entGestVerificato = entGestVerificato;
    }
    public ModelPersona getTitolare() {
        return titolare;
    }
    public void setTitolare(ModelPersona titolare) {
        this.titolare = titolare;
    }
    public Boolean getTitEffVerificato() {
        return titEffVerificato;
    }
    public void setTitEffVerificato(Boolean titEffVerificato) {
        this.titEffVerificato = titEffVerificato;
    }
    public ModelPersona getRappresentanteLegale() {
        return rappresentanteLegale;
    }
    public void setRappresentanteLegale(ModelPersona rappresentanteLegale) {
        this.rappresentanteLegale = rappresentanteLegale;
    }
}
