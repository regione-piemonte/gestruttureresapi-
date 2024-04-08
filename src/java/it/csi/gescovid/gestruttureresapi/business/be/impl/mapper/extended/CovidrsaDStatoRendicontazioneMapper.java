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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaDStatoRendicontazioneExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidrsaDStatoRendicontazioneMapper;

public interface CovidrsaDStatoRendicontazioneMapper extends BaseCovidrsaDStatoRendicontazioneMapper {

    @Select({
        "select",
        "cdsr.stato_rend_id, cdsr.stato_rend_cod, cdsr.stato_rend_desc, cdsr.flg_modificabile, cdsr.flg_stato_iniziale, ",
        "cdsr.flg_stato_finale, cdsr.validita_inizio, cdsr.validita_fine, cdsr.data_creazione, cdsr.data_modifica, ",
        "cdsr.data_cancellazione, cdsr.utente_operazione ",
        "from covidrsa_d_stato_rendicontazione cdsr ",
        "where cdsr.data_cancellazione is null ",
        "and now() between cdsr.validita_inizio and coalesce(cdsr.validita_fine, now()) "
    })
    @Results({
        @Result(column="stato_rend_id", property="statoRendId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stato_rend_cod", property="statoRendCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="stato_rend_desc", property="statoRendDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_modificabile", property="flgModificabile", jdbcType=JdbcType.BIT),
        @Result(column="flg_stato_iniziale", property="flgStatoIniziale", jdbcType=JdbcType.BIT),
        @Result(column="flg_stato_finale", property="flgStatoFinale", jdbcType=JdbcType.BIT),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR)
    })
    List<CovidrsaDStatoRendicontazioneExt> selectAllValid();

    @Select({ "select", "stato_rend_id",
            " from covidrsa_d_stato_rendicontazione ",
            "where stato_rend_cod = #{statoRendCod,jdbcType=VARCHAR} and data_cancellazione is null " })
    Integer selectIdByCod(String statoRendCod);
}
