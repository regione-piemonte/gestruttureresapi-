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

import it.csi.gescovid.gestruttureresapi.business.be.StrutturaInfoApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.ProfiloEnum;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Struttura;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.StrutturaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaCovidExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaDecessiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaPersonaleExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaPostiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaTamponiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaVisitatoriExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.StrutturaCategoriaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.StrutturaInfoExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.EnteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.ProfiloMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaCovidMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaDecessiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaPersonaleMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaPostiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaTamponiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaVisitatoriMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.StrutturaCategoriaMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.StrutturaInfoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseStrutturaMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.business.service.RsaCategorieServiceImpl;
import it.csi.gescovid.gestruttureresapi.dto.RsaCovidJson;
import it.csi.gescovid.gestruttureresapi.dto.RsaDecessiJson;
import it.csi.gescovid.gestruttureresapi.dto.RsaPersonaleJson;
import it.csi.gescovid.gestruttureresapi.dto.RsaPostiJson;
import it.csi.gescovid.gestruttureresapi.dto.RsaTamponeJson;
import it.csi.gescovid.gestruttureresapi.dto.RsaVisitatoriJson;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.DateUtils;
import it.csi.gescovid.gestruttureresapi.util.csv.CleanStringSerializer;
import it.csi.gescovid.gestruttureresapi.util.csv.LocalizedPropertyNamingStrategy;

public class StrutturaInfoApiServiceImpl extends GestioneUtenteServiceImpl implements StrutturaInfoApi{

	@Autowired
	private BaseStrutturaMapper baseStrutMapper;

	@Autowired
	private StrutturaInfoMapper strutInfoMapper;

	@Autowired
	private RsaPostiMapper postiMapper;

	@Autowired
	private RsaPersonaleMapper personaleMapper;

	@Autowired
	private RsaDecessiMapper decessiMapper;

	@Autowired
	private RsaTamponiMapper rsaTamponiMapper;

	@Autowired
	private RsaCovidMapper rsaCovidMapper;

	@Autowired
	private RsaVisitatoriMapper rsaVisitatoriMapper;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ProfiloMapper profiloMapper;
	
	@Autowired
	private EnteMapper enteMapper;

	@Autowired
	private StrutturaCategoriaMapper strutturaCategoriaMapper;
	
	@Autowired
	private RsaCategorieServiceImpl rsaCategorieServiceImpl;
	
	@Override
	public Response getStruttureInfoByFilter(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String natura, String idStruttura, String nomeSti,
			Integer idEnte, Integer idTipoUtenza, Integer strCategoriaId, String orderby, Long rowPerPage,
			Long pageNumber, String descendingStr, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "getStruttureInfoByFilter: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_INFO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			if(natura!=null && natura.trim().isEmpty()) natura = null;
			if(idStruttura!=null && idStruttura.trim().isEmpty()) idStruttura = null;
			if(nomeSti!=null && nomeSti.trim().isEmpty()) nomeSti = null;

			List<StrutturaInfoExt> list = null;
			List<String> nomiProfiliList = profiloMapper.selectElencoNomeProfiloByCodiceFiscale(shibIdentitaCodiceFiscale);
			Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, toBoolean(descendingStr));
			if(nomiProfiliList!=null && !nomiProfiliList.isEmpty()) {
				if(nomiProfiliList.contains(ProfiloEnum.RSA.getCodice())) {
					list = strutInfoMapper.selectStrutturaInfoByFilter(shibIdentitaCodiceFiscale, natura, idStruttura, nomeSti, idEnte, idTipoUtenza, strCategoriaId, paginazione );
				}else if(nomiProfiliList.contains(ProfiloEnum.RSA_RP.getCodice())) {
					list = strutInfoMapper.selectStrutturaInfoByFilter(null, natura, idStruttura, nomeSti, idEnte, idTipoUtenza, strCategoriaId, paginazione);
				}else if(nomiProfiliList.contains(ProfiloEnum.RSA_ASL.getCodice())) {
					List<Ente> enti=enteMapper.selectByCfUtente(shibIdentitaCodiceFiscale);
					if(enti!=null && !enti.isEmpty()) {
						idEnte =enti.get(0).getIdEnte();
						list = strutInfoMapper.selectStrutturaInfoByFilter(null, natura, idStruttura, nomeSti, idEnte, idTipoUtenza, strCategoriaId, paginazione);
					}
				}
			}
			logAudit(httpHeaders, "select", "covidrsa_t_struttura_info", methodName);

