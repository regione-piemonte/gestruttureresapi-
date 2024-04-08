/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.be.impl;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.DecorsoApi;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Sintomo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.DecorsoMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.SintomoMapper;
import it.csi.gescovid.gestruttureresapi.dto.DecorsoSintomo;
import it.csi.gescovid.gestruttureresapi.dto.SoggettoForSegnalazione;
import it.csi.gescovid.gestruttureresapi.dto.util.Message;
import it.csi.gescovid.gestruttureresapi.enumeration.FunzioneEnum;
import it.csi.gescovid.gestruttureresapi.util.CaConstants;

public class DecorsoApiServiceImpl extends GestioneUtenteServiceImpl implements DecorsoApi {
	
	@Autowired
	DecorsoMapper decorsoMapper;
	
	@Autowired
	SintomoMapper sintomoMapper;
	

	private static final Integer ID_TIPO_EVENTO_SEGNALAZIONE =11;  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Response insertSoggettoSegnalazione(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String webappOperazione,
			Integer idProfiloOperazione, String ruoloOperazione, Integer idEnteOperazione, String utenteOperazione,
			String idStrutturaOperazione, Integer idAreaOperazione, SoggettoForSegnalazione soggetto,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
        final String methodName = "insertSoggettoSegnalazione: ";
        Response responseError;
        
        try {
            log.info(methodName, "BEGIN");
            verifyCurrentUserValidate(webappOperazione, idProfiloOperazione, ruoloOperazione, idEnteOperazione,
                    utenteOperazione, idStrutturaOperazione, idAreaOperazione, funcScrittura(FunzioneEnum.DECORSO),
                    httpHeaders);
			
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			ObjectMapper mapper = new ObjectMapper();
			
			
			DecorsoSintomo decorso = soggetto.getDecorso();

			boolean isPazienteConSegnalazione = false;
						
			
			if (decorso!=null && 
					(decorso.getSintomi().equalsIgnoreCase("SI") && decorso.getSintomo()==null))
			{
				log.error(methodName, "Richiesta segnalazione per soggetto ma senza decorso o sintomi");
				Response resp = Response.status(Status.BAD_REQUEST)
						.entity(new Message("E' necessario fornire un decorso di tipo segnalazione con un oggetto sintomi incluso")).build();
				throw new WebApplicationException(resp);
			}
			
			boolean isPazienteConSintomi = false;

			if(decorso!=null)
				isPazienteConSegnalazione = true;
			
			if(decorso !=null && decorso.getSintomi().equalsIgnoreCase("SI") && decorso.getSintomo()!=null)
				isPazienteConSintomi = true;
				
			
			if (isPazienteConSegnalazione)
			{		
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.clear(Calendar.MINUTE);
				calendar.clear(Calendar.SECOND);
				calendar.clear(Calendar.MILLISECOND);
				Date dataOra = calendar.getTime();
		        
				decorso.setIdTipoEvento(ID_TIPO_EVENTO_SEGNALAZIONE);
				decorso.setDataDimissioni(dataOra);
				decorso.setDataEvento(new Date());
				//Check sintomi e condizioni cliniche 
				decorso.setIdSoggetto(soggetto.getIdSoggetto());
				decorsoMapper.insert(decorso);
				logAudit(httpHeaders, "insert", "decorso", mapper.writeValueAsString(decorso));
				if(isPazienteConSintomi) {
					Sintomo sintomo = decorso.getSintomo();
					if (sintomo!=null){
							sintomo.setIdDecorso(decorso.getIdDecorso());
							sintomoMapper.insert(sintomo);
							logAudit(httpHeaders, "insert", "sintomo", mapper.writeValueAsString(sintomo));
					}
				}
				
			}else log.info(methodName,"Inserimento soggetto senza DECORSO e SINTOMO");
				
			
			return Response.ok().entity(soggetto).build();

        } catch (Exception e) {
            responseError = generalExceptionReturn(methodName, e);
        }

        return responseError;
	}	
}
