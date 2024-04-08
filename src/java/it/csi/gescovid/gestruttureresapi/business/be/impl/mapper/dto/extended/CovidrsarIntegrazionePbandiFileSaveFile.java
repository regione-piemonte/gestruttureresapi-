/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsarIntegrazionePbandiFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.FileToBeSaved;

public class CovidrsarIntegrazionePbandiFileSaveFile extends CovidrsarIntegrazionePbandiFile {
    private FileToBeSaved file;

    public FileToBeSaved getFile() {
        return file;
    }

    public void setFile(FileToBeSaved file) {
        this.file = file;
    }

}
