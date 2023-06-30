package player;

import creatures.Actor;
import location.Location;

public class Player extends Actor implements java.io.Serializable {

    public Location previousLocation;
    public Location currentLocation;

    public Player(String name, String description, String race) {
        super(name, description, race);
        this.setHealthPoints(50);
        this.setStrength(29);
        this.setDexterity(14);
        this.setConstitution(10);
    }

    @Override
    public void startDialogue() {

    }
}
