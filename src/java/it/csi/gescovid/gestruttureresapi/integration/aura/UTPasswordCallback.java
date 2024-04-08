/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.aura;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {
	private Map<String, String> passwords = new HashMap<String, String>();

	public UTPasswordCallback(String user, String password) {
		passwords.put(user, password);
	}

	/**
	 * Add an alias/password pair to the callback mechanism.
	 */
	public void setAliasPassword(String alias, String password) {
		passwords.put(alias, password);
	}

	/**
	 * Here, we attempt to get the password from the private alias/passwords map.
	 */
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

			String pass = passwords.get(pc.getIdentifier());
			if (pass != null) {
				pc.setPassword(pass);
				return;
			}
		}
	}
}

