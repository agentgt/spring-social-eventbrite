package org.springframework.social.eventbrite.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class EventSearchSummary {

	private Filters filters;
	@XmlElement(name="first_event")
	private String firstEvent;
	@XmlElement(name="last_event")
	private String lastEvent;
	@XmlElement(name="total_items")
	private Integer totalItems;


	public Filters getFilters() {
		return filters;
	}
	public void setFilters(Filters filters) {
		this.filters = filters;
	}

	public String getFirstEvent() {
		return firstEvent;
	}

	public void setFirstEvent(String firstEvent) {
		this.firstEvent = firstEvent;
	}

	public String getLastEvent() {
		return lastEvent;
	}

	public void setLastEvent(String lastEvent) {
		this.lastEvent = lastEvent;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

}
