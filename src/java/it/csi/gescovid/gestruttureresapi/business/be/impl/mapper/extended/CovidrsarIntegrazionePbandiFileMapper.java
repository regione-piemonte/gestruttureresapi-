/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsarIntegrazionePbandiFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsarIntegrazionePbandiFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsarIntegrazionePbandiFileMapper;

public interface CovidrsarIntegrazionePbandiFileMapper extends BaseCovidrsarIntegrazionePbandiFileMapper {

    @Select({"select ",
        "cripf.integrazione_pbandi_file_id, cripf.integrazione_pbandi_id, cripf.file_id, cripf.file_tipo_id,  ",
        "cripf.validita_inizio, cripf.validita_fine, cripf.data_creazione, cripf.data_modifica,  ",
        "cripf.data_cancellazione, ctf.file_name ",
        "from covidrsa_r_integrazione_pbandi_file cripf ",
        "join covidus_t_file ctf on ctf.file_id = cripf.file_id  ",
        "where  ",
        "cripf.integrazione_pbandi_id = #{integrazionePbandiId,jdbcType=INTEGER} ",
        "and cripf.data_cancellazione is null   ",
        "and now() between cripf.validita_inizio and coalesce(cripf.validita_fine, now())   "})
    @Results({
        @Result(column="integrazione_pbandi_file_id", property="integrazionePbandiFileId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="integrazione_pbandi_id", property="integrazionePbandiId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_tipo_id", property="fileTipoId", jdbcType=JdbcType.INTEGER),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="file_id", property="file.fileId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_name", property="file.fileName", jdbcType=JdbcType.VARCHAR)
    })
    List<CovidrsarIntegrazionePbandiFileExt> selectByIntegrazionePbandiFileId(Integer integrazionePbandiId);
    


    @Select({
        "select",
        "integrazione_pbandi_file_id, integrazione_pbandi_id, file_id, file_tipo_id, ",
        "validita_inizio, validita_fine, utente_operazione, data_creazione, data_modifica, ",
        "data_cancellazione",
        "from covidrsa_r_integrazione_pbandi_file",
        "where integrazione_pbandi_file_id = #{integrazionePbandiFileId,jdbcType=INTEGER}",
        "and data_cancellazione is null   ",
        "and now() between validita_inizio and coalesce(validita_fine, now())   "
    })
    @Results({
        @Result(column="integrazione_pbandi_file_id", property="integrazionePbandiFileId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="integrazione_pbandi_id", property="integrazionePbandiId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_tipo_id", property="fileTipoId", jdbcType=JdbcType.INTEGER),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    CovidrsarIntegrazionePbandiFile selectByPrimaryKey(Integer integrazionePbandiFileId);
    
   @Insert({
       "insert into covidrsa_r_integrazione_pbandi_file (integrazione_pbandi_id, file_id, ",
       "file_tipo_id, validita_inizio, ",
       "validita_fine, utente_operazione, ",
       "data_creazione, data_modifica, ",
       "data_cancellazione)",
       "values (#{integrazionePbandiId,jdbcType=INTEGER}, #{fileId,jdbcType=INTEGER}, ",
       "#{fileTipoId,jdbcType=INTEGER}, coalesce(#{validitaInizio,jdbcType=TIMESTAMP},now()), ",
       "#{validitaFine,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
       "now(), now(), ",
       "#{dataCancellazione,jdbcType=TIMESTAMP})"
   })
   @Options(useGeneratedKeys=true,keyProperty="integrazionePbandiFileId")
   int insert(CovidrsarIntegrazionePbandiFile record);
   


   @Update({
           "update covidrsa_r_integrazione_pbandi_file",
           "set ",
           "data_cancellazione = now() ",
           "where integrazione_pbandi_file_id = #{integrazionePbandiFileId,jdbcType=INTEGER}",
           " and data_cancellazione is null "
   })
   int logicDelete(CovidrsarIntegrazionePbandiFile current);
   

   @Update({
       "update covidrsa_r_integrazione_pbandi_file",
       "set integrazione_pbandi_id = #{integrazionePbandiId,jdbcType=INTEGER},",
         "file_id = #{fileId,jdbcType=INTEGER},",
         "file_tipo_id = #{fileTipoId,jdbcType=INTEGER},",
         "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
         "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
         "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
         "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
         "data_modifica = coalesce(#{dataModifica,jdbcType=TIMESTAMP}, now()),",
         "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
       "where integrazione_pbandi_file_id = #{integrazionePbandiFileId,jdbcType=INTEGER}"
   })
   int updateByPrimaryKey(CovidrsarIntegrazionePbandiFile record);
}
