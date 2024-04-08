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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTIntegrazionePbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.CovidrsaTIntegrazionePbandiBo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTIntegrazionePbandiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaTIntegrazionePbandiMapper;

public interface CovidrsaTIntegrazionePbandiMapper extends BaseCovidrsaTIntegrazionePbandiMapper {

    @Select({
            "select  ",
            "ctipb.integrazione_pbandi_id, ctipb.invio_pbandi_id, ctipb.integrazione_pbandi_cod, ctipb.data_richiesta,   ",
            "ctipb.note_richiesta, ctipb.data_risposta, ctipb.validita_inizio, ctipb.validita_fine,   ",
            "ctipb.data_creazione, ctipb.data_modifica, ctipb.data_cancellazione, ctipb.data_scadenza, s.nome, s.cognome, s.codice_fiscale,   ",
            "       COUNT(*) OVER() full_count  ",
            "from covidrsa_t_integrazione_pbandi  ctipb  ",
            "join (select distinct on (ctr.invio_pbandi_id) ",
            "   ctr.invio_pbandi_id, ",
            "   ctr.id_soggetto, ",
            "   ctr.id_struttura ",
            "from ",
            "   covidrsa_t_rendicontazione ctr ",
            "where ",
            "   ctr.data_cancellazione is null ",
            "   and now() between ctr.validita_inizio and coalesce(ctr.validita_fine, now())) ctr on  ",
            "   ctr.invio_pbandi_id = ctipb.invio_pbandi_id ",
            "   and ctr.id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
            "join soggetto s on s.id_soggetto = ctr.id_soggetto   ",
            "where ctipb.data_cancellazione is null  ",
            "and now() between ctipb.validita_inizio and coalesce(ctipb.validita_fine, now())  ",
            "order by ctipb.data_creazione desc " })
    @Results({
            @Result(column = "integrazione_pbandi_id", property = "integrazionePbandiId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "invio_pbandi_id", property = "invioPbandiId", jdbcType = JdbcType.INTEGER),
            @Result(column = "integrazione_pbandi_cod", property = "integrazionePbandiCod", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_richiesta", property = "dataRichiesta", jdbcType = JdbcType.DATE),
            @Result(column = "note_richiesta", property = "noteRichiesta", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_risposta", property = "dataRisposta", jdbcType = JdbcType.DATE),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "nome", property = "soggetto.nome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cognome", property = "soggetto.cognome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "codice_fiscale", property = "soggetto.codiceFiscale", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_scadenza", property = "dataScadenza", jdbcType = JdbcType.DATE),
            @Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER)
    })
    List<CovidrsaTIntegrazionePbandiExt> selectByIdStruttura(String idStruttura);

    @Select({
            "select  ",
            "ctipb.integrazione_pbandi_id, ctipb.invio_pbandi_id, ctipb.integrazione_pbandi_cod, ctipb.data_richiesta,   ",
            "ctipb.note_richiesta, ctipb.data_risposta, ctipb.validita_inizio, ctipb.validita_fine,   ",
            "ctipb.data_creazione, ctipb.data_modifica, ctipb.data_cancellazione, ctipb.data_scadenza, s.nome, s.cognome, s.codice_fiscale ",
            "from covidrsa_t_integrazione_pbandi  ctipb  ",
            "join (select distinct on (ctr.invio_pbandi_id) ",
            "   ctr.invio_pbandi_id, ",
            "   ctr.id_soggetto, ",
            "   ctr.id_struttura from ",
            "   covidrsa_t_rendicontazione ctr ",
            "where ",
            "   ctr.data_cancellazione is null ",
            "   and now() between ctr.validita_inizio and coalesce(ctr.validita_fine, now())) ctr on  ",
            "   ctr.invio_pbandi_id = ctipb.invio_pbandi_id ",
            "   and ctr.id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
            "join soggetto s on s.id_soggetto = ctr.id_soggetto   ",
            "where  ",
            "ctipb.integrazione_pbandi_id = #{integrazionePbandiId,jdbcType=INTEGER} ",
            "and ctipb.data_cancellazione is null  ",
            "and now() between ctipb.validita_inizio and coalesce(ctipb.validita_fine, now())  "
    })
    @Results({
            @Result(column = "integrazione_pbandi_id", property = "integrazionePbandiId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "invio_pbandi_id", property = "invioPbandiId", jdbcType = JdbcType.INTEGER),
            @Result(column = "integrazione_pbandi_cod", property = "integrazionePbandiCod", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_richiesta", property = "dataRichiesta", jdbcType = JdbcType.DATE),
            @Result(column = "note_richiesta", property = "noteRichiesta", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_risposta", property = "dataRisposta", jdbcType = JdbcType.DATE),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "nome", property = "soggetto.nome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cognome", property = "soggetto.cognome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "codice_fiscale", property = "soggetto.codiceFiscale", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_scadenza", property = "dataScadenza", jdbcType = JdbcType.DATE),
            @Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER)
    })
    CovidrsaTIntegrazionePbandiExt selectByIdStrutturaAndIntegrazionePbandiId(@Param("idStruttura") String idStruttura,
            @Param("integrazionePbandiId") Integer integrazionePbandiId);
    

    @Insert({
        "insert into covidrsa_t_integrazione_pbandi (invio_pbandi_id, integrazione_pbandi_cod, ",
        "data_richiesta, note_richiesta, ",
        "data_risposta, validita_inizio, ",
        "validita_fine, utente_operazione, ",
        "data_creazione, data_modifica, ",
        "data_cancellazione,data_scadenza)",
        "values (#{invioPbandiId,jdbcType=INTEGER}, #{integrazionePbandiCod,jdbcType=VARCHAR}, ",
        "#{dataRichiesta,jdbcType=DATE}, #{noteRichiesta,jdbcType=VARCHAR}, ",
        "#{dataRisposta,jdbcType=DATE}, coalesce(#{validitaInizio,jdbcType=TIMESTAMP},now()), ",
        "#{validitaFine,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
        "now(), now(), ",
        "#{dataCancellazione,jdbcType=TIMESTAMP}, #{dataScadenza,jdbcType=DATE})"
    })
    @Options(useGeneratedKeys=true,keyProperty="integrazionePbandiId")
    int insert(CovidrsaTIntegrazionePbandi record);
    

    @Update({ "update covidrsa_t_integrazione_pbandi", "set invio_pbandi_id = #{invioPbandiId,jdbcType=INTEGER},",
            "integrazione_pbandi_cod = #{integrazionePbandiCod,jdbcType=VARCHAR},",
            "data_richiesta = #{dataRichiesta,jdbcType=DATE},", "note_richiesta = #{noteRichiesta,jdbcType=VARCHAR},",
            "data_risposta = #{dataRisposta,jdbcType=DATE},", "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
            "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
            "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
            "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
            "data_modifica = now(),",
            "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
            "data_scadenza = #{dataScadenza,jdbcType=DATE}",
            "where integrazione_pbandi_id = #{integrazionePbandiId,jdbcType=INTEGER}" })
    int updateByPrimaryKey(CovidrsaTIntegrazionePbandi record);

    

    @Select({"select ",
        "   ctipb.integrazione_pbandi_id, ",
        "   ctipb.invio_pbandi_id, ",
        "   ctbc.id_struttura, ",
        "   ctipb.integrazione_pbandi_cod, ",
        "   ctipb.data_richiesta, ",
        "   ctipb.note_richiesta, ",
        "   ctipb.data_risposta, ",
        "   ctipb.data_scadenza, ",
        "   crsw.str_res_nome, ",
        "   ( ",
        "   select ",
        "       MIN(z.data_rendicontazione) ",
        "   from ",
        "       covidrsa_t_rendicontazione z ",
        "   where ",
        "       ctipb.invio_pbandi_id = z.invio_pbandi_id ",
        "       and z.data_cancellazione is null ",
        "       and z.validita_fine is null) as periodo_inizio, ",
        "   ( ",
        "   select ",
        "       MAX(z.data_rendicontazione) ",
        "   from ",
        "       covidrsa_t_rendicontazione z ",
        "   where ",
        "       ctipb.invio_pbandi_id = z.invio_pbandi_id ",
        "       and z.data_cancellazione is null ",
        "       and z.validita_fine is null ) as periodo_fine, ",
        "   COUNT(*) over() full_count ",
        "from ",
        "   covidrsa_t_integrazione_pbandi ctipb ",
        "join ( ",
        "   select ",
        "       distinct ctr.invio_pbandi_id , ctb.id_struttura ",
        "   from ",
        "       covidrsa_t_buonores ctb ",
        "   join covidrsa_t_rendicontazione ctr on ",
        "       ctr.buonores_id = ctb.buonores_id ",
        "       and ctr.data_cancellazione is null ",
        "       and now() between ctr.validita_inizio and coalesce(ctr.validita_fine, now()) ",
        "   where ",
        "       ctb.domanda_numero = #{domandaNumero,jdbcType=VARCHAR}   ",
        "       and ctb.data_cancellazione is null ) ctbc on ",
        "   ctbc.invio_pbandi_id = ctipb.invio_pbandi_id ",
        "join covidrsa_r_struttura_welfare crsw on crsw.id_struttura = ctbc.id_struttura   ",
        "where ",
        "   true ",
        "   and ctipb.data_cancellazione is null ",
        "   and ctipb.validita_fine is null "})
    @Results({
            @Result(column = "integrazione_pbandi_id", property = "integrazionePbandiId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "invio_pbandi_id", property = "invioPbandiId", jdbcType = JdbcType.INTEGER),
            @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_res_nome", property = "strResNome", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_richiesta", property = "dataRichiesta", jdbcType = JdbcType.DATE),
            @Result(column = "note_richiesta", property = "noteRichiesta", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_scadenza", property = "dataScadenza", jdbcType = JdbcType.DATE),
            @Result(column = "data_risposta", property = "dataRisposta", jdbcType = JdbcType.DATE),
            @Result(column = "periodo_inizio", property = "periodoInizio", jdbcType = JdbcType.DATE),
            @Result(column = "periodo_fine", property = "periodoFine", jdbcType = JdbcType.DATE),
            @Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER)
    })
    List<CovidrsaTIntegrazionePbandiBo> selectByDocumentoNumero(String domandaNumero);
    
    @Select({
        "select cdwft.file_tipo_cod,  ",
        "       cdwft.file_tipo_desc,  ",
        "       ctf.file_name,  ",
        "       cripf.file_id, ",
        "       'INTEGRAZIONE' as allegato_tipo ",
        "from covidrsa_r_integrazione_pbandi_file cripf  ",
        "join covidus_t_file ctf on ctf.file_id = cripf.file_id  ",
        "join covidrsa_d_welfare_file_tipo cdwft on cdwft.file_tipo_id = cripf.file_tipo_id  ",
        "where cripf.data_cancellazione is null  ",
        " and cripf.integrazione_pbandi_id = #{integrazionePbandiId,jdbcType=INTEGER} "
        })
@Results({
        @Result(column = "file_id", property = "allegatoId", jdbcType = JdbcType.INTEGER),
        @Result(column = "file_tipo_desc", property = "allegatoTipoDesc", jdbcType = JdbcType.VARCHAR), 
        @Result(column = "file_tipo_cod", property = "allegatoTipoCod", jdbcType = JdbcType.VARCHAR), 
        @Result(column = "file_name", property = "allegatoFilename", jdbcType = JdbcType.VARCHAR),
        @Result(column = "allegato_tipo", property = "allegatoTipo", jdbcType = JdbcType.VARCHAR), 
        })
List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> selectByIntegrazioneIWhitDecodificaId(@Param("integrazionePbandiId") Integer integrazionePbandiId);


}
