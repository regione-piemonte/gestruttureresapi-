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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Test;



public interface BaseTestMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test
	 * @mbg.generated
	 */
	@Delete({ "delete from test", "where test_id = #{testId,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long testId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test
	 * @mbg.generated
	 */
	@Insert({ "insert into test (test_data_esecuzione, test_range_riferimento, ", "test_valore, test_unita_misura, ",
			"test_codice_esito, test_laboratorio_desc, ", "test_programma, id_soggetto, ",
			"test_esito_id, test_tipo_id, ", "test_richiesta_tipo_id, intfrdet_id, ",
			"utente_operazione, data_creazione, ", "data_modifica, data_cancellazione, ",
			"test_stato_id, data_prelievo_effettiva, ", "test_rapido_jrc_id, webapp_operazione, ",
			"id_profilo_operazione, ruolo_operazione, ", "id_ente_operazione, id_struttura_operazione, ",
			"id_area_operazione)",
			"values (#{testDataEsecuzione,jdbcType=TIMESTAMP}, #{testRangeRiferimento,jdbcType=VARCHAR}, ",
			"#{testValore,jdbcType=VARCHAR}, #{testUnitaMisura,jdbcType=VARCHAR}, ",
			"#{testCodiceEsito,jdbcType=VARCHAR}, #{testLaboratorioDesc,jdbcType=VARCHAR}, ",
			"#{testProgramma,jdbcType=VARCHAR}, #{idSoggetto,jdbcType=BIGINT}, ",
			"#{testEsitoId,jdbcType=INTEGER}, #{testTipoId,jdbcType=INTEGER}, ",
			"#{testRichiestaTipoId,jdbcType=INTEGER}, #{intfrdetId,jdbcType=INTEGER}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP}, ",
			"#{testStatoId,jdbcType=INTEGER}, #{dataPrelievoEffettiva,jdbcType=TIMESTAMP}, ",
			"#{testRapidoJrcId,jdbcType=INTEGER}, #{webappOperazione,jdbcType=VARCHAR}, ",
			"#{idProfiloOperazione,jdbcType=INTEGER}, #{ruoloOperazione,jdbcType=VARCHAR}, ",
			"#{idEnteOperazione,jdbcType=INTEGER}, #{idStrutturaOperazione,jdbcType=VARCHAR}, ",
			"#{idAreaOperazione,jdbcType=INTEGER})" })
	@Options(useGeneratedKeys = true, keyProperty = "testId")
	int insert(Test record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test
	 * @mbg.generated
	 */
	@Select({ "select", "test_id, test_data_esecuzione, test_range_riferimento, test_valore, test_unita_misura, ",
			"test_codice_esito, test_laboratorio_desc, test_programma, id_soggetto, test_esito_id, ",
			"test_tipo_id, test_richiesta_tipo_id, intfrdet_id, utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione, test_stato_id, data_prelievo_effettiva, test_rapido_jrc_id, ",
			"webapp_operazione, id_profilo_operazione, ruolo_operazione, id_ente_operazione, ",
			"id_struttura_operazione, id_area_operazione", "from test", "where test_id = #{testId,jdbcType=BIGINT}" })
	@Results({ @Result(column = "test_id", property = "testId", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "test_data_esecuzione", property = "testDataEsecuzione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "test_range_riferimento", property = "testRangeRiferimento", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_valore", property = "testValore", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_unita_misura", property = "testUnitaMisura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_codice_esito", property = "testCodiceEsito", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_laboratorio_desc", property = "testLaboratorioDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_programma", property = "testProgramma", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
			@Result(column = "test_esito_id", property = "testEsitoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "test_tipo_id", property = "testTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "test_richiesta_tipo_id", property = "testRichiestaTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "intfrdet_id", property = "intfrdetId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "test_stato_id", property = "testStatoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "data_prelievo_effettiva", property = "dataPrelievoEffettiva", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "test_rapido_jrc_id", property = "testRapidoJrcId", jdbcType = JdbcType.INTEGER),
			@Result(column = "webapp_operazione", property = "webappOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "ruolo_operazione", property = "ruoloOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente_operazione", property = "idEnteOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura_operazione", property = "idStrutturaOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_area_operazione", property = "idAreaOperazione", jdbcType = JdbcType.INTEGER) })
	Test selectByPrimaryKey(Long testId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test
	 * @mbg.generated
	 */
	@Select({ "select", "test_id, test_data_esecuzione, test_range_riferimento, test_valore, test_unita_misura, ",
			"test_codice_esito, test_laboratorio_desc, test_programma, id_soggetto, test_esito_id, ",
			"test_tipo_id, test_richiesta_tipo_id, intfrdet_id, utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione, test_stato_id, data_prelievo_effettiva, test_rapido_jrc_id, ",
			"webapp_operazione, id_profilo_operazione, ruolo_operazione, id_ente_operazione, ",
			"id_struttura_operazione, id_area_operazione", "from test" })
	@Results({ @Result(column = "test_id", property = "testId", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "test_data_esecuzione", property = "testDataEsecuzione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "test_range_riferimento", property = "testRangeRiferimento", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_valore", property = "testValore", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_unita_misura", property = "testUnitaMisura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_codice_esito", property = "testCodiceEsito", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_laboratorio_desc", property = "testLaboratorioDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "test_programma", property = "testProgramma", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
			@Result(column = "test_esito_id", property = "testEsitoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "test_tipo_id", property = "testTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "test_richiesta_tipo_id", property = "testRichiestaTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "intfrdet_id", property = "intfrdetId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "test_stato_id", property = "testStatoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "data_prelievo_effettiva", property = "dataPrelievoEffettiva", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "test_rapido_jrc_id", property = "testRapidoJrcId", jdbcType = JdbcType.INTEGER),
			@Result(column = "webapp_operazione", property = "webappOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "ruolo_operazione", property = "ruoloOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente_operazione", property = "idEnteOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura_operazione", property = "idStrutturaOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_area_operazione", property = "idAreaOperazione", jdbcType = JdbcType.INTEGER) })
	List<Test> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test
	 * @mbg.generated
	 */
	@Update({ "update test", "set test_data_esecuzione = #{testDataEsecuzione,jdbcType=TIMESTAMP},",
			"test_range_riferimento = #{testRangeRiferimento,jdbcType=VARCHAR},",
			"test_valore = #{testValore,jdbcType=VARCHAR},", "test_unita_misura = #{testUnitaMisura,jdbcType=VARCHAR},",
			"test_codice_esito = #{testCodiceEsito,jdbcType=VARCHAR},",
			"test_laboratorio_desc = #{testLaboratorioDesc,jdbcType=VARCHAR},",
			"test_programma = #{testProgramma,jdbcType=VARCHAR},", "id_soggetto = #{idSoggetto,jdbcType=BIGINT},",
			"test_esito_id = #{testEsitoId,jdbcType=INTEGER},", "test_tipo_id = #{testTipoId,jdbcType=INTEGER},",
			"test_richiesta_tipo_id = #{testRichiestaTipoId,jdbcType=INTEGER},",
			"intfrdet_id = #{intfrdetId,jdbcType=INTEGER},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
			"test_stato_id = #{testStatoId,jdbcType=INTEGER},",
			"data_prelievo_effettiva = #{dataPrelievoEffettiva,jdbcType=TIMESTAMP},",
			"test_rapido_jrc_id = #{testRapidoJrcId,jdbcType=INTEGER},",
			"webapp_operazione = #{webappOperazione,jdbcType=VARCHAR},",
			"id_profilo_operazione = #{idProfiloOperazione,jdbcType=INTEGER},",
			"ruolo_operazione = #{ruoloOperazione,jdbcType=VARCHAR},",
			"id_ente_operazione = #{idEnteOperazione,jdbcType=INTEGER},",
			"id_struttura_operazione = #{idStrutturaOperazione,jdbcType=VARCHAR},",
			"id_area_operazione = #{idAreaOperazione,jdbcType=INTEGER}", "where test_id = #{testId,jdbcType=BIGINT}" })
	int updateByPrimaryKey(Test record);
}