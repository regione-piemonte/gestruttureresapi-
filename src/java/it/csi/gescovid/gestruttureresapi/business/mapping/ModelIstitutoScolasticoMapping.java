/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.mapping;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.IstitutoScolastico;
import it.csi.gescovid.gestruttureresapi.dto.ModelIstitutoScolastico;

public class ModelIstitutoScolasticoMapping extends BaseMapper<ModelIstitutoScolastico, IstitutoScolastico> {

	@Override
	public IstitutoScolastico to(ModelIstitutoScolastico source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelIstitutoScolastico from(IstitutoScolastico dest) {
		if(dest == null) {
			return null;
		}
		ModelIstitutoScolastico source = new ModelIstitutoScolastico();
	
		source.setIdIstituto(dest.getIdIstituto());
		source.setCodiceIstituto(dest.getCodiceIstituto());
		source.setDenominazioneIstituto(dest.getDenominazioneIstituto());
		source.setIndirizzoIstituto(dest.getIndirizzoIstituto());
		source.setComuneIstituto(dest.getComuneIstituto());
		source.setProvinciaIstituto(dest.getProvinciaIstituto());
		source.setTelIstituto(dest.getTelIstituto());
		source.setOrdineIstituto(dest.getOrdineIstituto());
		return source;
	}

}
