/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.exception;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import it.csi.gescovid.gestruttureresapi.dto.Dettaglio;
import it.csi.gescovid.gestruttureresapi.dto.Errore;
import it.csi.gescovid.gestruttureresapi.enumeration.DetailChiaviEnum;


public class ErroreBuilder {
	private Errore errore;
	private int status;

	public static ErroreBuilder from(Status s) {
		return new ErroreBuilder()
				.status(s.getStatusCode())
				.code(s.name());
	}
	
	public static ErroreBuilder from(Status s, String messaggio) {
		return new ErroreBuilder()
				.status(s.getStatusCode())
				.code(messaggio);
	}

	public static ErroreBuilder from(int status, String code) {
		return new ErroreBuilder()
				.status(status)
				.code(code);
	}

	private ErroreBuilder() {
		this.errore = new Errore();
	}

	public ErroreBuilder status(int status) {
		errore.setCodice("" + status);
		this.status = status;
		return this;
	}

	public ErroreBuilder code(String code) {
		errore.setCodice(code);
		return this;
	}

	public ErroreBuilder descrizione(String title) {
		errore.setDescrizione(title);
		return this;
	}

    
    public ErroreBuilder dettaglio(DetailChiaviEnum chiave, String valore) {
        Dettaglio dettaglio = new Dettaglio();
        dettaglio.setChiave(chiave.getCode());
        dettaglio.setValore(valore);
        return dettaglio(dettaglio);
    }
    
    

    private ErroreBuilder dettaglio(Dettaglio dettaglio) {
        if(errore.getDetail()==null) {
            errore.setDetail(new ArrayList<>());
        }
        errore.getDetail().add(dettaglio);
        return this;
    }


	public Errore build() {
		return this.errore;
	}

	public RESTException exception() {
		return new RESTException(this.status,  MediaType.APPLICATION_JSON_TYPE, this.errore, errore.toString());
	}
	
	public RESTException exception(String message) {
		return new RESTException(this.status,  MediaType.APPLICATION_JSON_TYPE, this.errore, message);
	}

}
