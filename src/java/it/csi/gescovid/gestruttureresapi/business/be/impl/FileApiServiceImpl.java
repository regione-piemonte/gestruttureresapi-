/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.xml.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.FileApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.gestruttureresapi.dto.CovidusTFile;
import it.csi.gescovid.gestruttureresapi.dto.custom.FileResponse;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;

public class FileApiServiceImpl extends GestioneUtenteServiceImpl implements FileApi {

    @Autowired
    CovidusTFileMapper covidusTFileMapper;

    @Override
    public Response getFile(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
            String xForwardedFor, String userAgent, String webappOperazione, Integer idProfiloOperazione,
            String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione, String idStrutturaOperazione,
            Integer idAreaOperazione, Integer fileId, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        final String methodName = "getFile: ";
        Response responseError;

        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcLettura(FunzioneEnum.FILE),
                    httpHeaders);
            checkNotNull(fileId, "fileId obbligatorio");

            CovidusTFile file = covidusTFileMapper.selectByPrimaryKey(fileId);
            logAudit(httpHeaders, "select", "covidus_t_file", methodName);
            if (file != null) {
                FileResponse response = new FileResponse();
                response.setFileName(file.getFileName());
                response.setFileSize(file.getFileSize());
                response.setFileType(file.getFileType());
                String fileEncoded = Base64.encode(file.getFile());
                response.setFile(fileEncoded);
                return Response.ok(response).build();
            } else {
                return Response.ok().build();
            }
        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
    }

}
