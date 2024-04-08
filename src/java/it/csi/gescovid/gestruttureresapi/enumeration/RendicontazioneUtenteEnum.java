/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.enumeration;

public enum RendicontazioneUtenteEnum {

    STRUTTURA("STRUTTURA"),
    ENTE_GESTORE("ENTE_GESTORE")
    ;

    private final String code;

    private RendicontazioneUtenteEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
