/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import it.csi.gescovid.gestruttureresapi.dto.custom.DichiarazioneValidazioneRequest;
import it.csi.gescovid.gestruttureresapi.dto.custom.IntegrazioneSpesaWrap;


@Path("/domanda")
@Api(value = "Domanda", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface MovimentoApi {

    @POST
    @Path("/{numeroDomanda}/dichiarazione/validazione")
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post domanda stato", notes = "aggiornamento stato rendicontazione")
    public Response postDichiarazioneValidazione(
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @HeaderParam("User-Agent") String userAgent,
            @PathParam("numeroDomanda") String numeroDomanda,
            DichiarazioneValidazioneRequest payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    @POST
    @Path("/{numeroDomanda}/dichiarazione/integrazione")
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post domanda integrazione", notes = "aggiungo integrazione per domanda")
    public Response postDichiarazioneIntegrazione(
            @ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
            @HeaderParam("User-Agent") String userAgent,
            @PathParam("numeroDomanda") String numeroDomanda,
            IntegrazioneSpesaWrap payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

}
