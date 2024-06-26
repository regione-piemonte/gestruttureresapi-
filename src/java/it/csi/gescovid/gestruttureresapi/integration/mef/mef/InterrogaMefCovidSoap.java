/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.mef.mef;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.3
 * 2021-06-10T10:56:57.734+02:00
 * Generated source version: 3.4.3
 *
 */
@WebService(targetNamespace = "http://InterrogaMefCovid.central.services.auraws.aura.csi.it", name = "InterrogaMefCovidSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface InterrogaMefCovidSoap {

    @WebMethod(operationName = "InterrogaMefCovid", action = "http://InterrogaMefCovid.central.services.auraws.aura.csi.it/AURA.WS.InterrogaMefCovid.InterrogaMefCovid")
    @RequestWrapper(localName = "InterrogaMefCovid", targetNamespace = "http://InterrogaMefCovid.central.services.auraws.aura.csi.it", className = "it.csi.padvax.preadesioniapi.integration.mef.InterrogaMefCovid")
    @ResponseWrapper(localName = "InterrogaMefCovidResponse", targetNamespace = "http://InterrogaMefCovid.central.services.auraws.aura.csi.it", className = "it.csi.padvax.preadesioniapi.integration.mef.InterrogaMefCovidResponse")
    @WebResult(name = "InterrogaMefCovidResult", targetNamespace = "http://InterrogaMefCovid.central.services.auraws.aura.csi.it")
    public it.csi.gescovid.gestruttureresapi.integration.mef.mef.InterrogaMefCovidRes interrogaMefCovid(

        @WebParam(name = "CF", targetNamespace = "http://InterrogaMefCovid.central.services.auraws.aura.csi.it")
        java.lang.String cf
    );
}
