/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom;

import java.util.Date;
import java.util.List;

import it.csi.gescovid.gestruttureresapi.util.genericinterface.ListInterface;

public class CovidrsaTIntegrazionePbandiBo implements ListInterface {
    private Integer invioPbandiId;
    private Integer integrazionePbandiId;
    private String idStruttura;
    private String strResNome;
    private String noteRichiesta;
    private Date dataRichiesta;
    private Date dataRisposta;
    private Date periodoInizio;
    private Date periodoFine;
    private Date dataScadenza;
    private List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> file;
    private Long totalCount;
    
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getInvioPbandiId() {
        return invioPbandiId;
    }

    public void setInvioPbandiId(Integer invioPbandiId) {
        this.invioPbandiId = invioPbandiId;
    }

    public Integer getIntegrazionePbandiId() {
        return integrazionePbandiId;
    }

    public void setIntegrazionePbandiId(Integer integrazionePbandiId) {
        this.integrazionePbandiId = integrazionePbandiId;
    }

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public Date getDataRisposta() {
        return dataRisposta;
    }

    public void setDataRisposta(Date dataRisposta) {
        this.dataRisposta = dataRisposta;
    }

    public Date getPeriodoInizio() {
        return periodoInizio;
    }

    public void setPeriodoInizio(Date periodoInizio) {
        this.periodoInizio = periodoInizio;
    }

    public Date getPeriodoFine() {
        return periodoFine;
    }

    public void setPeriodoFine(Date periodoFine) {
        this.periodoFine = periodoFine;
    }

    public List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> getFile() {
        return file;
    }

    public void setFile(List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> file) {
        this.file = file;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getNoteRichiesta() {
        return noteRichiesta;
    }

    public void setNoteRichiesta(String noteRichiesta) {
        this.noteRichiesta = noteRichiesta;
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
}
