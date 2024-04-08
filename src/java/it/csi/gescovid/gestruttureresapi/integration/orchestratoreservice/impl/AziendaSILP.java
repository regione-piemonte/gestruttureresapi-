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
 * <p>Classe Java per aziendaSILP complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="aziendaSILP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://business.aaeporch.aaep.csi.it/}impresa">
 *       &lt;sequence>
 *         &lt;element name="annoRiferimentoNumDipendenti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCCNLMinistero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCCNLSILP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNaturaGiuridicaSILP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiciATECOSILP" type="{http://business.aaeporch.aaep.csi.it/}attivitaEconomica" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataAcquisizioneAAEP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAggiornamGeneraleAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAggiornamentoSILP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCCNLMinistero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCCNLSILP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrNaturaGiuridicaSILP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flgAziendaArtigiana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProspDisabRiferim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaProspDisab" type="{http://business.aaeporch.aaep.csi.it/}prospettoInformativoDisabile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numDipendenti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aziendaSILP", propOrder = {
    "annoRiferimentoNumDipendenti",
    "codCCNLMinistero",
    "codCCNLSILP",
    "codNaturaGiuridicaSILP",
    "codiciATECOSILP",
    "dataAcquisizioneAAEP",
    "dataAggiornamGeneraleAzienda",
    "dataAggiornamentoSILP",
    "dataInvio",
    "descrCCNLMinistero",
    "descrCCNLSILP",
    "descrNaturaGiuridicaSILP",
    "flgAziendaArtigiana",
    "idProspDisabRiferim",
    "listaProspDisab",
    "numDipendenti"
})
public class AziendaSILP
    extends Impresa
{

    protected String annoRiferimentoNumDipendenti;
    protected String codCCNLMinistero;
    protected String codCCNLSILP;
    protected String codNaturaGiuridicaSILP;
    @XmlElement(nillable = true)
    protected List<AttivitaEconomica> codiciATECOSILP;
    protected String dataAcquisizioneAAEP;
    protected String dataAggiornamGeneraleAzienda;
    protected String dataAggiornamentoSILP;
    protected String dataInvio;
    protected String descrCCNLMinistero;
    protected String descrCCNLSILP;
    protected String descrNaturaGiuridicaSILP;
    protected String flgAziendaArtigiana;
    protected String idProspDisabRiferim;
    @XmlElement(nillable = true)
    protected List<ProspettoInformativoDisabile> listaProspDisab;
    protected String numDipendenti;

    /**
     * Recupera il valore della propriet� annoRiferimentoNumDipendenti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoRiferimentoNumDipendenti() {
        return annoRiferimentoNumDipendenti;
    }

    /**
     * Imposta il valore della propriet� annoRiferimentoNumDipendenti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoRiferimentoNumDipendenti(String value) {
        this.annoRiferimentoNumDipendenti = value;
    }

    /**
     * Recupera il valore della propriet� codCCNLMinistero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCCNLMinistero() {
        return codCCNLMinistero;
    }

    /**
     * Imposta il valore della propriet� codCCNLMinistero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCCNLMinistero(String value) {
        this.codCCNLMinistero = value;
    }

    /**
     * Recupera il valore della propriet� codCCNLSILP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCCNLSILP() {
        return codCCNLSILP;
    }

    /**
     * Imposta il valore della propriet� codCCNLSILP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCCNLSILP(String value) {
        this.codCCNLSILP = value;
    }

    /**
     * Recupera il valore della propriet� codNaturaGiuridicaSILP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNaturaGiuridicaSILP() {
        return codNaturaGiuridicaSILP;
    }

    /**
     * Imposta il valore della propriet� codNaturaGiuridicaSILP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNaturaGiuridicaSILP(String value) {
        this.codNaturaGiuridicaSILP = value;
    }

    /**
     * Gets the value of the codiciATECOSILP property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codiciATECOSILP property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodiciATECOSILP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttivitaEconomica }
     * 
     * 
     */
    public List<AttivitaEconomica> getCodiciATECOSILP() {
        if (codiciATECOSILP == null) {
            codiciATECOSILP = new ArrayList<AttivitaEconomica>();
        }
        return this.codiciATECOSILP;
    }

    /**
     * Recupera il valore della propriet� dataAcquisizioneAAEP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAcquisizioneAAEP() {
        return dataAcquisizioneAAEP;
    }

    /**
     * Imposta il valore della propriet� dataAcquisizioneAAEP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAcquisizioneAAEP(String value) {
        this.dataAcquisizioneAAEP = value;
    }

    /**
     * Recupera il valore della propriet� dataAggiornamGeneraleAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAggiornamGeneraleAzienda() {
        return dataAggiornamGeneraleAzienda;
    }

    /**
     * Imposta il valore della propriet� dataAggiornamGeneraleAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAggiornamGeneraleAzienda(String value) {
        this.dataAggiornamGeneraleAzienda = value;
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
     * Recupera il valore della propriet� dataInvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInvio() {
        return dataInvio;
    }

    /**
     * Imposta il valore della propriet� dataInvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInvio(String value) {
        this.dataInvio = value;
    }

    /**
     * Recupera il valore della propriet� descrCCNLMinistero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCCNLMinistero() {
        return descrCCNLMinistero;
    }

    /**
     * Imposta il valore della propriet� descrCCNLMinistero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCCNLMinistero(String value) {
        this.descrCCNLMinistero = value;
    }

    /**
     * Recupera il valore della propriet� descrCCNLSILP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCCNLSILP() {
        return descrCCNLSILP;
    }

    /**
     * Imposta il valore della propriet� descrCCNLSILP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCCNLSILP(String value) {
        this.descrCCNLSILP = value;
    }

    /**
     * Recupera il valore della propriet� descrNaturaGiuridicaSILP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrNaturaGiuridicaSILP() {
        return descrNaturaGiuridicaSILP;
    }

    /**
     * Imposta il valore della propriet� descrNaturaGiuridicaSILP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrNaturaGiuridicaSILP(String value) {
        this.descrNaturaGiuridicaSILP = value;
    }

    /**
     * Recupera il valore della propriet� flgAziendaArtigiana.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgAziendaArtigiana() {
        return flgAziendaArtigiana;
    }

    /**
     * Imposta il valore della propriet� flgAziendaArtigiana.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgAziendaArtigiana(String value) {
        this.flgAziendaArtigiana = value;
    }

    /**
     * Recupera il valore della propriet� idProspDisabRiferim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProspDisabRiferim() {
        return idProspDisabRiferim;
    }

    /**
     * Imposta il valore della propriet� idProspDisabRiferim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProspDisabRiferim(String value) {
        this.idProspDisabRiferim = value;
    }

    /**
     * Gets the value of the listaProspDisab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaProspDisab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaProspDisab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProspettoInformativoDisabile }
     * 
     * 
     */
    public List<ProspettoInformativoDisabile> getListaProspDisab() {
        if (listaProspDisab == null) {
            listaProspDisab = new ArrayList<ProspettoInformativoDisabile>();
        }
        return this.listaProspDisab;
    }

    /**
     * Recupera il valore della propriet� numDipendenti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDipendenti() {
        return numDipendenti;
    }

    /**
     * Imposta il valore della propriet� numDipendenti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDipendenti(String value) {
        this.numDipendenti = value;
    }

}
