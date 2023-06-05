package locations;
import static java.lang.System.*;

import building.BuildingExterior;
import util.MiscUtils;

import static util.MiscUtils.*;
import static util.PromptUserForInput.*;
import static util.PrintToConsole.*;


public class Town extends aLocation {

    private static BuildingExterior tavernExterior;
    private static BuildingExterior blacksmithExterior;
    private static TavernInterior tavernInterior;

    public Town(String name, String description) {
        super(name, description);
    }

    public static void enterLocation() {

        createBuildings();
        boolean quit = false;
        int choice;
        do {
            clearScreen();
            String[] choiceMenu = {"Tavern.", "Blacksmith.", "Quit."};
            printChoiceMenu(choiceMenu);
            choice = promptUserForInt();
            switch (choice) {
                case 0 -> quit = true;
                case 1 -> {
                    goToTavern();
                }
                case 2 -> {
                    goToBlacksmith();
                }
                default -> {
                    clearScreen();
                    out.println("Not a valid choice.");
                }
            }

        } while (!quit);
    }

    private static void goToTavern() {
        clearScreen();
        printDescription(tavernExterior.getName(), tavernExterior.getDescription());
        int choice;
        boolean goBack = false;
        while (!goBack) {
            choice = tavernExterior.menu();
            switch (choice) {
                case 0 -> goBack = true;
                case 1 -> {
                    if (tavernExterior.isLocked()) {
                        clearScreen();
                        out.println("The door is locked.");
                    } else
                        tavernInterior.enterBuilding();
                }
                case 2 -> {
                    clearScreen();
                    for (int i = 0; i < 3; i++) {
                        out.print("*knock* ");
                        MiscUtils.wait(500);
                    }
                    MiscUtils.wait(1000);
                    clearScreen();
                    out.println("No one is answering, but you can hear voices from inside.");
                }
                default -> {
                    clearScreen();
                    out.println("Not a valid choice.");
                }
            }
        }
    }

    private static void goToBlacksmith() {
        clearScreen();
        printDescription(blacksmithExterior.getName(), blacksmithExterior.getDescription());
        int choice;
        boolean goBack = false;
        while (!goBack) {
            choice = blacksmithExterior.menu();
            switch (choice) {
                case 0 -> goBack = true;
                case 1 -> {
                    if (blacksmithExterior.isLocked()) {
                        clearScreen();
                        out.println("The door seems to be locked.");
                    } else {
                        clearScreen();
                        out.println("Blacksmith interior has not been created.");
                    }
                }
                case 2 -> {
                    clearScreen();
                    out.println("You're knocking, but no one's answering.");
                }
                default -> {
                    clearScreen();
                    out.println("Not a valid choice.");
                }
            }
        }
    }

    private static void createBuildings() {
        String tavernDescription = "The tavern is an old run down building. Seems cozy enough.";
        tavernExterior = new BuildingExterior("Tavern", tavernDescription, false);
        tavernInterior = new TavernInterior("Tavern");
        String blacksmithDescription = "An old smithy. A big, beardy, burly looking guy is outside hammering " +
                "away at a sword.";
        blacksmithExterior = new BuildingExterior("Blacksmith", blacksmithDescription, true);
    }
}