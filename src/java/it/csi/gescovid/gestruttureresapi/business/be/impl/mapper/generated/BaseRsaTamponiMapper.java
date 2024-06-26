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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaTamponi;

public interface BaseRsaTamponiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_tamponi
     *
     * @mbg.generated
     */
    @Delete({
        "delete from covidrsa_t_tamponi",
        "where tamp_id = #{tampId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tampId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_tamponi
     *
     * @mbg.generated
     */
    @Insert({
        "insert into covidrsa_t_tamponi (tamp_num_totali, tamp_num_positivi, ",
        "tamp_num_negativi, tamp_num_in_attesa, ",
        "tamp_num_indeterminati, tamp_num_dubbi, ",
        "tamp_cat_id, id_struttura, ",
        "str_categoria_id, data_rilevazione, ",
        "validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, ",
        "data_visibilita, str_tipo_tampone_id)",
        "values (#{tampNumTotali,jdbcType=INTEGER}, #{tampNumPositivi,jdbcType=INTEGER}, ",
        "#{tampNumNegativi,jdbcType=INTEGER}, #{tampNumInAttesa,jdbcType=INTEGER}, ",
        "#{tampNumIndeterminati,jdbcType=INTEGER}, #{tampNumDubbi,jdbcType=INTEGER}, ",
        "#{tampCatId,jdbcType=INTEGER}, #{idStruttura,jdbcType=VARCHAR}, ",
        "#{strCategoriaId,jdbcType=INTEGER}, #{dataRilevazione,jdbcType=TIMESTAMP}, ",
        "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
        "#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP}, ",
        "#{dataVisibilita,jdbcType=TIMESTAMP}, #{strTipoTamponeId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="tampId")
    int insert(RsaTamponi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_tamponi
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "tamp_id, tamp_num_totali, tamp_num_positivi, tamp_num_negativi, tamp_num_in_attesa, ",
        "tamp_num_indeterminati, tamp_num_dubbi, tamp_cat_id, id_struttura, str_categoria_id, ",
        "data_rilevazione, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, data_visibilita, str_tipo_tampone_id",
        "from covidrsa_t_tamponi",
        "where tamp_id = #{tampId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tamp_id", property="tampId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tamp_num_totali", property="tampNumTotali", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_positivi", property="tampNumPositivi", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_negativi", property="tampNumNegativi", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_in_attesa", property="tampNumInAttesa", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_indeterminati", property="tampNumIndeterminati", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_dubbi", property="tampNumDubbi", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_cat_id", property="tampCatId", jdbcType=JdbcType.INTEGER),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rilevazione", property="dataRilevazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_visibilita", property="dataVisibilita", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="str_tipo_tampone_id", property="strTipoTamponeId", jdbcType=JdbcType.INTEGER)
    })
    RsaTamponi selectByPrimaryKey(Integer tampId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_tamponi
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "tamp_id, tamp_num_totali, tamp_num_positivi, tamp_num_negativi, tamp_num_in_attesa, ",
        "tamp_num_indeterminati, tamp_num_dubbi, tamp_cat_id, id_struttura, str_categoria_id, ",
        "data_rilevazione, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, data_visibilita, str_tipo_tampone_id",
        "from covidrsa_t_tamponi"
    })
    @Results({
        @Result(column="tamp_id", property="tampId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tamp_num_totali", property="tampNumTotali", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_positivi", property="tampNumPositivi", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_negativi", property="tampNumNegativi", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_in_attesa", property="tampNumInAttesa", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_indeterminati", property="tampNumIndeterminati", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_num_dubbi", property="tampNumDubbi", jdbcType=JdbcType.INTEGER),
        @Result(column="tamp_cat_id", property="tampCatId", jdbcType=JdbcType.INTEGER),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rilevazione", property="dataRilevazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_visibilita", property="dataVisibilita", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="str_tipo_tampone_id", property="strTipoTamponeId", jdbcType=JdbcType.INTEGER)
    })
    List<RsaTamponi> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_tamponi
     *
     * @mbg.generated
     */
    @Update({
        "update covidrsa_t_tamponi",
        "set tamp_num_totali = #{tampNumTotali,jdbcType=INTEGER},",
          "tamp_num_positivi = #{tampNumPositivi,jdbcType=INTEGER},",
          "tamp_num_negativi = #{tampNumNegativi,jdbcType=INTEGER},",
          "tamp_num_in_attesa = #{tampNumInAttesa,jdbcType=INTEGER},",
          "tamp_num_indeterminati = #{tampNumIndeterminati,jdbcType=INTEGER},",
          "tamp_num_dubbi = #{tampNumDubbi,jdbcType=INTEGER},",
          "tamp_cat_id = #{tampCatId,jdbcType=INTEGER},",
          "id_struttura = #{idStruttura,jdbcType=VARCHAR},",
          "str_categoria_id = #{strCategoriaId,jdbcType=INTEGER},",
          "data_rilevazione = #{dataRilevazione,jdbcType=TIMESTAMP},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
          "data_visibilita = #{dataVisibilita,jdbcType=TIMESTAMP},",
          "str_tipo_tampone_id = #{strTipoTamponeId,jdbcType=INTEGER}",
        "where tamp_id = #{tampId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RsaTamponi record);
}