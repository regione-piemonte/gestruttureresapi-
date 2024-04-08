/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaVisitatoriIngressi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaVisitatoriIngressiMapper;

public interface RsaVisitatoriIngressiMapper extends BaseRsaVisitatoriIngressiMapper {
    @Select({
        "select",
        "visitatori_ingressi_id, visitatori_ingressi_cod, visitatori_ingressi_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_visitatori_ingressi",
        "where now() between validita_inizio and coalesce(validita_fine, now()) and data_cancellazione is null ",
        " order by visitatori_ingressi_ord "
    })
    @Results({
        @Result(column="visitatori_ingressi_id", property="visitatoriIngressiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="visitatori_ingressi_cod", property="visitatoriIngressiCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitatori_ingressi_desc", property="visitatoriIngressiDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RsaVisitatoriIngressi> selectAllValid();
    
}

