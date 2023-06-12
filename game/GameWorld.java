package game;

import abstractlocation.aTown;
import towntest.TownTest;

public class GameWorld implements java.io.Serializable {

    private aTown town = new TownTest("Town", true);

    public GameWorld() {
    }

    public void enterGameWorld() {
        town.enterLocation();
    }
}
