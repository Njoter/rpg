package util;

import dialogue.DialogueMenu;

import java.util.ArrayList;
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

    public static void printChoiceMenu(String[] menuArray) {
        // Prints an amount of -'s that are equal to the length of the first line.
        for (int i = 0; i < menuArray[0].length() + 3; i++) {
            out.print("-");
        }
        out.println();
        // Print all menu strings except the last one.
        for (int i = 0; i < menuArray.length-1; i++) {
            out.println((i+1) + ": " + menuArray[i]);
        }
        // Print the last menu item with 0 prefix
        out.println("0: " + menuArray[menuArray.length-1]);
    }

    public static void printDialogueMenu(ArrayList<DialogueMenu> dialogueMenu) {
        for (int i = 0; i < dialogueMenu.get(0).getMenuString().length(); i++) {
            out.print("-");
        }
        out.println();
        for (int i = 0; i < dialogueMenu.size(); i++) {
            out.println((i+1) + ": " + dialogueMenu.get(i).getMenuString());
        }
    }
}
