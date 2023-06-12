package towntest;

import abstractlocation.aDistrict;
import abstractlocation.aLocation;
import menu.Choice;
import util.PromptUserForInput;

public class NorthDistrict extends aDistrict implements java.io.Serializable {

    private aLocation generalStore = new GeneralStore("General store");
    private aLocation blacksmith = new Blacksmith("Blacksmith");

    public NorthDistrict(String name) {
        super(name);
    }

    public NorthDistrict(String name, boolean playerHere) {
        super(name, playerHere);
    }

    @Override
    protected void gamePlay(int key) {

    }

    @Override
    protected void addBuildingsToMap() {
        buildingMap.put(5, generalStore);
        buildingMap.put(6, blacksmith);
    }

    @Override
    public void addChoices() {
        choiceHash.put(2, new Choice("east district.", true));
        choiceHash.put(3, new Choice("west district.", true));
        choiceHash.put(4, new Choice("south district.", true));
        choiceHash.put(5, new Choice("general store."));
        choiceHash.put(6, new Choice("blacksmith."));
        choiceHash.put(7, new Choice("carpenter."));
        choiceHash.put(8, new Choice("tanner."));
        choiceHash.put(9, new Choice("tavern."));
        choiceHash.put(0, new Choice("Back."));
    }
}
