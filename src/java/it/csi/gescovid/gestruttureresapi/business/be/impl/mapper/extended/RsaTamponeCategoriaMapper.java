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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaTamponeCategoria;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaTamponeCategoriaMapper;

public interface RsaTamponeCategoriaMapper extends BaseRsaTamponeCategoriaMapper {
	
    @Select({
        "select",
        "tamp_cat_id, tamp_cat_cod, tamp_cat_desc, validita_inizio, validita_fine, utente_operazione, ",
        "data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_tampone_categoria ",
        "where now() between validita_inizio and coalesce(validita_fine, now()) order by tamp_cat_desc "
    })
    @Results({
        @Result(column="tamp_cat_id", property="tampCatId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tamp_cat_cod", property="tampCatCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tamp_cat_desc", property="tampCatDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RsaTamponeCategoria> selectAllValid();

}
