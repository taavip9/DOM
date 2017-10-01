package dragons;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Weather {

    static void getWeather() throws ParserConfigurationException, IOException, SAXException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL("http://www.dragonsofmugloar.com/weather/api/report/"
                +Game.getGameId()).openStream());
        NodeList rrr = doc.getElementsByTagName("code");
        for (int i = 0; i!=rrr.getLength();i++){
            System.out.println(rrr.item(i).getTextContent());
        }
    }
}
