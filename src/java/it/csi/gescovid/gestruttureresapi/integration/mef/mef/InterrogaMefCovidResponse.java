/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.mef.mef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java per anonymous complex type.
 * 
 * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="InterrogaMefCovidResult" type="{http://InterrogaMefCovid.central.services.auraws.aura.csi.it}InterrogaMefCovidRes"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "interrogaMefCovidResult"
})
@XmlRootElement(name = "InterrogaMefCovidResponse")
public class InterrogaMefCovidResponse {

    @XmlElement(name = "InterrogaMefCovidResult", required = true)
    protected InterrogaMefCovidRes interrogaMefCovidResult;

    /**
     * Recupera il valore della proprieta interrogaMefCovidResult.
     * 
     * @return
     *     possible object is
     *     {@link InterrogaMefCovidRes }
     *     
     */
    public InterrogaMefCovidRes getInterrogaMefCovidResult() {
        return interrogaMefCovidResult;
    }

    /**
     * Imposta il valore della proprieta interrogaMefCovidResult.
     * 
     * @param value
     *     allowed object is
     *     {@link InterrogaMefCovidRes }
     *     
     */
    public void setInterrogaMefCovidResult(InterrogaMefCovidRes value) {
        this.interrogaMefCovidResult = value;
    }

}
