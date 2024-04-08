/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.TamponeExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseTamponeMapper;



public interface TamponeMapper extends BaseTamponeMapper {

    @Select({
        "select",
        "t.id_tampone, t.id_soggetto, t.id_laboratorio, t.criterio_epidemiologico_covid19, t.id_test_covid, ",
        "t.data_test_str, t.id_ris_tamp, t.tampone_autorizzato, t.data_inserimento_richiesta, ",
        "t.data_ultima_modifica, t.utente_ultima_modifica, data_test, t.medico_richiedente, ",
        "t.contatto_richiedente, t.tampone_motivo_id, rt.risultato_tampone",
        "from tampone t left join ris_tampone rt on t.id_ris_tamp = rt.id_ris_tamp ",
        "where t.id_soggetto = #{idSoggetto,jdbcType=BIGINT} ",
        "order by data_test desc nulls last LIMIT 1"
    })
    @Results({
        @Result(column="id_tampone", property="idTampone", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="id_laboratorio", property="idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="criterio_epidemiologico_covid19", property="criterioEpidemiologicoCovid19", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_test_covid", property="idTestCovid", jdbcType=JdbcType.BIGINT),
        @Result(column="data_test_str", property="dataTestStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_ris_tamp", property="idRisTamp", jdbcType=JdbcType.BIGINT),
        @Result(column="tampone_autorizzato", property="tamponeAutorizzato", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_inserimento_richiesta", property="dataInserimentoRichiesta", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_ultima_modifica", property="dataUltimaModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_ultima_modifica", property="utenteUltimaModifica", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_test", property="dataTest", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="medico_richiedente", property="medicoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="contatto_richiedente", property="contattoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone_motivo_id", property="tamponeMotivoId", jdbcType=JdbcType.INTEGER),
        @Result(column="risultato_tampone", property="risultatoTampone", jdbcType=JdbcType.VARCHAR)
        
    })
    TamponeExt selectLastByIdSoggetto(Long idSoggetto);
    //TAMPONE DETTAGLIO
    
    
}
