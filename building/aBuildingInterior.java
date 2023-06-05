package building;

public abstract class aBuildingInterior {

    private String name;
    private boolean firstTimeEntered = true;
    private boolean exit;

    public aBuildingInterior(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFirstTimeEntered() {
        return firstTimeEntered;
    }

    public void setFirstTimeEntered(boolean firstTimeEntered) {
        this.firstTimeEntered = firstTimeEntered;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public abstract void enterBuilding();
    protected abstract void createRooms();
    protected abstract void createNpcs();
}
