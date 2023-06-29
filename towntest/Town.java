package towntest;

import game.Game;
import location.BuildingInterface;
import location.TownInterface;
import location.Location;
import menu.Menu;

import static towntest.TownObjects.*;
import static util.PrintToConsole.*;

public class Town extends Location implements TownInterface {

    public Town(String name) {
        super(name);
    }

    @Override
    public void enterLocation() {
        setDistrictVariables();
        setBuildingVariables();
        Game.player.currentLocation = southDistrict;
        gamePlay();
    }

    @Override
    public void gamePlay() {

        printNarrativeMessage("""
                You are entering a small town. There are two districts here, the north district and the
                south district. You enter the south district.""");

        while (true) {

            if (Game.player.currentLocation instanceof BuildingInterface) {
                Menu.buildingExteriorMenu(Game.player.currentLocation);
            } else {
                Menu.defaultLocationMenu(Game.player.currentLocation);
            }

            if (Game.player.currentLocation == northDistrict) {
                if (northDistrict.isFirstTimeEntered()) {
                    printNarrativeMessage("""
                            As you enter the north district, a shifty looking man approaches you.
                            He hands you a rolled up letter.""");
                    northDistrict.setFirstTimeEntered(false);
                }
            }
        }
    }

    @Override
    public void setDistrictVariables() {
        northDistrict.setDescription("This is the northern district.");
        southDistrict.setDescription("This is the south district.");
    }

    @Override
    public void setBuildingVariables() {
        tavern.setDescription("This is a tavern. Looks cozy.");
        weirdHouse.setDescription("This house sure is weird.");
        statelyManor.setDescription("A fancy house for fancy people.");
        blacksmith.setDescription("A blacksmith.");
        dilapidatedHouse.setDescription("This house sucks. It's just really old and stuff.");
        generalStore.setDescription("A general store. There's a sign outside that reads 'Geraldo's " +
                "General Wares'. What kind of a name is Geraldo?");
    }
}
