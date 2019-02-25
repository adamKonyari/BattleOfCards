package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public Document getDoc(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xmlPath);
        doc.getDocumentElement().normalize();

        return doc;
    }

    public Card CardParser(Document doc) {
        Card card = null;
        NodeList nodeList = doc.getElementsByTagName("Hero");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);
            Element tempElement = (Element) tempNode;
            card = new Card(tempElement.getAttribute("name"),tempElement.getAttribute("game"),
                Integer.parseInt(tempElement.getAttribute(("strength"))),Integer.parseInt(tempElement.getAttribute(("endurance"))),
                Integer.parseInt(tempElement.getAttribute(("intelligence"))),Integer.parseInt(tempElement.getAttribute(("vitality"))));

        }
        return card;
    }
}
