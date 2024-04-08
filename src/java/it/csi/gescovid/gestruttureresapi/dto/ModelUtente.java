/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.StrutturaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.StrutturaInfoExt;

public class ModelUtente   {
	// verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 

	
	private String versioneBe="2.2.4";
	private String cfUtente = null;
	private String nome = null;
	private String cognome = null;
	private String telefono = null;
	private String email = null;
	private Integer rowsNumber;
	private List<ModelUtenteElencoStruttura> elencoStruttura = new ArrayList<ModelUtenteElencoStruttura>();
	private List<ModelProfilo> elencoProfili = new ArrayList<ModelProfilo>();
	private List<StrutturaInfo> elencoStruttureRes = new ArrayList<StrutturaInfo>();
	private List<StrutturaInfoExt> elencoRsa = new ArrayList<StrutturaInfoExt>();

	/**
	 * Il codice fiscale dell&#39;utente loggato
	 **/

	@JsonProperty("cfUtente") 
	public String getCfUtente() {
		return cfUtente;
	}
	public void setCfUtente(String cfUtente) {
		this.cfUtente = cfUtente;
	}

	/**
	 * Il nome dell&#39;utente
	 **/


	@JsonProperty("nome") 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * il cognome dell&#39;utente
	 **/


	@JsonProperty("cognome") 
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Il numero di telefono dell&#39;utente
	 **/


	@JsonProperty("telefono") 
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * L&#39;indirizzo email
	 **/


	@JsonProperty("email") 

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 **/


	@JsonProperty("elencoStruttura") 
	public List<ModelUtenteElencoStruttura> getElencoStruttura() {
		return elencoStruttura;
	}
	public void setElencoStruttura(List<ModelUtenteElencoStruttura> elencoStruttura) {
		this.elencoStruttura = elencoStruttura;
	}


	@JsonProperty("elencoProfili") 
	public List<ModelProfilo> getElencoProfili() {
		return elencoProfili;
	}

	public void setElencoProfili(List<ModelProfilo> elencoProfili) {
		this.elencoProfili = elencoProfili;
	}


	@JsonProperty("elencoStruttureRes") 
	public List<StrutturaInfo> getElencoStruttureRes() {
		return elencoStruttureRes;
	}
	public void setElencoStruttureRes(List<StrutturaInfo> elencoStruttureRes) {
		this.elencoStruttureRes = elencoStruttureRes;
	}
	

	public List<StrutturaInfoExt> getElencoRsa() {
		return elencoRsa;
	}
	public void setElencoRsa(List<StrutturaInfoExt> elencoRsa) {
		this.elencoRsa = elencoRsa;
	}
	@JsonProperty("versioneBe") 
	public String getVersioneBe() {
		return versioneBe;
	}
	public void setVersioneBe(String versioneBe) {
		this.versioneBe = versioneBe;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelUtente modelUtente = (ModelUtente) o;
		return Objects.equals(cfUtente, modelUtente.cfUtente) &&
				Objects.equals(nome, modelUtente.nome) &&
				Objects.equals(cognome, modelUtente.cognome) &&
				Objects.equals(telefono, modelUtente.telefono) &&
				Objects.equals(email, modelUtente.email) &&
				Objects.equals(elencoStruttura, modelUtente.elencoStruttura)&&
				Objects.equals(elencoProfili, modelUtente.elencoProfili)&&
				Objects.equals(elencoStruttureRes, modelUtente.elencoStruttureRes) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cfUtente, nome, cognome, telefono, email, elencoStruttura, elencoProfili, elencoStruttureRes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelUtente {\n");

		sb.append("    cfUtente: ").append(toIndentedString(cfUtente)).append("\n");
		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
		sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    elencoStruttura: ").append(toIndentedString(elencoStruttura)).append("\n");
		sb.append("    elencoProfili: ").append(toIndentedString(elencoProfili)).append("\n");
		sb.append("    elencoStruttureRes: ").append(toIndentedString(elencoStruttureRes)).append("\n");

		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
	
	public Integer getRowsNumber() {
		return rowsNumber;
	}
	public void setRowsNumber(Integer rowsNumber) {
		this.rowsNumber = rowsNumber;
	}
}

