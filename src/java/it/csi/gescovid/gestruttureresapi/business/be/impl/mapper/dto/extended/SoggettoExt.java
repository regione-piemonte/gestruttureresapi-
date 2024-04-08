/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.Date;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Comuni;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.util.genericinterface.ListInterface;

public class SoggettoExt  extends Soggetto implements ListInterface{
	
	private Boolean flgOspite;
    private Long totalCount;
    private Date presenzaInizio;
    private Date presenzaFine;
    private Comuni comuneResidenza;
    private Comuni comuneDomicilio;
    private Date dataDimissioniDefinitiva;

	public Boolean getFlgOspite() {
		return flgOspite;
	}

	public void setFlgOspite(Boolean flgOspite) {
		this.flgOspite = flgOspite;
	}

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Date getPresenzaInizio() {
        return presenzaInizio;
    }

    public void setPresenzaInizio(Date presenzaInizio) {
        this.presenzaInizio = presenzaInizio;
    }

    public Date getPresenzaFine() {
        return presenzaFine;
    }

    public void setPresenzaFine(Date presenzaFine) {
        this.presenzaFine = presenzaFine;
    }

    public Comuni getComuneResidenza() {
        return comuneResidenza;
    }

    public void setComuneResidenza(Comuni comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }

    public Comuni getComuneDomicilio() {
        return comuneDomicilio;
    }

    public void setComuneDomicilio(Comuni comuneDomicilio) {
        this.comuneDomicilio = comuneDomicilio;
    }

    public Date getDataDimissioniDefinitiva() {
        return dataDimissioniDefinitiva;
    }

    public void setDataDimissioniDefinitiva(Date dataDimissioniDefinitiva) {
        this.dataDimissioniDefinitiva = dataDimissioniDefinitiva;
    }
}
