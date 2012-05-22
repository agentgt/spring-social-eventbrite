package org.springframework.social.eventbrite.api;


public interface EventOperations {
	
	/*
	 * event_search
event_get
event_new
event_copy
event_update
	 */
	
	public EventSearchResults search(EventSearchParameters parameters);
	

}
