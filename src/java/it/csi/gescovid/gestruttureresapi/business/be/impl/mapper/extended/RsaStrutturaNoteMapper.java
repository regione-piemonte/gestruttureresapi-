/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaStrutturaNoteExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseRsaStrutturaNoteMapper;

public interface RsaStrutturaNoteMapper extends BaseRsaStrutturaNoteMapper {
	
    @Select({
        "select",
        "sn.stn_id, sn.stn_note, sn.id_struttura, sn.str_categoria_id, sn.data_rilevazione, sn.validita_inizio, ",
        "sn.validita_fine, sn.utente_operazione, sn.data_creazione, sn.data_modifica, sn.data_cancellazione, ",
        "sn.data_visibilita, st.nome as nome_struttura, str_categoria_desc ",
        "from covidrsa_t_struttura_note sn ",
        "left join covidrsa_d_struttura_categoria cs on sn.str_categoria_id = cs.str_categoria_id ",
        "left join struttura st on sn.id_struttura = st.id_struttura " ,
        "left join r_utente_struttura rus on rus.id_struttura = st.id_struttura " ,
        "where sn.data_cancellazione is null ",
        "and rus.cf_utente = #{cfUtente, jdbcType=VARCHAR}  ",
        
    })
    @Results({
        @Result(column="stn_id", property="stnId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stn_note", property="stnNote", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="str_categoria_desc", property="tipologiaStrutturaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="nome_struttura", property="nomeStruttura", jdbcType=JdbcType.VARCHAR),
    })
    List<RsaStrutturaNoteExt> selectValidByCfUtente(String cfUtente);

}
