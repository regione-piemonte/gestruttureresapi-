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
 * <p>Classe Java per corso complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="corso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoComparto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoInizioCorso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codAzionePOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCausaleSoppressione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codComparto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codDocRegionale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codLineaInterventoPOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codMisuraPOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineCorso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioCorso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrAzionePOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCausaleSoppressione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrComparto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrDocRegionale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrLineaInterventoPOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrMisuraPOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numTotPartiIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroAllievi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orePratica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oreStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oreTeoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parteIterAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrAccorpamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrCorso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sede" type="{http://business.aaeporch.aaep.csi.it/}sedeOccasionale" minOccurs="0"/>
 *         &lt;element name="statoAvanzam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoEntita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totaleOreIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinatari" type="{http://business.aaeporch.aaep.csi.it/}genericListItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="indirizzi" type="{http://business.aaeporch.aaep.csi.it/}genericListItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "corso", propOrder = {
    "annoComparto",
    "annoGestione",
    "annoInizioCorso",
    "annoSettore",
    "codAzionePOR",
    "codCausaleSoppressione",
    "codComparto",
    "codDocRegionale",
    "codLineaInterventoPOR",
    "codMisuraPOR",
    "codSettore",
    "dataFineCorso",
    "dataInizioCorso",
    "denominazione",
    "descrAzionePOR",
    "descrCausaleSoppressione",
    "descrComparto",
    "descrDocRegionale",
    "descrLineaInterventoPOR",
    "descrMisuraPOR",
    "descrSettore",
    "numTotPartiIter",
    "numeroAllievi",
    "orePratica",
    "oreStage",
    "oreTeoria",
    "parteIterAttuale",
    "progrAccorpamento",
    "progrCorso",
    "sede",
    "statoAvanzam",
    "tipoAttivita",
    "tipoEntita",
    "totaleOreIter",
    "destinatari",
    "indirizzi"
})
public class Corso {

    protected String annoComparto;
    protected String annoGestione;
    protected String annoInizioCorso;
    protected String annoSettore;
    protected String codAzionePOR;
    protected String codCausaleSoppressione;
    protected String codComparto;
    protected String codDocRegionale;
    protected String codLineaInterventoPOR;
    protected String codMisuraPOR;
    protected String codSettore;
    protected String dataFineCorso;
    protected String dataInizioCorso;
    protected String denominazione;
    protected String descrAzionePOR;
    protected String descrCausaleSoppressione;
    protected String descrComparto;
    protected String descrDocRegionale;
    protected String descrLineaInterventoPOR;
    protected String descrMisuraPOR;
    protected String descrSettore;
    protected String numTotPartiIter;
    protected String numeroAllievi;
    protected String orePratica;
    protected String oreStage;
    protected String oreTeoria;
    protected String parteIterAttuale;
    protected String progrAccorpamento;
    protected String progrCorso;
    protected SedeOccasionale sede;
    protected String statoAvanzam;
    protected String tipoAttivita;
    protected String tipoEntita;
    protected String totaleOreIter;
    @XmlElement(nillable = true)
    protected List<GenericListItem> destinatari;
    @XmlElement(nillable = true)
    protected List<GenericListItem> indirizzi;

