/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.csi.gescovid.gestruttureresapi.dto.Errore;
import it.csi.gescovid.gestruttureresapi.exception.ErroreBuilder;

public class CaRet {

	public static Response badRequestResponse() {
		Errore errore = new Errore();
		errore.setCodice(Status.BAD_REQUEST.toString());
		errore.setDescrizione(CaConstants.HTTP_400);
		return Response.status(Status.BAD_REQUEST).entity(errore).build();
	}

	public static Response forbiddenResponse() {
		Errore errore = new Errore();
		errore.setCodice(Status.FORBIDDEN.toString());
		errore.setDescrizione(CaConstants.HTTP_403);
		return Response.status(Status.FORBIDDEN).entity(errore).build();
	}

	public static Response internalServerErrResponse() {
//		Errore errore = new Errore();
//		errore.setCodice(Status.INTERNAL_SERVER_ERROR.toString());
//		errore.setDescrizione(CaConstants.HTTP_500);
		// return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errore).build();

		return ErroreBuilder.from(Status.INTERNAL_SERVER_ERROR).descrizione("Errore imprevisto: contattare l'assistenza tecnica").exception()
				.getResponseBuilder().build();
	}
}
