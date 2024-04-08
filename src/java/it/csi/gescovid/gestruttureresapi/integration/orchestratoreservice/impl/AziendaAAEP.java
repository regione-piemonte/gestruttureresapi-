/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per aziendaAAEP complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="aziendaAAEP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}impresa">
 *       &lt;sequence>
 *         &lt;element name="dataCostituzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrStatoAttiv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idStatoAttiv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oggettoSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rappresentanteLegale" type="{http://business.aaeporch.aaep.csi.it/}rappresentanteLegale" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aziendaAAEP", propOrder = {
    "dataCostituzione",
    "descrStatoAttiv",
    "idStatoAttiv",
    "oggettoSociale",
    "rappresentanteLegale"
})
public class AziendaAAEP
    extends Impresa
{

    protected String dataCostituzione;
    protected String descrStatoAttiv;
    protected String idStatoAttiv;
    protected String oggettoSociale;
    protected RappresentanteLegale rappresentanteLegale;

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
     * Recupera il valore della propriet� descrStatoAttiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrStatoAttiv() {
        return descrStatoAttiv;
    }

    /**
     * Imposta il valore della propriet� descrStatoAttiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrStatoAttiv(String value) {
        this.descrStatoAttiv = value;
    }

    /**
     * Recupera il valore della propriet� idStatoAttiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdStatoAttiv() {
        return idStatoAttiv;
    }

    /**
     * Imposta il valore della propriet� idStatoAttiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdStatoAttiv(String value) {
        this.idStatoAttiv = value;
    }

    /**
     * Recupera il valore della propriet� oggettoSociale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOggettoSociale() {
        return oggettoSociale;
    }

    /**
     * Imposta il valore della propriet� oggettoSociale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOggettoSociale(String value) {
        this.oggettoSociale = value;
    }

    /**
     * Recupera il valore della propriet� rappresentanteLegale.
     * 
     * @return
     *     possible object is
     *     {@link RappresentanteLegale }
     *     
     */
    public RappresentanteLegale getRappresentanteLegale() {
        return rappresentanteLegale;
    }

    /**
     * Imposta il valore della propriet� rappresentanteLegale.
     * 
     * @param value
     *     allowed object is
     *     {@link RappresentanteLegale }
     *     
     */
    public void setRappresentanteLegale(RappresentanteLegale value) {
        this.rappresentanteLegale = value;
    }

}
