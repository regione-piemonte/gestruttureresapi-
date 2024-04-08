/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.aura.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FindProfiliAnagraficiResult" type="{http://AnagrafeFind.central.services.auraws.aura.csi.it}datiAnagraficiMsg"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "findProfiliAnagraficiResult"
})
@XmlRootElement(name = "FindProfiliAnagraficiResponse")
public class FindProfiliAnagraficiResponse {

    @XmlElement(name = "FindProfiliAnagraficiResult", required = true)
    protected DatiAnagraficiMsg findProfiliAnagraficiResult;

    /**
     * Recupera il valore della propriet� findProfiliAnagraficiResult.
     * 
     * @return
     *     possible object is
     *     {@link DatiAnagraficiMsg }
     *     
     */
    public DatiAnagraficiMsg getFindProfiliAnagraficiResult() {
        return findProfiliAnagraficiResult;
    }

    /**
     * Imposta il valore della propriet� findProfiliAnagraficiResult.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiAnagraficiMsg }
     *     
     */
    public void setFindProfiliAnagraficiResult(DatiAnagraficiMsg value) {
        this.findProfiliAnagraficiResult = value;
    }

}
