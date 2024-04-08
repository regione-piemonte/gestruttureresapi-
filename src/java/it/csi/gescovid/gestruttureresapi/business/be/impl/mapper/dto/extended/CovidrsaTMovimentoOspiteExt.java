/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Struttura;

public class CovidrsaTMovimentoOspiteExt extends CovidrsaTMovimentoOspite {

    private Soggetto soggetto;
    private CovidrsaDTipoMovOspite covidrsaDTipoMovOspite;
    private Struttura struttura;
    
    public Soggetto getSoggetto() {
        return soggetto;
    }

    public void setSoggetto(Soggetto soggetto) {
        this.soggetto = soggetto;
    }

    public CovidrsaDTipoMovOspite getCovidrsaDTipoMovOspite() {
        return covidrsaDTipoMovOspite;
    }

    public void setCovidrsaDTipoMovOspite(CovidrsaDTipoMovOspite covidrsaDTipoMovOspite) {
        this.covidrsaDTipoMovOspite = covidrsaDTipoMovOspite;
    }

    public Struttura getStruttura() {
        return struttura;
    }

    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }
}
