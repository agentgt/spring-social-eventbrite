package org.springframework.social.eventbrite.api;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;


public class Filters {
	private List<Filter> filters;

	@XmlAnyElement
	public List<Filter> getFilters() {
		return filters;
	}	
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

}
