/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.Date;
import java.util.List;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;
import it.csi.gescovid.gestruttureresapi.util.genericinterface.ListInterface;

public class ModelStrutturaWelfare extends AbstractDto implements ListInterface {

    private Integer strWelfareId;
    private String idStruttura;
    private String strResNome;
    private String strResIndirizzo;
    private String strResComune;
    private String strResProvincia;
    private String entGestCfPiva;
    private Date dataAdesione;
    private Long totalCount;
    private String entGestComune;
    private String entGestIndirizzo;
    private String entGestProvincia;
    private String entGestRagioneSociale;
    private ModelStrutturaArpe  struttura;
    
    public String getEntGestComune() {
        return entGestComune;
    }
    public void setEntGestComune(String entGestComune) {
        this.entGestComune = entGestComune;
    }
    public String getEntGestIndirizzo() {
        return entGestIndirizzo;
    }
    public void setEntGestIndirizzo(String entGestIndirizzo) {
        this.entGestIndirizzo = entGestIndirizzo;
    }
    public String getEntGestProvincia() {
        return entGestProvincia;
    }
    public void setEntGestProvincia(String entGestProvincia) {
        this.entGestProvincia = entGestProvincia;
    }
    public Integer getStrWelfareId() {
        return strWelfareId;
    }
    public void setStrWelfareId(Integer strWelfareId) {
        this.strWelfareId = strWelfareId;
    }
    public String getIdStruttura() {
        return idStruttura;
    }
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }
    public String getStrResNome() {
        return strResNome;
    }
    public void setStrResNome(String strResNome) {
        this.strResNome = strResNome;
    }
    public String getStrResIndirizzo() {
        return strResIndirizzo;
    }
    public void setStrResIndirizzo(String strResIndirizzo) {
        this.strResIndirizzo = strResIndirizzo;
    }
    public String getStrResComune() {
        return strResComune;
    }
    public void setStrResComune(String strResComune) {
        this.strResComune = strResComune;
    }
    public String getStrResProvincia() {
        return strResProvincia;
    }
    public void setStrResProvincia(String strResProvincia) {
        this.strResProvincia = strResProvincia;
    }
    public String getEntGestCfPiva() {
        return entGestCfPiva;
    }
    public void setEntGestCfPiva(String entGestCfPiva) {
        this.entGestCfPiva = entGestCfPiva;
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
    public Date getDataAdesione() {
        return dataAdesione;
    }
    public void setDataAdesione(Date dataAdesione) {
        this.dataAdesione = dataAdesione;
    }
    public ModelStrutturaArpe getStruttura() {
        return struttura;
    }
    public void setStruttura(ModelStrutturaArpe struttura) {
        this.struttura = struttura;
    }
    public String getEntGestRagioneSociale() {
        return entGestRagioneSociale;
    }
    public void setEntGestRagioneSociale(String entGestRagioneSociale) {
        this.entGestRagioneSociale = entGestRagioneSociale;
    }
}
