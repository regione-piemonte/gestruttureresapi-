/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per sedeFP complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="sedeFP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}sede">
 *       &lt;sequence>
 *         &lt;element name="annoSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corsi" type="{http://business.aaeporch.aaep.csi.it/}corso" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="indirizzoAlternativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaSindacato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitaOperativa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sedeFP", propOrder = {
    "annoSettore",
    "corsi",
    "indirizzoAlternativo",
    "siglaSindacato",
    "unitaOperativa"
})
public class SedeFP
    extends Sede
{

    protected String annoSettore;
    @XmlElement(nillable = true)
    protected List<Corso> corsi;
    protected String indirizzoAlternativo;
    protected String siglaSindacato;
    protected String unitaOperativa;

    /**
     * Recupera il valore della propriet� annoSettore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoSettore() {
        return annoSettore;
    }

    /**
     * Imposta il valore della propriet� annoSettore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoSettore(String value) {
        this.annoSettore = value;
    }

    /**
     * Gets the value of the corsi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the corsi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorsi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Corso }
     * 
     * 
     */
    public List<Corso> getCorsi() {
        if (corsi == null) {
            corsi = new ArrayList<Corso>();
        }
        return this.corsi;
    }

    /**
     * Recupera il valore della propriet� indirizzoAlternativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzoAlternativo() {
        return indirizzoAlternativo;
    }

    /**
     * Imposta il valore della propriet� indirizzoAlternativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzoAlternativo(String value) {
        this.indirizzoAlternativo = value;
    }

    /**
     * Recupera il valore della propriet� siglaSindacato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaSindacato() {
        return siglaSindacato;
    }

    /**
     * Imposta il valore della propriet� siglaSindacato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaSindacato(String value) {
        this.siglaSindacato = value;
    }

    /**
     * Recupera il valore della propriet� unitaOperativa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaOperativa() {
        return unitaOperativa;
    }

    /**
     * Imposta il valore della propriet� unitaOperativa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaOperativa(String value) {
        this.unitaOperativa = value;
    }

}
