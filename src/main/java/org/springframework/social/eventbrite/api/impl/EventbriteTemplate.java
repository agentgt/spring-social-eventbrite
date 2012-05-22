package org.springframework.social.eventbrite.api.impl;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.social.eventbrite.api.EventOperations;
import org.springframework.social.eventbrite.api.Eventbrite;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;


public class EventbriteTemplate extends AbstractOAuth2ApiBinding implements Eventbrite {

	private String accessToken;
	private String clientId;
	private EventOperations eventOperations;
	

	public EventbriteTemplate(String clientId) {
		super();
		initialize(clientId);
	}


	public EventbriteTemplate(String clientId, String accessToken) {
		super(accessToken);
		initialize(clientId);
		this.accessToken = accessToken;
		
	}

	@Override
	public EventOperations eventOperations() {
		return this.eventOperations;
	}
	
	// private helpers
	private void initialize(String clientId) {
		this.clientId = clientId;
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}
	
	private void initSubApis() {
		this.eventOperations = new EventTemplate(this, isAuthorized());

	}
	
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new EventbriteErrorHandler());
	}
	
	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = super.getMessageConverters();
		converters.add(new Jaxb2RootElementHttpMessageConverter());
		return converters;
	}


	public URIBuilder withAppKey(String uri) {
		return (accessToken == null) 
			? URIBuilder.fromUri(uri).queryParam("app_key", clientId)
			: URIBuilder.fromUri(uri);
	}

}
