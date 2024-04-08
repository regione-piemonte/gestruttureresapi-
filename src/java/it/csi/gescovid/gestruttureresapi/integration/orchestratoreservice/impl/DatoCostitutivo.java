/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per datoCostitutivo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datoCostitutivo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capitSocDeliberato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capitSocSottoscr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capitSocVersato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capitaleSocDelib" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capitalesocVers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codDurataCS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFormaAmministr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTipoAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTipoConferim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCostituzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineEsAmmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFondazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataIniEsAmmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRegAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataScadenzaPrimoEsercizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataTermineSocieta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrFormaAmministr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrProvUffReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrSiglaProvNotaio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrTipoAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrTipoConferim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagDurataIllimitata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localitaNotaio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notaio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAnniEsAmmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAzioniCapitSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numMaxMembriCS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numMembriCSCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numMinMembriCS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numRegAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numRepertorio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSoci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSociCarica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scadenzaEsSucc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvNotaio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvUffRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totFondoConsortE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totFondoConsortile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totQuoteCapitSoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totQuoteCapitSocE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ufficioRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valAzioniCapitSoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valoreAzioniCapitSoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valutaCapitSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valutaCapitale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datoCostitutivo", propOrder = {
    "capitSocDeliberato",
    "capitSocSottoscr",
    "capitSocVersato",
    "capitaleSocDelib",
    "capitalesocVers",
    "codDurataCS",
    "codFormaAmministr",
    "codTipoAtto",
    "codTipoConferim",
    "dataCostituzione",
    "dataFineEsAmmt",
    "dataFondazione",
    "dataIniEsAmmt",
    "dataRegAtto",
    "dataScadenzaPrimoEsercizio",
    "dataTermineSocieta",
    "descrFormaAmministr",
    "descrProvUffReg",
    "descrSiglaProvNotaio",
    "descrTipoAtto",
    "descrTipoConferim",
    "flagDurataIllimitata",
    "localitaNotaio",
    "notaio",
    "numAnniEsAmmt",
    "numAzioniCapitSociale",
    "numMaxMembriCS",
    "numMembriCSCarica",
    "numMinMembriCS",
    "numRegAtto",
    "numRepertorio",
    "numSoci",
    "numSociCarica",
    "scadenzaEsSucc",
    "siglaProvNotaio",
    "siglaProvUffRegistro",
    "totFondoConsortE",
    "totFondoConsortile",
    "totQuoteCapitSoc",
    "totQuoteCapitSocE",
    "ufficioRegistro",
    "valAzioniCapitSoc",
    "valoreAzioniCapitSoc",
    "valutaCapitSociale",
    "valutaCapitale"
})
public class DatoCostitutivo {

    protected String capitSocDeliberato;
    protected String capitSocSottoscr;
    protected String capitSocVersato;
    protected String capitaleSocDelib;
    protected String capitalesocVers;
    protected String codDurataCS;
    protected String codFormaAmministr;
    protected String codTipoAtto;
    protected String codTipoConferim;
    protected String dataCostituzione;
    protected String dataFineEsAmmt;
    protected String dataFondazione;
    protected String dataIniEsAmmt;
    protected String dataRegAtto;
    protected String dataScadenzaPrimoEsercizio;
    protected String dataTermineSocieta;
    protected String descrFormaAmministr;
    protected String descrProvUffReg;
    protected String descrSiglaProvNotaio;
    protected String descrTipoAtto;
    protected String descrTipoConferim;
    protected String flagDurataIllimitata;
    protected String localitaNotaio;
    protected String notaio;
    protected String numAnniEsAmmt;
    protected String numAzioniCapitSociale;
    protected String numMaxMembriCS;
    protected String numMembriCSCarica;
    protected String numMinMembriCS;
    protected String numRegAtto;
    protected String numRepertorio;
    protected String numSoci;
    protected String numSociCarica;
    protected String scadenzaEsSucc;
    protected String siglaProvNotaio;
    protected String siglaProvUffRegistro;
    protected String totFondoConsortE;
    protected String totFondoConsortile;
    protected String totQuoteCapitSoc;
    protected String totQuoteCapitSocE;
    protected String ufficioRegistro;
    protected String valAzioniCapitSoc;
    protected String valoreAzioniCapitSoc;
    protected String valutaCapitSociale;
    protected String valutaCapitale;

