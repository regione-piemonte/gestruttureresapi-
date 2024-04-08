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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaVisitatori;

public interface BaseRsaVisitatoriMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_visitatori
     *
     * @mbg.generated
     */
    @Delete({
        "delete from covidrsa_t_visitatori",
        "where visitatori_id = #{visitatoriId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer visitatoriId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_visitatori
     *
     * @mbg.generated
     */
    @Insert({
        "insert into covidrsa_t_visitatori (id_struttura, str_categoria_id, ",
        "data_visibilita, visitatori_ingressi_id, ",
        "data_rilevazione, validita_inizio, ",
        "validita_fine, utente_operazione, ",
        "data_creazione, data_modifica, ",
        "data_cancellazione)",
        "values (#{idStruttura,jdbcType=VARCHAR}, #{strCategoriaId,jdbcType=INTEGER}, ",
        "#{dataVisibilita,jdbcType=TIMESTAMP}, #{visitatoriIngressiId,jdbcType=INTEGER}, ",
        "#{dataRilevazione,jdbcType=TIMESTAMP}, #{validitaInizio,jdbcType=TIMESTAMP}, ",
        "#{validitaFine,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
        "#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
        "#{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="visitatoriId")
    int insert(RsaVisitatori record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_visitatori
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "visitatori_id, id_struttura, str_categoria_id, data_visibilita, visitatori_ingressi_id, ",
        "data_rilevazione, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione",
        "from covidrsa_t_visitatori",
        "where visitatori_id = #{visitatoriId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="visitatori_id", property="visitatoriId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_visibilita", property="dataVisibilita", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="visitatori_ingressi_id", property="visitatoriIngressiId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rilevazione", property="dataRilevazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    RsaVisitatori selectByPrimaryKey(Integer visitatoriId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_visitatori
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "visitatori_id, id_struttura, str_categoria_id, data_visibilita, visitatori_ingressi_id, ",
        "data_rilevazione, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione",
        "from covidrsa_t_visitatori"
    })
    @Results({
        @Result(column="visitatori_id", property="visitatoriId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_visibilita", property="dataVisibilita", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="visitatori_ingressi_id", property="visitatoriIngressiId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rilevazione", property="dataRilevazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RsaVisitatori> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_visitatori
     *
     * @mbg.generated
     */
    @Update({
        "update covidrsa_t_visitatori",
        "set id_struttura = #{idStruttura,jdbcType=VARCHAR},",
          "str_categoria_id = #{strCategoriaId,jdbcType=INTEGER},",
          "data_visibilita = #{dataVisibilita,jdbcType=TIMESTAMP},",
          "visitatori_ingressi_id = #{visitatoriIngressiId,jdbcType=INTEGER},",
          "data_rilevazione = #{dataRilevazione,jdbcType=TIMESTAMP},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
        "where visitatori_id = #{visitatoriId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RsaVisitatori record);
}