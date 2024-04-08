/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per carica complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="carica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codDurataCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFiscaleAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFiscalePersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataPresentazCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrDurataCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagRappresentanteLegale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idFonteDato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAnniEsercCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carica", propOrder = {
    "codCarica",
    "codDurataCarica",
    "codFiscaleAzienda",
    "codFiscalePersona",
    "dataFineCarica",
    "dataInizioCarica",
    "dataPresentazCarica",
    "descrAzienda",
    "descrCarica",
    "descrDurataCarica",
    "flagRappresentanteLegale",
    "idAzienda",
    "idFonteDato",
    "numAnniEsercCarica",
    "progrCarica",
    "progrPersona"
})
public class Carica {

    protected String codCarica;
    protected String codDurataCarica;
    protected String codFiscaleAzienda;
    protected String codFiscalePersona;
    protected String dataFineCarica;
    protected String dataInizioCarica;
    protected String dataPresentazCarica;
    protected String descrAzienda;
    protected String descrCarica;
    protected String descrDurataCarica;
    protected String flagRappresentanteLegale;
    protected String idAzienda;
    protected String idFonteDato;
    protected String numAnniEsercCarica;
    protected String progrCarica;
    protected String progrPersona;

    /**
     * Recupera il valore della propriet� codCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCarica() {
        return codCarica;
    }

    /**
     * Imposta il valore della propriet� codCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCarica(String value) {
        this.codCarica = value;
    }

    /**
     * Recupera il valore della propriet� codDurataCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDurataCarica() {
        return codDurataCarica;
    }

    /**
     * Imposta il valore della propriet� codDurataCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDurataCarica(String value) {
        this.codDurataCarica = value;
    }

    /**
     * Recupera il valore della propriet� codFiscaleAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleAzienda() {
        return codFiscaleAzienda;
    }

    /**
     * Imposta il valore della propriet� codFiscaleAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleAzienda(String value) {
        this.codFiscaleAzienda = value;
    }

    /**
     * Recupera il valore della propriet� codFiscalePersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscalePersona() {
        return codFiscalePersona;
    }

    /**
     * Imposta il valore della propriet� codFiscalePersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscalePersona(String value) {
        this.codFiscalePersona = value;
    }

    /**
     * Recupera il valore della propriet� dataFineCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineCarica() {
        return dataFineCarica;
    }

    /**
     * Imposta il valore della propriet� dataFineCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineCarica(String value) {
        this.dataFineCarica = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioCarica() {
        return dataInizioCarica;
    }

    /**
     * Imposta il valore della propriet� dataInizioCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioCarica(String value) {
        this.dataInizioCarica = value;
    }

    /**
     * Recupera il valore della propriet� dataPresentazCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataPresentazCarica() {
        return dataPresentazCarica;
    }

    /**
     * Imposta il valore della propriet� dataPresentazCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataPresentazCarica(String value) {
        this.dataPresentazCarica = value;
    }

    /**
     * Recupera il valore della propriet� descrAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrAzienda() {
        return descrAzienda;
    }

    /**
     * Imposta il valore della propriet� descrAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrAzienda(String value) {
        this.descrAzienda = value;
    }

    /**
     * Recupera il valore della propriet� descrCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCarica() {
        return descrCarica;
    }

    /**
     * Imposta il valore della propriet� descrCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCarica(String value) {
        this.descrCarica = value;
    }

    /**
     * Recupera il valore della propriet� descrDurataCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrDurataCarica() {
        return descrDurataCarica;
    }

    /**
     * Imposta il valore della propriet� descrDurataCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrDurataCarica(String value) {
        this.descrDurataCarica = value;
    }

    /**
     * Recupera il valore della propriet� flagRappresentanteLegale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagRappresentanteLegale() {
        return flagRappresentanteLegale;
    }

    /**
     * Imposta il valore della propriet� flagRappresentanteLegale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagRappresentanteLegale(String value) {
        this.flagRappresentanteLegale = value;
    }

    /**
     * Recupera il valore della propriet� idAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAzienda() {
        return idAzienda;
    }

    /**
     * Imposta il valore della propriet� idAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAzienda(String value) {
        this.idAzienda = value;
    }

    /**
     * Recupera il valore della propriet� idFonteDato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFonteDato() {
        return idFonteDato;
    }

    /**
     * Imposta il valore della propriet� idFonteDato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFonteDato(String value) {
        this.idFonteDato = value;
    }

    /**
     * Recupera il valore della propriet� numAnniEsercCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAnniEsercCarica() {
        return numAnniEsercCarica;
    }

    /**
     * Imposta il valore della propriet� numAnniEsercCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAnniEsercCarica(String value) {
        this.numAnniEsercCarica = value;
    }

    /**
     * Recupera il valore della propriet� progrCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrCarica() {
        return progrCarica;
    }

    /**
     * Imposta il valore della propriet� progrCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrCarica(String value) {
        this.progrCarica = value;
    }

    /**
     * Recupera il valore della propriet� progrPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrPersona() {
        return progrPersona;
    }

    /**
     * Imposta il valore della propriet� progrPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrPersona(String value) {
        this.progrPersona = value;
    }

}
