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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Struttura;

public interface BaseStrutturaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table struttura
	 * @mbg.generated
	 */
	@Delete({ "delete from struttura", "where id_struttura = #{idStruttura,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(String idStruttura);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table struttura
	 * @mbg.generated
	 */
	@Insert({ "insert into struttura (id_ente, nome, ", "natura, indirizzo, ", "comune_istat)",
			"values (#{idEnte,jdbcType=INTEGER}, #{nome,jdbcType=VARCHAR}, ",
			"#{natura,jdbcType=VARCHAR}, #{indirizzo,jdbcType=VARCHAR}, ", "#{comuneIstat,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "idStruttura")
	int insert(Struttura record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table struttura
	 * @mbg.generated
	 */
	@Select({ "select", "id_struttura, id_ente, nome, natura, indirizzo, comune_istat", "from struttura",
			"where id_struttura = #{idStruttura,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "natura", property = "natura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "indirizzo", property = "indirizzo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comune_istat", property = "comuneIstat", jdbcType = JdbcType.VARCHAR) })
	Struttura selectByPrimaryKey(String idStruttura);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table struttura
	 * @mbg.generated
	 */
	@Select({ "select", "id_struttura, id_ente, nome, natura, indirizzo, comune_istat", "from struttura" })
	@Results({ @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "natura", property = "natura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "indirizzo", property = "indirizzo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comune_istat", property = "comuneIstat", jdbcType = JdbcType.VARCHAR) })
	List<Struttura> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table struttura
	 * @mbg.generated
	 */
	@Update({ "update struttura", "set id_ente = #{idEnte,jdbcType=INTEGER},", "nome = #{nome,jdbcType=VARCHAR},",
			"natura = #{natura,jdbcType=VARCHAR},", "indirizzo = #{indirizzo,jdbcType=VARCHAR},",
			"comune_istat = #{comuneIstat,jdbcType=VARCHAR}", "where id_struttura = #{idStruttura,jdbcType=VARCHAR}" })
	int updateByPrimaryKey(Struttura record);
}