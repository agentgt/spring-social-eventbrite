package org.springframework.social.eventbrite.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.eventbrite.api.EventOperations;
import org.springframework.social.eventbrite.api.EventSearchParameters;
import org.springframework.social.eventbrite.api.EventSearchResults;


public class EventTemplate extends AbstractEventbriteOperations implements EventOperations {

	public EventTemplate(EventbriteTemplate eventbrite, boolean authorized) {
		super(eventbrite, authorized);
	}

	@Override
	public EventSearchResults search(EventSearchParameters p) {
		
		Map<String, String> m = new HashMap<String, String>();
		mput(m, "keywords", p.getKeywords());
		mput(m,"categories", p.getCategories());
		mput(m,"address", p.getAddress());
		mput(m,"city", p.getCity());
		mput(m,"region", p.getRegion());
		mput(m,"postal_code", p.getPostalCode());
		mput(m,"country", p.getCountry());
		mput(m,"within", p.getWithIn());
		mput(m,"within_unit", p.getWithInUnit());
		mput(m,"latitude", p.getLatitude());
		mput(m,"longitude", p.getLongitude());
		mput(m,"date", p.getDate());
		mput(m,"date_created", p.getDateCreated());
		mput(m,"date_modified", p.getDateModified());
		mput(m,"organizer", p.getOrganizer());
		mput(m,"max", p.getMax());
		mput(m,"count_only", p.getCountOnly());
		mput(m,"sort_by", p.getSortBy());
		mput(m,"page", p.getPage());
		mput(m,"tracking_link", p.getTrackingLink());
		
		return get(buildUri("event_search", m), EventSearchResults.class);
	}
	


}
