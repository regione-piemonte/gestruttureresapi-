/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per alboRuolo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="alboRuolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAlbo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCausaleCessaz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEnte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFormaRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTipoRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTipologiaRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCessazRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDelibCessazRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDeliberaRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDomandaCessazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDomandaIscrRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrAlbo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCessaz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrEnte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrFormaRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrTipoRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvRuolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alboRuolo", propOrder = {
    "codAlbo",
    "codCausaleCessaz",
    "codEnte",
    "codFormaRuolo",
    "codTipoRuolo",
    "codTipologiaRuolo",
    "dataCessazRuolo",
    "dataDelibCessazRuolo",
    "dataDeliberaRuolo",
    "dataDomandaCessazione",
    "dataDomandaIscrRuolo",
    "dataInizioAttivita",
    "descrAlbo",
    "descrCessaz",
    "descrEnte",
    "descrFormaRuolo",
    "descrTipoRuolo",
    "idRuolo",
    "numRuolo",
    "siglaProvRuolo"
})
public class AlboRuolo {

    protected String codAlbo;
    protected String codCausaleCessaz;
    protected String codEnte;
    protected String codFormaRuolo;
    protected String codTipoRuolo;
    protected String codTipologiaRuolo;
    protected String dataCessazRuolo;
    protected String dataDelibCessazRuolo;
    protected String dataDeliberaRuolo;
    protected String dataDomandaCessazione;
    protected String dataDomandaIscrRuolo;
    protected String dataInizioAttivita;
    protected String descrAlbo;
    protected String descrCessaz;
    protected String descrEnte;
    protected String descrFormaRuolo;
    protected String descrTipoRuolo;
    protected String idRuolo;
    protected String numRuolo;
    protected String siglaProvRuolo;

    /**
     * Recupera il valore della propriet� codAlbo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAlbo() {
        return codAlbo;
    }

    /**
     * Imposta il valore della propriet� codAlbo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAlbo(String value) {
        this.codAlbo = value;
    }

    /**
     * Recupera il valore della propriet� codCausaleCessaz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCausaleCessaz() {
        return codCausaleCessaz;
    }

    /**
     * Imposta il valore della propriet� codCausaleCessaz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCausaleCessaz(String value) {
        this.codCausaleCessaz = value;
    }

    /**
     * Recupera il valore della propriet� codEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEnte() {
        return codEnte;
    }

    /**
     * Imposta il valore della propriet� codEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEnte(String value) {
        this.codEnte = value;
    }

    /**
     * Recupera il valore della propriet� codFormaRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFormaRuolo() {
        return codFormaRuolo;
    }

    /**
     * Imposta il valore della propriet� codFormaRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFormaRuolo(String value) {
        this.codFormaRuolo = value;
    }

    /**
     * Recupera il valore della propriet� codTipoRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoRuolo() {
        return codTipoRuolo;
    }

    /**
     * Imposta il valore della propriet� codTipoRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoRuolo(String value) {
        this.codTipoRuolo = value;
    }

    /**
     * Recupera il valore della propriet� codTipologiaRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaRuolo() {
        return codTipologiaRuolo;
    }

    /**
     * Imposta il valore della propriet� codTipologiaRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaRuolo(String value) {
        this.codTipologiaRuolo = value;
    }

    /**
     * Recupera il valore della propriet� dataCessazRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCessazRuolo() {
        return dataCessazRuolo;
    }

    /**
     * Imposta il valore della propriet� dataCessazRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCessazRuolo(String value) {
        this.dataCessazRuolo = value;
    }

    /**
     * Recupera il valore della propriet� dataDelibCessazRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDelibCessazRuolo() {
        return dataDelibCessazRuolo;
    }

    /**
     * Imposta il valore della propriet� dataDelibCessazRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDelibCessazRuolo(String value) {
        this.dataDelibCessazRuolo = value;
    }

    /**
     * Recupera il valore della propriet� dataDeliberaRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDeliberaRuolo() {
        return dataDeliberaRuolo;
    }

    /**
     * Imposta il valore della propriet� dataDeliberaRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDeliberaRuolo(String value) {
        this.dataDeliberaRuolo = value;
    }

    /**
     * Recupera il valore della propriet� dataDomandaCessazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDomandaCessazione() {
        return dataDomandaCessazione;
    }

    /**
     * Imposta il valore della propriet� dataDomandaCessazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDomandaCessazione(String value) {
        this.dataDomandaCessazione = value;
    }

    /**
     * Recupera il valore della propriet� dataDomandaIscrRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDomandaIscrRuolo() {
        return dataDomandaIscrRuolo;
    }

    /**
     * Imposta il valore della propriet� dataDomandaIscrRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDomandaIscrRuolo(String value) {
        this.dataDomandaIscrRuolo = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioAttivita() {
        return dataInizioAttivita;
    }

    /**
     * Imposta il valore della propriet� dataInizioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioAttivita(String value) {
        this.dataInizioAttivita = value;
    }

    /**
     * Recupera il valore della propriet� descrAlbo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrAlbo() {
        return descrAlbo;
    }

    /**
     * Imposta il valore della propriet� descrAlbo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrAlbo(String value) {
        this.descrAlbo = value;
    }

    /**
     * Recupera il valore della propriet� descrCessaz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCessaz() {
        return descrCessaz;
    }

    /**
     * Imposta il valore della propriet� descrCessaz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCessaz(String value) {
        this.descrCessaz = value;
    }

    /**
     * Recupera il valore della propriet� descrEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrEnte() {
        return descrEnte;
    }

    /**
     * Imposta il valore della propriet� descrEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrEnte(String value) {
        this.descrEnte = value;
    }

    /**
     * Recupera il valore della propriet� descrFormaRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrFormaRuolo() {
        return descrFormaRuolo;
    }

    /**
     * Imposta il valore della propriet� descrFormaRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrFormaRuolo(String value) {
        this.descrFormaRuolo = value;
    }

    /**
     * Recupera il valore della propriet� descrTipoRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTipoRuolo() {
        return descrTipoRuolo;
    }

    /**
     * Imposta il valore della propriet� descrTipoRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTipoRuolo(String value) {
        this.descrTipoRuolo = value;
    }

    /**
     * Recupera il valore della propriet� idRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRuolo() {
        return idRuolo;
    }

    /**
     * Imposta il valore della propriet� idRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRuolo(String value) {
        this.idRuolo = value;
    }

    /**
     * Recupera il valore della propriet� numRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRuolo() {
        return numRuolo;
    }

    /**
     * Imposta il valore della propriet� numRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRuolo(String value) {
        this.numRuolo = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvRuolo() {
        return siglaProvRuolo;
    }

    /**
     * Imposta il valore della propriet� siglaProvRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvRuolo(String value) {
        this.siglaProvRuolo = value;
    }

}
