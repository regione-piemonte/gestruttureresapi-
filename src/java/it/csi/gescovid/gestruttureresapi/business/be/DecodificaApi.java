/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaDCondizioniOspite;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaDTipoMovOspiteExt;


@Path("/decodifica")
@Api(value = "ente", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface DecodificaApi {

    @GET
    @Path("/welfare-fascia")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Ente.class, responseContainer = "List")
    })
    public Response getWelfareFascia(
            @ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
            @ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @HeaderParam("User-Agent") String userAgent,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    @GET
    @Path("/stato-rendicontazione")
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Ente.class, responseContainer = "List")
    })
    public Response getStatoRendicontazione(
            @ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
            @ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @HeaderParam("User-Agent") String userAgent,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    @GET
    @Path("/tipo-mov-ospite")
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaDTipoMovOspiteExt.class, responseContainer = "List")
    })
    public Response getTipoMovimentoOspite(
            @ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
            @ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @HeaderParam("User-Agent") String userAgent,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    @GET
    @Path("/condizione-ospite")
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaDCondizioniOspite.class, responseContainer = "List")
    })
    public Response getCondizioneOspite(
            @ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
            @ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @HeaderParam("User-Agent") String userAgent,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );


}
