/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.text.StringSubstitutor;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDTipoMovOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFileTipo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWorkflowRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRRendicontazioneFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.FileToBeSaved;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.UpdateStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRRendicontazioneFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneList;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidhrCParametroMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDTipoMovOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWelfareFileTipoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWorkflowRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRRendicontazioneFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTMovimentoOspiteMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaTRendicontazioneMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SoggettoMapper;
import it.csi.gescovid.gestruttureresapi.dto.CovidusTFile;
import it.csi.gescovid.gestruttureresapi.enumeration.DetailChiaviEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.FileTipoEnum;
import it.csi.gescovid.gestruttureresapi.enumeration.RendicontazioneUtenteEnum;
import it.csi.gescovid.gestruttureresapi.exception.ErroreBuilder;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.GateFireService;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.Attachment;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.CallInfo;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.SignVerifyResult;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.Signer;
import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.ModelUtenteContatto;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;

@Service
public class CovidrsaRendicontazioneServiceImpl extends RESTBaseService {

    @Autowired
    private CovidrsaTMovimentoOspiteMapper covidrsaTMovimentoOspiteMapper;

    @Autowired
    private CovidrsaDTipoMovOspiteMapper covidrsaDTipoMovOspiteMapper;

    @Autowired
    private CovidrsaTRendicontazioneMapper covidrsaTRendicontazioneMapper;

    @Autowired
    private CovidrsaRStrutturaWelfareMapper covidrsaRStrutturaWelfareMapper;

    @Autowired
    private CovidrsaRRendicontazioneFileMapper covidrsaRRendicontazioneFileMapper;

    @Autowired
    private CovidusTFileMapper covidusTFileMapper;

    @Autowired
    private GateFireService gateFireService;

    @Autowired
    private CovidrsaDWelfareFileTipoMapper covidrsaDWelfareFileTipoMapper;

    @Autowired
    private SoggettoMapper soggettoMapper;

    @Autowired
    private GeneraPdfFromHtmlService generaPdfFromHtmlService;

    @Autowired
    private CovidhrCParametroMapper covidhrCParametroMapper;


