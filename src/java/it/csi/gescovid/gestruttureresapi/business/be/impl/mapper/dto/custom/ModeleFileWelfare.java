/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.Date;
import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.FileToBeSaved;
import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfare;

public class ModeleFileWelfare {

    private Integer strWelfareId;
    private Date validitaInizio;
    private Date validitaFine;
    private List<FileToBeSaved> files;
    private Boolean firmaRappresentanteLegale;

    
    public Integer getStrWelfareId() {
        return strWelfareId;
    }

    public void setStrWelfareId(Integer strWelfareId) {
        this.strWelfareId = strWelfareId;
    }

    public Date getValiditaInizio() {
        return validitaInizio;
    }

    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    public Date getValiditaFine() {
        return validitaFine;
    }

    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    public List<FileToBeSaved> getFiles() {
        return files;
    }

    public void setFiles(List<FileToBeSaved> files) {
        this.files = files;
    }

    public Boolean getFirmaRappresentanteLegale() {
        return firmaRappresentanteLegale;
    }

    public void setFirmaRappresentanteLegale(Boolean firmaRappresentanteLegale) {
        this.firmaRappresentanteLegale = firmaRappresentanteLegale;
    }
}
