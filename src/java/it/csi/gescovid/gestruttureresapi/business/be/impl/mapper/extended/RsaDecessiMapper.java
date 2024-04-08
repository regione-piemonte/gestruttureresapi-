/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaDecessiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaDecessiMapper;
import it.csi.gescovid.gestruttureresapi.dto.RsaCovidJson;
import it.csi.gescovid.gestruttureresapi.dto.RsaDecessiJson;

public interface RsaDecessiMapper extends BaseRsaDecessiMapper {

	
	   @Select({
	        "select",
	        "d.dec_id, d.dec_num_totali_anno_precedente, d.dec_num_totali, d.dec_num_totali_covid, ",
	        "d.dec_num_in_ospedale, d.dec_num_in_ospedale_covid, d.id_struttura, d.str_categoria_id, ",
	        "d.data_rilevazione, d.validita_inizio, d.validita_fine, d.utente_operazione, d.data_creazione, ",
	        "d.data_modifica, d.data_cancellazione, d.data_visibilita, d.dec_num_in_ospedale_anno_precedente, ",
	        "d.dec_num_in_struttura_anno_precedente, d.dec_num_in_struttura, d.dec_num_in_struttura_covid, ",
	        "d.dec_num_ultima_settimana, d.dec_num_covid_ultima_settimana, d.dec_num_in_struttura_ultima_settimana, ",
	        "d.dec_num_in_struttura_covid_ultima_settimana, d.dec_num_in_ospedale_ultima_settimana, ",
	        "d.dec_num_in_ospedale_covid_ultima_settimana, str_categoria_desc, concat('Dal ',to_char(d.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(d.validita_fine, 'dd/mm/yyyy') ) as dati_validi,  ",
	        "(coalesce(d.dec_num_in_ospedale, 0) + coalesce(d.dec_num_in_ospedale_covid, 0) + coalesce(d.dec_num_in_struttura, 0) + coalesce(d.dec_num_in_struttura_covid, 0) + coalesce(d.dec_num_ultima_settimana, 0) + coalesce(d.dec_num_covid_ultima_settimana, 0)) as totale ",
	        "from covidrsa_t_decessi d ",
	        "left join covidrsa_d_struttura_categoria cs on d.str_categoria_id = cs.str_categoria_id ",
	        "where d.data_cancellazione is null ",
	        "and d.id_struttura=#{idStruttura,jdbcType=VARCHAR}  ",
	        "order by d.data_rilevazione desc  "
	    })
	    @Results({
	        @Result(column="dec_id", property="decId", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="dec_num_totali_anno_precedente", property="decNumTotaliAnnoPrecedente", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_totali", property="decNumTotali", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_totali_covid", property="decNumTotaliCovid", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_ospedale", property="decNumInOspedale", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_ospedale_covid", property="decNumInOspedaleCovid", jdbcType=JdbcType.INTEGER),
	        @Result(column="id_struttura", property="idStruttura", jdbcType=JdbcType.VARCHAR),
	        @Result(column="str_categoria_id", property="strCategoriaId", jdbcType=JdbcType.INTEGER),
	        @Result(column="data_rilevazione", property="dataRilevazione", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
	        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="data_visibilita", property="dataVisibilita", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="dec_num_in_ospedale_anno_precedente", property="decNumInOspedaleAnnoPrecedente", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_struttura_anno_precedente", property="decNumInStrutturaAnnoPrecedente", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_struttura", property="decNumInStruttura", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_struttura_covid", property="decNumInStrutturaCovid", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_ultima_settimana", property="decNumUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_covid_ultima_settimana", property="decNumCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_struttura_ultima_settimana", property="decNumInStrutturaUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_struttura_covid_ultima_settimana", property="decNumInStrutturaCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_ospedale_ultima_settimana", property="decNumInOspedaleUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_ospedale_covid_ultima_settimana", property="decNumInOspedaleCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
	        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
	        @Result(column="totale", property="totale", jdbcType=JdbcType.INTEGER),
	    })
	    List<RsaDecessiExt> selectValidByIdStruttura(String idStruttura);
	   
	   @Select({
		   "<script>",
	        "select",
	        " case when COALESCE(st.nome, '')  !='' ",
		    " 	 then  st.nome ",
		    "    else ctsi.sti_nome ",
		    "end nome_st, ",
	        "d.dec_id, d.dec_num_totali_anno_precedente, d.dec_num_totali, d.dec_num_totali_covid, to_char(d.data_rilevazione, 'dd/mm/yyyy') as data_rilevazione_string, ",
	        "d.dec_num_in_ospedale, d.dec_num_in_ospedale_covid, d.id_struttura, d.str_categoria_id, ",
	        "d.data_rilevazione, d.validita_inizio, d.validita_fine, d.utente_operazione, d.data_creazione, ",
	        "d.data_modifica, d.data_cancellazione, d.data_visibilita, d.dec_num_in_ospedale_anno_precedente, ",
	        "d.dec_num_in_struttura_anno_precedente, d.dec_num_in_struttura, d.dec_num_in_struttura_covid, ",
	        "d.dec_num_ultima_settimana, d.dec_num_covid_ultima_settimana, d.dec_num_in_struttura_ultima_settimana, ",
	        "d.dec_num_in_struttura_covid_ultima_settimana, d.dec_num_in_ospedale_ultima_settimana, ",
	        "d.dec_num_in_ospedale_covid_ultima_settimana, str_categoria_desc, concat('Dal ',to_char(d.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(d.validita_fine, 'dd/mm/yyyy') ) as dati_validi  ",
	        "from covidrsa_t_decessi d ",
	        "left join covidrsa_d_struttura_categoria cs on d.str_categoria_id = cs.str_categoria_id ",
			"left join struttura st  on d.id_struttura = st.id_struttura " ,	
			"left join covidrsa_t_struttura_info ctsi  on ctsi.id_struttura = st.id_struttura " ,
			"<if test='cfUtente != null'> " , 
			"left join r_utente_struttura rus on d.id_struttura = rus.id_struttura " ,
			"</if>",
	        "where d.data_cancellazione is null ",
	       	"<if test='cfUtente != null'> " ,
	    	"and rus.cf_utente = #{cfUtente, jdbcType=VARCHAR}  ",
	    	"</if>",
	    	"<if test='dataRilevazioneDa != null'> ", 
			" and d.data_rilevazione >= #{dataRilevazioneDa, jdbcType = TIMESTAMP}",
			"</if>",
			"<if test='dataRilevazioneA != null'> ", 
			"and   #{dataRilevazioneA, jdbcType = TIMESTAMP} > d.data_rilevazione ", 
			"</if>",
			"<if test='idStruttura != null'> " ,
			"and d.id_struttura = #{idStruttura, jdbcType=VARCHAR}  ",
			"</if>",
	        "order by nome_st asc, d.data_rilevazione desc  ",
	        "</script>",
	    })
	    @Results({
	    	@Result(column="nome_st", property="nomeStruttura", jdbcType=JdbcType.VARCHAR),
			@Result(column="data_rilevazione_string", property="dataRilevazioneString", jdbcType=JdbcType.TIMESTAMP),	     
	        @Result(column="dec_num_in_ospedale_ultima_settimana", property="decNumInOspedaleUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_ospedale_covid_ultima_settimana", property="decNumInOspedaleCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),	              
	        @Result(column="dec_num_in_struttura_ultima_settimana", property="decNumInStrutturaUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_in_struttura_covid_ultima_settimana", property="decNumInStrutturaCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_ultima_settimana", property="decNumUltimaSettimana", jdbcType=JdbcType.INTEGER),
	        @Result(column="dec_num_covid_ultima_settimana", property="decNumCovidUltimaSettimana", jdbcType=JdbcType.INTEGER),	       	      
	        @Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
	        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
	    })
	   List<RsaDecessiJson> selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(@Param("cfUtente") String cfUtente, 
				@Param("dataRilevazioneDa") Date dataRilevazioneDa, 
				@Param("dataRilevazioneA") Date dataRilevazioneA,
				@Param("idStruttura") String idStruttura);
	   
	   
		

		@Insert({"INSERT INTO covidrsa_t_decessi( ",
			"   id_struttura, ",
			"   str_categoria_id, ",
			"   dec_num_totali_anno_precedente, ",
			"   dec_num_totali, ",
			"   dec_num_totali_covid, ",
			"   dec_num_in_struttura_anno_precedente, ",
			"   dec_num_in_struttura, ",
			"   dec_num_in_struttura_covid, ",
			"   dec_num_in_ospedale_anno_precedente, ",
			"   dec_num_in_ospedale, ",
			"   dec_num_in_ospedale_covid, ",
			"   dec_num_ultima_settimana, ",
			"   dec_num_covid_ultima_settimana, ",
			"   dec_num_in_struttura_ultima_settimana, ",
			"   dec_num_in_struttura_covid_ultima_settimana, ",
			"   dec_num_in_ospedale_ultima_settimana, ",
			"   dec_num_in_ospedale_covid_ultima_settimana, ",
			"   data_rilevazione, ",
			"   validita_inizio, ",
			"   validita_fine, ",
			"   utente_operazione ",
			") ",
			"SELECT ",
			"   #{idStruttura, jdbcType=VARCHAR}, ",
			"   #{strCategoriaId, jdbcType=INTEGER}, ",
			"   0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, ",
	        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP, ",
	        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '7 days', ",
	        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '1 day', ",
			"   #{cfUtente, jdbcType=VARCHAR} ",
			"FROM DUAL ",
			"WHERE NOT EXISTS ( ",
			"   SELECT 1 ",
			"   FROM covidrsa_t_decessi ",
			"   WHERE id_struttura = #{idStruttura, jdbcType=VARCHAR} ",
			"     AND str_categoria_id = #{strCategoriaId, jdbcType=INTEGER} ",
			"     AND TRUNC(data_rilevazione) = #{dataRilevazione, jdbcType = DATE} ",
			"     AND data_cancellazione IS NULL ",
			") "})
		int insertDefaultIfNotPresente( @Param("idStruttura") String idStruttura, @Param("strCategoriaId") Integer strCategoriaId, @Param("dataRilevazione") Date dataRilevazione, @Param("cfUtente") String cfUtente);


}
