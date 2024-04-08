/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.gestruttureresapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaCovidMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaDecessiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaPersonaleMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaPostiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaTamponiMapper;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.extended.RsaVisitatoriMapper;

@Service
public class RsaCategorieServiceImpl extends RESTBaseService{
    @Autowired
    private RsaPostiMapper postiMapper;

    @Autowired
    private RsaPersonaleMapper personaleMapper;

    @Autowired
    private RsaDecessiMapper decessiMapper;

    @Autowired
    private RsaTamponiMapper rsaTamponiMapper;

    @Autowired
    private RsaCovidMapper rsaCovidMapper;

    @Autowired
    private RsaVisitatoriMapper rsaVisitatoriMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
    public void checkCategoriaIsCompleted(String idStruttura, Integer strCategoriaId, String shibIdentitaCodiceFiscale,
            Date dataRilevazione) {
        String methodName = "checkCategoriaIsCompleted";
        log.info(methodName, "BEGIN");
        rsaCovidMapper.insertDefaultIfNotPresente(idStruttura, strCategoriaId, dataRilevazione, shibIdentitaCodiceFiscale);
        decessiMapper.insertDefaultIfNotPresente(idStruttura, strCategoriaId, dataRilevazione, shibIdentitaCodiceFiscale);
        personaleMapper.insertDefaultIfNotPresente(idStruttura, strCategoriaId, dataRilevazione, shibIdentitaCodiceFiscale);
        rsaTamponiMapper.insertDefaultIfNotPresente(idStruttura, strCategoriaId, dataRilevazione, shibIdentitaCodiceFiscale);
        rsaVisitatoriMapper.insertDefaultIfNotPresente(idStruttura, strCategoriaId, dataRilevazione, shibIdentitaCodiceFiscale);
        postiMapper.insertDefaultIfNotPresente(idStruttura, strCategoriaId, dataRilevazione, shibIdentitaCodiceFiscale);
        
    }
}
