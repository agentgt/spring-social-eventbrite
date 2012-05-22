package org.springframework.social.eventbrite.api.impl;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.social.eventbrite.api.EventSearchParametersBuilder;
import org.springframework.social.eventbrite.api.EventSearchResults;


public class EventbriteTemplateTest {
	
	private static String clientId;
	//private static String clientSecret;
	private EventbriteTemplate eventbrite;
	
	@BeforeClass
	public static void setUpStatic() throws Exception {
		Properties p = new Properties();
		p.load(EventbriteTemplateTest.class.getResourceAsStream("/eventbrite-test.properties"));
		clientId = p.getProperty("clientId");
		//clientSecret = p.getProperty("clientSecret");
	}
	
	
	@Before
	public void setUp() {
		eventbrite = new EventbriteTemplate(clientId);
	}

	@Test
	public void testSearch() {
		EventSearchResults results = eventbrite.eventOperations()
			.search(EventSearchParametersBuilder.eventSearchParameters()
				.city("Boston")
				.build());
		assertNotNull(results);
	}

}
