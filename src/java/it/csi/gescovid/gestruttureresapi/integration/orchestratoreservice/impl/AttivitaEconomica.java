/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per attivitaEconomica complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="attivitaEconomica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoDiRiferimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codImportanzaAA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codImportanzaRI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceATECO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCessazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrImportanzaAA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrImportanzaRI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attivitaEconomica", propOrder = {
    "annoDiRiferimento",
    "codImportanzaAA",
    "codImportanzaRI",
    "codiceATECO",
    "dataCessazione",
    "dataInizio",
    "descrImportanzaAA",
    "descrImportanzaRI",
    "descrizione"
})
public class AttivitaEconomica {

    protected String annoDiRiferimento;
    protected String codImportanzaAA;
    protected String codImportanzaRI;
    protected String codiceATECO;
    protected String dataCessazione;
    protected String dataInizio;
    protected String descrImportanzaAA;
    protected String descrImportanzaRI;
    protected String descrizione;

    /**
     * Recupera il valore della propriet� annoDiRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoDiRiferimento() {
        return annoDiRiferimento;
    }

    /**
     * Imposta il valore della propriet� annoDiRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoDiRiferimento(String value) {
        this.annoDiRiferimento = value;
    }

    /**
     * Recupera il valore della propriet� codImportanzaAA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodImportanzaAA() {
        return codImportanzaAA;
    }

    /**
     * Imposta il valore della propriet� codImportanzaAA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodImportanzaAA(String value) {
        this.codImportanzaAA = value;
    }

    /**
     * Recupera il valore della propriet� codImportanzaRI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodImportanzaRI() {
        return codImportanzaRI;
    }

    /**
     * Imposta il valore della propriet� codImportanzaRI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodImportanzaRI(String value) {
        this.codImportanzaRI = value;
    }

    /**
     * Recupera il valore della propriet� codiceATECO.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceATECO() {
        return codiceATECO;
    }

    /**
     * Imposta il valore della propriet� codiceATECO.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceATECO(String value) {
        this.codiceATECO = value;
    }

    /**
     * Recupera il valore della propriet� dataCessazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCessazione() {
        return dataCessazione;
    }

    /**
     * Imposta il valore della propriet� dataCessazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCessazione(String value) {
        this.dataCessazione = value;
    }

    /**
     * Recupera il valore della propriet� dataInizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizio() {
        return dataInizio;
    }

    /**
     * Imposta il valore della propriet� dataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizio(String value) {
        this.dataInizio = value;
    }

    /**
     * Recupera il valore della propriet� descrImportanzaAA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrImportanzaAA() {
        return descrImportanzaAA;
    }

    /**
     * Imposta il valore della propriet� descrImportanzaAA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrImportanzaAA(String value) {
        this.descrImportanzaAA = value;
    }

    /**
     * Recupera il valore della propriet� descrImportanzaRI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrImportanzaRI() {
        return descrImportanzaRI;
    }

    /**
     * Imposta il valore della propriet� descrImportanzaRI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrImportanzaRI(String value) {
        this.descrImportanzaRI = value;
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

}
