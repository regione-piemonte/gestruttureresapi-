/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per sedeFonteINFOC complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="sedeFonteINFOC">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}sede">
 *       &lt;sequence>
 *         &lt;element name="codCausaleCessazioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCancREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCessazioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDenunciaCessazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDenunciaCessazioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCausaleCessazioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrStatoEstero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numIscrizREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvCCIAA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sedeFonteINFOC", propOrder = {
    "codCausaleCessazioneREA",
    "dataCancREA",
    "dataCessazioneREA",
    "dataDenunciaCessazione",
    "dataDenunciaCessazioneREA",
    "descrCausaleCessazioneREA",
    "descrStatoEstero",
    "localita",
    "numIscrizREA",
    "siglaProv",
    "siglaProvCCIAA"
})
public class SedeFonteINFOC
    extends Sede
{

    protected String codCausaleCessazioneREA;
    protected String dataCancREA;
    protected String dataCessazioneREA;
    protected String dataDenunciaCessazione;
    protected String dataDenunciaCessazioneREA;
    protected String descrCausaleCessazioneREA;
    protected String descrStatoEstero;
    protected String localita;
    protected String numIscrizREA;
    protected String siglaProv;
    protected String siglaProvCCIAA;

    /**
     * Recupera il valore della propriet� codCausaleCessazioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCausaleCessazioneREA() {
        return codCausaleCessazioneREA;
    }

    /**
     * Imposta il valore della propriet� codCausaleCessazioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCausaleCessazioneREA(String value) {
        this.codCausaleCessazioneREA = value;
    }

    /**
     * Recupera il valore della propriet� dataCancREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCancREA() {
        return dataCancREA;
    }

    /**
     * Imposta il valore della propriet� dataCancREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCancREA(String value) {
        this.dataCancREA = value;
    }

    /**
     * Recupera il valore della propriet� dataCessazioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCessazioneREA() {
        return dataCessazioneREA;
    }

    /**
     * Imposta il valore della propriet� dataCessazioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCessazioneREA(String value) {
        this.dataCessazioneREA = value;
    }

    /**
     * Recupera il valore della propriet� dataDenunciaCessazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDenunciaCessazione() {
        return dataDenunciaCessazione;
    }

    /**
     * Imposta il valore della propriet� dataDenunciaCessazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDenunciaCessazione(String value) {
        this.dataDenunciaCessazione = value;
    }

    /**
     * Recupera il valore della propriet� dataDenunciaCessazioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDenunciaCessazioneREA() {
        return dataDenunciaCessazioneREA;
    }

    /**
     * Imposta il valore della propriet� dataDenunciaCessazioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDenunciaCessazioneREA(String value) {
        this.dataDenunciaCessazioneREA = value;
    }

    /**
     * Recupera il valore della propriet� descrCausaleCessazioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCausaleCessazioneREA() {
        return descrCausaleCessazioneREA;
    }

    /**
     * Imposta il valore della propriet� descrCausaleCessazioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCausaleCessazioneREA(String value) {
        this.descrCausaleCessazioneREA = value;
    }

    /**
     * Recupera il valore della propriet� descrStatoEstero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrStatoEstero() {
        return descrStatoEstero;
    }

    /**
     * Imposta il valore della propriet� descrStatoEstero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrStatoEstero(String value) {
        this.descrStatoEstero = value;
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

    /**
     * Recupera il valore della propriet� numIscrizREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumIscrizREA() {
        return numIscrizREA;
    }

    /**
     * Imposta il valore della propriet� numIscrizREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumIscrizREA(String value) {
        this.numIscrizREA = value;
    }

    /**
     * Recupera il valore della propriet� siglaProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProv() {
        return siglaProv;
    }

    /**
     * Imposta il valore della propriet� siglaProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProv(String value) {
        this.siglaProv = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvCCIAA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvCCIAA() {
        return siglaProvCCIAA;
    }

    /**
     * Imposta il valore della propriet� siglaProvCCIAA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvCCIAA(String value) {
        this.siglaProvCCIAA = value;
    }

}
