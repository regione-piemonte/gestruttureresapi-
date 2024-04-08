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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaVisitatoriIngressi;

public interface BaseRsaVisitatoriIngressiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_visitatori_ingressi
     *
     * @mbg.generated
     */
    @Delete({
        "delete from covidrsa_d_visitatori_ingressi",
        "where visitatori_ingressi_id = #{visitatoriIngressiId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer visitatoriIngressiId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_visitatori_ingressi
     *
     * @mbg.generated
     */
    @Insert({
        "insert into covidrsa_d_visitatori_ingressi (visitatori_ingressi_cod, visitatori_ingressi_desc, ",
        "validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione)",
        "values (#{visitatoriIngressiCod,jdbcType=VARCHAR}, #{visitatoriIngressiDesc,jdbcType=VARCHAR}, ",
        "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
        "#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="visitatoriIngressiId")
    int insert(RsaVisitatoriIngressi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_visitatori_ingressi
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "visitatori_ingressi_id, visitatori_ingressi_cod, visitatori_ingressi_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_visitatori_ingressi",
        "where visitatori_ingressi_id = #{visitatoriIngressiId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="visitatori_ingressi_id", property="visitatoriIngressiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="visitatori_ingressi_cod", property="visitatoriIngressiCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitatori_ingressi_desc", property="visitatoriIngressiDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    RsaVisitatoriIngressi selectByPrimaryKey(Integer visitatoriIngressiId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_visitatori_ingressi
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "visitatori_ingressi_id, visitatori_ingressi_cod, visitatori_ingressi_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_visitatori_ingressi"
    })
    @Results({
        @Result(column="visitatori_ingressi_id", property="visitatoriIngressiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="visitatori_ingressi_cod", property="visitatoriIngressiCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitatori_ingressi_desc", property="visitatoriIngressiDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RsaVisitatoriIngressi> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_d_visitatori_ingressi
     *
     * @mbg.generated
     */
    @Update({
        "update covidrsa_d_visitatori_ingressi",
        "set visitatori_ingressi_cod = #{visitatoriIngressiCod,jdbcType=VARCHAR},",
          "visitatori_ingressi_desc = #{visitatoriIngressiDesc,jdbcType=VARCHAR},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
        "where visitatori_ingressi_id = #{visitatoriIngressiId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RsaVisitatoriIngressi record);
}