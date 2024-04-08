/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.service;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.core.HttpHeaders;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.SoggettoStrutturaInfo;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.generated.SoggettoStrutturaInfoMapper;

@Service
public class SoggettoServiceImpl extends RESTBaseService {


    @Autowired
    private SoggettoStrutturaInfoMapper ssiMapper;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
    public void associaSoggettoAStrutturaRes(String shibIdentitaCodiceFiscale, HttpHeaders httpHeaders, String methodName,
            Date now,  Long idSoggetto, String idStrutturaRes, boolean flgOspite) throws IOException {

        SoggettoStrutturaInfo ssi = new SoggettoStrutturaInfo();

        ssi.setDataCreazione(now);
        ssi.setDataModifica(now);
        ssi.setUtenteOperazione(shibIdentitaCodiceFiscale);
        ssi.setValiditaInizio(now);
        ssi.setIdSoggetto(idSoggetto.intValue());
        ssi.setIdStruttura(idStrutturaRes);
        ssi.setFlgOspite(flgOspite);
        ssiMapper.insert(ssi);  

        ObjectMapper mapper = new ObjectMapper();
        logAudit(httpHeaders, "insert", "covidres_r_soggetto_struttura_info", mapper.writeValueAsString(ssi));  

    }
}
