/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class TrasmissioneDocIntegrativaSpesaRequest extends AbstractDto {

    private Integer identificativoRichiestaDiIntegrazione;
    private List<ListaDocIntegrazioneSpesa> listaDocIntegrazioneSpesa;

    public Integer getIdentificativoRichiestaDiIntegrazione() {
        return identificativoRichiestaDiIntegrazione;
    }

    public void setIdentificativoRichiestaDiIntegrazione(Integer identificativoRichiestaDiIntegrazione) {
        this.identificativoRichiestaDiIntegrazione = identificativoRichiestaDiIntegrazione;
    }

    public List<ListaDocIntegrazioneSpesa> getListaDocIntegrazioneSpesa() {
        return listaDocIntegrazioneSpesa;
    }

    public void setListaDocIntegrazioneSpesa(List<ListaDocIntegrazioneSpesa> listaDocIntegrazioneSpesa) {
        this.listaDocIntegrazioneSpesa = listaDocIntegrazioneSpesa;
    }

}
