package location;

import objects.GameObject;

import java.util.ArrayList;

public abstract class aLocation extends GameObject {

    private boolean playerHere;
    private boolean firstTimeEntered = true;
    public ArrayList<aLocation> locationArray = new ArrayList<>();

    public aLocation(String name) {
        this(name, "not set", false);
    }
    public aLocation(String name, String description) {
        this(name, description, false);
    }
    public aLocation(String name, boolean playerHere) {
        this(name, "not set", playerHere);
    }
    public aLocation(String name, String description, boolean playerHere) {
        super(name, description);
        this.playerHere = playerHere;
    }

    public boolean isPlayerHere() {
        return playerHere;
    }

    public void setPlayerHere(boolean playerHere) {
        this.playerHere = playerHere;
    }

    public boolean isFirstTimeEntered() {
        return firstTimeEntered;
    }

    public void setFirstTimeEntered(boolean firstTimeEntered) {
        this.firstTimeEntered = firstTimeEntered;
    }

    public abstract void enterLocation();
}
