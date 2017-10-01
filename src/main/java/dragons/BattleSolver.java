package dragons;

public class BattleSolver {

    public Dragon createDragon(Game game){

        Knight knight = game.getKnight();
        int ag = knight.getAgility();
        int att = knight.getAttack();
        int arm = knight.getArmor();
        int end = knight.getEndurance();


        Dragon dragon = new Dragon();
        dragon.setClawSharpness(arm);
        dragon.setFireBreath(end-1);
        dragon.setScaleThickness(att+2);
        dragon.setWingStrength(ag-1);

        return dragon;
    }
}
