/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.org.openehealth.ipf.xds.Identifiable;


/**
 * <p>Classe Java per DocumentEntry complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DocumentEntry">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.openehealth.org/ipf/xds}DocumentEntry">
 *       &lt;sequence>
 *         &lt;element name="sourcePatientIdList" type="{http://www.openehealth.org/ipf/xds}Identifiable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="extSourcePatientInfo" type="{http://www.csi.it/gatefire/}PatientInfoExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentEntry", propOrder = {
    "sourcePatientIdList",
    "extSourcePatientInfo"
})
public class DocumentEntry
    extends it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.org.openehealth.ipf.xds.DocumentEntry
{

    @XmlElement(nillable = true)
    protected List<Identifiable> sourcePatientIdList;
    protected PatientInfoExt extSourcePatientInfo;

    /**
     * Gets the value of the sourcePatientIdList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourcePatientIdList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourcePatientIdList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Identifiable }
     * 
     * 
     */
    public List<Identifiable> getSourcePatientIdList() {
        if (sourcePatientIdList == null) {
            sourcePatientIdList = new ArrayList<Identifiable>();
        }
        return this.sourcePatientIdList;
    }

    /**
     * Recupera il valore della propriet� extSourcePatientInfo.
     * 
     * @return
     *     possible object is
     *     {@link PatientInfoExt }
     *     
     */
    public PatientInfoExt getExtSourcePatientInfo() {
        return extSourcePatientInfo;
    }

    /**
     * Imposta il valore della propriet� extSourcePatientInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientInfoExt }
     *     
     */
    public void setExtSourcePatientInfo(PatientInfoExt value) {
        this.extSourcePatientInfo = value;
    }

}
