/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.operatorinterface;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator.BaseUtenteOperazioneInterface;

public interface UtenteOperazioneCodProfiloInterface extends BaseUtenteOperazioneInterface {

	String getCodProfiloOperazione();

}