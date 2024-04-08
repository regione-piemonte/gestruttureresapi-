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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFileTipo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaDWelfareFileTipoMapper;

public interface CovidrsaDWelfareFileTipoMapper extends BaseCovidrsaDWelfareFileTipoMapper {

    @Select({ 
            "<script>",
            "select", "file_tipo_id, file_tipo_cod, file_tipo_desc, file_tipo_obbligatorio, file_tipo_firmato, ",
            "validita_inizio, validita_fine, utente_operazione, data_creazione, data_modifica, ",
            "data_cancellazione, file_tipo_gruppo, file_tipo_hint ", 
            "from covidrsa_d_welfare_file_tipo ",
            "where data_cancellazione is null ",
            "and now() between validita_inizio and coalesce(validita_fine, now()) ",
            "<if test='fileTipoCod != null'> " , 
            "and file_tipo_cod = #{fileTipoCod,jdbcType=VARCHAR} ",
            "</if>",
            "</script>"})
    @Results({ @Result(column = "file_tipo_id", property = "fileTipoId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "file_tipo_cod", property = "fileTipoCod", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_tipo_desc", property = "fileTipoDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_tipo_obbligatorio", property = "fileTipoObbligatorio", jdbcType = JdbcType.BIT),
            @Result(column = "file_tipo_firmato", property = "fileTipoFirmato", jdbcType = JdbcType.BIT),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
            @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "file_tipo_gruppo", property = "fileTipoGruppo", jdbcType = JdbcType.VARCHAR),
            @Result(column="file_tipo_hint", property="fileTipoHint", jdbcType=JdbcType.VARCHAR) })
    List<CovidrsaDWelfareFileTipo> selectAllValid(@Param("fileTipoCod") String fileTipoCod);
    
    @Select({
        "select", "file_tipo_id, file_tipo_cod, file_tipo_desc, file_tipo_obbligatorio, file_tipo_firmato, ",
        "validita_inizio, validita_fine, utente_operazione, data_creazione, data_modifica, ",
        "data_cancellazione, file_tipo_gruppo, file_tipo_hint ", 
        "from covidrsa_d_welfare_file_tipo",
        "where file_tipo_id = #{fileTipoId,jdbcType=INTEGER} ",
        " and data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now())  "
    })
    @Results({
        @Result(column="file_tipo_id", property="fileTipoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="file_tipo_cod", property="fileTipoCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_tipo_desc", property="fileTipoDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_tipo_obbligatorio", property="fileTipoObbligatorio", jdbcType=JdbcType.BIT),
        @Result(column="file_tipo_firmato", property="fileTipoFirmato", jdbcType=JdbcType.BIT),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column = "file_tipo_gruppo", property = "fileTipoGruppo", jdbcType = JdbcType.VARCHAR),
        @Result(column="file_tipo_hint", property="fileTipoHint", jdbcType=JdbcType.VARCHAR)
    })
    CovidrsaDWelfareFileTipo selectByPrimaryKeyValid(Integer fileTipoId);
    
    @Select({
        "select count(*) from covidrsa_d_welfare_file_tipo ",
        "where file_tipo_gruppo = #{fileTipoGruppo,jdbcType=VARCHAR} ",
        "and file_tipo_obbligatorio ",
        "and data_cancellazione is null ",
        "and now() between validita_inizio and coalesce(validita_fine, now())  "
    })
    Integer countFileObbligatoriFromGruppo(@Param("fileTipoGruppo") String gruppo);

}
