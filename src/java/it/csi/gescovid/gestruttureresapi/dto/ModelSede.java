/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ModelSede extends AbstractDto {
    private String descrTipoSede;
    private String codISTATComune;
    private String descrComune;
    private String indirizzo;
    private String siglaProvincia;
    public String getDescrTipoSede() {
        return descrTipoSede;
    }
    public void setDescrTipoSede(String descrTipoSede) {
        this.descrTipoSede = descrTipoSede;
    }
    public String getCodISTATComune() {
        return codISTATComune;
    }
    public void setCodISTATComune(String codISTATComune) {
        this.codISTATComune = codISTATComune;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public String getSiglaProvincia() {
        return siglaProvincia;
    }
    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }
    public String getDescrComune() {
        return descrComune;
    }
    public void setDescrComune(String descrComune) {
        this.descrComune = descrComune;
    }
}
