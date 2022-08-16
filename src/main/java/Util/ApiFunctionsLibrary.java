package Util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ApiFunctionsLibrary {
    public static String sendRequest(String url) throws IOException, InterruptedException {
        var request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static JSONObject convertStringToJson(String url) throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        var responseString = sendRequest(url);
        JSONObject json = XML.toJSONObject(responseString);
        String jsonString = json.toString(4);
        System.out.println(jsonString);
        return json;
    }

    public static Document convertStringToXml() throws IOException, InterruptedException {
       var xmlString = sendRequest("https://boardgamegeek.com/xmlapi/boardgame/342942");

        SAXBuilder sax = new SAXBuilder();
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

        try {

            Document doc = sax.build(new StringReader(xmlString));
            return doc.getDocument();

        } catch (IOException | JDOMException e) {
            throw new RuntimeException(e);
        }

    }

    public static Element readXML(Document doc){
        SAXBuilder sax = new SAXBuilder();
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        Element rootNode = doc.getRootElement();
        List<Element> list = rootNode.getChildren("boardgame");
        List<Element> pollElement = list.get(0).getChildren("poll");
        System.out.println("size of list"+list.size());
        Element finalResultPoll = null;
        for (Element target : pollElement) {
            if (target.getAttributeValue("name").contains("language_dependence")) {
                finalResultPoll = target;
                System.out.println("final Result::"+finalResultPoll);
            }
        }
        return finalResultPoll;
    }

    public Map<String,Integer>  getMaximumCount(String key, Element xmlElement){
        Map<String , Integer> pollResult = new HashMap<String,Integer>();
        Element parentNode = xmlElement.getParentElement();
        List<Element> getChildNode = parentNode.getChildren("results");

        return pollResult;
    }


}

