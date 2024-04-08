/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

public class IntegrazioneSpesa {
    private String id_dichiarazione_spesa_bandi;
    private String identificativo_richiesta_integrazione;
    private String data_azione;
    private String note;
    private Integer numero_giorni;
    
    public String getId_dichiarazione_spesa_bandi() {
        return id_dichiarazione_spesa_bandi;
    }
    public void setId_dichiarazione_spesa_bandi(String id_dichiarazione_spesa_bandi) {
        this.id_dichiarazione_spesa_bandi = id_dichiarazione_spesa_bandi;
    }
    public String getIdentificativo_richiesta_integrazione() {
        return identificativo_richiesta_integrazione;
    }
    public void setIdentificativo_richiesta_integrazione(String identificativo_richiesta_integrazione) {
        this.identificativo_richiesta_integrazione = identificativo_richiesta_integrazione;
    }
    public String getData_azione() {
        return data_azione;
    }
    public void setData_azione(String data_azione) {
        this.data_azione = data_azione;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Integer getNumero_giorni() {
        return numero_giorni;
    }
    public void setNumero_giorni(Integer numero_giorni) {
        this.numero_giorni = numero_giorni;
    }
    
    

}
