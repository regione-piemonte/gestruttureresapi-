/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.org.openehealth.ipf.xds;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DocumentAvailability.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentAvailability">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Offline"/>
 *     &lt;enumeration value="Online"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocumentAvailability")
@XmlEnum
public enum DocumentAvailability {

    @XmlEnumValue("Offline")
    OFFLINE("Offline"),
    @XmlEnumValue("Online")
    ONLINE("Online");
    private final String value;

    DocumentAvailability(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DocumentAvailability fromValue(String v) {
        for (DocumentAvailability c: DocumentAvailability.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
