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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaDTipoMovOspiteExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaDTipoMovOspiteMapper;

public interface CovidrsaDTipoMovOspiteMapper extends BaseCovidrsaDTipoMovOspiteMapper {
    
    @Select({ "select", "tipo_mov_ospite_id, tipo_mov_ospite_cod, tipo_mov_ospite_desc, flg_ingresso, ",
        "validita_inizio, validita_fine, data_creazione, data_modifica, data_cancellazione, flg_uscita, tipo_mov_ospite_hint, ", "utente_operazione",
        "from covidrsa_d_tipo_mov_ospite ",
        "where data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) " })
    @Results({
            @Result(column = "tipo_mov_ospite_id", property = "tipoMovOspiteId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "tipo_mov_ospite_cod", property = "tipoMovOspiteCod", jdbcType = JdbcType.VARCHAR),
            @Result(column = "tipo_mov_ospite_desc", property = "tipoMovOspiteDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "flg_ingresso", property = "flgIngresso", jdbcType = JdbcType.BIT),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column="tipo_mov_ospite_hint", property="tipoMovOspiteHint", jdbcType=JdbcType.VARCHAR),
            @Result(column = "flg_uscita", property = "flgUscita", jdbcType = JdbcType.BIT)})
    List<CovidrsaDTipoMovOspiteExt> selectAllValid();
    
    @Select({ "select", "tipo_mov_ospite_id, tipo_mov_ospite_cod, tipo_mov_ospite_desc, flg_ingresso, ",
        "validita_inizio, validita_fine, data_creazione, data_modifica, data_cancellazione, flg_uscita, tipo_mov_ospite_hint, ", "utente_operazione",
        "from covidrsa_d_tipo_mov_ospite ", 
        "where data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) and tipo_mov_ospite_cod = #{tipoMovOspiteCod,jdbcType=VARCHAR} " })
@Results({
        @Result(column = "tipo_mov_ospite_id", property = "tipoMovOspiteId", jdbcType = JdbcType.INTEGER, id = true),
        @Result(column = "tipo_mov_ospite_cod", property = "tipoMovOspiteCod", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tipo_mov_ospite_desc", property = "tipoMovOspiteDesc", jdbcType = JdbcType.VARCHAR),
        @Result(column = "flg_ingresso", property = "flgIngresso", jdbcType = JdbcType.BIT),
        @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
        @Result(column="tipo_mov_ospite_hint", property="tipoMovOspiteHint", jdbcType=JdbcType.VARCHAR),
        @Result(column = "flg_uscita", property = "flgUscita", jdbcType = JdbcType.BIT) })
CovidrsaDTipoMovOspite selectByMovOspiteCod(String tipoMovOspiteCod);

}
