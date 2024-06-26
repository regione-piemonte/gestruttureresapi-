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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRTipoMovOspiteNaturaSad;

public interface BaseCovidrsaRTipoMovOspiteNaturaSadMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidrsa_r_tipo_mov_ospite_natura_sod
	 * @mbg.generated
	 */
	@Delete({ "delete from covidrsa_r_tipo_mov_ospite_natura_sod",
			"where tmo_natura_sod_id = #{tmoNaturaSodId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer tmoNaturaSodId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidrsa_r_tipo_mov_ospite_natura_sod
	 * @mbg.generated
	 */
	@Insert({ "insert into covidrsa_r_tipo_mov_ospite_natura_sod (tmo_natura_sod_id, natura_struttura_od, ",
			"validita_inizio, validita_fine, ", "data_creazione, data_modifica, ",
			"data_cancellazione, utente_operazione)",
			"values (#{tmoNaturaSodId,jdbcType=INTEGER}, #{naturaStrutturaOd,jdbcType=VARCHAR}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
			"#{dataCancellazione,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "tipoMovOspiteId")
	int insert(CovidrsaRTipoMovOspiteNaturaSad record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidrsa_r_tipo_mov_ospite_natura_sod
	 * @mbg.generated
	 */
	@Select({ "select", "tmo_natura_sod_id, tipo_mov_ospite_id, natura_struttura_od, validita_inizio, ",
			"validita_fine, data_creazione, data_modifica, data_cancellazione, utente_operazione",
			"from covidrsa_r_tipo_mov_ospite_natura_sod",
			"where tmo_natura_sod_id = #{tmoNaturaSodId,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "tmo_natura_sod_id", property = "tmoNaturaSodId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "tipo_mov_ospite_id", property = "tipoMovOspiteId", jdbcType = JdbcType.INTEGER),
			@Result(column = "natura_struttura_od", property = "naturaStrutturaOd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR) })
	CovidrsaRTipoMovOspiteNaturaSad selectByPrimaryKey(Integer tmoNaturaSodId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidrsa_r_tipo_mov_ospite_natura_sod
	 * @mbg.generated
	 */
	@Select({ "select", "tmo_natura_sod_id, tipo_mov_ospite_id, natura_struttura_od, validita_inizio, ",
			"validita_fine, data_creazione, data_modifica, data_cancellazione, utente_operazione",
			"from covidrsa_r_tipo_mov_ospite_natura_sod" })
	@Results({
			@Result(column = "tmo_natura_sod_id", property = "tmoNaturaSodId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "tipo_mov_ospite_id", property = "tipoMovOspiteId", jdbcType = JdbcType.INTEGER),
			@Result(column = "natura_struttura_od", property = "naturaStrutturaOd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR) })
	List<CovidrsaRTipoMovOspiteNaturaSad> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidrsa_r_tipo_mov_ospite_natura_sod
	 * @mbg.generated
	 */
	@Update({ "update covidrsa_r_tipo_mov_ospite_natura_sod",
			"set tipo_mov_ospite_id = #{tipoMovOspiteId,jdbcType=INTEGER},",
			"natura_struttura_od = #{naturaStrutturaOd,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR}",
			"where tmo_natura_sod_id = #{tmoNaturaSodId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidrsaRTipoMovOspiteNaturaSad record);
}