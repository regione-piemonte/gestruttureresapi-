/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

import java.math.BigDecimal;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class FileResponse extends AbstractDto {

    private String file;
    private String fileName;
    private String fileType;
    private BigDecimal fileSize;
    
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public BigDecimal getFileSize() {
        return fileSize;
    }
    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }
}
