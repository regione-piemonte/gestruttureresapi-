/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFileStrutturaWelfare;
import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfare;

public class CovidrsaRStrutturaWelfareExt extends CovidrsaRStrutturaWelfare {

    private List<ModelFileStrutturaWelfare> files;
    private List<ModelFascia> fascia;
    private Boolean richiestaFinalizzata;
    private Boolean rilevazioniPresenti;

    public Boolean getRichiestaFinalizzata() {
        return richiestaFinalizzata;
    }

    public void setRichiestaFinalizzata(Boolean richiestaFinalizzata) {
        this.richiestaFinalizzata = richiestaFinalizzata;
    }

    public Boolean getRilevazioniPresenti() {
        return rilevazioniPresenti;
    }

    public void setRilevazioniPresenti(Boolean rilevazioniPresenti) {
        this.rilevazioniPresenti = rilevazioniPresenti;
    }

    public List<ModelFileStrutturaWelfare> getFiles() {
        return files;
    }

    public void setFiles(List<ModelFileStrutturaWelfare> files) {
        this.files = files;
    }

    public List<ModelFascia> getFascia() {
        return fascia;
    }

    public void setFascia(List<ModelFascia> fascia) {
        this.fascia = fascia;
    }
}
