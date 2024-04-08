/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
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

import it.csi.gescovid.gestruttureresapi.business.be.StrutturaWelfareApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFileTipo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRStrutturaWelfareContatti;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.FileToBeSaved;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFileStrutturaWelfare;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelStrutturaWelfare;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModeleFileWelfare;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareComuni;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWelfareFileTipoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareContattiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRWelfareFasciaMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.gestruttureresapi.business.service.CovidrsaRStrutturaWelfareServiceImpl;
import it.csi.gescovid.gestruttureresapi.dto.CovidusTFile;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.GeneralLogEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.HeaderEnum;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Message;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.GenericUtils;
import it.csi.gescovid.gestruttureresapi.util.PDFGenerator;

public class StrutturaWelfareServiceImpl extends GestioneUtenteServiceImpl implements StrutturaWelfareApi {

    private static final String FIN = "FIN";

    @Autowired
    private CovidrsaRStrutturaWelfareMapper covidrsaRStrutturaWelfareMapper;

    @Autowired
    private CovidrsaRStrutturaWelfareFileMapper covidrsaRStrutturaWelfareFileMapper;

    @Autowired
    private CovidusTFileMapper covidusTFileMapper;

    @Autowired
    private CovidrsaRStrutturaWelfareServiceImpl covidrsaRStrutturaWelfareServiceImpl;

    @Autowired
    private CovidrsaDWelfareFileTipoMapper covidrsaDWelfareFileTipoMapper;
    @Autowired
    private CovidrsaRWelfareFasciaMapper covidrsaRWelfareFasciaMapper;
    
    @Autowired 
    private CovidrsaRStrutturaWelfareContattiMapper covidrsaRStrutturaWelfareContattiMapper;

    @Override
    public Response getStrutturaWelfare(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getStrutturaWelfare: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);
            CovidrsaRStrutturaWelfareExt result = covidrsaRStrutturaWelfareMapper
                    .selectByIdStruttura(idStrutturaOperazione);

            logAudit(httpHeaders, "select", "covidrsa_r_struttura_welfare", methodName);

            result.setRichiestaFinalizzata(Boolean.FALSE);

            if (result.getStrWelfareId() != null) {
                result.setFascia(covidrsaRWelfareFasciaMapper.selectByStrWelfareId(result.getStrWelfareId()));
                List<CovidrsaRStrutturaWelfareFileExt> files = covidrsaRStrutturaWelfareFileMapper
                        .selectByStrWelfareId(result.getStrWelfareId());
                if (!files.isEmpty()) {
                    result.setFiles(new ArrayList<>());
                    for (CovidrsaRStrutturaWelfareFileExt file : files) {
                        if (!result.getRichiestaFinalizzata() && FIN.equalsIgnoreCase(file.getFileTipoGruppo())) {
                            result.setRichiestaFinalizzata(Boolean.TRUE);
                        }
                        CovidusTFile fileData = covidusTFileMapper.selectByPrimaryKey(file.getFileId());
                        ModelFileStrutturaWelfare fileResult = new ModelFileStrutturaWelfare();
                        fileResult.setFilename(fileData.getFileName());
                        fileResult.setFirmaVerificata(file.getFirmaVerificata());
                        fileResult.setFileTipoId(file.getFileTipoId());
                        fileResult.setFileTipoCod(file.getFileTipoCod());
                        fileResult.setFileTipoDesc(file.getFileTipoDesc());
                        result.getFiles().add(fileResult);
                    }
                }

            }

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getStrutturaWelfareFilter(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String denominazione, String comune,
            String indirizzo, String orderby, Long rowPerPage, Long pageNumber, Boolean descending,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getStrutturaWelfareFilter: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, Boolean.TRUE.equals(descending));
            List<ModelStrutturaWelfare> result = covidrsaRStrutturaWelfareMapper.selectFiltered(denominazione, comune, indirizzo, paginazione);

            logAudit(httpHeaders, "select", "covidrsa_r_struttura_welfare", methodName);

