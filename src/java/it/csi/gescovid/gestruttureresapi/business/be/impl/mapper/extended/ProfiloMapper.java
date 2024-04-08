/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseProfiloMapper;

public interface ProfiloMapper extends BaseProfiloMapper {

	@Select({ "select", 
		" nome_profilo", 
		"from profilo",
		"join r_utente_profilo on r_utente_profilo.id_profilo = profilo.id_profilo",
	"where r_utente_profilo.cf_utente = #{codiceFiscale,jdbcType=VARCHAR}" })
	List<String> selectElencoNomeProfiloByCodiceFiscale(String codiceFiscale);

}
