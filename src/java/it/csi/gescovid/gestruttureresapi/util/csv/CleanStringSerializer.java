/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.util.csv;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class CleanStringSerializer extends ToStringSerializer {

	private static final long serialVersionUID = 1L;
	


	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		 gen.writeString(((String) value).replaceAll("[\\t\\n\\r]+"," "));
	}

}
