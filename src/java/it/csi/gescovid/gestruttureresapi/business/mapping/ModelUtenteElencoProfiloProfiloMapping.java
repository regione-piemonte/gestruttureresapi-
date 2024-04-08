/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.mapping;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.gestruttureresapi.dto.ModelProfilo;

public class ModelUtenteElencoProfiloProfiloMapping extends BaseMapper<ModelProfilo, Profilo> {

	@Override
	public Profilo to(ModelProfilo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelProfilo from(Profilo dest) {
		if(dest == null) {
			return null;
		}
		
		ModelProfilo source = new ModelProfilo();
		source.setIdProfilo(dest.getIdProfilo()!=null ? dest.getIdProfilo(): 0);
		source.setNomeProfilo(dest.getNomeProfilo()!=null ? dest.getNomeProfilo() : "");
		
		return source;
	}

}
