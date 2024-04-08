/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaVisitatori;

public class RsaVisitatoriExt extends RsaVisitatori {

	private String tipologiaStrutturaDesc;
	private String datiValidi;
	private String visitatoriIngressiDesc;
	
	public String getDatiValidi() {
		return datiValidi;
	}
	public void setDatiValidi(String datiValidi) {
		this.datiValidi = datiValidi;
	}
	public String getTipologiaStrutturaDesc() {
		return tipologiaStrutturaDesc;
	}
	public void setTipologiaStrutturaDesc(String tipologiaStrutturaDesc) {
		this.tipologiaStrutturaDesc = tipologiaStrutturaDesc;
	}
    public String getVisitatoriIngressiDesc() {
        return visitatoriIngressiDesc;
    }
    public void setVisitatoriIngressiDesc(String visitatoriIngressiDesc) {
        this.visitatoriIngressiDesc = visitatoriIngressiDesc;
    }

}
