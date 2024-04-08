/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaVisitatoriExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaVisitatoriMapper;
import it.csi.gescovid.gestruttureresapi.dto.RsaVisitatoriJson;

public interface RsaVisitatoriMapper extends BaseRsaVisitatoriMapper {

	    @Select({
	        "select",
	        "ctv.visitatori_id, ctv.id_struttura, ctv.str_categoria_id, ctv.data_visibilita, ctv.visitatori_ingressi_id, ",
	        "ctv.data_rilevazione, ctv.validita_inizio, ctv.validita_fine, ctv.utente_operazione, ctv.data_creazione, ",
	        "ctv.data_modifica, ctv.data_cancellazione, cdvi.visitatori_ingressi_desc, ",
	        "cs.str_categoria_desc,  concat('Dal ',to_char(ctv.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(ctv.validita_fine, 'dd/mm/yyyy') ) as dati_validi ",
	        "from covidrsa_t_visitatori ctv ",
            "left join covidrsa_d_struttura_categoria cs on ctv.str_categoria_id = cs.str_categoria_id ",
            "left join covidrsa_d_visitatori_ingressi cdvi on cdvi.visitatori_ingressi_id = ctv.visitatori_ingressi_id ",
	        "where ctv.data_cancellazione is null ",
	        "and ctv.id_struttura=#{idStruttura,jdbcType=VARCHAR}  ",
	        "order by ctv.data_rilevazione desc  "
	         
	    })
	    @Results({
	        @Result(column="visitatori_id", property="visitatoriId", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
	        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER),
	        @Result(column="data_visibilita", property="dataVisibilita", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="visitatori_ingressi_id", property="visitatoriIngressiId", jdbcType=JdbcType.INTEGER),
	        @Result(column="data_rilevazione", property="dataRilevazione", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
	        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
	        
	        @Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
            @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="visitatori_ingressi_desc", property="visitatoriIngressiDesc", jdbcType=JdbcType.VARCHAR)
	    })
	    List<RsaVisitatoriExt> selectValidByIdStruttura(String idStruttura);

		  @Select({
			  "<script>",
		        "select",
		        " case when COALESCE(st.nome, '')  !='' ",
			    "    then  st.nome ",
			    "    else ctsi.sti_nome ",
			    "end nome_st, ",
		        "ctv.visitatori_id, ctv.id_struttura, ctv.str_categoria_id, ctv.data_visibilita, ctv.visitatori_ingressi_id, ",
		        "ctv.data_rilevazione, ctv.validita_inizio, ctv.validita_fine, ctv.utente_operazione, ctv.data_creazione, ",
		        "ctv.data_modifica, ctv.data_cancellazione, ",
		        "cdrvi.visitatori_ingressi_desc, ",
		        "to_char(ctv.data_rilevazione, 'dd/mm/yyyy') as data_rilevazione_string, ",
		        "concat('Dal ',to_char(ctv.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(ctv.validita_fine, 'dd/mm/yyyy') ) as dati_validi, ",
		        "cs.str_categoria_desc ",
		        "from covidrsa_t_visitatori ctv ",
		        "left join covidrsa_d_struttura_categoria cs on ctv.str_categoria_id = cs.str_categoria_id ",
		        "left join struttura st  on ctv.id_struttura = st.id_struttura " ,	
		        "left join covidrsa_t_struttura_info ctsi  on ctsi.id_struttura = ctv.id_struttura " ,
		        "left join covidrsa_d_visitatori_ingressi cdrvi on cdrvi.visitatori_ingressi_id = ctv.visitatori_ingressi_id ",
		        "<if test='cfUtente != null'> " , 
		        "left join r_utente_struttura rus on rus.id_struttura = ctv.id_struttura " ,
		    	"</if>",
		        "where ctv.data_cancellazione is null ",
		    	"<if test='cfUtente != null'> " ,
		    	"and rus.cf_utente = #{cfUtente, jdbcType=VARCHAR}  ",
		    	"</if>",
		    	"<if test='dataRilevazioneDa != null'> ", 
				" and ctv.data_rilevazione >= #{dataRilevazioneDa, jdbcType = TIMESTAMP}",
				"</if>",
				"<if test='dataRilevazioneA != null'> ", 
				"and   #{dataRilevazioneA, jdbcType = TIMESTAMP} > ctv.data_rilevazione ", 
				"</if>",
				"<if test='idStruttura != null'> " ,
		    	"and ctv.id_struttura = #{idStruttura, jdbcType=VARCHAR}  ",
		    	"</if>",
		        "order by nome_st asc, ctv.data_rilevazione desc  ",
			  "</script>"
		    })
		    @Results({
		        @Result(column="visitatori_ingressi_desc", property="visitatoriIngressiDesc", jdbcType=JdbcType.VARCHAR),
		    
		        @Result(column="data_rilevazione_string", property="dataRilevazioneString", jdbcType=JdbcType.TIMESTAMP),
		        @Result(column="nome_st", property="nomeStruttura", jdbcType=JdbcType.VARCHAR),
		        @Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
		        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR)
		    })
		    List<RsaVisitatoriJson> selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(@Param("cfUtente") String cfUtente,
		    		@Param("dataRilevazioneDa") Date dataRilevazioneDa, 
		    		@Param("dataRilevazioneA") Date dataRilevazioneA,
		    		@Param("idStruttura") String idStruttura);

	@Insert({ 
        "insert into covidrsa_t_visitatori ( ",
        "id_struttura, ",
        "str_categoria_id, ",
        "data_rilevazione, ", 
        "validita_inizio, ",
        "validita_fine, ",
        "utente_operazione ",
        " )",
		"SELECT ",
		"   #{idStruttura, jdbcType=VARCHAR} , ",
		"   #{strCategoriaId, jdbcType=INTEGER}, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '7 days', ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '1 day', ",
		"   #{cfUtente, jdbcType=VARCHAR} ",
		"FROM DUAL ",
		"WHERE NOT EXISTS ( ",
		"   SELECT 1 ",
		"   FROM covidrsa_t_visitatori ",
		"   WHERE id_struttura = #{idStruttura, jdbcType=VARCHAR} ",
		"     AND str_categoria_id = #{strCategoriaId, jdbcType=INTEGER} ",
		"     AND TRUNC(data_rilevazione) = #{dataRilevazione, jdbcType = DATE} ",
		"     AND data_cancellazione IS NULL ",
		") "})
	int insertDefaultIfNotPresente( @Param("idStruttura") String idStruttura, @Param("strCategoriaId") Integer strCategoriaId, @Param("dataRilevazione") Date dataRilevazione, @Param("cfUtente") String cfUtente);
	
}
