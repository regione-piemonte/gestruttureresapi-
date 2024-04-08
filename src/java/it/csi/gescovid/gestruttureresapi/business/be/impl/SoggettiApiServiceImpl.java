/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.StreamingOutput;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.SoggettiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.IstitutoScolastico;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.SoggettoAura;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.SoggettoStrutturaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.Audit;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.SoggettoExtDto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.SoggettoExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidhrCParametroMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDTipoMovOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTMovimentoOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.DecorsoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.IstitutiScolasticiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.MedicoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.MedicoSoggettoAuraMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.MedicoSoggettoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SoggettoApiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SoggettoAuraMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SoggettoContattoTipoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SoggettoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.TamponeMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.TestMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseComuniMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseMedicoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.BaseTipoSoggettoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.SoggettoStrutturaInfoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.TipoEventoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.business.mapping.ModelIstitutoScolasticoMapping;
import it.csi.gescovid.gestruttureresapi.business.mapping.ModelSoggettoMedicoMedicoMapping;
import it.csi.gescovid.gestruttureresapi.business.service.SoggettoServiceImpl;
import it.csi.gescovid.gestruttureresapi.dto.ModelErrore;
import it.csi.gescovid.gestruttureresapi.dto.ModelIstitutoScolastico;
import it.csi.gescovid.gestruttureresapi.dto.ModelSoggetto;
import it.csi.gescovid.gestruttureresapi.dto.ModelSoggettoAsr;
import it.csi.gescovid.gestruttureresapi.dto.ModelSoggettoComuneDomicilio;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.HeaderEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.GenericUtils;


public class SoggettiApiServiceImpl extends GestioneUtenteServiceImpl implements SoggettiApi {

	@Autowired
	CovidhrCParametroMapper parametroMapper;
	
	@Autowired
	SoggettoMapper soggettoMapper;

	@Autowired 
	TamponeMapper tamponeMapper;

	@Autowired 
	DecorsoMapper decorsoMapper;

	@Autowired
	SoggettoAuraMapper soggettoAuraMapper;

	@Autowired
	SoggettoContattoTipoMapper soggettoContattoTipoMapper;

	@Autowired
	MedicoMapper medicoMapper;

	@Autowired
	MedicoSoggettoMapper medSogMapper;

	@Autowired
	BaseMedicoMapper baseMedMapper;

	@Autowired
	IstitutiScolasticiMapper istitutiScolasticiMapper;

	@Autowired
	SoggettoApiMapper soggettoApiMapper;

	@Autowired
	BaseTipoSoggettoMapper baseTipoSoggettoMapper;

	@Autowired
	BaseComuniMapper baseComuneMapper;

	@Autowired
	SoggettoStrutturaInfoMapper ssiMapper;

	@Autowired
	TestMapper testMapper;

	@Autowired
	TipoEventoMapper tipoEventoMapper;
	
	@Autowired
	MedicoSoggettoAuraMapper medicoSoggettoAuraMapper;
	
    @Autowired
    private CovidrsaTMovimentoOspiteMapper covidrsaTMovimentoOspiteMapper;

    @Autowired
    private CovidrsaDTipoMovOspiteMapper covidrsaDTipoMovOspiteMapper;

    @Autowired
    SoggettoServiceImpl soggettoServiceImpl;
    
