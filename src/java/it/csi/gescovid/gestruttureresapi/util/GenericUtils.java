/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.util;

import java.util.List;

import it.csi.gescovid.gestruttureresapi.util.genericinterface.ListInterface;

public class GenericUtils {

    public static long getTotalCountFromList(List<? extends ListInterface> result) {
        return (result != null && !result.isEmpty() && result.get(0).getTotalCount() != null)
                ? result.get(0).getTotalCount()
                : 0L;
    }

}
