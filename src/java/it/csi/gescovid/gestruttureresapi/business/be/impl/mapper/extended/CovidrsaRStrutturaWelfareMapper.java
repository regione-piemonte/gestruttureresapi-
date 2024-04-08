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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelStrutturaWelfare;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareComuni;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaRStrutturaWelfareMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfare;

public interface CovidrsaRStrutturaWelfareMapper extends BaseCovidrsaRStrutturaWelfareMapper {

    @Select({
        "WITH s AS ",
        "    (SELECT id_struttura, data_creazione, ",
        "         (SELECT COUNT(DISTINCT p.data_rilevazione) ",
        "          FROM covidrsa_t_posti p ",
        "          WHERE p.id_struttura = st.id_struttura ",
        "              AND p.data_rilevazione BETWEEN NOW() - INTERVAL '8 weeks' AND NOW()) AS cnt ",
        "     FROM struttura st ",
        "     WHERE id_struttura = #{idStruttura,jdbcType=INTEGER}) ",
        "SELECT crsw.str_welfare_id, crsw.id_struttura, crsw.rap_leg_codice_fiscale, crsw.rap_leg_cognome, crsw.rap_leg_nome, ",
        "crsw.rap_leg_comune_nascita, crsw.rap_leg_provincia_nascita, crsw.rap_leg_data_nascita, crsw.rap_leg_comune_residenza, ",
        "crsw.rap_leg_provincia_residenza, crsw.rap_leg_indirizzo_residenza, crsw.rap_leg_comune_domicilio, ",
        "crsw.rap_leg_provincia_domicilio, crsw.rap_leg_indirizzo_domicilio, crsw.rap_leg_cellulare, ",
        "crsw.rap_leg_email, crsw.ent_gest_ragione_sociale, crsw.ent_gest_comune, crsw.ent_gest_indirizzo, ",
        "crsw.ent_gest_provincia, crsw.str_res_nome, crsw.str_res_tipologia, crsw.str_res_comune, crsw.str_res_indirizzo, ",
        "crsw.str_res_provincia, crsw.validita_inizio, crsw.validita_fine, crsw.utente_operazione, crsw.data_creazione, ",
        "crsw.data_modifica, crsw.data_cancellazione, crsw.ent_gest_cf_piva, ",
        "crsw.rap_leg_verificato, crsw.rap_leg_invariato, crsw.ent_gest_verificato, crsw.ent_gest_invariato, ",
        "crsw.str_res_invariato, crsw.tit_eff_verificato, crsw.tit_eff_invariato, crsw.tit_eff_codice_fiscale, ", 
        " crsw.tit_eff_cognome, crsw.tit_eff_nome, crsw.tit_eff_data_nascita, ",
        "crsw.tit_eff_comune_nascita, crsw.tit_eff_provincia_nascita, ", 
        "crsw.tit_eff_indirizzo_residenza, crsw.tit_eff_comune_residenza, crsw.tit_eff_provincia_residenza, ",
        "(s.cnt > 7 OR s.data_creazione > NOW() - INTERVAL '8 weeks') AS rilevazioni_presenti ",
        "FROM s ",
        "LEFT JOIN covidrsa_r_struttura_welfare crsw ON crsw.id_struttura = s.id_struttura ",
        "AND crsw.data_cancellazione is NULL ",
        "AND now() BETWEEN crsw.validita_inizio AND coalesce(crsw.validita_fine, now()) "
    })
    @Results({
        @Result(column="str_welfare_id", property="strWelfareId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_codice_fiscale", property="rapLegCodiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_cognome", property="rapLegCognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_nome", property="rapLegNome", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_comune_nascita", property="rapLegComuneNascita", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_provincia_nascita", property="rapLegProvinciaNascita", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_data_nascita", property="rapLegDataNascita", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rap_leg_comune_residenza", property="rapLegComuneResidenza", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_provincia_residenza", property="rapLegProvinciaResidenza", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_indirizzo_residenza", property="rapLegIndirizzoResidenza", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_comune_domicilio", property="rapLegComuneDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_provincia_domicilio", property="rapLegProvinciaDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_indirizzo_domicilio", property="rapLegIndirizzoDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_cellulare", property="rapLegCellulare", jdbcType=JdbcType.VARCHAR),
        @Result(column="rap_leg_email", property="rapLegEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="ent_gest_ragione_sociale", property="entGestRagioneSociale", jdbcType=JdbcType.VARCHAR),
        @Result(column="ent_gest_comune", property="entGestComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="ent_gest_indirizzo", property="entGestIndirizzo", jdbcType=JdbcType.VARCHAR),
        @Result(column="ent_gest_provincia", property="entGestProvincia", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_res_nome", property="strResNome", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_res_tipologia", property="strResTipologia", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_res_comune", property="strResComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_res_indirizzo", property="strResIndirizzo", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_res_provincia", property="strResProvincia", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rilevazioni_presenti", property="rilevazioniPresenti", jdbcType=JdbcType.BOOLEAN),
        @Result(column = "ent_gest_cf_piva", property = "entGestCfPiva", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_verificato", property = "rapLegVerificato", jdbcType = JdbcType.BIT),
        @Result(column = "rap_leg_invariato", property = "rapLegInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "ent_gest_verificato", property = "entGestVerificato", jdbcType = JdbcType.BIT),
        @Result(column = "ent_gest_invariato", property = "entGestInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "str_res_invariato", property = "strResInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "tit_eff_verificato", property = "titEffVerificato", jdbcType = JdbcType.BIT),
        @Result(column = "tit_eff_invariato", property = "titEffInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "tit_eff_codice_fiscale", property = "titEffCodiceFiscale", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_cognome", property = "titEffCognome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_nome", property = "titEffNome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_data_nascita", property = "titEffDataNascita", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "tit_eff_comune_nascita", property = "titEffComuneNascita", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_provincia_nascita", property = "titEffProvinciaNascita", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_indirizzo_residenza", property = "titEffIndirizzoResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_comune_residenza", property = "titEffComuneResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_provincia_residenza", property = "titEffProvinciaResidenza", jdbcType = JdbcType.VARCHAR) 
    })
    CovidrsaRStrutturaWelfareExt selectByIdStruttura(String idStruttura);

    @Select({ "select", "str_welfare_id, id_struttura, rap_leg_codice_fiscale, rap_leg_cognome, rap_leg_nome, ",
        "rap_leg_comune_nascita, rap_leg_provincia_nascita, rap_leg_data_nascita, rap_leg_comune_residenza, ",
        "rap_leg_provincia_residenza, rap_leg_indirizzo_residenza, rap_leg_comune_domicilio, ",
        "rap_leg_provincia_domicilio, rap_leg_indirizzo_domicilio, rap_leg_cellulare, ",
        "rap_leg_email, ent_gest_ragione_sociale, ent_gest_comune, ent_gest_indirizzo, ",
        "ent_gest_provincia, str_res_nome, str_res_tipologia, str_res_comune, str_res_indirizzo, ",
        "str_res_provincia, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, ent_gest_cf_piva, rap_leg_verificato, rap_leg_invariato, ",
        "ent_gest_verificato, ent_gest_invariato, str_res_invariato, tit_eff_verificato, ",
        "tit_eff_invariato, tit_eff_codice_fiscale, tit_eff_cognome, tit_eff_nome, tit_eff_data_nascita, ",
        "tit_eff_comune_nascita, tit_eff_provincia_nascita, ", 
        "tit_eff_indirizzo_residenza, tit_eff_comune_residenza, tit_eff_provincia_residenza ",
        "from covidrsa_r_struttura_welfare ",
        "where str_welfare_id = #{strWelfareId,jdbcType=INTEGER}",
        "and data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) " })
    @Results({ @Result(column = "str_welfare_id", property = "strWelfareId", jdbcType = JdbcType.INTEGER, id = true),
        @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_codice_fiscale", property = "rapLegCodiceFiscale", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_cognome", property = "rapLegCognome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_nome", property = "rapLegNome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_comune_nascita", property = "rapLegComuneNascita", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_provincia_nascita", property = "rapLegProvinciaNascita", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_data_nascita", property = "rapLegDataNascita", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "rap_leg_comune_residenza", property = "rapLegComuneResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_provincia_residenza", property = "rapLegProvinciaResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_indirizzo_residenza", property = "rapLegIndirizzoResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_comune_domicilio", property = "rapLegComuneDomicilio", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_provincia_domicilio", property = "rapLegProvinciaDomicilio", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_indirizzo_domicilio", property = "rapLegIndirizzoDomicilio", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_cellulare", property = "rapLegCellulare", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_email", property = "rapLegEmail", jdbcType = JdbcType.VARCHAR),
        @Result(column = "ent_gest_ragione_sociale", property = "entGestRagioneSociale", jdbcType = JdbcType.VARCHAR),
        @Result(column = "ent_gest_comune", property = "entGestComune", jdbcType = JdbcType.VARCHAR),
        @Result(column = "ent_gest_indirizzo", property = "entGestIndirizzo", jdbcType = JdbcType.VARCHAR),
        @Result(column = "ent_gest_provincia", property = "entGestProvincia", jdbcType = JdbcType.VARCHAR),
        @Result(column = "str_res_nome", property = "strResNome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "str_res_tipologia", property = "strResTipologia", jdbcType = JdbcType.VARCHAR),
        @Result(column = "str_res_comune", property = "strResComune", jdbcType = JdbcType.VARCHAR),
        @Result(column = "str_res_indirizzo", property = "strResIndirizzo", jdbcType = JdbcType.VARCHAR),
        @Result(column = "str_res_provincia", property = "strResProvincia", jdbcType = JdbcType.VARCHAR),
        @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
        @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "ent_gest_cf_piva", property = "entGestCfPiva", jdbcType = JdbcType.VARCHAR),
        @Result(column = "rap_leg_verificato", property = "rapLegVerificato", jdbcType = JdbcType.BIT),
        @Result(column = "rap_leg_invariato", property = "rapLegInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "ent_gest_verificato", property = "entGestVerificato", jdbcType = JdbcType.BIT),
        @Result(column = "ent_gest_invariato", property = "entGestInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "str_res_invariato", property = "strResInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "tit_eff_verificato", property = "titEffVerificato", jdbcType = JdbcType.BIT),
        @Result(column = "tit_eff_invariato", property = "titEffInvariato", jdbcType = JdbcType.BIT),
        @Result(column = "tit_eff_codice_fiscale", property = "titEffCodiceFiscale", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_cognome", property = "titEffCognome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_nome", property = "titEffNome", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_data_nascita", property = "titEffDataNascita", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "tit_eff_comune_nascita", property = "titEffComuneNascita", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_provincia_nascita", property = "titEffProvinciaNascita", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_indirizzo_residenza", property = "titEffIndirizzoResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_comune_residenza", property = "titEffComuneResidenza", jdbcType = JdbcType.VARCHAR),
        @Result(column = "tit_eff_provincia_residenza", property = "titEffProvinciaResidenza", jdbcType = JdbcType.VARCHAR)  })
    CovidrsaRStrutturaWelfare selectByValidPrimaryKey(Integer strWelfareId);

    @Insert({ "insert into covidrsa_r_struttura_welfare (id_struttura, rap_leg_codice_fiscale, ",
        "rap_leg_cognome, rap_leg_nome, ", "rap_leg_comune_nascita, rap_leg_provincia_nascita, ",
        "rap_leg_data_nascita, rap_leg_comune_residenza, ",
        "rap_leg_provincia_residenza, rap_leg_indirizzo_residenza, ",
        "rap_leg_comune_domicilio, rap_leg_provincia_domicilio, ",
        "rap_leg_indirizzo_domicilio, rap_leg_cellulare, ", "rap_leg_email, ent_gest_ragione_sociale, ",
        "ent_gest_comune, ent_gest_indirizzo, ", "ent_gest_provincia, str_res_nome, ",
        "str_res_tipologia, str_res_comune, ", "str_res_indirizzo, str_res_provincia, ",
        "validita_inizio, validita_fine, ", "utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione, ", "ent_gest_cf_piva, rap_leg_verificato, ",
        "rap_leg_invariato, ent_gest_verificato, ", "ent_gest_invariato, str_res_invariato, ",
        "tit_eff_verificato, tit_eff_invariato, ", "tit_eff_codice_fiscale, tit_eff_cognome, ",
        "tit_eff_nome, tit_eff_data_nascita, ", "tit_eff_comune_nascita, tit_eff_provincia_nascita, ",
        "tit_eff_indirizzo_residenza, tit_eff_comune_residenza, ", "tit_eff_provincia_residenza)",
        "values (#{idStruttura,jdbcType=VARCHAR}, #{rapLegCodiceFiscale,jdbcType=VARCHAR}, ",
        "#{rapLegCognome,jdbcType=VARCHAR}, #{rapLegNome,jdbcType=VARCHAR}, ",
        "#{rapLegComuneNascita,jdbcType=VARCHAR}, #{rapLegProvinciaNascita,jdbcType=VARCHAR}, ",
        "#{rapLegDataNascita,jdbcType=TIMESTAMP}, #{rapLegComuneResidenza,jdbcType=VARCHAR}, ",
        "#{rapLegProvinciaResidenza,jdbcType=VARCHAR}, #{rapLegIndirizzoResidenza,jdbcType=VARCHAR}, ",
        "#{rapLegComuneDomicilio,jdbcType=VARCHAR}, #{rapLegProvinciaDomicilio,jdbcType=VARCHAR}, ",
        "#{rapLegIndirizzoDomicilio,jdbcType=VARCHAR}, #{rapLegCellulare,jdbcType=VARCHAR}, ",
        "#{rapLegEmail,jdbcType=VARCHAR}, #{entGestRagioneSociale,jdbcType=VARCHAR}, ",
        "#{entGestComune,jdbcType=VARCHAR}, #{entGestIndirizzo,jdbcType=VARCHAR}, ",
        "#{entGestProvincia,jdbcType=VARCHAR}, #{strResNome,jdbcType=VARCHAR}, ",
        "#{strResTipologia,jdbcType=VARCHAR}, #{strResComune,jdbcType=VARCHAR}, ",
        "#{strResIndirizzo,jdbcType=VARCHAR}, #{strResProvincia,jdbcType=VARCHAR}, ",
        "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, now(), ",
        "now(), #{dataCancellazione,jdbcType=TIMESTAMP}, ",
        "#{entGestCfPiva,jdbcType=VARCHAR}, #{rapLegVerificato,jdbcType=BIT}, ",
        "#{rapLegInvariato,jdbcType=BIT}, #{entGestVerificato,jdbcType=BIT}, ",
        "#{entGestInvariato,jdbcType=BIT}, #{strResInvariato,jdbcType=BIT}, ",
        "#{titEffVerificato,jdbcType=BIT}, #{titEffInvariato,jdbcType=BIT}, ",
        "#{titEffCodiceFiscale,jdbcType=VARCHAR}, #{titEffCognome,jdbcType=VARCHAR}, ",
        "#{titEffNome,jdbcType=VARCHAR}, #{titEffDataNascita,jdbcType=TIMESTAMP}, ",
        "#{titEffComuneNascita,jdbcType=VARCHAR}, #{titEffProvinciaNascita,jdbcType=VARCHAR}, ",
        "#{titEffIndirizzoResidenza,jdbcType=VARCHAR}, #{titEffComuneResidenza,jdbcType=VARCHAR}, ",
        "#{titEffProvinciaResidenza,jdbcType=VARCHAR})" })
    @Options(useGeneratedKeys = true, keyProperty = "strWelfareId")
    int insert(CovidrsaRStrutturaWelfare record);
    

    @Update({
        "update covidrsa_r_struttura_welfare",
        "set ",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_modifica =now(), ",
          "data_cancellazione = now() ",
        "where str_welfare_id = #{strWelfareId,jdbcType=INTEGER}"
    })
    int logicDeletByPrimaryKey(CovidrsaRStrutturaWelfare record);
    
    

    @Select({ 
            "<script>",
            "select ", "crsw.str_welfare_id, crsw.id_struttura, crsw.ent_gest_ragione_sociale, crsw.ent_gest_comune, crsw.ent_gest_indirizzo, ",
            "crsw.ent_gest_provincia, crsw.str_res_nome, crsw.str_res_tipologia, crsw.str_res_comune, crsw.str_res_indirizzo, ",
            "crsw.str_res_provincia, crsw.validita_inizio, crsw.validita_fine, crsw.utente_operazione, crsw.data_creazione, ",
            "crsw.ent_gest_cf_piva, crsw.rap_leg_verificato, crsw.rap_leg_invariato, ",
            "crsw.ent_gest_verificato, crsw.ent_gest_invariato, crsw.str_res_invariato, crsw.ent_gest_ragione_sociale, ",
            " (SELECT MAX(z.data_creazione) FROM covidrsa_r_struttura_welfare_file z ",
            " JOIN covidrsa_d_welfare_file_tipo cdwft ON cdwft.file_tipo_id = z.file_tipo_id AND cdwft.file_tipo_gruppo = 'FIN' AND cdwft.data_cancellazione is null  ",
            "and now() between cdwft.validita_inizio and coalesce(cdwft.validita_fine, now()) ",
            " WHERE z.str_welfare_id = crsw.str_welfare_id AND z.data_cancellazione IS NULL AND z.validita_fine IS NULL) data_adesione, ",
            "s.cod_struttura_arpe,  s.coord_srid,  s.coord_x,  s.coord_y, ",
            "       COUNT(*) OVER() full_count ",
            "from covidrsa_r_struttura_welfare crsw ",
            "join struttura s on s.id_struttura = crsw.id_struttura ",
            " WHERE crsw.data_cancellazione is null  ",
            "and now() between crsw.validita_inizio and coalesce(crsw.validita_fine, now()) ",
            " and exists (SELECT 1 FROM covidrsa_r_struttura_welfare_file z ",
            " JOIN covidrsa_d_welfare_file_tipo cdwft ON cdwft.file_tipo_id = z.file_tipo_id AND cdwft.file_tipo_gruppo = 'FIN' AND cdwft.data_cancellazione is null  ",
            "and now() between cdwft.validita_inizio and coalesce(cdwft.validita_fine, now()) ",
            " WHERE z.str_welfare_id = crsw.str_welfare_id AND z.data_cancellazione IS NULL AND z.validita_fine IS NULL) ",
            "<if test='denominazione != null'> and  crsw.str_res_nome ilike CONCAT('%',#{denominazione,jdbcType=VARCHAR},'%') </if> " ,
            "<if test='comune != null'> and  crsw.str_res_comune ilike CONCAT('%',#{comune,jdbcType=VARCHAR},'%') </if> " ,
            "<if test='indirizzo != null'> and  crsw.str_res_indirizzo ilike CONCAT('%',#{indirizzo,jdbcType=VARCHAR},'%') </if> " ,
            "<if test='paginazione.orderBy != null'>ORDER BY ${paginazione.orderBy} </if>  ",
            "<if test='paginazione.limit !=-1'>OFFSET #{paginazione.offset,jdbcType=BIGINT} LIMIT #{paginazione.limit,jdbcType=BIGINT}</if> ",
            "</script>" })
    @Results({ @Result(column = "str_welfare_id", property = "strWelfareId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_res_nome", property = "strResNome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_res_comune", property = "strResComune", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_res_indirizzo", property = "strResIndirizzo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_res_provincia", property = "strResProvincia", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ent_gest_cf_piva", property = "entGestCfPiva", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_adesione", property = "dataAdesione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "ent_gest_comune", property = "entGestComune", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ent_gest_indirizzo", property = "entGestIndirizzo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ent_gest_provincia", property = "entGestProvincia", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cod_struttura_arpe", property = "struttura.codStrutturaArpe", jdbcType = JdbcType.VARCHAR),
            @Result(column = "coord_srid", property = "struttura.coordSrid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "coord_x", property = "struttura.coordX", jdbcType = JdbcType.VARCHAR),
            @Result(column = "coord_y", property = "struttura.coordY", jdbcType = JdbcType.VARCHAR),       
            @Result(column="ent_gest_ragione_sociale", property="entGestRagioneSociale", jdbcType=JdbcType.VARCHAR)
})
    List<ModelStrutturaWelfare> selectFiltered(
            @Param("denominazione") String denominazione,
            @Param("comune") String  comune, 
            @Param("indirizzo") String indirizzo,
            @Param("paginazione") Paginazione paginazione);

    
    @Select({ "select distinct ",
        "str_res_comune, ",
        "str_res_provincia ",
        "from covidrsa_r_struttura_welfare ",
        "where ",
        " data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) ",            
        " and exists (SELECT 1 FROM covidrsa_r_struttura_welfare_file z ",
        " JOIN covidrsa_d_welfare_file_tipo cdwft on cdwft.file_tipo_gruppo = 'FIN' AND cdwft.data_cancellazione is null  ",
        "and now() between cdwft.validita_inizio and coalesce(cdwft.validita_fine, now()) ",
        " WHERE z.str_welfare_id = str_welfare_id AND z.data_cancellazione IS NULL AND z.validita_fine IS NULL) ",
 })
    @Results({ 
        @Result(column = "str_res_comune", property = "strResComune", jdbcType = JdbcType.VARCHAR),
        @Result(column = "str_res_provincia", property = "strResProvincia", jdbcType = JdbcType.VARCHAR)
        })
    List<CovidrsaRStrutturaWelfareComuni> selectDistinctComuni();
    


    @Select({
        " SELECT sw.rap_leg_codice_fiscale ",
        "  FROM covidrsa_r_struttura_welfare sw ",
        "  JOIN covidrsa_r_struttura_welfare_file swf ON swf.str_welfare_id = sw.str_welfare_id  ",
        "    AND swf.data_cancellazione IS NULL ",
        "    AND swf.validita_fine IS NULL ",
        "  JOIN covidrsa_d_welfare_file_tipo wft ON wft.file_tipo_id = swf.file_tipo_id ",
        "    AND wft.file_tipo_gruppo = 'FIN' ",
        "    AND wft.data_cancellazione is null ",
        "    AND NOW() BETWEEN wft.validita_inizio AND COALESCE(wft.validita_fine, NOW()) ",
        "  WHERE ",
        "  sw.id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
        "  AND sw.data_cancellazione IS NULL ",
        "  AND sw.validita_fine IS NULL ",
        "  LIMIT 1 "
        })
    String selectRapLegCodiceFiscaleFromStruttura(@Param("idStruttura") String idStruttura);
}
