package org.springframework.social.eventbrite.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;


public class EventbriteErrorHandler extends DefaultResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		if(super.hasError(response)) {
			return true;
		}
		String content = readFully(response.getBody());
		if (log.isDebugEnabled()) {
			log.debug(content);
		}
		return false;
		
	}
	
	private String readFully(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		while (reader.ready()) {
			sb.append(reader.readLine());
		}
		return sb.toString();
	}
	
	
	private static final Logger log = Logger.getLogger(EventbriteErrorHandler.class);

}
