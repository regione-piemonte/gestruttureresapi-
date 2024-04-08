/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto.custom;

public class DocumentiEsitoAcquisizione {
    private String id_documento_buonodom;
    private String id_documento_bandi;
    public String getId_documento_buonodom() {
        return id_documento_buonodom;
    }
    public void setId_documento_buonodom(String id_documento_buonodom) {
        this.id_documento_buonodom = id_documento_buonodom;
    }
    public String getId_documento_bandi() {
        return id_documento_bandi;
    }
    public void setId_documento_bandi(String id_documento_bandi) {
        this.id_documento_bandi = id_documento_bandi;
    }
}
