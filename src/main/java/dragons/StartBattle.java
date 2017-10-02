package dragons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.xml.sax.SAXException;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class StartBattle {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        /*String aaas = "{\"gameId\":7004253,\"knight\":{\"name\":\"Sir. Johnny Ruiz of Alberta\",\"attack\":0,\"armor\":6,\"agility\":7,\"endurance\":7}}";
        Game a = new ObjectMapper().readValue(aaas, Game.class);
        System.out.println(a.getGameId());
        System.out.println(a.getKnight().getName());*/



        URL test = new URL("http://www.dragonsofmugloar.com/api/game");

        for(int i = 0; i!=50;i++) {
            Game a0 = new ObjectMapper().readValue(test, Game.class);
            System.out.println(a0.getGameId());
            System.out.println(a0.getKnight().getName());
            Knight knight = a0.getKnight();
            System.out.println("Attack: " + knight.getAttack());
            System.out.println("Armor: " + knight.getArmor());
            System.out.println("Agiltiy: " + knight.getAgility());
            System.out.println("Endurance: " + knight.getEndurance());

            URL url = new URL("http://www.dragonsofmugloar.com/api/game/" + a0.getGameId() + "/solution");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            httpCon.setRequestProperty("Accept", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());

            BattleSolver bs = new BattleSolver();
            Dragon drag = bs.createDragon(a0);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String outjson = ow.writeValueAsString(drag);
            System.out.println(outjson);
            out.write("{\n" +
                        "    \"dragon\": \n" + outjson +
                        "    \n" +
                        "}");

            out.flush();
            out.close();
            BufferedReader br = new BufferedReader((new InputStreamReader(httpCon.getInputStream())));
            System.out.println(br.readLine());
            System.out.println("-------------------------------------------------------------------------------" + "\n");
        }
    }

}


