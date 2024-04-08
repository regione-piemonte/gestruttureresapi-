/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import it.csi.gescovid.gestruttureresapi.business.be.RsaStrutturaNoteApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaStrutturaNote;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaStrutturaNoteExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaStrutturaNoteMapper;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.csv.CleanStringSerializer;
import it.csi.gescovid.gestruttureresapi.util.csv.LocalizedPropertyNamingStrategy;

public class RsaStrutturaNoteApiServiceImpl extends GestioneUtenteServiceImpl implements RsaStrutturaNoteApi {
	
	@Autowired
	private RsaStrutturaNoteMapper rsaStrutturaNoteMapper;
	
	@Autowired
    private MessageSource messageSource;

	@Override
	public Response getRsaStrutturaNote(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
			Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
			String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "getRsaStrutturaNote: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_NOTE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			List<RsaStrutturaNoteExt> list = rsaStrutturaNoteMapper.selectValidByCfUtente(shibIdentitaCodiceFiscale);
			logAudit(httpHeaders, "select", "covidrsa_t_struttura_note", methodName);

			return Response.ok(list).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}
	
	@Override
	public Response getDettaglioRsaStrutturaNote(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String webappOperazione, Integer idProfiloOperazione,
			String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
			Integer idAreaOperazione, String userAgent, Integer stnId, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getDettaglioRsaStrutturaNote: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_NOTE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			RsaStrutturaNote stn = rsaStrutturaNoteMapper.selectByPrimaryKey(stnId);
			logAudit(httpHeaders, "select", "covidrsa_t_struttura_note", methodName);

			return Response.ok(stn).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response inserisciRsaStrutturaNote(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String webappOperazione, Integer idProfiloOperazione,
			String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
			Integer idAreaOperazione, RsaStrutturaNote input, String userAgent, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "inserisciRsaStrutturaNote: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_NOTE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			Date now = new Date();
			
			input.setUtenteOperazione(shibIdentitaCodiceFiscale);
			input.setDataCreazione(now);
			input.setDataModifica(now);
			input.setValiditaInizio(now);
			
			rsaStrutturaNoteMapper.insert(input);
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "insert", "covidrsa_t_struttura_note", mapper.writeValueAsString(input));

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response aggiornaRsaStrutturaNote(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String webappOperazione, Integer idProfiloOperazione,
			String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
			Integer idAreaOperazione, RsaStrutturaNote input, String userAgent, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "aggiornaRsaStrutturaNote: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_NOTE),
                    httpHeaders);


			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			if(input.getStnId()!=null) {
				RsaStrutturaNote stn = rsaStrutturaNoteMapper.selectByPrimaryKey(input.getStnId());
				Date now = new Date();			
				stn.setUtenteOperazione(shibIdentitaCodiceFiscale);
				stn.setDataModifica(now);
				stn.setIdStruttura(input.getIdStruttura());
				stn.setStnNote(input.getStnNote());
				stn.setStrCategoriaId(input.getStrCategoriaId());
				stn.setDataRilevazione(input.getDataRilevazione());
				
				rsaStrutturaNoteMapper.updateByPrimaryKey(stn);
				ObjectMapper mapper = new ObjectMapper();
				logAudit(httpHeaders, "update", "covidrsa_t_struttura_note", mapper.writeValueAsString(stn));
				
			}
			
			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response cancellaRsaStrutturaNote(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String webappOperazione, Integer idProfiloOperazione,
			String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
			Integer idAreaOperazione, RsaStrutturaNote input, String userAgent, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "cancellaRsaStrutturaNote: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_NOTE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			if(input.getStnId()!=null) {
				RsaStrutturaNote stn = rsaStrutturaNoteMapper.selectByPrimaryKey(input.getStnId());
				Date now = new Date();			
				stn.setUtenteOperazione(shibIdentitaCodiceFiscale);
				stn.setDataModifica(now);
				stn.setDataCancellazione(now);
				
				rsaStrutturaNoteMapper.updateByPrimaryKey(stn);
				ObjectMapper mapper = new ObjectMapper();
				logAudit(httpHeaders, "update", "covidrsa_t_struttura_note", mapper.writeValueAsString(stn));
				
			}
			
			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}


	@Override
	public Response getRsaStrutturaNoteCsv(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String webappOperazione, Integer idProfiloOperazione,
			String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
			Integer idAreaOperazione, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "getRsaStrutturaNoteCsv: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_NOTE),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			List<RsaStrutturaNoteExt> list = rsaStrutturaNoteMapper.selectValidByCfUtente(shibIdentitaCodiceFiscale);
			logAudit(httpHeaders, "select", "covidrsa_t_struttura_note", methodName);

			String csv = convertObjectsRsaStrutturaNoteToCsv(list);
			String  fileName = "Note.csv";
			
			return Response.ok(csv).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}
	
	private String convertObjectsRsaStrutturaNoteToCsv(List<RsaStrutturaNoteExt> list) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Locale locale = LocaleContextHolder.getLocale();
			if(list!=null && list.size()>0) {
				CsvMapper mapper = new CsvMapper();
				mapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
				mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
				mapper.setDateFormat(df);
				mapper.setPropertyNamingStrategy(new LocalizedPropertyNamingStrategy(messageSource, locale));
				mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
				CsvSchema schema = mapper.schemaFor(RsaStrutturaNoteExt.class);
				SimpleModule module = new SimpleModule();
				module.addSerializer(String.class, new CleanStringSerializer());
				mapper.registerModule(module);				
				schema = schema.withColumnSeparator(';');
				schema = schema.withUseHeader(true);
				schema = schema.withQuoteChar('"');
				return mapper.writer(schema).writeValueAsString(list);
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "CSV conversion error";
		}
	}
}
