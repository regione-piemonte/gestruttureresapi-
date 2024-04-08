/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFascia;

public interface BaseCovidrsaDWelfareFasciaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_welfare_fascia
     *
     * @mbg.generated
     */
    @Delete({
        "delete from covidrsa_d_welfare_fascia",
        "where welfare_fascia_id = #{welfareFasciaId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer welfareFasciaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_welfare_fascia
     *
     * @mbg.generated
     */
    @Insert({
        "insert into covidrsa_d_welfare_fascia (welfare_fascia_cod, welfare_fascia_desc, ",
        "validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione)",
        "values (#{welfareFasciaCod,jdbcType=VARCHAR}, #{welfareFasciaDesc,jdbcType=VARCHAR}, ",
        "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
        "#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="welfareFasciaId")
    int insert(CovidrsaDWelfareFascia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_welfare_fascia
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "welfare_fascia_id, welfare_fascia_cod, welfare_fascia_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_welfare_fascia",
        "where welfare_fascia_id = #{welfareFasciaId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="welfare_fascia_cod", property="welfareFasciaCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_desc", property="welfareFasciaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    CovidrsaDWelfareFascia selectByPrimaryKey(Integer welfareFasciaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_welfare_fascia
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "welfare_fascia_id, welfare_fascia_cod, welfare_fascia_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_welfare_fascia"
    })
    @Results({
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="welfare_fascia_cod", property="welfareFasciaCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_desc", property="welfareFasciaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CovidrsaDWelfareFascia> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_welfare_fascia
     *
     * @mbg.generated
     */
    @Update({
        "update covidrsa_d_welfare_fascia",
        "set welfare_fascia_cod = #{welfareFasciaCod,jdbcType=VARCHAR},",
          "welfare_fascia_desc = #{welfareFasciaDesc,jdbcType=VARCHAR},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
        "where welfare_fascia_id = #{welfareFasciaId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CovidrsaDWelfareFascia record);
}