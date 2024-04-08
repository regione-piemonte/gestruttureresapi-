/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.piattaformabandi;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.Message;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.TrasmissioneDocIntegrativaSpesaRequest;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.TrasmissioneDocIntegrativaSpesaResponse;
import it.csi.gescovid.gestruttureresapi.integration.piattaformabandi.dto.DocIntegrativaSpesaResponse;

@Service
public class TrasmissioneDocIntegrativaSpesa extends RESTBaseService {

    @Value("${piattaformabandi.url}")
    private String basicUrl;
    
    @Value("${piattaformabandi.psw}")
    private String basicPsw;
    
    @Value("${piattaformabandi.user}")
    private String basicUser;

    @Value("${gestioneutente.webapp}")
    private String webapp;
    
    private ObjectMapper objectMapper;

    protected TrasmissioneDocIntegrativaSpesa() {
        this.objectMapper = new ObjectMapper();
    }
    
    public TrasmissioneDocIntegrativaSpesaResponse postTrasmissioneDocIntegrativaSpesa(TrasmissioneDocIntegrativaSpesaRequest payload) throws Exception {
        TrasmissioneDocIntegrativaSpesaResponse res = new TrasmissioneDocIntegrativaSpesaResponse();
        ResponseEntity<String> responseEntity = null;
        String methodName = "postTrasmissioneDocIntegrativaSpesa: ";
        try {
            String uuidCall = UUID.randomUUID().toString();
            log.info(methodName, "inizio chiamata uuid: " + uuidCall);
            HttpHeaders headers = new HttpHeaders();
            String basic = "Basic "
                    + Base64.getEncoder().encodeToString((basicUser + ":" + basicPsw).getBytes(StandardCharsets.UTF_8));
            headers.add("Authorization", basic);
            headers.add("x-Request-Id", uuidCall);
            headers.add("Content-Type", "application/json");
            
            StringBuilder url = new StringBuilder(basicUrl).append("/trasmissioneDocumentazioneIntegrativaDocSpesa/setTrasmissioneDocIntegrativaSpesa");

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(payload);
            
            HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
            RestTemplate rest = new RestTemplate();
            
            responseEntity = rest.exchange(url.toString(), HttpMethod.POST, requestEntity, String.class);
            log.info(methodName, "status: " + responseEntity.getStatusCode());
            if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                res.setStatus(responseEntity.getStatusCode());
                res.setDocIntegrativaSpesaResponse(objectMapper.readValue(responseEntity.getBody(), DocIntegrativaSpesaResponse.class));
            } else {
                res.setStatus(responseEntity.getStatusCode());
                res.setErrore(objectMapper.readValue(responseEntity.getBody(), Message.class));
            }
        } catch (HttpClientErrorException e) {
            log.info(methodName, "HttpClientErrorException:" + "statusCode:" + e.getStatusCode() + " errorString:"
                    + e.getResponseBodyAsString());
            throw new Exception(
                    "HttpClientErrorException----" + e.getStatusCode() + "--" + e.getResponseBodyAsString());
        } catch (Exception e) {
            log.info(methodName, "Exception: " + e.getMessage());
            throw e;
        }
        
        return res;
    }



}
