/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class FileToBeSaved extends AbstractDto {
    private String filename;
    private String base64String;
    private Integer fileTipoId;
    
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getBase64String() {
        return base64String;
    }
    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }
    public Integer getFileTipoId() {
        return fileTipoId;
    }
    public void setFileTipoId(Integer fileTipoId) {
        this.fileTipoId = fileTipoId;
    }
}
