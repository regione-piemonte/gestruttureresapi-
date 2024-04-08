/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.7
 * 2023-02-08T11:57:16.295+01:00
 * Generated source version: 2.7.7
 */

@WebFault(name = "SystemException", targetNamespace = "http://business.aaeporch.aaep.csi.it/")
public class SystemException_Exception extends Exception {
    
    private it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.SystemException systemException;

    public SystemException_Exception() {
        super();
    }
    
    public SystemException_Exception(String message) {
        super(message);
    }
    
    public SystemException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException_Exception(String message, it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.SystemException systemException) {
        super(message);
        this.systemException = systemException;
    }

    public SystemException_Exception(String message, it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.SystemException systemException, Throwable cause) {
        super(message, cause);
        this.systemException = systemException;
    }

    public it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl.SystemException getFaultInfo() {
        return this.systemException;
    }
}