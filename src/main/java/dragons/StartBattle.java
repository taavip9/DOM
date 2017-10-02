package dragons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dragons.objects.Dragon;
import dragons.objects.Game;
import dragons.objects.Knight;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class StartBattle {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //Clear the detailed_result.txt file
        PrintWriter pw = new PrintWriter("detailed_result.txt");
        pw.close();
        PrintWriter fileOut = new PrintWriter(new FileOutputStream("detailed_result.txt", true));




        //User determines how many battle he/she wants to do
        System.out.println("How many battles do you wish to do?");
        Scanner input = new Scanner(System.in);
        int parseScanner = input.nextInt();
        System.out.println("Please wait...");

        URL apiURL = new URL("http://www.dragonsofmugloar.com/api/game");
        int victories = 0;
        int defeats = 0;

        //Start battle loop
        for(int i = 0; i!=parseScanner; i++) {

            //Create URL and Http connection
            Game game = new ObjectMapper().readValue(apiURL, Game.class);
            URL url = new URL("http://www.dragonsofmugloar.com/api/game/" + game.getGameId() + "/solution");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            httpCon.setRequestProperty("Accept", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());

            //Create a dragon to respond to the /api/game input
            BattleSolver bs = new BattleSolver();
            Dragon drag = bs.createDragon(game);

            //Convert the dragon to JSON syntax using ObjectMapper
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String outjson = ow.writeValueAsString(drag);

            //Send a PUT HTTP request with the dragon in it in JSON format
            out.write("{\n" +
                        "    \"dragon\": \n" + outjson +
                        "    \n" +
                        "}");
            out.close();

            //Get battle result response from the PUT request
            BufferedReader br = new BufferedReader((new InputStreamReader(httpCon.getInputStream())));
            String battleResult = br.readLine();

            //Calculate victories
            if(battleResult.contains("Victory")){
                victories++;
            } else{
                defeats++;
            }

            //Log data to detailed_results.txt file
            Knight knight = game.getKnight();
            fileOut.println("Game ID: "+game.getGameId());
            fileOut.println("Knight's name: "+knight.getName());
            fileOut.println("Attack: " + knight.getAttack());
            fileOut.println("Armor: " + knight.getArmor());
            fileOut.println("Agility: " + knight.getAgility());
            fileOut.println("Endurance: " + knight.getEndurance()+"\n");
            fileOut.println("Dragon stats:");
            if(drag!=null) {
                fileOut.println("Scale thickness: " + drag.getScaleThickness());
                fileOut.println("Claw sharpness: " + drag.getClawSharpness());
                fileOut.println("Wing strength: " + drag.getWingStrength());
                fileOut.println("Fire Breath: " + drag.getFireBreath());
            } else {
                fileOut.println("No dragon because of the storm");
            }
            fileOut.println("Battle result: "+battleResult);
            fileOut.println("----------------------------------------------------------------------------\n");

        }
        fileOut.close();
        System.out.println("Victories: "+victories);
        System.out.println("Defeats: "+defeats);
        System.out.println("A more detailed result of the fights can be seen in the detailed_result.txt file");
    }

}


