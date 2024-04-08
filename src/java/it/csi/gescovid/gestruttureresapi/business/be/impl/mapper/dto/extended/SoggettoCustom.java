/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;

public class SoggettoCustom  extends Soggetto{
	
	private Boolean flgOspite;

	public Boolean getFlgOspite() {
		return flgOspite;
	}

	public void setFlgOspite(Boolean flgOspite) {
		this.flgOspite = flgOspite;
	}
}
