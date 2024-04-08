/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per openSession complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="openSession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionInput" type="{http://www.csi.it/gatefire/}sessionInput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "openSession", propOrder = {
    "sessionInput"
})
public class OpenSession {

    protected SessionInput sessionInput;

    /**
     * Recupera il valore della propriet� sessionInput.
     * 
     * @return
     *     possible object is
     *     {@link SessionInput }
     *     
     */
    public SessionInput getSessionInput() {
        return sessionInput;
    }

    /**
     * Imposta il valore della propriet� sessionInput.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionInput }
     *     
     */
    public void setSessionInput(SessionInput value) {
        this.sessionInput = value;
    }

}
