/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRRendicontazioneFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRRendicontazioneFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaRRendicontazioneFileMapper;

public interface CovidrsaRRendicontazioneFileMapper extends BaseCovidrsaRRendicontazioneFileMapper {

    @Insert({ "insert into covidrsa_r_rendicontazione_file (rendicontazione_id, file_id, ",
            "validita_inizio, validita_fine, ", "data_creazione, data_modifica, ",
            "data_cancellazione, utente_operazione, ", "file_tipo_id, firma_verificata)",
            "values (#{rendicontazioneId,jdbcType=INTEGER}, #{fileId,jdbcType=INTEGER}, ",
            "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
            " now(), now(), ",
            "#{dataCancellazione,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR}, ",
            "#{fileTipoId,jdbcType=INTEGER}, #{firmaVerificata,jdbcType=BIT})" })
    @Options(useGeneratedKeys = true, keyProperty = "rendicontazioneFileId")
    int insert(CovidrsaRRendicontazioneFile record);
    
    @Select({ "select", " ctf.file_name, crrf.rendicontazione_file_id, crrf.rendicontazione_id, crrf.file_id, crrf.validita_inizio, crrf.validita_fine, ",
            "crrf.data_creazione, crrf.data_modifica, crrf.data_cancellazione, crrf.utente_operazione, crrf.file_tipo_id, ", "crrf.firma_verificata",
            "from covidrsa_r_rendicontazione_file crrf ",
            " join covidus_t_file ctf on ctf.file_id = crrf.file_id ",
            "where crrf.rendicontazione_id = #{rendicontazioneId,jdbcType=INTEGER} and crrf.data_cancellazione is null "})
    @Results({
            @Result(column = "rendicontazione_file_id", property = "rendicontazioneFileId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "rendicontazione_id", property = "rendicontazioneId", jdbcType = JdbcType.INTEGER),
            @Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER),
            @Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_tipo_id", property = "fileTipoId", jdbcType = JdbcType.INTEGER),
            @Result(column = "firma_verificata", property = "firmaVerificata", jdbcType = JdbcType.BIT),
            @Result(column = "file_name", property = "fileToBeSaved.filename", jdbcType = JdbcType.VARCHAR), })
    List<CovidrsaRRendicontazioneFileExt> selectByRendicontazioneId(@Param("rendicontazioneId") Integer rendicontazioneId);    
    
    @Select({"select cdwft.file_tipo_cod, ",
        "       cdwft.file_tipo_desc, ",
        "       ctf.file_name, ",
        "       crrf.file_id, ",
        "       'GIUSTIFICATIVO' as allegato_tipo ",
        "from covidrsa_r_rendicontazione_file crrf ",
        "join covidus_t_file ctf on ctf.file_id = crrf.file_id ",
        "join covidrsa_d_welfare_file_tipo cdwft on cdwft.file_tipo_id = crrf.file_tipo_id ",
        "where crrf.data_cancellazione is null ",
        " and crrf.rendicontazione_id = #{rendicontazioneId,jdbcType=INTEGER}"
        })
@Results({
        @Result(column = "file_id", property = "allegatoId", jdbcType = JdbcType.INTEGER),
        @Result(column = "file_tipo_desc", property = "allegatoTipoDesc", jdbcType = JdbcType.VARCHAR), 
        @Result(column = "file_tipo_cod", property = "allegatoTipoCod", jdbcType = JdbcType.VARCHAR), 
        @Result(column = "file_name", property = "allegatoFilename", jdbcType = JdbcType.VARCHAR), 
        @Result(column = "allegato_tipo", property = "allegatoTipo", jdbcType = JdbcType.VARCHAR), 
        })
List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> selectByRendicontazioneWhitDecodificaId(@Param("rendicontazioneId") Integer rendicontazioneId);
}
