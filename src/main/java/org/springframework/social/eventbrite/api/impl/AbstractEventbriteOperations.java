package org.springframework.social.eventbrite.api.impl;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.eventbrite.api.ParameterEnum;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;


public abstract class AbstractEventbriteOperations {
	
	private final boolean authorized;
	private final EventbriteTemplate eventbrite;
	
	public AbstractEventbriteOperations(EventbriteTemplate eventbrite, boolean authorized) {
		super();
		this.authorized = authorized;
		this.eventbrite = eventbrite;
	}
	
	protected <T> T get(URI uri, Class<T> responseType) {
		return eventbrite.getRestTemplate().getForObject(uri, responseType);
	}
	
	protected <C> C post(URI uri, MultiValueMap<String,Object> data,  Class<C> responseType) {
	    MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<String, Object>(data);
	    return eventbrite.getRestTemplate().postForObject(uri, requestData, responseType);
	}
	
	protected void delete(URI uri) {
		eventbrite.getRestTemplate().delete(uri);
	}
	
	protected void requireUserAuthorization() {
		if(!authorized) {
			throw new MissingAuthorizationException();
		}
	}
	
	protected URI buildUri(String path) {
		return buildUri(path, Collections.<String, String>emptyMap());
	}
	
	protected URI buildUri(String path, Map<String, String> params) {
		URIBuilder uriBuilder = eventbrite.withAppKey(API_URL_BASE_XML + path);

		for (String paramName : params.keySet()) {
			uriBuilder.queryParam(paramName, String.valueOf(params.get(paramName)));
		}
		URI uri = uriBuilder.build();
		return uri;
	}
	
	protected void mput(Map<String, String> m, String k, String value) {
		if (value != null)
			m.put(k, value);
	}
	protected void mput(Map<String, String> m, String k, Collection<String> value) {
		if (value != null &&  ! value.isEmpty())
			m.put(k, StringUtils.collectionToCommaDelimitedString(value));
	}
	
	protected void mput(Map<String, String> m, String k, ParameterEnum value) {
		if (value != null)
			m.put(k, value.getParameterName());
	}

	protected void mput(Map<String, String> m, String k, Number value) {
		mputDefault(m, k, value);
	}
	
	protected void mput(Map<String, String> m, String k, Boolean value) {
		mputDefault(m, k, value);
	}
	
	protected void mputDefault(Map<String, String> m, String k, Object value) {
		if (value != null)
			m.put(k, value.toString());
	}
	
	private static final String API_URL_BASE = "https://www.eventbrite.com/";
	private static final String API_URL_BASE_XML = API_URL_BASE + "xml/";	

}
