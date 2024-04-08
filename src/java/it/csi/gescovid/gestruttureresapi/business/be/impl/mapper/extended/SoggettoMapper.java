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
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.SoggettoExtDto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseSoggettoMapper;


public interface SoggettoMapper extends BaseSoggettoMapper {
    
	@Insert({ "insert into soggetto (id_soggetto, codice_fiscale, id_asr, ", "cognome, nome, ", "comune_residenza_istat, comune_domicilio_istat, ",
		"indirizzo_domicilio, telefono_recapito, data_nascita, asl_residenza, asl_domicilio, email,id_tipo_soggetto,",
		"utente_operazione, webapp_operazione, id_profilo_operazione, ",
        "ruolo_operazione, id_ente_operazione, ",
        "id_struttura_operazione, id_area_operazione ",
		")", 
		"values (nextval('seq_id_soggetto'),  UPPER(#{codiceFiscale,jdbcType=VARCHAR}), #{idAsr,jdbcType=BIGINT}, ",
		"UPPER(#{cognome,jdbcType=VARCHAR}), UPPER(#{nome,jdbcType=VARCHAR}),  ",
		"#{comuneResidenzaIstat,jdbcType=VARCHAR}, #{comuneDomicilioIstat,jdbcType=VARCHAR}, ",
		"UPPER(#{indirizzoDomicilio,jdbcType=VARCHAR}), UPPER(#{telefonoRecapito,jdbcType=VARCHAR}),#{dataNascita,jdbcType=DATE},"
		+"#{aslResidenza,jdbcType=VARCHAR}, #{aslDomicilio,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{idTipoSoggetto,jdbcType=BIGINT},",
		"#{utenteOperazione,jdbcType=VARCHAR},#{webappOperazione,jdbcType=VARCHAR}, #{idProfiloOperazione,jdbcType=INTEGER}, ",
	    "#{ruoloOperazione,jdbcType=VARCHAR}, #{idEnteOperazione,jdbcType=INTEGER}, ",
	    "#{idStrutturaOperazione,jdbcType=VARCHAR}, #{idAreaOperazione,jdbcType=INTEGER}",
	")" })
	@Options(useGeneratedKeys = true, keyProperty = "idSoggetto")
	int insert(Soggetto record);

	@Select({
		"select fnc_trasf_asr_sogg(#{idSoggetto,jdbcType=BIGINT},#{idAsr,jdbcType=BIGINT},#{dataEvento,jdbcType=DATE})"
	})
	int callMigrazioneAsr(@Param("idSoggetto") String idSoggetto, @Param("idAsr") String idAsr, @Param("dataEvento") String dataEvento);
	
	@Update({ "update soggetto", "set ",
			"id_asr = #{idAsr,jdbcType=BIGINT}",
			"where id_soggetto = #{idSoggetto,jdbcType=BIGINT}" })
	int updateAsrByPrimaryKey(Soggetto record);
	
   
   
