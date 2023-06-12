package game;

import player.Player;
import util.PrintToConsole;
import util.PromptUserForInput;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import static java.lang.System.out;
import static menu.Menu.newGameMenu;
import static util.MiscUtils.clearScreen;

public class Game {

    //public static final MainWindow frame = new MainWindow();
    private static GameWorld gameWorld;
    public static Player player;

    public static GameWorld getGameWorld() {
        return gameWorld;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void startGame() {

        boolean loadSavedGame = newGameMenu();

        if (loadSavedGame) {
            loadGame();
        } else {
            gameWorld = new GameWorld();
            //player = characterCreationMenu();
        }

        gameWorld.enterGameWorld();
    }

    public static void loadGame() {
        clearScreen();
        out.print("Name of save file: ");
        String filename = PromptUserForInput.promptForString();

        // Load game state.
        String filenameGame = (filename + "_game.sav");
        try {
            FileInputStream fis = new FileInputStream(filenameGame);
            ObjectInputStream ois = new ObjectInputStream(fis);
            gameWorld = (GameWorld) ois.readObject();
            ois.close();
        } catch (Exception e) {
            out.println("No file named " + filenameGame);
            PrintToConsole.enterToContinue("ENTER to continue");
        }

        // Load player state.
        String filenamePlayer = (filename + "_player.sav");
        try {
            FileInputStream fis = new FileInputStream(filenamePlayer);
            ObjectInputStream ois = new ObjectInputStream(fis);
            player = (Player) ois.readObject();
            ois.close();
        } catch (Exception e) {
            out.println("No file named " + filenamePlayer);
            PrintToConsole.enterToContinue("ENTER to continue");
        }
    }
}
