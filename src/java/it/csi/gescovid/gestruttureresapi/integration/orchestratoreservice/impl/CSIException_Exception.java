/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.7
 * 2023-02-08T11:57:16.289+01:00
 * Generated source version: 2.7.7
 */

@WebFault(name = "CSIException", targetNamespace = "http://business.aaeporch.aaep.csi.it/")
public class CSIException_Exception extends Exception {
    
    private it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CSIException csiException;

    public CSIException_Exception() {
        super();
    }
    
    public CSIException_Exception(String message) {
        super(message);
    }
    
    public CSIException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public CSIException_Exception(String message, it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CSIException csiException) {
        super(message);
        this.csiException = csiException;
    }

    public CSIException_Exception(String message, it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CSIException csiException, Throwable cause) {
        super(message, cause);
        this.csiException = csiException;
    }

    public it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.CSIException getFaultInfo() {
        return this.csiException;
    }
}