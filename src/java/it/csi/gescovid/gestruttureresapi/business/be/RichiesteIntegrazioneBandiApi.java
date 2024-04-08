/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTIntegrazionePbandi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsarIntegrazionePbandiFile;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTIntegrazionePbandiExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsarIntegrazionePbandiFileSaveFile;

@Path("/richieste-bandi")
@Api(value = "rendicontazione", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface RichiesteIntegrazioneBandiApi {

    @GET
    @Produces({ "application/json" })
    @Path("list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaTIntegrazionePbandiExt.class)
    })
    public Response getRichiesteBandi(
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
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    @GET
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaTIntegrazionePbandiExt.class)
    })
    public Response getRichiestaBandi(
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
            @QueryParam("integrazionePbandiId") Integer integrazionePbandiId,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);
    

    @POST
    @Produces({ "application/json" })
    @Path("/file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post richiesta file", notes = "inserimento file per richiesta")
    public Response postRichiestaFile(
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
            CovidrsarIntegrazionePbandiFileSaveFile payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);
    
    @POST
    @Produces({ "application/json" })
    @Path("/file/delete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post richiesta file", notes = "inserimento file per richiesta")
    public Response deleteRichiestaFile(
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
            CovidrsarIntegrazionePbandiFile payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);


    @POST
    @Produces({ "application/json" })
    @Path("/invia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "inia richiesta bandi", notes = "invio file richiesta bandi")
    public Response inviaRichiestaFile(
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
            CovidrsaTIntegrazionePbandi payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    @GET
    @Produces({ "application/json" })
    @Path("/bo/lista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaTIntegrazionePbandiExt.class)
    })
    public Response getRichiesteBandiPerBo(
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
            @QueryParam("documentoNumero") String documentoNumero,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    
}
