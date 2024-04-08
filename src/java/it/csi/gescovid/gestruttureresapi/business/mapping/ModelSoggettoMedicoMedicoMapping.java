/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.mapping;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.gestruttureresapi.dto.ModelSoggettoMedico;

public class ModelSoggettoMedicoMedicoMapping extends BaseMapper<ModelSoggettoMedico, Medico> {

	@Override
	public Medico to(ModelSoggettoMedico source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoMedico from(Medico dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoMedico source = new ModelSoggettoMedico();
		source.setCfMedico(dest.getCfMedico() != null ? dest.getCfMedico(): "");
		source.setNome(dest.getNome() !=null ? dest.getNome(): "");
		source.setNome(dest.getCognome() !=null ? dest.getCognome(): "");
		source.setCodiceReg(dest.getCodiceReg() !=null ? dest.getCodiceReg(): "");
		
		return source;
		
	}

}
