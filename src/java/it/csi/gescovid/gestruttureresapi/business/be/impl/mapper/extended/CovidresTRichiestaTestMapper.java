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

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidresTRichiestaTest;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidresTRichiestaTestExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseCovidresTRichiestaTestMapper;

public interface CovidresTRichiestaTestMapper extends BaseCovidresTRichiestaTestMapper {
    

    @Select({
        "select ",
        "ctrt.richiesta_test_id, ctrt.data_richiesta, ctrt.data_approviggionamento, ctrt.numero_test,  ",
        "ctrt.validita_inizio, ctrt.validita_fine ",
        "from covidres_t_richiesta_test ctrt ",
        "where ctrt.id_struttura = #{idStruttura,jdbcType=VARCHAR}  ",
        "and ctrt.data_cancellazione is null  ",
        "and now() between ctrt.validita_inizio and coalesce(ctrt.validita_fine, now())  ",
        "order by ctrt.data_approviggionamento desc "
    })
    @Results({
        @Result(column="richiesta_test_id", property="richiestaTestId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="data_richiesta", property="dataRichiesta", jdbcType=JdbcType.DATE),
        @Result(column="data_approviggionamento", property="dataApproviggionamento", jdbcType=JdbcType.DATE),
        @Result(column="numero_test", property="numeroTest", jdbcType=JdbcType.INTEGER),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
    })
    List<CovidresTRichiestaTestExt> selectFromIdStruttura(@Param("idStruttura") String idStruttura);
    

    @Insert({
        "insert into covidres_t_richiesta_test (id_struttura, data_richiesta, ",
        "data_approviggionamento, numero_test, ",
        "validita_inizio, validita_fine, ",
        "data_creazione, data_modifica, ",
        "data_cancellazione, utente_operazione)",
        "values (#{idStruttura,jdbcType=VARCHAR}, #{dataRichiesta,jdbcType=DATE}, ",
        "#{dataApproviggionamento,jdbcType=DATE}, #{numeroTest,jdbcType=INTEGER}, ",
        "coalesce(#{validitaInizio,jdbcType=TIMESTAMP},now()), #{validitaFine,jdbcType=TIMESTAMP}, ",
        "now(), now(), ",
        "#{dataCancellazione,jdbcType=TIMESTAMP}, #{utenteOperazione,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="richiestaTestId")
    int insert(CovidresTRichiestaTest record);

    @Update({
            "update covidres_t_richiesta_test",
            "set ",
            "validita_fine = now() ",
            "where richiesta_test_id = #{richiestaTestId,jdbcType=INTEGER}",
            " and data_cancellazione is null ",
            " and validita_fine is null "
    })
    int updateValiditaFine(CovidresTRichiestaTest record);

    @Update({
            "update covidres_t_richiesta_test",
            "set ",
            "data_cancellazione = now() ",
            "where richiesta_test_id = #{richiestaTestId,jdbcType=INTEGER}",
            " and data_cancellazione is null "
    })
    int updateDataCancellazione(CovidresTRichiestaTest record);

}
