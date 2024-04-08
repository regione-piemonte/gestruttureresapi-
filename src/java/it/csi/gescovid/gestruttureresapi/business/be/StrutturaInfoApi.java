/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.StrutturaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.StrutturaInfoExt;

@Path("/struttura-info")
@Api(value = "StrutturaInfo", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface StrutturaInfoApi {
	
	@GET
	@GZIP
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = StrutturaInfoExt.class, responseContainer = "List")
	})
	public Response getStruttureInfoByFilter(
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
            
			@QueryParam("natura") String natura,
			@QueryParam("idStruttura") String idStruttura,
			@QueryParam("nomeSti") String nomeSti,
			@QueryParam("idEnte") Integer idEnte,
			@QueryParam("idTipoUtenza") Integer idTipoUtenza,
			@QueryParam("strCategoriaId") Integer strCategoriaId,
			@QueryParam("orderby") String orderby,
			@QueryParam("rowPerPage") Long rowPerPage,
			@QueryParam("pageNumber") Long pageNumber,
			@QueryParam("descendingStr") String descendingStr,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
	@GET
	@Path("/csv")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = StrutturaInfoExt.class, responseContainer = "List")
	})
	public Response getStruttureInfoByFilterCsv(
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
            
			@QueryParam("natura") String natura,
			@QueryParam("idStruttura") String idStruttura,
			@QueryParam("nomeSti") String nomeSti,
			@QueryParam("idEnte") Integer idEnte,
			@QueryParam("idTipoUtenza") Integer idTipoUtenza,
			@QueryParam("strCategoriaId") Integer strCategoriaId,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
	@GET
	@Path("/rilevazioni/csv")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success",  responseContainer = "List")
	})
	public Response getRilevazioniCsv(
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
            
			@QueryParam("tipo") String tipo,
			@QueryParam("dataRilevazioneDa") String dataRilevazioneDa,
			@QueryParam("dataRilevazioneA") String dataRilevazioneA,
			@QueryParam("idStruttura") String idStruttura,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
	@GET
	@GZIP
	@Path("/{id-struttura}")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = StrutturaInfoExt.class)
	})
	public Response getDettaglioStruttureInfo(
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
            
			@PathParam("id-struttura") String idStruttura,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	@PUT
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success")
	})
	public Response aggiornaStrutturaInfo(
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
            
			StrutturaInfo input,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
