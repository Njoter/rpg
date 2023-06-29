package location;

import util.MiscUtils;
import util.PrintToConsole;
import util.PromptUserForInput;

public class BuildingWithoutInterior extends Location implements BuildingInterface {

    protected boolean locked;

    public BuildingWithoutInterior(String name) {
        super(name, "not set");
    }
    public BuildingWithoutInterior(String name, boolean  locked) {
        super(name, "not set");
        this.locked = locked;
    }

    @Override
    public void enterLocation() {
        MiscUtils.clearScreen();
        System.out.println("The door is locked.");
        PromptUserForInput.enterToContinue();
    }

    @Override
    public void gamePlay() {

    }

    @Override
    public void setRoomVariables() {

    }

    @Override
    public void knockOnDoor() {
        PrintToConsole.knockOnDoor();
        System.out.println("No one is answering.");
        PromptUserForInput.enterToContinue();
    }
}
