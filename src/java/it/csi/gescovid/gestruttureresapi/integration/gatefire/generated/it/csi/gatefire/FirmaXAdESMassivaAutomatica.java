/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per firmaXAdESMassivaAutomatica complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="firmaXAdESMassivaAutomatica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attachment" type="{http://www.csi.it/gatefire/}attachment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="xadesInput" type="{http://www.csi.it/gatefire/}xadesInput" minOccurs="0"/>
 *         &lt;element name="identity" type="{http://www.csi.it/gatefire/}autoSignIdentity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firmaXAdESMassivaAutomatica", propOrder = {
    "attachment",
    "xadesInput",
    "identity"
})
public class FirmaXAdESMassivaAutomatica {

    protected List<Attachment> attachment;
    protected XadesInput xadesInput;
    protected AutoSignIdentity identity;

    /**
     * Gets the value of the attachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getAttachment() {
        if (attachment == null) {
            attachment = new ArrayList<Attachment>();
        }
        return this.attachment;
    }

    /**
     * Recupera il valore della propriet� xadesInput.
     * 
     * @return
     *     possible object is
     *     {@link XadesInput }
     *     
     */
    public XadesInput getXadesInput() {
        return xadesInput;
    }

    /**
     * Imposta il valore della propriet� xadesInput.
     * 
     * @param value
     *     allowed object is
     *     {@link XadesInput }
     *     
     */
    public void setXadesInput(XadesInput value) {
        this.xadesInput = value;
    }

    /**
     * Recupera il valore della propriet� identity.
     * 
     * @return
     *     possible object is
     *     {@link AutoSignIdentity }
     *     
     */
    public AutoSignIdentity getIdentity() {
        return identity;
    }

    /**
     * Imposta il valore della propriet� identity.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoSignIdentity }
     *     
     */
    public void setIdentity(AutoSignIdentity value) {
        this.identity = value;
    }

}
