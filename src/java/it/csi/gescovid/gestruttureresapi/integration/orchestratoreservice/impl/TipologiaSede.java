/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per tipologiaSede.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipologiaSede">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SEDE_LEGALE"/>
 *     &lt;enumeration value="UNITA_LOCALE"/>
 *     &lt;enumeration value="SEDE_CORRISPONDENZA"/>
 *     &lt;enumeration value="DOMICILIO_FISCALE"/>
 *     &lt;enumeration value="UNITA_TECNICA"/>
 *     &lt;enumeration value="SEDE_SECONDARIA"/>
 *     &lt;enumeration value="SEDE_OCCASIONALE"/>
 *     &lt;enumeration value="SEDE_AMMINISTRATIVA"/>
 *     &lt;enumeration value="SEDE_NON_CODIFICATA_ALLA_FONTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipologiaSede")
@XmlEnum
public enum TipologiaSede {

    SEDE_LEGALE,
    UNITA_LOCALE,
    SEDE_CORRISPONDENZA,
    DOMICILIO_FISCALE,
    UNITA_TECNICA,
    SEDE_SECONDARIA,
    SEDE_OCCASIONALE,
    SEDE_AMMINISTRATIVA,
    SEDE_NON_CODIFICATA_ALLA_FONTE;

    public String value() {
        return name();
    }

    public static TipologiaSede fromValue(String v) {
        return valueOf(v);
    }

}
