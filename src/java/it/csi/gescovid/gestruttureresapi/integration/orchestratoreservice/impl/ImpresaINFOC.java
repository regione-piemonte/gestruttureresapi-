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
 * <p>Classe Java per impresaINFOC complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="impresaINFOC">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}impresa">
 *       &lt;sequence>
 *         &lt;element name="annoDenunciaAddetti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cessazioneFunzioneSedeLegale" type="{http://business.aaeporch.aaep.csi.it/}cessazione" minOccurs="0"/>
 *         &lt;element name="codFonte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datoCostitutivo" type="{http://business.aaeporch.aaep.csi.it/}datoCostitutivo" minOccurs="0"/>
 *         &lt;element name="descrIndicStatoAttiv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrIndicTrasfSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagLocalizzazionePiemonte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flgAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="impresaCessata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicStatoAttiv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicTrasfSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaPersone" type="{http://business.aaeporch.aaep.csi.it/}persona" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaProcConcors" type="{http://business.aaeporch.aaep.csi.it/}procConcors" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaSezSpecInfoc" type="{http://business.aaeporch.aaep.csi.it/}sezioneSpeciale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numAddettiFam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAddettiSubord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testoOggettoSociale" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impresaINFOC", propOrder = {
    "annoDenunciaAddetti",
    "cessazioneFunzioneSedeLegale",
    "codFonte",
    "datoCostitutivo",
    "descrIndicStatoAttiv",
    "descrIndicTrasfSede",
    "flagLocalizzazionePiemonte",
    "flgAggiornamento",
    "impresaCessata",
    "indicStatoAttiv",
    "indicTrasfSede",
    "listaPersone",
    "listaProcConcors",
    "listaSezSpecInfoc",
    "numAddettiFam",
    "numAddettiSubord",
    "testoOggettoSociale"
})
public class ImpresaINFOC
    extends Impresa
{

    protected String annoDenunciaAddetti;
    protected Cessazione cessazioneFunzioneSedeLegale;
    protected String codFonte;
    protected DatoCostitutivo datoCostitutivo;
    protected String descrIndicStatoAttiv;
    protected String descrIndicTrasfSede;
    protected String flagLocalizzazionePiemonte;
    protected String flgAggiornamento;
    protected String impresaCessata;
    protected String indicStatoAttiv;
    protected String indicTrasfSede;
    @XmlElement(nillable = true)
    protected List<Persona> listaPersone;
    @XmlElement(nillable = true)
    protected List<ProcConcors> listaProcConcors;
    @XmlElement(nillable = true)
    protected List<SezioneSpeciale> listaSezSpecInfoc;
    protected String numAddettiFam;
    protected String numAddettiSubord;
    @XmlElement(nillable = true)
    protected List<String> testoOggettoSociale;

    /**
     * Recupera il valore della propriet� annoDenunciaAddetti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoDenunciaAddetti() {
        return annoDenunciaAddetti;
    }

    /**
     * Imposta il valore della propriet� annoDenunciaAddetti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoDenunciaAddetti(String value) {
        this.annoDenunciaAddetti = value;
    }

    /**
     * Recupera il valore della propriet� cessazioneFunzioneSedeLegale.
     * 
     * @return
     *     possible object is
     *     {@link Cessazione }
     *     
     */
    public Cessazione getCessazioneFunzioneSedeLegale() {
        return cessazioneFunzioneSedeLegale;
    }

    /**
     * Imposta il valore della propriet� cessazioneFunzioneSedeLegale.
     * 
     * @param value
     *     allowed object is
     *     {@link Cessazione }
     *     
     */
    public void setCessazioneFunzioneSedeLegale(Cessazione value) {
        this.cessazioneFunzioneSedeLegale = value;
    }

    /**
     * Recupera il valore della propriet� codFonte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFonte() {
        return codFonte;
    }

    /**
     * Imposta il valore della propriet� codFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFonte(String value) {
        this.codFonte = value;
    }

    /**
     * Recupera il valore della propriet� datoCostitutivo.
     * 
     * @return
     *     possible object is
     *     {@link DatoCostitutivo }
     *     
     */
    public DatoCostitutivo getDatoCostitutivo() {
        return datoCostitutivo;
    }

    /**
     * Imposta il valore della propriet� datoCostitutivo.
     * 
     * @param value
     *     allowed object is
     *     {@link DatoCostitutivo }
     *     
     */
    public void setDatoCostitutivo(DatoCostitutivo value) {
        this.datoCostitutivo = value;
    }

    /**
     * Recupera il valore della propriet� descrIndicStatoAttiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrIndicStatoAttiv() {
        return descrIndicStatoAttiv;
    }

    /**
     * Imposta il valore della propriet� descrIndicStatoAttiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrIndicStatoAttiv(String value) {
        this.descrIndicStatoAttiv = value;
    }

    /**
     * Recupera il valore della propriet� descrIndicTrasfSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrIndicTrasfSede() {
        return descrIndicTrasfSede;
    }

    /**
     * Imposta il valore della propriet� descrIndicTrasfSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrIndicTrasfSede(String value) {
        this.descrIndicTrasfSede = value;
    }

    /**
     * Recupera il valore della propriet� flagLocalizzazionePiemonte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagLocalizzazionePiemonte() {
        return flagLocalizzazionePiemonte;
    }

    /**
     * Imposta il valore della propriet� flagLocalizzazionePiemonte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagLocalizzazionePiemonte(String value) {
        this.flagLocalizzazionePiemonte = value;
    }

    /**
     * Recupera il valore della propriet� flgAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgAggiornamento() {
        return flgAggiornamento;
    }

    /**
     * Imposta il valore della propriet� flgAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgAggiornamento(String value) {
        this.flgAggiornamento = value;
    }

    /**
     * Recupera il valore della propriet� impresaCessata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpresaCessata() {
        return impresaCessata;
    }

    /**
     * Imposta il valore della propriet� impresaCessata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpresaCessata(String value) {
        this.impresaCessata = value;
    }

    /**
     * Recupera il valore della propriet� indicStatoAttiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicStatoAttiv() {
        return indicStatoAttiv;
    }

    /**
     * Imposta il valore della propriet� indicStatoAttiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicStatoAttiv(String value) {
        this.indicStatoAttiv = value;
    }

    /**
     * Recupera il valore della propriet� indicTrasfSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicTrasfSede() {
        return indicTrasfSede;
    }

    /**
     * Imposta il valore della propriet� indicTrasfSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicTrasfSede(String value) {
        this.indicTrasfSede = value;
    }

    /**
     * Gets the value of the listaPersone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaPersone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaPersone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Persona }
     * 
     * 
     */
    public List<Persona> getListaPersone() {
        if (listaPersone == null) {
            listaPersone = new ArrayList<Persona>();
        }
        return this.listaPersone;
    }

    /**
     * Gets the value of the listaProcConcors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaProcConcors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaProcConcors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcConcors }
     * 
     * 
     */
    public List<ProcConcors> getListaProcConcors() {
        if (listaProcConcors == null) {
            listaProcConcors = new ArrayList<ProcConcors>();
        }
        return this.listaProcConcors;
    }

    /**
     * Gets the value of the listaSezSpecInfoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaSezSpecInfoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaSezSpecInfoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SezioneSpeciale }
     * 
     * 
     */
    public List<SezioneSpeciale> getListaSezSpecInfoc() {
        if (listaSezSpecInfoc == null) {
            listaSezSpecInfoc = new ArrayList<SezioneSpeciale>();
        }
        return this.listaSezSpecInfoc;
    }

    /**
     * Recupera il valore della propriet� numAddettiFam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAddettiFam() {
        return numAddettiFam;
    }

    /**
     * Imposta il valore della propriet� numAddettiFam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAddettiFam(String value) {
        this.numAddettiFam = value;
    }

    /**
     * Recupera il valore della propriet� numAddettiSubord.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAddettiSubord() {
        return numAddettiSubord;
    }

    /**
     * Imposta il valore della propriet� numAddettiSubord.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAddettiSubord(String value) {
        this.numAddettiSubord = value;
    }

    /**
     * Gets the value of the testoOggettoSociale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the testoOggettoSociale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTestoOggettoSociale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTestoOggettoSociale() {
        if (testoOggettoSociale == null) {
            testoOggettoSociale = new ArrayList<String>();
        }
        return this.testoOggettoSociale;
    }

}
