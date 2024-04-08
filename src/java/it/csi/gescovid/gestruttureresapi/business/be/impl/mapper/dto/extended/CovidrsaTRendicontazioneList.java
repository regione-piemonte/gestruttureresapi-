/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Comuni;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.util.genericinterface.ListInterface;

public class CovidrsaTRendicontazioneList extends CovidrsaTRendicontazione implements ListInterface {

    private Long totalCount;
    private Soggetto soggetto;
    private Comuni comuneResidenza;
    private Comuni comuneDomicilio;
    private CovidrsaDStatoRendicontazione  covidrsaDStatoRendicontazione;
    private List<CovidrsaRRendicontazioneFileExt> files;
    private Boolean flgPrimaRendicontazione;
    private Boolean flgUltimaRendicontazione;
    private Boolean flgTrasferito;
    private CovidrsaTMovimentoOspiteExt movimentoOspiteUscita;
    
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Soggetto getSoggetto() {
        return soggetto;
    }

    public void setSoggetto(Soggetto soggetto) {
        this.soggetto = soggetto;
    }

    public Comuni getComuneResidenza() {
        return comuneResidenza;
    }

    public void setComuneResidenza(Comuni comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }

    public Comuni getComuneDomicilio() {
        return comuneDomicilio;
    }

    public void setComuneDomicilio(Comuni comuneDomicilio) {
        this.comuneDomicilio = comuneDomicilio;
    }

    public CovidrsaDStatoRendicontazione getCovidrsaDStatoRendicontazione() {
        return covidrsaDStatoRendicontazione;
    }

    public void setCovidrsaDStatoRendicontazione(CovidrsaDStatoRendicontazione covidrsaDStatoRendicontazione) {
        this.covidrsaDStatoRendicontazione = covidrsaDStatoRendicontazione;
    }

    public List<CovidrsaRRendicontazioneFileExt> getFiles() {
        return files;
    }

    public void setFiles(List<CovidrsaRRendicontazioneFileExt> files) {
        this.files = files;
    }

    public Boolean getFlgPrimaRendicontazione() {
        return flgPrimaRendicontazione;
    }

    public void setFlgPrimaRendicontazione(Boolean flgPrimaRendicontazione) {
        this.flgPrimaRendicontazione = flgPrimaRendicontazione;
    }

    public Boolean getFlgUltimaRendicontazione() {
        return flgUltimaRendicontazione;
    }

    public void setFlgUltimaRendicontazione(Boolean flgUltimaRendicontazione) {
        this.flgUltimaRendicontazione = flgUltimaRendicontazione;
    }

    public CovidrsaTMovimentoOspiteExt getMovimentoOspiteUscita() {
        return movimentoOspiteUscita;
    }

    public void setMovimentoOspiteUscita(CovidrsaTMovimentoOspiteExt movimentoOspiteUscita) {
        this.movimentoOspiteUscita = movimentoOspiteUscita;
    }

    public Boolean getFlgTrasferito() {
        return flgTrasferito;
    }

    public void setFlgTrasferito(Boolean flgTrasferito) {
        this.flgTrasferito = flgTrasferito;
    }

}
