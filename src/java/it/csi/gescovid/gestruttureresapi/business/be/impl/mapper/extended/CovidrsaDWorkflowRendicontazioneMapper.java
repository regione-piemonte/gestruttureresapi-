/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWorkflowRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaDWorkflowRendicontazioneMapper;

public interface CovidrsaDWorkflowRendicontazioneMapper extends BaseCovidrsaDWorkflowRendicontazioneMapper {

    @Select({
        "<script> ",
        "select",
        "workflow_rend_id, stato_rend_id_old, stato_rend_id_new, flg_struttura, flg_ente_gestore, ",
        "validita_inizio, validita_fine, data_creazione, data_modifica, data_cancellazione, ",
        "utente_operazione, flg_controlla_file, informativa_utente, flg_genera_dichiarazione ",
        "from covidrsa_d_workflow_rendicontazione",
        "where stato_rend_id_old = #{statoRendId,jdbcType=INTEGER} ",
        "<if test='statoRendIdNew != null'> ",
        " and stato_rend_id_new = #{statoRendIdNew,jdbcType=INTEGER} ",
        "</if> ",
        "and data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now()) ",
        " </script>"
    })
    @Results({
        @Result(column="workflow_rend_id", property="workflowRendId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stato_rend_id_old", property="statoRendIdOld", jdbcType=JdbcType.INTEGER),
        @Result(column="stato_rend_id_new", property="statoRendIdNew", jdbcType=JdbcType.INTEGER),
        @Result(column="flg_struttura", property="flgStruttura", jdbcType=JdbcType.BIT),
        @Result(column="flg_ente_gestore", property="flgEnteGestore", jdbcType=JdbcType.BIT),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="flg_controlla_file", property="flgControllaFile", jdbcType=JdbcType.BIT),
        @Result(column = "informativa_utente", property = "informativaUtente", jdbcType = JdbcType.VARCHAR),
        @Result(column = "flg_genera_dichiarazione", property = "flgGeneraDichiarazione", jdbcType = JdbcType.BIT)
    })
    List<CovidrsaDWorkflowRendicontazione> selectAllValidFromId(@Param("statoRendId") Integer statoRendId,
            @Param("statoRendIdNew") Integer statoRendIdNew);

}
