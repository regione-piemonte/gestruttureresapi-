/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRTipoMovOspiteNaturaSad;

public class CovidrsaDTipoMovOspiteExt extends CovidrsaDTipoMovOspite {
    
    private List<CovidrsaRTipoMovOspiteNaturaSad> tipoMovOspiteNaturaSod;

    public List<CovidrsaRTipoMovOspiteNaturaSad> getTipoMovOspiteNaturaSod() {
        return tipoMovOspiteNaturaSod;
    }

    public void setTipoMovOspiteNaturaSod(List<CovidrsaRTipoMovOspiteNaturaSad> tipoMovOspiteNaturaSod) {
        this.tipoMovOspiteNaturaSod = tipoMovOspiteNaturaSod;
    }
}
