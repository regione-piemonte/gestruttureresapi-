/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface;

public interface UtenteRichiedenteInterface {

	Integer getIdProfiloRichiedente();
	
	String getWebappRichiedente();

	String getRuoloRichiedente();

	String getUtenteRichiedente();

	Integer getIdEnteRichiedente();

	String getIdStrutturaRichiedente();

	Integer getIdAreaRichiedente();

}