/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.service;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDWelfareFileTipo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRStrutturaWelfareContatti;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaRWelfareFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.FileToBeSaved;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModeleFileWelfare;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaDWelfareFileTipoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareContattiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareFileMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRStrutturaWelfareMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidrsaRWelfareFasciaMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfare;
import it.csi.gescovid.gestruttureresapi.dto.CovidrsaRStrutturaWelfareFile;
import it.csi.gescovid.gestruttureresapi.dto.CovidusTFile;
import it.csi.gescovid.gestruttureresapi.exception.ErroreBuilder;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.GateFireService;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.Attachment;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.CallInfo;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.SignVerifyResult;
import it.csi.gescovid.gestruttureresapi.integration.gatefire.generated.it.csi.gatefire.Signer;

@Service
public class CovidrsaRStrutturaWelfareServiceImpl extends RESTBaseService {

    @Autowired
    private CovidrsaRStrutturaWelfareMapper covidrsaRStrutturaWelfareMapper;

    @Autowired
    private CovidrsaRStrutturaWelfareFileMapper covidrsaRStrutturaWelfareFileMapper;

    @Autowired
    private CovidusTFileMapper covidusTFileMapper;

    @Autowired
    private GateFireService gateFireService;

    @Autowired
    private CovidrsaDWelfareFileTipoMapper covidrsaDWelfareFileTipoMapper;

    @Autowired
    private CovidrsaRWelfareFasciaMapper covidrsaRWelfareFasciaMapper;

    @Autowired 
    private CovidrsaRStrutturaWelfareContattiMapper covidrsaRStrutturaWelfareContattiMapper;
    
