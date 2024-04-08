/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
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
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTMovimentoOspite;
import it.csi.gescovid.gestruttureresapi.dto.ModelSoggetto;

@Path("/soggetti")
@Api(value = "Soggetti", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface SoggettiApi  {


    @GET
    @Produces({ "application/json" })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
    })
    public Response getSoggettiByStruttRes(
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
            
            @QueryParam("idStrutturaRes") String idStrutturaRes,
            @QueryParam("filter") String filter,
            
            @QueryParam("orderby") String orderby,
            @QueryParam("rowPerPage") Long rowPerPage,
            @QueryParam("pageNumber") Long pageNumber,
            @QueryParam("descending") Boolean descending,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    @GET
    @Path("/rendicontazione")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
    })
    public Response getSoggettiByStruttResRendicontazione(
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
            
            @QueryParam("filter") String filter,
            @QueryParam("idStruttura") String idStruttura,
            
            @QueryParam("orderby") String orderby,
            @QueryParam("rowPerPage") Long rowPerPage,
            @QueryParam("pageNumber") Long pageNumber,
            @QueryParam("descending") Boolean descending,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
//	@GET
//	@Path("/report/xlsx")
//	@Produces({ "application/xlsx" })
//	public Response getSoggettiByRespXlsx(
//			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
//			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
//			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
//			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
//			@HeaderParam("User-Agent") String userAgent, @HeaderParam("idStrutturaRes") Integer idStrutturaRes,
//			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );


	
	@GET
	@Path("/report/xlsx")
	@Produces({ "application/xlsx" })
	public Response getSoggettiByRespXlsx(@Context SecurityContext securityContext, 
            @QueryParam("webappOperazione") String webappOperazione,
            @QueryParam("idProfiloOperazione") Integer idProfiloOperazione,
            @QueryParam("ruoloOperazione") String ruoloOperazione,
            @QueryParam("idEnteOperazione") Integer idEnteOperazione,
            @QueryParam("utenteOperazione") String utenteOperazione,
            @QueryParam("idStrutturaOperazione") String idStrutturaOperazione,
            @QueryParam("idAreaOperazione") Integer idAreaOperazione,
            
			@QueryParam("idStrutturaRes") String idStrutturaRes, 
			@QueryParam("cf") String cf, 
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

//	@GET
//	@Path("/{soggetto_id}")
//	@Produces({ "application/json" })
//	@GZIP
//	@ApiResponses(value = { 
//			@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
//	})
//	public Response soggettiSoggettoIdGet(
//			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
//			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
//			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
//			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
//			@HeaderParam("User-Agent") String userAgent, 
//
//			@PathParam("soggetto_id") Integer soggettoId,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

	@GET
	@Path("/by-cf/{codice_fiscale}")
	@Produces({ "application/json" })
	@GZIP
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
	})
	public Response soggettiSoggettoCfGet(
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

			@PathParam("codice_fiscale") String codiceFiscale,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

	
//	@GET
//	@Path("/list-by-cf/{codice_fiscale}")
//	@Produces({ "application/json" })
//	@GZIP
//	@ApiResponses(value = { 
//			@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class, responseContainer = "List")
//	})
//	public Response listaSoggettiSoggettoCfGet(
//			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
//			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
//			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
//			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
//			@HeaderParam("User-Agent") String userAgent, 
//
//			@PathParam("codice_fiscale") String codiceFiscale,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );


//	@GET
//	@Path("/by-nome-cognome")
//	@Produces({ "application/json" })
//	@GZIP
//	@ApiResponses(value = { 
//			@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
//	})
//	public Response soggettiSoggettoNomeCognomeGet(
//			@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
//			@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
//			@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
//			@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
//			@HeaderParam("User-Agent") String userAgent, 
//
//			@QueryParam("nome") String nome,
//			@QueryParam("cognome") String cognome,
//			@QueryParam("dataNascita") String dataNascita,
//			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
	@GET
	@Path("/list-by-nome-cognome")
	@Produces({ "application/json" })
	@GZIP
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class, responseContainer = "List")
	})
	public Response listaSoggettiByNomeCognomeGet(
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

			@QueryParam("nome") String nome,
			@QueryParam("cognome") String cognome,
			@QueryParam("dataNascita") String dataNascita,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	
	@POST
	@Path("/associa")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success")
	})
	public Response associaSoggettoAStruttura(
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
            
			@HeaderParam("idStrutturaRes") String idStrutturaRes,
			@HeaderParam("idSoggetto") Long idSoggetto,
            @HeaderParam("flgOspite") boolean flgOspite,
            CovidrsaTMovimentoOspite payload,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
	@GET
	@Path("/aggiorna-tipo-sogg")
	@Produces({ "application/json" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success")
	})
	public Response aggiornaTiposoggetto(
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
            
			@HeaderParam("idSoggetto") Long idSoggetto,
			@HeaderParam("idTipoSoggetto") Integer idTipoSoggetto,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
	
    
    @DELETE
    @Path("/elimina-assoc")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success")
    })
    public Response eliminaAssociazioneRes(
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
            
            @HeaderParam("idSoggetto") Long idSoggetto,
            @HeaderParam("idStrutturaRes") String idStrutturaRes,
            @HeaderParam("flgOspite") Boolean flgOspite,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    @POST
    @Path("/elimina-assoc")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success")
    })
    public Response eliminaAssociazioneRes(
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
            
            @HeaderParam("idSoggetto") Long idSoggetto,
            @HeaderParam("idStrutturaRes") String idStrutturaRes,
            @HeaderParam("flgOspite") Boolean flgOspite,
            CovidrsaTMovimentoOspite payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
