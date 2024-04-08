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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaPersonaleTipo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaPersonaleTipoMapper;

public interface RsaPersonaleTipoMapper extends BaseRsaPersonaleTipoMapper{
	
	 @Select({
	        "select",
	        "pers_tipo_id, pers_tipo_cod, pers_tipo_desc, validita_inizio, validita_fine, ",
	        "utente_operazione, data_creazione, data_modifica, data_cancellazione",
	        "from covidrsa_d_personale_tipo ",
	        "where now() between validita_inizio and coalesce(validita_fine, now()) "
	    })
	    @Results({
	        @Result(column="pers_tipo_id", property="persTipoId", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="pers_tipo_cod", property="persTipoCod", jdbcType=JdbcType.VARCHAR),
	        @Result(column="pers_tipo_desc", property="persTipoDesc", jdbcType=JdbcType.VARCHAR),
	        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
	        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
	    })
	    List<RsaPersonaleTipo> selectAllValid();

}
