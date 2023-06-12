package menu;

import game.Save;
import player.Player;
import util.MiscUtils;
import util.PrintToConsole;
import util.PromptUserForInput;

import static java.lang.System.out;
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

    public static Player characterCreationMenu() {
        MiscUtils.clearScreen();
        out.println("What is your name?");
        String name = PromptUserForInput.promptForString();
        out.println("How many health points do you have?");
        int healthpoints = promptForInt();
        out.println("How many coppers do you have?");
        int coppers = promptForInt();
        Player player = new Player(name, healthpoints, coppers);
        return player;
    }

    public static void optionsMenu() {
        MiscUtils.clearScreen();
        out.println("""
                1: Character
                2: Save
                0: Go back
                """);
        switch (promptForInt()) {
            case 1 -> Player.printCharacter();
            case 2 -> Save.saveGame();
        }
    }
}