            return Response.ok(result)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), GenericUtils.getTotalCountFromList(result)).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }


    @Override
    public Response postStrutturaWelfare(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidrsaRStrutturaWelfareExt payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postStrutturaWelfare: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);

            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getRapLegCodiceFiscale(), "codice fiscale rappresentante legale obbligatorio");
            if (!shibIdentitaCodiceFiscale.equalsIgnoreCase(payload.getRapLegCodiceFiscale().trim())) {
                checkNotNull(payload.getFiles(), "non e' stato allegato file di delega");
                checkCondition(!payload.getFiles().isEmpty(), "non e' stato allegato file di delega");
                List<CovidrsaDWelfareFileTipo> fileTipoDelega = covidrsaDWelfareFileTipoMapper
                        .selectAllValid("AR_DELEGA");
                checkCondition(payload.getFiles().get(0).getFileTipoId().equals(fileTipoDelega.get(0).getFileTipoId()),
                        "file allegato non di delega");
            }
            if(payload.getFascia()!=null) {
                for(ModelFascia fascia:payload.getFascia()) {
                    BigDecimal com = new BigDecimal(10000);
                    checkCondition(com.compareTo(fascia.getTariffaMensileMassima())>0, "importo "+fascia.getTariffaMensileMassima()+ " supera soglia massima");
                }
                
            }
            payload.setIdStruttura(idStrutturaOperazione);

            // insert in tabella di payload
            covidrsaRStrutturaWelfareServiceImpl.insertStrutturaWelfare(shibIdentitaCodiceFiscale, payload);

            logAudit(httpHeaders, "insert", "covidrsa_r_struttura_welfare", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postStrutturaWelfareFiles(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, ModeleFileWelfare payload,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postStrutturaWelfareFiles: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);
            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getStrWelfareId(), "strWelfareId obbligatorio");
            checkNotNull(covidrsaRStrutturaWelfareMapper
                    .selectByValidPrimaryKey(payload.getStrWelfareId()),
                    "Non esiste struttura Welfare valida associata a strWelfareId");

            // insert in tabella di payload
            covidrsaRStrutturaWelfareServiceImpl.insertStrutturaWelfareFiles(shibIdentitaCodiceFiscale,
                    idStrutturaOperazione, payload);

            logAudit(httpHeaders, "insert", "covidrsa_r_struttura_welfare_file", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response printDichiarazioneSostitutivaDiCertificazione(String shibIdentitaCodiceFiscale,
            String xApplicazioneCodice, String xRequestId, String xForwardedFor, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest req) {
        final String methodName = "printDichiarazioneSostitutivaDiCertificazione: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);
            CovidrsaRStrutturaWelfareExt result = covidrsaRStrutturaWelfareMapper
                    .selectByIdStruttura(idStrutturaOperazione);
            if (result.getStrWelfareId() != null) {
                result.setFascia(covidrsaRWelfareFasciaMapper.selectByStrWelfareId(result.getStrWelfareId()));
            }

            logAudit(httpHeaders, "select", "covidrsa_r_struttura_welfare", methodName);

            checkNotNull(result, "la struttura corrente non ha dati associati");

            String fileName = "dichiarazione_sostitutiva_di_certificazione.pdf";
            ByteArrayInputStream is = generatePdfDichiarazioneSostitutiva(result);

            ResponseBuilder responseBuilder = Response.ok(is);
            responseBuilder.type("application/pdf");
            responseBuilder.header("Content-Disposition", "filename=\"" + fileName + "\"");
            return responseBuilder.build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    /**
     * @param methodName
     * @param result
     * @return
     * @throws WebApplicationException
     */
    private ByteArrayInputStream generatePdfDichiarazioneSostitutiva(
            CovidrsaRStrutturaWelfareExt result) throws WebApplicationException {
        final String methodName = "generatePdfDichiarazioneSostitutiva: ";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(os));
                Document doc = new Document(pdfDoc, PageSize.A4)) {
            doc.setMargins(10, 10, 10, 10);
            PDFGenerator.printDichiarazioneSostitutivaDiCertificazione(result, doc);
        } catch (IOException e) {
            log.error(methodName, "Errore durante la generazione del PDF per dichiarazione sostitutiva: ", e);
            throw new WebApplicationException(
                    Response.serverError().entity(new Message("Errore durante la generazione del PDF")).build());
        }
        return new ByteArrayInputStream(os.toByteArray());
    }

    @Override
    public Response getStrutturaWelfareFileTipo(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String fileTipoCod,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getStrutturaWelfareFileTipo: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());

            List<CovidrsaDWelfareFileTipo> result = covidrsaDWelfareFileTipoMapper.selectAllValid(fileTipoCod);
            logAudit(httpHeaders, "select", "covidrsa_r_struttura_welfare_file_tipo", methodName);

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postVerificaFirma(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, String cfRappLeg, FileToBeSaved payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postStrutturaWelfareFiles: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.FIRMA),
                    httpHeaders);
            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(cfRappLeg, "codice fiscale rappresentante legale obbligatorio");

            String[] strings = payload.getBase64String().split(",");
            byte[] fileDecoded = Base64.getDecoder().decode(strings[1]);
            Boolean result = covidrsaRStrutturaWelfareServiceImpl.verificaFirma(shibIdentitaCodiceFiscale,
                    payload.getFilename(), fileDecoded,
                    true, cfRappLeg);

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getStrutturaWelfareComuni(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getStrutturaWelfareComuni: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            List<CovidrsaRStrutturaWelfareComuni> result = covidrsaRStrutturaWelfareMapper.selectDistinctComuni();

            logAudit(httpHeaders, "select", "covidrsa_r_struttura_welfare", methodName);

            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getStrutturaWelfareEmail(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getStrutturaWelfareEmail: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);
            CovidrsaRStrutturaWelfareContatti result = covidrsaRStrutturaWelfareContattiMapper
                    .selectByIdStruttura(idStrutturaOperazione);

            logAudit(httpHeaders, "select", "covidrsa_r_struttura_welfare_contatti", methodName);


            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postStrutturaWelfareEmail(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, CovidrsaRStrutturaWelfareContatti payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postStrutturaWelfareEmail: ";
        Response responseError;

        try {
            log.info(methodName, GeneralLogEnum.BEGIN.getCode());
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.STRUTTURA_WELFARE),
                    httpHeaders);
            checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
            checkNotNull(payload.getStrutturaEmail(), "parametro StrutturaEmail obbligatoria");
            CovidrsaRStrutturaWelfareContatti result = covidrsaRStrutturaWelfareContattiMapper
                    .selectByIdStruttura(idStrutturaOperazione);
            checkNotNull(result, "email associata a struttura non trovata");
            
            result.setUtenteOperazione(utenteOperazione);
            covidrsaRStrutturaWelfareContattiMapper.invalidaByPrimaryKey(result);
            result.setStrWelfContattiId(null);
            result.setDataCreazione(null);
            result.setValiditaInizio(null);
            result.setValiditaFine(null);
            result.setStrutturaEmail(payload.getStrutturaEmail());
            int res = covidrsaRStrutturaWelfareContattiMapper.insert(result);
            checkCondition(res == 1, "email non inserita correttamente");
            logAudit(httpHeaders, "insert", "covidrsa_r_struttura_welfare_contatti", methodName);


            return Response.ok(result).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
