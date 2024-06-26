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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Medico;

public interface BaseMedicoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table medico
	 * @mbg.generated
	 */
	@Delete({ "delete from medico", "where id_medico = #{idMedico,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long idMedico);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table medico
	 * @mbg.generated
	 */
	@Insert({ "insert into medico (cf_medico, codice_reg, ", "cognome, nome, sostituito_da, ", "sostituisce)",
			"values (#{cfMedico,jdbcType=VARCHAR}, #{codiceReg,jdbcType=VARCHAR}, ",
			"#{cognome,jdbcType=VARCHAR}, #{nome,jdbcType=VARCHAR}, #{sostituitoDa,jdbcType=VARCHAR}, ",
			"#{sostituisce,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "idMedico")
	int insert(Medico record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table medico
	 * @mbg.generated
	 */
	@Select({ "select", "id_medico, cf_medico, codice_reg, cognome, nome", "from medico",
			"where id_medico = #{idMedico,jdbcType=BIGINT}" })
	@Results({ @Result(column = "id_medico", property = "idMedico", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "cf_medico", property = "cfMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "codice_reg", property = "codiceReg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR) })
	Medico selectByPrimaryKey(Long idMedico);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table medico
	 * @mbg.generated
	 */
	@Select({ "select", "id_medico, cf_medico, codice_reg, cognome, nome", "from medico" })
	@Results({ @Result(column = "id_medico", property = "idMedico", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "cf_medico", property = "cfMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "codice_reg", property = "codiceReg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sostituito_da", property = "sostituitoDa", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sostituisce", property = "sostituisce", jdbcType = JdbcType.VARCHAR) })
	List<Medico> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table medico
	 * @mbg.generated
	 */
	@Update({ "update medico", "set cf_medico = #{cfMedico,jdbcType=VARCHAR},",
			"codice_reg = #{codiceReg,jdbcType=VARCHAR},", "cognome = #{cognome,jdbcType=VARCHAR},",
			"nome = #{nome,jdbcType=VARCHAR},", "where id_medico = #{idMedico,jdbcType=BIGINT}" })
	int updateByPrimaryKey(Medico record);
}