package towntest;

import game.Game;
import location.BuildingInterface;
import location.Location;
import location.Room;
import menu.Menu;
import util.PrintToConsole;
import util.PromptUserForInput;

import static towntest.TownObjects.*;

public class Tavern extends Location implements BuildingInterface {

    public Tavern(String name) {
        super(name);
    }

    @Override
    public void enterLocation() {
        setRoomVariables();
        Game.player.currentLocation = mainHall;
        gamePlay();
    }

    @Override
    public void gamePlay() {
        while (Menu.defaultRoomMenu(this, (Room)Game.player.currentLocation) != 0) {
        }
    }

    @Override
    public void setRoomVariables() {
        mainHall.setDescription("""
                This is the main hall. There are people here drinking beer, and an elf-lady
                is standing behind the bar. To the left is a door that leads to some unknown place, and a
                stairwell leads up to a dark corridor.""");
        lavatory.setDescription("""
                This is obviously the lavatory. There's a hole in the floor, and the smell
                in here is terrible.""");
        upstairs.setDescription("""
                You are standing in a dark, narrow corridor with three doors on either side.
                Probably sleeping areas.""");
    }

    @Override
    public void knockOnDoor() {
        PrintToConsole.knockOnDoor();
        System.out.println("No one is answering, but you can hear voices from inside.");
        PromptUserForInput.enterToContinue();
    }
}
