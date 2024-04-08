/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.enumeration;

public enum HeaderEnum {
	
	ROWS_NUMBER("Rows-Number"), 
	CONTENT_DISPOSITION("Content-Disposition");
	
	private final String code;

	private HeaderEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}



}