    /**
     * @param shibIdentitaCodiceFiscale
     * @param payload
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertStrutturaWelfare(String shibIdentitaCodiceFiscale, CovidrsaRStrutturaWelfareExt payload) {

        CovidrsaRStrutturaWelfareExt oldStrutturaWelfare = covidrsaRStrutturaWelfareMapper
                .selectByIdStruttura(payload.getIdStruttura());
        if (oldStrutturaWelfare != null) {
            oldStrutturaWelfare.setUtenteOperazione(shibIdentitaCodiceFiscale);
            covidrsaRStrutturaWelfareMapper.logicDeletByPrimaryKey(oldStrutturaWelfare);
            List<CovidrsaRStrutturaWelfareFileExt> files = covidrsaRStrutturaWelfareFileMapper
                    .selectByStrWelfareId(oldStrutturaWelfare.getStrWelfareId());
            if (!files.isEmpty()) {
                for (CovidrsaRStrutturaWelfareFile file : files) {
                    file.setUtenteOperazione(shibIdentitaCodiceFiscale);
                    covidrsaRStrutturaWelfareFileMapper.logicDeletByPrimaryKey(file);
                }
            }
            
            List<ModelFascia> fascie = covidrsaRWelfareFasciaMapper.selectByStrWelfareId(oldStrutturaWelfare.getStrWelfareId());
            if (!fascie.isEmpty()) {
                for (ModelFascia modelFascia : fascie) {
                    CovidrsaRWelfareFascia fascia = new CovidrsaRWelfareFascia();
                    fascia.setUtenteOperazione(shibIdentitaCodiceFiscale);
                    fascia.setStrWelfFasciaId(modelFascia.getStrWelfFasciaId());
                    covidrsaRWelfareFasciaMapper.logicDeletByPrimaryKey(fascia);
                }
            }

            CovidrsaRStrutturaWelfareContatti covidrsaRStrutturaWelfareContatti = covidrsaRStrutturaWelfareContattiMapper
                    .selectByStrWelfareId(oldStrutturaWelfare.getStrWelfareId());
            if(covidrsaRStrutturaWelfareContatti != null) {
                covidrsaRStrutturaWelfareContatti.setUtenteOperazione(shibIdentitaCodiceFiscale);
                covidrsaRStrutturaWelfareContattiMapper.logicDeletByPrimaryKey(covidrsaRStrutturaWelfareContatti);
            }
        }

        // invalidare walfare in base alla struttura
        // e di conseguezna walfare id
        payload.setUtenteOperazione(shibIdentitaCodiceFiscale);
        payload.setDataCancellazione(null);
        payload.setDataModifica(null);
        Date validitaInizio = payload.getValiditaInizio();
        if (validitaInizio == null) {
            payload.setValiditaInizio(new Date());
        }
        covidrsaRStrutturaWelfareMapper.insert(payload);
        
        if(payload.getFascia() != null && !payload.getFascia().isEmpty()) {
            for (ModelFascia modelFascia : payload.getFascia()) {
                CovidrsaRWelfareFascia fascia = new CovidrsaRWelfareFascia();
                fascia.setStrWelfareId(payload.getStrWelfareId());
                fascia.setWelfareFasciaId(modelFascia.getWelfareFasciaId());
                fascia.setTariffaMensileMassima(modelFascia.getTariffaMensileMassima());
                fascia.setUtenteOperazione(shibIdentitaCodiceFiscale);
                fascia.setValiditaFine(payload.getValiditaFine());
                fascia.setValiditaInizio(payload.getValiditaInizio());
                covidrsaRWelfareFasciaMapper.insert(fascia);
            }
        }
        
        if (payload.getFiles() != null && !payload.getFiles().isEmpty()) {
            for (FileToBeSaved file : payload.getFiles()) {
                saveFile(payload.getStrWelfareId(), payload.getValiditaInizio(), payload.getValiditaFine(),
                        Boolean.TRUE,
                        shibIdentitaCodiceFiscale, file, payload.getRapLegCodiceFiscale());
            }
        }
        if(payload.getRapLegEmail()!=null) {
            CovidrsaRStrutturaWelfareContatti mail = new CovidrsaRStrutturaWelfareContatti();
            mail.setUtenteOperazione(shibIdentitaCodiceFiscale);
            mail.setStrWelfareId(payload.getStrWelfareId());
            mail.setStrutturaEmail(payload.getRapLegEmail());
            mail.setValiditaFine(payload.getValiditaFine());
            mail.setValiditaInizio(payload.getValiditaInizio());
            covidrsaRStrutturaWelfareContattiMapper.insert(mail);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertStrutturaWelfareFiles(String shibIdentitaCodiceFiscale, String idStrutturaOperazione,
            ModeleFileWelfare payload) {

        // e di conseguezna walfare id
        Date validitaInizio = payload.getValiditaInizio();
        if (validitaInizio == null) {
            payload.setValiditaInizio(new Date());
        }
        if (payload.getFiles() != null && !payload.getFiles().isEmpty()) {
            CovidrsaRStrutturaWelfare strutturaWelfare = covidrsaRStrutturaWelfareMapper
                    .selectByValidPrimaryKey(payload.getStrWelfareId());
            String cfRappresentanteLegale = strutturaWelfare.getRapLegCodiceFiscale();
            for (FileToBeSaved file : payload.getFiles()) {
                saveFile(payload.getStrWelfareId(), payload.getValiditaInizio(), payload.getValiditaFine(),
                        payload.getFirmaRappresentanteLegale(),
                        shibIdentitaCodiceFiscale, file, cfRappresentanteLegale);
            }
        }
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
    private void saveFile(Integer strWelfareId, Date validitaInizio, Date validitaFine,
            Boolean firmaRappresentanteLegale, String shibIdentitaCodiceFiscale, FileToBeSaved file, String cfRappresentanteLegale)
            throws WebApplicationException {
        checkNotNull(file.getFileTipoId(), "fileTipoId obbligatorio");
        CovidrsaDWelfareFileTipo fileTipo = covidrsaDWelfareFileTipoMapper.selectByPrimaryKey(file.getFileTipoId());
        checkNotNull(fileTipo, "fileTipoId non associato e nessun tipo file valido");
        Boolean verificaFirma = fileTipo.getFileTipoFirmato();
        Boolean result = null;
        if (Boolean.TRUE.equals(verificaFirma)) {
            String[] strings = file.getBase64String().split(",");
            checkCondition(strings!=null && strings.length>1, "file: "+file.getFilename()+" file non valido");
            if(strings!=null && strings.length>1) {
                byte[] fileDecoded = Base64.getDecoder().decode(strings[1]);
                result = verificaFirma(shibIdentitaCodiceFiscale, file.getFilename(), fileDecoded,
                        firmaRappresentanteLegale,cfRappresentanteLegale);
            }
                
        }
        CovidusTFile documento = salvaDocumento(shibIdentitaCodiceFiscale, file.getFilename(),
                file.getBase64String());

        CovidrsaRStrutturaWelfareFile rStrutturaWelfareFile = new CovidrsaRStrutturaWelfareFile();
        rStrutturaWelfareFile.setFileId(documento.getFileId());
        rStrutturaWelfareFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
        rStrutturaWelfareFile.setStrWelfareId(strWelfareId);
        rStrutturaWelfareFile.setValiditaInizio(validitaInizio);
        rStrutturaWelfareFile.setValiditaFine(validitaFine);
        rStrutturaWelfareFile.setFileTipoId(file.getFileTipoId());
        rStrutturaWelfareFile.setFirmaVerificata(result);

        covidrsaRStrutturaWelfareFileMapper.insert(rStrutturaWelfareFile);
    }

    private CovidusTFile salvaDocumento(String shibIdentitaCodiceFiscale, String filename, String base64String) {
        CovidusTFile covidusTFile = new CovidusTFile();
        covidusTFile.setFileName(filename);

        String[] strings = base64String.split(",");
        String tipoFile = strings[0];

        String mineType = tipoFile.substring(tipoFile.indexOf(":") + 1, tipoFile.indexOf(";"));

        byte[] file = Base64.getDecoder().decode(strings[1]);
        covidusTFile.setFile(file);
        covidusTFile.setFileType(mineType);
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

}
