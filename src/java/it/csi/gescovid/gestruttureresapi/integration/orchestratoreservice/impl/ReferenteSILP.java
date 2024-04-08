/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per referenteSILP complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="referenteSILP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}persona">
 *       &lt;sequence>
 *         &lt;element name="contatti" type="{http://business.aaeporch.aaep.csi.it/}contatti" minOccurs="0"/>
 *         &lt;element name="dataAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAggiornamentoSILP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "referenteSILP", propOrder = {
    "contatti",
    "dataAggiornamento",
    "dataAggiornamentoSILP",
    "ruolo"
})
public class ReferenteSILP
    extends Persona
{

    protected Contatti contatti;
    protected String dataAggiornamento;
    protected String dataAggiornamentoSILP;
    protected String ruolo;

    /**
     * Recupera il valore della propriet� contatti.
     * 
     * @return
     *     possible object is
     *     {@link Contatti }
     *     
     */
    public Contatti getContatti() {
        return contatti;
    }

    /**
     * Imposta il valore della propriet� contatti.
     * 
     * @param value
     *     allowed object is
     *     {@link Contatti }
     *     
     */
    public void setContatti(Contatti value) {
        this.contatti = value;
    }

    /**
     * Recupera il valore della propriet� dataAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Imposta il valore della propriet� dataAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAggiornamento(String value) {
        this.dataAggiornamento = value;
    }

    /**
     * Recupera il valore della propriet� dataAggiornamentoSILP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAggiornamentoSILP() {
        return dataAggiornamentoSILP;
    }

    /**
     * Imposta il valore della propriet� dataAggiornamentoSILP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAggiornamentoSILP(String value) {
        this.dataAggiornamentoSILP = value;
    }

    /**
     * Recupera il valore della propriet� ruolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuolo() {
        return ruolo;
    }

    /**
     * Imposta il valore della propriet� ruolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuolo(String value) {
        this.ruolo = value;
    }

}
