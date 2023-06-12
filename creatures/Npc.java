package creatures;

import dialogue.Dialogue;

public class Npc implements java.io.Serializable {
    private String name;
    private String description;
    private String race;
    private Boolean firstDialogue = true;
    private Dialogue dialogue;

    public Npc(String name, String description, String race) {
        this.name = name;
        this.description = description;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Boolean getFirstDialogue() {
        return firstDialogue;
    }

    public void setFirstDialogue(Boolean firstDialogue) {
        this.firstDialogue = firstDialogue;
    }

    public Dialogue getDialogue() {
        return dialogue;
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }
}
