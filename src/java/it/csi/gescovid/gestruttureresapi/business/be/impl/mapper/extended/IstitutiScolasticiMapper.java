/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.IstitutoScolastico;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseIstitutiScolasticiMapper;



public interface IstitutiScolasticiMapper extends BaseIstitutiScolasticiMapper {
	
	
	@Select({
    	" select a.* " ,
    	" from istituti_scolastici a, r_soggetto_istituto b  ",
    	" where a.id_istituto = b.id_istituto and ",
    	" b.id_soggetto = #{idSoggetto} and ",
    	" b.data_cancellazione is null  and",
    	" #{adesso,jdbcType=TIMESTAMP} between b.validita_inizio and coalesce(b.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" 
    })
    @Results({
        @Result(column="id_istituto", property="idIstituto", jdbcType=JdbcType.INTEGER),
        @Result(column="codice_istituto", property="codiceIstituto", jdbcType=JdbcType.VARCHAR),
        @Result(column="denominazione_istituto", property="denominazioneIstituto", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_istituto", property="indirizzoIstituto", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_istituto", property="comuneIstituto", jdbcType=JdbcType.VARCHAR),
        @Result(column="provincia_istituto", property="provinciaIstituto", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_istituto", property="telIstituto", jdbcType=JdbcType.VARCHAR),
        @Result(column="ordine_istituto", property="ordineIstituto", jdbcType=JdbcType.VARCHAR) 
    })
    List<IstitutoScolastico> selectIstitutiValidiBySoggettoId(@Param("idSoggetto") Long idSoggetto, @Param("adesso") Date data);

}
