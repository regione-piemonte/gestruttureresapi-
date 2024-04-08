/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Decorso;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Sintomo;

public class DecorsoSintomo extends Decorso {
	
	private Sintomo sintomo;

	public Sintomo getSintomo() {
		return sintomo;
	}

	public void setSintomo(Sintomo sintomo) {
		this.sintomo = sintomo;
	}
	

	
}
