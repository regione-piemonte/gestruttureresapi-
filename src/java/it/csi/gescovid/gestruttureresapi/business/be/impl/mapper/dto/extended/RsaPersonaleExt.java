/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaPersonale;

public class RsaPersonaleExt extends RsaPersonale {

	private String tipologiaStrutturaDesc;
	private String datiValidi;
	private Integer persTipoId;
	private String persTipoCod;
	private String persTipoDesc;
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
	public Integer getPersTipoId() {
		return persTipoId;
	}
	public void setPersTipoId(Integer persTipoId) {
		this.persTipoId = persTipoId;
	}
	public String getPersTipoCod() {
		return persTipoCod;
	}
	public void setPersTipoCod(String persTipoCod) {
		this.persTipoCod = persTipoCod;
	}
	public String getPersTipoDesc() {
		return persTipoDesc;
	}
	public void setPersTipoDesc(String persTipoDesc) {
		this.persTipoDesc = persTipoDesc;
	}
	public Integer getTotale() {
		return totale;
	}
	public void setTotale(Integer totale) {
		this.totale = totale;
	}
	

	
}
