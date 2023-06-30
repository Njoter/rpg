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
                You have traveled for quite a while and your feet are hurting by the time
                you arrive at a small sea port by the coast of Baluba Bay. This quaint, little harbor town
                is made up of two distinct districts - The north district and the south distric.
                Very creative, I know.""");

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
        northDistrict.setDescription("""
                Aaah, the northern district. Famous for it's many rats and drunken sailors roaming the streets at nigth.
                Among the houses is a tavern, a weird house and a stately manor.""");
        southDistrict.setDescription("""
                This is the south district. There are some shops here, notably a blacksmith and a general store.
                At the edge of the city you also find a dilapidated old house.""");
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
