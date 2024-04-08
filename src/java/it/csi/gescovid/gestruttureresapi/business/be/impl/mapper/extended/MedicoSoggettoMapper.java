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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.MedicoSoggetto;

public interface MedicoSoggettoMapper {

    @Select({
        "select",
        "id_medico, id_soggetto",
        "from r_medico_soggetto ", 
        "where id_soggetto= #{idSoggetto,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id_medico", property="idMedico", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<MedicoSoggetto> selectByIdSoggetto(Long idSoggetto);
}
