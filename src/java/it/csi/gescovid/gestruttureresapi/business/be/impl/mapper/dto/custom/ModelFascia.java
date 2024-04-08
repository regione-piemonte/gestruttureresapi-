/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.math.BigDecimal;
import java.math.BigInteger;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;

public class ModelFascia extends AbstractDto {
    private Integer strWelfFasciaId;
    private Integer welfareFasciaId;
    private BigDecimal tariffaMensileMassima;
    private String welfareFasciaDesc;
    private String welfareFasciaCod;
    
    public Integer getStrWelfFasciaId() {
        return strWelfFasciaId;
    }
    public void setStrWelfFasciaId(Integer strWelfFasciaId) {
        this.strWelfFasciaId = strWelfFasciaId;
    }
    public Integer getWelfareFasciaId() {
        return welfareFasciaId;
    }
    public void setWelfareFasciaId(Integer welfareFasciaId) {
        this.welfareFasciaId = welfareFasciaId;
    }
    public String getWelfareFasciaDesc() {
        return welfareFasciaDesc;
    }
    public void setWelfareFasciaDesc(String welfareFasciaDesc) {
        this.welfareFasciaDesc = welfareFasciaDesc;
    }
    public BigDecimal getTariffaMensileMassima() {
        return tariffaMensileMassima;
    }
    public void setTariffaMensileMassima(BigDecimal tariffaMensileMassima) {
        this.tariffaMensileMassima = tariffaMensileMassima;
    }
    public String getWelfareFasciaCod() {
        return welfareFasciaCod;
    }
    public void setWelfareFasciaCod(String welfareFasciaCod) {
        this.welfareFasciaCod = welfareFasciaCod;
    }
}
