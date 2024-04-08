/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaTamponi;

public class RsaTamponiExt extends RsaTamponi {
	
	private String tipologiaStrutturaDesc;
	private String datiValidi;
	private String categoriaTampCod;
	private String categoriaTampDesc;
	private Integer totale;
    private String strTipoTamponeCod;
    private String strTipoTamponeDesc;
	
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
	public String getCategoriaTampCod() {
		return categoriaTampCod;
	}
	public void setCategoriaTampCod(String categoriaTampCod) {
		this.categoriaTampCod = categoriaTampCod;
	}
	public String getCategoriaTampDesc() {
		return categoriaTampDesc;
	}
	public void setCategoriaTampDesc(String categoriaTampDesc) {
		this.categoriaTampDesc = categoriaTampDesc;
	}
	public Integer getTotale() {
		return totale;
	}
	public void setTotale(Integer totale) {
		this.totale = totale;
	}
    public String getStrTipoTamponeDesc() {
        return strTipoTamponeDesc;
    }
    public void setStrTipoTamponeDesc(String strTipoTamponeDesc) {
        this.strTipoTamponeDesc = strTipoTamponeDesc;
    }
    public String getStrTipoTamponeCod() {
        return strTipoTamponeCod;
    }
    public void setStrTipoTamponeCod(String strTipoTamponeCod) {
        this.strTipoTamponeCod = strTipoTamponeCod;
    }
	


}
