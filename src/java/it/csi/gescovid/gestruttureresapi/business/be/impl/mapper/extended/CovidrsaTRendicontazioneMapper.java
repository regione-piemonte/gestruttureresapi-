/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.CovidrsaTRendicontazioneCsv;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneBackOffice;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneList;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaTRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;

public interface CovidrsaTRendicontazioneMapper extends BaseCovidrsaTRendicontazioneMapper {

    @Select({
            "<script> ",
            "select",
            "ctr.rendicontazione_id, ctr.id_struttura, ctr.id_soggetto, ctr.data_rendicontazione, ctr.importo_retta, ",
            "ctr.str_conto_id, ctr.stato_rend_id, ctr.validita_inizio, ctr.validita_fine, ",
            "ctr.data_creazione, ctr.data_modifica, ctr.data_cancellazione, ctr.utente_operazione, ctr.welfare_fascia_id, ",
            "ctr.flg_primo_ingresso, ctr.movimento_ospite_id_uscita, ctr.note, ctr.buonores_id, ",    
            "not exists (select 1 from covidrsa_t_rendicontazione z  ",
            "where z.id_struttura = ctr.id_struttura ",
            "and z.id_soggetto= ctr.id_soggetto ",
            "and z.data_rendicontazione &lt; ctr.data_rendicontazione  ",
            "and z.data_cancellazione is null  ",
            ") as flg_prima_rendicontazione, ",
            "not exists (select 1 from covidrsa_t_rendicontazione z  ",
            "where z.id_struttura = ctr.id_struttura ",
            "and z.id_soggetto= ctr.id_soggetto ",
            "and z.data_rendicontazione &gt; ctr.data_rendicontazione  ",
            "and z.data_cancellazione is null  ",
            ") as flg_ultima_rendicontazione, ",
            "exists (  ",
            "  SELECT 1   ",
            "  FROM covidrsa_t_rendicontazione z  ",
            "  WHERE z.data_cancellazione IS NULL   ",
            "    AND z.id_struttura != ctr.id_struttura   ",
            "    AND z.id_soggetto = ctr.id_soggetto   ",
            "    AND z.data_rendicontazione &lt; ctr.data_rendicontazione   ",
            "    ) AS flg_trasferito, ",
            "s.codice_fiscale, s.cognome, s.nome, s.data_nascita, ",
            "s.comune_residenza_istat, s.comune_domicilio_istat, ",        
            "cr.nome_comune as nome_comune_residenza, cd.nome_comune as nome_comune_domicilio, ", 
            "cdsr.stato_rend_cod, cdsr.stato_rend_desc, ",   
            "cdsr.flg_modificabile, cdsr.flg_stato_iniziale, ",  
            "cdsr.flg_stato_finale, ",        
            "ctmo.movimento_ospite_id, ctmo.data_movimento, ctmo.tipo_mov_ospite_id, ",
            "ctmo.id_struttura_od, ctmo.flg_preserva_posto, ctmo.note as movimento_ospite_note, ",
            "cdtmo.tipo_mov_ospite_cod, cdtmo.tipo_mov_ospite_desc, ",
            "       COUNT(*) OVER() full_count ",
            "from covidrsa_t_rendicontazione ctr ",
            " join soggetto s on ctr.id_soggetto = s.id_soggetto ",
            "join comuni cd on cd.istat_comune = s.comune_domicilio_istat ",
            "join comuni cr on cr.istat_comune = s.comune_residenza_istat ",
            "join covidrsa_d_stato_rendicontazione cdsr on cdsr.stato_rend_id = ctr.stato_rend_id ",
            "left join covidrsa_t_movimento_ospite ctmo on ctmo.movimento_ospite_id = ctr.movimento_ospite_id_uscita ",
            "left join covidrsa_d_tipo_mov_ospite cdtmo on cdtmo.tipo_mov_ospite_id = ctmo.tipo_mov_ospite_id ",
            "join covidrsa_t_buonores ctb on ctb.buonores_id = ctr.buonores_id and ctb.data_cancellazione is null ",
            "where ctr.data_cancellazione is null ",
            "and now() between ctr.validita_inizio and coalesce(ctr.validita_fine, now()) ",
            "<if test='dataRendicontazioneDaDate != null'> ",
            " and ctr.data_rendicontazione &gt;= #{dataRendicontazioneDaDate,jdbcType=TIMESTAMP} ",
            "</if> ",
            "<if test='dataRendicontazioneADate != null'> ",
            " and ctr.data_rendicontazione &lt;= #{dataRendicontazioneADate,jdbcType=TIMESTAMP} ",
            "</if> ",
            "<if test='idStruttura != null'> ",
            " and ctr.id_struttura like #{idStruttura,jdbcType=VARCHAR} ",
            "</if> ",
            "<if test='statoRendId != null'> ",
            " and ctr.stato_rend_id = #{statoRendId,jdbcType=INTEGER} ",
            "</if> ",
            "<if test='filter != null'> ",
            "       AND (s.codice_fiscale ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR s.documento_numero ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR s.cognome ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR s.nome ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "       ) ",
            "</if> ",
            "<if test='paginazione != null'>",
            "<if test='paginazione.orderBy != null'>ORDER BY ${paginazione.orderBy} </if>  ",
            "<if test='paginazione.limit !=-1'>OFFSET #{paginazione.offset,jdbcType=BIGINT} LIMIT #{paginazione.limit,jdbcType=BIGINT}</if> ",
            "</if>  ",
            " </script>",
    })
    @Results({
            @Result(column="rendicontazione_id", property="rendicontazioneId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
            @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
            @Result(column="data_rendicontazione", property="dataRendicontazione", jdbcType=JdbcType.DATE),
            @Result(column="importo_retta", property="importoRetta", jdbcType=JdbcType.NUMERIC),
            @Result(column="str_conto_id", property="strContoId", jdbcType=JdbcType.INTEGER),
            @Result(column="stato_rend_id", property="statoRendId", jdbcType=JdbcType.INTEGER),
            @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
            @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER),
            @Result(column="flg_primo_ingresso", property="flgPrimoIngresso", jdbcType=JdbcType.BIT),
            @Result(column="movimento_ospite_id_uscita", property="movimentoOspiteIdUscita", jdbcType=JdbcType.INTEGER),
            @Result(column = "note", property = "note", jdbcType = JdbcType.VARCHAR),
            @Result(column = "buonores_id", property = "buonoresId", jdbcType = JdbcType.INTEGER),

            @Result(column="flg_prima_rendicontazione", property="flgPrimaRendicontazione", jdbcType=JdbcType.BIT),
            @Result(column="flg_ultima_rendicontazione", property="flgUltimaRendicontazione", jdbcType=JdbcType.BIT),
            @Result(column="flg_trasferito", property="flgTrasferito", jdbcType=JdbcType.BIT),
            
            @Result(column = "codice_fiscale", property = "soggetto.codiceFiscale", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cognome", property = "soggetto.cognome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nome", property = "soggetto.nome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_nascita", property = "soggetto.dataNascita", jdbcType = JdbcType.DATE),
            @Result(column = "comune_residenza_istat", property = "soggetto.comuneResidenzaIstat", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comune_domicilio_istat", property = "soggetto.comuneDomicilioIstat", jdbcType = JdbcType.VARCHAR),
           
            @Result(column="comune_residenza_istat", property="comuneResidenza.istatComune", jdbcType=JdbcType.VARCHAR),
            @Result(column="nome_comune_residenza", property="comuneResidenza.nomeComune", jdbcType=JdbcType.VARCHAR),
            @Result(column="comune_domicilio_istat", property="comuneDomicilio.istatComune", jdbcType=JdbcType.VARCHAR),
            @Result(column="nome_comune_domicilio", property="comuneDomicilio.nomeComune", jdbcType=JdbcType.VARCHAR),
            
            @Result(column = "stato_rend_id", property = "covidrsaDStatoRendicontazione.statoRendId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "stato_rend_cod", property = "covidrsaDStatoRendicontazione.statoRendCod", jdbcType = JdbcType.VARCHAR),
            @Result(column = "stato_rend_desc", property = "covidrsaDStatoRendicontazione.statoRendDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "flg_modificabile", property = "covidrsaDStatoRendicontazione.flgModificabile", jdbcType = JdbcType.BIT),
            @Result(column = "flg_stato_iniziale", property = "covidrsaDStatoRendicontazione.flgStatoIniziale", jdbcType = JdbcType.BIT),
            @Result(column = "flg_stato_finale", property = "covidrsaDStatoRendicontazione.flgStatoFinale", jdbcType = JdbcType.BIT),
            
            @Result(column="movimento_ospite_id", property="movimentoOspiteUscita.movimentoOspiteId", jdbcType=JdbcType.INTEGER),
            @Result(column="data_movimento", property="movimentoOspiteUscita.dataMovimento", jdbcType=JdbcType.DATE),
            @Result(column="tipo_mov_ospite_id", property="movimentoOspiteUscita.tipoMovOspiteId", jdbcType=JdbcType.INTEGER),
            @Result(column="id_struttura_od", property="movimentoOspiteUscita.idStrutturaOd", jdbcType=JdbcType.VARCHAR),
            @Result(column="flg_preserva_posto", property="movimentoOspiteUscita.flgPreservaPosto", jdbcType=JdbcType.BIT),
            @Result(column="movimento_ospite_note", property="movimentoOspiteUscita.note", jdbcType=JdbcType.VARCHAR),
            
            @Result(column="tipo_mov_ospite_id", property="movimentoOspiteUscita.covidrsaDTipoMovOspite.tipoMovOspiteId", jdbcType=JdbcType.INTEGER),
            @Result(column="tipo_mov_ospite_cod", property="movimentoOspiteUscita.covidrsaDTipoMovOspite.tipoMovOspiteCod", jdbcType=JdbcType.VARCHAR),
            @Result(column="tipo_mov_ospite_desc", property="movimentoOspiteUscita.covidrsaDTipoMovOspite.tipoMovOspiteDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER),
    })
    List<CovidrsaTRendicontazioneList> selectListFrom(@Param("dataRendicontazioneDaDate") Date dataRendicontazioneDaDate,
            @Param("dataRendicontazioneADate") Date dataRendicontazioneADate,
            @Param("filter") String filter, @Param("idStruttura") String idStruttura,
            @Param("paginazione") Paginazione paginazione, @Param("statoRendId") Integer statoRendId);

    @Select({
            "<script> ",
            "select",
            "ctr.rendicontazione_id, ctr.id_struttura, ctr.id_soggetto, ctr.data_rendicontazione, ctr.importo_retta, ",
            "ctr.str_conto_id, ctr.stato_rend_id, ctr.validita_inizio, ctr.validita_fine, ",
            "ctr.data_creazione, ctr.data_modifica, ctr.data_cancellazione, ctr.utente_operazione, ctr.welfare_fascia_id, ",
            "ctr.flg_primo_ingresso, ctr.movimento_ospite_id_uscita, ctr.note, ctr.buonores_id, ",  
            "s.codice_fiscale, s.cognome, s.nome, s.data_nascita, ",
            "s.comune_residenza_istat, s.comune_domicilio_istat, ",        
            "cr.nome_comune as nome_comune_residenza, cd.nome_comune as nome_comune_domicilio, ", 
            "cdsr.stato_rend_cod, cdsr.stato_rend_desc, ",   
            "cdsr.flg_modificabile, cdsr.flg_stato_iniziale, ",  
            "cdsr.flg_stato_finale, ",        
            "ctmo.movimento_ospite_id, ctmo.data_movimento, ctmo.tipo_mov_ospite_id, ",
            "ctmo.id_struttura_od, ctmo.flg_preserva_posto, ctmo.note as movimento_ospite_note, ",
            "cdtmo.tipo_mov_ospite_cod, cdtmo.tipo_mov_ospite_desc, ",
            "       COUNT(*) OVER() full_count ",
            "from covidrsa_t_rendicontazione ctr ",
            " join soggetto s on ctr.id_soggetto = s.id_soggetto ",
            "join comuni cd on cd.istat_comune = s.comune_domicilio_istat ",
            "join comuni cr on cr.istat_comune = s.comune_residenza_istat ",
            "join covidrsa_d_stato_rendicontazione cdsr on cdsr.stato_rend_id = ctr.stato_rend_id ",
            "left join covidrsa_t_movimento_ospite ctmo on ctmo.movimento_ospite_id = ctr.movimento_ospite_id_uscita ",
            "left join covidrsa_d_tipo_mov_ospite cdtmo on cdtmo.tipo_mov_ospite_id = ctmo.tipo_mov_ospite_id ",
            "where ctr.data_cancellazione is null ",
            "and now() between ctr.validita_inizio and coalesce(ctr.validita_fine, now()) ",
            "<if test='dataRendicontazioneDaDate != null'> ",
            " and ctr.data_rendicontazione &gt;= #{dataRendicontazioneDaDate,jdbcType=TIMESTAMP} ",
            "</if> ",
            "<if test='dataRendicontazioneADate != null'> ",
            " and ctr.data_rendicontazione &lt;= #{dataRendicontazioneADate,jdbcType=TIMESTAMP} ",
            "</if> ",
            "<if test='idStruttura != null'> ",
            " and ctr.id_struttura like #{idStruttura,jdbcType=VARCHAR} ",
            "</if> ",
            "<if test='statoRendId != null'> ",
            " and ctr.stato_rend_id = #{statoRendId,jdbcType=INTEGER} ",
            "</if> ",
            "<if test='filter != null'> ",
            "       AND (s.codice_fiscale ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR s.documento_numero ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR s.cognome ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR s.nome ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "       ) ",
            "</if> ",
            " </script>",
    })
    @Results({
            @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
            @Result(column="data_rendicontazione", property="dataRendicontazione", jdbcType=JdbcType.DATE),
            @Result(column="importo_retta", property="importoRetta", jdbcType=JdbcType.NUMERIC),
            @Result(column="flg_primo_ingresso", property="flgPrimoIngresso", jdbcType=JdbcType.BIT),
            @Result(column = "note", property = "note", jdbcType = JdbcType.VARCHAR),
            @Result(column = "buonores_id", property = "buonoresId", jdbcType = JdbcType.INTEGER),
            @Result(column = "codice_fiscale", property = "codiceFiscale", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_nascita", property = "dataNascita", jdbcType = JdbcType.DATE),
            @Result(column = "stato_rend_desc", property = "statoRendicontazione", jdbcType = JdbcType.VARCHAR),
            @Result(column="data_movimento", property="dataUscita", jdbcType=JdbcType.DATE),
            @Result(column="tipo_mov_ospite_desc", property="motivoUscita", jdbcType=JdbcType.VARCHAR),
    })
    List<CovidrsaTRendicontazioneCsv> selectListForCsvFrom(@Param("dataRendicontazioneDaDate") Date dataRendicontazioneDaDate,
            @Param("dataRendicontazioneADate") Date dataRendicontazioneADate,
            @Param("filter") String filter, @Param("idStruttura") String idStruttura,
            @Param("statoRendId") Integer statoRendId);


    @Select({
        "select",
        "ctr.rendicontazione_id, ctr.id_struttura, ctr.id_soggetto, ctr.data_rendicontazione, ctr.importo_retta, ",
        "ctr.str_conto_id, ctr.stato_rend_id, ctr.validita_inizio, ctr.validita_fine, ",
        "ctr.data_creazione, ctr.data_modifica, ctr.data_cancellazione, ctr.utente_operazione, ctr.welfare_fascia_id, ",
        "ctr.flg_primo_ingresso, ctr.movimento_ospite_id_uscita, ctr.note, ctr.buonores_id, ", 
        " ctr.invio_pbandi_id, ",
        "ctr.rendicontazione_cod, ctr.rendicontazione_cod_ext, ",
        "not exists (select 1 from covidrsa_t_rendicontazione z  ",
        "where z.id_struttura = ctr.id_struttura ",
        "and z.id_soggetto= ctr.id_soggetto ",
        "and z.data_rendicontazione < ctr.data_rendicontazione  ",
        ") as flg_prima_rendicontazione ",
        "from covidrsa_t_rendicontazione ctr",
        "where ctr.rendicontazione_id = #{rendicontazioneId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rendicontazione_id", property="rendicontazioneId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rendicontazione", property="dataRendicontazione", jdbcType=JdbcType.DATE),
        @Result(column="importo_retta", property="importoRetta", jdbcType=JdbcType.NUMERIC),
        @Result(column="str_conto_id", property="strContoId", jdbcType=JdbcType.INTEGER),
        @Result(column="stato_rend_id", property="statoRendId", jdbcType=JdbcType.INTEGER),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER),
        @Result(column="flg_primo_ingresso", property="flgPrimoIngresso", jdbcType=JdbcType.BIT),
        @Result(column="movimento_ospite_id_uscita", property="movimentoOspiteIdUscita", jdbcType=JdbcType.INTEGER),
        @Result(column = "note", property = "note", jdbcType = JdbcType.VARCHAR),
        @Result(column = "buonores_id", property = "buonoresId", jdbcType = JdbcType.INTEGER),
        @Result(column="flg_prima_rendicontazione", property="flgPrimaRendicontazione", jdbcType=JdbcType.BIT),
        @Result(column="invio_pbandi_id", property="invioPbandiId", jdbcType=JdbcType.INTEGER),
        @Result(column="rendicontazione_cod", property="rendicontazioneCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="rendicontazione_cod_ext", property="rendicontazioneCodExt", jdbcType=JdbcType.VARCHAR)
    })
    CovidrsaTRendicontazioneList selectByPrimaryKeyWhitPrimoIngresso(Integer rendicontazioneId);
    
    @Insert({
        "insert into covidrsa_t_rendicontazione (id_struttura, id_soggetto, ",
        "data_rendicontazione, importo_retta, ",
        "str_conto_id,  ",
        "stato_rend_id, validita_inizio, ",
        "validita_fine, data_creazione, ",
        "data_modifica, data_cancellazione, ",
        "utente_operazione, welfare_fascia_id, ",
        "flg_primo_ingresso, movimento_ospite_id_uscita, note, ",
        "buonores_id, invio_pbandi_id, ",
        "rendicontazione_cod, rendicontazione_cod_ext, ",
        "note_operazione)",
        "values (#{idStruttura,jdbcType=VARCHAR}, #{idSoggetto,jdbcType=INTEGER}, ",
        "#{dataRendicontazione,jdbcType=DATE}, #{importoRetta,jdbcType=NUMERIC}, ",
        "#{strContoId,jdbcType=INTEGER}, ",
        "#{statoRendId,jdbcType=INTEGER}, coalesce(#{validitaInizio,jdbcType=TIMESTAMP},now()), ",
        "#{validitaFine,jdbcType=TIMESTAMP}, now(), ",
        "now(), #{dataCancellazione,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{welfareFasciaId,jdbcType=INTEGER}, ",
        "#{flgPrimoIngresso,jdbcType=BIT}, #{movimentoOspiteIdUscita,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR}, ",
        "#{buonoresId,jdbcType=INTEGER}, #{invioPbandiId,jdbcType=INTEGER}, ",
        "#{rendicontazioneCod,jdbcType=VARCHAR}, #{rendicontazioneCodExt,jdbcType=VARCHAR}, ",
        "#{noteOperazione,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "rendicontazioneId")
    int insert(CovidrsaTRendicontazione record);

    @Update({
            "update covidrsa_t_rendicontazione",
            "set ",
            "validita_fine = now() ",
            "where rendicontazione_id = #{rendicontazioneId,jdbcType=INTEGER}",
            " and data_cancellazione is null ",
            " and validita_fine is null "
    })
    int updateValiditaFine(CovidrsaTRendicontazione record);


    @Update({
            "update covidrsa_t_rendicontazione",
            "set ",
            "data_cancellazione = now() ",
            "where id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
            " and id_soggetto = #{idSoggetto,jdbcType=INTEGER} ",
            " and data_rendicontazione = #{dataRendicontazione,jdbcType=DATE} ",
            " and data_cancellazione is null "
    })
    int deleteBySoggettoStrutturaAndData(CovidrsaTRendicontazione current);

    @Update({
            "update covidrsa_t_rendicontazione",
            "set ",
            "data_cancellazione = now() ",
            "where id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
            " and id_soggetto = #{idSoggetto,jdbcType=INTEGER} ",
            " and data_rendicontazione > #{dataRendicontazione,jdbcType=DATE} ",
            " and data_cancellazione is null "
    })
    int deleteBySoggettoStrutturaAndAfterData(@Param("idStruttura")String idStruttura, 
            @Param("idSoggetto")Integer idSoggetto,
            @Param("dataRendicontazione")Date dataRendicontazione);

    @Select({ 
    "select count(*) from covidrsa_t_rendicontazione ctr  ",
    "join covidrsa_r_rendicontazione_file crrf on crrf.rendicontazione_id = ctr.rendicontazione_id  ",
    "join covidrsa_d_welfare_file_tipo cdwft on cdwft.file_tipo_id = crrf.file_tipo_id and cdwft.file_tipo_obbligatorio  ",
    "and cdwft.file_tipo_gruppo = #{fileTipoGruppo,jdbcType=VARCHAR} ",
    "where ctr.rendicontazione_id = #{rendicontazioneId,jdbcType=INTEGER} ",
    "and ctr.data_cancellazione is null ",
    "and now() between ctr.validita_inizio and coalesce(ctr.validita_fine, now()) ",
     })
    Integer countFileObbligatoriInseriti(@Param("rendicontazioneId") Integer rendicontazioneId, @Param("fileTipoGruppo") String gruppo);

    @Select({
        "select",
        "rendicontazione_id, id_struttura, id_soggetto, data_rendicontazione, importo_retta, ",
        "str_conto_id, stato_rend_id, validita_inizio, validita_fine, data_creazione, ",
        "data_modifica, data_cancellazione, utente_operazione, welfare_fascia_id, flg_primo_ingresso, ",
        "movimento_ospite_id_uscita, note, buonores_id, invio_pbandi_id, rendicontazione_cod, ",
        "rendicontazione_cod_ext",
        "from covidrsa_t_rendicontazione",
        "where rendicontazione_cod = #{rendicontazioneCod,jdbcType=VARCHAR} ",
        "and data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) ",
    })
    @Results({
        @Result(column="rendicontazione_id", property="rendicontazioneId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rendicontazione", property="dataRendicontazione", jdbcType=JdbcType.DATE),
        @Result(column="importo_retta", property="importoRetta", jdbcType=JdbcType.NUMERIC),
        @Result(column="str_conto_id", property="strContoId", jdbcType=JdbcType.INTEGER),
        @Result(column="stato_rend_id", property="statoRendId", jdbcType=JdbcType.INTEGER),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER),
        @Result(column="flg_primo_ingresso", property="flgPrimoIngresso", jdbcType=JdbcType.BIT),
        @Result(column="movimento_ospite_id_uscita", property="movimentoOspiteIdUscita", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="buonores_id", property="buonoresId", jdbcType=JdbcType.INTEGER),
        @Result(column="invio_pbandi_id", property="invioPbandiId", jdbcType=JdbcType.INTEGER),
        @Result(column="rendicontazione_cod", property="rendicontazioneCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="rendicontazione_cod_ext", property="rendicontazioneCodExt", jdbcType=JdbcType.VARCHAR)
    })
    CovidrsaTRendicontazione selectByRendicontazioneCod(String rendicontazioneCod);
    @Select({
        "select",
        "rendicontazione_id, id_struttura, id_soggetto, data_rendicontazione, importo_retta, ",
        "str_conto_id, stato_rend_id, validita_inizio, validita_fine, data_creazione, ",
        "data_modifica, data_cancellazione, utente_operazione, welfare_fascia_id, flg_primo_ingresso, ",
        "movimento_ospite_id_uscita, note, buonores_id, invio_pbandi_id, rendicontazione_cod, ",
        "rendicontazione_cod_ext",
        "from covidrsa_t_rendicontazione",
        "where invio_pbandi_id = #{invioPbandiId,jdbcType=INTEGER} ",
        "and data_rendicontazione = #{dataRendicontazione,jdbcType=DATE}  ",
        "and data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) ",
    })
    @Results({
        @Result(column="rendicontazione_id", property="rendicontazioneId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rendicontazione", property="dataRendicontazione", jdbcType=JdbcType.DATE),
        @Result(column="importo_retta", property="importoRetta", jdbcType=JdbcType.NUMERIC),
        @Result(column="str_conto_id", property="strContoId", jdbcType=JdbcType.INTEGER),
        @Result(column="stato_rend_id", property="statoRendId", jdbcType=JdbcType.INTEGER),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER),
        @Result(column="flg_primo_ingresso", property="flgPrimoIngresso", jdbcType=JdbcType.BIT),
        @Result(column="movimento_ospite_id_uscita", property="movimentoOspiteIdUscita", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="buonores_id", property="buonoresId", jdbcType=JdbcType.INTEGER),
        @Result(column="invio_pbandi_id", property="invioPbandiId", jdbcType=JdbcType.INTEGER),
        @Result(column="rendicontazione_cod", property="rendicontazioneCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="rendicontazione_cod_ext", property="rendicontazioneCodExt", jdbcType=JdbcType.VARCHAR)
    })
    CovidrsaTRendicontazione selectByRendicontazioneByInvioPBandiId(@Param("invioPbandiId") Integer invioPbandiId ,@Param("dataRendicontazione")  Date dataRendicontazione);
    
    

    @Update({
        "update covidrsa_t_rendicontazione",
        "set id_struttura = #{idStruttura,jdbcType=VARCHAR},",
          "id_soggetto = #{idSoggetto,jdbcType=INTEGER},",
          "data_rendicontazione = #{dataRendicontazione,jdbcType=DATE},",
          "importo_retta = #{importoRetta,jdbcType=NUMERIC},",
          "str_conto_id = #{strContoId,jdbcType=INTEGER},",
          "stato_rend_id = #{statoRendId,jdbcType=INTEGER},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifica = now(),",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "welfare_fascia_id = #{welfareFasciaId,jdbcType=INTEGER},",
          "flg_primo_ingresso = #{flgPrimoIngresso,jdbcType=BIT},",
          "movimento_ospite_id_uscita = #{movimentoOspiteIdUscita,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR},",
          "buonores_id = #{buonoresId,jdbcType=INTEGER},",
          "invio_pbandi_id = #{invioPbandiId,jdbcType=INTEGER},",
          "rendicontazione_cod = #{rendicontazioneCod,jdbcType=VARCHAR},",
          "rendicontazione_cod_ext = #{rendicontazioneCodExt,jdbcType=VARCHAR},",
          "note_operazione = #{noteOperazione,jdbcType=VARCHAR}",
        "where rendicontazione_id = #{rendicontazioneId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CovidrsaTRendicontazione record);
    
    @Select({"select ctr.*,ctip.invio_pbandi_cod, ctip.invio_data, ctip.invio_pbandi_uuid_ext,crsc.str_conto_iban,  ",
        "s.cod_struttura_arpe, crsw.ent_gest_cf_piva , crsw.str_res_nome , ctmo.data_movimento,  ",
        "cdtmo.tipo_mov_ospite_desc,cdwf.welfare_fascia_desc, cdsr.stato_rend_desc , cdsr.stato_rend_cod  ",
        "from covidrsa_t_rendicontazione ctr   ",
        "join covidrsa_d_stato_rendicontazione cdsr on cdsr.stato_rend_id = ctr.stato_rend_id   ",
        " and cdsr.stato_rend_cod != 'BOZZA' ",
        "join covidrsa_t_buonores ctb on ctb.buonores_id = ctr.buonores_id  ",
        "and ctb.domanda_numero = #{domandaNumero,jdbcType=VARCHAR} ",
        "and ctb.data_cancellazione is null ",
        "left join covidrsa_t_invio_pbandi ctip on ctr.invio_pbandi_id = ctip.invio_pbandi_id   ",
        "left join covidrsa_r_struttura_conto crsc ON crsc.str_conto_id = ctr.str_conto_id  ",
        "join struttura s on s.id_struttura = ctr.id_struttura   ",
        "join covidrsa_r_struttura_welfare crsw on crsw.id_struttura = s.id_struttura   ",
        "left join covidrsa_t_movimento_ospite ctmo on ctmo.movimento_ospite_id = ctr.movimento_ospite_id_uscita  ",
        "left join covidrsa_d_tipo_mov_ospite cdtmo on cdtmo.tipo_mov_ospite_id = ctmo.tipo_mov_ospite_id  ",
        "left join covidrsa_d_welfare_fascia cdwf on cdwf.welfare_fascia_id = ctr.welfare_fascia_id   ",
        "where ctr.data_cancellazione is null and ctr.validita_fine is null ",
        "order by ctr.id_struttura, ctr.stato_rend_id ,ctr.invio_pbandi_id, ctr.data_rendicontazione   "})
@Results({
    @Result(column="rendicontazione_id", property="rendicontazioneId", jdbcType=JdbcType.INTEGER, id=true),
    @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
    @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
    @Result(column="data_rendicontazione", property="dataRendicontazione", jdbcType=JdbcType.DATE),
    @Result(column="importo_retta", property="importoRetta", jdbcType=JdbcType.NUMERIC),
    @Result(column="str_conto_id", property="strContoId", jdbcType=JdbcType.INTEGER),
    @Result(column="stato_rend_id", property="statoRendId", jdbcType=JdbcType.INTEGER),
    @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
    @Result(column="welfare_fascia_id", property="welfareFasciaId", jdbcType=JdbcType.INTEGER),
    @Result(column="flg_primo_ingresso", property="flgPrimoIngresso", jdbcType=JdbcType.BIT),
    @Result(column="movimento_ospite_id_uscita", property="movimentoOspiteIdUscita", jdbcType=JdbcType.INTEGER),
    @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
    @Result(column="buonores_id", property="buonoresId", jdbcType=JdbcType.INTEGER),
    @Result(column="invio_pbandi_id", property="invioPbandiId", jdbcType=JdbcType.INTEGER),
    @Result(column="rendicontazione_cod", property="rendicontazioneCod", jdbcType=JdbcType.VARCHAR),
    @Result(column="rendicontazione_cod_ext", property="rendicontazioneCodExt", jdbcType=JdbcType.VARCHAR),

    @Result(column="invio_pbandi_cod", property="invioPbandi.invioPbandiCod", jdbcType=JdbcType.VARCHAR),
    @Result(column="invio_data", property="invioPbandi.invioData", jdbcType=JdbcType.DATE),
    @Result(column="invio_pbandi_uuid_ext", property="invioPbandi.invioPbandiUuidExt", jdbcType=JdbcType.VARCHAR),

    @Result(column="str_conto_iban", property="conto.strContoIban", jdbcType=JdbcType.VARCHAR),

    @Result(column="cod_struttura_arpe", property="strutturaArpe", jdbcType=JdbcType.VARCHAR),

    @Result(column="ent_gest_cf_piva", property="strutturaWelfare.entGestCfPiva", jdbcType=JdbcType.VARCHAR),
    @Result(column="str_res_nome", property="strutturaWelfare.strResNome", jdbcType=JdbcType.VARCHAR),

    @Result(column="data_movimento", property="movimentoOspite.dataMovimento", jdbcType=JdbcType.DATE),

    @Result(column="tipo_mov_ospite_desc", property="movimentoOspiteDescrizione.tipoMovOspiteDesc", jdbcType=JdbcType.VARCHAR),
    
    @Result(column="welfare_fascia_desc", property="fascia.welfareFasciaDesc", jdbcType=JdbcType.VARCHAR),

    @Result(column="stato_rend_desc", property="statoRendicontazione.statoRendDesc", jdbcType=JdbcType.VARCHAR),
    @Result(column="stato_rend_cod", property="statoRendicontazione.statoRendCod", jdbcType=JdbcType.VARCHAR),
    
    @Result(column="data_creazione", property="dataIstruttoria", jdbcType=JdbcType.DATE),
    @Result(column="note_operazione", property="noteIstruttoria", jdbcType=JdbcType.VARCHAR),
    
})
List<CovidrsaTRendicontazioneBackOffice> selectListRendicontazioniFromDomandaNumero(
        @Param("domandaNumero") String domandaNumero);

    @Select({
        "select ctb.domanda_numero from covidrsa_t_buonores ctb ",
        "join covidrsa_t_rendicontazione ctr on ctr.buonores_id = ctb.buonores_id and ctr.invio_pbandi_id = #{invioPbandiId,jdbcType=INTEGER} ",
        "and ctr.data_cancellazione is null ",
        "limit 1; "
    })
    String selectDomandaNumeroFromInvioPbandiId(Integer invioPbandiId);
    
    
}
