package org.springframework.social.eventbrite.api;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlJavaTypeAdapter(value=EventbriteSearchFiltersXmlAdapter.class)
public class Filter {
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	

}
