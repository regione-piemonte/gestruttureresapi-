/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/

package it.csi.gescovid.gestruttureresapi.integration.orchestratoreservice.impl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per tipologiaFonte.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipologiaFonte">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INFOC"/>
 *     &lt;enumeration value="AAEP"/>
 *     &lt;enumeration value="INAIL"/>
 *     &lt;enumeration value="TRIBUTI"/>
 *     &lt;enumeration value="SILP"/>
 *     &lt;enumeration value="FP"/>
 *     &lt;enumeration value="SIAP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipologiaFonte")
@XmlEnum
public enum TipologiaFonte {

    INFOC,
    AAEP,
    INAIL,
    TRIBUTI,
    SILP,
    FP,
    SIAP;

    public String value() {
        return name();
    }

    public static TipologiaFonte fromValue(String v) {
        return valueOf(v);
    }

}
