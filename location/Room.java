package location;

public class Room extends Location {

    private String alternativeName;
    private boolean exitBuilding;

    public Room(String name) {
        super(name);
    }
    public Room(String name, String alternativeName) {
        super(name);
        this.alternativeName = alternativeName;
    }
    public Room(String name, boolean exitBuilding) {
        super(name);
        this.exitBuilding = exitBuilding;
    }
    public Room(String name, String alternativeName, boolean exitBuilding) {
        super(name);
        this.alternativeName = alternativeName;
        this.exitBuilding = exitBuilding;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public boolean isExitBuilding() {
        return exitBuilding;
    }
}
