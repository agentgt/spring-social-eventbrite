package org.springframework.social.eventbrite.api;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//<event>
//<id>908163459</id>
//<title>Best NYC New Year's Party</title>
//<description>Come spend New Year's Eve with us!</description>
//<category>conferences</category>
//<tags>new year, party</tags>
//<start_date>2008-12-31 20:00:00</start_date>
//<end_date>2009-01-01 06:00:00</end_date>
//<timezone>US/Eastern</timezone>
//<created>2007-11-03 12:47:06</created>
//<modified>2008-01-09 10:12:15</modified>
//<privacy>1</privacy>
//<url>http://nycparty.eventbrite.com</url>
//<logo>http://images.eventbrite.com/logos/908163459.jpg</logo>
//<logo_ssl>https://www.eventbrite.com/php/logo.php?id=908163459.jpg</logo_ssl>
//<venue>
//	<id>1</id>
//	<name>Madison Square Garden</name>
//	<address>4 Penn Plaza</address>
//	<address_2></address_2>
//	<city>New York</city>
//	<region>NY</region>
//	<postal_code>10001</postal_code>
//	<country>United States</country>
//	<country_code>US</country_code>
//	<Lat-Long>47.123 / 3.34</Lat-Long>
//</venue>
//<organizer>
//	<id>65739440</id>
//	<name>New Year's NYC Team</name>
//	<description>We organizer the best parties in town!</description>
//	<url>http://www.eventbrite.com/org/65739440</url>
//</organizer>
//<tickets>
//	<ticket>
//		<id>45264859</id>
//		<name>VIP Registration</name>
//		<description>Access to VIP Rooms</description>
//		<type>0</type>
//		<currency>USD</currency>
//		<price>199.99</price>
//		<start_date>2008-10-24 00:00:00</start_date>
//		<end_date>2008-12-30 23:00:00</end_date>
//		<quantity_available>100</quantity_available>
//		<quantity_sold>0</quantity_sold>
//	</ticket>
//</tickets>
//</event>
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
	
	private String id;
	private String title;
	private String description;
	private String category;
	private String tags;
	
	@XmlJavaTypeAdapter(EventbriteXmlDateAdapter.class)
	@XmlElement(name="start_date")
	private Date startDate;
	
	@XmlJavaTypeAdapter(EventbriteXmlDateAdapter.class)
	@XmlElement(name="end_date")
	private Date endDate;
	
	@XmlElement(name="timezone")
	private String timeZone;
	
	@XmlJavaTypeAdapter(EventbriteXmlDateAdapter.class)
	private Date created;
	
	@XmlJavaTypeAdapter(EventbriteXmlDateAdapter.class)
	private Date modified;
	
	private String privacy;
	private String url;
	private String logo;
	@XmlElement(name="logo_ssl")
	private String logoSSL;
	private Venue venue;
	private Organizer organizer;
	@XmlElementWrapper(name="tickets")
	@XmlElement(name="ticket")
	private List<Ticket> tickets;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogoSSL() {
		return logoSSL;
	}

	public void setLogoSSL(String logoSSL) {
		this.logoSSL = logoSSL;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
