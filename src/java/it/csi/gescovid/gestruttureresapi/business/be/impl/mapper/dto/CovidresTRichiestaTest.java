/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidresTRichiestaTest extends AbstractDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.richiesta_test_id
     *
     * @mbg.generated
     */
    private Integer richiestaTestId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.id_struttura
     *
     * @mbg.generated
     */
    private String idStruttura;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.data_richiesta
     *
     * @mbg.generated
     */
    private Date dataRichiesta;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.data_approviggionamento
     *
     * @mbg.generated
     */
    private Date dataApproviggionamento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.numero_test
     *
     * @mbg.generated
     */
    private Integer numeroTest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.validita_inizio
     *
     * @mbg.generated
     */
    private Date validitaInizio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.validita_fine
     *
     * @mbg.generated
     */
    private Date validitaFine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.data_creazione
     *
     * @mbg.generated
     */
    private Date dataCreazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.data_modifica
     *
     * @mbg.generated
     */
    private Date dataModifica;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.data_cancellazione
     *
     * @mbg.generated
     */
    private Date dataCancellazione;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column covidres_t_richiesta_test.utente_operazione
     *
     * @mbg.generated
     */
    private String utenteOperazione;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.richiesta_test_id
     *
     * @return the value of covidres_t_richiesta_test.richiesta_test_id
     *
     * @mbg.generated
     */
    public Integer getRichiestaTestId() {
        return richiestaTestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.richiesta_test_id
     *
     * @param richiestaTestId the value for covidres_t_richiesta_test.richiesta_test_id
     *
     * @mbg.generated
     */
    public void setRichiestaTestId(Integer richiestaTestId) {
        this.richiestaTestId = richiestaTestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.id_struttura
     *
     * @return the value of covidres_t_richiesta_test.id_struttura
     *
     * @mbg.generated
     */
    public String getIdStruttura() {
        return idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.id_struttura
     *
     * @param idStruttura the value for covidres_t_richiesta_test.id_struttura
     *
     * @mbg.generated
     */
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.data_richiesta
     *
     * @return the value of covidres_t_richiesta_test.data_richiesta
     *
     * @mbg.generated
     */
    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.data_richiesta
     *
     * @param dataRichiesta the value for covidres_t_richiesta_test.data_richiesta
     *
     * @mbg.generated
     */
    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.data_approviggionamento
     *
     * @return the value of covidres_t_richiesta_test.data_approviggionamento
     *
     * @mbg.generated
     */
    public Date getDataApproviggionamento() {
        return dataApproviggionamento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.data_approviggionamento
     *
     * @param dataApproviggionamento the value for covidres_t_richiesta_test.data_approviggionamento
     *
     * @mbg.generated
     */
    public void setDataApproviggionamento(Date dataApproviggionamento) {
        this.dataApproviggionamento = dataApproviggionamento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.numero_test
     *
     * @return the value of covidres_t_richiesta_test.numero_test
     *
     * @mbg.generated
     */
    public Integer getNumeroTest() {
        return numeroTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.numero_test
     *
     * @param numeroTest the value for covidres_t_richiesta_test.numero_test
     *
     * @mbg.generated
     */
    public void setNumeroTest(Integer numeroTest) {
        this.numeroTest = numeroTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.validita_inizio
     *
     * @return the value of covidres_t_richiesta_test.validita_inizio
     *
     * @mbg.generated
     */
    public Date getValiditaInizio() {
        return validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.validita_inizio
     *
     * @param validitaInizio the value for covidres_t_richiesta_test.validita_inizio
     *
     * @mbg.generated
     */
    public void setValiditaInizio(Date validitaInizio) {
        this.validitaInizio = validitaInizio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.validita_fine
     *
     * @return the value of covidres_t_richiesta_test.validita_fine
     *
     * @mbg.generated
     */
    public Date getValiditaFine() {
        return validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.validita_fine
     *
     * @param validitaFine the value for covidres_t_richiesta_test.validita_fine
     *
     * @mbg.generated
     */
    public void setValiditaFine(Date validitaFine) {
        this.validitaFine = validitaFine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.data_creazione
     *
     * @return the value of covidres_t_richiesta_test.data_creazione
     *
     * @mbg.generated
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.data_creazione
     *
     * @param dataCreazione the value for covidres_t_richiesta_test.data_creazione
     *
     * @mbg.generated
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.data_modifica
     *
     * @return the value of covidres_t_richiesta_test.data_modifica
     *
     * @mbg.generated
     */
    public Date getDataModifica() {
        return dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.data_modifica
     *
     * @param dataModifica the value for covidres_t_richiesta_test.data_modifica
     *
     * @mbg.generated
     */
    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.data_cancellazione
     *
     * @return the value of covidres_t_richiesta_test.data_cancellazione
     *
     * @mbg.generated
     */
    public Date getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.data_cancellazione
     *
     * @param dataCancellazione the value for covidres_t_richiesta_test.data_cancellazione
     *
     * @mbg.generated
     */
    public void setDataCancellazione(Date dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column covidres_t_richiesta_test.utente_operazione
     *
     * @return the value of covidres_t_richiesta_test.utente_operazione
     *
     * @mbg.generated
     */
    public String getUtenteOperazione() {
        return utenteOperazione;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column covidres_t_richiesta_test.utente_operazione
     *
     * @param utenteOperazione the value for covidres_t_richiesta_test.utente_operazione
     *
     * @mbg.generated
     */
    public void setUtenteOperazione(String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }
}