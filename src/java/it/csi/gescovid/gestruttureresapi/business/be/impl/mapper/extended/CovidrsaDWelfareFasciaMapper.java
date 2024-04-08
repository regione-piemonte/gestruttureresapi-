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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaDWelfareFasciaMapper;

public interface CovidrsaDWelfareFasciaMapper extends BaseCovidrsaDWelfareFasciaMapper {
    @Select({
        "select",
        "welfare_fascia_id, welfare_fascia_cod, welfare_fascia_desc ",
        "from covidrsa_d_welfare_fascia",
        "where data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) "
    })
    @Results({
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="welfare_fascia_cod", property="welfareFasciaCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_desc", property="welfareFasciaDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<CovidrsaDWelfareFascia> selectAllValid();

}
