package util;

import game.Game;
import location.BuildingInterface;
import location.Location;
import objects.GameObject;

import static java.lang.System.out;
import static util.MiscUtils.clearScreen;

public class PrintToConsole {

    public static void printDescription(GameObject object) {
        String name;
        if (object instanceof BuildingInterface) {
            name = object.getName() + " (exterior)";
        } else {
            name = object.getName();
        }
        clearScreen();
        out.println(name);
        for (int i = 0; i < name.length() + 1; i++) {
            out.print("-");
        }
        out.println();
        out.println(object.getDescription());
    }

    public static void printNarrativeMessage(String message) {
        MiscUtils.clearScreen();
        out.println(message);
        PromptUserForInput.enterToContinue();
    }

    public static void knockOnDoor() {
        MiscUtils.clearScreen();
        for (int i = 0; i < 3; i++) {
            System.out.print("*knock* ");
            MiscUtils.wait(500);
        }
        MiscUtils.wait(1000);
        MiscUtils.clearScreen();
    }

    public static void printBuildingExteriorMenu(Location building) {
        String name = building.getName();
        printCharactersNumberOfTimes('-', 11 + name.length());
        out.println("1: Enter " + name + ".");
        out.println("2: Knock on the door.");
        out.println("3: Examine ->");
        out.println("4: Actions ->");
    }

    public static void printDefaultMenu() {
        printCharactersNumberOfTimes('-', 14);
        out.println("1: Go to   ->");
        out.println("2: Examine ->");
        out.println("3: Actions ->");
    }


    public static void printActionsMenu() {
        clearScreen();
        printDescription(Game.player.currentLocation);
        printCharactersNumberOfTimes('-', 14);
        out.println("1: Talk to ->");
    }

    public static void printChoiceCharacter() {
        out.println("98: Character");
    }

    public static void printChoiceInventory() {
        out.println("99: Inventory");
    }

    public static void printChoiceOptions() {
        out.println("90: Options.");
    }

    public static void printChoiceBack() {
        out.println("0: Go back");
    }

    public static void printCharactersNumberOfTimes(char character, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            out.print(character);
        }
        out.println();
    }
}
