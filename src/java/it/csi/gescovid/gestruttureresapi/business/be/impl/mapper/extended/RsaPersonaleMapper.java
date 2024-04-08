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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaPersonaleExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaPersonaleMapper;
import it.csi.gescovid.gestruttureresapi.dto.RsaPersonaleJson;

public interface RsaPersonaleMapper extends BaseRsaPersonaleMapper {
	
    @Select({
        "select",
        "p.pers_id, p.pers_num_pianta_organica, p.pers_num_attuali, p.pers_num_nuove_assunzioni, ",
        "p.pers_tipo_id, id_struttura, p.str_categoria_id, p.data_rilevazione, p.validita_inizio, ",
        "p.validita_fine, p.utente_operazione, p.data_creazione, p.data_modifica, p.data_cancellazione, ",
        "data_visibilita,  str_categoria_desc, concat('Dal ',to_char(p.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(p.validita_fine, 'dd/mm/yyyy') ) as dati_validi,  ",
        "pt.pers_tipo_id, pt.pers_tipo_cod, pt.pers_tipo_desc, ",
         "(coalesce(p.pers_num_pianta_organica, 0) + coalesce(p.pers_num_attuali, 0) + coalesce(p.pers_num_nuove_assunzioni, 0)) as totale ",
        "from covidrsa_t_personale p ",
        "left join covidrsa_d_struttura_categoria cs on p.str_categoria_id = cs.str_categoria_id ",
        "left join covidrsa_d_personale_tipo pt on p.pers_tipo_id = pt.pers_tipo_id ",
        "where p.data_cancellazione is null ",
        "and p.id_struttura=#{idStruttura,jdbcType=VARCHAR}  ",
        "order by p.data_rilevazione desc  "
    })
    @Results({
        @Result(column="pers_id", property="persId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pers_num_pianta_organica", property="persNumPiantaOrganica", jdbcType=JdbcType.INTEGER),
        @Result(column="pers_num_attuali", property="persNumAttuali", jdbcType=JdbcType.INTEGER),
        @Result(column="pers_num_nuove_assunzioni", property="persNumNuoveAssunzioni", jdbcType=JdbcType.INTEGER),
        @Result(column="pers_tipo_id", property="persTipoId", jdbcType=JdbcType.INTEGER),
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
        @Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="pers_tipo_id", property="persTipoId", jdbcType=JdbcType.INTEGER),
        @Result(column="pers_tipo_cod", property="persTipoCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="pers_tipo_desc", property="persTipoDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="totale", property="totale", jdbcType=JdbcType.INTEGER),
        
    })
    
    List<RsaPersonaleExt> selectValidByIdStruttura(String idStruttura);
    
    @Select({
    	"<script>",
        "select",
        " case when COALESCE(st.nome, '')  !='' ",
	    " 	 then  st.nome ",
	    "    else ctsi.sti_nome ",
	    "end nome_st, ",
        "p.pers_id, p.pers_num_pianta_organica, p.pers_num_attuali, p.pers_num_nuove_assunzioni, ",
        "p.pers_tipo_id, p.str_categoria_id, p.data_rilevazione, p.validita_inizio, to_char(p.data_rilevazione, 'dd/mm/yyyy') as data_rilevazione_string , ",
        "p.validita_fine, p.utente_operazione, p.data_creazione, p.data_modifica, p.data_cancellazione, cdpt.pers_tipo_desc, ",
        "data_visibilita,  str_categoria_desc, concat('Dal ',to_char(p.validita_inizio, 'dd/mm/yyyy'),' al ' ,to_char(p.validita_fine, 'dd/mm/yyyy') ) as dati_validi  ",
        "from covidrsa_t_personale p ",
        "left join covidrsa_d_struttura_categoria cs on p.str_categoria_id = cs.str_categoria_id ",
        "left join covidrsa_d_personale_tipo cdpt on cdpt.pers_tipo_id = p.pers_tipo_id ",
        "left join struttura st  on p.id_struttura = st.id_struttura " ,	
        "left join covidrsa_t_struttura_info ctsi  on ctsi.id_struttura = st.id_struttura " ,
        "<if test='cfUtente != null'> " , 
        "left join r_utente_struttura rus on p.id_struttura = rus.id_struttura " ,
    	"</if>",
        "where p.data_cancellazione is null ",
    	"<if test='cfUtente != null'> " ,
    	"and rus.cf_utente = #{cfUtente, jdbcType=VARCHAR}  ",
    	"</if>",
    	"<if test='dataRilevazioneDa != null'> ", 
		" and p.data_rilevazione >= #{dataRilevazioneDa, jdbcType = TIMESTAMP}",
		"</if>",
		"<if test='dataRilevazioneA != null'> ", 
		"and   #{dataRilevazioneA, jdbcType = TIMESTAMP} > p.data_rilevazione ", 
		"</if>",
		"<if test='idStruttura != null'> " ,
    	"and p.id_struttura = #{idStruttura, jdbcType=VARCHAR}  ",
    	"</if>",
        "order by nome_st asc, p.data_rilevazione desc  ",
        "</script>"
    })
    @Results({
    	 @Result(column="nome_st", property="nomeStruttura", jdbcType=JdbcType.VARCHAR),
        @Result(column="pers_num_attuali", property="persNumAttuali", jdbcType=JdbcType.INTEGER),
        @Result(column="data_rilevazione_string", property="dataRilevazioneString", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dati_validi", property="datiValidi", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="pers_tipo_desc", property="tipologiaPersonale", jdbcType=JdbcType.VARCHAR),
    })
    List<RsaPersonaleJson> selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(@Param("cfUtente") String cfUtente,
    		@Param("dataRilevazioneDa") Date dataRilevazioneDa, 
    		@Param("dataRilevazioneA") Date dataRilevazioneA,
    		@Param("idStruttura") String idStruttura);
    		
    

	@Insert({"INSERT INTO covidrsa_t_personale( ",
		"   id_struttura, ",
		"   str_categoria_id, ",
		"   pers_tipo_id, ",
		"   pers_num_pianta_organica, ",
		"   pers_num_attuali, ",
		"   pers_num_nuove_assunzioni, ",
		"   data_rilevazione, ",
		"   validita_inizio, ",
		"   validita_fine, ",
		"   utente_operazione ",
		") ",
		"SELECT ",
		"   #{idStruttura, jdbcType=VARCHAR}, ",
		"   #{strCategoriaId, jdbcType=INTEGER}, ",
		"   pt.pers_tipo_id, ",
		"   0,0,0, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP, ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '7 days', ",
        "(#{dataRilevazione, jdbcType = DATE})::TIMESTAMP - INTERVAL '1 day', ",
		"   #{cfUtente, jdbcType=VARCHAR} ",
		"FROM covidrsa_d_personale_tipo pt ",
        "WHERE pt.validita_fine IS NULL and pt.data_cancellazione is NULL ",
        "     AND NOT EXISTS ( ",
		"   SELECT 1 ",
		"   FROM covidrsa_t_personale ",
		"   WHERE id_struttura = #{idStruttura, jdbcType=VARCHAR} ",
		"     AND str_categoria_id = #{strCategoriaId, jdbcType=INTEGER} ",
		"     AND pers_tipo_id = pt.pers_tipo_id ",
		"     AND TRUNC(data_rilevazione) = #{dataRilevazione, jdbcType = DATE} ",
		"     AND data_cancellazione IS NULL ",
		") "})
	int insertDefaultIfNotPresente( @Param("idStruttura") String idStruttura, @Param("strCategoriaId") Integer strCategoriaId, @Param("dataRilevazione") Date dataRilevazione, @Param("cfUtente") String cfUtente);


}
