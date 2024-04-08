/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfareFile;

public class CovidrsaRStrutturaWelfareFileExt extends CovidrsaRStrutturaWelfareFile {

    private String fileTipoCod;
    private String fileTipoDesc;
    private String fileTipoGruppo;
    
    public String getFileTipoDesc() {
        return fileTipoDesc;
    }
    public void setFileTipoDesc(String fileTipoDesc) {
        this.fileTipoDesc = fileTipoDesc;
    }
    public String getFileTipoCod() {
        return fileTipoCod;
    }
    public void setFileTipoCod(String fileTipoCod) {
        this.fileTipoCod = fileTipoCod;
    }
    public String getFileTipoGruppo() {
        return fileTipoGruppo;
    }
    public void setFileTipoGruppo(String fileTipoGruppo) {
        this.fileTipoGruppo = fileTipoGruppo;
    }
    
}