			Integer rowsNumber =0;
			if(list!=null && !list.isEmpty()) {
				rowsNumber = list.get(0).getFullCount();
			}

			return Response.ok(list).header("rows-number", rowsNumber).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

	}

	@Override
	public Response getDettaglioStruttureInfo(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String idStruttura, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getDettaglioStruttureInfo: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_INFO),
                    httpHeaders);
            
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			Date dataRilevazione = DateUtils.getNextMonday();
			
			StrutturaInfoExt sti = strutInfoMapper.selectDettaglioStrutturaInfo(idStruttura);
			logAudit(httpHeaders, "select", "covidrsa_t_struttura_info", methodName);

			if(sti.getIdStruttura()!=null && !sti.getIdStruttura().isEmpty()) {
				
				List<StrutturaCategoriaInfo> categorie = strutturaCategoriaMapper.selectCategorieByIdStruttura(sti.getIdStruttura(),dataRilevazione);
				for(StrutturaCategoriaInfo categoria:categorie) {
					if(Boolean.TRUE.equals(categoria.getEsisteUltimaRilevazione())) {
					    rsaCategorieServiceImpl.checkCategoriaIsCompleted(sti.getIdStruttura(),categoria.getStrCategoriaId(),shibIdentitaCodiceFiscale,dataRilevazione);
					}
				}
				sti.setCategorie(categorie);
				
				List<RsaPostiExt> posti = postiMapper.selectValidByIdStruttura(sti.getIdStruttura());
				sti.setPosti(posti);

				List<RsaPersonaleExt> personale =  personaleMapper.selectValidByIdStruttura(sti.getIdStruttura());
				sti.setPersonale(personale);

				List<RsaTamponiExt> tamponi= rsaTamponiMapper.selectValidByIdStrutturaAndTipoTamponeCod(sti.getIdStruttura());
				sti.setTamponi(tamponi);

				List<RsaCovidExt> ospiti= rsaCovidMapper.selectValidByIdStruttura(sti.getIdStruttura());
				sti.setOspiti(ospiti);

				List<RsaDecessiExt> decessi = decessiMapper.selectValidByIdStruttura(sti.getIdStruttura());
				sti.setDecessi(decessi);

				List<RsaVisitatoriExt> visitatori = rsaVisitatoriMapper.selectValidByIdStruttura(sti.getIdStruttura());
				sti.setVisitatori(visitatori);
			}

			return Response.ok(sti).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response aggiornaStrutturaInfo(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, StrutturaInfo input,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "aggiornaStrutturaInfo: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.RSA_STRUTTURA_INFO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			Struttura st= baseStrutMapper.selectByPrimaryKey(input.getIdStruttura());
			baseStrutMapper.updateByPrimaryKey(st);
			st.setNome(input.getStiNome());
			ObjectMapper mapper = new ObjectMapper();
			logAudit(httpHeaders, "update", "struttura", mapper.writeValueAsString(st));

			if(input.getStiId()!=null) {
				StrutturaInfo sti = strutInfoMapper.selectByPrimaryKey(input.getStiId());
				sti.setUtenteOperazione(shibIdentitaCodiceFiscale);
				sti.setDataModifica(new Date());
				sti.setStiTelefono(input.getStiTelefono());
				sti.setStiEmail(input.getStiEmail());
				sti.setStiEmail2(input.getStiEmail2());
				sti.setStiPec(input.getStiPec());
				sti.setStiMensaInternaPresente(input.getStiMensaInternaPresente());    
				sti.setStiAsmedMmg(input.getStiAsmedMmg());    
				sti.setAssmedId(input.getAssmedId());    
				sti.setStiAsmedMista(input.getStiAsmedMista());    
				sti.setStiPersInfNotturno(input.getStiPersInfNotturno()); 
				sti.setStiDirStrPresente(input.getStiDirStrPresente()); 
				sti.setStiDirStrNome(input.getStiDirStrNome()); 
				sti.setStiDirStrEmail(input.getStiDirStrEmail()); 
				sti.setStiDirStrTelReperibilita(input.getStiDirStrTelReperibilita()); 
				sti.setStiDirSanitPresente(input.getStiDirSanitPresente()); 
				sti.setStiDirSanitNome(input.getStiDirSanitNome()); 
				sti.setStiDirSanitEmail(input.getStiDirSanitEmail()); 
				sti.setStiDirSanitTelReperibilita(input.getStiDirSanitTelReperibilita()); 
				sti.setStiCoordInfPresente(input.getStiCoordInfPresente()); 
				sti.setStiCoordInfNome(input.getStiCoordInfNome()); 
				sti.setStiCoordInfEmail(input.getStiCoordInfEmail()); 
                sti.setStiCoordInfTelReperibilita(input.getStiCoordInfTelReperibilita()); 
                sti.setStiAdesioneDgr10(input.getStiAdesioneDgr10());
                sti.setStiAbilitatoSollievo(input.getStiAbilitatoSollievo());
                sti.setStiAbilitatoDimProt(input.getStiAbilitatoDimProt());
                sti.setStiAbilitatoCavs(input.getStiAbilitatoCavs());
                sti.setStiAbilitatoLungodeg(input.getStiAbilitatoLungodeg());
                sti.setStiAbilitatoHospice(input.getStiAbilitatoHospice());
				strutInfoMapper.updateByPrimaryKey(sti);
				logAudit(httpHeaders, "update", "covidrsa_t_struttura_info", mapper.writeValueAsString(sti));	
			}

			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	public Response getStruttureInfoByFilterCsv(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String natura, String idStruttura, String nomeSti,
			Integer idEnte, Integer idTipoUtenza, Integer strCategoriaId, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getStruttureInfoByFilterCsv: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_INFO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			if(natura!=null && natura.trim().isEmpty()) natura = null;
			if(idStruttura!=null && idStruttura.trim().isEmpty()) idStruttura = null;
			if(nomeSti!=null && nomeSti.trim().isEmpty()) nomeSti = null;

			List<StrutturaInfoExt> list = null;
			List<String> nomiProfiliList = profiloMapper.selectElencoNomeProfiloByCodiceFiscale(shibIdentitaCodiceFiscale);
			if(nomiProfiliList!=null && !nomiProfiliList.isEmpty()) {
				if(nomiProfiliList.contains(ProfiloEnum.RSA.getCodice())) {
					list = strutInfoMapper.selectStrutturaInfoByFilter(shibIdentitaCodiceFiscale, natura, idStruttura, nomeSti, idEnte, idTipoUtenza, strCategoriaId, null );
				}else if(nomiProfiliList.contains(ProfiloEnum.RSA_RP.getCodice())) {
					list = strutInfoMapper.selectStrutturaInfoByFilter(null, natura, idStruttura, nomeSti, idEnte, idTipoUtenza, strCategoriaId, null );
				}
			}

			logAudit(httpHeaders, "select", "covidrsa_t_struttura_info", methodName);

			String csv = convertObjectsStrutturaInfoToCsv(list);
			String  fileName = "Strutture.csv";

			return Response.ok(csv).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

	}

	private String convertObjectsStrutturaInfoToCsv(List<StrutturaInfoExt> list) {
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
				CsvSchema schema = mapper.schemaFor(StrutturaInfoExt.class);
				SimpleModule module = new SimpleModule();
				module.addSerializer(String.class, new CleanStringSerializer());
				mapper.registerModule(module);				
				schema = schema.withColumnSeparator(';');
				schema = schema.withUseHeader(true);
				schema = schema.withQuoteChar('"');
				String csv = mapper.writer(schema).writeValueAsString(list);
				return csv;
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "CSV conversion error";
		}
	}
	
	@Override
	public Response getRilevazioniCsv(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
			String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
			Integer idAreaOperazione, String tipo, String dataRilevazioneDa, String dataRilevazioneA,
			String idStruttura, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "getRilevazioniCsv: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.RSA_STRUTTURA_INFO),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			List<String> nomiProfiliList = profiloMapper.selectElencoNomeProfiloByCodiceFiscale(shibIdentitaCodiceFiscale);
			String cfUtente= shibIdentitaCodiceFiscale;
			
			if(nomiProfiliList!=null && !nomiProfiliList.isEmpty() && nomiProfiliList.contains(ProfiloEnum.RSA_RP.getCodice())) {
					cfUtente= null;
			}
			
			Date dataRilevDa= null;
			Date dataRilevA= null;
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(dataRilevazioneDa!=null && !dataRilevazioneDa.isEmpty()) {
				 dataRilevDa = format.parse(dataRilevazioneDa);
			}
			if(dataRilevazioneA!=null && !dataRilevazioneA.isEmpty()) {
				dataRilevA = format.parse(dataRilevazioneA); 
				dataRilevA = new Date( dataRilevA.getTime() + 86400000);
			}
			
			if(idStruttura!=null && (idStruttura.isEmpty() || idStruttura.equals("") )) {
				idStruttura= null;
			}
			
			String csv =null;
			if(tipo.equalsIgnoreCase("POSTI")) {
				logAudit(httpHeaders, "select", "covidrsa_t_posti", methodName);
				List<RsaPostiJson> posti= postiMapper.selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(cfUtente, 
						dataRilevDa, dataRilevA, idStruttura);
				csv = convertRsaPostiJsonToCsv(posti);
			}
			if(tipo.equalsIgnoreCase("PERSONALE")) {
				logAudit(httpHeaders, "select", "covidrsa_t_personale", methodName);
				List<RsaPersonaleJson> personale= personaleMapper.selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(cfUtente, dataRilevDa, dataRilevA, idStruttura);
				csv = convertRsaPersonaleJsonToCsv(personale);
			}
			if(tipo.equalsIgnoreCase("TAMPONI")) {
				logAudit(httpHeaders, "select", "covidrsa_t_tamponi", methodName);
				List<RsaTamponeJson> tamponiM= rsaTamponiMapper.selectValidByCfUtenteaAndTipoTamponeCodAndDataRilevazioneAndIdStruttura(cfUtente, dataRilevDa, dataRilevA, idStruttura);
				csv = convertRsaTamponeJsonToCsv(tamponiM);
			}
			if(tipo.equalsIgnoreCase("OSPITI")) {
				logAudit(httpHeaders, "select", "covidrsa_t_covid", methodName);
				List<RsaCovidJson> ospiti = rsaCovidMapper.selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(cfUtente, dataRilevDa, dataRilevA, idStruttura);
				csv = convertRsaCovidJsonToCsv(ospiti);
			}
			if(tipo.equalsIgnoreCase("DECESSI")) {
				logAudit(httpHeaders, "select", "covidrsa_t_decessi", methodName);
				List<RsaDecessiJson> decessi = decessiMapper.selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(cfUtente, dataRilevDa, dataRilevA, idStruttura);
				csv = convertRsaDecessiJsonToCsv(decessi);
			}
			if(tipo.equalsIgnoreCase("VISITATORI")) {
				logAudit(httpHeaders, "select", "covidrsa_t_visitatori", methodName);
				List<RsaVisitatoriJson> visitatori = rsaVisitatoriMapper.selectValidByCfUtenteAndDataRilevazioneDaAndDataRilevazioneAAndIdStruttura(cfUtente, dataRilevDa, dataRilevA, idStruttura);
				csv = convertRsaVisitatoriJsonToCsv(visitatori);
			}
			
			String tipoPascalCase = !tipo.isEmpty()?tipo.substring(0, 1).toUpperCase()+tipo.substring(1).toLowerCase():"";
			String  fileName = "Rilevazioni"+tipoPascalCase+".csv";

			return Response.ok(csv).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}
	
	private String convertRsaPostiJsonToCsv(List<RsaPostiJson> list) {
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
				CsvSchema schema = mapper.schemaFor(RsaPostiJson.class);
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
	
	private String convertRsaPersonaleJsonToCsv(List<RsaPersonaleJson> list) {
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
				CsvSchema schema = mapper.schemaFor(RsaPersonaleJson.class);
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
	
	private String convertRsaTamponeJsonToCsv(List<RsaTamponeJson> list) {
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
				CsvSchema schema = mapper.schemaFor(RsaTamponeJson.class);
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
	
	private String convertRsaCovidJsonToCsv(List<RsaCovidJson> list) {
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
				CsvSchema schema = mapper.schemaFor(RsaCovidJson.class);
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

	private String convertRsaDecessiJsonToCsv(List<RsaDecessiJson> list) {
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
				CsvSchema schema = mapper.schemaFor(RsaDecessiJson.class);
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

	private String convertRsaVisitatoriJsonToCsv(List<RsaVisitatoriJson> list) {
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
				CsvSchema schema = mapper.schemaFor(RsaVisitatoriJson.class);
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
