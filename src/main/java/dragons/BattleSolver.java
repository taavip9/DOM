package dragons;

import dragons.objects.Dragon;
import dragons.objects.Game;
import dragons.objects.Knight;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleSolver {

    public Dragon createDragon(Game game)throws ParserConfigurationException, IOException, SAXException {

        Knight knight = game.getKnight();
        int ag = knight.getAgility();
        int att = knight.getAttack();
        int arm = knight.getArmor();
        int end = knight.getEndurance();

        //Create a dragon a give knight's stats to the dragon
        Dragon dragon = new Dragon();
        dragon.setScaleThickness(att);
        dragon.setClawSharpness(arm);
        dragon.setWingStrength(ag);
        dragon.setFireBreath(end);

        //Determine the highest knight's attribute and counter it
        if ( att >= ag && att >= arm && att >= end){
            dragon.setScaleThickness(att+2);
            if(arm == 0){
                dragon.setFireBreath(end-1);
                dragon.setWingStrength(ag-1);
            }else if (ag == 0){
                dragon.setFireBreath(end-1);
                dragon.setClawSharpness(arm-1);
            }else{
                dragon.setClawSharpness(arm-1);
                dragon.setWingStrength(ag-1);
            }
        }else if ( arm >= ag && arm >= att && arm >= end){
            dragon.setClawSharpness(arm+2);
            if(att == 0){
                dragon.setFireBreath(end-1);
                dragon.setWingStrength(ag-1);
            }else if (ag == 0){
                dragon.setScaleThickness(att-1);
                dragon.setFireBreath(end-1);
            }else{
                dragon.setScaleThickness(att-1);
                dragon.setWingStrength(ag-1);
            }
        }else if ( ag >= att && ag >= arm && ag >= end){
            dragon.setWingStrength(ag+2);
            if(att == 0){
                dragon.setFireBreath(end-1);
                dragon.setClawSharpness(arm-1);
            }else if (arm == 0){
                dragon.setFireBreath(end-1);
                dragon.setScaleThickness(att-1);
            }else{
                dragon.setScaleThickness(att-1);
                dragon.setClawSharpness(arm-1);
            }
        }else if ( end >= ag && end >= arm && end >= att){
            dragon.setFireBreath(end+2);
            if(att == 0){
                dragon.setWingStrength(ag-1);
                dragon.setClawSharpness(arm-1);
            }else if (arm == 0){
                dragon.setWingStrength(ag-1);
                dragon.setScaleThickness(att-1);
            }else{
                dragon.setScaleThickness(att-1);
                dragon.setClawSharpness(arm-1);
            }
        }

        //Weather modifications
        String weather = Weather.getWeather();

        if(weather.equals("SRO")){
            dragon = null;
            return dragon;
        } else if (weather.equals("T E")){
            dragon.setScaleThickness(5);
            dragon.setClawSharpness(5);
            dragon.setWingStrength(5);
            dragon.setFireBreath(5);
            return dragon;
        } else if (weather.equals("HVA")){
            dragon.setScaleThickness(10);
            dragon.setClawSharpness(10);
            dragon.setWingStrength(0);
            dragon.setFireBreath(0);
            return dragon;
        }else{
            return dragon;
        }

    }


}
