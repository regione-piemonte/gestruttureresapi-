/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per utente complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="utente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceFiscaleUtente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cognomeUtente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idUtente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeUtente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utente", propOrder = {
    "codiceFiscaleUtente",
    "cognomeUtente",
    "idUtente",
    "nomeUtente"
})
public class Utente {

    protected String codiceFiscaleUtente;
    protected String cognomeUtente;
    protected String idUtente;
    protected String nomeUtente;

    /**
     * Recupera il valore della propriet� codiceFiscaleUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleUtente() {
        return codiceFiscaleUtente;
    }

    /**
     * Imposta il valore della propriet� codiceFiscaleUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleUtente(String value) {
        this.codiceFiscaleUtente = value;
    }

    /**
     * Recupera il valore della propriet� cognomeUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognomeUtente() {
        return cognomeUtente;
    }

    /**
     * Imposta il valore della propriet� cognomeUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognomeUtente(String value) {
        this.cognomeUtente = value;
    }

    /**
     * Recupera il valore della propriet� idUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUtente() {
        return idUtente;
    }

    /**
     * Imposta il valore della propriet� idUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUtente(String value) {
        this.idUtente = value;
    }

    /**
     * Recupera il valore della propriet� nomeUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeUtente() {
        return nomeUtente;
    }

    /**
     * Imposta il valore della propriet� nomeUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeUtente(String value) {
        this.nomeUtente = value;
    }

}
