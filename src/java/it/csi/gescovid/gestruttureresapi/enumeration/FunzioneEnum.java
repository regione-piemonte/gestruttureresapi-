/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.enumeration;

public enum FunzioneEnum {

    DECORSO("DECORSO"),
    RSA_DECESSO("RSA_DECESSO"),
    RSA_OSPITE("RSA_OSPITE"),
    RSA_PERSONALE("RSA_PERSONALE"),
    RSA_POSTI("RSA_POSTI"),
    RSA_STRUTTURA_NOTE("RSA_STRUTTURA_NOTE"),
    RSA_STRUTTURA_INFO("RSA_STRUTTURA_INFO"),
    STRUTTURA_WELFARE("STRUTTURA_WELFARE"),
    RSA_TAMPONE("RSA_TAMPONE"),
    RSA_VISITATORI("RSA_VISITATORI"),
    SOGGETTI("SOGGETTI"),
    SOGGETTO_STRUTTURA("SOGGETTO_STRUTTURA"), 
    FIRMA("FIRMA"),
    RSA_STRUTTURA_CONTO("RSA_STRUTTURA_CONTO"),
    RSA_MOVIMENTO_OSPITE("RSA_MOVIMENTO_OSPITE"),
    RSA_RENDICONTAZIONE("RSA_RENDICONTAZIONE"),
    RSA_TAMPONE_RICHIESTA("RSA_TAMPONE_RICHIESTA"),
    BANDI_RICHIESTA("BANDI_RICHIESTA"),
    FILE("FILE"),
    ;

    private final String code;

    private FunzioneEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
