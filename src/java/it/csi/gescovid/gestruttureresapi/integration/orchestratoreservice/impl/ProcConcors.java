/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per procConcors complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="procConcors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codLiquidazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAperturaProc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataChiusuraLiquidaz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataEsecConcordPrevent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineLiquidaz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRegistroAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRevocalLiquidaz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descIndicatEsecutAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrAltreIndicazioni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCodAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrNotaio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrTribunale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAAEPAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAAEPFonteDato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localRegistroAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numRestistrAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrLiquidazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvRegAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procConcors", propOrder = {
    "codAtto",
    "codLiquidazione",
    "dataAperturaProc",
    "dataChiusuraLiquidaz",
    "dataEsecConcordPrevent",
    "dataFineLiquidaz",
    "dataRegistroAtto",
    "dataRevocalLiquidaz",
    "descIndicatEsecutAtto",
    "descrAltreIndicazioni",
    "descrCodAtto",
    "descrNotaio",
    "descrTribunale",
    "idAAEPAzienda",
    "idAAEPFonteDato",
    "localRegistroAtto",
    "numRestistrAtto",
    "progrLiquidazione",
    "siglaProvRegAtto"
})
public class ProcConcors {

    protected String codAtto;
    protected String codLiquidazione;
    protected String dataAperturaProc;
    protected String dataChiusuraLiquidaz;
    protected String dataEsecConcordPrevent;
    protected String dataFineLiquidaz;
    protected String dataRegistroAtto;
    protected String dataRevocalLiquidaz;
    protected String descIndicatEsecutAtto;
    protected String descrAltreIndicazioni;
    protected String descrCodAtto;
    protected String descrNotaio;
    protected String descrTribunale;
    protected String idAAEPAzienda;
    protected String idAAEPFonteDato;
    protected String localRegistroAtto;
    protected String numRestistrAtto;
    protected String progrLiquidazione;
    protected String siglaProvRegAtto;

    /**
     * Recupera il valore della propriet� codAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAtto() {
        return codAtto;
    }

    /**
     * Imposta il valore della propriet� codAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAtto(String value) {
        this.codAtto = value;
    }

    /**
     * Recupera il valore della propriet� codLiquidazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLiquidazione() {
        return codLiquidazione;
    }

    /**
     * Imposta il valore della propriet� codLiquidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLiquidazione(String value) {
        this.codLiquidazione = value;
    }

    /**
     * Recupera il valore della propriet� dataAperturaProc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAperturaProc() {
        return dataAperturaProc;
    }

    /**
     * Imposta il valore della propriet� dataAperturaProc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAperturaProc(String value) {
        this.dataAperturaProc = value;
    }

    /**
     * Recupera il valore della propriet� dataChiusuraLiquidaz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataChiusuraLiquidaz() {
        return dataChiusuraLiquidaz;
    }

    /**
     * Imposta il valore della propriet� dataChiusuraLiquidaz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataChiusuraLiquidaz(String value) {
        this.dataChiusuraLiquidaz = value;
    }

    /**
     * Recupera il valore della propriet� dataEsecConcordPrevent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEsecConcordPrevent() {
        return dataEsecConcordPrevent;
    }

    /**
     * Imposta il valore della propriet� dataEsecConcordPrevent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEsecConcordPrevent(String value) {
        this.dataEsecConcordPrevent = value;
    }

    /**
     * Recupera il valore della propriet� dataFineLiquidaz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineLiquidaz() {
        return dataFineLiquidaz;
    }

    /**
     * Imposta il valore della propriet� dataFineLiquidaz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineLiquidaz(String value) {
        this.dataFineLiquidaz = value;
    }

    /**
     * Recupera il valore della propriet� dataRegistroAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRegistroAtto() {
        return dataRegistroAtto;
    }

    /**
     * Imposta il valore della propriet� dataRegistroAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRegistroAtto(String value) {
        this.dataRegistroAtto = value;
    }

    /**
     * Recupera il valore della propriet� dataRevocalLiquidaz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRevocalLiquidaz() {
        return dataRevocalLiquidaz;
    }

    /**
     * Imposta il valore della propriet� dataRevocalLiquidaz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRevocalLiquidaz(String value) {
        this.dataRevocalLiquidaz = value;
    }

    /**
     * Recupera il valore della propriet� descIndicatEsecutAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescIndicatEsecutAtto() {
        return descIndicatEsecutAtto;
    }

    /**
     * Imposta il valore della propriet� descIndicatEsecutAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescIndicatEsecutAtto(String value) {
        this.descIndicatEsecutAtto = value;
    }

    /**
     * Recupera il valore della propriet� descrAltreIndicazioni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrAltreIndicazioni() {
        return descrAltreIndicazioni;
    }

    /**
     * Imposta il valore della propriet� descrAltreIndicazioni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrAltreIndicazioni(String value) {
        this.descrAltreIndicazioni = value;
    }

    /**
     * Recupera il valore della propriet� descrCodAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCodAtto() {
        return descrCodAtto;
    }

    /**
     * Imposta il valore della propriet� descrCodAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCodAtto(String value) {
        this.descrCodAtto = value;
    }

    /**
     * Recupera il valore della propriet� descrNotaio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrNotaio() {
        return descrNotaio;
    }

    /**
     * Imposta il valore della propriet� descrNotaio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrNotaio(String value) {
        this.descrNotaio = value;
    }

    /**
     * Recupera il valore della propriet� descrTribunale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTribunale() {
        return descrTribunale;
    }

    /**
     * Imposta il valore della propriet� descrTribunale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTribunale(String value) {
        this.descrTribunale = value;
    }

    /**
     * Recupera il valore della propriet� idAAEPAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAAEPAzienda() {
        return idAAEPAzienda;
    }

    /**
     * Imposta il valore della propriet� idAAEPAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAAEPAzienda(String value) {
        this.idAAEPAzienda = value;
    }

    /**
     * Recupera il valore della propriet� idAAEPFonteDato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAAEPFonteDato() {
        return idAAEPFonteDato;
    }

    /**
     * Imposta il valore della propriet� idAAEPFonteDato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAAEPFonteDato(String value) {
        this.idAAEPFonteDato = value;
    }

    /**
     * Recupera il valore della propriet� localRegistroAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalRegistroAtto() {
        return localRegistroAtto;
    }

    /**
     * Imposta il valore della propriet� localRegistroAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalRegistroAtto(String value) {
        this.localRegistroAtto = value;
    }

    /**
     * Recupera il valore della propriet� numRestistrAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRestistrAtto() {
        return numRestistrAtto;
    }

    /**
     * Imposta il valore della propriet� numRestistrAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRestistrAtto(String value) {
        this.numRestistrAtto = value;
    }

    /**
     * Recupera il valore della propriet� progrLiquidazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrLiquidazione() {
        return progrLiquidazione;
    }

    /**
     * Imposta il valore della propriet� progrLiquidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrLiquidazione(String value) {
        this.progrLiquidazione = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvRegAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvRegAtto() {
        return siglaProvRegAtto;
    }

    /**
     * Imposta il valore della propriet� siglaProvRegAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvRegAtto(String value) {
        this.siglaProvRegAtto = value;
    }

}
