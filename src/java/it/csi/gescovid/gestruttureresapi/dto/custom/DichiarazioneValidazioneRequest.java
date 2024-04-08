/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

public class DichiarazioneValidazioneRequest {    
    
    private ValidazioneDichiarazione validazione_dichiarazione;

    public ValidazioneDichiarazione getValidazione_dichiarazione() {
        return validazione_dichiarazione;
    }

    public void setValidazione_dichiarazione(ValidazioneDichiarazione validazione_dichiarazione) {
        this.validazione_dichiarazione = validazione_dichiarazione;
    }

}
