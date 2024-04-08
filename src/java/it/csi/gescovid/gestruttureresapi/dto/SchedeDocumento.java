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

public class SchedeDocumento   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String nome = null;
  private String fileBase64 = null;

  /**
   * Nome del file
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * file base64
   **/
  

  @JsonProperty("file_base64") 
 
  public String getFileBase64() {
    return fileBase64;
  }
  public void setFileBase64(String fileBase64) {
    this.fileBase64 = fileBase64;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchedeDocumento schedeDocumento = (SchedeDocumento) o;
    return Objects.equals(nome, schedeDocumento.nome) &&
        Objects.equals(fileBase64, schedeDocumento.fileBase64);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, fileBase64);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchedeDocumento {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    fileBase64: ").append(toIndentedString(fileBase64)).append("\n");
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

