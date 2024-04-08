/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRWelfareFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaRWelfareFasciaMapper;

public interface CovidrsaRWelfareFasciaMapper extends BaseCovidrsaRWelfareFasciaMapper {

    @Select({
        "select",
        "crswf.str_welf_fascia_id, crswf.welfare_fascia_id, crswf.tariffa_mensile_massima, cdwf.welfare_fascia_desc, cdwf.welfare_fascia_cod  ",
        "from covidrsa_r_struttura_welfare_fascia crswf ",
        "left join covidrsa_d_welfare_fascia cdwf on cdwf.welfare_fascia_id = crswf.welfare_fascia_id ",
        "where str_welfare_id = #{strWelfareId,jdbcType=INTEGER}",
        " and crswf.data_cancellazione is null ",
        " order by crswf.welfare_fascia_id "
    })
    @Results({
        @Result(column="str_welf_fascia_id", property="strWelfFasciaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER),
        @Result(column="tariffa_mensile_massima", property="tariffaMensileMassima", jdbcType=JdbcType.NUMERIC),
        @Result(column="welfare_fascia_cod", property="welfareFasciaCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_desc", property="welfareFasciaDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<ModelFascia> selectByStrWelfareId(Integer strWelfareId);
    
    @Insert({
        "insert into covidrsa_r_struttura_welfare_fascia (str_welfare_id, welfare_fascia_id, ",
        "tariffa_mensile_massima, validita_inizio, ",
        "validita_fine, utente_operazione, ",
        "data_creazione, data_modifica, ",
        "data_cancellazione)",
        "values (#{strWelfareId,jdbcType=INTEGER}, #{welfareFasciaId,jdbcType=INTEGER}, ",
        "#{tariffaMensileMassima,jdbcType=NUMERIC}, #{validitaInizio,jdbcType=TIMESTAMP}, ",
        "#{validitaFine,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
        "now(), now(), ",
        "#{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="strWelfFasciaId")
    int insert(CovidrsaRWelfareFascia record);

    @Update({
        "update covidrsa_r_struttura_welfare_fascia",
        "set ",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR}, ",
          "data_modifica = now(), ",
          "data_cancellazione = now() ",
        "where str_welf_fascia_id = #{strWelfFasciaId,jdbcType=INTEGER} "
    })
    int logicDeletByPrimaryKey(CovidrsaRWelfareFascia record);

}
