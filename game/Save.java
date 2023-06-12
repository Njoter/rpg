package game;

import util.MiscUtils;
import util.PrintToConsole;
import util.PromptUserForInput;

import java.io.*;

public class Save {

    public static void saveGame() {
        // Save game state.
        MiscUtils.clearScreen();
        System.out.println("Name the savefile.");
        String savefile = PromptUserForInput.promptForString();
        try {
            FileOutputStream fosGame = new FileOutputStream( (savefile + "_game.sav") );
            ObjectOutputStream oosGame = new ObjectOutputStream(fosGame);
            oosGame.writeObject(Game.getGameWorld());
            oosGame.flush();
            oosGame.close();
        } catch (Exception e){
            System.out.println("Serialization error. Game save failed.");
            PrintToConsole.enterToContinue("ENTER to continue.");
        }
        // Save player state.
        try {
            FileOutputStream fosPlayer = new FileOutputStream( (savefile + "_player.sav") );
            ObjectOutputStream oosPlayer = new ObjectOutputStream(fosPlayer);
            oosPlayer.writeObject(Game.getPlayer());
            oosPlayer.flush();
            oosPlayer.close();
        } catch (Exception e) {
            System.out.println("Serialization error. Player save failed.");
            PrintToConsole.enterToContinue("ENTER to continue.");
        }
        System.out.println("Game saved");
        PrintToConsole.enterToContinue("ENTER to continue.");
    }
}
