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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AssistenzaMedica;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseAssistenzaMedicaMapper;

public interface AssistenzaMedicaApiMapper extends BaseAssistenzaMedicaMapper {
	
    @Select({
        "select",
        "assmed_id, assmed_cod, assmed_desc, validita_inizio, validita_fine, utente_operazione, ",
        "data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_assistenza_medica",
        "where data_cancellazione is null ",
        " and now() between validita_inizio and coalesce(validita_fine, now())  "
    })
    @Results({
        @Result(column="assmed_id", property="assmedId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="assmed_cod", property="assmedCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="assmed_desc", property="assmedDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AssistenzaMedica> selectAllValid();

}
