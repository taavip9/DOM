package dragons;

import dragons.objects.Game;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class Weather {

    //Get weather in XML and extraxt the "code" node value
    static String getWeather() throws ParserConfigurationException, IOException, SAXException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL("http://www.dragonsofmugloar.com/weather/api/report/"
                + Game.getGameId()).openStream());
        NodeList nodeList = doc.getElementsByTagName("code");
        return nodeList.item(0).getTextContent();
    }
}
