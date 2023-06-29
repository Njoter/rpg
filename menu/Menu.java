package menu;

import game.Game;
import game.Save;
import location.BuildingInterface;
import location.Location;
import location.Room;
import objects.GameObject;
import util.PrintToConsole;
import util.PromptUserForInput;

import static java.lang.System.out;
import static util.MiscUtils.*;
import static util.PrintToConsole.*;
import static util.PromptUserForInput.promptForInt;

public class Menu {
    public static boolean newGameMenu() {
        out.print("""
                1: Start new game.
                2: Load saved game.
                --------------------
                """);
        int choice = promptForInt();
        if (choice == 2)
            return true;
        else
            return false;
    }

    public static void buildingExteriorMenu(Location building) {
        printDescription(building);
        printBuildingExteriorMenu(building);
        printChoiceBack();

        BuildingInterface bi = (BuildingInterface) building;

        switch  (PromptUserForInput.promptForInt()) {
            case 1 -> bi.enterLocation();
            case 2 -> bi.knockOnDoor();
            case 3 -> examineMenu();
            case 4 -> actionsMenu();
            case 0 -> {
                Location previousLocation = Game.player.previousLocation;
                Game.player.previousLocation = Game.player.currentLocation;
                Game.player.currentLocation = previousLocation;
            }
        }
    }

    public static int defaultLocationMenu(Location location) {
        printDescription(location);
        printDefaultMenu();
        printChoiceBack();
        out.println();
        printChoiceCharacter();
        printChoiceInventory();
        printChoiceOptions();

        switch (PromptUserForInput.promptForInt()) {
            case 1 -> {
                goToLocation(location);
                return 1;
            }
            case 2 -> {
                examineMenu();
                return 2;
            }
            case 3 -> {
                actionsMenu();
                return 3;
            }
            case 0 -> {
                return 0;
            }
            case 98 -> {
                return 98;
            }
            case 99 -> {
                return 99;
            }
            case 90 -> {
                optionsMenu();
            }
        }
        return -1;
    }

    public static int defaultRoomMenu(Location building, Room room) {
        printDescription(room);
        printDefaultMenu();
        if (room.isExitBuilding()) {
            out.println("0: Exit " + building.getName());
        }
        out.println();
        printChoiceCharacter();
        printChoiceInventory();
        printChoiceOptions();

        switch (PromptUserForInput.promptForInt()) {
            case 1 -> goToRoom(room);
            case 2 -> examineMenu();
            case 3 -> actionsMenu();
            case 0 -> {
                Game.player.previousLocation = Game.player.currentLocation;
                Game.player.currentLocation = building;
                return 0;
            }
        }
        return -1;
    }

    private static void examineMenu() {

    }

    private static void actionsMenu() {

    }

    public static void goToLocation(Location location) {
        while (true) {
            // Print Description
            printDescription(location);
            int length = location.locationArray.get(0).getName().length();
            printCharactersNumberOfTimes('-', length);

            // Print locations
            for (int i = 0; i < location.locationArray.size(); i++) {
                out.println( (i+1) + ": " + location.locationArray.get(i).getName() + ".");
            }
            printChoiceBack();

            // Prompt user for choice
            int userChoice = PromptUserForInput.promptForInt();
            // If valid choice
            if (userChoice > 0 && userChoice <= location.locationArray.size()) {
                Location newLocation = location.locationArray.get(userChoice - 1);
                Game.player.previousLocation = location;
                Game.player.currentLocation = newLocation;
                break;
            } else if (userChoice == 0) {
                break;
            }
        }
    }

    private static void goToRoom(Location location) {
        while (true) {

            // Print Description
            printDescription(location);
            int length = location.locationArray.get(0).getName().length();
            printCharactersNumberOfTimes('-', length);

            // Print locations
            for (int i = 0; i < location.locationArray.size(); i++) {
                Room room = (Room) location.locationArray.get(i);
                if (room.getAlternativeName() != null) {
                    out.println( (i+1) + ": " + room.getAlternativeName() + ".");
                } else {
                    out.println( (i+1) + ": " + room.getName() + ".");
                }
            }
            printChoiceBack();

            // Prompt user for choice
            int userChoice = PromptUserForInput.promptForInt();
            // If valid choice
            if (userChoice > 0 && userChoice <= location.locationArray.size()) {
                Location newLocation = location.locationArray.get(userChoice - 1);
                Game.player.previousLocation = location;
                Game.player.currentLocation = newLocation;
                break;
            } else if (userChoice == 0) {
                break;
            }
        }
    }

    public static void optionsMenu() {
        while (true) {
            clearScreen();
            out.println("""
                1: Save
                0: Go back""");
            switch (promptForInt()) {
                case 1 -> Save.saveGame();
                case 0 -> {
                    return;
                }
            }
        }
    }
}
