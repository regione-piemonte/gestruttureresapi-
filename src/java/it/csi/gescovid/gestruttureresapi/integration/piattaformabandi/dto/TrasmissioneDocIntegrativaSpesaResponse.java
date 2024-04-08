/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto;

import org.springframework.http.HttpStatus;

public class TrasmissioneDocIntegrativaSpesaResponse {
    private HttpStatus status;
    private Message errore;
    private DocIntegrativaSpesaResponse docIntegrativaSpesaResponse;
    
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Message getErrore() {
        return errore;
    }

    public void setErrore(Message errore) {
        this.errore = errore;
    }

    public DocIntegrativaSpesaResponse getDocIntegrativaSpesaResponse() {
        return docIntegrativaSpesaResponse;
    }

    public void setDocIntegrativaSpesaResponse(DocIntegrativaSpesaResponse docIntegrativaSpesaResponse2) {
        this.docIntegrativaSpesaResponse = docIntegrativaSpesaResponse2;
    }

    @Override
    public String toString() {
        return "TrasmissioneDocIntegrativaSpesaResponse [status=" + status + ", errore=" + errore
                + ", docIntegrativaSpesaResponse=" + docIntegrativaSpesaResponse + "]";
    }

}
