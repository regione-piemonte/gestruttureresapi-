/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

public class EsitoAcquisizione {
    private String uuid;
    private String esito;
    private ErroreEsitoAcquisizione errore;
    public ErroreEsitoAcquisizione getErrore() {
        return errore;
    }
    public void setErrore(ErroreEsitoAcquisizione errore) {
        this.errore = errore;
    }
    public String getEsito() {
        return esito;
    }
    public void setEsito(String esito) {
        this.esito = esito;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
