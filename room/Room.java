package room;

public class Room implements java.io.Serializable {

    private final String name;
    private String description;
    private Boolean playerIsHere = false;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isPlayerIsHere() {
        return playerIsHere;
    }

    public void setPlayerIsHere(Boolean playerIsHere) {
        this.playerIsHere = playerIsHere;
    }
}
