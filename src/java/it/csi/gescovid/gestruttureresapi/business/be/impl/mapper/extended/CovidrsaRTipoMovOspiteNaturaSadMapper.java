/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRTipoMovOspiteNaturaSad;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaRTipoMovOspiteNaturaSadMapper;

public interface CovidrsaRTipoMovOspiteNaturaSadMapper extends BaseCovidrsaRTipoMovOspiteNaturaSadMapper {

    @Select({ "select", "tmo_natura_sod_id, tipo_mov_ospite_id, natura_struttura_od, validita_inizio, ",
            "validita_fine, data_creazione, data_modifica, data_cancellazione, utente_operazione ",
            "from covidrsa_r_tipo_mov_ospite_natura_sod ",
            "where data_cancellazione is null ",
            "and now() between validita_inizio and coalesce(validita_fine, now()) " })
    @Results({
            @Result(column = "tmo_natura_sod_id", property = "tmoNaturaSodId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "tipo_mov_ospite_id", property = "tipoMovOspiteId", jdbcType = JdbcType.INTEGER),
            @Result(column = "natura_struttura_od", property = "naturaStrutturaOd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR) })
    List<CovidrsaRTipoMovOspiteNaturaSad> selectAllValid();

    @Select({ "select", "tmo_natura_sod_id, tipo_mov_ospite_id, natura_struttura_od, validita_inizio, ",
            "validita_fine, data_creazione, data_modifica, data_cancellazione, utente_operazione ",
            "from covidrsa_r_tipo_mov_ospite_natura_sod ",
            "where data_cancellazione is null ",
            "and now() between validita_inizio and coalesce(validita_fine, now()) ",
            " and tipo_mov_ospite_id = #{tipoMovOspiteId,jdbcType=INTEGER} "})
    @Results({
            @Result(column = "tmo_natura_sod_id", property = "tmoNaturaSodId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "tipo_mov_ospite_id", property = "tipoMovOspiteId", jdbcType = JdbcType.INTEGER),
            @Result(column = "natura_struttura_od", property = "naturaStrutturaOd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR) })
    List<CovidrsaRTipoMovOspiteNaturaSad> selectAllValidfromTipoMovOspiteId(@Param("tipoMovOspiteId") Integer tipoMovOspiteId);

}
