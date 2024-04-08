/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto;

public class DocIntegrativaSpesaResponse {
    private String esito;
    private String messaggioErrore;
    private String codiceErrore;

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getMessaggioErrore() {
        return messaggioErrore;
    }

    public void setMessaggioErrore(String messaggioErrore) {
        this.messaggioErrore = messaggioErrore;
    }

    public String getCodiceErrore() {
        return codiceErrore;
    }

    public void setCodiceErrore(String codiceErrore) {
        this.codiceErrore = codiceErrore;
    }

    @Override
    public String toString() {
        return "DocIntegrativaSpesaResponse [esito=" + esito + ", messaggioErrore=" + messaggioErrore
                + ", codiceErrore=" + codiceErrore + "]";
    }
}
