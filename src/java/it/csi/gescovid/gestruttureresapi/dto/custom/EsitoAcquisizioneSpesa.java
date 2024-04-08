/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

import java.util.ArrayList;

public class EsitoAcquisizioneSpesa {
    private EsitoAcquisizione esito_acquisizione;
    private ArrayList<DocumentiEsitoAcquisizione> documenti;
    private String id_dichiarazione_spesa_bandi;
    
    public EsitoAcquisizione getEsito_acquisizione() {
        return esito_acquisizione;
    }
    public void setEsito_acquisizione(EsitoAcquisizione esito_acquisizione) {
        this.esito_acquisizione = esito_acquisizione;
    }
    public ArrayList<DocumentiEsitoAcquisizione> getDocumenti() {
        return documenti;
    }
    public void setDocumenti(ArrayList<DocumentiEsitoAcquisizione> documenti) {
        this.documenti = documenti;
    }
    public String getId_dichiarazione_spesa_bandi() {
        return id_dichiarazione_spesa_bandi;
    }
    public void setId_dichiarazione_spesa_bandi(String id_dichiarazione_spesa_bandi) {
        this.id_dichiarazione_spesa_bandi = id_dichiarazione_spesa_bandi;
    }
}
