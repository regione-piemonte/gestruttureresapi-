/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per repositoryDocIdInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="repositoryDocIdInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="docUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "repositoryDocIdInput", propOrder = {
    "docUid"
})
public class RepositoryDocIdInput {

    protected String docUid;

    /**
     * Recupera il valore della propriet� docUid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocUid() {
        return docUid;
    }

    /**
     * Imposta il valore della propriet� docUid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocUid(String value) {
        this.docUid = value;
    }

}
