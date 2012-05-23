package org.springframework.social.eventbrite.api;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

import java.io.StringWriter;

import javax.xml.bind.JAXB;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;


public class EventSearchResultsTest {

	@Before
	public void setUp() throws Exception {}

	@Test
	public void testSerialization() throws Exception {
		XMLUnit.setIgnoreWhitespace(true);
		
		EventSearchResults r = 
				JAXB.unmarshal(getClass().getResourceAsStream("/EventSearchResults.xml"), 
						EventSearchResults.class);
		StringWriter sw = new StringWriter();
		JAXB.marshal(r, sw);
		String expected = 
				IOUtils.toString(getClass().getResourceAsStream("/EventSearchResults.xml"), "UTF-8");
		String actual = sw.toString();
		//System.out.println(expected);
		System.out.println(actual);
		assertXMLEqual(expected, actual);
		
		
	}
	
	
	private static final Logger log = Logger.getLogger(EventSearchResultsTest.class);

}
