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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Profilo;

public interface BaseProfiloMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table profilo
	 * @mbg.generated
	 */
	@Delete({ "delete from profilo", "where id_profilo = #{idProfilo,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer idProfilo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table profilo
	 * @mbg.generated
	 */
	@Insert({ "insert into profilo (nome_profilo)", "values (#{nomeProfilo,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "idProfilo")
	int insert(Profilo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table profilo
	 * @mbg.generated
	 */
	@Select({ "select", "id_profilo, nome_profilo", "from profilo",
			"where id_profilo = #{idProfilo,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id_profilo", property = "idProfilo", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "nome_profilo", property = "nomeProfilo", jdbcType = JdbcType.VARCHAR) })
	Profilo selectByPrimaryKey(Integer idProfilo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table profilo
	 * @mbg.generated
	 */
	@Select({ "select", "id_profilo, nome_profilo", "from profilo" })
	@Results({ @Result(column = "id_profilo", property = "idProfilo", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "nome_profilo", property = "nomeProfilo", jdbcType = JdbcType.VARCHAR) })
	List<Profilo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table profilo
	 * @mbg.generated
	 */
	@Update({ "update profilo", "set nome_profilo = #{nomeProfilo,jdbcType=VARCHAR}",
			"where id_profilo = #{idProfilo,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Profilo record);
}