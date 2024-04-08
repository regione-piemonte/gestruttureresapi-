/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cercaImprese complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cercaImprese">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="utente" type="{http://business.aaeporch.aaep.csi.it/}utente" minOccurs="0"/>
 *         &lt;element name="fonte" type="{http://business.aaeporch.aaep.csi.it/}tipologiaFonte" minOccurs="0"/>
 *         &lt;element name="statoCessazione" type="{http://business.aaeporch.aaep.csi.it/}statoCessazione" minOccurs="0"/>
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscaleLike" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ragioneSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ragioneSocialeLike" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="escapeCaratteriJolly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="codiceAteco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoAtecoDiRiferimento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codiceFiscalePersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceNaturaGiuridica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipologiaSede" type="{http://business.aaeporch.aaep.csi.it/}tipologiaSede" minOccurs="0"/>
 *         &lt;element name="siglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceIstatComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cercaImprese", propOrder = {
    "utente",
    "fonte",
    "statoCessazione",
    "codiceFiscale",
    "codiceFiscaleLike",
    "ragioneSociale",
    "ragioneSocialeLike",
    "escapeCaratteriJolly",
    "codiceAteco",
    "annoAtecoDiRiferimento",
    "codiceFiscalePersona",
    "codiceNaturaGiuridica",
    "tipologiaSede",
    "siglaProvincia",
    "codiceIstatComune",
    "localita"
})
public class CercaImprese {

    protected Utente utente;
    protected TipologiaFonte fonte;
    protected StatoCessazione statoCessazione;
    protected String codiceFiscale;
    protected Boolean codiceFiscaleLike;
    protected String ragioneSociale;
    protected Boolean ragioneSocialeLike;
    protected Boolean escapeCaratteriJolly;
    protected String codiceAteco;
    protected Integer annoAtecoDiRiferimento;
    protected String codiceFiscalePersona;
    protected String codiceNaturaGiuridica;
    protected TipologiaSede tipologiaSede;
    protected String siglaProvincia;
    protected String codiceIstatComune;
    protected String localita;

    /**
     * Recupera il valore della propriet� utente.
     * 
     * @return
     *     possible object is
     *     {@link Utente }
     *     
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * Imposta il valore della propriet� utente.
     * 
     * @param value
     *     allowed object is
     *     {@link Utente }
     *     
     */
    public void setUtente(Utente value) {
        this.utente = value;
    }

    /**
     * Recupera il valore della propriet� fonte.
     * 
     * @return
     *     possible object is
     *     {@link TipologiaFonte }
     *     
     */
    public TipologiaFonte getFonte() {
        return fonte;
    }

    /**
     * Imposta il valore della propriet� fonte.
     * 
     * @param value
     *     allowed object is
     *     {@link TipologiaFonte }
     *     
     */
    public void setFonte(TipologiaFonte value) {
        this.fonte = value;
    }

    /**
     * Recupera il valore della propriet� statoCessazione.
     * 
     * @return
     *     possible object is
     *     {@link StatoCessazione }
     *     
     */
    public StatoCessazione getStatoCessazione() {
        return statoCessazione;
    }

    /**
     * Imposta il valore della propriet� statoCessazione.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoCessazione }
     *     
     */
    public void setStatoCessazione(StatoCessazione value) {
        this.statoCessazione = value;
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
     * Recupera il valore della propriet� codiceFiscaleLike.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCodiceFiscaleLike() {
        return codiceFiscaleLike;
    }

    /**
     * Imposta il valore della propriet� codiceFiscaleLike.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCodiceFiscaleLike(Boolean value) {
        this.codiceFiscaleLike = value;
    }

    /**
     * Recupera il valore della propriet� ragioneSociale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRagioneSociale() {
        return ragioneSociale;
    }

    /**
     * Imposta il valore della propriet� ragioneSociale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRagioneSociale(String value) {
        this.ragioneSociale = value;
    }

    /**
     * Recupera il valore della propriet� ragioneSocialeLike.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRagioneSocialeLike() {
        return ragioneSocialeLike;
    }

    /**
     * Imposta il valore della propriet� ragioneSocialeLike.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRagioneSocialeLike(Boolean value) {
        this.ragioneSocialeLike = value;
    }

    /**
     * Recupera il valore della propriet� escapeCaratteriJolly.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEscapeCaratteriJolly() {
        return escapeCaratteriJolly;
    }

    /**
     * Imposta il valore della propriet� escapeCaratteriJolly.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEscapeCaratteriJolly(Boolean value) {
        this.escapeCaratteriJolly = value;
    }

    /**
     * Recupera il valore della propriet� codiceAteco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAteco() {
        return codiceAteco;
    }

    /**
     * Imposta il valore della propriet� codiceAteco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAteco(String value) {
        this.codiceAteco = value;
    }

    /**
     * Recupera il valore della propriet� annoAtecoDiRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnnoAtecoDiRiferimento() {
        return annoAtecoDiRiferimento;
    }

    /**
     * Imposta il valore della propriet� annoAtecoDiRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnnoAtecoDiRiferimento(Integer value) {
        this.annoAtecoDiRiferimento = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscalePersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscalePersona() {
        return codiceFiscalePersona;
    }

    /**
     * Imposta il valore della propriet� codiceFiscalePersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscalePersona(String value) {
        this.codiceFiscalePersona = value;
    }

    /**
     * Recupera il valore della propriet� codiceNaturaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceNaturaGiuridica() {
        return codiceNaturaGiuridica;
    }

    /**
     * Imposta il valore della propriet� codiceNaturaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceNaturaGiuridica(String value) {
        this.codiceNaturaGiuridica = value;
    }

    /**
     * Recupera il valore della propriet� tipologiaSede.
     * 
     * @return
     *     possible object is
     *     {@link TipologiaSede }
     *     
     */
    public TipologiaSede getTipologiaSede() {
        return tipologiaSede;
    }

    /**
     * Imposta il valore della propriet� tipologiaSede.
     * 
     * @param value
     *     allowed object is
     *     {@link TipologiaSede }
     *     
     */
    public void setTipologiaSede(TipologiaSede value) {
        this.tipologiaSede = value;
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
     * Recupera il valore della propriet� codiceIstatComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceIstatComune() {
        return codiceIstatComune;
    }

    /**
     * Imposta il valore della propriet� codiceIstatComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceIstatComune(String value) {
        this.codiceIstatComune = value;
    }

    /**
     * Recupera il valore della propriet� localita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalita() {
        return localita;
    }

    /**
     * Imposta il valore della propriet� localita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalita(String value) {
        this.localita = value;
    }

}
