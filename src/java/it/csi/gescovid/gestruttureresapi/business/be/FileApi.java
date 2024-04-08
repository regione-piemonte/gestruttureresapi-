/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.csi.gescovid.gestruttureresapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.gestruttureresapi.dto.custom.FileResponse;

@Path("/file")
@Api(value = "file", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface FileApi {

    @GET
    @Produces({ "application/json" })
    @Path("/{fileId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FileResponse.class)
    })
    public Response getFile(
            @ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
            @ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @HeaderParam("User-Agent") String userAgent,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,

            @PathParam("fileId") Integer fileId,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

}