    /**
     * Recupera il valore della propriet� capitSocDeliberato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitSocDeliberato() {
        return capitSocDeliberato;
    }

    /**
     * Imposta il valore della propriet� capitSocDeliberato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitSocDeliberato(String value) {
        this.capitSocDeliberato = value;
    }

    /**
     * Recupera il valore della propriet� capitSocSottoscr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitSocSottoscr() {
        return capitSocSottoscr;
    }

    /**
     * Imposta il valore della propriet� capitSocSottoscr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitSocSottoscr(String value) {
        this.capitSocSottoscr = value;
    }

    /**
     * Recupera il valore della propriet� capitSocVersato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitSocVersato() {
        return capitSocVersato;
    }

    /**
     * Imposta il valore della propriet� capitSocVersato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitSocVersato(String value) {
        this.capitSocVersato = value;
    }

    /**
     * Recupera il valore della propriet� capitaleSocDelib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitaleSocDelib() {
        return capitaleSocDelib;
    }

    /**
     * Imposta il valore della propriet� capitaleSocDelib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitaleSocDelib(String value) {
        this.capitaleSocDelib = value;
    }

    /**
     * Recupera il valore della propriet� capitalesocVers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitalesocVers() {
        return capitalesocVers;
    }

    /**
     * Imposta il valore della propriet� capitalesocVers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitalesocVers(String value) {
        this.capitalesocVers = value;
    }

    /**
     * Recupera il valore della propriet� codDurataCS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDurataCS() {
        return codDurataCS;
    }

    /**
     * Imposta il valore della propriet� codDurataCS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDurataCS(String value) {
        this.codDurataCS = value;
    }

    /**
     * Recupera il valore della propriet� codFormaAmministr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFormaAmministr() {
        return codFormaAmministr;
    }

    /**
     * Imposta il valore della propriet� codFormaAmministr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFormaAmministr(String value) {
        this.codFormaAmministr = value;
    }

    /**
     * Recupera il valore della propriet� codTipoAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoAtto() {
        return codTipoAtto;
    }

    /**
     * Imposta il valore della propriet� codTipoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoAtto(String value) {
        this.codTipoAtto = value;
    }

    /**
     * Recupera il valore della propriet� codTipoConferim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoConferim() {
        return codTipoConferim;
    }

    /**
     * Imposta il valore della propriet� codTipoConferim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoConferim(String value) {
        this.codTipoConferim = value;
    }

    /**
     * Recupera il valore della propriet� dataCostituzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCostituzione() {
        return dataCostituzione;
    }

    /**
     * Imposta il valore della propriet� dataCostituzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCostituzione(String value) {
        this.dataCostituzione = value;
    }

    /**
     * Recupera il valore della propriet� dataFineEsAmmt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineEsAmmt() {
        return dataFineEsAmmt;
    }

    /**
     * Imposta il valore della propriet� dataFineEsAmmt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineEsAmmt(String value) {
        this.dataFineEsAmmt = value;
    }

    /**
     * Recupera il valore della propriet� dataFondazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFondazione() {
        return dataFondazione;
    }

    /**
     * Imposta il valore della propriet� dataFondazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFondazione(String value) {
        this.dataFondazione = value;
    }

    /**
     * Recupera il valore della propriet� dataIniEsAmmt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataIniEsAmmt() {
        return dataIniEsAmmt;
    }

    /**
     * Imposta il valore della propriet� dataIniEsAmmt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataIniEsAmmt(String value) {
        this.dataIniEsAmmt = value;
    }

    /**
     * Recupera il valore della propriet� dataRegAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRegAtto() {
        return dataRegAtto;
    }

    /**
     * Imposta il valore della propriet� dataRegAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRegAtto(String value) {
        this.dataRegAtto = value;
    }

    /**
     * Recupera il valore della propriet� dataScadenzaPrimoEsercizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataScadenzaPrimoEsercizio() {
        return dataScadenzaPrimoEsercizio;
    }

    /**
     * Imposta il valore della propriet� dataScadenzaPrimoEsercizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataScadenzaPrimoEsercizio(String value) {
        this.dataScadenzaPrimoEsercizio = value;
    }

    /**
     * Recupera il valore della propriet� dataTermineSocieta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataTermineSocieta() {
        return dataTermineSocieta;
    }

    /**
     * Imposta il valore della propriet� dataTermineSocieta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataTermineSocieta(String value) {
        this.dataTermineSocieta = value;
    }

    /**
     * Recupera il valore della propriet� descrFormaAmministr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrFormaAmministr() {
        return descrFormaAmministr;
    }

    /**
     * Imposta il valore della propriet� descrFormaAmministr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrFormaAmministr(String value) {
        this.descrFormaAmministr = value;
    }

    /**
     * Recupera il valore della propriet� descrProvUffReg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrProvUffReg() {
        return descrProvUffReg;
    }

    /**
     * Imposta il valore della propriet� descrProvUffReg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrProvUffReg(String value) {
        this.descrProvUffReg = value;
    }

    /**
     * Recupera il valore della propriet� descrSiglaProvNotaio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrSiglaProvNotaio() {
        return descrSiglaProvNotaio;
    }

    /**
     * Imposta il valore della propriet� descrSiglaProvNotaio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrSiglaProvNotaio(String value) {
        this.descrSiglaProvNotaio = value;
    }

    /**
     * Recupera il valore della propriet� descrTipoAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTipoAtto() {
        return descrTipoAtto;
    }

    /**
     * Imposta il valore della propriet� descrTipoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTipoAtto(String value) {
        this.descrTipoAtto = value;
    }

    /**
     * Recupera il valore della propriet� descrTipoConferim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTipoConferim() {
        return descrTipoConferim;
    }

    /**
     * Imposta il valore della propriet� descrTipoConferim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTipoConferim(String value) {
        this.descrTipoConferim = value;
    }

    /**
     * Recupera il valore della propriet� flagDurataIllimitata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagDurataIllimitata() {
        return flagDurataIllimitata;
    }

    /**
     * Imposta il valore della propriet� flagDurataIllimitata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagDurataIllimitata(String value) {
        this.flagDurataIllimitata = value;
    }

    /**
     * Recupera il valore della propriet� localitaNotaio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalitaNotaio() {
        return localitaNotaio;
    }

    /**
     * Imposta il valore della propriet� localitaNotaio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalitaNotaio(String value) {
        this.localitaNotaio = value;
    }

    /**
     * Recupera il valore della propriet� notaio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotaio() {
        return notaio;
    }

    /**
     * Imposta il valore della propriet� notaio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotaio(String value) {
        this.notaio = value;
    }

    /**
     * Recupera il valore della propriet� numAnniEsAmmt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAnniEsAmmt() {
        return numAnniEsAmmt;
    }

    /**
     * Imposta il valore della propriet� numAnniEsAmmt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAnniEsAmmt(String value) {
        this.numAnniEsAmmt = value;
    }

    /**
     * Recupera il valore della propriet� numAzioniCapitSociale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAzioniCapitSociale() {
        return numAzioniCapitSociale;
    }

    /**
     * Imposta il valore della propriet� numAzioniCapitSociale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAzioniCapitSociale(String value) {
        this.numAzioniCapitSociale = value;
    }

    /**
     * Recupera il valore della propriet� numMaxMembriCS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumMaxMembriCS() {
        return numMaxMembriCS;
    }

    /**
     * Imposta il valore della propriet� numMaxMembriCS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumMaxMembriCS(String value) {
        this.numMaxMembriCS = value;
    }

    /**
     * Recupera il valore della propriet� numMembriCSCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumMembriCSCarica() {
        return numMembriCSCarica;
    }

    /**
     * Imposta il valore della propriet� numMembriCSCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumMembriCSCarica(String value) {
        this.numMembriCSCarica = value;
    }

    /**
     * Recupera il valore della propriet� numMinMembriCS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumMinMembriCS() {
        return numMinMembriCS;
    }

    /**
     * Imposta il valore della propriet� numMinMembriCS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumMinMembriCS(String value) {
        this.numMinMembriCS = value;
    }

    /**
     * Recupera il valore della propriet� numRegAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRegAtto() {
        return numRegAtto;
    }

    /**
     * Imposta il valore della propriet� numRegAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRegAtto(String value) {
        this.numRegAtto = value;
    }

    /**
     * Recupera il valore della propriet� numRepertorio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRepertorio() {
        return numRepertorio;
    }

    /**
     * Imposta il valore della propriet� numRepertorio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRepertorio(String value) {
        this.numRepertorio = value;
    }

    /**
     * Recupera il valore della propriet� numSoci.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSoci() {
        return numSoci;
    }

    /**
     * Imposta il valore della propriet� numSoci.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSoci(String value) {
        this.numSoci = value;
    }

    /**
     * Recupera il valore della propriet� numSociCarica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSociCarica() {
        return numSociCarica;
    }

    /**
     * Imposta il valore della propriet� numSociCarica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSociCarica(String value) {
        this.numSociCarica = value;
    }

    /**
     * Recupera il valore della propriet� scadenzaEsSucc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScadenzaEsSucc() {
        return scadenzaEsSucc;
    }

    /**
     * Imposta il valore della propriet� scadenzaEsSucc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScadenzaEsSucc(String value) {
        this.scadenzaEsSucc = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvNotaio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvNotaio() {
        return siglaProvNotaio;
    }

    /**
     * Imposta il valore della propriet� siglaProvNotaio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvNotaio(String value) {
        this.siglaProvNotaio = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvUffRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvUffRegistro() {
        return siglaProvUffRegistro;
    }

    /**
     * Imposta il valore della propriet� siglaProvUffRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvUffRegistro(String value) {
        this.siglaProvUffRegistro = value;
    }

    /**
     * Recupera il valore della propriet� totFondoConsortE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotFondoConsortE() {
        return totFondoConsortE;
    }

    /**
     * Imposta il valore della propriet� totFondoConsortE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotFondoConsortE(String value) {
        this.totFondoConsortE = value;
    }

    /**
     * Recupera il valore della propriet� totFondoConsortile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotFondoConsortile() {
        return totFondoConsortile;
    }

    /**
     * Imposta il valore della propriet� totFondoConsortile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotFondoConsortile(String value) {
        this.totFondoConsortile = value;
    }

    /**
     * Recupera il valore della propriet� totQuoteCapitSoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotQuoteCapitSoc() {
        return totQuoteCapitSoc;
    }

    /**
     * Imposta il valore della propriet� totQuoteCapitSoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotQuoteCapitSoc(String value) {
        this.totQuoteCapitSoc = value;
    }

    /**
     * Recupera il valore della propriet� totQuoteCapitSocE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotQuoteCapitSocE() {
        return totQuoteCapitSocE;
    }

    /**
     * Imposta il valore della propriet� totQuoteCapitSocE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotQuoteCapitSocE(String value) {
        this.totQuoteCapitSocE = value;
    }

    /**
     * Recupera il valore della propriet� ufficioRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUfficioRegistro() {
        return ufficioRegistro;
    }

    /**
     * Imposta il valore della propriet� ufficioRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUfficioRegistro(String value) {
        this.ufficioRegistro = value;
    }

    /**
     * Recupera il valore della propriet� valAzioniCapitSoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValAzioniCapitSoc() {
        return valAzioniCapitSoc;
    }

    /**
     * Imposta il valore della propriet� valAzioniCapitSoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValAzioniCapitSoc(String value) {
        this.valAzioniCapitSoc = value;
    }

    /**
     * Recupera il valore della propriet� valoreAzioniCapitSoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreAzioniCapitSoc() {
        return valoreAzioniCapitSoc;
    }

    /**
     * Imposta il valore della propriet� valoreAzioniCapitSoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreAzioniCapitSoc(String value) {
        this.valoreAzioniCapitSoc = value;
    }

    /**
     * Recupera il valore della propriet� valutaCapitSociale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValutaCapitSociale() {
        return valutaCapitSociale;
    }

    /**
     * Imposta il valore della propriet� valutaCapitSociale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValutaCapitSociale(String value) {
        this.valutaCapitSociale = value;
    }

    /**
     * Recupera il valore della propriet� valutaCapitale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValutaCapitale() {
        return valutaCapitale;
    }

    /**
     * Imposta il valore della propriet� valutaCapitale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValutaCapitale(String value) {
        this.valutaCapitale = value;
    }

}
