/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.StrutturaCategoria;

public class StrutturaCategoriaInfo extends StrutturaCategoria {

	private Boolean esisteUltimaRilevazione;
	private Integer postiAutorizzati;

	public Integer getPostiAutorizzati() {
		return postiAutorizzati;
	}

	public void setPostiAutorizzati(Integer postiAutorizzati) {
		this.postiAutorizzati = postiAutorizzati;
	}

	public Boolean getEsisteUltimaRilevazione() {
		return esisteUltimaRilevazione;
	}

	public void setEsisteUltimaRilevazione(Boolean esisteUltimaRilevazione) {
		this.esisteUltimaRilevazione = esisteUltimaRilevazione;
	}
	
}
