package towntest;

import creatures.Actor;
import creatures.Barmaid;
import location.BuildingWithoutInterior;
import location.Location;
import location.Room;

public class TownObjects {

    // Districts
    protected static Location northDistrict = new Location("North district");
    protected static Location southDistrict = new Location("South district");

    // Buildings without interior
    protected static Location weirdHouse = new BuildingWithoutInterior("Weird house");
    protected static Location statelyManor = new BuildingWithoutInterior("Stately manor");
    protected static Location dilapidatedHouse = new BuildingWithoutInterior("Dilapidated house");

    // Blacksmith
    protected static Location blacksmith = new Blacksmith("Blacksmith");

    // General store
    protected static Location generalStore = new GeneralStore("Geraldo's General Wares");

    // Tavern
    protected static Location tavern = new Tavern("Tavern");
    protected static Location mainHall = new Room("Main hall", true);
    protected static Location lavatory = new Room("Lavatory", "the door on the left");
    protected static Location upstairs = new Room("Upstairs");

    // NPC's
    protected static Actor barmaid = new Barmaid("barmaid", "An elf lady.", "Human");

    public TownObjects(Location town) {
        placeLocationsInCorrectLocations(town);
        placeActorsInCorrectLocations(town);
    }

    private void placeLocationsInCorrectLocations(Location town) {

        town.locationArray.add(northDistrict);
        town.locationArray.add(southDistrict);
        northDistrict.parentLocation = town;
        southDistrict.parentLocation = town;

        northDistrict.locationArray.add(southDistrict);
        northDistrict.locationArray.add(tavern);
        northDistrict.locationArray.add(weirdHouse);
        northDistrict.locationArray.add(statelyManor);

        tavern.parentLocation = northDistrict;
        weirdHouse.parentLocation = northDistrict;
        statelyManor.parentLocation = northDistrict;

        southDistrict.locationArray.add(northDistrict);
        southDistrict.locationArray.add(blacksmith);
        southDistrict.locationArray.add(generalStore);
        southDistrict.locationArray.add(dilapidatedHouse);

        blacksmith.parentLocation = southDistrict;
        generalStore.parentLocation = southDistrict;
        dilapidatedHouse.parentLocation = southDistrict;

        tavern.locationArray.add(mainHall);
        tavern.locationArray.add(lavatory);
        tavern.locationArray.add(upstairs);
        mainHall.locationArray.add(lavatory);
        mainHall.locationArray.add(upstairs);
        lavatory.locationArray.add(mainHall);
        upstairs.locationArray.add(mainHall);

        mainHall.parentLocation = tavern;
        lavatory.parentLocation = tavern;
        upstairs.parentLocation = tavern;
    }

    private void placeActorsInCorrectLocations(Location town) {
        mainHall.actorArray.add(barmaid);
    }
}
