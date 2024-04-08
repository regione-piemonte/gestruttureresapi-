/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ListaDocIntegrazioneSpesa extends AbstractDto {

    private String nomeDocumento;
    private String documento;

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
