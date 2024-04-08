/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import it.csi.gescovid.gestruttureresapi.business.be.RendicontazioneApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWorkflowRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRRendicontazioneFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.CovidrsaTRendicontazioneCsv;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelRendicontazioniBoDocumentiSpesa;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelRendicontazioniBoDocumentiSpesaDettaglio;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelRendicontazioniBoResponse;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.UpdateStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRRendicontazioneFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneBackOffice;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneList;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDStatoRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDTipoMovOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWorkflowRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRRendicontazioneFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTMovimentoOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SoggettoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.business.service.CovidrsaRendicontazioneServiceImpl;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.GeneralLogEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.HeaderEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.RendicontazioneUtenteEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Message;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelUtenteContatto;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.GenericUtils;
import it.csi.gescovid.gestruttureresapi.util.PDFGenerator;

public class RendicontazioneApiServiceImpl extends GestioneUtenteServiceImpl implements RendicontazioneApi {

    @Autowired
    private CovidrsaTRendicontazioneMapper covidrsaTRendicontazioneMapper;

    @Autowired
    private CovidrsaRendicontazioneServiceImpl covidrsaRendicontazioneServiceImpl;

    @Autowired
    private CovidrsaRRendicontazioneFileMapper covidrsaRRendicontazioneFileMapper;

    @Autowired
    private CovidrsaRStrutturaWelfareMapper covidrsaRStrutturaWelfareMapper;

    @Autowired
    private SoggettoMapper soggettoMapper;
    
    @Autowired
    protected CovidrsaDStatoRendicontazioneMapper covidrsaDStatoRendicontazioneMapper;

