import locations.aLocation;
import locations.Town;
import player.Player;

import java.util.Scanner;

import static java.lang.System.*;
import static util.MiscUtils.*;


public class Main {
    private static final Scanner input = new Scanner(in);

    public static void main(String[] args) {
        clearScreen();
        out.println("Hello! Welcome to the game! What is your name?");
        String name = input.next();
        Player.setName(name);

        String townDescription = "A small, quiet town. Some people are walking around.";
        aLocation town = new Town("Town", townDescription);
        Town.enterLocation();
    }
}
