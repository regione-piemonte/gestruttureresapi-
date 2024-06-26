/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Soggetto extends AbstractDto {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.id_soggetto
	 * @mbg.generated
	 */
	private Long idSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.codice_fiscale
	 * @mbg.generated
	 */
	private String codiceFiscale;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.id_asr
	 * @mbg.generated
	 */
	private Long idAsr;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.cognome
	 * @mbg.generated
	 */
	private String cognome;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.nome
	 * @mbg.generated
	 */
	private String nome;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.data_nascita_str
	 * @mbg.generated
	 */
	private String dataNascitaStr;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.comune_residenza_istat
	 * @mbg.generated
	 */
	private String comuneResidenzaIstat;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.comune_domicilio_istat
	 * @mbg.generated
	 */
	private String comuneDomicilioIstat;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.indirizzo_domicilio
	 * @mbg.generated
	 */
	private String indirizzoDomicilio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.telefono_recapito
	 * @mbg.generated
	 */
	private String telefonoRecapito;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.data_nascita
	 * @mbg.generated
	 */
	private Date dataNascita;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.asl_residenza
	 * @mbg.generated
	 */
	private String aslResidenza;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.asl_domicilio
	 * @mbg.generated
	 */
	private String aslDomicilio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.email
	 * @mbg.generated
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.id_tipo_soggetto
	 * @mbg.generated
	 */
	private Integer idTipoSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.caso_importato
	 * @mbg.generated
	 */
	private String casoImportato;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.stato_contagio
	 * @mbg.generated
	 */
	private String statoContagio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.regione_contagio
	 * @mbg.generated
	 */
	private String regioneContagio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.lat
	 * @mbg.generated
	 */
	private BigDecimal lat;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.lng
	 * @mbg.generated
	 */
	private BigDecimal lng;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.documento_numero
	 * @mbg.generated
	 */
	private String documentoNumero;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column soggetto.documento_tipo_id
	 * @mbg.generated
	 */
	private Integer documentoTipoId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.id_soggetto
	 * @return  the value of soggetto.id_soggetto
	 * @mbg.generated
	 */
	public Long getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.id_soggetto
	 * @param idSoggetto  the value for soggetto.id_soggetto
	 * @mbg.generated
	 */
	public void setIdSoggetto(Long idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.codice_fiscale
	 * @return  the value of soggetto.codice_fiscale
	 * @mbg.generated
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.codice_fiscale
	 * @param codiceFiscale  the value for soggetto.codice_fiscale
	 * @mbg.generated
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.id_asr
	 * @return  the value of soggetto.id_asr
	 * @mbg.generated
	 */
	public Long getIdAsr() {
		return idAsr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.id_asr
	 * @param idAsr  the value for soggetto.id_asr
	 * @mbg.generated
	 */
	public void setIdAsr(Long idAsr) {
		this.idAsr = idAsr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.cognome
	 * @return  the value of soggetto.cognome
	 * @mbg.generated
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.cognome
	 * @param cognome  the value for soggetto.cognome
	 * @mbg.generated
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.nome
	 * @return  the value of soggetto.nome
	 * @mbg.generated
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.nome
	 * @param nome  the value for soggetto.nome
	 * @mbg.generated
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.data_nascita_str
	 * @return  the value of soggetto.data_nascita_str
	 * @mbg.generated
	 */
	public String getDataNascitaStr() {
		return dataNascitaStr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.data_nascita_str
	 * @param dataNascitaStr  the value for soggetto.data_nascita_str
	 * @mbg.generated
	 */
	public void setDataNascitaStr(String dataNascitaStr) {
		this.dataNascitaStr = dataNascitaStr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.comune_residenza_istat
	 * @return  the value of soggetto.comune_residenza_istat
	 * @mbg.generated
	 */
	public String getComuneResidenzaIstat() {
		return comuneResidenzaIstat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.comune_residenza_istat
	 * @param comuneResidenzaIstat  the value for soggetto.comune_residenza_istat
	 * @mbg.generated
	 */
	public void setComuneResidenzaIstat(String comuneResidenzaIstat) {
		this.comuneResidenzaIstat = comuneResidenzaIstat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.comune_domicilio_istat
	 * @return  the value of soggetto.comune_domicilio_istat
	 * @mbg.generated
	 */
	public String getComuneDomicilioIstat() {
		return comuneDomicilioIstat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.comune_domicilio_istat
	 * @param comuneDomicilioIstat  the value for soggetto.comune_domicilio_istat
	 * @mbg.generated
	 */
	public void setComuneDomicilioIstat(String comuneDomicilioIstat) {
		this.comuneDomicilioIstat = comuneDomicilioIstat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.indirizzo_domicilio
	 * @return  the value of soggetto.indirizzo_domicilio
	 * @mbg.generated
	 */
	public String getIndirizzoDomicilio() {
		return indirizzoDomicilio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.indirizzo_domicilio
	 * @param indirizzoDomicilio  the value for soggetto.indirizzo_domicilio
	 * @mbg.generated
	 */
	public void setIndirizzoDomicilio(String indirizzoDomicilio) {
		this.indirizzoDomicilio = indirizzoDomicilio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.telefono_recapito
	 * @return  the value of soggetto.telefono_recapito
	 * @mbg.generated
	 */
	public String getTelefonoRecapito() {
		return telefonoRecapito;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.telefono_recapito
	 * @param telefonoRecapito  the value for soggetto.telefono_recapito
	 * @mbg.generated
	 */
	public void setTelefonoRecapito(String telefonoRecapito) {
		this.telefonoRecapito = telefonoRecapito;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.data_nascita
	 * @return  the value of soggetto.data_nascita
	 * @mbg.generated
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.data_nascita
	 * @param dataNascita  the value for soggetto.data_nascita
	 * @mbg.generated
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.asl_residenza
	 * @return  the value of soggetto.asl_residenza
	 * @mbg.generated
	 */
	public String getAslResidenza() {
		return aslResidenza;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.asl_residenza
	 * @param aslResidenza  the value for soggetto.asl_residenza
	 * @mbg.generated
	 */
	public void setAslResidenza(String aslResidenza) {
		this.aslResidenza = aslResidenza;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.asl_domicilio
	 * @return  the value of soggetto.asl_domicilio
	 * @mbg.generated
	 */
	public String getAslDomicilio() {
		return aslDomicilio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.asl_domicilio
	 * @param aslDomicilio  the value for soggetto.asl_domicilio
	 * @mbg.generated
	 */
	public void setAslDomicilio(String aslDomicilio) {
		this.aslDomicilio = aslDomicilio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.email
	 * @return  the value of soggetto.email
	 * @mbg.generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.email
	 * @param email  the value for soggetto.email
	 * @mbg.generated
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.id_tipo_soggetto
	 * @return  the value of soggetto.id_tipo_soggetto
	 * @mbg.generated
	 */
	public Integer getIdTipoSoggetto() {
		return idTipoSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.id_tipo_soggetto
	 * @param idTipoSoggetto  the value for soggetto.id_tipo_soggetto
	 * @mbg.generated
	 */
	public void setIdTipoSoggetto(Integer idTipoSoggetto) {
		this.idTipoSoggetto = idTipoSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.caso_importato
	 * @return  the value of soggetto.caso_importato
	 * @mbg.generated
	 */
	public String getCasoImportato() {
		return casoImportato;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.caso_importato
	 * @param casoImportato  the value for soggetto.caso_importato
	 * @mbg.generated
	 */
	public void setCasoImportato(String casoImportato) {
		this.casoImportato = casoImportato;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.stato_contagio
	 * @return  the value of soggetto.stato_contagio
	 * @mbg.generated
	 */
	public String getStatoContagio() {
		return statoContagio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.stato_contagio
	 * @param statoContagio  the value for soggetto.stato_contagio
	 * @mbg.generated
	 */
	public void setStatoContagio(String statoContagio) {
		this.statoContagio = statoContagio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.regione_contagio
	 * @return  the value of soggetto.regione_contagio
	 * @mbg.generated
	 */
	public String getRegioneContagio() {
		return regioneContagio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.regione_contagio
	 * @param regioneContagio  the value for soggetto.regione_contagio
	 * @mbg.generated
	 */
	public void setRegioneContagio(String regioneContagio) {
		this.regioneContagio = regioneContagio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.lat
	 * @return  the value of soggetto.lat
	 * @mbg.generated
	 */
	public BigDecimal getLat() {
		return lat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.lat
	 * @param lat  the value for soggetto.lat
	 * @mbg.generated
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.lng
	 * @return  the value of soggetto.lng
	 * @mbg.generated
	 */
	public BigDecimal getLng() {
		return lng;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.lng
	 * @param lng  the value for soggetto.lng
	 * @mbg.generated
	 */
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.documento_numero
	 * @return  the value of soggetto.documento_numero
	 * @mbg.generated
	 */
	public String getDocumentoNumero() {
		return documentoNumero;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.documento_numero
	 * @param documentoNumero  the value for soggetto.documento_numero
	 * @mbg.generated
	 */
	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column soggetto.documento_tipo_id
	 * @return  the value of soggetto.documento_tipo_id
	 * @mbg.generated
	 */
	public Integer getDocumentoTipoId() {
		return documentoTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column soggetto.documento_tipo_id
	 * @param documentoTipoId  the value for soggetto.documento_tipo_id
	 * @mbg.generated
	 */
	public void setDocumentoTipoId(Integer documentoTipoId) {
		this.documentoTipoId = documentoTipoId;
	}
}