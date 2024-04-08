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
 * <p>Classe Java per bilancio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="bilancio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capitaleSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dettagliBilancio" type="{http://business.aaeporch.aaep.csi.it/}rigoBilancio" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iscrizioneAlboCOOP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numIscrizioneCCIAA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numIscrizioneRegistroImprese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partitaIVA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ubicazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bilancio", propOrder = {
    "capitaleSociale",
    "codiceFiscale",
    "dataAggiornamento",
    "denominazione",
    "dettagliBilancio",
    "iscrizioneAlboCOOP",
    "numIscrizioneCCIAA",
    "numIscrizioneRegistroImprese",
    "numREA",
    "partitaIVA",
    "ubicazione"
})
public class Bilancio {

    protected String capitaleSociale;
    protected String codiceFiscale;
    protected String dataAggiornamento;
    protected String denominazione;
    @XmlElement(nillable = true)
    protected List<RigoBilancio> dettagliBilancio;
    protected String iscrizioneAlboCOOP;
    protected String numIscrizioneCCIAA;
    protected String numIscrizioneRegistroImprese;
    protected String numREA;
    protected String partitaIVA;
    protected String ubicazione;

    /**
     * Recupera il valore della propriet� capitaleSociale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitaleSociale() {
        return capitaleSociale;
    }

    /**
     * Imposta il valore della propriet� capitaleSociale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitaleSociale(String value) {
        this.capitaleSociale = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della propriet� codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della propriet� dataAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Imposta il valore della propriet� dataAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAggiornamento(String value) {
        this.dataAggiornamento = value;
    }

    /**
     * Recupera il valore della propriet� denominazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * Imposta il valore della propriet� denominazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazione(String value) {
        this.denominazione = value;
    }

    /**
     * Gets the value of the dettagliBilancio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dettagliBilancio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettagliBilancio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RigoBilancio }
     * 
     * 
     */
    public List<RigoBilancio> getDettagliBilancio() {
        if (dettagliBilancio == null) {
            dettagliBilancio = new ArrayList<RigoBilancio>();
        }
        return this.dettagliBilancio;
    }

    /**
     * Recupera il valore della propriet� iscrizioneAlboCOOP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIscrizioneAlboCOOP() {
        return iscrizioneAlboCOOP;
    }

    /**
     * Imposta il valore della propriet� iscrizioneAlboCOOP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIscrizioneAlboCOOP(String value) {
        this.iscrizioneAlboCOOP = value;
    }

    /**
     * Recupera il valore della propriet� numIscrizioneCCIAA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumIscrizioneCCIAA() {
        return numIscrizioneCCIAA;
    }

    /**
     * Imposta il valore della propriet� numIscrizioneCCIAA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumIscrizioneCCIAA(String value) {
        this.numIscrizioneCCIAA = value;
    }

    /**
     * Recupera il valore della propriet� numIscrizioneRegistroImprese.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumIscrizioneRegistroImprese() {
        return numIscrizioneRegistroImprese;
    }

    /**
     * Imposta il valore della propriet� numIscrizioneRegistroImprese.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumIscrizioneRegistroImprese(String value) {
        this.numIscrizioneRegistroImprese = value;
    }

    /**
     * Recupera il valore della propriet� numREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumREA() {
        return numREA;
    }

    /**
     * Imposta il valore della propriet� numREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumREA(String value) {
        this.numREA = value;
    }

    /**
     * Recupera il valore della propriet� partitaIVA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitaIVA() {
        return partitaIVA;
    }

    /**
     * Imposta il valore della propriet� partitaIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitaIVA(String value) {
        this.partitaIVA = value;
    }

    /**
     * Recupera il valore della propriet� ubicazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazione() {
        return ubicazione;
    }

    /**
     * Imposta il valore della propriet� ubicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazione(String value) {
        this.ubicazione = value;
    }

}
