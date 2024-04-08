/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.Audit;

public interface AuditMapper {

	@Insert({ "insert into \"COVID19_audit\" (datetime, ip, \"user\", \"table\", action, description)",
			"values (NOW(), #{ip,jdbcType=VARCHAR}, #{user,jdbcType=VARCHAR}, #{table,jdbcType=VARCHAR}, ",
			"#{action,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Audit audit);

}