    /**
     * Recupera il valore della propriet� annoComparto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoComparto() {
        return annoComparto;
    }

    /**
     * Imposta il valore della propriet� annoComparto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoComparto(String value) {
        this.annoComparto = value;
    }

    /**
     * Recupera il valore della propriet� annoGestione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoGestione() {
        return annoGestione;
    }

    /**
     * Imposta il valore della propriet� annoGestione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoGestione(String value) {
        this.annoGestione = value;
    }

    /**
     * Recupera il valore della propriet� annoInizioCorso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoInizioCorso() {
        return annoInizioCorso;
    }

    /**
     * Imposta il valore della propriet� annoInizioCorso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoInizioCorso(String value) {
        this.annoInizioCorso = value;
    }

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
     * Recupera il valore della propriet� codAzionePOR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAzionePOR() {
        return codAzionePOR;
    }

    /**
     * Imposta il valore della propriet� codAzionePOR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAzionePOR(String value) {
        this.codAzionePOR = value;
    }

    /**
     * Recupera il valore della propriet� codCausaleSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCausaleSoppressione() {
        return codCausaleSoppressione;
    }

    /**
     * Imposta il valore della propriet� codCausaleSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCausaleSoppressione(String value) {
        this.codCausaleSoppressione = value;
    }

    /**
     * Recupera il valore della propriet� codComparto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComparto() {
        return codComparto;
    }

    /**
     * Imposta il valore della propriet� codComparto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComparto(String value) {
        this.codComparto = value;
    }

    /**
     * Recupera il valore della propriet� codDocRegionale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDocRegionale() {
        return codDocRegionale;
    }

    /**
     * Imposta il valore della propriet� codDocRegionale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDocRegionale(String value) {
        this.codDocRegionale = value;
    }

    /**
     * Recupera il valore della propriet� codLineaInterventoPOR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLineaInterventoPOR() {
        return codLineaInterventoPOR;
    }

    /**
     * Imposta il valore della propriet� codLineaInterventoPOR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLineaInterventoPOR(String value) {
        this.codLineaInterventoPOR = value;
    }

    /**
     * Recupera il valore della propriet� codMisuraPOR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMisuraPOR() {
        return codMisuraPOR;
    }

    /**
     * Imposta il valore della propriet� codMisuraPOR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMisuraPOR(String value) {
        this.codMisuraPOR = value;
    }

    /**
     * Recupera il valore della propriet� codSettore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSettore() {
        return codSettore;
    }

    /**
     * Imposta il valore della propriet� codSettore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSettore(String value) {
        this.codSettore = value;
    }

    /**
     * Recupera il valore della propriet� dataFineCorso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineCorso() {
        return dataFineCorso;
    }

    /**
     * Imposta il valore della propriet� dataFineCorso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineCorso(String value) {
        this.dataFineCorso = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioCorso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioCorso() {
        return dataInizioCorso;
    }

    /**
     * Imposta il valore della propriet� dataInizioCorso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioCorso(String value) {
        this.dataInizioCorso = value;
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
     * Recupera il valore della propriet� descrAzionePOR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrAzionePOR() {
        return descrAzionePOR;
    }

    /**
     * Imposta il valore della propriet� descrAzionePOR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrAzionePOR(String value) {
        this.descrAzionePOR = value;
    }

    /**
     * Recupera il valore della propriet� descrCausaleSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCausaleSoppressione() {
        return descrCausaleSoppressione;
    }

    /**
     * Imposta il valore della propriet� descrCausaleSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCausaleSoppressione(String value) {
        this.descrCausaleSoppressione = value;
    }

    /**
     * Recupera il valore della propriet� descrComparto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrComparto() {
        return descrComparto;
    }

    /**
     * Imposta il valore della propriet� descrComparto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrComparto(String value) {
        this.descrComparto = value;
    }

    /**
     * Recupera il valore della propriet� descrDocRegionale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrDocRegionale() {
        return descrDocRegionale;
    }

    /**
     * Imposta il valore della propriet� descrDocRegionale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrDocRegionale(String value) {
        this.descrDocRegionale = value;
    }

    /**
     * Recupera il valore della propriet� descrLineaInterventoPOR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrLineaInterventoPOR() {
        return descrLineaInterventoPOR;
    }

    /**
     * Imposta il valore della propriet� descrLineaInterventoPOR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrLineaInterventoPOR(String value) {
        this.descrLineaInterventoPOR = value;
    }

    /**
     * Recupera il valore della propriet� descrMisuraPOR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrMisuraPOR() {
        return descrMisuraPOR;
    }

    /**
     * Imposta il valore della propriet� descrMisuraPOR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrMisuraPOR(String value) {
        this.descrMisuraPOR = value;
    }

    /**
     * Recupera il valore della propriet� descrSettore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrSettore() {
        return descrSettore;
    }

    /**
     * Imposta il valore della propriet� descrSettore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrSettore(String value) {
        this.descrSettore = value;
    }

    /**
     * Recupera il valore della propriet� numTotPartiIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTotPartiIter() {
        return numTotPartiIter;
    }

    /**
     * Imposta il valore della propriet� numTotPartiIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTotPartiIter(String value) {
        this.numTotPartiIter = value;
    }

    /**
     * Recupera il valore della propriet� numeroAllievi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroAllievi() {
        return numeroAllievi;
    }

    /**
     * Imposta il valore della propriet� numeroAllievi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroAllievi(String value) {
        this.numeroAllievi = value;
    }

    /**
     * Recupera il valore della propriet� orePratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrePratica() {
        return orePratica;
    }

    /**
     * Imposta il valore della propriet� orePratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrePratica(String value) {
        this.orePratica = value;
    }

    /**
     * Recupera il valore della propriet� oreStage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOreStage() {
        return oreStage;
    }

    /**
     * Imposta il valore della propriet� oreStage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOreStage(String value) {
        this.oreStage = value;
    }

    /**
     * Recupera il valore della propriet� oreTeoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOreTeoria() {
        return oreTeoria;
    }

    /**
     * Imposta il valore della propriet� oreTeoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOreTeoria(String value) {
        this.oreTeoria = value;
    }

    /**
     * Recupera il valore della propriet� parteIterAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParteIterAttuale() {
        return parteIterAttuale;
    }

    /**
     * Imposta il valore della propriet� parteIterAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParteIterAttuale(String value) {
        this.parteIterAttuale = value;
    }

    /**
     * Recupera il valore della propriet� progrAccorpamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrAccorpamento() {
        return progrAccorpamento;
    }

    /**
     * Imposta il valore della propriet� progrAccorpamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrAccorpamento(String value) {
        this.progrAccorpamento = value;
    }

    /**
     * Recupera il valore della propriet� progrCorso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrCorso() {
        return progrCorso;
    }

    /**
     * Imposta il valore della propriet� progrCorso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrCorso(String value) {
        this.progrCorso = value;
    }

    /**
     * Recupera il valore della propriet� sede.
     * 
     * @return
     *     possible object is
     *     {@link SedeOccasionale }
     *     
     */
    public SedeOccasionale getSede() {
        return sede;
    }