    @Autowired
    private CovidrsaDWorkflowRendicontazioneMapper covidrsaDWorkflowRendicontazioneMapper;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void postRendicontazioneStato(UpdateStatoRendicontazione payload, String shibIdentitaCodiceFiscale,
            HttpHeaders httpHeaders, ModelUtenteContatto utenteContatto, String note, RendicontazioneUtenteEnum tipoUtente)
            throws IOException {
        
        Boolean verificaFile = false;
        Boolean flgGeneraDichiarazione = false;
        Boolean flgCancellaDichiarazione = null;
        
        if(!payload.getOldStato().equals(payload.getNewStato())) {
            //SE SONO UGUALI gli stati non bisogna fare queste verifiche e proseguire
            List<CovidrsaDWorkflowRendicontazione> workflow = covidrsaDWorkflowRendicontazioneMapper
                    .selectAllValidFromId(payload.getOldStato(), payload.getNewStato());
            checkNotNull(workflow, "workflow dipendente da stato precedente e nuovo stato non trovato");
            checkCondition(!workflow.isEmpty(),
                    "workflow dipendente da stato precedente e nuovo stato non trovato ");
            
            //Struttura a true se chiamata da struttura TODO
            if(tipoUtente.equals(RendicontazioneUtenteEnum.STRUTTURA)) {
                checkCondition(Boolean.TRUE.equals(workflow.get(0).getFlgStruttura()),
                        "passaggio di stato non permesso per struttura");
            } else if(tipoUtente.equals(RendicontazioneUtenteEnum.ENTE_GESTORE))  {
                checkCondition(Boolean.TRUE.equals(workflow.get(0).getFlgEnteGestore()),
                        "passaggio di stato non permesso per ente gestore");
            }
            verificaFile = workflow.get(0).getFlgControllaFile();
            flgGeneraDichiarazione = workflow.get(0).getFlgGeneraDichiarazione();
            List<CovidrsaDWorkflowRendicontazione> workflowInverso = covidrsaDWorkflowRendicontazioneMapper
                    .selectAllValidFromId(payload.getNewStato(), payload.getOldStato());
            if(workflowInverso != null && !workflowInverso.isEmpty() && workflowInverso.get(0).getFlgGeneraDichiarazione()!=null) {
                flgCancellaDichiarazione = workflowInverso.get(0).getFlgGeneraDichiarazione();
            }
            
        }

        

        Integer oldStato = payload.getOldStato();
        Integer newStato = payload.getNewStato();
        if (Boolean.TRUE.equals(verificaFile)) {
            Integer totalFileOblGen = covidrsaDWelfareFileTipoMapper
                    .countFileObbligatoriFromGruppo(FileTipoEnum.RBR.getCode());
            Integer totalFileOblPrimoMese = covidrsaDWelfareFileTipoMapper
                    .countFileObbligatoriFromGruppo(FileTipoEnum.RBR_MESE_1.getCode());
            Integer totalFileOblPrimoIngresso = covidrsaDWelfareFileTipoMapper
                    .countFileObbligatoriFromGruppo(FileTipoEnum.RBR_MESE_1_PRIMO_INGRESSO.getCode());

            BigDecimal bdl = new BigDecimal(600);
            for (Integer rendId : payload.getRendicontazioniId()) {

                CovidrsaTRendicontazione oldVal = covidrsaTRendicontazioneMapper
                        .selectByPrimaryKey(rendId);

                checkNotNull(oldVal.getImportoRetta(), "Importo fattura deve essere valorizzato");
                checkCondition(oldVal.getImportoRetta().compareTo(bdl) >= 0,
                        "Importo fattura deve essere maggiore o uguale a 600 euro");

                CovidrsaTRendicontazioneList rendicontazione = getRendicontazioneAndVerifyStato(oldStato, rendId);

                Integer fileOblInseriti = null;
                Integer totalFileObl = null;
                if (Boolean.TRUE.equals(rendicontazione.getFlgPrimaRendicontazione())) {
                    if (Boolean.TRUE.equals(rendicontazione.getFlgPrimoIngresso())) {
                        totalFileObl = totalFileOblPrimoIngresso;
                        fileOblInseriti = covidrsaTRendicontazioneMapper.countFileObbligatoriInseriti(rendId,
                                FileTipoEnum.RBR_MESE_1_PRIMO_INGRESSO.getCode());
                    } else {
                        totalFileObl = totalFileOblPrimoMese;
                        fileOblInseriti = covidrsaTRendicontazioneMapper.countFileObbligatoriInseriti(rendId,
                                FileTipoEnum.RBR_MESE_1.getCode());

                    }
                } else {
                    totalFileObl = totalFileOblGen;
                    fileOblInseriti = covidrsaTRendicontazioneMapper.countFileObbligatoriInseriti(rendId,
                            FileTipoEnum.RBR.getCode());
                }

                if (!totalFileObl.equals(fileOblInseriti)) {

                    throw ErroreBuilder.from(Status.BAD_REQUEST).descrizione("rendicontazione per " + rendId +
                            " non sono stati inseriti i file obbligatori necessari per la modifica di stato")
                            .dettaglio(DetailChiaviEnum.CODE, CaConstants.ERROR_CODE_FILE_OBBLIGATORI_MANCANTI)
                            .dettaglio(DetailChiaviEnum.RENDICONTAZIONE_ID, String.valueOf(rendId))
                            .exception();
                }

                updateStatoRendicontazione(newStato, shibIdentitaCodiceFiscale, httpHeaders, rendId,
                        rendicontazione, flgGeneraDichiarazione,flgCancellaDichiarazione,  utenteContatto, note);
            }
            // --> a questo punto fai invalida e inserisci rendicontazione.

        } else {

            for (Integer rendId : payload.getRendicontazioniId()) {
                CovidrsaTRendicontazioneList rendicontazione = getRendicontazioneAndVerifyStato(oldStato, rendId);

                updateStatoRendicontazione(newStato, shibIdentitaCodiceFiscale, httpHeaders, rendId,
                        rendicontazione, flgGeneraDichiarazione, flgCancellaDichiarazione, utenteContatto, note);
            }

        }
    }

