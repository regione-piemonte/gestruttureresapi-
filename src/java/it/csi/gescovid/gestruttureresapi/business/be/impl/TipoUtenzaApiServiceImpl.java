/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.gestruttureresapi.business.be.TipoUtenzaApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.TipoUtenza;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.TipoUtenzaMapper;
import it.csi.gescovid.gestruttureresapi.exception.RESTException;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;
import it.csi.gescovid.gestruttureresapi.util.CaRet;

public class TipoUtenzaApiServiceImpl extends RESTBaseService implements TipoUtenzaApi {
	
	@Autowired
	private TipoUtenzaMapper tipoUtenzaMapper;
	

	@Override
	public Response getTipiUtenze(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		String methodName = "getTipiUtenze";
		log.info(methodName, "BEGIN");


		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
		
			List<TipoUtenza> tipi= tipoUtenzaMapper.selectAllValid();

			logAudit(httpHeaders, "select", "covidrsa_d_tipo_utenza", methodName);


			return Response.ok(tipi).build();


		} catch (RESTException e) {
			log.error(methodName, " ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}
	
	

}
