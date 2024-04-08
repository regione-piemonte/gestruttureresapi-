/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

import java.util.List;

public class ValidazioneDichiarazione {
    private String id_dichiarazione_spesa_bandi;
    private List<Mensilitum> mensilita;

    public List<Mensilitum> getMensilita() {
        return mensilita;
    }

    public void setMensilita(List<Mensilitum> mensilita) {
        this.mensilita = mensilita;
    }

    public String getId_dichiarazione_spesa_bandi() {
        return id_dichiarazione_spesa_bandi;
    }

    public void setId_dichiarazione_spesa_bandi(String id_dichiarazione_spesa_bandi) {
        this.id_dichiarazione_spesa_bandi = id_dichiarazione_spesa_bandi;
    }

}
