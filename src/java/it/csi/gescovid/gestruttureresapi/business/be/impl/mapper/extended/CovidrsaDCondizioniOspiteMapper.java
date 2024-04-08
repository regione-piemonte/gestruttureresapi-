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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDCondizioniOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaDCondizioniOspiteMapper;

public interface CovidrsaDCondizioniOspiteMapper extends BaseCovidrsaDCondizioniOspiteMapper {

    @Select({
        "select",
        "condizioni_ospite_id, condizioni_ospite_ord, condizioni_ospite_cod, condizioni_ospite_desc, ",
        "validita_inizio, validita_fine, data_creazione, data_modifica, data_cancellazione, ",
        "utente_operazione",
        "from covidrsa_d_condizioni_ospite",
        "where data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) " ,
        "order by condizioni_ospite_ord ASC "
    })
    @Results({
        @Result(column="condizioni_ospite_id", property="condizioniOspiteId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="condizioni_ospite_ord", property="condizioniOspiteOrd", jdbcType=JdbcType.VARCHAR),
        @Result(column="condizioni_ospite_cod", property="condizioniOspiteCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="condizioni_ospite_desc", property="condizioniOspiteDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR)
    })
    List<CovidrsaDCondizioniOspite> selectAllValid();

}
