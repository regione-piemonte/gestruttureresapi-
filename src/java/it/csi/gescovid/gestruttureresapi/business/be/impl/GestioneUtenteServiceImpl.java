/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.CurrentOperatorTypeEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.GestioneUtenteInteface;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.GestioneUtenteInteface.ProfiloTypeEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.GestioneUtenteInteface.UserTypeEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.VisibilitaEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Funzione;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelUtenteContatto;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator.CurrentOperator;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.operator.CurrentOperatorCodProfilo;

public abstract class GestioneUtenteServiceImpl extends RESTBaseService {

    @Autowired
    protected GestioneUtenteInteface gestioneUtenteClient;

    protected Funzione funcLettura(FunzioneEnum funzioneEnum) {
        return new Funzione(funzioneEnum.getCode(), VisibilitaEnum.LETTURA);
    }

    protected Funzione funcScrittura(FunzioneEnum funzioneEnum) {
        return new Funzione(funzioneEnum.getCode(), VisibilitaEnum.SCRITTURA);
    }

    protected void verifyCurrentUserValidate(String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, Funzione function, HttpHeaders httpHeaders) {
        if (webappOperazione.equals("BO_BUONORES")) {
            //chiamata per servizi esterni
            gestioneUtenteClient.verifyCurrentUser(
                    new CurrentOperatorCodProfilo(webappOperazione, ProfiloTypeEnum.BUONO_RES, ruoloOperazione,
                            utenteOperazione,
                            idEnteOperazione, idStrutturaOperazione, idAreaOperazione),
                    CurrentOperatorTypeEnum.UTENTE_OPERAZIONE, UserTypeEnum.VALIDATE, function,
                    httpHeaders.getRequestHeaders());
        } else {
            gestioneUtenteClient.verifyCurrentUser(
                    new CurrentOperator(webappOperazione, idProfiloOperazione, ruoloOperazione, utenteOperazione,
                            idEnteOperazione, idStrutturaOperazione, idAreaOperazione),
                    CurrentOperatorTypeEnum.UTENTE_OPERAZIONE, UserTypeEnum.VALIDATE, function,
                    httpHeaders.getRequestHeaders());
        }
    }

    protected ModelUtenteContatto verifyCurrentUserGetUtenteContatto(String webappOperazione,
            Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, Funzione function, HttpHeaders httpHeaders) {
        return gestioneUtenteClient.verifyCurrentUser(
                new CurrentOperator(webappOperazione, idProfiloOperazione, ruoloOperazione, utenteOperazione,
                        idEnteOperazione, idStrutturaOperazione, idAreaOperazione),
                CurrentOperatorTypeEnum.UTENTE_OPERAZIONE, UserTypeEnum.UTENTE_CONTATTO, function,
                httpHeaders.getRequestHeaders());
    }
}