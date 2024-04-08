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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseEnteMapper;

public interface EnteMapper extends BaseEnteMapper {

	@Select({ "select", 
		" e.id_ente, e.nome, e.tot_posti_target", 
		"from ente e join r_utente_ente rue on e.id_ente = rue.id_ente  ", 
	"where cf_utente = #{cf,jdbcType=VARCHAR} order by e.nome" })
	@Results({ 
		@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "tot_posti_target", property = "totPostiTarget", jdbcType = JdbcType.INTEGER) 
	})
	List<Ente> selectByCfUtente(String  cf);


	@Select({ "select", 
		" e.id_ente, e.nome, e.tot_posti_target", 
		"from ente e  ", 
		"where e.nome  ilike ('%A.S.L%') order by e.nome"
	})
	@Results({ 
		@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "tot_posti_target", property = "totPostiTarget", jdbcType = JdbcType.INTEGER) 
	})
	List<Ente> selectAsl();

}
