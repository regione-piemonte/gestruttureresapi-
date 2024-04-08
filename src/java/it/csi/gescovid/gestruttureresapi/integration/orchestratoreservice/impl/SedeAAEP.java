/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per sedeAAEP complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="sedeAAEP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}sede">
 *       &lt;sequence>
 *         &lt;element name="codSedeInailComp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizioneAttivitaSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvUL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sedeAAEP", propOrder = {
    "codSedeInailComp",
    "descrizioneAttivitaSede",
    "siglaProvUL"
})
public class SedeAAEP
    extends Sede
{

    protected String codSedeInailComp;
    protected String descrizioneAttivitaSede;
    protected String siglaProvUL;

    /**
     * Recupera il valore della propriet� codSedeInailComp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSedeInailComp() {
        return codSedeInailComp;
    }

    /**
     * Imposta il valore della propriet� codSedeInailComp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSedeInailComp(String value) {
        this.codSedeInailComp = value;
    }

    /**
     * Recupera il valore della propriet� descrizioneAttivitaSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneAttivitaSede() {
        return descrizioneAttivitaSede;
    }

    /**
     * Imposta il valore della propriet� descrizioneAttivitaSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneAttivitaSede(String value) {
        this.descrizioneAttivitaSede = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvUL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvUL() {
        return siglaProvUL;
    }

    /**
     * Imposta il valore della propriet� siglaProvUL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvUL(String value) {
        this.siglaProvUL = value;
    }

}
