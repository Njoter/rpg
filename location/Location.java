package location;

import objects.GameObject;

import java.util.ArrayList;

public class Location extends GameObject {

    private boolean firstTimeEntered = true;
    public ArrayList<Location> locationArray = new ArrayList<>();

    public Location(String name) {
        this(name, "not set");
    }
    public Location(String name, String description) {
        super(name, description);
    }

    public boolean isFirstTimeEntered() {
        return firstTimeEntered;
    }

    public void setFirstTimeEntered(boolean firstTimeEntered) {
        this.firstTimeEntered = firstTimeEntered;
    }
}
