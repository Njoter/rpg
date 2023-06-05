package creatures;

import dialogue.DialogueMenu;
import util.PrintToConsole;
import util.PromptUserForInput;

import java.util.ArrayList;

import static java.lang.System.out;
import static util.MiscUtils.clearScreen;

public class Npc {
    private String name;
    private String description;
    private String race;
    private Boolean firstDialogue = true;

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
}
