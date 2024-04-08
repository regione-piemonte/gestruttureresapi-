/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import it.csi.gescovid.gestruttureresapi.business.be.RichiesteIntegrazioneBandiApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFileTipo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTIntegrazionePbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsarIntegrazionePbandiFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.CovidrsaTIntegrazionePbandiBo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelCovidrsaTIntegrazionePbandiBo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTIntegrazionePbandiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsarIntegrazionePbandiFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsarIntegrazionePbandiFileSaveFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWelfareFileTipoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTIntegrazionePbandiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsarIntegrazionePbandiFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.gestruttureresapi.business.service.CovidrsaRendicontazioneServiceImpl;
import it.csi.gescovid.gestruttureresapi.dto.CovidusTFile;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.HeaderEnum;
import it.csi.gescovid.gestruttureresapi.exception.ErroreBuilder;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.TrasmissioneDocIntegrativaSpesa;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.ListaDocIntegrazioneSpesa;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.TrasmissioneDocIntegrativaSpesaRequest;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.TrasmissioneDocIntegrativaSpesaResponse;
import it.csi.gescovid.gestruttureresapi.util.GenericUtils;

public class RichiesteIntegrazioneBandiApiServiceImpl extends GestioneUtenteServiceImpl
        implements RichiesteIntegrazioneBandiApi {

    @Autowired
    private CovidrsaTIntegrazionePbandiMapper covidrsaTIntegrazionePbandiMapper;

    @Autowired
    private CovidrsarIntegrazionePbandiFileMapper covidrsarIntegrazionePbandiFileMapper;

    @Autowired
    private CovidrsaRendicontazioneServiceImpl covidrsaRendicontazioneServiceImpl;

    @Autowired
    private CovidrsaDWelfareFileTipoMapper covidrsaDWelfareFileTipoMapper;

    @Autowired
    private TrasmissioneDocIntegrativaSpesa trasmissioneDocIntegrativaSpesa;

    @Autowired
    private CovidusTFileMapper covidusTFileMapper;

    @Override
    public Response getRichiesteBandi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getRichiesteBandi: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.BANDI_RICHIESTA),
                    httpHeaders);

            List<CovidrsaTIntegrazionePbandiExt> res = covidrsaTIntegrazionePbandiMapper
                    .selectByIdStruttura(idStrutturaOperazione);
            logAudit(httpHeaders, "select", "covidrsa_t_integrazione_pbandi", methodName);

            return Response.ok(res)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), GenericUtils.getTotalCountFromList(res)).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getRichiestaBandi(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, Integer integrazionePbandiId, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getRichiestaBandi: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.BANDI_RICHIESTA),
                    httpHeaders);

            checkNotNull(integrazionePbandiId, "id integrazione pbandi obbligatoria");

            CovidrsaTIntegrazionePbandiExt res = covidrsaTIntegrazionePbandiMapper
                    .selectByIdStrutturaAndIntegrazionePbandiId(idStrutturaOperazione, integrazionePbandiId);
            logAudit(httpHeaders, "select", "covidrsa_t_integrazione_pbandi", methodName);
            checkNotNull(res, "inegrazione associata non trovata");

            List<CovidrsarIntegrazionePbandiFileExt> file = covidrsarIntegrazionePbandiFileMapper
                    .selectByIntegrazionePbandiFileId(integrazionePbandiId);
            res.setFile(file);

            return Response.ok(res).build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response postRichiestaFile(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, CovidrsarIntegrazionePbandiFileSaveFile payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "postRichiestaFile: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.BANDI_RICHIESTA),
                    httpHeaders);
            checkNotNull(payload, "payload obbligatorio");
            checkNotNull(payload.getFile(), "file obbligatorio");
            checkNotNull(payload.getFile().getFilename(), "filename obbligatorio");
            checkNotNull(payload.getIntegrazionePbandiId(), "integrazione pbandi id associato obbligatorio");
            CovidrsaTIntegrazionePbandiExt res = covidrsaTIntegrazionePbandiMapper
                    .selectByIdStrutturaAndIntegrazionePbandiId(idStrutturaOperazione,
                            payload.getIntegrazionePbandiId());
            checkNotNull(res, "inegrazione associata non trovata");
            checkNotNull(payload.getFileTipoId(), "file tipo id obbligatorio");
            CovidrsaDWelfareFileTipo fileTipo = covidrsaDWelfareFileTipoMapper
                    .selectByPrimaryKey(payload.getFileTipoId());
            checkNotNull(fileTipo, "fileTipoId non associato e nessun tipo file valido");

            CovidusTFile documento = covidrsaRendicontazioneServiceImpl.salvaDocumento(shibIdentitaCodiceFiscale,
                    payload.getFile().getFilename(),
                    payload.getFile().getBase64String());

            payload.setDataCancellazione(null);
            payload.setValiditaInizio(null);
            payload.setIntegrazionePbandiFileId(null);
            payload.setUtenteOperazione(shibIdentitaCodiceFiscale);
            payload.setFileId(documento.getFileId());

            covidrsarIntegrazionePbandiFileMapper.insert(payload);
            logAudit(httpHeaders, "insert", "covidrsa_r_integrazione_pbandi_file", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response deleteRichiestaFile(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, CovidrsarIntegrazionePbandiFile payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "deleteRichiestaFile: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.BANDI_RICHIESTA),
                    httpHeaders);
            checkNotNull(payload, "payload obbligatorio");
            checkNotNull(payload.getIntegrazionePbandiFileId(), "integrazione pbandi file id obbligatorio");
            CovidrsarIntegrazionePbandiFile integrazione = covidrsarIntegrazionePbandiFileMapper
                    .selectByPrimaryKey(payload.getIntegrazionePbandiFileId());
            checkNotNull(integrazione, "integrazione associata a integrazione pbandi file id non trovata");

            CovidrsaTIntegrazionePbandiExt res = covidrsaTIntegrazionePbandiMapper
                    .selectByIdStrutturaAndIntegrazionePbandiId(idStrutturaOperazione,
                            integrazione.getIntegrazionePbandiId());
            checkNotNull(res, "inegrazione associata non trovata");

            covidrsarIntegrazionePbandiFileMapper.logicDelete(integrazione);
            logAudit(httpHeaders, "delete logica", "covidrsa_r_integrazione_pbandi_file", methodName);

            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }
    // -->
    // POST SU DETTAGLIO, api che fa l'invio a pbandi e se va bene deve fare un
    // updatedella richiesta mettendo data risposta = now() e utente operazione.

    @Override
    public Response inviaRichiestaFile(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, CovidrsaTIntegrazionePbandi payload, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "inviaRichiestaFile: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcScrittura(FunzioneEnum.BANDI_RICHIESTA),
                    httpHeaders);
            checkNotNull(payload, "payload obbligatorio");
            checkNotNull(payload.getIntegrazionePbandiId(), "id integrazione pbandi obbligatoria");

            CovidrsaTIntegrazionePbandiExt res = covidrsaTIntegrazionePbandiMapper
                    .selectByIdStrutturaAndIntegrazionePbandiId(idStrutturaOperazione,
                            payload.getIntegrazionePbandiId());
            logAudit(httpHeaders, "select", "covidrsa_t_integrazione_pbandi", methodName);
            checkNotNull(res, "inegrazione associata non trovata");

            CovidrsaTIntegrazionePbandi integrazione = covidrsaTIntegrazionePbandiMapper
                    .selectByPrimaryKey(payload.getIntegrazionePbandiId());
            checkCondition(integrazione.getDataRisposta() == null, "integrazione gia' inviata");

            TrasmissioneDocIntegrativaSpesaRequest request = new TrasmissioneDocIntegrativaSpesaRequest();
            request.setIdentificativoRichiestaDiIntegrazione(Integer.valueOf(integrazione.getIntegrazionePbandiCod()));

            List<ListaDocIntegrazioneSpesa> documenti = new ArrayList<>();
            List<CovidrsarIntegrazionePbandiFileExt> files = covidrsarIntegrazionePbandiFileMapper
                    .selectByIntegrazionePbandiFileId(payload.getIntegrazionePbandiId());
            for (CovidrsarIntegrazionePbandiFileExt file : files) {
                ListaDocIntegrazioneSpesa documento = new ListaDocIntegrazioneSpesa();
                documento.setNomeDocumento(file.getFile().getFileName());
                CovidusTFile covidusTfile = covidusTFileMapper.selectByPrimaryKey(file.getFileId());
                documento.setDocumento(Base64.getEncoder().encodeToString(
                        covidusTfile.getFile()));
                documenti.add(documento);

            }
            request.setListaDocIntegrazioneSpesa(documenti);
            TrasmissioneDocIntegrativaSpesaResponse response = trasmissioneDocIntegrativaSpesa
                    .postTrasmissioneDocIntegrativaSpesa(request);
            // fai invio
            if (response != null && response.getStatus().equals(HttpStatus.OK)) {
                log.info(methodName, response.getStatus().toString());
                if (response.getDocIntegrativaSpesaResponse() != null
                        && response.getDocIntegrativaSpesaResponse().getEsito() != null
                        && response.getDocIntegrativaSpesaResponse().getEsito().equals("OK")) {
                    integrazione.setUtenteOperazione(shibIdentitaCodiceFiscale);
                    integrazione.setDataRisposta(new Date());

                    covidrsaTIntegrazionePbandiMapper.updateByPrimaryKey(integrazione);
                    logAudit(httpHeaders, "update", "covidrsa_t_integrazione_pbandi", methodName);

                } else {
                    logAudit(httpHeaders, "ERROR", "",
                            methodName + " " + response.toString());
                    return ErroreBuilder.from(Status.INTERNAL_SERVER_ERROR).descrizione(
                            "Trasmissione integrazione a pbandi con esito negativo: "
                                    + response.getDocIntegrativaSpesaResponse().getCodiceErrore() + " "
                                    + response.getDocIntegrativaSpesaResponse().getMessaggioErrore())
                            .exception().getResponse();
                }
            } else {
                logAudit(httpHeaders, "ERROR", "",
                        methodName + " Errore imprevisto: " + (response != null ? response.toString()
                                : "ND"));
                return ErroreBuilder.from(Status.INTERNAL_SERVER_ERROR)
                        .descrizione("Errore imprevisto: chiamata bandi chiamare l'assistenza")
                        .exception().getResponse();
            }
            return Response.ok().build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

    @Override
    public Response getRichiesteBandiPerBo(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
            String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
            Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
            String idStrutturaOperazione, Integer idAreaOperazione, String documentoNumero,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        final String methodName = "getRichiesteBandiPerBo: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione,
                    funcLettura(FunzioneEnum.BANDI_RICHIESTA),
                    httpHeaders);

            List<CovidrsaTIntegrazionePbandiBo> listaIntegrazioni = covidrsaTIntegrazionePbandiMapper
                    .selectByDocumentoNumero(documentoNumero);
            logAudit(httpHeaders, "select", "covidrsa_t_integrazione_pbandi", methodName);
            List<ModelCovidrsaTIntegrazionePbandiBo> res = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (CovidrsaTIntegrazionePbandiBo r : listaIntegrazioni) {
                ModelCovidrsaTIntegrazionePbandiBo integrazione = new ModelCovidrsaTIntegrazionePbandiBo();
                res.add(integrazione);
                integrazione.setAllegati(covidrsaTIntegrazionePbandiMapper
                        .selectByIntegrazioneIWhitDecodificaId(r.getIntegrazionePbandiId()));
                integrazione.setIntegrazionePbandiId(r.getIntegrazionePbandiId());
                integrazione.setInvioPbandiId(r.getInvioPbandiId());
                integrazione.setDicSpesaIntegrazioneNote(r.getNoteRichiesta());
                if (r.getDataRisposta() != null) {
                    integrazione.setDicSpesaIntegrazioneCode("INVIATA");
                    integrazione.setDataRisposta(sdf.format(r.getDataRisposta()));
                } else {
                    integrazione.setDicSpesaIntegrazioneCode("CARICATA");
                }
                if (r.getDataRichiesta() != null) {
                    integrazione.setDicSpesaIntegrazioneData(sdf.format(r.getDataRichiesta()));
                }
                if (r.getPeriodoFine() != null) {
                    integrazione.setPeriodoFine(sdf.format(r.getPeriodoFine()));
                }
                if (r.getPeriodoInizio() != null) {
                    integrazione.setPeriodoInizio(sdf.format(r.getPeriodoInizio()));
                }
                if (r.getDataScadenza() != null) {
                    integrazione.setDataScadenza(sdf.format(r.getDataScadenza()));
                }

                
                integrazione.setRsaNome(r.getStrResNome());                
                integrazione.setRsaCod(r.getIdStruttura());

            }

            return Response.ok(res)
                    .header(HeaderEnum.ROWS_NUMBER.getCode(), GenericUtils.getTotalCountFromList(listaIntegrazioni))
                    .build();
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
