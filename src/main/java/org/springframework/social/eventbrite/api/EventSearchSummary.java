package org.springframework.social.eventbrite.api;

import java.util.Map;

public class EventSearchSummary {

	private Map<String, Object> filters;
	private String firstEvent;
	private String lastEvent;
	private Integer totalItems;

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
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
