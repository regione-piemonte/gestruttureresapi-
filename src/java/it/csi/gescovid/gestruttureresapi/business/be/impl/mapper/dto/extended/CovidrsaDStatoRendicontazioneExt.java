/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWorkflowRendicontazione;

public class CovidrsaDStatoRendicontazioneExt extends CovidrsaDStatoRendicontazione {

    private List<CovidrsaDWorkflowRendicontazione>  workflowRendicontazione;

    public List<CovidrsaDWorkflowRendicontazione> getWorkflowRendicontazione() {
        return workflowRendicontazione;
    }

    public void setWorkflowRendicontazione(List<CovidrsaDWorkflowRendicontazione> workflowRendicontazione) {
        this.workflowRendicontazione = workflowRendicontazione;
    }
}
