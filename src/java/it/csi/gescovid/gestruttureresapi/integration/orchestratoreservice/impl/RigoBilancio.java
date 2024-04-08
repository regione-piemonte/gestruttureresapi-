/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per rigoBilancio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="rigoBilancio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoPrecedente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="livelloIndentazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoRigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rigoBilancio", propOrder = {
    "annoAttuale",
    "annoPrecedente",
    "livelloIndentazione",
    "tipoRigo",
    "voce"
})
public class RigoBilancio {

    protected String annoAttuale;
    protected String annoPrecedente;
    protected String livelloIndentazione;
    protected String tipoRigo;
    protected String voce;

    /**
     * Recupera il valore della propriet� annoAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoAttuale() {
        return annoAttuale;
    }

    /**
     * Imposta il valore della propriet� annoAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoAttuale(String value) {
        this.annoAttuale = value;
    }

    /**
     * Recupera il valore della propriet� annoPrecedente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoPrecedente() {
        return annoPrecedente;
    }

    /**
     * Imposta il valore della propriet� annoPrecedente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoPrecedente(String value) {
        this.annoPrecedente = value;
    }

    /**
     * Recupera il valore della propriet� livelloIndentazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLivelloIndentazione() {
        return livelloIndentazione;
    }

    /**
     * Imposta il valore della propriet� livelloIndentazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLivelloIndentazione(String value) {
        this.livelloIndentazione = value;
    }

    /**
     * Recupera il valore della propriet� tipoRigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRigo() {
        return tipoRigo;
    }

    /**
     * Imposta il valore della propriet� tipoRigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRigo(String value) {
        this.tipoRigo = value;
    }

    /**
     * Recupera il valore della propriet� voce.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoce() {
        return voce;
    }

    /**
     * Imposta il valore della propriet� voce.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoce(String value) {
        this.voce = value;
    }

}
