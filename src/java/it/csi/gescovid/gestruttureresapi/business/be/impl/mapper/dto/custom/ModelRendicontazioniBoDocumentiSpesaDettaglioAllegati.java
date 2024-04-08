/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

public class ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati {
    private Integer allegatoId;
    private String allegatoTipo;
    private String allegatoTipoCod;
    private String allegatoTipoDesc;
    private String allegatoFilename;
    
    public String getAllegatoTipo() {
        return allegatoTipo;
    }

    public void setAllegatoTipo(String allegatoTipo) {
        this.allegatoTipo = allegatoTipo;
    }

    public String getAllegatoTipoCod() {
        return allegatoTipoCod;
    }

    public void setAllegatoTipoCod(String allegatoTipoCod) {
        this.allegatoTipoCod = allegatoTipoCod;
    }

    public String getAllegatoTipoDesc() {
        return allegatoTipoDesc;
    }

    public void setAllegatoTipoDesc(String allegatoTipoDesc) {
        this.allegatoTipoDesc = allegatoTipoDesc;
    }

    public String getAllegatoFilename() {
        return allegatoFilename;
    }

    public void setAllegatoFilename(String allegatoFilename) {
        this.allegatoFilename = allegatoFilename;
    }

    public Integer getAllegatoId() {
        return allegatoId;
    }

    public void setAllegatoId(Integer allegatoId) {
        this.allegatoId = allegatoId;
    }



}
