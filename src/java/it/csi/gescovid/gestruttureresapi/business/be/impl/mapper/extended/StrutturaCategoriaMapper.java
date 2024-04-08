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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.StrutturaCategoria;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.StrutturaCategoriaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseStrutturaCategoriaMapper;

public interface StrutturaCategoriaMapper extends BaseStrutturaCategoriaMapper {
	
  
    @Select({
        "select",
        "str_categoria_id, str_categoria_cod, str_categoria_desc, validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from covidrsa_d_struttura_categoria ",
        "where now() between validita_inizio and coalesce(validita_fine, now())  order by str_categoria_desc "
    })
    @Results({
        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="str_categoria_cod", property="strCategoriaCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_desc", property="strCategoriaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StrutturaCategoria> selectAllValid();
	
  
    @Select({
    	"select ",
    	"cdsc.str_categoria_id, cdsc.str_categoria_cod, ",
    	"cdsc.str_categoria_desc, cdsc.validita_inizio, ",
    	"cdsc.validita_fine, cdsc.utente_operazione, ",
    	"cdsc.data_creazione, cdsc.data_modifica, ",
    	"cdsc.data_cancellazione, rsc.posti_autorizzati, ",
    	"(EXISTS ( ",
		"     SELECT TRUE FROM covidrsa_t_posti WHERE id_struttura = ",
		"     rsc.id_struttura AND str_categoria_id = rsc.str_categoria_id AND ",
		"     TRUNC(data_rilevazione) = #{dataRilevazione,jdbcType=DATE} AND data_cancellazione IS NULL ",
		"       UNION ",
		"       SELECT TRUE FROM covidrsa_t_personale WHERE id_struttura = ",
		"   rsc.id_struttura AND str_categoria_id = rsc.str_categoria_id AND ",
		"   TRUNC(data_rilevazione) = #{dataRilevazione,jdbcType=DATE} AND data_cancellazione IS NULL ",
		"      UNION ",
		"      SELECT TRUE FROM covidrsa_t_tamponi WHERE id_struttura = ",
		"   rsc.id_struttura AND str_categoria_id = rsc.str_categoria_id AND ",
		"   TRUNC(data_rilevazione) = #{dataRilevazione,jdbcType=DATE} AND data_cancellazione IS NULL ",
		"      UNION ",
		"      SELECT TRUE FROM covidrsa_t_covid WHERE id_struttura = ",
		"   rsc.id_struttura AND str_categoria_id = rsc.str_categoria_id AND ",
		"   TRUNC(data_rilevazione) = #{dataRilevazione,jdbcType=DATE} AND data_cancellazione IS NULL ",
		"      UNION ",
		"      SELECT TRUE FROM covidrsa_t_decessi WHERE id_struttura = ",
		"   rsc.id_struttura AND str_categoria_id = rsc.str_categoria_id AND ", 
		"   TRUNC(data_rilevazione) = #{dataRilevazione,jdbcType=DATE} AND data_cancellazione IS NULL ",
		"    )) esiste_ultima_rilevazione ",
    	"from covidrsa_d_struttura_categoria cdsc ",
    	"join covidrsa_r_struttura_categoria rsc on rsc.id_struttura = #{idStruttura,jdbcType=VARCHAR} ",
    	"                          and now() between rsc.validita_inizio and coalesce(rsc.validita_fine, now()) ",
    	"                          and rsc.data_cancellazione is null  ",
    	"where ",
    	"rsc.str_categoria_id = cdsc.str_categoria_id and  ",
    	"now() between cdsc.validita_inizio and coalesce(cdsc.validita_fine, now()) ",
    	"order by cdsc.str_categoria_desc "
    })
    @Results({
        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="str_categoria_cod", property="strCategoriaCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_desc", property="strCategoriaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="posti_autorizzati", property="postiAutorizzati", jdbcType=JdbcType.INTEGER),
        @Result(column="esiste_ultima_rilevazione", property="esisteUltimaRilevazione", jdbcType=JdbcType.BOOLEAN),
    })
	List<StrutturaCategoriaInfo> selectCategorieByIdStruttura(@Param("idStruttura") String idStruttura,@Param("dataRilevazione") Date dataRilevazione );

}
