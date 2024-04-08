/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.mef;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.integration.mef.mef.InterrogaMefCovidRes;
import it.csi.gescovid.gestruttureresapi.integration.mef.mef.InterrogaMefCovidResponseBody;
import it.csi.gescovid.gestruttureresapi.integration.mef.mef.InterrogaMefCovidSoap;
import it.csi.gescovid.gestruttureresapi.integration.mef.mef.InterrogaMefCovid_Service;
import it.csi.gescovid.gestruttureresapi.util.UTPasswordCallback;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MefService extends RESTBaseService {
	
	@Value("${mef.service}")
	private String WS_MEF_SERVICEURL;

	private static final QName SERVICE_NAME = new QName("http://InterrogaMefCovid.central.services.auraws.aura.csi.it",
			"InterrogaMefCovid");

	@Value("${mef.user}")
	private String WS_MEF_USER; 
	
	@Value("${mef.password}")
	private String WS_MEF_PASSWORD; 

	/**
	 * Restituisce l'anagrafica del cittadino
	 * @param cfCittadino
	 * @return
	 * @throws Exception 
	 */
	public InterrogaMefCovidResponseBody getAnagraficaCittadino(String cfCittadino) throws Exception {

		String methodName = "getAnagraficaCittadino | ";

		try {

//			URL wsdlURL = InterrogaMefCovid_Service.WSDL_LOCATION;
			URL wsdlURL = new URL(WS_MEF_SERVICEURL+"?wsdl");

			// costruisco il service
			InterrogaMefCovid_Service ss = new InterrogaMefCovid_Service(wsdlURL, SERVICE_NAME);
			InterrogaMefCovidSoap soap = ss.getInterrogaMefCovidSoap();

			Client client = ClientProxy.getClient(soap);
			
			// timeout
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(3000);
			httpClientPolicy.setReceiveTimeout(3000);
			http.setClient(httpClientPolicy);

			Map<String, Object> outProps = new HashMap<String, Object>();

			outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			outProps.put(WSHandlerConstants.USER, WS_MEF_USER);
			outProps.put(WSHandlerConstants.PW_CALLBACK_REF, new UTPasswordCallback(WS_MEF_USER, WS_MEF_PASSWORD));

			client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));

			InterrogaMefCovidRes interrogaMefCovidReturn = soap.interrogaMefCovid(cfCittadino);

			log.info(methodName, "response: " + interrogaMefCovidReturn.getEsitomef());

			return interrogaMefCovidReturn.getBody();

		} catch (Exception e) {
			log.error(methodName,"Errore nella chiamata a MEF: " + e.getCause() + " - " + e.getMessage());
			throw e;
		}

	}

}
