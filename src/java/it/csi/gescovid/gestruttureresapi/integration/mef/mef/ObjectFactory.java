/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.mef.mef;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.csi.padvax.preadesioniapi.integration.mef package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.csi.padvax.preadesioniapi.integration.mef
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InterrogaMefCovid }
     * 
     */
    public InterrogaMefCovid createInterrogaMefCovid() {
        return new InterrogaMefCovid();
    }

    /**
     * Create an instance of {@link InterrogaMefCovidResponse }
     * 
     */
    public InterrogaMefCovidResponse createInterrogaMefCovidResponse() {
        return new InterrogaMefCovidResponse();
    }

    /**
     * Create an instance of {@link InterrogaMefCovidRes }
     * 
     */
    public InterrogaMefCovidRes createInterrogaMefCovidRes() {
        return new InterrogaMefCovidRes();
    }

    /**
     * Create an instance of {@link InterrogaMefCovidResponseBody }
     * 
     */
    public InterrogaMefCovidResponseBody createInterrogaMefCovidResponseBody() {
        return new InterrogaMefCovidResponseBody();
    }

}
