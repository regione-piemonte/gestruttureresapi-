/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator;

public interface BaseUtenteOperazioneInterface {

	String getWebappOperazione();

	String getRuoloOperazione();

	String getUtenteOperazione();

	Integer getIdEnteOperazione();

	String getIdStrutturaOperazione();

	Integer getIdAreaOperazione();

}