    @Override
    public Response getRendicontazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, String dataRendicontazioneDa, String dataRendicontazioneA, String filter,
            String idStruttura, Integer statoRendId, String orderby, Long rowPerPage, Long pageNumber,
            Boolean descending, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            checkCondition(idStrutturaOperazione.equals(idStruttura),
                    "idStruttura non coincidente con idStrutturaOperazione");
            Date dataRendicontazioneDaDate = null;
            if (dataRendicontazioneDa != null && !dataRendicontazioneDa.isEmpty()) {
                dataRendicontazioneDaDate = new SimpleDateFormat("yyyy-MM-dd").parse(dataRendicontazioneDa);
            }
            Date dataRendicontazioneADate = null;
            if (dataRendicontazioneA != null && !dataRendicontazioneA.isEmpty()) {
                dataRendicontazioneADate = new SimpleDateFormat("yyyy-MM-dd").parse(dataRendicontazioneA);
            }
            Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, descending);
            List<CovidrsaTRendicontazioneList> res = covidrsaTRendicontazioneMapper
                    .selectListFrom(dataRendicontazioneDaDate, dataRendicontazioneADate, filter, idStruttura,
                            paginazione, statoRendId);

            for (CovidrsaTRendicontazioneList r : res) {
                r.setFiles(covidrsaRRendicontazioneFileMapper.selectByRendicontazioneId(r.getRendicontazioneId()));
            }
            logAudit(httpHeaders, "select", "covidrsa_t_rendicontazione", methodName);

            return Response.ok(res)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), GenericUtils.getTotalCountFromList(res)).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getRendicontazioneCsv(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, String dataRendicontazioneDa,
            String dataRendicontazioneA, String filter, String idStruttura, Integer statoRendId,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getRendicontazioneCsv: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            checkCondition(idStrutturaOperazione.equals(idStruttura),
                    "idStruttura non coincidente con idStrutturaOperazione");
            Date dataRendicontazioneDaDate = null;
            if (dataRendicontazioneDa != null && !dataRendicontazioneDa.isEmpty()) {
                dataRendicontazioneDaDate = new SimpleDateFormat("yyyy-MM-dd").parse(dataRendicontazioneDa);
            }
            Date dataRendicontazioneADate = null;
            if (dataRendicontazioneA != null && !dataRendicontazioneA.isEmpty()) {
                dataRendicontazioneADate = new SimpleDateFormat("yyyy-MM-dd").parse(dataRendicontazioneA);
            }
            List<CovidrsaTRendicontazioneCsv> res = covidrsaTRendicontazioneMapper
                    .selectListForCsvFrom(dataRendicontazioneDaDate, dataRendicontazioneADate, filter, idStruttura,
                            statoRendId);

            logAudit(httpHeaders, "select", "covidrsa_t_rendicontazione", methodName);

            String csv = convertObjectsToCsv(res);
            String fileName = "rendicontazioni.csv";
            return Response.ok(csv)
                    .header(HeaderEnum.CONTENT_DISPOSITION.getCode(), "attachment; filename=\"" + fileName + "\"")
                    .build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postRendicontazioneFile(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidrsaRRendicontazioneFileExt payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postRendicontazioneFile: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            covidrsaRendicontazioneServiceImpl
                    .insertRendicontazioneFiles(shibIdentitaCodiceFiscale, idStrutturaOperazione, payload);
            logAudit(httpHeaders, "insert", "covidrsa_r_rendicontazione_file", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postRendicontazioneStato(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, UpdateStatoRendicontazione payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postRendicontazioneStato: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            ModelUtenteContatto utenteContatto = verifyCurrentUserGetUtenteContatto(webappOperazione,
                    idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getOldStato(), "stato precedente obbligatorio");
            checkNotNull(payload.getNewStato(), "nuovo stato obbligatorio");
            checkNotNull(payload.getRendicontazioniId(), "lista id rendicontazioni obbligatoria");
            checkCondition(!payload.getRendicontazioniId().isEmpty(),
                    "lista id rendicontazioni obbligatoria");

            covidrsaRendicontazioneServiceImpl.postRendicontazioneStato(payload, shibIdentitaCodiceFiscale,
                    httpHeaders, utenteContatto, null,RendicontazioneUtenteEnum.STRUTTURA);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postRendicontazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, CovidrsaTRendicontazioneExt payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getIdSoggetto(), CaConstants.ID_SOGGETTO_OBBLIGATORIO);
            checkNotNull(payload.getDataRendicontazione(), "dataRendicontazione obbligatoria");
            checkNotNull(payload.getImportoRetta(), "importoRetta obbligatoria");
//            checkNotNull(payload.getBuonoresId(), "BuonoresId obbligatorio");
            checkNotNull(payload.getStatoRendId(), "statoRendId obbligatorio");
            checkNotNull(payload.getFlgPrimoIngresso(), "flgPrimoIngresso obbligatorio");
            checkNotNull(payload.getRendicontazioneId(), "identificativo rendicontazione obbligatoria");
            payload.setValiditaInizio(null);
            payload.setIdStruttura(idStrutturaOperazione);
            payload.setUtenteOperazione(utenteOperazione);
//            checkNotNull(payload.getStrContoId(), "strContoId obbligatoria");
//            String idStrutturaConto = covidrsaRStrutturaContoMapper.selectIdStrutturaByPrimaryKey(payload.getStrContoId());
//            checkCondition(idStrutturaOperazione.equals(idStrutturaConto),
//                    "idStruttura associata a conto non coincide con idStrutturaOperazione");
            covidrsaRendicontazioneServiceImpl.modificaRendicontazione(payload, utenteOperazione, httpHeaders, methodName);

            return Response.ok(payload.getRendicontazioneId()).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }
    
    @Override
    public Response deleteRendicontazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidrsaTRendicontazione payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "deleteMovimentoOspite: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getRendicontazioneId(), "Rendicontazione Obbligatoria");
            CovidrsaTRendicontazione current = covidrsaTRendicontazioneMapper
                    .selectByPrimaryKey(payload.getRendicontazioneId());
            checkNotNull(current, "valore associato a rendicontazioneId non esistente");
            // data cancellazione a now
            // per tutti quelli che hannno lo stesso soggeto e struttura e
            // data_rendicontazione
            int res = covidrsaTRendicontazioneMapper.deleteBySoggettoStrutturaAndData(current);
            checkCondition(res != 0, "rendicontazioni da cancellare non trovata");
            logAudit(httpHeaders, "update", "covidrsa_t_rendicontazione", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response printDichiarazioneRendicontazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, Integer rendicontazioneId, SecurityContext securityContext,
            HttpHeaders httpHeaders,
            HttpServletRequest req) {
        final String methodName = "printDichiarazioneRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            CovidrsaRStrutturaWelfareExt result = covidrsaRStrutturaWelfareMapper
                    .selectByIdStruttura(idStrutturaOperazione);
            logAudit(httpHeaders, "select", "covidrsa_t_rendicontazione", methodName);
            checkNotNull(result, "la struttura corrente non ha dati associati");
            CovidrsaTRendicontazione rend = covidrsaTRendicontazioneMapper.selectByPrimaryKey(rendicontazioneId);
            checkNotNull(rend, "rendicontazione non esistente");
            Soggetto soggetto = soggettoMapper.selectByPrimaryKey(Long.valueOf(rend.getIdSoggetto()));
            String fileName = "dichiarazione_rendicontazione.pdf";
            ByteArrayInputStream is = generateRendicontazione(result, rend, soggetto);

            ResponseBuilder responseBuilder = Response.ok(is);
            responseBuilder.type("application/pdf");
            responseBuilder.header("Content-Disposition", "filename=\"" + fileName + "\"");
            return responseBuilder.build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    private ByteArrayInputStream generateRendicontazione(
            CovidrsaRStrutturaWelfareExt result, CovidrsaTRendicontazione rend, Soggetto soggetto)
            throws WebApplicationException {
        final String methodName = "generatePdfDichiarazioneSostitutiva: ";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(os));
                Document doc = new Document(pdfDoc, PageSize.A4)) {
            doc.setMargins(10, 10, 10, 10);
            PDFGenerator.printDichiarazioneRendicontazione(result, rend, soggetto, doc);
        } catch (IOException e) {
            log.error(methodName, "Errore durante la generazione del PDF per dichiarazione sostitutiva: ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Errore durante la generazione del PDF")).build());
        }
        return new ByteArrayInputStream(os.toByteArray());
    }

    @Override
    public Response getHtmlPresaVisione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
            Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
            Integer idRendicontazione, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest req) {
        final String methodName = "printDichiarazioneRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            ModelUtenteContatto utenteContatto = verifyCurrentUserGetUtenteContatto(webappOperazione,
                    idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            CovidrsaTRendicontazione rend = covidrsaTRendicontazioneMapper.selectByPrimaryKey(idRendicontazione);
            checkNotNull(rend, "rendicontazione non esistente");

            String html = covidrsaRendicontazioneServiceImpl.generaHtmlPresaVisione(utenteContatto, rend,
                    shibIdentitaCodiceFiscale);

            ResponseBuilder responseBuilder = Response.ok(html);
            responseBuilder.type("text/plain");
            return responseBuilder.build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getPdfPresaVisione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String webappOperazione, Integer idProfiloOperazione, String ruoloOperazione,
            Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione, Integer idAreaOperazione,
            Integer idRendicontazione, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest req) {
        final String methodName = "printDichiarazioneRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            ModelUtenteContatto utenteContatto = verifyCurrentUserGetUtenteContatto(webappOperazione,
                    idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            CovidrsaTRendicontazione rend = covidrsaTRendicontazioneMapper.selectByPrimaryKey(idRendicontazione);
            checkNotNull(rend, "rendicontazione non esistente");

            ByteArrayInputStream html = covidrsaRendicontazioneServiceImpl.generaPdfPresaVisione(utenteContatto,
                    shibIdentitaCodiceFiscale, httpHeaders, methodName, rend);

            ResponseBuilder responseBuilder = Response.ok(html);
            responseBuilder.type("application/pdf");
            String fileName = "presaVisione.pdf";
            responseBuilder.header("Content-Disposition", "filename=\"" + fileName + "\"");
            return responseBuilder.build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getRendicontazionePerBo(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, String documentoNumero,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getRendicontazione: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.RSA_RENDICONTAZIONE),
                    httpHeaders);
            checkNotNull(documentoNumero, "documentoNumero obbligatorio");
            List<CovidrsaTRendicontazioneBackOffice> rendicontazioni = covidrsaTRendicontazioneMapper
                    .selectListRendicontazioniFromDomandaNumero(documentoNumero);

            logAudit(httpHeaders, "select", "covidrsa_t_rendicontazione", methodName);
            String currentStruttura = null;
            ModelRendicontazioniBoResponse last = null;
            List<ModelRendicontazioniBoResponse> res = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (CovidrsaTRendicontazioneBackOffice r : rendicontazioni) {
                if (last == null || !r.getIdStruttura().equals(currentStruttura)) {
                    // primo giro o struttura diversa
                    currentStruttura = r.getIdStruttura();
                    last = generaModelRendicontazioneBoResponse(res, r, sdf);
                } else if (!r.getStatoRendicontazione().getStatoRendCod().equals(last.getStatoCod())) {
                    // struttura uguale, stato diverso
                    last = generaModelRendicontazioneBoResponse(res, r, sdf);
                } else if (r.getInvioPbandiId()!=null && !r.getInvioPbandiId().equals(last.getIdDicSpesa())) {
                    // struttura uguale, stato uguale, invio diverso
                    last = generaModelRendicontazioneBoResponse(res, r, sdf);
                } 

                last.setPeriodoFine(sdf.format(getLastDayOfMonth(r.getDataRendicontazione())));
                last.setDicSpesaPeriodoDesc(
                        "Periodo dal " + last.getPeriodoInizio() + " al " + last.getPeriodoFine());

                ModelRendicontazioniBoDocumentiSpesa rendicontazione = new ModelRendicontazioniBoDocumentiSpesa();
                last.getDocumentiSpesa().add(rendicontazione);
                
                rendicontazione.setNoteIstruttoria(r.getNoteIstruttoria());
                if(r.getDataIstruttoria()!=null) {
                    rendicontazione.setDataIstruttoria(new SimpleDateFormat("dd/MM/yyyy").format(r.getDataIstruttoria()));
                }
                
                rendicontazione.setIdDocSpesa(r.getRendicontazioneId());
                rendicontazione.setDoc_tipo("FATTURA");
                rendicontazione.setDoc_numero(r.getRendicontazioneCod());
                rendicontazione.setPeriodoInizio(sdf.format(getFirstDayOfMonth(r.getDataRendicontazione())));
                rendicontazione.setPeriodoFine(sdf.format(getLastDayOfMonth(r.getDataRendicontazione())));
                rendicontazione.setRsaCod(r.getIdStruttura());
                rendicontazione.setFlagPrimoIngresso(r.getFlgPrimoIngresso());
                rendicontazione.setNote(r.getNote());
                rendicontazione.setRsaPIva(r.getStrutturaWelfare().getEntGestCfPiva());
                rendicontazione.setRsaNome(r.getStrutturaWelfare().getStrResNome());
                if (r.getConto() != null) {
                    rendicontazione.setRsaIBAN(r.getConto().getStrContoIban());
                }
                rendicontazione.setRsaCodArpe(r.getStrutturaArpe());
                if (r.getMovimentoOspite() != null) {
                    rendicontazione.setMovUscitaMotivazione(r.getMovimentoOspiteDescrizione().getTipoMovOspiteDesc());
                    if (r.getMovimentoOspite().getDataMovimento() != null) {
                        rendicontazione.setMovUscitaData(sdf.format(r.getMovimentoOspite().getDataMovimento()));
                    }
                }
                if (r.getFascia() != null) {
                    rendicontazione.setFascia(r.getFascia().getWelfareFasciaDesc());
                }
                List<ModelRendicontazioniBoDocumentiSpesaDettaglio> documentiDettaglio = new ArrayList<>();
                // aggiungi file
                rendicontazione.setDocumentiSpesaDettaglio(documentiDettaglio);
                ModelRendicontazioniBoDocumentiSpesaDettaglio documentoDettaglio = new ModelRendicontazioniBoDocumentiSpesaDettaglio();
                documentiDettaglio.add(documentoDettaglio);
                documentoDettaglio.setIdDocSpesaDettaglio(r.getRendicontazioneId());
                documentoDettaglio
                        .setDocumentoSpesaDettaglioData(sdf.format(getLastDayOfMonth(r.getDataRendicontazione())));
                if (r.getImportoRetta() != null) {
                    documentoDettaglio.setImporto(r.getImportoRetta().toString());
                }
                List<ModelRendicontazioniBoDocumentiSpesaDettaglioAllegati> allegati = covidrsaRRendicontazioneFileMapper.selectByRendicontazioneWhitDecodificaId(r.getRendicontazioneId());
                documentoDettaglio.setAllegati(allegati);

            }
            return Response.ok(res)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), res.size()).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    /**
     * @param res
     * @param r
     * @param sdf
     * @return
     */
    public ModelRendicontazioniBoResponse generaModelRendicontazioneBoResponse(List<ModelRendicontazioniBoResponse> res,
            CovidrsaTRendicontazioneBackOffice r, SimpleDateFormat sdf) {
        ModelRendicontazioniBoResponse current;
        current = new ModelRendicontazioniBoResponse();
        current.setIdDicSpesa(r.getInvioPbandiId());
        current.setStatoCod(r.getStatoRendicontazione().getStatoRendCod());
        current.setStatoDesc(r.getStatoRendicontazione().getStatoRendDesc());
        Date date = getFirstDayOfMonth(r.getDataRendicontazione());
        current.setPeriodoInizio(sdf.format(date));
        if (r.getInvioPbandi() != null) {
            current.setDicSpesaPeriodoDesc(r.getInvioPbandi().getInvioPbandiCod());
            if (r.getInvioPbandi().getInvioData() != null) {
                current.setDataInvio(sdf.format(r.getInvioPbandi().getInvioData()));
                current.setDicSpesaData(sdf.format(r.getInvioPbandi().getInvioData()));
            }
            current.setDicSpesaCodBandi(r.getInvioPbandi().getInvioPbandiUuidExt());
        }

        current.setDocumentiSpesa(new ArrayList<>());
        current.setAllegatiDichiarazioneSpesa(new ArrayList<>());
        res.add(current);
        return current;
    }

    /**
     * @param r
     * @return
     */
    public Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

}
