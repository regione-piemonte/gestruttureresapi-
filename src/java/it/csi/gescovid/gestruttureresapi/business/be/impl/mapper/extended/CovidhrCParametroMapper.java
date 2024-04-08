/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidhrCParametro;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidhrCParametroMapper;

public interface CovidhrCParametroMapper extends BaseCovidhrCParametroMapper {

    @Select({
            "select param_value ",
            "from covidhr_c_parametro ",
            "where param_key = #{paramKey, jdbcType=VARCHAR}; "
    })
    @Results({
            @Result(column="param_value", property="paramValue", jdbcType= JdbcType.VARCHAR)
    })
    CovidhrCParametro selectParamValueByParamKey(String paramkey);
    
    
	    @Select({
	        "select param_value ",
	        "from covidhr_c_parametro ",
	        "where param_key = #{paramKey, jdbcType=VARCHAR}; "
	})
	String selectParamValueByParamKeyString(String paramkey);
    

}