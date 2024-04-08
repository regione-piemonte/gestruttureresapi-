/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

public class ModelStrutturaArpe {
    private String codStrutturaArpe;
    private String coordSrid;
    private String coordX;
    private String coordY;
    
    public String getCodStrutturaArpe() {
        return codStrutturaArpe;
    }
    public void setCodStrutturaArpe(String codStrutturaArpe) {
        this.codStrutturaArpe = codStrutturaArpe;
    }
    public String getCoordSrid() {
        return coordSrid;
    }
    public void setCoordSrid(String coordSrid) {
        this.coordSrid = coordSrid;
    }
    public String getCoordX() {
        return coordX;
    }
    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }
    public String getCoordY() {
        return coordY;
    }
    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }
    
}
