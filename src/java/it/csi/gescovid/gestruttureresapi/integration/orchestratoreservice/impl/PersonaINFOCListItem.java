/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per personaINFOCListItem complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="personaINFOCListItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}persona">
 *       &lt;sequence>
 *         &lt;element name="ragSocSP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruoloRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personaINFOCListItem", propOrder = {
    "ragSocSP",
    "ruoloRL"
})
public class PersonaINFOCListItem
    extends Persona
{

    protected String ragSocSP;
    protected String ruoloRL;

    /**
     * Recupera il valore della propriet� ragSocSP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRagSocSP() {
        return ragSocSP;
    }

    /**
     * Imposta il valore della propriet� ragSocSP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRagSocSP(String value) {
        this.ragSocSP = value;
    }

    /**
     * Recupera il valore della propriet� ruoloRL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuoloRL() {
        return ruoloRL;
    }

    /**
     * Imposta il valore della propriet� ruoloRL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuoloRL(String value) {
        this.ruoloRL = value;
    }

}