    /**
     * Imposta il valore della propriet� sede.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeOccasionale }
     *     
     */
    public void setSede(SedeOccasionale value) {
        this.sede = value;
    }

    /**
     * Recupera il valore della propriet� statoAvanzam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoAvanzam() {
        return statoAvanzam;
    }

    /**
     * Imposta il valore della propriet� statoAvanzam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoAvanzam(String value) {
        this.statoAvanzam = value;
    }

    /**
     * Recupera il valore della propriet� tipoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAttivita() {
        return tipoAttivita;
    }

    /**
     * Imposta il valore della propriet� tipoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAttivita(String value) {
        this.tipoAttivita = value;
    }

    /**
     * Recupera il valore della propriet� tipoEntita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEntita() {
        return tipoEntita;
    }

    /**
     * Imposta il valore della propriet� tipoEntita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEntita(String value) {
        this.tipoEntita = value;
    }

    /**
     * Recupera il valore della propriet� totaleOreIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotaleOreIter() {
        return totaleOreIter;
    }

    /**
     * Imposta il valore della propriet� totaleOreIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotaleOreIter(String value) {
        this.totaleOreIter = value;
    }

    /**
     * Gets the value of the destinatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the destinatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDestinatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericListItem }
     * 
     * 
     */
    public List<GenericListItem> getDestinatari() {
        if (destinatari == null) {
            destinatari = new ArrayList<GenericListItem>();
        }
        return this.destinatari;
    }

    /**
     * Gets the value of the indirizzi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indirizzi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndirizzi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericListItem }
     * 
     * 
     */
    public List<GenericListItem> getIndirizzi() {
        if (indirizzi == null) {
            indirizzi = new ArrayList<GenericListItem>();
        }
        return this.indirizzi;
    }

}
