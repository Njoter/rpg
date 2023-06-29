package game;

import towntest.Town;
import towntest.TownObjects;

public class GameWorld implements java.io.Serializable {

    private Town town = new Town("Town");
    private TownObjects townObjects = new TownObjects(town);

    public GameWorld() {
    }

    public void enterGameWorld() {

        Game.player.currentLocation = town;

        setDescriptions();
        while (true) {
            town.enterLocation();
        }
    }

    private void setDescriptions() {
        town.setDescription("""
                You are standing in a quaint little town. It has a north district
                and a south district.""");
    }
}
