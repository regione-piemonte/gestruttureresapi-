/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsarIntegrazionePbandiFile;
import it.csi.gescovid.gestruttureresapi.dto.CovidusTFile;

public class CovidrsarIntegrazionePbandiFileExt extends CovidrsarIntegrazionePbandiFile {
    private CovidusTFile file;

    public CovidusTFile getFile() {
        return file;
    }

    public void setFile(CovidusTFile file) {
        this.file = file;
    }
}
