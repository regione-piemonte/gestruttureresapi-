/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.SoggettoStrutturaInfo;

public interface SoggettoStrutturaInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidres_r_soggetto_struttura_info
	 * @mbg.generated
	 */
	@Delete({ "delete from covidres_r_soggetto_struttura_info", "where ssi_id = #{ssiId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer ssiId);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidres_r_soggetto_struttura_info
	 * @mbg.generated
	 */
	@Insert({ "insert into covidres_r_soggetto_struttura_info (id_soggetto, sti_id, ",
			"validita_inizio, validita_fine, ", "data_creazione, data_modifica, ",
			"data_cancellazione, utente_operazione, ", "id_struttura, flg_ospite)",
			"values (#{idSoggetto,jdbcType=INTEGER}, #{stiId,jdbcType=INTEGER}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
			"#{dataCancellazione,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{idStruttura,jdbcType=VARCHAR}, #{flgOspite,jdbcType=BIT})" })
	@Options(useGeneratedKeys = true, keyProperty = "ssiId")
	int insert(SoggettoStrutturaInfo record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidres_r_soggetto_struttura_info
	 * @mbg.generated
	 */
	@Select({ "select", "ssi_id, id_soggetto, sti_id, validita_inizio, validita_fine, data_creazione, ",
			"data_modifica, data_cancellazione, utente_operazione, id_struttura, flg_ospite",
			"from covidres_r_soggetto_struttura_info", "where ssi_id = #{ssiId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "ssi_id", property = "ssiId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
			@Result(column = "sti_id", property = "stiId", jdbcType = JdbcType.INTEGER),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "flg_ospite", property = "flgOspite", jdbcType = JdbcType.BIT) })
	SoggettoStrutturaInfo selectByPrimaryKey(Integer ssiId);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidres_r_soggetto_struttura_info
	 * @mbg.generated
	 */
	@Select({ "select", "ssi_id, id_soggetto, sti_id, validita_inizio, validita_fine, data_creazione, ",
			"data_modifica, data_cancellazione, utente_operazione, id_struttura, flg_ospite",
			"from covidres_r_soggetto_struttura_info" })
	@Results({ @Result(column = "ssi_id", property = "ssiId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
			@Result(column = "sti_id", property = "stiId", jdbcType = JdbcType.INTEGER),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "flg_ospite", property = "flgOspite", jdbcType = JdbcType.BIT) })
	List<SoggettoStrutturaInfo> selectAll();


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidres_r_soggetto_struttura_info
	 * @mbg.generated
	 */
	@Update({ "update covidres_r_soggetto_struttura_info", "set id_soggetto = #{idSoggetto,jdbcType=INTEGER},",
			"sti_id = #{stiId,jdbcType=INTEGER},", "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"id_struttura = #{idStruttura,jdbcType=VARCHAR},", "flg_ospite = #{flgOspite,jdbcType=BIT}",
			"where ssi_id = #{ssiId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(SoggettoStrutturaInfo record);


	@Select({
		"<script>",
		"select ssi.* ",
		"from covidres_r_soggetto_struttura_info ssi ",
		"where ssi.id_soggetto = #{idSoggetto,jdbcType=INTEGER} ",
		"<if test = 'idStruttura != null'> and ssi.id_struttura= #{idStruttura,jdbcType=VARCHAR} </if>", 
		"<if test = 'flgOspite'> and flg_ospite  </if>" ,
		"  and ssi.data_cancellazione is null ",	
		"  and ssi.validita_fine is null " ,
		"</script>"
	})
	@Results({ @Result(column = "ssi_id", property = "ssiId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
		@Result(column = "sti_id", property = "stiId", jdbcType = JdbcType.INTEGER),
		@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
	@Result(column = "flg_ospite", property = "flgOspite", jdbcType = JdbcType.BIT) })
	List<SoggettoStrutturaInfo> selectValidByIdSoggettoAndIdStruttura(@Param("idSoggetto") Long idSoggetto, @Param("idStruttura") String idStruttura, @Param("flgOspite") boolean flgOspite);

	
	@Update({ 
		"<script>",
		"update covidres_r_soggetto_struttura_info", "set ",
		" validita_fine = now(),",
		"data_modifica = now(),",
		"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR} ",
		"where ", 
		"<if test = '!flgOspite'> id_soggetto = #{idSoggetto,jdbcType=BIGINT} and id_struttura =  #{idStruttura,jdbcType=VARCHAR} </if>", 
		"<if test = 'flgOspite'> id_soggetto = #{idSoggetto,jdbcType=INTEGER} and (flg_ospite is true or id_struttura =  #{idStruttura,jdbcType=VARCHAR})  </if>" ,
		"</script>"
	})
	int invalidSsSoggettoByIdSoggettoIdStrutturaFlgOspite(
			@Param("idSoggetto") Long idSoggetto, 
			@Param("idStruttura") String idStruttura,
			@Param("flgOspite") boolean flgOspite,
			@Param("utenteOperazione")String utenteOperazione);

	@Update({ 
		"update covidres_r_soggetto_struttura_info", "set ",
		"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
		"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
		"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR} ",
		"where ssi_id = #{ssiId,jdbcType=INTEGER}"
	})
	int invalidSsSoggetto(
			SoggettoStrutturaInfo recurd);

	
}