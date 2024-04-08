/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.integration.gestioneutente.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import it.csi.gescovid.gestruttureresapi.integration.gestioneutente.dto.Message;

public class GestioneUtenteClient {

	private GestioneUtenteClient() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * @param <T>
	 * @param currentUserCf
	 * @param path
	 * @param queryParam
	 * @return
	 * @throws JsonSyntaxException
	 */
	protected static <T> T getResultObject(MultivaluedMap<String, String> header, String path, List<String> queryParam,
			Class<T> neededClass, String basePath, String username, String password) {
		String query = generateQueryParamsString(queryParam);
		String result = getJSON(basePath + "/" + path + query, 10000, username, password, header);
		try {
			return new Gson().fromJson(result, neededClass);
		} catch (JsonSyntaxException e) {
			generateResponse(Status.INTERNAL_SERVER_ERROR, "errore in trascodifica response per verifyUser");
		}
		return null;
	}

	/**
	 * @param queryParam
	 * @return
	 */
	private static String generateQueryParamsString(List<String> queryParam) {
		String query = "";
		StringBuilder queryBuilder = new StringBuilder();
		if (queryParam != null && !queryParam.isEmpty()) {
			queryBuilder.append("?").append(queryParam.remove(0));
			for (String s : queryParam) {
				queryBuilder.append("&").append(s);
			}
			query = queryBuilder.toString();
		}
		return query;
	}

	/**
	 * @param value
	 * @param queryParam
	 * @throws UnsupportedEncodingException
	 */
	protected static <T> void setElementIfExist(T value, List<String> queryParam, String key) {
		String s = setQueryParameterIfExist(value, key);
		if (s != null)
			queryParam.add(s);
	}

	/**
	 * @param webappOperazione
	 * @param queryBuilder
	 * @param key
	 * @throws UnsupportedEncodingException
	 */
	protected static <T> String setQueryParameterIfExist(T value, String key) {
		if (value != null) {

			try {
				if (String.class.isAssignableFrom(value.getClass())) {
					return String.format("%s=%s", key,
							URLEncoder.encode((String) value, StandardCharsets.UTF_8.displayName()));
				} else if (Integer.class.isAssignableFrom(value.getClass())) {
					return String.format("%s=%d", key, ((Integer) value).intValue());
				} else if (Enum.class.isAssignableFrom(value.getClass())) {
					return String.format("%s=%s", key, URLEncoder.encode(((Enum<?>) value).name(),
							StandardCharsets.UTF_8.displayName()));
				} else {
					generateResponse(Status.INTERNAL_SERVER_ERROR,
							"errore in trascodifica parametri per verifyUser, tipologia parametro non esistente");
				}
			} catch (UnsupportedEncodingException e) {
				generateResponse(Status.INTERNAL_SERVER_ERROR, "errore in trascodifica parametri per verifyUser");
			}
		}
		return null;
	}

	private static String getJSON(String url, int timeout, String username, String psw,
			MultivaluedMap<String, String> header) {
		HttpURLConnection c = null;
		String basic = "Basic "
				+ Base64.getEncoder().encodeToString((username + ":" + psw).getBytes(StandardCharsets.UTF_8));

		try {
			URL u = new URL(url);
			c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			if (header != null) {
				for (Entry<String, List<String>> entry : header.entrySet()) {
					if (!entry.getKey().equals("Accept") && !entry.getKey().equals("Authorization") && entry.getValue() != null
							&& !entry.getValue().isEmpty()) {
						c.setRequestProperty(entry.getKey(), String.join(",", entry.getValue()));
					}
				}
			}
			c.setRequestProperty("Content-length", "0");
			c.setUseCaches(false);
			c.setAllowUserInteraction(false);
			c.setConnectTimeout(timeout);
			c.setReadTimeout(timeout);
            c.setRequestProperty("Authorization", basic);
            c.setRequestProperty("Accept", "application/json");
			c.connect();
			int status = c.getResponseCode();

			if (status == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();
				return sb.toString();
			} else if (status == 401 || status == 403 || status == 400) {
				BufferedReader br = new BufferedReader(new InputStreamReader(c.getErrorStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();
				generateResponseFromJson(status, sb.toString());
			} else {
				generateResponse(Status.INTERNAL_SERVER_ERROR, "Errore in verifica dati utente codifica dati");
			}

		} catch (MalformedURLException ex) {
			generateResponse(Status.INTERNAL_SERVER_ERROR, "Errore in verifica dati utente codifica dati");
		} catch (IOException ex) {
			generateResponse(Status.INTERNAL_SERVER_ERROR, "Errore in verifica dati utente transcodifica dati");
		} finally {
			if (c != null) {
				try {
					c.disconnect();
				} catch (Exception ex) {
					generateResponse(Status.INTERNAL_SERVER_ERROR, "Errore in verifica dati utente");
				}
			}
		}
		return null;
	}

	private static void generateResponseFromJson(int status, String string) {
		String message;
		try {
			JSONObject jsonObject = new JSONObject(string);
			message = jsonObject.getString("title");
		} catch (JSONException err) {
			message = string;
		}
		generateResponse(status, message);

	}

	private static void generateResponse(int status, String message) {

		Status statusObj = Status.fromStatusCode(status);
		generateResponse(statusObj, message);
	}

	protected static void generateResponse(Status status, String message) throws WebApplicationException {
		Response resp = Response.status(status).entity(new Message(message)).build();

		throw new WebApplicationException(resp);
	}
}
