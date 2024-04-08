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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaTamponiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaTamponiMapper;
import it.csi.gescovid.gestruttureresapi.dto.RsaTamponeJson;

public interface RsaTamponiMapper extends BaseRsaTamponiMapper{


	@Select({
		"select",
		"t.tamp_id, t.tamp_num_totali, t.tamp_num_positivi, t.tamp_num_negativi, t.tamp_num_in_attesa, ",
		"t.tamp_num_indeterminati, t.tamp_num_dubbi, t.tamp_cat_id, t.id_struttura, t.str_categoria_id, ",
		"t.data_rilevazione, t.validita_inizio, t.validita_fine, t.utente_operazione, t.data_creazione, ",
		"t.data_modifica, t.data_cancellazione, t.data_visibilita, t.str_tipo_tampone_id, ",
		" str_categoria_desc, concat('Dal ',to_char(t.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(t.validita_fine, 'dd/mm/yyyy') ) as dati_validi, ",
		" tamp_cat_cod, tamp_cat_desc, ti.str_tipo_tampone_cod, ti.str_tipo_tampone_desc, cs.str_categoria_desc,  ",
		"(coalesce(t.tamp_num_totali, 0) + coalesce(t.tamp_num_positivi, 0) + coalesce(t.tamp_num_negativi, 0) + coalesce(t.tamp_num_in_attesa, 0)+ coalesce(t.tamp_num_indeterminati, 0) + coalesce(t.tamp_num_dubbi, 0)) as totale  ",
		"from covidrsa_t_tamponi t ",
		"left join covidrsa_d_struttura_categoria cs on t.str_categoria_id = cs.str_categoria_id ",
		"left join covidrsa_d_tipo_tampone ti on t.str_tipo_tampone_id = ti.str_tipo_tampone_id ",
		"left join covidrsa_d_tampone_categoria tc on t.tamp_cat_id = tc.tamp_cat_id ",
		"where t.data_cancellazione is null ",
		"and t.id_struttura=#{idStruttura,jdbcType=VARCHAR}  ",
		"order by t.data_rilevazione desc  "
	})
	@Results({
		@Result(column="tamp_id", property="tampId", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="tamp_num_totali", property="tampNumTotali", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_positivi", property="tampNumPositivi", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_negativi", property="tampNumNegativi", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_in_attesa", property="tampNumInAttesa", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_indeterminati", property="tampNumIndeterminati", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_dubbi", property="tampNumDubbi", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_cat_id", property="tampCatId", jdbcType=JdbcType.INTEGER),
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
		@Result(column="str_tipo_tampone_id", property="strTipoTamponeId", jdbcType=JdbcType.INTEGER),
		@Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
		@Result(column="tamp_cat_cod", property="categoriaTampCod", jdbcType=JdbcType.VARCHAR),
		@Result(column="tamp_cat_desc", property="categoriaTampDesc", jdbcType=JdbcType.VARCHAR),
		@Result(column="totale", property="totale", jdbcType=JdbcType.INTEGER),
        @Result(column="str_tipo_tampone_cod", property="strTipoTamponeCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_tipo_tampone_desc", property="strTipoTamponeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
	}) 
	List<RsaTamponiExt> selectValidByIdStrutturaAndTipoTamponeCod(@Param("idStruttura") String idStruttura);

	@Select({
		"<script>",
		"select",
		" case when COALESCE(st.nome, '')  !='' ",
		" 	 then  st.nome ",
		"    else ctsi.sti_nome ",
		"end nome_st, ",
		"t.tamp_id, t.tamp_num_totali, t.tamp_num_positivi, t.tamp_num_negativi, t.tamp_num_in_attesa, ",
		"t.tamp_num_indeterminati, t.tamp_num_dubbi, t.tamp_cat_id, t.id_struttura, t.str_categoria_id, ",
		"t.data_rilevazione, t.validita_inizio, t.validita_fine, t.utente_operazione, t.data_creazione, ",
		"t.data_modifica, t.data_cancellazione, t.data_visibilita, t.str_tipo_tampone_id, to_char(t.data_rilevazione, 'dd/mm/yyyy') as data_rilevazione_string ,  ",
		" str_categoria_desc, concat('Dal ',to_char(t.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(t.validita_fine, 'dd/mm/yyyy') ) as dati_validi, ",
		" tamp_cat_cod, tamp_cat_desc, ",
		"(coalesce(t.tamp_num_totali, 0) + coalesce(t.tamp_num_positivi, 0) + coalesce(t.tamp_num_negativi, 0) + coalesce(t.tamp_num_in_attesa, 0)+ coalesce(t.tamp_num_indeterminati, 0) + coalesce(t.tamp_num_dubbi, 0)) as totale  ",
		"from covidrsa_t_tamponi t ",
		"left join covidrsa_d_struttura_categoria cs on t.str_categoria_id = cs.str_categoria_id ",
		"left join struttura st  on t.id_struttura = st.id_struttura " ,	
		"left join covidrsa_t_struttura_info ctsi  on ctsi.id_struttura = st.id_struttura " ,
		"<if test='cfUtente != null'> " , 
		"left join r_utente_struttura rus on t.id_struttura = rus.id_struttura " ,
		"</if>",
		"left join covidrsa_d_tipo_tampone ti on t.str_tipo_tampone_id = ti.str_tipo_tampone_id ",
		"left join covidrsa_d_tampone_categoria tc on t.tamp_cat_id = tc.tamp_cat_id ",
		"where t.data_cancellazione is null ",
		"<if test='cfUtente != null'> " ,
		"and rus.cf_utente = #{cfUtente, jdbcType=VARCHAR}  ",
		"</if>",
		"<if test='dataRilevazioneDa != null'> ", 
		" and t.data_rilevazione >= #{dataRilevazioneDa, jdbcType = TIMESTAMP}",
		"</if>",
		"<if test='dataRilevazioneA != null'> ", 
		"and   #{dataRilevazioneA, jdbcType = TIMESTAMP} > t.data_rilevazione ", 
		"</if>",
		"<if test='idStruttura != null'> " ,
		"and t.id_struttura = #{idStruttura, jdbcType=VARCHAR}  ",
		"</if>",
		"order by nome_st asc, t.data_rilevazione desc  ",
		"</script>",
	})
	@Results({
		@Result(column="nome_st", property="nomeStruttura", jdbcType=JdbcType.VARCHAR),
		@Result(column="tamp_num_totali", property="tampNumTotali", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_positivi", property="tampNumPositivi", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_num_negativi", property="tampNumNegativi", jdbcType=JdbcType.INTEGER),
		@Result(column="tamp_cat_desc", property="categoriaTampDesc", jdbcType=JdbcType.VARCHAR),
		@Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
		@Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
		@Result(column="data_rilevazione_string", property="dataRilevazioneString", jdbcType=JdbcType.TIMESTAMP),
	})
	List<RsaTamponeJson> selectValidByCfUtenteaAndTipoTamponeCodAndDataRilevazioneAndIdStruttura(@Param("cfUtente") String cfUtente, 
			@Param("dataRilevazioneDa") Date dataRilevazioneDa, 
			@Param("dataRilevazioneA") Date dataRilevazioneA,
			@Param("idStruttura") String idStruttura);
	
	

	@Insert({"INSERT INTO covidrsa_t_tamponi( ",
		"   id_struttura, ",
		"   str_categoria_id, ",
		"   tamp_cat_id, ",
		"   str_tipo_tampone_id, ",
		"   tamp_num_totali, ",
		"   tamp_num_positivi, ",
		"   tamp_num_negativi, ",
		"   tamp_num_in_attesa, ",
		"   tamp_num_indeterminati, ",
		"   tamp_num_dubbi, ",
		"   data_rilevazione, ",
		"   validita_inizio, ",
		"   validita_fine, ",
		"   utente_operazione ",
		") ",
		"SELECT ",
		"   #{idStruttura, jdbcType=VARCHAR}, ",
		"   #{strCategoriaId, jdbcType=INTEGER}, ",
		"   tc.tamp_cat_id, ",
		"   tt.str_tipo_tampone_id, ",
		"   0,0,0,0,0,0, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '7 days', ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '1 day', ",
		"   #{cfUtente, jdbcType=VARCHAR} ",
		"FROM covidrsa_d_tampone_categoria tc, covidrsa_d_tipo_tampone tt ",
        "WHERE tc.validita_fine IS NULL and tc.data_cancellazione is NULL ",
        "     AND tt.validita_fine IS NULL and tt.data_cancellazione is NULL ",
		"     AND NOT EXISTS ( ",
		"   SELECT 1 ",
		"   FROM covidrsa_t_tamponi ",
		"   WHERE id_struttura = #{idStruttura, jdbcType=VARCHAR} ",
		"     AND str_categoria_id = #{strCategoriaId, jdbcType=INTEGER} ",
		"     AND tamp_cat_id = tc.tamp_cat_id ",
		"     AND str_tipo_tampone_id = tt.str_tipo_tampone_id ",
		"     AND TRUNC(data_rilevazione) = #{dataRilevazione, jdbcType = DATE} ",
        "     AND data_cancellazione IS NULL ",
		") "})
	int insertDefaultIfNotPresente( @Param("idStruttura") String idStruttura, @Param("strCategoriaId") Integer strCategoriaId, @Param("dataRilevazione") Date dataRilevazione, @Param("cfUtente") String cfUtente);


}
