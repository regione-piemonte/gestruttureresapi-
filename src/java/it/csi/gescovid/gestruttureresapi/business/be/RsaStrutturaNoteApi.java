/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.annotations.GZIP;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.csi.gescovid.gestruttureresapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.RsaStrutturaNote;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.RsaStrutturaNoteExt;

@Path("/rsa-struttura-note")
@Api(value = "RsaStrutturaNote", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface RsaStrutturaNoteApi {
	
	@GET
	@GZIP
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = RsaStrutturaNoteExt.class, responseContainer = "List")
	})
	public Response getRsaStrutturaNote(
			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
			@HeaderParam("User-Agent") String userAgent, 
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
	@GET
	@Path("/csv")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = RsaStrutturaNoteExt.class, responseContainer = "List")
	})
	public Response getRsaStrutturaNoteCsv(
			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
			@HeaderParam("User-Agent") String userAgent, 
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	@GET
	@GZIP
	@Path("/{stn_id}")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = RsaStrutturaNote.class)
	})
	public Response getDettaglioRsaStrutturaNote(
			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
			@HeaderParam("User-Agent") String userAgent, 
			@PathParam("stn_id") Integer stnId,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	@POST
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = RsaStrutturaNote.class)
	})
	public Response inserisciRsaStrutturaNote(
			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
			RsaStrutturaNote input,
			@HeaderParam("User-Agent") String userAgent, 
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	@PUT
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = RsaStrutturaNote.class)
	})
	public Response aggiornaRsaStrutturaNote(
			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
			RsaStrutturaNote input,
			@HeaderParam("User-Agent") String userAgent, 
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	@PUT
	@Path("/cancella")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = RsaStrutturaNote.class)
	})
	public Response cancellaRsaStrutturaNote(
			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
			RsaStrutturaNote input,
			@HeaderParam("User-Agent") String userAgent, 
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	

}
