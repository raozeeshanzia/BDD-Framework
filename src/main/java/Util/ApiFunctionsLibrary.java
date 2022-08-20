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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ApiFunctionsLibrary {
    public static String sendRequest(String url) throws IOException, InterruptedException {
        url =  url.replaceAll(" ", "%20");
        var request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static List<Element> getBroadGameParent(Document doc){
        SAXBuilder sax = new SAXBuilder();
        List<Element> list =  new ArrayList<>();
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        Element rootNode = doc.getRootElement();
        list = rootNode.getChildren("boardgame");
        return list;
    }

    public static String getParentObjectId(Document doc, String name, String year){
        List<Element> element = getBroadGameParent(doc);
        List<Element> allBoardTag = element.get(0).getChildren();
        List<Element> finalResultBoardTag = new ArrayList<>();
        String yearOfPublish ;

        for (Element target : element) {
            String actualName = target.getChildren().get(0).getContent(0).getValue();
            yearOfPublish = target.getChildren().get(1).getContent(0).getValue();
            if (actualName.equals(name) && yearOfPublish.equals(year)) {
                finalResultBoardTag.add(target);
            }
        }

        return finalResultBoardTag.get(0).getAttributeValue("objectid");
    }


    public static JSONObject convertStringToJson(String url) throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        var responseString = sendRequest(url);
        JSONObject json = XML.toJSONObject(responseString);
        String jsonString = json.toString(4);
        return json;
    }

    public static Document convertStringToXml(String url) throws IOException, InterruptedException {
       var xmlString = sendRequest(url);

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

    public static Element pollElement(Document doc){
        List<Element> list = getBroadGameParent(doc);
        List<Element> pollElement = list.get(0).getChildren("poll");
        System.out.println("size of list"+list.size());
        Element finalResultPoll = null;
        for (Element target : pollElement) {
            String attributeValue = target.getAttributeValue("name");
            if (target.getAttributeValue("name").contains("language_dependence")) {
                finalResultPoll = target;
                System.out.println("final Result::"+finalResultPoll);
            }
        }
        return finalResultPoll;
    }

    public static Map<String,String> getMaximumCount(Element xmlElement){
        Map<String , String> pollResult = new HashMap<String,String>();
        //Element parentNode = xmlElement.getParentElement();
        List<Element> getChildNode = xmlElement.getChildren("results");
        List<Element> subChild = getChildNode.get(0).getChildren("result");

        for (Element result:subChild) {
            pollResult.put(result.getAttributeValue("value"),result.getAttributeValue("numvotes"));
        }

        return pollResult;
    }

    // Find the entry with highest value
    public static Map.Entry<String,String> getMaxEntryInMapBasedOnValue(Map<String, String> map)
    {

        // To store the result
        Map.Entry<String, String> entryWithMaxValue = null;
        // Iterate in the map to find the required entry
        for (Map.Entry<String, String> currentEntry :
                map.entrySet()) {

            if (entryWithMaxValue == null
                            || currentEntry.getValue().compareTo(
                            entryWithMaxValue.getValue())
                            > 0) {

                entryWithMaxValue = currentEntry;
            }
        }

        // Return the entry with highest value
        return entryWithMaxValue;
    }

    public static Map<String,String> getObjectIdAndContent(List<Element> xmlElements){
        Map<String , String>  objectIdAndContent= new HashMap<String,String>();
        for (Element xmlElement : xmlElements) {
            String getObjectID = xmlElement.getAttributeValue("objectid");
            String getContent = xmlElement.getContent(0).getValue();
            objectIdAndContent.put(getContent, getObjectID);
        }
        return objectIdAndContent;
    }


    public static List<Element> getAllBroadGameElement(Document doc){
        List<Element> list = getBroadGameParent(doc);
        List<Element> allBoardTag = list.get(0).getChildren();
        List<Element> finalResultBoardTag  = new ArrayList<>();

        for (Element target : allBoardTag) {
            if (target.getName().contains("boardgame")){
                finalResultBoardTag.add(target);
            }
        }
        return finalResultBoardTag;
    }

}

