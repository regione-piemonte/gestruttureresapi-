/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRRendicontazioneFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.FileToBeSaved;

public class CovidrsaRRendicontazioneFileExt extends CovidrsaRRendicontazioneFile {
    
    private FileToBeSaved fileToBeSaved;

    public FileToBeSaved getFileToBeSaved() {
        return fileToBeSaved;
    }

    public void setFileToBeSaved(FileToBeSaved fileToBeSaved) {
        this.fileToBeSaved = fileToBeSaved;
    }

}
