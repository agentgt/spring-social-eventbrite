package org.springframework.social.eventbrite.api;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Event Search Parameters</h1>
 * <table class="zebra-stripped">
 * <thead>
 * <tr>
 * <th style="width:100px;">Name</th>
 * <th>description</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td>keywords</td>
 * <td>The search keywords. To run an OR search, you need this format:<br>
 * “keywords=google%20OR%20multimedia”</td>
 * </tr>
 * <tr>
 * <td>category</td>
 * <td>Event categories (comma seperated): conference, conventions,
 * entertainment, fundraisers, meetings, other, performances, reunions, sales,
 * seminars, social, sports, tradeshows, travel, religion, fairs, food, music,
 * recreation.</td>
 * </tr>
 * <tr>
 * <td>address</td>
 * <td>The venue address.</td>
 * </tr>
 * <tr>
 * <td>city</td>
 * <td>The venue city.</td>
 * </tr>
 * <tr>
 * <td>region</td>
 * <td>The venue state/province/county/territory depending on the country.
 * 2-letter state code is required for US addresses.</td>
 * </tr>
 * <tr>
 * <td>postal_code</td>
 * <td>The postal/zip code of the venue.</td>
 * </tr>
 * <tr>
 * <td>country</td>
 * <td>2-letter country code, according to the <a href=
 * "http://www.iso.org/iso/country_codes/iso_3166_code_lists/english_country_names_and_code_elements.htm"
 * >ISO 3166</a> format.</td>
 * </tr>
 * <tr>
 * <td>within</td>
 * <td>If “within” is set and the “city” or “zipcode” resolve to a specific
 * geolocation, the search will be restricted to the specified within radius.
 * The sorting default will be set to “distance”.</td>
 * </tr>
 * <tr>
 * <td>within_unit</td>
 * <td>If within is set, you can specify the unit to use: “M” for miles, or “K”
 * for kilometers. By default, the API will use miles.</td>
 * </tr>
 * <tr>
 * <td>latitude</td>
 * <td>If “within” is set you can limit your search to wgs84 coordinates
 * (latitude, Longitude).</td>
 * </tr>
 * <tr>
 * <td>longitude</td>
 * <td>If “within” is set you can limit your search to wgs84 coordinates
 * (latitude, Longitude).</td>
 * </tr>
 * <tr>
 * <td>date</td>
 * <td>The event start date. Limit the list of results to a date range,
 * specified by a label or by exact dates. Currently supported labels include:
 * “All”, “Future”, “Past”, “Today”, “Yesterday”, “Last Week”, “This Week”,
 * “Next week”, “This Month”, “Next Month” and months by name, e.g. “October”.
 * Exact date ranges take the form “YYYY-MM-DD YYYY-MM-DD”, e.g. “2008-04-25
 * 2008-04-27″.</td>
 * </tr>
 * <tr>
 * <td>date_created</td>
 * <td>The date range the event was created, specified by a label or by exact
 * dates. Currently supported labels include: “Today”, “Yesterday”, “Last Week”,
 * “This Week”, “This Month”. Exact date ranges take the form “YYYY-MM-DD
 * YYYY-MM-DD”, e.g. “2008-04-25 2008-04-27″.</td>
 * </tr>
 * <tr>
 * <td>date_modified</td>
 * <td>The date the event was last modified, specified by a label or by exact
 * dates. Currently supported labels include: “Today”, “Yesterday”, “Last Week”,
 * “This Week”, “This Month”. Exact date ranges take the form “YYYY-MM-DD
 * YYYY-MM-DD”, e.g. “2008-04-25 2008-04-27″.</td>
 * </tr>
 * <tr>
 * <td>organizer</td>
 * <td>The organizer name.</td>
 * </tr>
 * <tr>
 * <td>max</td>
 * <td>Limit the number of events returned. Maximum limit is 100 events per
 * page. Default is 10.</td>
 * </tr>
 * <tr>
 * <td>count_only</td>
 * <td>Only return the total number of events (“true” or “false”). Default is
 * “false”.</td>
 * </tr>
 * <tr>
 * <td>sort_by</td>
 * <td>Sort the list of events by “id”, “date”, “name”, “city”. The default is
 * “date”.</td>
 * </tr>
 * <tr>
 * <td>page</td>
 * <td>Allows for paging through the results of a query. Default is 1.</td>
 * </tr>
 * <tr>
 * <td>since_id</td>
 * <td>Returns events with id greater than “since_id” value. Default is 1.</td>
 * </tr>
 * <tr>
 * <td>tracking_link</td>
 * <td>The <a
 * href="http://www.eventbrite.com/t/how-to-create-affiliate-links">tracking
 * link</a> code to add to the event URLs.</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * @author agent
 * 
 */
public class EventSearchParameters {

	private List<String> keywords = new ArrayList<String>();
	private List<String> categories = new ArrayList<String>();
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private Boolean withIn;
	private WithInUnit withInUnit = WithInUnit.MILES;
	private Double latitude;
	private Double longitude;
	private String date;
	private String dateCreated;
	private String dateModified;
	private String organizer;
	private Integer max;
	private Boolean countOnly;
	private SortBy sortBy;
	private Integer page;
	private String trackingLink;

	public static enum SortBy implements ParameterEnum {

		ID("id"), DATE("date"), NAME("name"), CITY("city");

		private String parameterName;

		private SortBy(String parameterName) {
			this.parameterName = parameterName;
		}
		public String getParameterName() {
			return parameterName;
		}
	}

	public static enum WithInUnit implements ParameterEnum {

		MILES("M"), KILOMETERS("K");

		private String parameterName;

		private WithInUnit(String parameterName) {
			this.parameterName = parameterName;
		}
		public String getParameterName() {
			return parameterName;
		}

	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getWithIn() {
		return withIn;
	}

	public void setWithIn(boolean withIn) {
		this.withIn = withIn;
	}

	public WithInUnit getWithInUnit() {
		return withInUnit;
	}

	public void setWithInUnit(WithInUnit withInUnit) {
		this.withInUnit = withInUnit;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public void setWithIn(Boolean withIn) {
		this.withIn = withIn;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Boolean getCountOnly() {
		return countOnly;
	}

	public void setCountOnly(Boolean countOnly) {
		this.countOnly = countOnly;
	}

	public SortBy getSortBy() {
		return sortBy;
	}

	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getTrackingLink() {
		return trackingLink;
	}

	public void setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
	}

}
