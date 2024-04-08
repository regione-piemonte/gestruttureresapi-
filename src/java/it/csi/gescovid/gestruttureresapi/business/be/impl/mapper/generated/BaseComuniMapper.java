/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Comuni;

public interface BaseComuniMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comuni
	 * @mbg.generated
	 */
	@Delete({ "delete from comuni", "where istat_comune = #{istatComune,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(String istatComune);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comuni
	 * @mbg.generated
	 */
	@Insert({ "insert into comuni (istat_comune, nome_comune)",
			"values (#{istatComune,jdbcType=VARCHAR}, #{nomeComune,jdbcType=VARCHAR})" })
	int insert(Comuni record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comuni
	 * @mbg.generated
	 */
	@Select({ "select", "istat_comune, nome_comune", "from comuni",
			"where istat_comune = #{istatComune,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "istat_comune", property = "istatComune", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "nome_comune", property = "nomeComune", jdbcType = JdbcType.VARCHAR) })
	Comuni selectByPrimaryKey(String istatComune);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comuni
	 * @mbg.generated
	 */
	@Select({ "select", "istat_comune, nome_comune", "from comuni" })
	@Results({ @Result(column = "istat_comune", property = "istatComune", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "nome_comune", property = "nomeComune", jdbcType = JdbcType.VARCHAR) })
	List<Comuni> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comuni
	 * @mbg.generated
	 */
	@Update({ "update comuni", "set nome_comune = #{nomeComune,jdbcType=VARCHAR}",
			"where istat_comune = #{istatComune,jdbcType=VARCHAR}" })
	int updateByPrimaryKey(Comuni record);
}