package org.springframework.social.eventbrite.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class EventbriteXmlDateAdapter extends XmlAdapter<String, Date> {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Override
	public Date unmarshal(String d) throws Exception {
		//Yes this is inefficient...
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);
		return sd.parse(d);
	}

	@Override
	public String marshal(Date d) throws Exception {
		//Yes this is inefficient...
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);
		return sd.format(d);
	}

}
