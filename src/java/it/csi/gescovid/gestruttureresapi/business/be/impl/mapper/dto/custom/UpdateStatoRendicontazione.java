/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class UpdateStatoRendicontazione extends AbstractDto {

    private Integer oldStato;
    private Integer newStato;
    private List<Integer> rendicontazioniId;
    
    public Integer getOldStato() {
        return oldStato;
    }
    public void setOldStato(Integer oldStato) {
        this.oldStato = oldStato;
    }
    public Integer getNewStato() {
        return newStato;
    }
    public void setNewStato(Integer newStato) {
        this.newStato = newStato;
    }
    public List<Integer> getRendicontazioniId() {
        return rendicontazioniId;
    }
    public void setRendicontazioniId(List<Integer> rendicontazioniId) {
        this.rendicontazioniId = rendicontazioniId;
    }
}
