/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per regione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="regione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codIstat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nazione" type="{http://business.aaeporch.aaep.csi.it/}nazione" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regione", propOrder = {
    "codIstat",
    "descrizione",
    "nazione"
})
public class Regione {

    protected String codIstat;
    protected String descrizione;
    protected Nazione nazione;

    /**
     * Recupera il valore della propriet� codIstat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodIstat() {
        return codIstat;
    }

    /**
     * Imposta il valore della propriet� codIstat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodIstat(String value) {
        this.codIstat = value;
    }

    /**
     * Recupera il valore della propriet� descrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta il valore della propriet� descrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizione(String value) {
        this.descrizione = value;
    }

    /**
     * Recupera il valore della propriet� nazione.
     * 
     * @return
     *     possible object is
     *     {@link Nazione }
     *     
     */
    public Nazione getNazione() {
        return nazione;
    }

    /**
     * Imposta il valore della propriet� nazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Nazione }
     *     
     */
    public void setNazione(Nazione value) {
        this.nazione = value;
    }

}
