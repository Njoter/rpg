package util;

import abstractlocation.aLocation;
import menu.Choice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class PrintToConsole {

    public static void printDescription(String name, String description) {
        out.println(name);
        for (int i = 0; i < name.length() + 1; i++) {
            out.print("-");
        }
        out.println();
        out.println(description);
    }

    public static void printChoices(LinkedHashMap<Integer, Choice> choiceHash) {
        int firstStringLength = 0;
        for (Choice choice : choiceHash.values()) {
            firstStringLength = choice.getString().length();
            break;
        }
        printCharactersNumberOfTimes('-', firstStringLength + 3);

        int i = 1;
        for (Choice choice : choiceHash.values()) {
            if (i != choiceHash.size()) {
                out.print(i + ": ");
            } else {
                out.print(0 + ": ");
            }
            out.println(choice.getString());
            i++;
        }
    }

    public static void printLocations(HashMap<Integer, aLocation> locationMap) {
        int firstStringLength = 0;
        for (aLocation l : locationMap.values()) {
            firstStringLength = l.getName().length();
            break;
        }
        printCharactersNumberOfTimes('-', firstStringLength + 3);

        int i = 1;
        for (aLocation l : locationMap.values()) {
            out.print(i + ": ");
            out.println(l.getName());
            i++;
        }
    }

    public static void printDefaultMenus() {
        printCharactersNumberOfTimes('-', 12);
        out.println("1: Go to...");
        out.println("2: Examine...");
        out.println("3: Actions");
    }

    public static void printChoiceCharacter() {
        out.println("98: Character");
    }

    public static void printChoiceInventory() {
        out.println("99: Inventory");
    }

    public static void printChoiceOptions() {
        out.println("90: Menu.");
    }

    public static void printChoiceBack(String message) {
        out.println("0: " + message);
    }

    public static void printCharactersNumberOfTimes(char character, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            out.print(character);
        }
        out.println();
    }

    public static void enterToContinue(String message) {
        Scanner input = new Scanner(in);
        printCharactersNumberOfTimes('_', message.length());
        System.out.println(message);
        input.nextLine();
    }
}
