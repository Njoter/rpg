package location;

public class Building extends Location implements BuildingInterface {

    protected boolean locked;

    public Building(String name) {
        super(name, "not set");
    }
    public Building(String name, boolean  locked) {
        super(name, "not set", locked);
    }

    @Override
    public void enterLocation() {

    }

    @Override
    public void gamePlay() {

    }

    @Override
    public void knockOnDoor() {

    }
}
