/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
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
import javax.ws.rs.core.Response.ResponseBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.csi.gescovid.gestruttureresapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.UpdateStatoRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRRendicontazioneFileExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneExt;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaTRendicontazioneList;
import it.csi.gescovid.gestruttureresapi.enumeration.GeneralLogEnum;

@Path("/rendicontazione")
@Api(value = "rendicontazione", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface RendicontazioneApi {

    @GET
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaTRendicontazioneList.class)
    })
    public Response getRendicontazione(
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

            @QueryParam("dataRendicontazioneDa") String dataRendicontazioneDa,
            @QueryParam("dataRendicontazioneA") String dataRendicontazioneA,
            @QueryParam("filter") String filter,
            @QueryParam("idStruttura") String idStruttura,
            @QueryParam("statoRend") Integer statoRendId,
            
            @QueryParam("orderby") String orderby,
            @QueryParam("rowPerPage") Long rowPerPage,
            @QueryParam("pageNumber") Long pageNumber,
            @QueryParam("descending") Boolean descending,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    @GET
    @Produces({ "text/csv" })
    @Path("/csv")
    public Response getRendicontazioneCsv(
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

            @QueryParam("dataRendicontazioneDa") String dataRendicontazioneDa,
            @QueryParam("dataRendicontazioneA") String dataRendicontazioneA,
            @QueryParam("filter") String filter,
            @QueryParam("idStruttura") String idStruttura,
            @QueryParam("statoRend") Integer statoRendId,
            
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    @POST
    @Produces({ "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post rendicontazione", notes = "inserimento rendicontazione")
    public Response postRendicontazione(
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
            CovidrsaTRendicontazioneExt payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);
    
    @POST
    @Produces({ "application/json" })
    @Path("/stato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post rendicontazione stato", notes = "modifica stati rendicontazione")
    public Response postRendicontazioneStato(
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
            UpdateStatoRendicontazione payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);
    
    @POST
    @Produces({ "application/json" })
    @Path("/file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post rendicontazione", notes = "inserimento rendicontazione")
    public Response postRendicontazioneFile(
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
            CovidrsaRRendicontazioneFileExt payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);

    @POST
    @Produces({ "application/json" })
    @Path("/delete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @io.swagger.annotations.ApiOperation(value = "post rendicontazione", notes = "inserimento rendicontazione")
    public Response deleteRendicontazione(
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
            CovidrsaTRendicontazione payload,
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
            @Context HttpServletRequest httpRequest);
    
    @GET
    @Path("/dichiarazione/{idRendicontazione}")
    @Produces({ "application/pdf" })
    @io.swagger.annotations.ApiOperation(value = "Download pdf rendicontazione", notes = "")
    @io.swagger.annotations.ApiResponses(
            value = { 
                    @io.swagger.annotations.ApiResponse(code = 200, message = "PDF Generato"),
             })  
    public Response printDichiarazioneRendicontazione(
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
            @PathParam("idRendicontazione") Integer stnId, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);
    
    @GET
    @Path("/presavisione/{idRendicontazione}")
    @Produces({ "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Download html presa visione passaggio di stato", notes = "")
    @io.swagger.annotations.ApiResponses(
            value = { 
                    @io.swagger.annotations.ApiResponse(code = 200, message = "PDF Generato"),
             })  
    public Response getHtmlPresaVisione(
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
            @PathParam("idRendicontazione") Integer idRendicontazione, 
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

    @GET
    @Path("/presavisione/{idRendicontazione}/pdf")
    @Produces({ "application/pdf" })
    @io.swagger.annotations.ApiOperation(value = "Download pdf presa visione passaggio di stato", notes = "")
    @io.swagger.annotations.ApiResponses(
            value = { 
                    @io.swagger.annotations.ApiResponse(code = 200, message = "PDF Generato"),
             })  
    public Response getPdfPresaVisione(
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
            @PathParam("idRendicontazione") Integer idRendicontazione, 
            @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);


    @GET
    @Produces({ "application/json" })
    @Path("/bo/lista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CovidrsaTRendicontazioneList.class)
    })
    public Response getRendicontazionePerBo(
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
