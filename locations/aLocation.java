package locations;

public abstract class aLocation {
    private String name;
    private String description;

    public aLocation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
