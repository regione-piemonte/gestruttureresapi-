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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.MedicoSoggettoAura;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseMedicoSoggettoAuraMapper;

public interface MedicoSoggettoAuraMapper extends BaseMedicoSoggettoAuraMapper {
	
	
    @Select({
        "select",
        "id_medico, id_aura_sogg, data_scelta, data_revoca",
        "from r_medico_sogg_aura",
        "where ",
          " id_aura_sogg = #{idAuraSogg,jdbcType=BIGINT} ",
          " and data_revoca is null "
    })
    @Results({
        @Result(column="id_medico", property="idMedico", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_aura_sogg", property="idAuraSogg", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="data_scelta", property="dataScelta", jdbcType=JdbcType.DATE),
        @Result(column="data_revoca", property="dataRevoca", jdbcType=JdbcType.DATE)
    })
    List<MedicoSoggettoAura> selectByIdAuraSoggAndRevocaNull(Long idAuraSogg);

}
