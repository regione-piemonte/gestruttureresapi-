/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.SoggettoExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.dto.ModelSoggetto;

public interface SoggettoApiMapper extends SoggettoMapper {
    
    @Select({
            "<script>",
            "SELECT ",
            "  s.*, ",
            "  cd.nome_comune as nome_comune_domicilio, ",
            "  cr.nome_comune as nome_comune_residenza, ",
            "  (SELECT MIN(z.validita_inizio) ",
            "  FROM covidrsa_t_buonores z ",
            "  WHERE z.id_soggetto = s.id_soggetto ",
            "    AND z.data_cancellazione IS NULL ",
            "<if test='idStruttura != null'>",
            " and z.id_struttura = #{idStruttura,jdbcType=VARCHAR}  ",
            "</if>  ",
            "    ) presenza_inizio, ",
            "  (SELECT MAX(z.validita_fine) ",
            "  FROM covidrsa_t_buonores z ",
            "  WHERE z.id_soggetto = s.id_soggetto ",
            "    AND z.data_cancellazione IS NULL ",
            "<if test='idStruttura != null'>",
            " and z.id_struttura = #{idStruttura,jdbcType=VARCHAR}  ",
            "</if>  ",
            "    ) presenza_fine, ",
            "(SELECT MAX(z.data_movimento) ",
            "        FROM covidrsa_t_movimento_ospite z ",
            "       join covidrsa_t_rendicontazione ctr on ctr.movimento_ospite_id_uscita = z.movimento_ospite_id ",
            "        WHERE z.data_cancellazione IS NULL ",
            "          and z.id_soggetto = s.id_soggetto ",
            "<if test='idStruttura != null'>",
            " and z.id_struttura = #{idStruttura,jdbcType=VARCHAR}  ",
            "</if>  ",
            "          ) data_dimissioni_definitiva, ",
            "  COUNT(*) OVER() full_count ",
            "FROM soggetto s ",
            "JOIN comuni cd ON cd.istat_comune = s.comune_domicilio_istat ",
            "JOIN comuni cr ON cr.istat_comune = s.comune_residenza_istat ",
            "WHERE s.id_soggetto IN ( ",
            "  SELECT id_soggetto ",
            "  FROM covidrsa_t_buonores z ",
            "  WHERE z.data_cancellazione IS NULL ",
            "<if test='idStruttura != null'>",
            " and z.id_struttura = #{idStruttura,jdbcType=VARCHAR}  ",
            "</if>  ",
            "  ) ",
            "<if test='filter != null'> ",
            "       AND (codice_fiscale ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR cognome ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "         OR nome ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
            "       ) ",
            "</if> ",
            "<if test='paginazione != null'>",
            "<if test='paginazione.orderBy != null'>ORDER BY ${paginazione.orderBy} </if>  ",
            "<if test='paginazione.limit !=-1'>OFFSET #{paginazione.offset,jdbcType=BIGINT} LIMIT #{paginazione.limit,jdbcType=BIGINT}</if> ",
            "</if>  ",
            "</script>",
    })
    @Results({
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="codice_fiscale", property="codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_asr", property="idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita_str", property="dataNascitaStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_istat", property="comuneResidenzaIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilioIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_domicilio", property="indirizzoDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_recapito", property="telefonoRecapito", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita", property="dataNascita", jdbcType=JdbcType.DATE),
        @Result(column="asl_residenza", property="aslResidenza", jdbcType=JdbcType.VARCHAR),
        @Result(column="asl_domicilio", property="aslDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_tipo_soggetto", property="idTipoSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="caso_importato", property="casoImportato", jdbcType=JdbcType.VARCHAR),
        @Result(column="stato_contagio", property="statoContagio", jdbcType=JdbcType.VARCHAR),
        @Result(column="regione_contagio", property="regioneContagio", jdbcType=JdbcType.VARCHAR),
        @Result(column="presenza_inizio", property="presenzaInizio", jdbcType=JdbcType.DATE),
        @Result(column="presenza_fine", property="presenzaFine", jdbcType=JdbcType.DATE),
        @Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER),
        @Result(column="comune_residenza_istat", property="comuneResidenza.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome_comune_residenza", property="comuneResidenza.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilio.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome_comune_domicilio", property="comuneDomicilio.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_dimissioni_definitiva", property="dataDimissioniDefinitiva", jdbcType=JdbcType.DATE)
    })
    List<SoggettoExt> selectElencoByStrutturaInfoRendicontazione(@Param("filter") String filter,
            @Param("idStruttura")String idStruttura, @Param("paginazione") Paginazione paginazione);

    
    @Select({
        "<script>",
        "WITH ",
        "  ss AS ( ",
        "    SELECT ",
        "      id_soggetto, ",
        "      flg_ospite ",
        "    FROM covidres_r_soggetto_struttura_info ss ",
        "    WHERE ss.id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
        "      AND ss.data_cancellazione IS NULL ",
        "      AND ss.validita_fine IS NULL ",
        "  ), ",
        "  ms1 AS ( ",
        "    SELECT ss.id_soggetto, msa.id_medico ",
        "    FROM                    ss ",
        "    JOIN r_soggetto_aura    sa  ON sa.id_soggetto = ss.id_soggetto ",
        "    JOIN r_medico_sogg_aura msa ON sa.id_aura = msa.id_aura_sogg AND msa.data_revoca IS NULL ",
        "  ), ",
        "  ms2 AS ( ",
        "    SELECT ms.id_soggetto, ms.id_medico ",
        "    FROM                    ss ",
        "    JOIN r_medico_soggetto  ms ON ms.id_soggetto = ss.id_soggetto  ",
        "    WHERE ms.id_soggetto NOT IN (SELECT id_soggetto FROM ms1) ",
        "  ), ",
        "  ms AS ( ",
        "    SELECT * FROM ms1 ",
        "    UNION ",
        "    SELECT * FROM ms2 ",
        "  ), ",
        "  s AS ( ",
        "    SELECT ",
        "      ss.id_soggetto, ",
        "      ss.flg_ospite, ",
        "      s.codice_fiscale, ",
        "      s.documento_tipo_id, ",
        "      s.documento_numero, ",
        "      s.cognome, ",
        "      s.nome, ",
        "      s.comune_domicilio_istat, ",
        "      s.indirizzo_domicilio, ",
        "      s.telefono_recapito, ",
        "      s.data_nascita, ",
        "      s.asl_domicilio, ",
        "      s.id_tipo_soggetto, ",
        "      cdo.nome_comune comuni_domicilio_nome_comune, ",
        "      cdo.istat_comune comuni_domicilio_istat_comune, ",
        "      sr.id_decorso_ultimo, ",
        "      sr.id_tampone_ultimo, ",
        "      m.id_medico, ",
        "      m.cf_medico, ",
        "      m.codice_reg, ",
        "      m.cognome medico_cognome, ",
        "      m.nome medico_nome ",
        "    FROM                           ss ",
        "         JOIN soggetto             s   ON s.id_soggetto = ss.id_soggetto ",
        "         JOIN soggetto_ricalcolato sr  ON sr.id_soggetto = ss.id_soggetto ",
        "    LEFT JOIN comuni               cdo ON cdo.istat_comune =  s.comune_domicilio_istat ",
        "    LEFT JOIN                      ms  ON ms.id_soggetto = ss.id_soggetto ",
        "    LEFT JOIN medico               m   ON m.id_medico = ms.id_medico ",
        "    WHERE TRUE ",
        "<if test='filter != null'> ",
        "      AND (s.codice_fiscale   ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "        OR s.documento_numero ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "        OR s.cognome          ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "        OR s.nome             ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "        OR cdo.nome_comune    ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "        OR m.cognome          ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "        OR m.nome             ILIKE CONCAT('%', #{filter,jdbcType=VARCHAR},'%') ",
        "      ) ",
        " </if> ",
        "  ) ",
        "SELECT s.*, ",
        "  dt.documento_tipo_desc, ",
        "  ts.desc_tipo_soggetto, ",
        "  ts.tipologia, ",
        "  (rt.risultato_tampone = 'POSITIVO') AS ultimo_tampone_positivo, ",
        "  te.desc_tipo_evento, ",
        "  d.id_tipo_evento, ",
        "  COUNT(*) OVER() AS full_count ",
        "FROM s ",
        "LEFT JOIN d_documento_tipo dt ON dt.documento_tipo_id = s.documento_tipo_id ",
        "LEFT JOIN d_tipo_soggetto  ts ON ts.id_tipo_soggetto = s.id_tipo_soggetto ",
        "LEFT JOIN decorso          d  ON d.id_decorso = s.id_decorso_ultimo ",
        "LEFT JOIN d_tipo_evento    te ON te.id_tipo_evento = d.id_tipo_evento  ",
        "LEFT JOIN tampone          t  ON t.id_tampone = s.id_tampone_ultimo ",
        "LEFT JOIN ris_tampone      rt ON rt.id_ris_tamp = t.id_ris_tamp  ",
        "<if test='paginazione != null'>",
        "<if test='paginazione.orderBy != null'>ORDER BY ${paginazione.orderBy} </if>  ",
        "<if test='paginazione.limit !=-1'>OFFSET #{paginazione.offset,jdbcType=BIGINT} LIMIT #{paginazione.limit,jdbcType=BIGINT}</if> ",
        "</if>  ",
        "</script>"})
    @Results({
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="codice_fiscale", property="codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="documento_numero", property="documentoNumero", jdbcType=JdbcType.VARCHAR),
        @Result(column="documento_tipo_desc", property="documentoTipoDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita", property="dataNascita", jdbcType=JdbcType.DATE),
        @Result(column="telefono_recapito", property="telefonoRecapito", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_domicilio", property="indirizzodomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="asl_domicilio", property="aslDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_tipo_soggetto", property="idTipoSoggetto", jdbcType=JdbcType.INTEGER),
        @Result(column="desc_tipo_soggetto", property="descTipoSogg", jdbcType=JdbcType.VARCHAR),
        @Result(column="tipologia", property="tipologiaTipoSoggetto", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_ospite", property="flgOspite", jdbcType=JdbcType.BIT),
        @Result(column="comuni_domicilio_nome_comune", property="comuneDomicilioDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="cf_medico", property="medico.cfMedico", jdbcType=JdbcType.VARCHAR),
        @Result(column="medico_nome", property="medico.nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="medico_cognome", property="medico.cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="codice_reg", property="medico.codiceReg", jdbcType=JdbcType.VARCHAR),
        @Result(column="ultimo_tampone_positivo", property="ultimoTamponeMolecolarePositivo", jdbcType=JdbcType.BIT),
        @Result(column="id_decorso_ultimo", property="idUltimoDecorso", jdbcType=JdbcType.BIGINT),
        @Result(column="id_tipo_evento", property="idTipoUltimoDecorso", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc_tipo_evento", property="descTipoUltimoDecorso", jdbcType=JdbcType.VARCHAR),
        @Result(column="full_count", property="totalCount", jdbcType=JdbcType.BIGINT)
    })
    List<ModelSoggetto> selectElencoByStrutturaInfo(
            @Param("idStruttura")String idStruttura,
            @Param("statoEmergenza")String statoEmergenza,
            @Param("filter")String filter,
            @Param("paginazione")Paginazione paginazione);

}