package abstractlocation;

import menu.Choice;
import util.MiscUtils;
import util.PrintToConsole;
import util.PromptUserForInput;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class aLocation implements java.io.Serializable {
    private String name;
    private String description;
    protected boolean playerHere;
    protected boolean firstTimeEntered = true;
    protected LinkedHashMap<Integer, Choice> choiceHash;
    protected HashMap<Integer, aLocation> buildingMap;
    protected static HashMap<Integer, aLocation> districtMap = new HashMap<>();

    public aLocation(String name) {
        this.name = name;
    }

    public aLocation(String name, boolean playerHere) {
        this.name = name;
        this.playerHere = playerHere;
    }

    public void enterLocation() {
        MiscUtils.clearScreen();
        PrintToConsole.printDescription(name, description);
        playerHere = true;
        PrintToConsole.printDefaultMenus();
        int playerInput = PromptUserForInput.promptForInt();

        if (playerInput == 1) {
            MiscUtils.clearScreen();
            PrintToConsole.printDescription(name, description);
            PrintToConsole.printLocations(districtMap);
            PrintToConsole.printChoiceBack("Go back");
            System.out.println();
            PrintToConsole.printChoiceCharacter();
            PrintToConsole.printChoiceInventory();
            PrintToConsole.printChoiceOptions();
            int hashKey = PromptUserForInput.getHashKey(districtMap);

            if (hashKey == 0) {
                return;
            }
            if (hashKey == -1) {
                return;
            }
            playerHere = false;
            districtMap.get(hashKey).playerHere = true;
        }


    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPlayerHere() {
        return playerHere;
    }
}
