/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Test;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseTestMapper;


public interface TestMapper extends BaseTestMapper{





	@Select({
		"select",
		"test_id, test_data_esecuzione, test_range_riferimento, test_valore, test_unita_misura, ",
		"test_codice_esito, test_laboratorio_desc, test_programma, id_soggetto, test_esito_id, ",
		"test_tipo_id, test_richiesta_tipo_id, intfrdet_id, utente_operazione, data_creazione, ",
		"data_modifica, data_cancellazione",
		"from test",
		"where id_soggetto = #{idSoggetto,jdbcType=BIGINT} ",
		"and data_cancellazione is null order by test_data_esecuzione desc nulls last LIMIT 1"
	})
	@Results({
		@Result(column="test_id", property="testId", jdbcType=JdbcType.BIGINT, id=true),
		@Result(column="test_data_esecuzione", property="testDataEsecuzione", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="test_range_riferimento", property="testRangeRiferimento", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_valore", property="testValore", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_unita_misura", property="testUnitaMisura", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_codice_esito", property="testCodiceEsito", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_laboratorio_desc", property="testLaboratorioDesc", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_programma", property="testProgramma", jdbcType=JdbcType.VARCHAR),
		@Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
		@Result(column="test_esito_id", property="testEsitoId", jdbcType=JdbcType.INTEGER),
		@Result(column="test_tipo_id", property="testTipoId", jdbcType=JdbcType.INTEGER),
		@Result(column="test_richiesta_tipo_id", property="testRichiestaTipoId", jdbcType=JdbcType.INTEGER),
		@Result(column="intfrdet_id", property="intfrdetId", jdbcType=JdbcType.INTEGER),
		@Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
		@Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
	})
	Test selectLastByIdSoggetto(Long idSoggetto);// verifica positivo o meno
	
	@Select({
		"select",
		"t.test_id, t.test_data_esecuzione, t.test_range_riferimento, t.test_valore, t.test_unita_misura, ",
		"t.test_codice_esito, t.test_laboratorio_desc, t.test_programma, t.id_soggetto, t.test_esito_id, ",
		"t.test_tipo_id, t.test_richiesta_tipo_id, t.intfrdet_id, t.utente_operazione, t.data_creazione, ",
		"t.data_modifica, t.data_cancellazione",
		"from test t left join covidres_r_test_struttura_info tsi on  t.test_id= tsi.test_id ",
		"where id_soggetto = #{idSoggetto,jdbcType=BIGINT} ",
		"and tsi.id_struttura =  #{idStrutturaRes,jdbcType=VARCHAR}" ,
		"and t.data_cancellazione is null",
		"and tsi.data_cancellazione is null ",
		"order by test_data_esecuzione desc nulls last LIMIT 1"
	})
	@Results({
		@Result(column="test_id", property="testId", jdbcType=JdbcType.BIGINT, id=true),
		@Result(column="test_data_esecuzione", property="testDataEsecuzione", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="test_range_riferimento", property="testRangeRiferimento", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_valore", property="testValore", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_unita_misura", property="testUnitaMisura", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_codice_esito", property="testCodiceEsito", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_laboratorio_desc", property="testLaboratorioDesc", jdbcType=JdbcType.VARCHAR),
		@Result(column="test_programma", property="testProgramma", jdbcType=JdbcType.VARCHAR),
		@Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
		@Result(column="test_esito_id", property="testEsitoId", jdbcType=JdbcType.INTEGER),
		@Result(column="test_tipo_id", property="testTipoId", jdbcType=JdbcType.INTEGER),
		@Result(column="test_richiesta_tipo_id", property="testRichiestaTipoId", jdbcType=JdbcType.INTEGER),
		@Result(column="intfrdet_id", property="intfrdetId", jdbcType=JdbcType.INTEGER),
		@Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
		@Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
	})
	Test selectLastByIdSoggettoAndIdStrutturaRes(
			@Param("idSoggetto") Long idSoggetto,
			@Param("idStrutturaRes") String idStrutturaRes);
	// Verifica positivo o meno su soggetto
}
