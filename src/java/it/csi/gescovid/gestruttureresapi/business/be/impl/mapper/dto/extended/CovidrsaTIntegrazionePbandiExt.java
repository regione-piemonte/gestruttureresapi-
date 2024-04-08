/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTIntegrazionePbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.util.genericinterface.ListInterface;

public class CovidrsaTIntegrazionePbandiExt extends CovidrsaTIntegrazionePbandi implements ListInterface {
    private Soggetto soggetto;
    private List<CovidrsarIntegrazionePbandiFileExt> file;
    private Long totalCount;
    
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

    public List<CovidrsarIntegrazionePbandiFileExt> getFile() {
        return file;
    }

    public void setFile(List<CovidrsarIntegrazionePbandiFileExt> file) {
        this.file = file;
    }
    

}
