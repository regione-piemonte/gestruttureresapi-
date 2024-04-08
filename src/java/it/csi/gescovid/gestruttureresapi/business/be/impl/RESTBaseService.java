/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.AbstractDto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.Audit;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.AuditMapper;
import it.csi.gescovid.gestruttureresapi.exception.ErroreBuilder;
import it.csi.gescovid.gestruttureresapi.exception.RESTException;
import it.csi.gescovid.gestruttureresapi.util.LogUtil;
import it.csi.gescovid.gestruttureresapi.util.SpringSupportedResource;
import it.csi.gescovid.gestruttureresapi.util.csv.CleanStringSerializer;
import it.csi.gescovid.gestruttureresapi.util.csv.LocalizedPropertyNamingStrategy;

public class RESTBaseService extends SpringSupportedResource {

	@Autowired
	//CovidusLogAuditMapper repositoryLogAudit;
	AuditMapper repositoryAudit;
    
    @Autowired
    private MessageSource messageSource;
    
	protected LogUtil log = new LogUtil(this.getClass());

	//	protected void checkUtenteAutorizzato(String shibIdentitaCodiceFiscale, String xApplicazioneCodice) {
	//		if(xApplicazioneCodice.equalsIgnoreCase("APPLICAZIONE_ESTERNA")) return; // nessun controllo
	//		
	//		List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);
	//		boolean isPresenteProfilo = UtilitiStream.verificaProfili(elencoProfiliDB, xApplicazioneCodice);
	//		checkCondition(isPresenteProfilo,
	//				ErroreBuilder.from(Status.UNAUTHORIZED).descrizione("Utente non autorizzato").exception());
	//	}


    protected void logAudit(HttpHeaders headers, String action, String table, String description) {
        String shibIdentitaCf = getHeaderParam(headers, "Shib-Identita-CodiceFiscale", false);
        log.info("logAudit", "[HeaderParam - Shib-Identita-CodiceFiscale] value: " + shibIdentitaCf);
        //String xApplicationcodice = getHeaderParam(headers, "X-Applicazione-Codice", true);
        //String xRequestId = getHeaderParam(headers, "X-Request-Id", true);
        String ipAddress =  getHeaderParam(headers, "X-Forwarded-For", false);
        log.info("logAudit", "[HeaderParam - X-Forwarded-For] value: " + ipAddress);
        //ipAddress = StringUtils.contains(ipAddress, ",")?  ipAddress.substring(0, ipAddress.indexOf(",")): ipAddress;
        String userAgent = getHeaderParam(headers, "User-Agent", false);
        log.info("logAudit", "[HeaderParam - User-Agent] value: " + userAgent);

        Audit logAudit = new Audit();

        logAudit.setAction(action);
        logAudit.setUser(shibIdentitaCf);
        logAudit.setIp(ipAddress);
        logAudit.setTable(table);
        logAudit.setDescription(description);

        repositoryAudit.insert(logAudit);
    }
    
    protected void logAuditWhitoutShibIdentitaCf(HttpHeaders headers,String shibIdentitaCf, String action, String table, String description) {
        log.info("logAudit", "[HeaderParam - Shib-Identita-CodiceFiscale] value: " + shibIdentitaCf);
        //String xApplicationcodice = getHeaderParam(headers, "X-Applicazione-Codice", true);
        //String xRequestId = getHeaderParam(headers, "X-Request-Id", true);
        String ipAddress =  getHeaderParam(headers, "X-Forwarded-For", false);
        log.info("logAudit", "[HeaderParam - X-Forwarded-For] value: " + ipAddress);
        //ipAddress = StringUtils.contains(ipAddress, ",")?  ipAddress.substring(0, ipAddress.indexOf(",")): ipAddress;
        String userAgent = getHeaderParam(headers, "User-Agent", false);
        log.info("logAudit", "[HeaderParam - User-Agent] value: " + userAgent);

        Audit logAudit = new Audit();

        logAudit.setAction(action);
        logAudit.setUser(shibIdentitaCf);
        logAudit.setIp(ipAddress);
        logAudit.setTable(table);
        logAudit.setDescription(description);

        repositoryAudit.insert(logAudit);
    }

	protected String getHeaderParam(HttpHeaders httpHeaders, String headerParam, boolean obbligatorio) throws RESTException {
		List<String> values = httpHeaders.getRequestHeader(headerParam);
		String ret = "";
		if(obbligatorio) {
			if (values == null) {
				throw ErroreBuilder.from(Status.BAD_REQUEST).descrizione("Parametro mancante: " + headerParam).exception();
			} else if (values.size() == 0 ) {
				throw ErroreBuilder.from(Status.BAD_REQUEST).descrizione("Parametro mancante: " + headerParam).exception();
			}else {
				ret = values.get(0);
			}
		}
		else if(values != null && values.size() != 0) {
			ret = values.get(0);
		}

		return ret;
	}



