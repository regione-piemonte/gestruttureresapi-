/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import it.csi.gescovid.gestruttureresapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.gestruttureresapi.dto.custom.EsitoAcquisizioneSpesa;


@Path("/rendicontazione")
@Api(value = "Decorso", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface RendicontazioneBandiApi {
	
	
	@POST
    @Path("/{idDichiarazionespesaBuonodom}/esito-acquisizione")
	@Consumes({ "application/json" })
	public Response postRendicontazioneBandiApi(
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@HeaderParam("User-Agent") String userAgent,
            @PathParam("idDichiarazionespesaBuonodom") String idDichiarazionespesaBuonodom,
            EsitoAcquisizioneSpesa payload, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);


}
