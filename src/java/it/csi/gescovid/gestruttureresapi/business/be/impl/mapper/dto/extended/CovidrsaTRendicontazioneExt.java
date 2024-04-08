/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRRendicontazioneFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;

public class CovidrsaTRendicontazioneExt extends CovidrsaTRendicontazione {

    private List<CovidrsaRRendicontazioneFile> files;
    private CovidrsaTMovimentoOspite movimentoOspiteUscita;

    public List<CovidrsaRRendicontazioneFile> getFiles() {
        return files;
    }

    public void setFiles(List<CovidrsaRRendicontazioneFile> files) {
        this.files = files;
    }

    public CovidrsaTMovimentoOspite getMovimentoOspiteUscita() {
        return movimentoOspiteUscita;
    }

    public void setMovimentoOspiteUscita(CovidrsaTMovimentoOspite movimentoOspiteUscita) {
        this.movimentoOspiteUscita = movimentoOspiteUscita;
    }
}
