/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per denunciaAttivita complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="denunciaAttivita">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceEnte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDenunciaInizioAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrEnte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDenuncia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "denunciaAttivita", propOrder = {
    "codiceEnte",
    "dataDenunciaInizioAttivita",
    "descrEnte",
    "idDenuncia"
})
public class DenunciaAttivita {

    protected String codiceEnte;
    protected String dataDenunciaInizioAttivita;
    protected String descrEnte;
    protected String idDenuncia;

    /**
     * Recupera il valore della propriet� codiceEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceEnte() {
        return codiceEnte;
    }

    /**
     * Imposta il valore della propriet� codiceEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceEnte(String value) {
        this.codiceEnte = value;
    }

    /**
     * Recupera il valore della propriet� dataDenunciaInizioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDenunciaInizioAttivita() {
        return dataDenunciaInizioAttivita;
    }

    /**
     * Imposta il valore della propriet� dataDenunciaInizioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDenunciaInizioAttivita(String value) {
        this.dataDenunciaInizioAttivita = value;
    }

    /**
     * Recupera il valore della propriet� descrEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrEnte() {
        return descrEnte;
    }

    /**
     * Imposta il valore della propriet� descrEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrEnte(String value) {
        this.descrEnte = value;
    }

    /**
     * Recupera il valore della propriet� idDenuncia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDenuncia() {
        return idDenuncia;
    }

    /**
     * Imposta il valore della propriet� idDenuncia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDenuncia(String value) {
        this.idDenuncia = value;
    }

}
