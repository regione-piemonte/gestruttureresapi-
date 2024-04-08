/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.List;

public class ModelRendicontazioniBoDocumentiSpesaDettaglio {
    private Integer idDocSpesaDettaglio;
    private String documentoSpesaDettaglioData;
    private String importo;
    private List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> allegati;

    public String getDocumentoSpesaDettaglioData() {
        return documentoSpesaDettaglioData;
    }

    public void setDocumentoSpesaDettaglioData(String documentoSpesaDettaglioData) {
        this.documentoSpesaDettaglioData = documentoSpesaDettaglioData;
    }

    public String getImporto() {
        return importo;
    }

    public void setImporto(String importo) {
        this.importo = importo;
    }

    public List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> getAllegati() {
        return allegati;
    }

    public void setAllegati(List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> allegati) {
        this.allegati = allegati;
    }

    public Integer getIdDocSpesaDettaglio() {
        return idDocSpesaDettaglio;
    }

    public void setIdDocSpesaDettaglio(Integer idDocSpesaDettaglio) {
        this.idDocSpesaDettaglio = idDocSpesaDettaglio;
    }
}
