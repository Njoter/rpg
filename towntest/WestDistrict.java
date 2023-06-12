package towntest;

import abstractlocation.aDistrict;
import menu.Choice;

public class WestDistrict extends aDistrict implements java.io.Serializable {

    public WestDistrict(String name) {
        super(name);
    }

    public WestDistrict(String name, boolean playerHere) {
        super(name, playerHere);
    }

    @Override
    protected void gamePlay(int key) {

    }

    @Override
    protected void addBuildingsToMap() {

    }

    @Override
    public void addChoices() {
        choiceHash.put(1, new Choice("Go to north district.", true));
        choiceHash.put(2, new Choice("Go to east district.", true));
        choiceHash.put(4, new Choice("Go to south district.", true));
        choiceHash.put(0, new Choice("Exit."));
    }
}
