/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaPosti;

public class RsaPostiExt extends RsaPosti {
	
	private String tipologiaStrutturaDesc;
	private String datiValidi;
	private Integer totale;
	
	public String getTipologiaStrutturaDesc() {
		return tipologiaStrutturaDesc;
	}
	public void setTipologiaStrutturaDesc(String tipologiaStrutturaDesc) {
		this.tipologiaStrutturaDesc = tipologiaStrutturaDesc;
	}
	public String getDatiValidi() {
		return datiValidi;
	}
	public void setDatiValidi(String datiValidi) {
		this.datiValidi = datiValidi;
	}
	public Integer getTotale() {
		return totale;
	}
	public void setTotale(Integer totale) {
		this.totale = totale;
	}
	
	

}