	public String convertiStrutture(List<String> elencoIdStruttura) {
		String res = "";

		if (elencoIdStruttura.size() == 0) {
			return null;
		}

		Iterator<String> iterator = elencoIdStruttura.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();

			if (res.isEmpty()) {
				res = "'" + next.trim() + "'";
			} else {
				res += ",'" + next.trim() + "'";
			}
		}

		return res;
	}

	/**
	 * Controlla che il parametro obj sia valorizzato; diversamente solleva una
	 * {@link RESTException} con Status.BAD_REQUEST e con il messaggio passato come
	 * parametro.
	 * 
	 * @param obj
	 * @param message
	 */
	protected void checkNotNull(Object obj, String message) {
		checkNotNull(obj, buildError(message, Status.BAD_REQUEST));
	}

	/**
	 * Controlla che il parametro obj sia valorizzato; diversamente solleva
	 * l'eccezione passata come parametro.
	 * 
	 * @param obj
	 * @param re
	 */
	protected void checkNotNull(Object obj, RESTException re) {
		checkCondition(obj != null, re);
	}

	/**
	 * Controlla che il parametro str sia valorizzato; diversamente solleva una
	 * {@link RESTException} con Status.BAD_REQUEST e con il messaggio passato come
	 * parametro.
	 * 
	 * @param obj
	 * @param re
	 */
	protected void checkNotBlank(String str, String message) {
        checkNotBlank(str, buildError(message, Status.BAD_REQUEST));
	}

    /**
     * @param message
     * @param status
     * @return
     */
	protected RESTException buildError(String message, Status status) {
        return ErroreBuilder.from(status).descrizione(message).exception();
    }

	/**
	 * Controlla che il parametro str sia valorizzato; diversamente solleva
	 * l'eccezione passata come parametro.
	 * 
	 * @param obj
	 * @param re
	 */
	protected void checkNotBlank(String str, RESTException re) {
		checkCondition(StringUtils.isNotBlank(str), re);
	}

	/**
	 * Controlla che la condizione isOk sia uguale a <code>true</code>; diversamente
	 * solleva l'eccezione passata come parametro.
	 * 
	 * @param isOk
	 * @param re
	 */
	protected void checkCondition(boolean isOk, RESTException re) {
		if (!isOk) {
			throw re;
		}
	}

	/**
	 * Controlla che la condizione isOk sia uguale a <code>true</code>; diversamente
	 * solleva una {@link RESTException} con Status.BAD_REQUEST e con il messaggio
	 * passato come parametro.
	 * 
	 * @param isOk
	 * @param re
	 */
	protected void checkCondition(boolean isOk, String message) {
		checkCondition(isOk, buildError(message, Status.BAD_REQUEST));
	}
	
	protected static boolean toBoolean(String s) {
		return "true".equalsIgnoreCase(s) || "s".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s);
	}
	

    /**
     * @param methodName
     * @param e
     * @return
     */
    protected Response generalExceptionReturn(String methodName, Exception e) {
        if (e instanceof RESTException) {
            log.error(methodName,"RESTException in chiamata", e);
            return ((RESTException) e).getResponse();
        }
        if (e instanceof WebApplicationException)
            return ((WebApplicationException) e).getResponse();
        log.error(methodName,"Errore in chiamata", e);
        return ErroreBuilder.from(Status.INTERNAL_SERVER_ERROR)
                .descrizione("Errore imprevisto: contattare l'assistenza tecnica")
                .exception().getResponse();
    }
    

    public String convertObjectsToCsv(List<? extends AbstractDto> obj) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Locale locale = LocaleContextHolder.getLocale();
            if(obj!=null && !obj.isEmpty()) {
                CsvMapper mapper = new CsvMapper();
                mapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
                mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                mapper.setDateFormat(df);
                mapper.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
                mapper.setPropertyNamingStrategy(new LocalizedPropertyNamingStrategy(messageSource, locale));
                mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
                CsvSchema schema = mapper.schemaFor(obj.get(0).getClass());
                SimpleModule module = new SimpleModule();
                module.addSerializer(String.class, new CleanStringSerializer());
                mapper.registerModule(module);              
                schema = schema.withColumnSeparator(';');
                schema = schema.withUseHeader(true);
                schema = schema.withQuoteChar('"');
                return mapper.writer(schema).writeValueAsString(obj);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "CSV conversion error";
        }
    }
}
