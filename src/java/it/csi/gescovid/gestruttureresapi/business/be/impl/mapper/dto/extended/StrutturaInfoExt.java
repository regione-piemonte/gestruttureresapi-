/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.StrutturaInfo;

public class StrutturaInfoExt extends StrutturaInfo {
    
    @JsonProperty("Ente")
    private String nomeEnte;

    @JsonProperty("idEnte")
    private String idEnte;
	
	@JsonProperty("Comune")
	private String comune;

	@JsonProperty("Tipo utenza")
	private String tipoUtenzaDesc;
	
	@JsonProperty("Natrura")
	private String naturaDesc;
	
	@JsonProperty("Tipo struttura")
	private String tipoStrutturaDesc;
	
	@JsonProperty("Accreditamento")
	private String accreditamentoDesc;
	
	@JsonProperty("Categoria")
	private String strCategoriaDesc;
	
	@JsonIgnore
	private String accreditamentoCod;
	
	@JsonIgnore
	private Integer strCategoriaId;
	
	@JsonIgnore
	private Integer fullCount;

    @JsonIgnore
    private String siglaProv;
    
    @JsonIgnore
    private Boolean adesioneBuonoWelfare;

	@JsonIgnore
	List<StrutturaCategoriaInfo> categorie;
	
	@JsonIgnore
	private List<RsaPostiExt> posti;
	
	@JsonIgnore
	private List<RsaPersonaleExt> personale;

    @JsonIgnore
	private List<RsaTamponiExt> tamponi;
	
	@JsonIgnore
	private List<RsaCovidExt> ospiti;
	
	@JsonIgnore
	private List<RsaDecessiExt> decessi;
	
	@JsonIgnore
	private List<RsaVisitatoriExt> visitatori;
	
	public String getTipoUtenzaDesc() {
		return tipoUtenzaDesc;
	}
	public void setTipoUtenzaDesc(String tipoUtenzaDesc) {
		this.tipoUtenzaDesc = tipoUtenzaDesc;
	}
	public String getNomeEnte() {
		return nomeEnte;
	}
	public void setNomeEnte(String nomeEnte) {
		this.nomeEnte = nomeEnte;
	}
	public String getNaturaDesc() {
		return naturaDesc;
	}
	public void setNaturaDesc(String naturaDesc) {
		this.naturaDesc = naturaDesc;
	}
	public String getTipoStrutturaDesc() {
		return tipoStrutturaDesc;
	}
	public void setTipoStrutturaDesc(String tipoStrutturaDesc) {
		this.tipoStrutturaDesc = tipoStrutturaDesc;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getAccreditamentoCod() {
		return accreditamentoCod;
	}
	public void setAccreditamentoCod(String accreditamentoCod) {
		this.accreditamentoCod = accreditamentoCod;
	}
	public String getAccreditamentoDesc() {
		return accreditamentoDesc;
	}
	public void setAccreditamentoDesc(String accreditamentoDesc) {
		this.accreditamentoDesc = accreditamentoDesc;
	}
	public Integer getStrCategoriaId() {
		return strCategoriaId;
	}
	public void setStrCategoriaId(Integer strCategoriaId) {
		this.strCategoriaId = strCategoriaId;
	}
	public List<RsaPostiExt> getPosti() {
		return posti;
	}
	public void setPosti(List<RsaPostiExt> posti) {
		this.posti = posti;
	}
	public List<RsaPersonaleExt> getPersonale() {
		return personale;
	}
	public void setPersonale(List<RsaPersonaleExt> personale) {
		this.personale = personale;
	}
	public List<RsaCovidExt> getOspiti() {
		return ospiti;
	}
	public void setOspiti(List<RsaCovidExt> ospiti) {
		this.ospiti = ospiti;
	}
	public List<RsaDecessiExt> getDecessi() {
		return decessi;
	}
	public void setDecessi(List<RsaDecessiExt> decessi) {
		this.decessi = decessi;
	}
	public String getStrCategoriaDesc() {
		return strCategoriaDesc;
	}
	public void setStrCategoriaDesc(String strCategoriaDesc) {
		this.strCategoriaDesc = strCategoriaDesc;
	}
	public Integer getFullCount() {
		return fullCount;
	}
	public void setFullCount(Integer fullCount) {
		this.fullCount = fullCount;
	}
	public List<StrutturaCategoriaInfo> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<StrutturaCategoriaInfo> categorie) {
		this.categorie = categorie;
	}
	public List<RsaVisitatoriExt> getVisitatori() {
		return visitatori;
	}
	public void setVisitatori(List<RsaVisitatoriExt> visitatori) {
		this.visitatori = visitatori;
	}
    public String getIdEnte() {
        return idEnte;
    }
    public void setIdEnte(String idEnte) {
        this.idEnte = idEnte;
    }
    public String getSiglaProv() {
        return siglaProv;
    }
    public void setSiglaProv(String siglaProv) {
        this.siglaProv = siglaProv;
    }
    public List<RsaTamponiExt> getTamponi() {
        return tamponi;
    }
    public void setTamponi(List<RsaTamponiExt> tamponi) {
        this.tamponi = tamponi;
    }
    public Boolean getAdesioneBuonoWelfare() {
        return adesioneBuonoWelfare;
    }
    public void setAdesioneBuonoWelfare(Boolean adesioneBuonoWelfare) {
        this.adesioneBuonoWelfare = adesioneBuonoWelfare;
    }
	
	
}
