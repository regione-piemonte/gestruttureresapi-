/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface;

public interface UtenteRefertanteInterface {

	Integer getIdProfiloRefertante();
	
	String getWebappRefertante();

	String getRuoloRefertante();

	String getUtenteRefertante();

	Integer getIdEnteRefertante();

	String getIdStrutturaRefertante();

	Integer getIdAreaRefertante();

}