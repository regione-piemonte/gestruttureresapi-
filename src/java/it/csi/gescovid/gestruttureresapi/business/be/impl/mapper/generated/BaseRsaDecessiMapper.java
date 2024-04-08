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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaDecessi;

public interface BaseRsaDecessiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_decessi
     *
     * @mbg.generated
     */
    @Delete({
        "delete from covidrsa_t_decessi",
        "where dec_id = #{decId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer decId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_decessi
     *
     * @mbg.generated
     */
    @Insert({
        "insert into covidrsa_t_decessi (dec_num_totali_anno_precedente, ",
        "dec_num_totali, dec_num_totali_covid, ",
        "dec_num_in_ospedale, dec_num_in_ospedale_covid, ",
        "id_struttura, str_categoria_id, ",
        "data_rilevazione, validita_inizio, ",
        "validita_fine, utente_operazione, ",
        "data_creazione, data_modifica, ",
        "data_cancellazione, data_visibilita, ",
        "dec_num_in_ospedale_anno_precedente, dec_num_in_struttura_anno_precedente, ",
        "dec_num_in_struttura, dec_num_in_struttura_covid, ",
        "dec_num_ultima_settimana, dec_num_covid_ultima_settimana, ",
        "dec_num_in_struttura_ultima_settimana, dec_num_in_struttura_covid_ultima_settimana, ",
        "dec_num_in_ospedale_ultima_settimana, dec_num_in_ospedale_covid_ultima_settimana)",
        "values (#{decNumTotaliAnnoPrecedente,jdbcType=INTEGER}, ",
        "#{decNumTotali,jdbcType=INTEGER}, #{decNumTotaliCovid,jdbcType=INTEGER}, ",
        "#{decNumInOspedale,jdbcType=INTEGER}, #{decNumInOspedaleCovid,jdbcType=INTEGER}, ",
        "#{idStruttura,jdbcType=VARCHAR}, #{strCategoriaId,jdbcType=INTEGER}, ",
        "#{dataRilevazione,jdbcType=TIMESTAMP}, #{validitaInizio,jdbcType=TIMESTAMP}, ",
        "#{validitaFine,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
        "#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
        "#{dataCancellazione,jdbcType=TIMESTAMP}, #{dataVisibilita,jdbcType=TIMESTAMP}, ",
        "#{decNumInOspedaleAnnoPrecedente,jdbcType=INTEGER}, #{decNumInStrutturaAnnoPrecedente,jdbcType=INTEGER}, ",
        "#{decNumInStruttura,jdbcType=INTEGER}, #{decNumInStrutturaCovid,jdbcType=INTEGER}, ",
        "#{decNumUltimaSettimana,jdbcType=INTEGER}, #{decNumCovidUltimaSettimana,jdbcType=INTEGER}, ",
        "#{decNumInStrutturaUltimaSettimana,jdbcType=INTEGER}, #{decNumInStrutturaCovidUltimaSettimana,jdbcType=INTEGER}, ",
        "#{decNumInOspedaleUltimaSettimana,jdbcType=INTEGER}, #{decNumInOspedaleCovidUltimaSettimana,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="decId")
    int insert(RsaDecessi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_decessi
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "dec_id, dec_num_totali_anno_precedente, dec_num_totali, dec_num_totali_covid, ",
        "dec_num_in_ospedale, dec_num_in_ospedale_covid, id_struttura, str_categoria_id, ",
        "data_rilevazione, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, data_visibilita, dec_num_in_ospedale_anno_precedente, ",
        "dec_num_in_struttura_anno_precedente, dec_num_in_struttura, dec_num_in_struttura_covid, ",
        "dec_num_ultima_settimana, dec_num_covid_ultima_settimana, dec_num_in_struttura_ultima_settimana, ",
        "dec_num_in_struttura_covid_ultima_settimana, dec_num_in_ospedale_ultima_settimana, ",
        "dec_num_in_ospedale_covid_ultima_settimana",
        "from covidrsa_t_decessi",
        "where dec_id = #{decId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="dec_id", property="decId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dec_num_totali_anno_precedente", property="decNumTotaliAnnoPrecedente", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_totali", property="decNumTotali", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_totali_covid", property="decNumTotaliCovid", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale", property="decNumInOspedale", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale_covid", property="decNumInOspedaleCovid", jdbcType=JdbcType.INTEGER),
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
        @Result(column="dec_num_in_ospedale_anno_precedente", property="decNumInOspedaleAnnoPrecedente", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_anno_precedente", property="decNumInStrutturaAnnoPrecedente", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura", property="decNumInStruttura", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_covid", property="decNumInStrutturaCovid", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_ultima_settimana", property="decNumUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_covid_ultima_settimana", property="decNumCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_ultima_settimana", property="decNumInStrutturaUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_covid_ultima_settimana", property="decNumInStrutturaCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale_ultima_settimana", property="decNumInOspedaleUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale_covid_ultima_settimana", property="decNumInOspedaleCovidUltimaSettimana", jdbcType=JdbcType.INTEGER)
    })
    RsaDecessi selectByPrimaryKey(Integer decId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_decessi
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "dec_id, dec_num_totali_anno_precedente, dec_num_totali, dec_num_totali_covid, ",
        "dec_num_in_ospedale, dec_num_in_ospedale_covid, id_struttura, str_categoria_id, ",
        "data_rilevazione, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, data_visibilita, dec_num_in_ospedale_anno_precedente, ",
        "dec_num_in_struttura_anno_precedente, dec_num_in_struttura, dec_num_in_struttura_covid, ",
        "dec_num_ultima_settimana, dec_num_covid_ultima_settimana, dec_num_in_struttura_ultima_settimana, ",
        "dec_num_in_struttura_covid_ultima_settimana, dec_num_in_ospedale_ultima_settimana, ",
        "dec_num_in_ospedale_covid_ultima_settimana",
        "from covidrsa_t_decessi"
    })
    @Results({
        @Result(column="dec_id", property="decId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dec_num_totali_anno_precedente", property="decNumTotaliAnnoPrecedente", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_totali", property="decNumTotali", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_totali_covid", property="decNumTotaliCovid", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale", property="decNumInOspedale", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale_covid", property="decNumInOspedaleCovid", jdbcType=JdbcType.INTEGER),
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
        @Result(column="dec_num_in_ospedale_anno_precedente", property="decNumInOspedaleAnnoPrecedente", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_anno_precedente", property="decNumInStrutturaAnnoPrecedente", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura", property="decNumInStruttura", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_covid", property="decNumInStrutturaCovid", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_ultima_settimana", property="decNumUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_covid_ultima_settimana", property="decNumCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_ultima_settimana", property="decNumInStrutturaUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_struttura_covid_ultima_settimana", property="decNumInStrutturaCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale_ultima_settimana", property="decNumInOspedaleUltimaSettimana", jdbcType=JdbcType.INTEGER),
        @Result(column="dec_num_in_ospedale_covid_ultima_settimana", property="decNumInOspedaleCovidUltimaSettimana", jdbcType=JdbcType.INTEGER)
    })
    List<RsaDecessi> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table covidrsa_t_decessi
     *
     * @mbg.generated
     */
    @Update({
        "update covidrsa_t_decessi",
        "set dec_num_totali_anno_precedente = #{decNumTotaliAnnoPrecedente,jdbcType=INTEGER},",
          "dec_num_totali = #{decNumTotali,jdbcType=INTEGER},",
          "dec_num_totali_covid = #{decNumTotaliCovid,jdbcType=INTEGER},",
          "dec_num_in_ospedale = #{decNumInOspedale,jdbcType=INTEGER},",
          "dec_num_in_ospedale_covid = #{decNumInOspedaleCovid,jdbcType=INTEGER},",
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
          "dec_num_in_ospedale_anno_precedente = #{decNumInOspedaleAnnoPrecedente,jdbcType=INTEGER},",
          "dec_num_in_struttura_anno_precedente = #{decNumInStrutturaAnnoPrecedente,jdbcType=INTEGER},",
          "dec_num_in_struttura = #{decNumInStruttura,jdbcType=INTEGER},",
          "dec_num_in_struttura_covid = #{decNumInStrutturaCovid,jdbcType=INTEGER},",
          "dec_num_ultima_settimana = #{decNumUltimaSettimana,jdbcType=INTEGER},",
          "dec_num_covid_ultima_settimana = #{decNumCovidUltimaSettimana,jdbcType=INTEGER},",
          "dec_num_in_struttura_ultima_settimana = #{decNumInStrutturaUltimaSettimana,jdbcType=INTEGER},",
          "dec_num_in_struttura_covid_ultima_settimana = #{decNumInStrutturaCovidUltimaSettimana,jdbcType=INTEGER},",
          "dec_num_in_ospedale_ultima_settimana = #{decNumInOspedaleUltimaSettimana,jdbcType=INTEGER},",
          "dec_num_in_ospedale_covid_ultima_settimana = #{decNumInOspedaleCovidUltimaSettimana,jdbcType=INTEGER}",
        "where dec_id = #{decId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RsaDecessi record);
}