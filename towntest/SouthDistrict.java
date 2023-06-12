package towntest;

import abstractlocation.aDistrict;
import menu.Choice;

public class SouthDistrict extends aDistrict implements java.io.Serializable {

    public SouthDistrict(String name) {
        super(name);
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
        choiceHash.put(3, new Choice("Go to west district.", true));
        choiceHash.put(0, new Choice("Exit."));
    }
}
