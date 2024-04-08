/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.enumeration;

public enum FileTipoEnum {

    RBR_DICHIARAZIONE("RBR_DICHIARAZIONE"),
    RBR_MESE_1_PRIMO_INGRESSO("RBR_MESE_1_PRIMO_INGRESSO"),
    RBR_MESE_1("RBR_MESE_1"),
    RBR("RBR"),
    ;

    private final String code;

    private FileTipoEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
