package building;

import util.PrintToConsole;

import static util.PromptUserForInput.*;

public class BuildingExterior {

    private String name;
    private String description;
    private boolean locked;

    public BuildingExterior(String name, String description, boolean locked) {
        this.name = name;
        this.description = description;
        this.locked = locked;
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

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int menu() {
        String[] choiceMenu = {("Enter " + this.name + "."), "Knock on the door.", "Go back."};
        PrintToConsole.printChoiceMenu(choiceMenu);
        return promptUserForInt();
    }
}
