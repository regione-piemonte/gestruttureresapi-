/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per operatoreFormazioneProfessionale complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="operatoreFormazioneProfessionale">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}impresa">
 *       &lt;sequence>
 *         &lt;element name="codGruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTipoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrGruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrTipoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operatoreFormazioneProfessionale", propOrder = {
    "codGruppoOperatore",
    "codOperatore",
    "codTipoOperatore",
    "descrGruppoOperatore",
    "descrTipoOperatore"
})
public class OperatoreFormazioneProfessionale
    extends Impresa
{

    protected String codGruppoOperatore;
    protected String codOperatore;
    protected String codTipoOperatore;
    protected String descrGruppoOperatore;
    protected String descrTipoOperatore;

    /**
     * Recupera il valore della propriet� codGruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodGruppoOperatore() {
        return codGruppoOperatore;
    }

    /**
     * Imposta il valore della propriet� codGruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodGruppoOperatore(String value) {
        this.codGruppoOperatore = value;
    }

    /**
     * Recupera il valore della propriet� codOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodOperatore() {
        return codOperatore;
    }

    /**
     * Imposta il valore della propriet� codOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodOperatore(String value) {
        this.codOperatore = value;
    }

    /**
     * Recupera il valore della propriet� codTipoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoOperatore() {
        return codTipoOperatore;
    }

    /**
     * Imposta il valore della propriet� codTipoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoOperatore(String value) {
        this.codTipoOperatore = value;
    }

    /**
     * Recupera il valore della propriet� descrGruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrGruppoOperatore() {
        return descrGruppoOperatore;
    }

    /**
     * Imposta il valore della propriet� descrGruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrGruppoOperatore(String value) {
        this.descrGruppoOperatore = value;
    }

    /**
     * Recupera il valore della propriet� descrTipoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTipoOperatore() {
        return descrTipoOperatore;
    }

    /**
     * Imposta il valore della propriet� descrTipoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTipoOperatore(String value) {
        this.descrTipoOperatore = value;
    }

}
