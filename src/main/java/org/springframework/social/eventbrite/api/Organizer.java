package org.springframework.social.eventbrite.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

//<organizer>
//<id>65739440</id>
//<name>New Year's NYC Team</name>
//<description>We organizer the best parties in town!</description>
//<url>http://www.eventbrite.com/org/65739440</url>
//</organizer>
@XmlAccessorType(XmlAccessType.FIELD)
public class Organizer {

	private String id;
	private String name;
	private String description;
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
