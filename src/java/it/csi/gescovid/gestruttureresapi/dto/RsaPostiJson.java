/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RsaPostiJson {
	
	@JsonProperty("Struttura")
	private String nomeStruttura;
	
	@JsonProperty("Data rilevazione")
	private String dataRilevazioneString;
	
	@JsonProperty("Tipo struttura")
	private String tipologiaStrutturaDesc;
	
	@JsonProperty("Dati validi")
	private String datiValidi;

    @JsonProperty("Posti liberi")
    private Integer postiNumLiberi;
	
	@JsonProperty("Posti occupati")
	private Integer postiNumOccupati;
    
    @JsonProperty("Posti occupati convenzionati")
    private Integer postiNumOccupatiConvenzionati;
    
    @JsonProperty("Posti occupati paganti")
    private Integer postiNumOccupatiPaganti;
    
    @JsonProperty("Posti occupanti paganti scelta sociale")
    private Integer postiNumOccupatiPagantiSs;

    @JsonProperty("Posti sollievo occupati")
    private Integer postiNumSollievoOccupati;

    @JsonProperty("Posti sollievo liberi")
    private Integer postiNumSollievoLiberi;

    @JsonProperty("Posti sollievo liberi uomini")
    private Integer postiNumSollievoLiberiUomini;

    @JsonProperty("Posti sollievo liberi donne")
    private Integer postiNumSollievoLiberiDonne;

    @JsonProperty("Posti sollievo liberi indifferenti")
    private Integer postiNumSollievoLiberiIndiff;

    @JsonProperty("Posti dimissioni protette occupati")
    private Integer postiNumDimProtOccupati;

    @JsonProperty("Posti dimissioni protette liberi")
    private Integer postiNumDimProtLiberi;

    @JsonProperty("Posti dimissioni protette liberi uomini")
    private Integer postiNumDimProtLiberiUomini;

    @JsonProperty("Posti dimissioni protette liberi donne")
    private Integer postiNumDimProtLiberiDonne;

    @JsonProperty("Posti dimissioni protette liberi indifferenti")
    private Integer postiNumDimProtLiberiIndiff;

    @JsonProperty("Posti CAVS occupati")
    private Integer postiNumCavsOccupati;

    @JsonProperty("Posti CAVS liberi")
    private Integer postiNumCavsLiberi;

    @JsonProperty("Posti CAVS liberi uomini")
    private Integer postiNumCavsLiberiUomini;

    @JsonProperty("Posti CAVS liberi donne")
    private Integer postiNumCavsLiberiDonne;

    @JsonProperty("Posti CAVS liberi indifferenti")
    private Integer postiNumCavsLiberiIndiff;

    @JsonProperty("Posti LD occupati")
    private Integer postiNumLungodegOccupati;

    @JsonProperty("Posti LD liberi")
    private Integer postiNumLungodegLiberi;

    @JsonProperty("Posti LD liberi uomini")
    private Integer postiNumLungodegLiberiUomini;

    @JsonProperty("Posti LD liberi donne")
    private Integer postiNumLungodegLiberiDonne;

    @JsonProperty("Posti LD liberi indifferenti")
    private Integer postiNumLungodegLiberiIndiff;

    @JsonProperty("Posti HOSPICE occupati")
    private Integer postiNumHospiceOccupati;

    @JsonProperty("Posti HOSPICE liberi")
    private Integer postiNumHospiceLiberi;

    @JsonProperty("Posti HOSPICE liberi uomini")
    private Integer postiNumHospiceLiberiUomini;

    @JsonProperty("Posti HOSPICE liberi donne")
    private Integer postiNumHospiceLiberiDonne;

    @JsonProperty("Posti HOSPICE liberi indifferenti")
    private Integer postiNumHospiceLiberiIndiff;

    @JsonProperty("Ospedalizzati")
    private Integer postiNumOspedalizzati;
    
    @JsonProperty("Invii in PS")
    private Integer accessiInPsNum;
    
    @JsonProperty("Camere singole totali")
    private Integer postiNumTotaliSingole;

    @JsonProperty("Camere singole libere")
    private Integer postiNumSingoleResidue;

    @JsonProperty("Posti liberi uomini")
    private Integer postiNumLiberiUomini;

    @JsonProperty("Posti liberi donne")
    private Integer postiNumLiberiDonne;

    @JsonProperty("Posti liberi indifferenti")
    private Integer postiNumLiberiIndiff;

	

    
	public Integer getPostiNumLiberi() {
        return postiNumLiberi;
    }


    public void setPostiNumLiberi(Integer postiNumLiberi) {
        this.postiNumLiberi = postiNumLiberi;
    }


    public Integer getPostiNumOccupatiPagantiSs() {
        return postiNumOccupatiPagantiSs;
    }


    public void setPostiNumOccupatiPagantiSs(Integer postiNumOccupatiPagantiSs) {
        this.postiNumOccupatiPagantiSs = postiNumOccupatiPagantiSs;
    }


    public Integer getPostiNumSollievoOccupati() {
        return postiNumSollievoOccupati;
    }


    public void setPostiNumSollievoOccupati(Integer postiNumSollievoOccupati) {
        this.postiNumSollievoOccupati = postiNumSollievoOccupati;
    }


    public Integer getPostiNumSollievoLiberi() {
        return postiNumSollievoLiberi;
    }


    public void setPostiNumSollievoLiberi(Integer postiNumSollievoLiberi) {
        this.postiNumSollievoLiberi = postiNumSollievoLiberi;
    }


    public Integer getPostiNumSollievoLiberiUomini() {
        return postiNumSollievoLiberiUomini;
    }


    public void setPostiNumSollievoLiberiUomini(Integer postiNumSollievoLiberiUomini) {
        this.postiNumSollievoLiberiUomini = postiNumSollievoLiberiUomini;
    }


    public Integer getPostiNumSollievoLiberiDonne() {
        return postiNumSollievoLiberiDonne;
    }


    public void setPostiNumSollievoLiberiDonne(Integer postiNumSollievoLiberiDonne) {
        this.postiNumSollievoLiberiDonne = postiNumSollievoLiberiDonne;
    }


    public Integer getPostiNumSollievoLiberiIndiff() {
        return postiNumSollievoLiberiIndiff;
    }


    public void setPostiNumSollievoLiberiIndiff(Integer postiNumSollievoLiberiIndiff) {
        this.postiNumSollievoLiberiIndiff = postiNumSollievoLiberiIndiff;
    }


    public Integer getPostiNumDimProtOccupati() {
        return postiNumDimProtOccupati;
    }


    public void setPostiNumDimProtOccupati(Integer postiNumDimProtOccupati) {
        this.postiNumDimProtOccupati = postiNumDimProtOccupati;
    }


    public Integer getPostiNumDimProtLiberi() {
        return postiNumDimProtLiberi;
    }


    public void setPostiNumDimProtLiberi(Integer postiNumDimProtLiberi) {
        this.postiNumDimProtLiberi = postiNumDimProtLiberi;
    }


    public Integer getPostiNumDimProtLiberiUomini() {
        return postiNumDimProtLiberiUomini;
    }


    public void setPostiNumDimProtLiberiUomini(Integer postiNumDimProtLiberiUomini) {
        this.postiNumDimProtLiberiUomini = postiNumDimProtLiberiUomini;
    }


    public Integer getPostiNumDimProtLiberiDonne() {
        return postiNumDimProtLiberiDonne;
    }


    public void setPostiNumDimProtLiberiDonne(Integer postiNumDimProtLiberiDonne) {
        this.postiNumDimProtLiberiDonne = postiNumDimProtLiberiDonne;
    }


    public Integer getPostiNumDimProtLiberiIndiff() {
        return postiNumDimProtLiberiIndiff;
    }


    public void setPostiNumDimProtLiberiIndiff(Integer postiNumDimProtLiberiIndiff) {
        this.postiNumDimProtLiberiIndiff = postiNumDimProtLiberiIndiff;
    }


    public Integer getPostiNumCavsOccupati() {
        return postiNumCavsOccupati;
    }


    public void setPostiNumCavsOccupati(Integer postiNumCavsOccupati) {
        this.postiNumCavsOccupati = postiNumCavsOccupati;
    }


    public Integer getPostiNumCavsLiberi() {
        return postiNumCavsLiberi;
    }


    public void setPostiNumCavsLiberi(Integer postiNumCavsLiberi) {
        this.postiNumCavsLiberi = postiNumCavsLiberi;
    }


    public Integer getPostiNumCavsLiberiUomini() {
        return postiNumCavsLiberiUomini;
    }


    public void setPostiNumCavsLiberiUomini(Integer postiNumCavsLiberiUomini) {
        this.postiNumCavsLiberiUomini = postiNumCavsLiberiUomini;
    }


    public Integer getPostiNumCavsLiberiDonne() {
        return postiNumCavsLiberiDonne;
    }


    public void setPostiNumCavsLiberiDonne(Integer postiNumCavsLiberiDonne) {
        this.postiNumCavsLiberiDonne = postiNumCavsLiberiDonne;
    }


    public Integer getPostiNumCavsLiberiIndiff() {
        return postiNumCavsLiberiIndiff;
    }


    public void setPostiNumCavsLiberiIndiff(Integer postiNumCavsLiberiIndiff) {
        this.postiNumCavsLiberiIndiff = postiNumCavsLiberiIndiff;
    }


    public Integer getPostiNumLungodegOccupati() {
        return postiNumLungodegOccupati;
    }


    public void setPostiNumLungodegOccupati(Integer postiNumLungodegOccupati) {
        this.postiNumLungodegOccupati = postiNumLungodegOccupati;
    }


    public Integer getPostiNumLungodegLiberi() {
        return postiNumLungodegLiberi;
    }


    public void setPostiNumLungodegLiberi(Integer postiNumLungodegLiberi) {
        this.postiNumLungodegLiberi = postiNumLungodegLiberi;
    }


    public Integer getPostiNumLungodegLiberiUomini() {
        return postiNumLungodegLiberiUomini;
    }


    public void setPostiNumLungodegLiberiUomini(Integer postiNumLungodegLiberiUomini) {
        this.postiNumLungodegLiberiUomini = postiNumLungodegLiberiUomini;
    }


    public Integer getPostiNumLungodegLiberiDonne() {
        return postiNumLungodegLiberiDonne;
    }


    public void setPostiNumLungodegLiberiDonne(Integer postiNumLungodegLiberiDonne) {
        this.postiNumLungodegLiberiDonne = postiNumLungodegLiberiDonne;
    }


    public Integer getPostiNumLungodegLiberiIndiff() {
        return postiNumLungodegLiberiIndiff;
    }


    public void setPostiNumLungodegLiberiIndiff(Integer postiNumLungodegLiberiIndiff) {
        this.postiNumLungodegLiberiIndiff = postiNumLungodegLiberiIndiff;
    }


    public Integer getPostiNumHospiceOccupati() {
        return postiNumHospiceOccupati;
    }


    public void setPostiNumHospiceOccupati(Integer postiNumHospiceOccupati) {
        this.postiNumHospiceOccupati = postiNumHospiceOccupati;
    }


    public Integer getPostiNumHospiceLiberi() {
        return postiNumHospiceLiberi;
    }


    public void setPostiNumHospiceLiberi(Integer postiNumHospiceLiberi) {
        this.postiNumHospiceLiberi = postiNumHospiceLiberi;
    }


    public Integer getPostiNumHospiceLiberiUomini() {
        return postiNumHospiceLiberiUomini;
    }


    public void setPostiNumHospiceLiberiUomini(Integer postiNumHospiceLiberiUomini) {
        this.postiNumHospiceLiberiUomini = postiNumHospiceLiberiUomini;
    }


    public Integer getPostiNumHospiceLiberiDonne() {
        return postiNumHospiceLiberiDonne;
    }


    public void setPostiNumHospiceLiberiDonne(Integer postiNumHospiceLiberiDonne) {
        this.postiNumHospiceLiberiDonne = postiNumHospiceLiberiDonne;
    }


    public Integer getPostiNumHospiceLiberiIndiff() {
        return postiNumHospiceLiberiIndiff;
    }


    public void setPostiNumHospiceLiberiIndiff(Integer postiNumHospiceLiberiIndiff) {
        this.postiNumHospiceLiberiIndiff = postiNumHospiceLiberiIndiff;
    }


    public String getNomeStruttura() {
		return nomeStruttura;
	}


	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}


	public String getDataRilevazioneString() {
		return dataRilevazioneString;
	}


	public void setDataRilevazioneString(String dataRilevazioneString) {
		this.dataRilevazioneString = dataRilevazioneString;
	}


	public String getTipologiaStrutturaDesc() {
		return tipologiaStrutturaDesc;
	}


	public void setTipologiaStrutturaDesc(String tipologiaStrutturaDesc) {
		this.tipologiaStrutturaDesc = tipologiaStrutturaDesc;
	}


	public String getDatiValidi() {
		return datiValidi;
	}


	public void setDatiValidi(String datiValidi) {
		this.datiValidi = datiValidi;
	}

	public Integer getPostiNumOccupati() {
		return postiNumOccupati;
	}


	public void setPostiNumOccupati(Integer postiNumOccupati) {
		this.postiNumOccupati = postiNumOccupati;
	}


	public Integer getPostiNumOspedalizzati() {
		return postiNumOspedalizzati;
	}


	public void setPostiNumOspedalizzati(Integer postiNumOspedalizzati) {
		this.postiNumOspedalizzati = postiNumOspedalizzati;
	}


	public Integer getPostiNumTotaliSingole() {
		return postiNumTotaliSingole;
	}


	public void setPostiNumTotaliSingole(Integer postiNumTotaliSingole) {
		this.postiNumTotaliSingole = postiNumTotaliSingole;
	}


	public Integer getPostiNumSingoleResidue() {
		return postiNumSingoleResidue;
	}


	public void setPostiNumSingoleResidue(Integer postiNumSingoleResidue) {
		this.postiNumSingoleResidue = postiNumSingoleResidue;
	}


	public Integer getAccessiInPsNum() {
		return accessiInPsNum;
	}


	public void setAccessiInPsNum(Integer accessiInPsNum) {
		this.accessiInPsNum = accessiInPsNum;
	}


	public Integer getPostiNumOccupatiPaganti() {
		return postiNumOccupatiPaganti;
	}


	public void setPostiNumOccupatiPaganti(Integer postiNumOccupatiPaganti) {
		this.postiNumOccupatiPaganti = postiNumOccupatiPaganti;
	}


	public Integer getPostiNumOccupatiConvenzionati() {
		return postiNumOccupatiConvenzionati;
	}


	public void setPostiNumOccupatiConvenzionati(Integer postiNumOccupatiConvenzionati) {
		this.postiNumOccupatiConvenzionati = postiNumOccupatiConvenzionati;
	}


    public Integer getPostiNumLiberiUomini() {
        return postiNumLiberiUomini;
    }


    public void setPostiNumLiberiUomini(Integer postiNumLiberiUomini) {
        this.postiNumLiberiUomini = postiNumLiberiUomini;
    }


    public Integer getPostiNumLiberiDonne() {
        return postiNumLiberiDonne;
    }


    public void setPostiNumLiberiDonne(Integer postiNumLiberiDonne) {
        this.postiNumLiberiDonne = postiNumLiberiDonne;
    }


    public Integer getPostiNumLiberiIndiff() {
        return postiNumLiberiIndiff;
    }


    public void setPostiNumLiberiIndiff(Integer postiNumLiberiIndiff) {
        this.postiNumLiberiIndiff = postiNumLiberiIndiff;
    }

}