    @Select({"<script>",
        "select",
        "soggetto.id_soggetto , soggetto.codice_fiscale, soggetto.id_asr, soggetto.cognome, soggetto.nome, soggetto.data_nascita, soggetto.comune_residenza_istat, ",
        "soggetto.comune_domicilio_istat, soggetto.indirizzo_domicilio, soggetto.telefono_recapito, ",
        "soggetto.asl_residenza, soggetto.asl_domicilio,soggetto.email,soggetto.id_tipo_soggetto, d_tipo_soggetto.desc_tipo_soggetto, ",
        "comuni_dom.nome_comune as comune_domicilio_nome, comuni_res.nome_comune as comune_residenza_nome, ",
        "asr.descrizione as asr_descrizione, "
        + " (select count(*) from tampone where id_soggetto = soggetto.id_soggetto) as numero_tamponi, ",
        "   (select count(*) from decorso where id_soggetto = soggetto.id_soggetto) as numero_decorsi, ",
        " d_max.id_tipo_evento as ultimo_id_tipo_evento ",
        " from soggetto "
        + "LEFT join comuni comuni_res on soggetto.comune_residenza_istat = comuni_res.istat_comune "
        + "LEFT join comuni comuni_dom on soggetto.comune_domicilio_istat = comuni_dom.istat_comune "
        + "left join d_tipo_soggetto on  soggetto.id_tipo_soggetto = d_tipo_soggetto.id_tipo_soggetto "
        + "LEFT join asr on  soggetto.id_asr = asr.id_asr "
    	+ "LEFT join (select distinct on(id_soggetto) * from decorso order by" ,
    	"				id_soggetto, " ,
    	"				data_dimissioni desc nulls last ," , 
    	"				data_evento desc nulls last," ,
    	"				id_decorso desc) d_max on ", 
    	"	d_max.id_soggetto = soggetto.id_soggetto",
        " where ",
        " soggetto.id_soggetto=#{idSoggetto,jdbcType=BIGINT}  " ,
        //" <if test='idAsr != -1'> AND soggetto.id_asr=#{idAsr,jdbcType=BIGINT} </if>",
        "</script>"
    })
    @Results({
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="codice_fiscale", property="codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_asr", property="idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita", property="dataNascita", jdbcType=JdbcType.DATE),
        @Result(column="comune_residenza_istat", property="comuneResidenzaIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilioIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_domicilio", property="indirizzoDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_recapito", property="telefonoRecapito", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
		@Result(column = "id_tipo_soggetto", property = "idTipoSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "id_tipo_soggetto", property = "tipoSoggetto.idTipoSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "desc_tipo_soggetto", property = "tipoSoggetto.descTipoSoggetto", jdbcType = JdbcType.VARCHAR),
        @Result(column="id_asr", property="asr.idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="asr_descrizione", property="asr.descrizione", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_nome", property="comuneDomicilio.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilio.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_nome", property="comuneResidenza.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_istat", property="comuneResidenza.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="numero_tamponi", property="numeroCampioni", jdbcType=JdbcType.BIGINT),
        @Result(column="numero_decorsi", property="numeroDecorsi", jdbcType=JdbcType.BIGINT),
		@Result(column = "asl_residenza", property = "aslResidenza", jdbcType = JdbcType.VARCHAR),
		@Result(column = "asl_domicilio", property = "aslDomicilio", jdbcType = JdbcType.VARCHAR),
		@Result(column = "ultimo_id_tipo_evento", property = "ultimoIdTipoEvento", jdbcType = JdbcType.INTEGER)
    })
    SoggettoExtDto selectForElencoByIdSoggetto(@Param("idSoggetto") Long idSoggetto);

    
    
    
    
    @Select({"<script>",
        "select",
        "soggetto.id_soggetto , soggetto.codice_fiscale, soggetto.id_asr, soggetto.cognome, soggetto.nome, soggetto.data_nascita, soggetto.comune_residenza_istat, ",
        "soggetto.comune_domicilio_istat, soggetto.indirizzo_domicilio, soggetto.telefono_recapito, soggetto.documento_numero , soggetto.documento_tipo_id , ",
        "soggetto.asl_residenza, soggetto.asl_domicilio,soggetto.email,soggetto.id_tipo_soggetto, d_tipo_soggetto.desc_tipo_soggetto, ",
        "comuni_dom.nome_comune as comune_domicilio_nome, comuni_res.nome_comune as comune_residenza_nome, ",
        "asr.descrizione as asr_descrizione, "
        + " (select count(*) from tampone where id_soggetto = soggetto.id_soggetto) as numero_tamponi, ",
        "   (select count(*) from decorso where id_soggetto = soggetto.id_soggetto) as numero_decorsi, ",
        " d_max.id_tipo_evento as ultimo_id_tipo_evento ",
        " from soggetto "
        + "LEFT join comuni comuni_res on soggetto.comune_residenza_istat = comuni_res.istat_comune "
        + "LEFT join comuni comuni_dom on soggetto.comune_domicilio_istat = comuni_dom.istat_comune "
        + "left join d_tipo_soggetto on  soggetto.id_tipo_soggetto = d_tipo_soggetto.id_tipo_soggetto "
        + "LEFT join asr on  soggetto.id_asr = asr.id_asr "
    	+ "LEFT join (select distinct on(id_soggetto) * from decorso order by" ,
    	"				id_soggetto, " ,
    	"				data_dimissioni desc nulls last ," , 
    	"				data_evento desc nulls last," ,
    	"				id_decorso desc) d_max on ", 
    	"	d_max.id_soggetto = soggetto.id_soggetto ",
		"<where>",
		"1=1 ",
		"<if test='cfSoggetto != null'> and soggetto.codice_fiscale ILIKE '%${cfSoggetto}%' </if> ",
		"<if test='nome != null'> and soggetto.nome ILIKE '%${nome}%' </if> ",
		"<if test='cognome != null'> and soggetto.cognome ILIKE '%${cognome}%' </if> ",
		"<if test='dataNascita != null'> and to_char(soggetto.data_nascita, 'dd-mm-yyyy') = #{dataNascita,jdbcType=VARCHAR} </if> ",
		"</where>",
        "</script>"
    })
    @Results({
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="codice_fiscale", property="codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_asr", property="idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita", property="dataNascita", jdbcType=JdbcType.DATE),
        @Result(column="comune_residenza_istat", property="comuneResidenzaIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilioIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_domicilio", property="indirizzoDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_recapito", property="telefonoRecapito", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
		@Result(column = "id_tipo_soggetto", property = "idTipoSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "id_tipo_soggetto", property = "tipoSoggetto.idTipoSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "desc_tipo_soggetto", property = "tipoSoggetto.descTipoSoggetto", jdbcType = JdbcType.VARCHAR),
        @Result(column="id_asr", property="asr.idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="asr_descrizione", property="asr.descrizione", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_nome", property="comuneDomicilio.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilio.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_nome", property="comuneResidenza.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_istat", property="comuneResidenza.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="numero_tamponi", property="numeroCampioni", jdbcType=JdbcType.BIGINT),
        @Result(column="numero_decorsi", property="numeroDecorsi", jdbcType=JdbcType.BIGINT),
		@Result(column = "asl_residenza", property = "aslResidenza", jdbcType = JdbcType.VARCHAR),
		@Result(column = "asl_domicilio", property = "aslDomicilio", jdbcType = JdbcType.VARCHAR),
		@Result(column = "ultimo_id_tipo_evento", property = "ultimoIdTipoEvento", jdbcType = JdbcType.INTEGER),
		@Result(column = "documento_tipo_id", property = "documentoTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "documento_numero", property = "documentoNumero", jdbcType = JdbcType.VARCHAR)
		
    })
    SoggettoExtDto selectSoggettoBySoggetto(@Param("cfSoggetto") String cfSoggetto, @Param("nome") String nome, @Param("cognome") String cognome, @Param("dataNascita") String dataNascita);
    
    
    @Select({"<script>",
        "select",
        "soggetto.id_soggetto , soggetto.codice_fiscale, soggetto.id_asr, soggetto.cognome, soggetto.nome, soggetto.data_nascita, soggetto.comune_residenza_istat, ",
        "soggetto.comune_domicilio_istat, soggetto.indirizzo_domicilio, soggetto.telefono_recapito, soggetto.documento_numero , soggetto.documento_tipo_id ,",
        "soggetto.asl_residenza, soggetto.asl_domicilio,soggetto.email,soggetto.id_tipo_soggetto, d_tipo_soggetto.desc_tipo_soggetto, ",
        "comuni_dom.nome_comune as comune_domicilio_nome, comuni_res.nome_comune as comune_residenza_nome, ",
        "asr.descrizione as asr_descrizione, "
        + " (select count(*) from tampone where id_soggetto = soggetto.id_soggetto) as numero_tamponi, ",
        "   (select count(*) from decorso where id_soggetto = soggetto.id_soggetto) as numero_decorsi, ",
        " d_max.id_tipo_evento as ultimo_id_tipo_evento ",
        " from soggetto "
        + "LEFT join comuni comuni_res on soggetto.comune_residenza_istat = comuni_res.istat_comune "
        + "LEFT join comuni comuni_dom on soggetto.comune_domicilio_istat = comuni_dom.istat_comune "
        + "left join d_tipo_soggetto on  soggetto.id_tipo_soggetto = d_tipo_soggetto.id_tipo_soggetto "
        + "LEFT join asr on  soggetto.id_asr = asr.id_asr "
    	+ "LEFT join (select distinct on(id_soggetto) * from decorso order by" ,
    	"				id_soggetto, " ,
    	"				data_dimissioni desc nulls last ," , 
    	"				data_evento desc nulls last," ,
    	"				id_decorso desc) d_max on ", 
    	"	d_max.id_soggetto = soggetto.id_soggetto ",
		"<where>",
		"1=1 ",
		"<if test='cfSoggetto != null'> and soggetto.codice_fiscale ILIKE concat('%',#{cfSoggetto,jdbcType=VARCHAR},'%') </if> ",
		"<if test='nome != null'> and soggetto.nome ILIKE concat('%',#{nome,jdbcType=VARCHAR},'%') </if> ",
		"<if test='cognome != null'> and soggetto.cognome ILIKE concat('%',#{cognome,jdbcType=VARCHAR},'%') </if> ",
		"	<if test='dataNascita != null'> and to_char(soggetto.data_nascita, 'dd-mm-yyyy') = #{dataNascita,jdbcType=VARCHAR} </if> ",
		"</where>",
        "</script>"
    })
    @Results({
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="codice_fiscale", property="codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_asr", property="idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita", property="dataNascita", jdbcType=JdbcType.DATE),
        @Result(column="comune_residenza_istat", property="comuneResidenzaIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilioIstat", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_domicilio", property="indirizzoDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_recapito", property="telefonoRecapito", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
		@Result(column = "id_tipo_soggetto", property = "idTipoSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "id_tipo_soggetto", property = "tipoSoggetto.idTipoSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "desc_tipo_soggetto", property = "tipoSoggetto.descTipoSoggetto", jdbcType = JdbcType.VARCHAR),
        @Result(column="id_asr", property="asr.idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="asr_descrizione", property="asr.descrizione", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_nome", property="comuneDomicilio.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_istat", property="comuneDomicilio.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_nome", property="comuneResidenza.nomeComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_istat", property="comuneResidenza.istatComune", jdbcType=JdbcType.VARCHAR),
        @Result(column="numero_tamponi", property="numeroCampioni", jdbcType=JdbcType.BIGINT),
        @Result(column="numero_decorsi", property="numeroDecorsi", jdbcType=JdbcType.BIGINT),
		@Result(column = "asl_residenza", property = "aslResidenza", jdbcType = JdbcType.VARCHAR),
		@Result(column = "asl_domicilio", property = "aslDomicilio", jdbcType = JdbcType.VARCHAR),
		@Result(column = "ultimo_id_tipo_evento", property = "ultimoIdTipoEvento", jdbcType = JdbcType.INTEGER),
		@Result(column = "documento_tipo_id", property = "documentoTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "documento_numero", property = "documentoNumero", jdbcType = JdbcType.VARCHAR)
    })
    List<SoggettoExtDto> selectListSoggettoBySoggetto(@Param("cfSoggetto") String cfSoggetto, @Param("nome") String nome, @Param("cognome") String cognome, @Param("dataNascita") String dataNascita);

}
