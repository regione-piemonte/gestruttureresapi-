/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTInvioPbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaTInvioPbandiMapper;

public interface CovidrsaTInvioPbandiMapper extends BaseCovidrsaTInvioPbandiMapper {


    @Select({
        "select",
        "invio_pbandi_id, invio_pbandi_cod, invio_pbandi_uuid_ext, invio_pbandi_cod_ext, ",
        "file_id_dichiarazione_spesa, invio_data, invio_request, invio_result, invio_error_cod, ",
        "invio_error_message, callback_data, callback_esito, callback_error_cod, callback_error_message, ",
        "invio_esito",
        "from covidrsa_t_invio_pbandi",
        "where invio_pbandi_cod = #{invioPbandiCod,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="invio_pbandi_id", property="invioPbandiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="invio_pbandi_cod", property="invioPbandiCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_pbandi_uuid_ext", property="invioPbandiUuidExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_pbandi_cod_ext", property="invioPbandiCodExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_id_dichiarazione_spesa", property="fileIdDichiarazioneSpesa", jdbcType=JdbcType.INTEGER),
        @Result(column="invio_data", property="invioData", jdbcType=JdbcType.DATE),
        @Result(column="invio_request", property="invioRequest", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_result", property="invioResult", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_error_cod", property="invioErrorCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_error_message", property="invioErrorMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="callback_data", property="callbackData", jdbcType=JdbcType.DATE),
        @Result(column="callback_esito", property="callbackEsito", jdbcType=JdbcType.VARCHAR),
        @Result(column="callback_error_cod", property="callbackErrorCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="callback_error_message", property="callbackErrorMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_esito", property="invioEsito", jdbcType=JdbcType.VARCHAR)
    })
    CovidrsaTInvioPbandi selectByInvioPbandiCod(@Param("invioPbandiCod") String invioPbandiCod);

    @Select({
        "select",
        "invio_pbandi_id, invio_pbandi_cod, invio_pbandi_uuid_ext, invio_pbandi_cod_ext, ",
        "file_id_dichiarazione_spesa, invio_data, invio_request, invio_result, invio_error_cod, ",
        "invio_error_message, callback_data, callback_esito, callback_error_cod, callback_error_message, ",
        "invio_esito",
        "from covidrsa_t_invio_pbandi",
        "where invio_pbandi_cod_ext = #{invioPbandiCodExt,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="invio_pbandi_id", property="invioPbandiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="invio_pbandi_cod", property="invioPbandiCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_pbandi_uuid_ext", property="invioPbandiUuidExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_pbandi_cod_ext", property="invioPbandiCodExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_id_dichiarazione_spesa", property="fileIdDichiarazioneSpesa", jdbcType=JdbcType.INTEGER),
        @Result(column="invio_data", property="invioData", jdbcType=JdbcType.DATE),
        @Result(column="invio_request", property="invioRequest", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_result", property="invioResult", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_error_cod", property="invioErrorCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_error_message", property="invioErrorMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="callback_data", property="callbackData", jdbcType=JdbcType.DATE),
        @Result(column="callback_esito", property="callbackEsito", jdbcType=JdbcType.VARCHAR),
        @Result(column="callback_error_cod", property="callbackErrorCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="callback_error_message", property="callbackErrorMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="invio_esito", property="invioEsito", jdbcType=JdbcType.VARCHAR)
    })
    CovidrsaTInvioPbandi selectByInvioPbandiCodExt(@Param("invioPbandiCodExt") String invioPbandiCodExt);
    
    
    
}
