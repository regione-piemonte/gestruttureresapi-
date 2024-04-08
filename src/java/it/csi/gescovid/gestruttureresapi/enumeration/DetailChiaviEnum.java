/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.enumeration;

public enum DetailChiaviEnum {

    CODE("CODE"),
    RENDICONTAZIONE_ID("rendicontazioneId"),
    ;

    private final String code;

    private DetailChiaviEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
