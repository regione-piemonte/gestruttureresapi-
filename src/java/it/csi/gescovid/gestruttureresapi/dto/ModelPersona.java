/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ModelPersona extends AbstractDto {
    private String codiceFiscale;
    private String cognome;
    private String nome;
    private String dataNascita; 
    private String comuneNascita; 
    private String provinciaNascita;
    private String indirizzoResidenza; 
    private String comuneResidenza; 
    private String provinciaResidenza; 
    
    
    

    public String getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getComuneNascita() {
        return comuneNascita;
    }
    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }
    public String getProvinciaNascita() {
        return provinciaNascita;
    }
    public void setProvinciaNascita(String provinciaNascita) {
        this.provinciaNascita = provinciaNascita;
    }
    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }
    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }
    public String getComuneResidenza() {
        return comuneResidenza;
    }
    public void setComuneResidenza(String comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }
    public String getProvinciaResidenza() {
        return provinciaResidenza;
    }
    public void setProvinciaResidenza(String provinciaResidenza) {
        this.provinciaResidenza = provinciaResidenza;
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
    
}
