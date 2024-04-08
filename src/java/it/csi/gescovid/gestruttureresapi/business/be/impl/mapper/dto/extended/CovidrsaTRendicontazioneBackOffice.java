/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.Date;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRStrutturaConto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTInvioPbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfare;

public class CovidrsaTRendicontazioneBackOffice extends CovidrsaTRendicontazione {

    private CovidrsaDStatoRendicontazione statoRendicontazione;
    private CovidrsaTInvioPbandi invioPbandi;
    private CovidrsaRStrutturaConto conto;
    private CovidrsaRStrutturaWelfare strutturaWelfare;
    private CovidrsaTMovimentoOspite movimentoOspite;
    private CovidrsaDTipoMovOspite movimentoOspiteDescrizione;
    private CovidrsaDWelfareFascia fascia;
    private String strutturaArpe;
    private String noteIstruttoria;
    private Date dataIstruttoria;
    
    public CovidrsaDStatoRendicontazione getStatoRendicontazione() {
        return statoRendicontazione;
    }

    public void setStatoRendicontazione(CovidrsaDStatoRendicontazione statoRendicontazione) {
        this.statoRendicontazione = statoRendicontazione;
    }

    public CovidrsaTInvioPbandi getInvioPbandi() {
        return invioPbandi;
    }

    public void setInvioPbandi(CovidrsaTInvioPbandi invioPbandi) {
        this.invioPbandi = invioPbandi;
    }

    public CovidrsaRStrutturaWelfare getStrutturaWelfare() {
        return strutturaWelfare;
    }

    public void setStrutturaWelfare(CovidrsaRStrutturaWelfare strutturaWelfare) {
        this.strutturaWelfare = strutturaWelfare;
    }

    public CovidrsaTMovimentoOspite getMovimentoOspite() {
        return movimentoOspite;
    }

    public void setMovimentoOspite(CovidrsaTMovimentoOspite movimentoOspite) {
        this.movimentoOspite = movimentoOspite;
    }

    public CovidrsaDTipoMovOspite getMovimentoOspiteDescrizione() {
        return movimentoOspiteDescrizione;
    }

    public void setMovimentoOspiteDescrizione(CovidrsaDTipoMovOspite movimentoOspiteDescrizione) {
        this.movimentoOspiteDescrizione = movimentoOspiteDescrizione;
    }

    public CovidrsaRStrutturaConto getConto() {
        return conto;
    }

    public void setConto(CovidrsaRStrutturaConto conto) {
        this.conto = conto;
    }

    public CovidrsaDWelfareFascia getFascia() {
        return fascia;
    }

    public void setFascia(CovidrsaDWelfareFascia fascia) {
        this.fascia = fascia;
    }

    public String getStrutturaArpe() {
        return strutturaArpe;
    }

    public void setStrutturaArpe(String strutturaArpe) {
        this.strutturaArpe = strutturaArpe;
    }

    public String getNoteIstruttoria() {
        return noteIstruttoria;
    }

    public void setNoteIstruttoria(String noteIstruttoria) {
        this.noteIstruttoria = noteIstruttoria;
    }

    public Date getDataIstruttoria() {
        return dataIstruttoria;
    }

    public void setDataIstruttoria(Date dataIstruttoria) {
        this.dataIstruttoria = dataIstruttoria;
    }
}
