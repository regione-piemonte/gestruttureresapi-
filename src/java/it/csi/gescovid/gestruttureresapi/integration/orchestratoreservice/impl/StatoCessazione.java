/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per statoCessazione.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="statoCessazione">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NON_CESSATA"/>
 *     &lt;enumeration value="CESSATA"/>
 *     &lt;enumeration value="NON_DEFINITO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statoCessazione")
@XmlEnum
public enum StatoCessazione {

    NON_CESSATA,
    CESSATA,
    NON_DEFINITO;

    public String value() {
        return name();
    }

    public static StatoCessazione fromValue(String v) {
        return valueOf(v);
    }

}
