/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRStrutturaWelfareContatti;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRWelfareFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaRStrutturaWelfareContattiMapper;

public interface CovidrsaRStrutturaWelfareContattiMapper extends BaseCovidrsaRStrutturaWelfareContattiMapper {

    @Select({
        "select crswc.* from covidrsa_r_struttura_welfare_contatti crswc   ",
        "join covidrsa_r_struttura_welfare crsw on crsw.str_welfare_id = crswc.str_welfare_id ",
        "AND crsw.data_cancellazione is NULL  ",
        "AND now() BETWEEN crsw.validita_inizio AND coalesce(crsw.validita_fine, now())  ",
        "where crsw.id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
        "AND crswc.data_cancellazione is NULL  ",
        "AND now() BETWEEN crswc.validita_inizio AND coalesce(crswc.validita_fine, now()) "
    })
    @Results({
        @Result(column="str_welf_contatti_id", property="strWelfContattiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="str_welfare_id", property="strWelfareId", jdbcType=JdbcType.INTEGER),
        @Result(column="struttura_email", property="strutturaEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    CovidrsaRStrutturaWelfareContatti selectByIdStruttura(@Param("idStruttura") String idStruttura);

    @Update({
        "update covidrsa_r_struttura_welfare_contatti",
        "set ",
          "validita_fine = now(),",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_modifica = now() ",
        "where str_welf_contatti_id = #{strWelfContattiId,jdbcType=INTEGER}"
    })
    int invalidaByPrimaryKey(CovidrsaRStrutturaWelfareContatti record);
    

    @Update({
        "update covidrsa_r_struttura_welfare_contatti ",
        "set ",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR}, ",
          "data_modifica = now(), ",
          "data_cancellazione = now() ",
        "where str_welf_contatti_id = #{strWelfFasciaId,jdbcType=INTEGER} "
    })
    int logicDeletByPrimaryKey(CovidrsaRStrutturaWelfareContatti record);

    @Insert({
        "insert into covidrsa_r_struttura_welfare_contatti (str_welfare_id, struttura_email, ",
        "validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione)",
        "values (#{strWelfareId,jdbcType=INTEGER}, #{strutturaEmail,jdbcType=VARCHAR}, ",
        "coalesce(#{validitaInizio,jdbcType=TIMESTAMP},now()), #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, coalesce(#{dataCreazione,jdbcType=TIMESTAMP},now()), ",
        "coalesce(#{dataModifica,jdbcType=TIMESTAMP},now()), #{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="strWelfContattiId")
    int insert(CovidrsaRStrutturaWelfareContatti record);

    @Select({
        "select crswc.* from covidrsa_r_struttura_welfare_contatti crswc   ",
        "where crswc.str_welfare_id = #{strWelfareId,jdbcType=INTEGER} ",
        "AND crswc.data_cancellazione is NULL  ",
        "AND now() BETWEEN crswc.validita_inizio AND coalesce(crswc.validita_fine, now()) "
    })
    @Results({
        @Result(column="str_welf_contatti_id", property="strWelfContattiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="str_welfare_id", property="strWelfareId", jdbcType=JdbcType.INTEGER),
        @Result(column="struttura_email", property="strutturaEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    CovidrsaRStrutturaWelfareContatti selectByStrWelfareId(@Param("strWelfareId") Integer strWelfareId);
}
