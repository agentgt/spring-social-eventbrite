package org.springframework.social.eventbrite.api;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="events")
public class EventSearchResults {

	private List<Event> events;
	private EventSearchSummary summary;

	@XmlElement(name="event")
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public EventSearchSummary getSummary() {
		return summary;
	}
	public void setSummary(EventSearchSummary summary) {
		this.summary = summary;
	}

}
