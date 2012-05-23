package org.springframework.social.eventbrite.api;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="events")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventSearchResults {

	private EventSearchSummary summary;
	
	@XmlElement(name="event")
	private List<Event> events;
	
	public EventSearchSummary getSummary() {
		return summary;
	}
	public void setSummary(EventSearchSummary summary) {
		this.summary = summary;
	}
	
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
