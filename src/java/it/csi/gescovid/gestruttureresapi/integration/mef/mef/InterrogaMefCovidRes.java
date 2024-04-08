/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.mef.mef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java per InterrogaMefCovidRes complex type.
 * 
 * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="InterrogaMefCovidRes"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="esitomef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="body" type="{http://InterrogaMefCovid.central.services.auraws.aura.csi.it}InterrogaMefCovidResponseBody" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterrogaMefCovidRes", propOrder = {
    "errorCode",
    "esitomef",
    "body"
})
public class InterrogaMefCovidRes {

    protected String errorCode;
    protected String esitomef;
    protected InterrogaMefCovidResponseBody body;

    /**
     * Recupera il valore della proprieta errorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Imposta il valore della proprieta errorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Recupera il valore della proprieta esitomef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitomef() {
        return esitomef;
    }

    /**
     * Imposta il valore della proprieta esitomef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitomef(String value) {
        this.esitomef = value;
    }

    /**
     * Recupera il valore della proprieta body.
     * 
     * @return
     *     possible object is
     *     {@link InterrogaMefCovidResponseBody }
     *     
     */
    public InterrogaMefCovidResponseBody getBody() {
        return body;
    }

    /**
     * Imposta il valore della proprieta body.
     * 
     * @param value
     *     allowed object is
     *     {@link InterrogaMefCovidResponseBody }
     *     
     */
    public void setBody(InterrogaMefCovidResponseBody value) {
        this.body = value;
    }

}
