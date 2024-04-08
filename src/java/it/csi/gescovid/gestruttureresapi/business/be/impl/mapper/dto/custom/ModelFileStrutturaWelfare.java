/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

public class ModelFileStrutturaWelfare extends FileToBeSaved {
    private Boolean firmaVerificata;
    private String fileTipoCod;
    private String fileTipoDesc;
    
    public Boolean getFirmaVerificata() {
        return firmaVerificata;
    }
    public void setFirmaVerificata(Boolean firmaVerificata) {
        this.firmaVerificata = firmaVerificata;
    }
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
}
