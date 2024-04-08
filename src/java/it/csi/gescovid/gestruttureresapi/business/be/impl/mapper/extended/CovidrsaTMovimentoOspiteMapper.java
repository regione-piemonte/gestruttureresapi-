/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTMovimentoOspiteExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaTMovimentoOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;

public interface CovidrsaTMovimentoOspiteMapper extends BaseCovidrsaTMovimentoOspiteMapper {

    @Select({
        "<script>",
        "select",
        "ctmo.movimento_ospite_id, ctmo.id_struttura, ctmo.id_soggetto, ctmo.data_movimento, ctmo.tipo_mov_ospite_id, ",
        "ctmo.id_struttura_od, ctmo.flg_preserva_posto, ctmo.note, ctmo.validita_inizio, ctmo.validita_fine, ctmo.data_creazione, ",
        "ctmo.data_modifica, ctmo.data_cancellazione, ctmo.utente_operazione,",
        "s.codice_fiscale, s.nome, s.cognome, s.data_nascita, ",
        "cdtmo.tipo_mov_ospite_cod, cdtmo.tipo_mov_ospite_desc, ",
        "st.comune_istat, ctmo.condizioni_ospite_id ",
        "from covidrsa_t_movimento_ospite ctmo ",
        "join soggetto s on s.id_soggetto = ctmo.id_soggetto ",
        "join struttura st on st.id_struttura = ctmo.id_struttura ",
        "join covidrsa_d_tipo_mov_ospite cdtmo on cdtmo.tipo_mov_ospite_id = ctmo.tipo_mov_ospite_id ",
        "where ctmo.id_soggetto = #{idSoggetto,jdbcType=INTEGER} ",
        " and ctmo.data_cancellazione is null ",
        " and now() between ctmo.validita_inizio and coalesce(ctmo.validita_fine, now()) ",
        "<if test='idStrutturaOperazione != null'>",
        " and ctmo.id_struttura like #{idStrutturaOperazione,jdbcType=VARCHAR}  ",
        "</if>  ",
        "<if test='paginazione != null'>",
        "<if test='paginazione.orderBy != null'>ORDER BY ${paginazione.orderBy} </if>  ",
        "<if test='paginazione.limit !=-1'>OFFSET #{paginazione.offset,jdbcType=BIGINT} LIMIT #{paginazione.limit,jdbcType=BIGINT}</if> ",
        "</if>  ",
        "</script>"
    })
    @Results({
        @Result(column="movimento_ospite_id", property="movimentoOspiteId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="data_movimento", property="dataMovimento", jdbcType=JdbcType.DATE),
        @Result(column="tipo_mov_ospite_id", property="tipoMovOspiteId", jdbcType=JdbcType.INTEGER),
        @Result(column="id_struttura_od", property="idStrutturaOd", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_preserva_posto", property="flgPreservaPosto", jdbcType=JdbcType.BIT),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        
        @Result(column="id_soggetto", property="soggetto.idSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="nome", property="soggetto.nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="cognome", property="soggetto.cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="codiceFiscale", property="soggetto.codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="dataNascita", property="soggetto.dataNascita", jdbcType=JdbcType.DATE),

        @Result(column="tipo_mov_ospite_id", property="covidrsaDTipoMovOspite.tipoMovOspiteId", jdbcType=JdbcType.INTEGER),
        @Result(column="tipo_mov_ospite_cod", property="covidrsaDTipoMovOspite.tipoMovOspiteCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tipo_mov_ospite_desc", property="covidrsaDTipoMovOspite.tipoMovOspiteDesc", jdbcType=JdbcType.VARCHAR),
        
        @Result(column="comune_istat", property="struttura.comuneIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_struttura", property="struttura.idStruttura", jdbcType=JdbcType.VARCHAR),
    })
    List<CovidrsaTMovimentoOspiteExt> selectFromIdSoggettoAndIdStruttura(@Param("idSoggetto") Integer idSoggetto, 
            @Param("idStrutturaOperazione") String idStrutturaOperazione,@Param("paginazione") Paginazione paginazione);

    @Insert({
        "insert into covidrsa_t_movimento_ospite (id_struttura, id_soggetto, ",
        "data_movimento, tipo_mov_ospite_id, ",
        "id_struttura_od, flg_preserva_posto, ",
        "note, validita_inizio, ",
        "validita_fine, data_creazione, ",
        "data_modifica, data_cancellazione, ",
        "utente_operazione, condizioni_ospite_id )",
        "values (#{idStruttura,jdbcType=VARCHAR}, #{idSoggetto,jdbcType=INTEGER}, ",
        "#{dataMovimento,jdbcType=DATE}, #{tipoMovOspiteId,jdbcType=INTEGER}, ",
        "#{idStrutturaOd,jdbcType=VARCHAR}, #{flgPreservaPosto,jdbcType=BIT}, ",
        "#{note,jdbcType=VARCHAR}, COALESCE(#{validitaInizio,jdbcType=TIMESTAMP},now()), ",
        "#{validitaFine,jdbcType=TIMESTAMP}, now(), ",
        "now(), null, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{condizioniOspiteId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="movimentoOspiteId")
    int insert(CovidrsaTMovimentoOspite record);


    @Update({
        "update covidrsa_t_movimento_ospite ",
        "set ",
          "data_cancellazione = now() ",
          "where movimento_ospite_id = #{movimentoOspiteId,jdbcType=INTEGER}",
          " and data_cancellazione is null "
    })
    int logicDeleteByPrimaryKey(CovidrsaTMovimentoOspite payload);


    @Update({
        "update covidrsa_t_movimento_ospite ",
        "set ",
          "data_cancellazione = now() ",
          "where movimento_ospite_id = #{movimentoOspiteId,jdbcType=INTEGER}",
          " and data_cancellazione is null "
    })
    int logicDeleteByPrimaryKeyD(@Param("movimentoOspiteId") Integer movimentoOspiteId);

}
