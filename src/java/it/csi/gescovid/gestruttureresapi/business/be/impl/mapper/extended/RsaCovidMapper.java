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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaCovidExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaCovidMapper;
import it.csi.gescovid.gestruttureresapi.dto.RsaCovidJson;

public interface RsaCovidMapper extends BaseRsaCovidMapper {

	@Select({
		"select",
		"c.covid_id, c.covid_num_sospetti, c.covid_num_isolati, c.id_struttura, c.str_categoria_id, ",
		"c.data_rilevazione, c.validita_inizio, c.validita_fine, c.utente_operazione, c.data_creazione, ",
		"c.data_modifica, c.data_cancellazione, c.data_visibilita, c.covid_num_ospedalizzati, ",
		"str_categoria_desc, concat('Dal ',to_char(c.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(c.validita_fine, 'dd/mm/yyyy') ) as dati_validi, ",
		"(coalesce(c.covid_num_sospetti, 0) + coalesce(c.covid_num_isolati, 0) + coalesce(c.covid_num_ospedalizzati, 0)) as totale ",
		"from covidrsa_t_covid c ",
		"left join covidrsa_d_struttura_categoria cs on c.str_categoria_id = cs.str_categoria_id ",
		"where c.data_cancellazione is null ",
		"and c.id_struttura=#{idStruttura,jdbcType=VARCHAR}  ",
		"order by c.data_rilevazione desc  "
	})

	@Results({
		@Result(column="covid_id", property="covidId", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="covid_num_sospetti", property="covidNumSospetti", jdbcType=JdbcType.INTEGER),
		@Result(column="covid_num_isolati", property="covidNumIsolati", jdbcType=JdbcType.INTEGER),
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
		@Result(column="covid_num_ospedalizzati", property="covidNumOspedalizzati", jdbcType=JdbcType.INTEGER),
		@Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
		@Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
		@Result(column="totale", property="totale", jdbcType=JdbcType.INTEGER),
	})
	List<RsaCovidExt> selectValidByIdStruttura(String idStruttura);

	@Select({
		"<script>",
		"select",
        " case when COALESCE(st.nome, '')  !='' ",
	    " 	 then  st.nome ",
	    "    else ctsi.sti_nome ",
	    "end nome_st, ",
		"c.covid_id, c.covid_num_sospetti, c.covid_num_isolati, c.id_struttura, c.str_categoria_id, to_char(c.data_rilevazione, 'dd/mm/yyyy') as data_rilevazione_string , ",
		"c.data_rilevazione, c.validita_inizio, c.validita_fine, c.utente_operazione, c.data_creazione, ",
		"c.data_modifica, c.data_cancellazione, c.data_visibilita, c.covid_num_ospedalizzati, ",
		"str_categoria_desc, concat('Dal ',to_char(c.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(c.validita_fine, 'dd/mm/yyyy') ) as dati_validi ",
		"from covidrsa_t_covid c ",
		"left join covidrsa_d_struttura_categoria cs on c.str_categoria_id = cs.str_categoria_id ",
		"left join struttura st  on c.id_struttura = st.id_struttura " ,	
		"left join covidrsa_t_struttura_info ctsi  on ctsi.id_struttura = st.id_struttura " ,
		"<if test='cfUtente != null'> " , 
		"left join r_utente_struttura rus on c.id_struttura = rus.id_struttura " ,
		"</if>",
		"where c.data_cancellazione is null ",
       	"<if test='cfUtente != null'> " ,
    	"and rus.cf_utente = #{cfUtente, jdbcType=VARCHAR}  ",
    	"</if>",
    	"<if test='dataRilevazioneDa != null'> ", 
		" and c.data_rilevazione >= #{dataRilevazioneDa, jdbcType = TIMESTAMP}",
		"</if>",
		"<if test='dataRilevazioneA != null'> ", 
		"and   #{dataRilevazioneA, jdbcType = TIMESTAMP} > c.data_rilevazione ", 
		"</if>",
		"<if test='idStruttura != null'> " ,
		"and c.id_struttura = #{idStruttura, jdbcType=VARCHAR}  ",
		"</if>",
        "order by nome_st asc, c.data_rilevazione desc  ",
        "</script>",
	})

	@Results({
		@Result(column="nome_st", property="nomeStruttura", jdbcType=JdbcType.VARCHAR),
		@Result(column="data_rilevazione_string", property="dataRilevazioneString", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="covid_num_isolati", property="covidNumIsolati", jdbcType=JdbcType.INTEGER),
		@Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
		@Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
	})
	List<RsaCovidJson> selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(@Param("cfUtente") String cfUtente, 
			@Param("dataRilevazioneDa") Date dataRilevazioneDa, 
			@Param("dataRilevazioneA") Date dataRilevazioneA,
			@Param("idStruttura") String idStruttura);
	

	@Insert({"INSERT INTO covidrsa_t_covid( ",
		"   id_struttura, ",
		"   str_categoria_id, ",
		"   covid_num_sospetti, ",
		"   covid_num_isolati, ",
		"   covid_num_ospedalizzati, ",
		"   data_rilevazione, ",
		"   validita_inizio, ",
		"   validita_fine, ",
		"   utente_operazione ",
		") ",
		"SELECT ",
		"   #{idStruttura, jdbcType=VARCHAR}, ",
		"   #{strCategoriaId, jdbcType=INTEGER}, ",
		"   0,0,0, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '7 days', ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '1 day', ",
		"   #{cfUtente, jdbcType=VARCHAR} ",
		"FROM DUAL ",
		"WHERE NOT EXISTS ( ",
		"   SELECT 1 ",
		"   FROM covidrsa_t_covid ",
		"   WHERE id_struttura = #{idStruttura, jdbcType=VARCHAR} ",
		"     AND str_categoria_id = #{strCategoriaId, jdbcType=INTEGER} ",
		"     AND TRUNC(data_rilevazione) = #{dataRilevazione, jdbcType = DATE} ",
		"     AND data_cancellazione IS NULL ",
		") "})
	int insertDefaultIfNotPresente( @Param("idStruttura") String idStruttura, @Param("strCategoriaId") Integer strCategoriaId, @Param("dataRilevazione") Date dataRilevazione, @Param("cfUtente") String cfUtente);

}