    @Override
    public Response getSoggettiByStruttRes(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, String idStrutturaRes,
            String filter, String orderby, Long rowPerPage, Long pageNumber, Boolean descending,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getSoggettiByStruttRes: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.SOGGETTI),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(idStrutturaRes, "idStruttura obbligatorio");

            Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, descending);
			logAudit(httpHeaders, "select", "soggetto", methodName);

			List<ModelSoggetto> mSoggettiList = ricavaListaSoggettiRes(idStrutturaRes, filter, paginazione);
			logAudit(httpHeaders, "select", "soggetto", methodName);

			return Response.ok(mSoggettiList)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), GenericUtils.getTotalCountFromList(mSoggettiList)).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

	}
    
    @Override
    public Response getSoggettiByStruttResRendicontazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, String filter, String idStruttura, String orderby,
            Long rowPerPage, Long pageNumber, Boolean descending, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getSoggettiByStruttResRendicontazione: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.SOGGETTI),
                    httpHeaders);

            checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
            checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
            checkCondition(idStrutturaOperazione.equals(idStruttura), "idStruttura non coincidente con idStrutturaOperazione");

            Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, descending);
            List<SoggettoExt> soggetti = soggettoApiMapper.selectElencoByStrutturaInfoRendicontazione(filter, idStruttura, paginazione);
            logAudit(httpHeaders, "select", "soggetto", methodName);

            return Response.ok(soggetti)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), GenericUtils.getTotalCountFromList(soggetti)).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

    }



    private List<ModelSoggetto> ricavaListaSoggettiRes(String idStrutturaRes, String filter,
            Paginazione paginazione) {
        // String statoEmergenza =
        // parametroMapper.selectParamValueByParamKeyString("stato.emergenziale.active");
        String statoEmergenza = null;
        List<ModelSoggetto> soggetti = soggettoApiMapper.selectElencoByStrutturaInfo(idStrutturaRes,
                statoEmergenza,
                filter, paginazione);
        return soggetti;
    }


	private ModelSoggetto getDettaglioSoggetto(Integer soggettoId, SoggettoExtDto soggetto) {
		Date now = new Date();
		List<IstitutoScolastico> elencoIstitutoScolastico = istitutiScolasticiMapper.selectIstitutiValidiBySoggettoId(soggettoId.longValue(),now);

		List<SoggettoAura> elencoSoggettoAura = soggettoAuraMapper.selectByIdSoggetto(soggettoId.longValue());

		Integer idAura = elencoSoggettoAura!=null && !elencoSoggettoAura.isEmpty()?elencoSoggettoAura.get(0).getIdAura().intValue() : 0  ;

		Medico medico = null;
		/**
		 *  Dovrebbe esserci al piu un solo soggettoAura ma il db ne permette piu di uno, scelgo il primo
		 */
		if (idAura != 0)
		{
			List<Medico> elencoMedico = medicoMapper.selectByIdAuraSogg(idAura.longValue());
			if (elencoMedico!=null && !elencoMedico.isEmpty())
			{	
				medico = elencoMedico.get(0);

			}
		}

		ModelSoggetto modelsoggetto = convertiSoggettoModelSoggetto(soggetto, idAura);
		modelsoggetto.setMedico(new ModelSoggettoMedicoMedicoMapping().from(medico));


		//map elenco istituti scolastici
		List<ModelIstitutoScolastico> modelIstitutoScolastico = new ModelIstitutoScolasticoMapping().fromList(elencoIstitutoScolastico);
		modelsoggetto.setElencoIstitutoScolastico(modelIstitutoScolastico);


		return modelsoggetto;
	}

	private ModelSoggetto convertiSoggettoModelSoggetto(SoggettoExtDto soggetto, Integer idAura) {

		ModelSoggetto msoggetto = new ModelSoggetto();
		msoggetto.setIdAura(idAura);
		msoggetto.setIdSoggetto(soggetto.getIdSoggetto().intValue());
		if(soggetto.getIdAsr()!=null) {
			msoggetto.setIdAsr( Integer.valueOf(soggetto.getIdAsr().intValue()));
		}
		msoggetto.setIdTipoSoggetto(soggetto.getIdTipoSoggetto());
		msoggetto.setCodiceFiscale(soggetto.getCodiceFiscale()!=null ? soggetto.getCodiceFiscale() : "");
		msoggetto.setCognome(soggetto.getCognome()!=null? soggetto.getCognome():"" );
		msoggetto.setNome(soggetto.getNome()!=null? soggetto.getNome():"" );
		msoggetto.setComuneResidenzaIstat(soggetto.getComuneResidenzaIstat() !=null? soggetto.getComuneResidenzaIstat():"");
		msoggetto.setComuneDomicilioIstat(soggetto.getComuneDomicilioIstat() !=null? soggetto.getComuneDomicilioIstat():"");
		msoggetto.setIndirizzodomicilio(soggetto.getIndirizzoDomicilio()!=null? soggetto.getIndirizzoDomicilio():"");
		msoggetto.setTelefonoRecapito(soggetto.getTelefonoRecapito()!=null? soggetto.getTelefonoRecapito():"");
		msoggetto.setDataNascita(soggetto.getDataNascita()!=null? soggetto.getDataNascita(): null);
		msoggetto.setAslDomicilio(soggetto.getAslDomicilio()!=null ? soggetto.getAslDomicilio() :"");
		msoggetto.setAslResidenza(soggetto.getAslResidenza()!=null ? soggetto.getAslResidenza() :"");
		msoggetto.setEmail(soggetto.getEmail()!=null ? soggetto.getEmail() :"");
		msoggetto.setNumeroCampioni(soggetto.getNumeroCampioni());
		msoggetto.setNumeroDecorsi(soggetto.getNumeroDecorsi());
		msoggetto.setUltimoIdTipoEvento(soggetto.getUltimoIdTipoEvento());

		msoggetto.setDocumentoNumero(soggetto.getDocumentoNumero());
		msoggetto.setDocumentoTipoId(soggetto.getDocumentoTipoId());
		convertiAsrModelUtenteAsr(soggetto, msoggetto);
		convertiDomicilioResidenza(soggetto, msoggetto);

		return msoggetto;
	}

	private void convertiDomicilioResidenza(SoggettoExtDto soggetto, ModelSoggetto msoggetto) {
		//ModelUtenteSindacoComune mcomuneDomicilio = new ModelUtenteSindacoComune();
		ModelSoggettoComuneDomicilio mcomuneDomicilio = new ModelSoggettoComuneDomicilio();

		if(soggetto.getComuneDomicilio()!=null) {
			mcomuneDomicilio.setIstatComune(soggetto.getComuneDomicilio().getIstatComune()!=null ? soggetto.getComuneDomicilio().getIstatComune() : "");
			mcomuneDomicilio.setNomeComune(soggetto.getComuneDomicilio().getNomeComune() != null ? soggetto.getComuneDomicilio().getNomeComune() : "");
		}
		msoggetto.setComuneDomicilio(mcomuneDomicilio);

		//ModelUtenteSindacoComune mcomunResidenza = new ModelUtenteSindacoComune();
		ModelSoggettoComuneDomicilio mcomunResidenza = new ModelSoggettoComuneDomicilio();
		if(soggetto.getComuneResidenza()!=null) {
			mcomunResidenza.setIstatComune(soggetto.getComuneResidenza()!=null ? soggetto.getComuneResidenza().getIstatComune() : "");
			mcomunResidenza.setNomeComune(soggetto.getComuneResidenza().getNomeComune() != null ? soggetto.getComuneResidenza().getNomeComune() : "");
		}
		msoggetto.setComuneResidenza(mcomunResidenza);
	}

	private void convertiAsrModelUtenteAsr(SoggettoExtDto soggetto, ModelSoggetto msoggetto) {
		//ModelUtenteAsr mutenteasr = new ModelUtenteAsr();

		ModelSoggettoAsr mutenteasr= new ModelSoggettoAsr();
		if(soggetto.getAsr()!=null) {
			mutenteasr.setIdAsr(soggetto.getAsr().getIdAsr()!=null ? soggetto.getAsr().getIdAsr().intValue(): 0);
			mutenteasr.setDescrizione(soggetto.getAsr().getDescrizione()!=null ? soggetto.getAsr().getDescrizione() : "");
			mutenteasr.setIdEnte(soggetto.getAsr().getIdEnte()!=null ? soggetto.getAsr().getIdEnte(): 0);
		}
		msoggetto.setAsr(mutenteasr);
	}

	@Override
	public Response soggettiSoggettoCfGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String codiceFiscale,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "soggettiSoggettoCfGet: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.SOGGETTI),
                    httpHeaders);


			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkNotNull(codiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select for cfsoggetto", "soggetto", methodName);

			SoggettoExtDto soggetto = soggettoMapper.selectSoggettoBySoggetto(codiceFiscale, null, null, null);

			if (soggetto==null) return Response.ok(null).build();


			ModelSoggetto modelsoggetto = getDettaglioSoggetto(soggetto.getIdSoggetto().intValue(), soggetto);

			//			verificaSoggettoOspiteinStruttura(soggetto, modelsoggetto);

			return Response.ok(modelsoggetto).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}






	//	private void verificaSoggettoOspiteinStruttura(SoggettoExtDto soggetto, ModelSoggetto modelsoggetto) {
	//		modelsoggetto.setOspiteInStrutturaRes(false);
	//		StrutturaInfo strutturaRes = struttInfoApiMapper.selectStrutturaByIdSoggetto(soggetto.getIdSoggetto());
	//		
	//		if(strutturaRes!=null) {
	//			modelsoggetto.setOspiteInStrutturaRes(true);
	//			modelsoggetto.setNomeStrutturaRes(strutturaRes.getStiNome());
	//			modelsoggetto.setIndirizzoStrutturaRes(strutturaRes.getStiIndirizzo());
	//			Comuni comune = baseComuneMapper.selectByPrimaryKey(strutturaRes.getStiComuneIstat());
	//			 if(comune!=null) {
	//				 modelsoggetto.setNomeComuneStrutturaRes(comune.getNomeComune());
	//			 }
	//		}
	//	}

	@Override
	public Response listaSoggettiByNomeCognomeGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String nome, String cognome, String dataNascita,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "listaSoggettiByNomeCognomeGet: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.SOGGETTI),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(nome, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(cognome, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(dataNascita, CaConstants.IDENTITA_OBBLIGATORIA);


			logAudit(httpHeaders, "select for nome e cognome", "soggetto", methodName);

			List<SoggettoExtDto >soggetti = soggettoMapper.selectListSoggettoBySoggetto(null, nome, cognome, dataNascita);

			if (soggetti!=null && !soggetti.isEmpty()) {

				List<ModelSoggetto> list = new ArrayList<ModelSoggetto>();

				for(SoggettoExtDto soggetto :soggetti) {
					ModelSoggetto modelsoggetto = getDettaglioSoggetto(soggetto.getIdSoggetto().intValue(), soggetto);				
					list.add(modelsoggetto);
				}

				//			verificaSoggettoOspiteinStruttura(soggetto, modelsoggetto);

				return Response.ok(list).build();
			}else {
				return Response.ok(null).build();
			}

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}

	@Override
	public Response associaSoggettoAStruttura(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String idStrutturaRes, Long idSoggetto,
			boolean flgOspite, CovidrsaTMovimentoOspite payload, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "associaSoggettoAStruttura: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.SOGGETTO_STRUTTURA),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(idStrutturaRes, CaConstants.ID_STRUT_RES_OBBLIGATORIO);
			checkNotNull(idSoggetto, CaConstants.ID_SOGGETTO_OBBLIGATORIO);

			
			int ret = ssiMapper.invalidSsSoggettoByIdSoggettoIdStrutturaFlgOspite(idSoggetto, idStrutturaRes, flgOspite, shibIdentitaCodiceFiscale);
			log.info(methodName, "Sono state invalidate " + ret + " struttura per il soggetto " + idSoggetto);
			
			ModelErrore errore = new ModelErrore();
			
				try {
				    soggettoServiceImpl.associaSoggettoAStrutturaRes(shibIdentitaCodiceFiscale, httpHeaders, methodName, new Date(), idSoggetto, idStrutturaRes, flgOspite);
				} catch (Exception e) {
					log.error(methodName, " ERROR associaSoggettoAStrutturaRes idSoggetto: "+idSoggetto+" idStrutturaRes: "+idStrutturaRes);
					logAudit(httpHeaders, "rollback", "covidres_r_soggetto_struttura_info", "errore inserimento id_struttura: " + idStrutturaRes + " id_soggetto: " + idSoggetto);	
					errore.setMessaggio("immpossibile associare soggetto alla struttura");
					throw e;
				}
			

			return Response.ok(errore).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

	}


	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response aggiornaTiposoggetto(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, Long idSoggetto, Integer idTipoSoggetto,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "aggiornaTiposoggetto: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.SOGGETTI),
                    httpHeaders);
            
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(idTipoSoggetto, CaConstants.ID_TIPO_SOGGETTO_OBBLIGATORIO);
			checkNotNull(idSoggetto, CaConstants.ID_SOGGETTO_OBBLIGATORIO);

			ObjectMapper mapper = new ObjectMapper();

			Soggetto soggetto = soggettoApiMapper.selectByPrimaryKey(idSoggetto);
			if(soggetto!=null) {
				soggetto.setIdTipoSoggetto(idTipoSoggetto);
				soggettoApiMapper.updateByPrimaryKey(soggetto);
				logAudit(httpHeaders, "update", "soggetto", mapper.writeValueAsString(soggetto));	
			}


			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public Response eliminaAssociazioneRes(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, Long idSoggetto, String idStrutturaRes,
			Boolean flgOspite, CovidrsaTMovimentoOspite payload, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
        final String methodName = "eliminaAssociazioneRes: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.SOGGETTO_STRUTTURA),
                    httpHeaders);

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			boolean flgOspiteBool = Boolean.TRUE.equals(flgOspite);
			if(!flgOspiteBool) {
				checkNotBlank(idStrutturaRes, CaConstants.ID_STRUT_RES_OBBLIGATORIO);
			}
			if(idStrutturaRes!=null && idStrutturaRes.isEmpty()) {
				idStrutturaRes = null;
			}
			checkNotNull(idSoggetto, CaConstants.ID_SOGGETTO_OBBLIGATORIO);

			List<SoggettoStrutturaInfo> ssiList= ssiMapper.selectValidByIdSoggettoAndIdStruttura(idSoggetto, idStrutturaRes, flgOspiteBool);

			ObjectMapper mapper = new ObjectMapper();

			if(ssiList!=null) {
				for(SoggettoStrutturaInfo ssi:ssiList) {
					ssi.setValiditaFine(new Date());
					ssi.setUtenteOperazione(shibIdentitaCodiceFiscale);
					ssiMapper.updateByPrimaryKey(ssi);
					logAudit(httpHeaders, "update", "covidres_r_soggetto_struttura_info", mapper.writeValueAsString(ssi));	
//		            if(Boolean.TRUE.equals(ssi.getFlgOspite())) {
//		                if(webappOperazione.equalsIgnoreCase("VISURA_MMG")) {
//		                    payload = new CovidrsaTMovimentoOspite();
//		                    payload.setDataMovimento(new Date());
//		                    payload.setFlgPreservaPosto(Boolean.TRUE);
//		                    CovidrsaDTipoMovOspite tipoMovimento = covidrsaDTipoMovOspiteMapper
//		                            .selectByMovOspiteCod("O_PRIV");
//		                    checkNotNull(tipoMovimento, "tipo movimento ospite O_PRIV non esistente");
//		                    payload.setTipoMovOspiteId(tipoMovimento.getTipoMovOspiteId());
////		                    eliminia associativa aggiungere motivo e data cosi viene cancellato da quella data
////		                    SE FLAG OSPITE A TRUE:
////		                    SE webappOperazione VISURA_MMG ALLORA data now e note vuote flag preserva posto a true,
////		                    tipo movimento obbligatorio
////		                    motivo costante. --> tipo mov ospite cod uguale a O_PRIV cosi tiri fuori il tipo movimento da inserire in tabella.
////		                    controlli:
////		                    data obbligatoria.
////		                    devo verificare il il tipo_movimento sia covidrsa_d_tipo_mov_ospite con flag ingresso a false.
////		                    validit� inizio a now le altre date non si accettano.
//		                    
//		                } else {
//		                    checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
//		                    checkNotNull(payload.getDataMovimento(), "data movimento obbligatoria");
//		                    checkNotNull(payload.getTipoMovOspiteId(), "tipo movimento ospite id obbligatorio");
//		                    CovidrsaDTipoMovOspite tipoMovimento = covidrsaDTipoMovOspiteMapper
//		                            .selectByPrimaryKey(payload.getTipoMovOspiteId());
//                            checkNotNull(tipoMovimento, "tipo movimento ospite non esistente");
//                            checkCondition(Boolean.TRUE.equals(tipoMovimento.getFlgUscita()), "tipo movimento ospite non di uscita");
//                            checkNotNull(payload.getFlgPreservaPosto(), "flag preserva posto obbligatorio");
//		                }
//
//                        payload.setIdSoggetto(idSoggetto.intValue());
//                        payload.setIdStruttura(idStrutturaRes);
//                        payload.setUtenteOperazione(shibIdentitaCodiceFiscale);
//                        payload.setMovimentoOspiteId(null);
//
//                        covidrsaTMovimentoOspiteMapper.insert(payload);
//                        logAudit(httpHeaders, "insert", "covidrsa_t_movimento_ospite", methodName);
//		                
//		            }
				}
			}
			


			return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

	}
	
    @Override
    public Response eliminaAssociazioneRes(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, Long idSoggetto, String idStrutturaRes,
            Boolean flgOspite, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "eliminaAssociazioneRes: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.SOGGETTO_STRUTTURA),
                    httpHeaders);

            checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
            checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
            checkNotNull(webappOperazione, "webappOperazione obbligatoria");
            checkCondition(webappOperazione.equalsIgnoreCase("VISURA_MMG"), "webappOperazione non VISURA_MMG");
            boolean flgOspiteBool = Boolean.TRUE.equals(flgOspite);
            if(!flgOspiteBool) {
                checkNotBlank(idStrutturaRes, CaConstants.ID_STRUT_RES_OBBLIGATORIO);
            }
            if(idStrutturaRes!=null && idStrutturaRes.isEmpty()) {
                idStrutturaRes = null;
            }
            checkNotNull(idSoggetto, CaConstants.ID_SOGGETTO_OBBLIGATORIO);

            List<SoggettoStrutturaInfo> ssiList= ssiMapper.selectValidByIdSoggettoAndIdStruttura(idSoggetto, idStrutturaRes, flgOspiteBool);

            ObjectMapper mapper = new ObjectMapper();

            if(ssiList!=null) {
                for(SoggettoStrutturaInfo ssi:ssiList) {
                    ssi.setValiditaFine(new Date());
                    ssi.setUtenteOperazione(shibIdentitaCodiceFiscale);
                    ssiMapper.updateByPrimaryKey(ssi);
                    logAudit(httpHeaders, "update", "covidres_r_soggetto_struttura_info", mapper.writeValueAsString(ssi));  
                    if(Boolean.TRUE.equals(ssi.getFlgOspite())) {
                        CovidrsaTMovimentoOspite payload = new CovidrsaTMovimentoOspite();
                        payload  = new CovidrsaTMovimentoOspite();
                        payload.setDataMovimento(new Date());
                        payload.setFlgPreservaPosto(Boolean.TRUE);
                        CovidrsaDTipoMovOspite tipoMovimento = covidrsaDTipoMovOspiteMapper
                                .selectByMovOspiteCod("O_PRIV");
                        checkNotNull(tipoMovimento, "tipo movimento ospite O_PRIV non esistente");
                        payload.setTipoMovOspiteId(tipoMovimento.getTipoMovOspiteId());


                        payload.setIdSoggetto(idSoggetto.intValue());
                        payload.setIdStruttura(idStrutturaRes);
                        payload.setUtenteOperazione(shibIdentitaCodiceFiscale);
                        payload.setMovimentoOspiteId(null);

                        covidrsaTMovimentoOspiteMapper.insert(payload);
                        logAudit(httpHeaders, "insert", "covidrsa_t_movimento_ospite", methodName);
                        
                    }
                }
            }
            


            return Response.ok().build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;

    }


	
	@Override
	public Response getSoggettiByRespXlsx(SecurityContext securityContext, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, String idStrutturaRes, String cf,
			HttpHeaders httpHeaders, HttpServletRequest req) {
        final String methodName = "getSoggettiByRespXlsx: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.SOGGETTI),
                    httpHeaders);

			checkNotNull(cf, CaConstants.IDENTITA_OBBLIGATORIA);
			//			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(idStrutturaRes, CaConstants.ID_STRUT_RES_OBBLIGATORIO);

			Audit logAudit = new Audit();
			logAudit.setAction("getSoggettiByRespXlsx("+idStrutturaRes+")");
			logAudit.setUser(cf);
			logAudit.setIp(req.getRemoteAddr());
			logAudit.setTable("soggetto");
			logAudit.setDescription(methodName);
			repositoryAudit.insert(logAudit);

			List<ModelSoggetto> mSoggettiList = ricavaListaSoggettiRes(idStrutturaRes,null,null);
			StreamingOutput os = convertObjectsToXlsx(mSoggettiList);
			String fileName = "soggetti-strutt-res.xlsx";
			return Response.ok(os).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}


	private StreamingOutput convertObjectsToXlsx(List<ModelSoggetto> list) {
		final XSSFWorkbook workbook = createWorkbook();

		if (list != null) {
			Sheet sheet = workbook.getSheet("Soggetti");

			XSSFFont headerFont = workbook.createFont();
			headerFont.setFontName("Arial");
			headerFont.setFontHeightInPoints((short) 8);
			headerFont.setBold(true);

			CellStyle cellDateStyle = workbook.createCellStyle();
			cellDateStyle.setBorderBottom(BorderStyle.THIN);
			cellDateStyle.setBorderTop(BorderStyle.THIN);
			cellDateStyle.setBorderRight(BorderStyle.THIN);
			cellDateStyle.setBorderLeft(BorderStyle.THIN);
			cellDateStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellDateStyle.setFillForegroundColor(IndexedColors.WHITE.index);
			cellDateStyle.setFont(headerFont);
			cellDateStyle.setWrapText(true);

			cellDateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("dd/mm/yyyy"));

			int indexRow = 1;
			for (ModelSoggetto sogg : list) {
				int indexColumn = 0;

				Row row = sheet.createRow(indexRow);
				Cell cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellValue(sogg.getCodiceFiscale());
				indexColumn++;

                cell = row.createCell(indexColumn);
                cell.setCellStyle(cellDateStyle);
                cell.setCellValue(sogg.getDocumentoNumero());
                indexColumn++;

                cell = row.createCell(indexColumn);
                cell.setCellStyle(cellDateStyle);
                cell.setCellValue(sogg.getDocumentoTipoDesc());
                indexColumn++;

				cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellValue(sogg.getCognome());
				indexColumn++;
				
				cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellValue(sogg.getNome());
				indexColumn++;

                cell = row.createCell(indexColumn);
                cell.setCellStyle(cellDateStyle);
                cell.setCellValue(sogg.getDataNascita());
                indexColumn++;

				cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellValue(sogg.getIndirizzodomicilio() +", "+sogg.getComuneDomicilioDesc());
				indexColumn++;

				cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellValue(sogg.getAslDomicilio());
				indexColumn++;

				cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				if(sogg.getMedico()!=null) {
					cell.setCellValue(sogg.getMedico().getNome()+" "+sogg.getMedico().getCognome());
				}
				indexColumn++;

				cell = row.createCell(indexColumn);
				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellValue(sogg.getDescTipoSogg());
				indexColumn++;

				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellDateStyle);
				if(sogg.getUltimoTestPositivo()!=null) {
					if(sogg.getUltimoTestPositivo()) {
						cell.setCellValue("SI");
					}else {
						cell.setCellValue("NO");
					}
				}else {
					cell.setCellValue("");
				}
				indexColumn++;


				indexRow++;
			}
		}

		StreamingOutput streamOutput = new StreamingOutput() {

			@Override
			public void write(OutputStream out) throws IOException, WebApplicationException {
				workbook.write(out);
			}

		};

		return streamOutput;
	}


	private static XSSFWorkbook createWorkbook() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Soggetti");
		Row header = sheet.createRow(0);

		XSSFFont headerFont = workbook.createFont();
		headerFont.setFontName("Arial");
		headerFont.setFontHeightInPoints((short) 8);
		headerFont.setBold(true);

		XSSFFont rowFont = workbook.createFont();
		rowFont.setFontName("Arial");
		rowFont.setFontHeightInPoints((short) 8);
		rowFont.setBold(false);
		int i = 0;
		for (String hName : headers) {
			CellStyle headerStyle = workbook.createCellStyle();
			Cell headerCell = header.createCell(i);
			headerCell.setCellValue(hName);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(headersColors[i].index);
			headerStyle.setFont(headerFont);
			headerStyle.setWrapText(true);
			headerCell.setCellStyle(headerStyle);
			sheet.setColumnWidth(i, headersWidth[i]);
			i++;
		}

		return workbook;
	}

	private static String[] headers = {"Codice Fiscale", "Documnento numero", "Documento tipo",
	        "Cognome", "Nome", "Data di nascita",
			"Domicilio", "Asl domicilio", "Medico MMG", 
			"Tipo", "Ultimo test positivo" };

	private static IndexedColors[] headersColors = { 
			IndexedColors.WHITE, IndexedColors.WHITE, IndexedColors.WHITE,
			IndexedColors.WHITE, IndexedColors.WHITE, IndexedColors.WHITE,
			IndexedColors.WHITE, IndexedColors.WHITE, IndexedColors.WHITE, IndexedColors.WHITE, IndexedColors.WHITE};

	private static Integer[] headersWidth = { 
			6000, 6000, 6000, 6000, 6000, 
			6000, 6000, 6000, 6000, 6000, 6000};

}
