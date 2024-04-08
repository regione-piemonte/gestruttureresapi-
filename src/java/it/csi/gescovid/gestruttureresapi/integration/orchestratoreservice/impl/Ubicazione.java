/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ubicazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ubicazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="altreIndicazioni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCatastale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codISTATComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codQuartiere" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordinataX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordinataY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizioneEstesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geometriaGJSON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeNazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroCivico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toponimo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ubicazione", propOrder = {
    "altreIndicazioni",
    "cap",
    "codCatastale",
    "codISTATComune",
    "codNazione",
    "codQuartiere",
    "coordinataX",
    "coordinataY",
    "descrComune",
    "descrizioneEstesa",
    "geometriaGJSON",
    "indirizzo",
    "nomeNazione",
    "numeroCivico",
    "siglaProvincia",
    "toponimo"
})
public class Ubicazione {

    protected String altreIndicazioni;
    protected String cap;
    protected String codCatastale;
    protected String codISTATComune;
    protected String codNazione;
    protected String codQuartiere;
    protected String coordinataX;
    protected String coordinataY;
    protected String descrComune;
    protected String descrizioneEstesa;
    protected String geometriaGJSON;
    protected String indirizzo;
    protected String nomeNazione;
    protected String numeroCivico;
    protected String siglaProvincia;
    protected String toponimo;

    /**
     * Recupera il valore della propriet� altreIndicazioni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAltreIndicazioni() {
        return altreIndicazioni;
    }

    /**
     * Imposta il valore della propriet� altreIndicazioni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAltreIndicazioni(String value) {
        this.altreIndicazioni = value;
    }

    /**
     * Recupera il valore della propriet� cap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il valore della propriet� cap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCap(String value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della propriet� codCatastale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCatastale() {
        return codCatastale;
    }

    /**
     * Imposta il valore della propriet� codCatastale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCatastale(String value) {
        this.codCatastale = value;
    }

    /**
     * Recupera il valore della propriet� codISTATComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodISTATComune() {
        return codISTATComune;
    }

    /**
     * Imposta il valore della propriet� codISTATComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodISTATComune(String value) {
        this.codISTATComune = value;
    }

    /**
     * Recupera il valore della propriet� codNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNazione() {
        return codNazione;
    }

    /**
     * Imposta il valore della propriet� codNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNazione(String value) {
        this.codNazione = value;
    }

    /**
     * Recupera il valore della propriet� codQuartiere.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodQuartiere() {
        return codQuartiere;
    }

    /**
     * Imposta il valore della propriet� codQuartiere.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodQuartiere(String value) {
        this.codQuartiere = value;
    }

    /**
     * Recupera il valore della propriet� coordinataX.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinataX() {
        return coordinataX;
    }

    /**
     * Imposta il valore della propriet� coordinataX.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinataX(String value) {
        this.coordinataX = value;
    }

    /**
     * Recupera il valore della propriet� coordinataY.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinataY() {
        return coordinataY;
    }

    /**
     * Imposta il valore della propriet� coordinataY.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinataY(String value) {
        this.coordinataY = value;
    }

    /**
     * Recupera il valore della propriet� descrComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrComune() {
        return descrComune;
    }

    /**
     * Imposta il valore della propriet� descrComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrComune(String value) {
        this.descrComune = value;
    }

    /**
     * Recupera il valore della propriet� descrizioneEstesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneEstesa() {
        return descrizioneEstesa;
    }

    /**
     * Imposta il valore della propriet� descrizioneEstesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneEstesa(String value) {
        this.descrizioneEstesa = value;
    }

    /**
     * Recupera il valore della propriet� geometriaGJSON.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeometriaGJSON() {
        return geometriaGJSON;
    }

    /**
     * Imposta il valore della propriet� geometriaGJSON.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeometriaGJSON(String value) {
        this.geometriaGJSON = value;
    }

    /**
     * Recupera il valore della propriet� indirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Imposta il valore della propriet� indirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzo(String value) {
        this.indirizzo = value;
    }

    /**
     * Recupera il valore della propriet� nomeNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeNazione() {
        return nomeNazione;
    }

    /**
     * Imposta il valore della propriet� nomeNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeNazione(String value) {
        this.nomeNazione = value;
    }

    /**
     * Recupera il valore della propriet� numeroCivico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCivico() {
        return numeroCivico;
    }

    /**
     * Imposta il valore della propriet� numeroCivico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCivico(String value) {
        this.numeroCivico = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    /**
     * Imposta il valore della propriet� siglaProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvincia(String value) {
        this.siglaProvincia = value;
    }

    /**
     * Recupera il valore della propriet� toponimo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToponimo() {
        return toponimo;
    }

    /**
     * Imposta il valore della propriet� toponimo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToponimo(String value) {
        this.toponimo = value;
    }

}
