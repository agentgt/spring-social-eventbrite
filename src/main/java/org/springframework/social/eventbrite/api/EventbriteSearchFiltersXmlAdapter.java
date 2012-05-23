package org.springframework.social.eventbrite.api;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class EventbriteSearchFiltersXmlAdapter extends XmlAdapter<Element, Filter> {
 
    private DocumentBuilder documentBuilder;
 
    private DocumentBuilder getDocumentBuilder() throws Exception {
        // Lazy load the DocumentBuilder as it is not used for unmarshalling.
        if (null == documentBuilder) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();
        }
        return documentBuilder;
    }
 
    @Override
    public Element marshal(Filter f) throws Exception {
        if (null == f) {
            return null;
        }
 
 
        // 2.  Marshal the JAXBElement to a DOM element.
        Document document = getDocumentBuilder().newDocument();
        Element root = document.createElement(f.getName());
        root.setTextContent(f.getValue());
        document.appendChild(root);

        return root;
    }
 
	@Override
	public Filter unmarshal(Element element) throws Exception {
		if (null == element) {
			return null;
		}
		Filter f = new Filter();
		f.setName(element.getTagName());
		f.setValue(element.getTextContent());
		return f;
	}
 
}