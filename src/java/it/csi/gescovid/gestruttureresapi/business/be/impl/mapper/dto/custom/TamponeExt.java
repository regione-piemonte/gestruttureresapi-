/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Tampone;

public class TamponeExt extends Tampone {
	
	private String risultatoTampone;

	public String getRisultatoTampone() {
		return risultatoTampone;
	}

	public void setRisultatoTampone(String risultatoTampone) {
		this.risultatoTampone = risultatoTampone;
	}
	
	

}
