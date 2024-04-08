/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteElencoStruttura   {
	// verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 

	private String idStruttura = null;
	private Integer idEnte = null;
	private String nome = null;
	private String natura = null;
	private String indirizzo = null;
	private String direttore = null;
	private String telefono = null;

	/**
	 **/


	@JsonProperty("idStruttura") 

	public String getIdStruttura() {
		return idStruttura;
	}
	public void setIdStruttura(String idStruttura) {
		this.idStruttura = idStruttura;
	}

	/**
	 **/


	@JsonProperty("idEnte") 

	public Integer getIdEnte() {
		return idEnte;
	}
	public void setIdEnte(Integer idEnte) {
		this.idEnte = idEnte;
	}

	/**
	 **/


	@JsonProperty("nome") 

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 **/


	@JsonProperty("natura") 
	public String getNatura() {
		return natura;
	}
	public void setNatura(String natura) {
		this.natura = natura;
	}



	@JsonProperty("indirizzo") 
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	

	@JsonProperty("direttore") 
	public String getDirettore() {
		return direttore;
	}
	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}
	
	@JsonProperty("telefono") 
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelUtenteElencoStruttura modelUtenteElencoStruttura = (ModelUtenteElencoStruttura) o;
		return Objects.equals(idStruttura, modelUtenteElencoStruttura.idStruttura) &&
				Objects.equals(idEnte, modelUtenteElencoStruttura.idEnte) &&
				Objects.equals(nome, modelUtenteElencoStruttura.nome) &&
				Objects.equals(natura, modelUtenteElencoStruttura.natura)&&
				Objects.equals(indirizzo, modelUtenteElencoStruttura.indirizzo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStruttura, idEnte, nome, natura, indirizzo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelUtenteElencoStruttura {\n");

		sb.append("    idStruttura: ").append(toIndentedString(idStruttura)).append("\n");
		sb.append("    idEnte: ").append(toIndentedString(idEnte)).append("\n");
		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    natura: ").append(toIndentedString(natura)).append("\n");
		sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
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
}

