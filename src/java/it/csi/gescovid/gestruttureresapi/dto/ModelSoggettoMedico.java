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

public class ModelSoggettoMedico   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String cfMedico = null;
  private String codiceReg = null;
  private String nome = null;
  private String cognome = null;

  /**
   **/
  

  @JsonProperty("cfMedico") 
 
  public String getCfMedico() {
    return cfMedico;
  }
  public void setCfMedico(String cfMedico) {
    this.cfMedico = cfMedico;
  }

  /**
   **/
  

  @JsonProperty("codiceReg") 
 
  public String getCodiceReg() {
    return codiceReg;
  }
  public void setCodiceReg(String codiceReg) {
    this.codiceReg = codiceReg;
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
  

  @JsonProperty("cognome") 
 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoMedico modelSoggettoMedico = (ModelSoggettoMedico) o;
    return Objects.equals(cfMedico, modelSoggettoMedico.cfMedico) &&
        Objects.equals(codiceReg, modelSoggettoMedico.codiceReg) &&
        Objects.equals(nome, modelSoggettoMedico.nome) &&
        Objects.equals(cognome, modelSoggettoMedico.cognome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cfMedico, codiceReg, nome, cognome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoMedico {\n");
    
    sb.append("    cfMedico: ").append(toIndentedString(cfMedico)).append("\n");
    sb.append("    codiceReg: ").append(toIndentedString(codiceReg)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
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

