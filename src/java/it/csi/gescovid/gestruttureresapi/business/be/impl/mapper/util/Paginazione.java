/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import it.csi.gescovid.gestruttureresapi.exception.ErroreBuilder;

public class Paginazione {
    private String orderBy;
    private Long offset;
    private Long limit = -1L;
    private Boolean descending = false;
    
    public Paginazione(String orderby, Long rowsPerPage, Long pageNumber, Boolean descending) {
        super();
        this.limit = -1L;
        this.offset = 0L;
        this.descending = Boolean.TRUE.equals(descending);
        this.orderBy = getOrderByClause(orderby);




        if (rowsPerPage != null && rowsPerPage != -1L) {
            if (pageNumber == null || pageNumber <= 0) {
                pageNumber = 1L;
            }
            this.limit = rowsPerPage;
            this.offset = (pageNumber - 1) * rowsPerPage;
        }
    }
    
    private String orderAscDesc(String orderBy) {
        if(StringUtils.isBlank(orderBy)){
            return "";
        }
        return isDescending()? "DESC": "ASC";
    }
    
    private String getOrderByClause(String orderBy) {
        if(StringUtils.isBlank(orderBy)){
            return null;
        }        
        if(orderBy.contains(" ")) {
            throw ErroreBuilder.from(Status.BAD_REQUEST).descrizione("OrderBy non conforme").exception();
        }
        String[] orderBySplitted = orderBy.split(",");
        String clause = "";
        for(String s: orderBySplitted) {
            clause = clause + s + " " + orderAscDesc(orderBy) + ",";
        }
        clause = clause.substring(0, clause.length()-1);
        return clause;    
    }



   public boolean isDescending() {
        return descending;
    }



   public String getOrderBy() {
        return orderBy;
    }



   public Long getOffset() {
        return offset;
    }



   public Long getLimit() {
        return limit;
    }
}
