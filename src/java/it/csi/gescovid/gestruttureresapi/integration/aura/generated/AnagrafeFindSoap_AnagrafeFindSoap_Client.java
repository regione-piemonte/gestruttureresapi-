/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.aura.generated;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2023-02-09T14:26:42.008+01:00
 * Generated source version: 2.7.7
 * 
 */
public final class AnagrafeFindSoap_AnagrafeFindSoap_Client {

    private static final QName SERVICE_NAME = new QName("http://AnagrafeFind.central.services.auraws.aura.csi.it", "AnagrafeFind");

    private AnagrafeFindSoap_AnagrafeFindSoap_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = AnagrafeFind.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        AnagrafeFind ss = new AnagrafeFind(wsdlURL, SERVICE_NAME);
        AnagrafeFindSoap port = ss.getAnagrafeFindSoap();  
        
        {
        System.out.println("Invoking findProfiliAnagrafici...");
        it.csi.gescovid.gestruttureresapi.integration.aura.generated.FindProfiliAnagraficiRequest _findProfiliAnagrafici_profiliRequest = null;
        it.csi.gescovid.gestruttureresapi.integration.aura.generated.DatiAnagraficiMsg _findProfiliAnagrafici__return = port.findProfiliAnagrafici(_findProfiliAnagrafici_profiliRequest);
        System.out.println("findProfiliAnagrafici.result=" + _findProfiliAnagrafici__return);


        }

        System.exit(0);
    }

}