    /**
     * @param oldStato
     * @param rendId
     * @return
     */
    private CovidrsaTRendicontazioneList getRendicontazioneAndVerifyStato(Integer oldStato, Integer rendId) {
        CovidrsaTRendicontazioneList rendicontazione = covidrsaTRendicontazioneMapper
                .selectByPrimaryKeyWhitPrimoIngresso(rendId);

        checkCondition(rendicontazione.getStatoRendId().equals(oldStato),
                "rendicontazione per " + rendId + " non uguale a quella indicata per stato precedente");
        return rendicontazione;
    }

    /**
     * @param payload
     * @param shibIdentitaCodiceFiscale
     * @param httpHeaders
     * @param methodName
     * @param rendId
     * @param rendicontazione
     * @param flgCancellaDichiarazione 
     * @throws IOException
     */
    private void updateStatoRendicontazione(Integer newStato, String shibIdentitaCodiceFiscale,
            HttpHeaders httpHeaders, Integer rendId, CovidrsaTRendicontazioneList rendicontazione,
            Boolean flgGeneraDichiarazione, Boolean flgCancellaDichiarazione, ModelUtenteContatto utenteContatto, String note) throws IOException {
        String methodName = "updateStatoRendicontazione";

        int res = covidrsaTRendicontazioneMapper.updateValiditaFine(rendicontazione);
        checkCondition(res != 0, "rendicontazione " + rendId + " da modificare non trovata");
        logAudit(httpHeaders, "update", "covidrsa_t_rendicontazione", methodName);

        rendicontazione.setValiditaInizio(null);
        rendicontazione.setRendicontazioneId(null);
        rendicontazione.setUtenteOperazione(shibIdentitaCodiceFiscale);
        rendicontazione.setStatoRendId(newStato);
        rendicontazione.setNoteOperazione(note);
        
        covidrsaTRendicontazioneMapper.insert(rendicontazione);
        List<CovidrsaRRendicontazioneFileExt> listaFile = covidrsaRRendicontazioneFileMapper
                .selectByRendicontazioneId(rendId);

        Integer fileTipoId = null;
        if (Boolean.TRUE.equals(flgGeneraDichiarazione) || Boolean.TRUE.equals(flgCancellaDichiarazione)) {
            List<CovidrsaDWelfareFileTipo> filesTipoId = covidrsaDWelfareFileTipoMapper
                    .selectAllValid(FileTipoEnum.RBR_DICHIARAZIONE.getCode());
            fileTipoId = filesTipoId.get(0).getFileTipoId();
        } 

        if (listaFile != null && !listaFile.isEmpty()) {
            for (CovidrsaRRendicontazioneFile file : listaFile) {
                if (fileTipoId == null || !file.getFileTipoId().equals(fileTipoId)) {
                    CovidrsaRRendicontazioneFile oldRRendicontaioneFile = covidrsaRRendicontazioneFileMapper
                            .selectByPrimaryKey(file.getRendicontazioneFileId());
                    oldRRendicontaioneFile.setRendicontazioneId(rendicontazione.getRendicontazioneId());
                    oldRRendicontaioneFile.setRendicontazioneFileId(null);
                    covidrsaRRendicontazioneFileMapper.insert(oldRRendicontaioneFile);
                }

            }
        }

        logAudit(httpHeaders, "insert", "covidrsa_t_rendicontazione", methodName);

//        CovidrsaRStrutturaWelfareExt result, CovidrsaTRendicontazione rend,
//        Soggetto soggetto
        if (Boolean.TRUE.equals(flgGeneraDichiarazione)) {
            CovidrsaTRendicontazione rend = covidrsaTRendicontazioneMapper
                    .selectByPrimaryKey(rendicontazione.getRendicontazioneId());
            checkNotNull(rend, "rendicontazione non esistente");
            logAudit(httpHeaders, "select", "covidrsa_t_rendicontazione", methodName);
            ByteArrayInputStream pdf = generaPdfPresaVisione(utenteContatto, shibIdentitaCodiceFiscale, httpHeaders,
                    methodName, rend);
            Date validitaInizio = rend.getValiditaInizio();
            if (validitaInizio == null) {
                rend.setValiditaInizio(new Date());
            }

            String fileType = "application/pdf";
            byte[] file = IOUtils.toByteArray(pdf);
            saveFileWhitoutCheckFirma(rend.getRendicontazioneId(), fileTipoId, validitaInizio,
                    rend.getValiditaFine(),
                    shibIdentitaCodiceFiscale, "dichiarazione_di_spesa.pdf", fileType, file);
            logAudit(httpHeaders, "insert", "covidrsa_r_rendicontazione_file", methodName);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertRendicontazioneFiles(String shibIdentitaCodiceFiscale, String idStrutturaOperazione,
            CovidrsaRRendicontazioneFileExt payload) {

        // e di conseguezna walfare id
        Date validitaInizio = payload.getValiditaInizio();
        if (validitaInizio == null) {
            payload.setValiditaInizio(new Date());
        }

        saveFile(payload.getRendicontazioneId(), payload.getValiditaInizio(), payload.getValiditaFine(),
                true, shibIdentitaCodiceFiscale, payload.getFileToBeSaved());
    }

    /**
     * @param strWelfareId
     * @param validitaInizio
     * @param validitaFine
     * @param firmaRappresentanteLegale
     * @param shibIdentitaCodiceFiscale
     * @param file
     * @throws WebApplicationException
     */
    private void saveFile(Integer rendicontazioneId, Date validitaInizio, Date validitaFine,
            Boolean firmaRappresentanteLegale, String shibIdentitaCodiceFiscale, FileToBeSaved file)
            throws WebApplicationException {
        checkNotNull(file.getFileTipoId(), "fileTipoId obbligatorio");
        CovidrsaDWelfareFileTipo fileTipo = covidrsaDWelfareFileTipoMapper.selectByPrimaryKey(file.getFileTipoId());
        checkNotNull(fileTipo, "fileTipoId non associato e nessun tipo file valido");
        Boolean verificaFirma = fileTipo.getFileTipoFirmato();
        Boolean result = null;
        if (Boolean.TRUE.equals(verificaFirma)) {
            String[] strings = file.getBase64String().split(",");
            checkCondition(strings != null && strings.length > 1, "file: " + file.getFilename() + " file non valido");
            if(strings != null && strings.length > 1) {
                byte[] fileDecoded = Base64.getDecoder().decode(strings[1]);
                CovidrsaTRendicontazione rend = covidrsaTRendicontazioneMapper
                        .selectByPrimaryKey(rendicontazioneId);
                String cfRappresentanteLegale = covidrsaRStrutturaWelfareMapper
                        .selectRapLegCodiceFiscaleFromStruttura(rend.getIdStruttura());

                result = verificaFirma(shibIdentitaCodiceFiscale, file.getFilename(), fileDecoded,
                        firmaRappresentanteLegale, cfRappresentanteLegale);
            }
        }
        CovidusTFile documento = salvaDocumento(shibIdentitaCodiceFiscale, file.getFilename(),
                file.getBase64String());

        CovidrsaRRendicontazioneFile rStrutturaWelfareFile = new CovidrsaRRendicontazioneFile();
        rStrutturaWelfareFile.setFileId(documento.getFileId());
        rStrutturaWelfareFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
        rStrutturaWelfareFile.setRendicontazioneId(rendicontazioneId);
        rStrutturaWelfareFile.setValiditaInizio(validitaInizio);
        rStrutturaWelfareFile.setValiditaFine(validitaFine);
        rStrutturaWelfareFile.setFileTipoId(file.getFileTipoId());
        rStrutturaWelfareFile.setFirmaVerificata(result);

        covidrsaRRendicontazioneFileMapper.insert(rStrutturaWelfareFile);
    }

    public CovidusTFile salvaDocumento(String shibIdentitaCodiceFiscale, String filename, String base64String) {
        String[] strings = base64String.split(",");
        String tipoFile = strings[0];

        String mineType = tipoFile.substring(tipoFile.indexOf(":") + 1, tipoFile.indexOf(";"));

        byte[] file = Base64.getDecoder().decode(strings[1]);

        return salvaDocumento(shibIdentitaCodiceFiscale, filename, mineType, file);
    }

    private void saveFileWhitoutCheckFirma(Integer rendicontazioneId, Integer fileTipoId, Date validitaInizio,
            Date validitaFine,
            String shibIdentitaCodiceFiscale, String filename, String fileType, byte[] file)
            throws WebApplicationException {
        checkNotNull(fileTipoId, "fileTipoId obbligatorio");
        CovidrsaDWelfareFileTipo fileTipo = covidrsaDWelfareFileTipoMapper.selectByPrimaryKey(fileTipoId);
        checkNotNull(fileTipo, "fileTipoId non associato e nessun tipo file valido");
        Boolean verificaFirma = fileTipo.getFileTipoFirmato();
        Boolean result = null;

        CovidusTFile documento = salvaDocumento(shibIdentitaCodiceFiscale, filename, fileType, file);

        CovidrsaRRendicontazioneFile rStrutturaWelfareFile = new CovidrsaRRendicontazioneFile();
        rStrutturaWelfareFile.setFileId(documento.getFileId());
        rStrutturaWelfareFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
        rStrutturaWelfareFile.setRendicontazioneId(rendicontazioneId);
        rStrutturaWelfareFile.setValiditaInizio(validitaInizio);
        rStrutturaWelfareFile.setValiditaFine(validitaFine);
        rStrutturaWelfareFile.setFileTipoId(fileTipoId);
        rStrutturaWelfareFile.setFirmaVerificata(result);

        covidrsaRRendicontazioneFileMapper.insert(rStrutturaWelfareFile);
    }

    private CovidusTFile salvaDocumento(String shibIdentitaCodiceFiscale, String filename, String fileType,
            byte[] file) {

        CovidusTFile covidusTFile = new CovidusTFile();
        covidusTFile.setFileName(filename);
        covidusTFile.setFile(file);
        covidusTFile.setFileType(fileType);
        covidusTFile.setFileSize(BigDecimal.valueOf(file.length));
        covidusTFile.setDataCreazione(new Date());
        covidusTFile.setDataModifica(covidusTFile.getDataCreazione());
        covidusTFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
        covidusTFileMapper.insert(covidusTFile);

        return covidusTFile;
    }

    /**
     * @param shibIdentitaCodiceFiscale
     * @param filename
     * @param file
     * @throws WebApplicationException
     */
    public Boolean verificaFirma(String shibIdentitaCodiceFiscale, String filename, byte[] file,
            Boolean firmaRappresentanteLegale, String cfRappresentanteLegale)
            throws WebApplicationException {

        Attachment attachment = new Attachment();
        attachment.setFileName(filename);
        attachment.setFile(file);
        CallInfo info = new CallInfo();
        info.setApplicationCode("GESTIONESTRUTTURE");
        info.setCaCode("INFOCERT");
        info.setCodiceFiscale(shibIdentitaCodiceFiscale);
        SignVerifyResult res = gateFireService.verificaFirma(attachment, info);
        if (res.getSigner() != null && !res.getSigner().isEmpty()) {
            Signer signer = null;
            for (Signer singleSigner : res.getSigner()) {
                if (singleSigner.getCertificate() != null && singleSigner.getCertificate().getSubject() != null
                        && cfRappresentanteLegale
                                .equals(singleSigner.getCertificate().getSubject().getCodiceFiscale())) {
                    return true;
                } else if (Boolean.TRUE.equals(singleSigner.isValid())) {
                    // ne prendo una valida
                    signer = singleSigner;
                }
            }
            if (signer == null) {
                // proseguo firma valida ma non sappiamo se e' del rappresentante legale
                throw ErroreBuilder.from(Status.NOT_ACCEPTABLE).descrizione("firma non valida per file: " + filename)
                        .exception();
            } else if (Boolean.FALSE.equals(firmaRappresentanteLegale)) {
                // firma valida non del rappresentante legale in caso di boolean a false
                return false;
            } else {
                throw ErroreBuilder.from(Status.NOT_ACCEPTABLE).code("RES_001")
                        .descrizione("firma valida ma non del rappresentante legale per file: " + filename)
                        .exception();
            }
        } else {
            throw ErroreBuilder.from(Status.BAD_REQUEST)
                    .descrizione("firma non trovata per file: " + filename)
                    .exception();
        }
    }

    public String generaHtmlPresaVisione(ModelUtenteContatto utenteContatto, CovidrsaTRendicontazione rend,
            String shibIdentitaCodiceFiscale) {
        CovidrsaRStrutturaWelfareExt result = covidrsaRStrutturaWelfareMapper
                .selectByIdStruttura(rend.getIdStruttura());
        Soggetto soggetto = soggettoMapper.selectByPrimaryKey(Long.valueOf(rend.getIdSoggetto()));

        String html = covidhrCParametroMapper
                .selectParamValueByParamKeyString("covidrsa.rendicontazione.testo.presavisione");

        SimpleDateFormat monthDate = new SimpleDateFormat("MMMM yyyy", Locale.ITALY);

        Map<String, String> replacementStrings = new HashMap<>();

        replacementStrings.put("UTENTEOPERAZIONE",
                utenteContatto.getCognome() + " " + utenteContatto.getNome());
        replacementStrings.put("NOMESTRUTTURA", result.getStrResNome());
        replacementStrings.put("SOGGETTO",
                soggetto.getNome() +
                        " "
                        + soggetto.getCognome() +
                        " "
                        + soggetto.getCodiceFiscale());
        replacementStrings.put("MESEANNOREND", monthDate.format(rend.getDataRendicontazione()));

        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        return sub.replace(html);
    }

    /**
     * @param shibIdentitaCodiceFiscale
     * @param httpHeaders
     * @param methodName
     * @param rend
     * @return
     * @throws IOException
     */
    public ByteArrayInputStream generaPdfPresaVisione(ModelUtenteContatto utenteContatto,
            String shibIdentitaCodiceFiscale, HttpHeaders httpHeaders, String methodName,
            CovidrsaTRendicontazione rend) throws IOException {
        String html = generaHtmlPresaVisione(utenteContatto, rend, shibIdentitaCodiceFiscale);
        try {
            return generaPdfFromHtmlService.generaPdfFromHtml(html);

        } catch (IOException e) {
            logAudit(httpHeaders, "ERRORE", "generaPdfFromHtml",
                    methodName + "ERRORE IN GENERAZIONE PDF PER RENDICONTAZIONE: " + rend.getRendicontazioneId());
            throw e;
        }
    }


    
    /**
     * @param payload
     * @param utenteOperazione
     * @param idStrutturaOperazione
     * @param httpHeaders
     * @param methodName
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void modificaRendicontazione(CovidrsaTRendicontazioneExt payload, String utenteOperazione,
            HttpHeaders httpHeaders, final String methodName) {
        if (payload.getMovimentoOspiteUscita() != null) {
            covidrsaTRendicontazioneMapper.deleteBySoggettoStrutturaAndAfterData(payload.getIdStruttura(),
                    payload.getIdSoggetto(),
                    payload.getDataRendicontazione());
        }

        if (payload.getRendicontazioneId() != null) {
            CovidrsaTRendicontazione oldVal = covidrsaTRendicontazioneMapper
                    .selectByPrimaryKey(payload.getRendicontazioneId());
            Integer oldValMov = oldVal.getMovimentoOspiteIdUscita();
            checkCondition(oldVal.getStatoRendId().equals(payload.getStatoRendId()),
                    "stato rendicontazione id non modificabile");
            checkCondition(oldVal.getIdStruttura().equals(payload.getIdStruttura()),
                    "id struttura non modificabile");
            checkCondition(oldVal.getIdSoggetto().equals(payload.getIdSoggetto()),
                    "id soggetto non modificabile");
            checkCondition(oldVal.getDataRendicontazione().equals(payload.getDataRendicontazione()),
                    "data rendicontazione non modificabile");
            checkCondition(oldVal.getBuonoresId().equals(payload.getBuonoresId()),
                    "buonores id non modificabile");
            
            int res = covidrsaTRendicontazioneMapper.updateValiditaFine(payload);
            checkCondition(res != 0, "rendicontazione da modificare non trovata");
            logAudit(httpHeaders, "update", "covidrsa_t_rendicontazione", methodName);

            if (oldValMov != null) {
                int resMov = covidrsaTMovimentoOspiteMapper.logicDeleteByPrimaryKeyD(oldValMov);
                checkCondition(resMov != 0,
                        "movimento ospite associato a rendicontazione da modificare non trovata");
                logAudit(httpHeaders, "update", "covidrsa_t_movimento_ospite", methodName);
            }

            // Aggiungi la modifica per validita fine a now ed insert
            payload.setRendicontazioneId(null);

            payload.setBuonoresId(oldVal.getBuonoresId());

        }

        if (payload.getMovimentoOspiteUscita() != null) {
            CovidrsaTMovimentoOspite movUscita = payload.getMovimentoOspiteUscita();
            checkNotNull(movUscita.getDataMovimento(), "data movimento obbligatoria");
            checkNotNull(movUscita.getTipoMovOspiteId(), "tipo movimento ospite id obbligatorio");
            CovidrsaDTipoMovOspite tipoMovimento = covidrsaDTipoMovOspiteMapper
                    .selectByPrimaryKey(movUscita.getTipoMovOspiteId());
            checkNotNull(tipoMovimento, "tipo movimento ospite non esistente");
            checkCondition(Boolean.TRUE.equals(tipoMovimento.getFlgUscita()), "movimento inserito non di uscita");

            movUscita.setFlgPreservaPosto(Boolean.FALSE);
            movUscita.setIdSoggetto(payload.getIdSoggetto());
            movUscita.setIdStruttura(payload.getIdStruttura());
            movUscita.setUtenteOperazione(utenteOperazione);
            movUscita.setMovimentoOspiteId(null);

            covidrsaTMovimentoOspiteMapper.insert(movUscita);
            logAudit(httpHeaders, "insert", "covidrsa_t_movimento_ospite",
                    methodName + " movimentoOspiteId: " + movUscita.getMovimentoOspiteId());

            payload.setMovimentoOspiteIdUscita(movUscita.getMovimentoOspiteId());
        }

        covidrsaTRendicontazioneMapper.insert(payload);
        if (payload.getFiles() != null && !payload.getFiles().isEmpty()) {
            for (CovidrsaRRendicontazioneFile file : payload.getFiles()) {
                CovidrsaRRendicontazioneFile oldRRendicontaioneFile = covidrsaRRendicontazioneFileMapper
                        .selectByPrimaryKey(file.getRendicontazioneFileId());
                oldRRendicontaioneFile.setRendicontazioneId(payload.getRendicontazioneId());
                oldRRendicontaioneFile.setRendicontazioneFileId(null);
                covidrsaRRendicontazioneFileMapper.insert(oldRRendicontaioneFile);
            }
        }

        logAudit(httpHeaders, "insert", "covidrsa_t_rendicontazione", methodName);
    }

}
