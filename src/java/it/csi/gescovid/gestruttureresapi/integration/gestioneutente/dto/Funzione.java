/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.VisibilitaEnum;

public class Funzione {
	String funzione;
	VisibilitaEnum visibilita;
	
	public Funzione(String funzione, VisibilitaEnum visibilita) {
		super();
		this.funzione = funzione;
		this.visibilita = visibilita;
	}
	
	public String getFunzione() {
		return funzione;
	}
	public void setFunzione(String funzione) {
		this.funzione = funzione;
	}
	
	public VisibilitaEnum getVisibilita() {
		return visibilita;
	}
	public void setVisibilita(VisibilitaEnum visibilita) {
		this.visibilita = visibilita;
	}
	
	
}
